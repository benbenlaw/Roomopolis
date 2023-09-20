package com.benbenlaw.item.custom;

import com.benbenlaw.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Arrays;

public class AdvancedKeyItem extends Item {
    public AdvancedKeyItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {

        Level level = pContext.getLevel();
        Player player = pContext.getPlayer();
        BlockPos blockPos = pContext.getClickedPos();
        BlockState blockState = pContext.getLevel().getBlockState(blockPos);
        assert player != null;
        Direction direction = pContext.getClickedFace();

        Direction facingDirection = direction.getOpposite(); // Assuming direction is where the box should be placed
        BlockPos frontPos = blockPos.relative(facingDirection, 3); // Adjust the distance as needed
        int range = 3; // Half of the desired box size (5x5x5)

// Define the coordinates for the center of each wall
        int[] wallCoordinates = new int[] { range, -range, range, -range };

        for (int x = -range; x <= range; x++) {
            for (int y = -range; y <= range; y++) {
                for (int z = -range; z <= range; z++) {
                    BlockPos boxPos = frontPos.offset(x, y, z);

                    // Check if the current position is on the outer shell of the box
                    if (Math.abs(x) == range || Math.abs(y) == range || Math.abs(z) == range) {
                        // Check if the current position is not on a corner
                        if (!(Math.abs(x) == range && Math.abs(y) == range && Math.abs(z) == range)) {
                            // Check if the current position is not in the direction that was clicked
                            if (!(facingDirection == Direction.DOWN && y == range)
                                    && !(facingDirection == Direction.UP && y == -range)
                                    && !(facingDirection == Direction.NORTH && z == range)
                                    && !(facingDirection == Direction.SOUTH && z == -range)
                                    && !(facingDirection == Direction.WEST && x == range)
                                    && !(facingDirection == Direction.EAST && x == -range)) {
                                // Check if the current position is one of the center wall coordinates
                                if (Arrays.binarySearch(wallCoordinates, x) >= 0
                                        || Arrays.binarySearch(wallCoordinates, y) >= 0
                                        || Arrays.binarySearch(wallCoordinates, z) >= 0) {
                                    // Place key block in the center of the walls
                                    level.setBlockAndUpdate(boxPos, ModBlocks.ADVANCED_ROOM_KEY_BLOCK.get().defaultBlockState());
                                } else {
                                    // Place room blocks for the rest of the outer shell
                                    level.setBlockAndUpdate(boxPos, ModBlocks.BASIC_ROOM_BLOCK.get().defaultBlockState());
                                }
                            } else {
                                // Place room blocks in the corners
                                level.setBlockAndUpdate(boxPos, ModBlocks.BASIC_ROOM_BLOCK.get().defaultBlockState());
                            }
                        }
                    }
                }
            }
        }



        if (blockState.is(ModBlocks.ADVANCED_ROOM_KEY_BLOCK.get()) && !level.isClientSide) {
            if (direction == Direction.DOWN || direction == Direction.UP) {
                for (int xOffset = -2; xOffset <= 2; xOffset++) {
                    for (int zOffset = -2; zOffset <= 2; zOffset++) {
                        BlockPos targetPos = blockPos.offset(xOffset, 0, zOffset);
                        BlockState targetBlockState = level.getBlockState(targetPos);
                        if (targetBlockState.is(ModBlocks.BASIC_ROOM_BLOCK.get()) || targetBlockState.is(ModBlocks.ADVANCED_ROOM_KEY_BLOCK.get())) {
                            level.setBlockAndUpdate(targetPos, Blocks.AIR.defaultBlockState());
                        }
                    }
                }
            }

            if (direction == Direction.NORTH || direction == Direction.SOUTH) {
                for (int xOffset = -2; xOffset <= 2; xOffset++) {
                    for (int yOffset = -2; yOffset <= 2; yOffset++) {
                        BlockPos targetPos = blockPos.offset(xOffset, yOffset, 0);
                        BlockState targetBlockState = level.getBlockState(targetPos);
                        if (targetBlockState.is(ModBlocks.BASIC_ROOM_BLOCK.get()) || targetBlockState.is(ModBlocks.ADVANCED_ROOM_KEY_BLOCK.get())) {
                            level.setBlockAndUpdate(targetPos, Blocks.AIR.defaultBlockState());
                        }
                    }
                }
            }

            if (direction == Direction.EAST || direction == Direction.WEST) {
                for (int yOffset = -2; yOffset <= 2; yOffset++) {
                    for (int zOffset = -2; zOffset <= 2; zOffset++) {
                        BlockPos targetPos = blockPos.offset(0, yOffset, zOffset);
                        BlockState targetBlockState = level.getBlockState(targetPos);
                        if (targetBlockState.is(ModBlocks.BASIC_ROOM_BLOCK.get()) || targetBlockState.is(ModBlocks.ADVANCED_ROOM_KEY_BLOCK.get())) {
                            level.setBlockAndUpdate(targetPos, Blocks.AIR.defaultBlockState());
                        }
                    }
                }
            }
        }


        return InteractionResult.SUCCESS;
    }
}
