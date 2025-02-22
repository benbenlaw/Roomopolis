package com.benbenlaw.roomopolis.item;

import com.benbenlaw.core.item.TooltipUtil;
import com.benbenlaw.core.util.DirectionUtil;
import com.benbenlaw.roomopolis.block.RoomopolisBlocks;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class KeyItem extends Item {

    public ResourceLocation templateId;
    public int heightAdjustment;
    public Block keyBlock;
    public boolean isPlaced;
    Vec3i templateSize;
    public KeyItem(Properties properties, String templateId, int heightAdjustment) {
        super(properties);
        this.templateId = ResourceLocation.parse(templateId);
        this.heightAdjustment = heightAdjustment;
    }

    public KeyItem(String templateId, int heightAdjustment) {
        super(new Item.Properties());
        this.templateId = ResourceLocation.parse(templateId);
        this.heightAdjustment = heightAdjustment;
    }

    public KeyItem(Properties properties, String templateId, int heightAdjustment, String keyBlock) {
        super(properties);
        this.templateId = ResourceLocation.parse(templateId);
        this.heightAdjustment = heightAdjustment;
        this.keyBlock = BuiltInRegistries.BLOCK.get(ResourceLocation.parse(keyBlock));
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Player player = context.getPlayer();
        BlockPos pos = context.getClickedPos();
        BlockState state = level.getBlockState(pos);
        Rotation rotation = DirectionUtil.getRotationFromDirection(context.getClickedFace());
        Direction facing = context.getHorizontalDirection();

        if (!level.isClientSide()) {

            if (keyBlock != null) {
                if (state.is(keyBlock)) {
                    createTemplate(level, rotation, facing, pos);
                    assert player != null;
                    if (isPlaced) {
                        player.sendSystemMessage(Component.translatable("item.key.placed").withStyle(ChatFormatting.GREEN));
                        level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
                        level.setBlockAndUpdate(pos.below(), Blocks.AIR.defaultBlockState());
                        level.sendBlockUpdated(pos, level.getBlockState(pos), level.getBlockState(pos), Block.UPDATE_ALL);
                        level.sendBlockUpdated(pos.below(), level.getBlockState(pos.below()), level.getBlockState(pos.below()), Block.UPDATE_ALL);
                    } else {
                        player.sendSystemMessage(Component.translatable("item.key.area_not_empty").withStyle(ChatFormatting.RED));
                    }
                } else {
                    assert player != null;
                    player.sendSystemMessage(Component.translatable("item.key.requires_key_block", keyBlock.getName()).withStyle(ChatFormatting.RED));
                }
            }

            else {
                createTemplate(level, rotation, facing, pos);
                assert player != null;
                if (isPlaced) {
                    player.sendSystemMessage(Component.translatable("item.key.placed").withStyle(ChatFormatting.GREEN));
                } else {
                    player.sendSystemMessage(Component.translatable("item.key.area_not_empty").withStyle(ChatFormatting.RED));
                }
            }
        }

        isPlaced = false;
        return super.useOn(context);
    }

    public void createTemplate(Level level, Rotation rotation, Direction facing, BlockPos pos) {
        StructureTemplateManager structureManager = Objects.requireNonNull(level.getServer()).getStructureManager();
        Optional<StructureTemplate> optionalTemplate = structureManager.get(templateId);

        StructurePlaceSettings placementSettings = new StructurePlaceSettings()
                .setRotation(rotation)
                .setMirror(Mirror.NONE)
                .setIgnoreEntities(false);

        if (optionalTemplate.isPresent()) {
            // Template Information
            StructureTemplate template = optionalTemplate.get();
            templateSize = template.getSize();

            // Position Adjustments to make the template spawn a block in front of the player and adjust the height of the template
            BlockPos centerOffset = new BlockPos(-templateSize.getX() / 2, -templateSize.getY() / 2, -templateSize.getZ() / 2);
            BlockPos adjustedOffset = StructureTemplate.calculateRelativePosition(placementSettings, centerOffset);
            int forwardShift = (rotation == Rotation.NONE || rotation == Rotation.CLOCKWISE_180) ? templateSize.getZ() / 2 + 1 : templateSize.getX() / 2 + 1;
            BlockPos forwardOffset = pos.relative(facing, forwardShift);
            BlockPos placementPos = forwardOffset.offset(adjustedOffset);
            placementPos = placementPos.above(heightAdjustment);

            // Check if the location is empty (all air blocks)
            boolean isEmpty = true;
            for (int x = 0; x < templateSize.getX(); x++) {
                for (int y = 0; y < templateSize.getY(); y++) {
                    for (int z = 0; z < templateSize.getZ(); z++) {
                        BlockPos relPos = new BlockPos(x, y, z);
                        BlockPos rotatedPos = StructureTemplate.calculateRelativePosition(placementSettings, relPos);
                        BlockPos worldPos = placementPos.offset(rotatedPos);

                        // Check if the block at the world position is not air
                        if (!level.getBlockState(worldPos).isAir()) {
                            isEmpty = false;
                            break;
                        }
                    }
                    if (!isEmpty) {
                        break;
                    }
                }
                if (!isEmpty) {
                    break;
                }
            }

            if (isEmpty) {
                // Place the template if the location is empty
                template.placeInWorld((ServerLevelAccessor) level, placementPos, placementPos, placementSettings, level.getRandom(), Block.UPDATE_ALL);
                isPlaced = true;

                // Update all placed blocks
                for (int x = 0; x < templateSize.getX(); x++) {
                    for (int y = 0; y < templateSize.getY(); y++) {
                        for (int z = 0; z < templateSize.getZ(); z++) {
                            BlockPos relPos = new BlockPos(x, y, z);
                            BlockPos rotatedPos = StructureTemplate.calculateRelativePosition(placementSettings, relPos);
                            BlockPos worldPos = placementPos.offset(rotatedPos);

                            level.sendBlockUpdated(worldPos, level.getBlockState(worldPos), level.getBlockState(worldPos), Block.UPDATE_ALL);
                        }
                    }
                }
            } else {
                System.out.println("Target location is not empty. Structure placement aborted.");
            }

        } else {
            System.out.println("Structure not found: " + templateId);
        }
    }


    @Override
    public void inventoryTick(@NotNull ItemStack stack, @NotNull Level level, Entity entity, int p_41407_, boolean p_41408_) {
        if (templateSize == null && !level.isClientSide()) {
            StructureTemplateManager structureManager = Objects.requireNonNull(level.getServer()).getStructureManager();
            Optional<StructureTemplate> optionalTemplate = structureManager.get(templateId);

            if (optionalTemplate.isPresent()) {
                StructureTemplate template = optionalTemplate.get();
                templateSize = template.getSize();
            }
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {

        //Size Information
        if (templateSize != null) {
            int templateWidth = templateSize.getX();
            int templateHeight = templateSize.getY();
            int templateLength = templateSize.getZ();
            Component templateSize = Component.translatable("tooltips.key.template_size", templateWidth, templateHeight, templateLength).withStyle(ChatFormatting.GRAY);
            tooltipComponents.add(templateSize);
        }
        //Key Block Information
        if (keyBlock != null) {
            tooltipComponents.add(Component.translatable("tooltips.key.requires_key_block", keyBlock.getName()).withStyle(ChatFormatting.RED));
        }
    }
}
