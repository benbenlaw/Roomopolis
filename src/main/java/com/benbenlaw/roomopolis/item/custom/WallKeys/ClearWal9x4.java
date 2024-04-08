package com.benbenlaw.roomopolis.item.custom.WallKeys;

import com.benbenlaw.roomopolis.block.ModBlocks;
import com.benbenlaw.roomopolis.multiblock.rooms.Clear;
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
import net.minecraft.world.level.block.Rotation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mangorage.mangomultiblock.core.misc.Util;

import java.util.List;

public class ClearWal9x4 extends Item {
    public ClearWal9x4(Properties pProperties) {
        super(pProperties);
    }

    public @NotNull InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        BlockPos blockPos = pContext.getClickedPos();
        Player player = pContext.getPlayer();
        ItemStack stack = pContext.getItemInHand();

        assert player != null;
        if (!level.isClientSide) {

            if (level.getBlockState(blockPos).is(ModBlocks.BASIC_ROOM_KEY_BLOCK.get())) {

                BlockPos adjustmentHeightPos = blockPos.below();
                Direction direction = pContext.getClickedFace();
                Rotation rotation = Util.DirectionToRotation(direction);

                switch (direction) {
                    case NORTH -> Clear.CLEAR_9x4.construct(level, adjustmentHeightPos.above(), rotation);
                    case SOUTH -> Clear.CLEAR_9x4.construct(level, adjustmentHeightPos.above(), rotation);
                    case WEST -> Clear.CLEAR_9x4.construct(level, adjustmentHeightPos.above(), rotation);
                    case EAST -> Clear.CLEAR_9x4.construct(level, adjustmentHeightPos.above(), rotation);
                }

                if (direction == Direction.SOUTH || direction == Direction.EAST || direction == Direction.WEST || direction == Direction.NORTH) {
                    player.sendSystemMessage(Component.literal("Placing Corridor and Clearing Wall (9x4)").withStyle(ChatFormatting.GREEN));
                    shrinkItem(player, stack);
                }

                else {
                    player.sendSystemMessage(Component.literal("Cannot use on the top or bottom!").withStyle(ChatFormatting.RED));

                }

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
            components.add(Component.literal("Can be used on the sides of Key Blocks to clear a wall.").withStyle(ChatFormatting.GREEN));
        }
        if (Screen.hasControlDown()) {
            components.add(Component.literal("Length x Width x Height.").withStyle(ChatFormatting.GREEN));
            components.add(Component.literal("1x7x4 internal room size.").withStyle(ChatFormatting.GREEN));

        } else {
            components.add(Component.literal("Hold SHIFT for more information").withStyle(ChatFormatting.BLUE));
            components.add(Component.literal("Hold CTRL for removal size").withStyle(ChatFormatting.BLUE));
        }
    }


    private void shrinkItem(Player player, ItemStack stack) {

        if (!player.isCreative()) {
            stack.shrink(1);
        }
    }
}
