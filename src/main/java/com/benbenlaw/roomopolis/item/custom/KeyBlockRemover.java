package com.benbenlaw.roomopolis.item.custom;

import com.benbenlaw.roomopolis.block.ModBlocks;
import com.benbenlaw.roomopolis.multiblock.rooms.Corridors;
import com.benbenlaw.roomopolis.util.ModTags;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.level.NoteBlockEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mangorage.mangomultiblock.core.misc.Util;

import java.util.List;

import static net.minecraft.world.ContainerHelper.removeItem;

public class KeyBlockRemover extends Item {
    public KeyBlockRemover(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {

        Level level = context.getLevel();
        Player player = context.getPlayer();
        BlockPos blockPos = context.getClickedPos();
        Direction direction = context.getClickedFace();
        ItemStack stack = context.getItemInHand();

        if (!level.isClientSide()) {

            BlockPos leftPos = null;
            BlockPos rightPos = null;

            switch (direction) {
                case NORTH:
                    leftPos = blockPos.west();
                    rightPos = blockPos.east();
                    break;
                case SOUTH:
                    leftPos = blockPos.east();
                    rightPos = blockPos.west();
                    break;
                case WEST:
                    leftPos = blockPos.south();
                    rightPos = blockPos.north();
                    break;
                case EAST:
                    leftPos = blockPos.north();
                    rightPos = blockPos.south();
                    break;

                case UP:
                    leftPos = blockPos.above();
                    rightPos = blockPos.below();
                    break;
                case DOWN:
                    leftPos = blockPos.below();
                    rightPos = blockPos.above();
                    break;
            }

            BlockPos abovePos = blockPos.above();
            BlockPos belowPos = blockPos.below();

            assert player != null;
            if (level.getBlockState(blockPos).is(ModBlocks.BASIC_ROOM_KEY_BLOCK.get())) {
                Block sameBlockSides = level.getBlockState(abovePos).getBlock();
                Block sameBlockUp = level.getBlockState(blockPos.west()).getBlock();

                if (sameBlockSides != Blocks.AIR) {
                    if (level.getBlockState(belowPos).is(sameBlockSides) && level.getBlockState(leftPos).is(sameBlockSides) && level.getBlockState(rightPos).is(sameBlockSides)) {
                        String translatedName = sameBlockSides.getName().getString();
                        level.setBlockAndUpdate(blockPos, sameBlockSides.defaultBlockState());
                        player.sendSystemMessage(Component.literal("Removing Key Block and replacing smartly with " + translatedName).withStyle(ChatFormatting.GREEN));
                        shrinkItem(player, stack);
                    }
                }

                else if (sameBlockUp != Blocks.AIR) {
                    if (level.getBlockState(blockPos.east()).is(sameBlockUp) && level.getBlockState(blockPos.north()).is(sameBlockUp) && level.getBlockState(blockPos.south()).is(sameBlockUp)) {
                        String translatedName = sameBlockUp.getName().getString();
                        level.setBlockAndUpdate(blockPos, sameBlockUp.defaultBlockState());
                        player.sendSystemMessage(Component.literal("Removing Key Block and replacing smartly with " + translatedName).withStyle(ChatFormatting.GREEN));
                        shrinkItem(player, stack);
                    }
                }

                else {
                    level.setBlockAndUpdate(blockPos, Blocks.AIR.defaultBlockState());
                    player.sendSystemMessage(Component.literal("Removing Key Block").withStyle(ChatFormatting.GREEN));
                    shrinkItem(player, stack);
                }

            }

            else {
                player.sendSystemMessage(Component.literal("Right Click on a Key Block to remove! This cannot be undone!").withStyle(ChatFormatting.RED));
            }
        }
        return super.useOn(context);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        if(Screen.hasShiftDown()) {
            components.add(Component.literal("Can be used to remove a key block! Will replace with the most common block found within its range or with air.").withStyle(ChatFormatting.GREEN));
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


