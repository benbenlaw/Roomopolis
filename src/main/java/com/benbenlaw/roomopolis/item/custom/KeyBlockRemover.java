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
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.Tags;
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

        boolean blocksMatch = false;

        if (!level.isClientSide()) {

            BlockPos leftPos = null;
            BlockPos rightPos = null;
            BlockPos upPos = null;
            BlockPos downPos = null;

            switch (direction) {
                case NORTH, SOUTH:
                    leftPos = blockPos.west();
                    rightPos = blockPos.east();
                    upPos = blockPos.above();
                    downPos = blockPos.below();
                    break;
                case WEST, EAST:
                    leftPos = blockPos.north();
                    rightPos = blockPos.south();
                    upPos = blockPos.above();
                    downPos = blockPos.below();
                    break;

                case UP, DOWN:
                    leftPos = blockPos.north();
                    rightPos = blockPos.south();
                    upPos = blockPos.east();
                    downPos = blockPos.west();
            }

            BlockState leftBlock = level.getBlockState(leftPos);
            BlockState rightBlock = level.getBlockState(rightPos);
            BlockState upBlock = level.getBlockState(upPos);
            BlockState downBlock = level.getBlockState(downPos);

            if (leftBlock == rightBlock && upBlock == downBlock && leftBlock == upBlock) {
                if (leftBlock != Blocks.AIR.defaultBlockState()) {
                    blocksMatch = true;
                }
            }

            assert player != null;

            if (level.getBlockState(blockPos).is(ModBlocks.BASIC_ROOM_KEY_BLOCK.get())) {

                if (blocksMatch) {
                    BlockState keyBlock = leftBlock;
                    if (keyBlock.is(ModTags.Blocks.KEY_BLOCK_SMART_BLOCKS)) {
                        level.setBlockAndUpdate(blockPos, keyBlock);
                        player.sendSystemMessage(Component.literal("Removing Key Block and replacing smartly with " + keyBlock.getBlock().getName().getString()).withStyle(ChatFormatting.GREEN));
                        shrinkItem(player, stack);
                    }
                } else {
                    level.setBlockAndUpdate(blockPos, Blocks.AIR.defaultBlockState());
                    player.sendSystemMessage(Component.literal("Removing Key Block").withStyle(ChatFormatting.GREEN));
                    shrinkItem(player, stack);
                }
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


