package com.benbenlaw.roomopolis.block.custom;

import net.minecraft.world.level.block.Block;

public class RoomKeyBlock extends RoomBlock {
    public RoomKeyBlock(Properties properties) {
        super(properties.strength(-1.0F, 3600000.0F));
    }

}
