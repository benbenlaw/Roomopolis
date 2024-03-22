package com.benbenlaw.roomopolis.item.custom.ElementalKeys;

import com.benbenlaw.roomopolis.block.ModBlocks;
import com.benbenlaw.roomopolis.config.RoomopolisConfigFile;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

public class WaterKey extends Item {
    public WaterKey(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public boolean isFoil(ItemStack p_41453_) {
        return true;
    }

    public @NotNull InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        BlockPos blockPos = pContext.getClickedPos();
        Player player = pContext.getPlayer();
        ItemStack stack = pContext.getItemInHand();

        assert player != null;
        if (!level.isClientSide) {

            if (level.getBlockState(blockPos).is(ModBlocks.ELITE_ROOM_KEY_BLOCK.get())) {

                int lowerY = blockPos.below(7).getY();
                int upperY = blockPos.above(5).getY();
                BlockPos northEast = blockPos.north(4).east(4);
                BlockPos southWest = blockPos.south(4).west(4);

                BlockPos cornerTop = new BlockPos(northEast.getX(), upperY, northEast.getZ());
                BlockPos cornerBottom = new BlockPos(southWest.getX(), lowerY, southWest.getZ());

                for (BlockPos pos : BlockPos.betweenClosed(cornerBottom, cornerTop)) {
                    BlockState state = level.getBlockState(pos);

                    BlockState oldStone = Objects.requireNonNull(ForgeRegistries.BLOCKS.getValue(new ResourceLocation("caveopolis:gray_colored_stone"))).defaultBlockState();
                    BlockState newStone = Objects.requireNonNull(ForgeRegistries.BLOCKS.getValue(new ResourceLocation("caveopolis:blue_colored_stone"))).withPropertiesOf(state);

                    BlockState oldLog = Objects.requireNonNull(ForgeRegistries.BLOCKS.getValue(new ResourceLocation("caveopolis:stripped_gray_colored_log"))).defaultBlockState();
                    BlockState newLog = Objects.requireNonNull(ForgeRegistries.BLOCKS.getValue(new ResourceLocation("caveopolis:stripped_blue_colored_log"))).withPropertiesOf(state);

                    BlockState oldPlank = Objects.requireNonNull(ForgeRegistries.BLOCKS.getValue(new ResourceLocation("caveopolis:light_gray_colored_wooden_planks"))).defaultBlockState();
                    BlockState newPlank = Objects.requireNonNull(ForgeRegistries.BLOCKS.getValue(new ResourceLocation("caveopolis:blue_colored_wooden_planks"))).withPropertiesOf(state);

                    BlockState oldFence = Objects.requireNonNull(ForgeRegistries.BLOCKS.getValue(new ResourceLocation("caveopolis:light_gray_colored_wooden_plank_fence"))).defaultBlockState();
                    BlockState newFence = Objects.requireNonNull(ForgeRegistries.BLOCKS.getValue(new ResourceLocation("caveopolis:blue_colored_wooden_plank_fence"))).withPropertiesOf(state);

                    BlockState oldBrick = Objects.requireNonNull(ForgeRegistries.BLOCKS.getValue(new ResourceLocation("caveopolis:gray_colored_stone_bricks"))).defaultBlockState();
                    BlockState newBrick = Objects.requireNonNull(ForgeRegistries.BLOCKS.getValue(new ResourceLocation("caveopolis:blue_colored_stone_bricks"))).withPropertiesOf(state);

                    BlockState oldSlab = Objects.requireNonNull(ForgeRegistries.BLOCKS.getValue(new ResourceLocation("caveopolis:gray_colored_stone_brick_slab"))).defaultBlockState();
                    BlockState newSlab = Objects.requireNonNull(ForgeRegistries.BLOCKS.getValue(new ResourceLocation("caveopolis:blue_colored_stone_brick_slab"))).withPropertiesOf(state);

                    BlockState oldKey = ModBlocks.ELITE_ROOM_KEY_BLOCK.get().defaultBlockState();
                    BlockState newKey = Objects.requireNonNull(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(RoomopolisConfigFile.waterShrineTreasureBlock.get()))).defaultBlockState();

                    if (state.getBlock() == oldStone.getBlock()) {
                        level.setBlockAndUpdate(pos, newStone);
                        level.sendBlockUpdated(pos, state, newStone, 3);
                    }
                    if (state.getBlock() == oldLog.getBlock()) {
                        level.setBlockAndUpdate(pos, newLog);
                        level.sendBlockUpdated(pos, state, newLog, 3);
                    }
                    if (state.getBlock() == oldPlank.getBlock()) {
                        level.setBlockAndUpdate(pos, newPlank);
                        level.sendBlockUpdated(pos, state, newPlank, 3);
                    }
                    if (state.getBlock() == oldFence.getBlock()) {
                        level.setBlockAndUpdate(pos, newFence);
                        level.sendBlockUpdated(pos, state, newFence, 3);
                    }
                    if (state.getBlock() == oldBrick.getBlock()) {
                        level.setBlockAndUpdate(pos, newBrick);
                        level.sendBlockUpdated(pos, state, newBrick, 3);
                    }
                    if (state.getBlock() == oldSlab.getBlock()) {
                        level.setBlockAndUpdate(pos, newSlab);
                        level.sendBlockUpdated(pos, state, newSlab, 3);
                    }
                    if (state.getBlock() == oldKey.getBlock()) {
                        level.setBlockAndUpdate(pos, newKey);
                        level.sendBlockUpdated(pos, state, newKey, 3);
                    }

                    shrinkItem(player, stack);



                }


                player.sendSystemMessage(Component.literal("ACTIVATING WATER SHRINE").withStyle(ChatFormatting.GREEN));

                return super.useOn(pContext);
            }

            else {
                player.sendSystemMessage(Component.literal("No room key block found!").withStyle(ChatFormatting.RED));
            }
        }

        return super.useOn(pContext);

    }


    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        if(Screen.hasShiftDown()) {
            components.add(Component.literal("Can be used on the sides of Key Blocks to create a small (3x3x5) internal corridor.").withStyle(ChatFormatting.GREEN));
        }
        else {
            components.add(Component.literal("Hold SHIFT for more information").withStyle(ChatFormatting.BLUE));
        }
    }


    private void shrinkItem(Player player, ItemStack stack) {

        if (!player.isCreative()) {
            stack.shrink(1);
        }
    }
}
