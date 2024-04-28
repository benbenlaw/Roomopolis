package com.benbenlaw.roomopolis.multiblock.rooms;

import com.benbenlaw.roomopolis.block.ModBlocks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.ForgeRegistries;
import org.mangorage.mangomultiblock.core.SimpleMultiBlockAislePatternBuilder;
import org.mangorage.mangomultiblock.core.impl.IMultiBlockPattern;
import org.mangorage.mangomultiblock.core.manager.MultiBlockManager;

public class Clear {
    public static final MultiBlockManager MANAGER = MultiBlockManager.getOrCreate("mangomultiblock", "roomopolis");

    public static final IMultiBlockPattern CLEAR_7x4;
    public static final IMultiBlockPattern CLEAR_9x4;
    public static final IMultiBlockPattern CLEAR_9x14;
    public static final IMultiBlockPattern CLEAR_3x3;
    public static final IMultiBlockPattern CLEAR_9x9;
    public static final IMultiBlockPattern CLEAR_9x9_UP;
    public static final IMultiBlockPattern CLEAR_3x3_UP;

    public Clear() {
    }

    private static final Block air = Blocks.AIR;


    static {

        SimpleMultiBlockAislePatternBuilder pattern = SimpleMultiBlockAislePatternBuilder.start()
                .aisle(" ", " ", " ", " ", " ", " ", " ")
                .aisle(" ", " ", " ", " ", " ", " ", " ")
                .aisle(" ", " ", " ", "*", " ", " ", " ")
                .aisle(" ", " ", " ", " ", " ", " ", " ")
                .where('*', a -> a.getState().is(air))
                .where(' ', a -> a.getState().is(air)
                );
        pattern.block('*', air::defaultBlockState);
        pattern.block(' ', air::defaultBlockState);

        CLEAR_7x4 = pattern.build();
    }

    static {

        SimpleMultiBlockAislePatternBuilder pattern = SimpleMultiBlockAislePatternBuilder.start()
                .aisle(" ", " ", " ", " ", " ", " ", " "," ", " ")
                .aisle(" ", " ", " ", " ", " ", " ", " "," ", " ")
                .aisle(" ", " ", " ", " ", " ", " ", " "," ", " ")
                .aisle(" ", " ", " ", " ", " ", " ", " "," ", " ")
                .aisle(" ", " ", " ", " ", "*", " ", " "," ", " ")
                .aisle(" ", " ", " ", " ", " ", " ", " "," ", " ")
                .aisle(" ", " ", " ", " ", " ", " ", " "," ", " ")
                .aisle(" ", " ", " ", " ", " ", " ", " "," ", " ")
                .aisle(" ", " ", " ", " ", " ", " ", " "," ", " ")
                .where('*', a -> a.getState().is(air))
                .where(' ', a -> a.getState().is(air)
                );
        pattern.block('*', air::defaultBlockState);
        pattern.block(' ', air::defaultBlockState);

        CLEAR_9x9 = pattern.build();
    }

    static {

        SimpleMultiBlockAislePatternBuilder pattern = SimpleMultiBlockAislePatternBuilder.start()
                .aisle("         ","         ","         ","         ","    *    ","         ","         ","         ","         ")
                .where('*', a -> a.getState().is(air))
                .where(' ', a -> a.getState().is(air)
                );
        pattern.block('*', air::defaultBlockState);
        pattern.block(' ', air::defaultBlockState);

        CLEAR_9x9_UP = pattern.build();
    }

    static {

        SimpleMultiBlockAislePatternBuilder pattern = SimpleMultiBlockAislePatternBuilder.start()
                .aisle("   ", " * ", "   ")
                .where('*', a -> a.getState().is(air))
                .where(' ', a -> a.getState().is(air)
                );
        pattern.block('*', air::defaultBlockState);
        pattern.block(' ', air::defaultBlockState);

        CLEAR_3x3_UP = pattern.build();
    }

    static {

        SimpleMultiBlockAislePatternBuilder pattern = SimpleMultiBlockAislePatternBuilder.start()
                .aisle(" ", " ", " ")
                .aisle(" ", "*", " ")
                .aisle(" ", " ", " ")
                .where('*', a -> a.getState().is(air))
                .where(' ', a -> a.getState().is(air)
                );
        pattern.block('*', air::defaultBlockState);
        pattern.block(' ', air::defaultBlockState);

        CLEAR_3x3 = pattern.build();
    }

    static {

        SimpleMultiBlockAislePatternBuilder pattern = SimpleMultiBlockAislePatternBuilder.start()
                .aisle(" ", " ", " ", " ", " ", " ", " ", " ", " ")
                .aisle(" ", " ", " ", " ", " ", " ", " ", " ", " ")
                .aisle(" ", " ", " ", " ", "*", " ", " ", " ", " ")
                .aisle(" ", " ", " ", " ", " ", " ", " ", " ", " ")
                .where('*', a -> a.getState().is(air))
                .where(' ', a -> a.getState().is(air)
                );
        pattern.block('*', air::defaultBlockState);
        pattern.block(' ', air::defaultBlockState);

        CLEAR_9x4 = pattern.build();
    }

    static {

        SimpleMultiBlockAislePatternBuilder pattern = SimpleMultiBlockAislePatternBuilder.start()
                .aisle(" ", " ", " ", " ", " ", " ", " ", " ", " ")
                .aisle(" ", " ", " ", " ", " ", " ", " ", " ", " ")
                .aisle(" ", " ", " ", " ", " ", " ", " ", " ", " ")
                .aisle(" ", " ", " ", " ", " ", " ", " ", " ", " ")
                .aisle(" ", " ", " ", " ", " ", " ", " ", " ", " ")
                .aisle(" ", " ", " ", " ", " ", " ", " ", " ", " ")
                .aisle(" ", " ", " ", " ", " ", " ", " ", " ", " ")
                .aisle(" ", " ", " ", " ", " ", " ", " ", " ", " ")
                .aisle(" ", " ", " ", " ", " ", " ", " ", " ", " ")
                .aisle(" ", " ", " ", " ", " ", " ", " ", " ", " ")
                .aisle(" ", " ", " ", " ", " ", " ", " ", " ", " ")
                .aisle(" ", " ", " ", " ", " ", " ", " ", " ", " ")
                .aisle(" ", " ", " ", " ", "*", " ", " ", " ", " ")
                .aisle(" ", " ", " ", " ", " ", " ", " ", " ", " ")
                .where('*', a -> a.getState().is(air))
                .where(' ', a -> a.getState().is(air)
                );
        pattern.block('*', air::defaultBlockState);
        pattern.block(' ', air::defaultBlockState);

        CLEAR_9x14 = pattern.build();
    }

}