package com.benbenlaw.roomopolis.block.custom;

import net.minecraft.world.level.block.Block;

public class RoomBlock extends Block {
    public RoomBlock(Properties properties) {
        super(properties.strength(-1.0F, 3600000.0F));
    }
}
