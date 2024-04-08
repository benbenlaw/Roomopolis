package com.benbenlaw.roomopolis.item.custom.RoomKeys;

import com.benbenlaw.roomopolis.block.ModBlocks;
import com.benbenlaw.roomopolis.config.RoomopolisConfigFile;
import com.benbenlaw.roomopolis.multiblock.rooms.Clear;
import com.benbenlaw.roomopolis.multiblock.rooms.Rooms;
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

public class EnderPortalRoomKey extends Item {
    public EnderPortalRoomKey(Properties pProperties) {
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
                    case UP -> Rooms.SHORT_ROOM.construct(level, adjustmentHeightPos.below(3), rotation);
                    case DOWN -> Rooms.SHORT_ROOM.construct(level, adjustmentHeightPos.above(2), rotation);
                    case NORTH -> Rooms.SHORT_ROOM.construct(level, adjustmentHeightPos.south(5), rotation);
                    case SOUTH -> Rooms.SHORT_ROOM.construct(level, adjustmentHeightPos.north(5), rotation);
                    case WEST -> Rooms.SHORT_ROOM.construct(level, adjustmentHeightPos.east(5), rotation);
                    case EAST -> Rooms.SHORT_ROOM.construct(level, adjustmentHeightPos.west(5), rotation);
                }

                if (direction == Direction.SOUTH || direction == Direction.EAST || direction == Direction.WEST || direction == Direction.NORTH) {
                    Clear.CLEAR_3x3.construct(level, adjustmentHeightPos.above(), rotation);
                    player.sendSystemMessage(Component.literal("Placing Short Room and Clearing Wall (9x4)").withStyle(ChatFormatting.GREEN));
                    shrinkItem(player, stack);
                }
                if (direction == Direction.DOWN) {
                    Clear.CLEAR_9x9_UP.construct(level, adjustmentHeightPos.above(), rotation);
                    player.sendSystemMessage(Component.literal("Placing Additional Room Layer and Clearing Floor/Roof (3x3)").withStyle(ChatFormatting.GREEN));
                    shrinkItem(player, stack);
                }
                if (direction == Direction.UP && blockPos.getY() > RoomopolisConfigFile.roomPlacementLowestBlockY.get()) {
                    Clear.CLEAR_9x9_UP.construct(level, adjustmentHeightPos.above(), rotation);
                    player.sendSystemMessage(Component.literal("Placing Additional Room Layer and Clearing Floor/Roof (3x3)").withStyle(ChatFormatting.GREEN));
                    shrinkItem(player, stack);
                }
                if (direction == Direction.UP && blockPos.getY() < RoomopolisConfigFile.roomPlacementLowestBlockY.get()) {
                    player.sendSystemMessage(Component.literal("Cannot Place any lower!").withStyle(ChatFormatting.GREEN));

                }


                return super.useOn(pContext);
            }

            else {
                assert player != null;
                player.sendSystemMessage(Component.literal("No room key block found!").withStyle(ChatFormatting.RED));
            }

        }

        return super.useOn(pContext);
    }


    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        if(Screen.hasShiftDown()) {
            components.add(Component.literal("Can be used on the sides of Key Blocks to create a Short Room.").withStyle(ChatFormatting.GREEN));
            components.add(Component.literal("Can be used on the top/bottom of Key Blocks to create a Short Room above/below.").withStyle(ChatFormatting.GREEN));
        }

        if (Screen.hasControlDown()) {
                components.add(Component.literal("Length x Width x Height.").withStyle(ChatFormatting.GREEN));
                components.add(Component.literal("9x9x4 internal room size.").withStyle(ChatFormatting.GREEN));

        } else {
            components.add(Component.literal("Hold SHIFT for more information").withStyle(ChatFormatting.BLUE));
            components.add(Component.literal("Hold CTRL for room size").withStyle(ChatFormatting.BLUE));
        }


    }

    private void shrinkItem(Player player, ItemStack stack) {

        if (!player.isCreative()) {
            stack.shrink(1);
        }
    }
}
