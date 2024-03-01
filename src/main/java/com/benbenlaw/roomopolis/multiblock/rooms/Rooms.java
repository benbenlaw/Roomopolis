package com.benbenlaw.roomopolis.multiblock.rooms;

import com.benbenlaw.roomopolis.block.ModBlocks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import org.mangorage.mangomultiblock.core.SimpleMultiBlockAislePatternBuilder;
import org.mangorage.mangomultiblock.core.impl.IMultiBlockPattern;
import org.mangorage.mangomultiblock.core.manager.MultiBlockManager;

public class Rooms {
    public static final MultiBlockManager MANAGER = MultiBlockManager.getOrCreate("mangomultiblock", "roomopolis");

    public static final IMultiBlockPattern BASIC_ROOM;
    public static final IMultiBlockPattern TALL_ROOM;
    public static final IMultiBlockPattern SHORT_ROOM;
    public static final IMultiBlockPattern ROOM_TOPPER;

    public Rooms() {
    }
    public static void init() {
        MANAGER.register("test", BASIC_ROOM);
    }


    private static final Block roomBlock = ModBlocks.BASIC_ROOM_BLOCK.get();
    private static final Block air = Blocks.AIR;
    private static final Block bricks = ForgeRegistries.BLOCKS.getValue(new ResourceLocation("caveopolis:light_blue_colored_stone_bricks"));
    private static final Block glass = Blocks.GLASS; // ForgeRegistries.BLOCKS.getValue(new ResourceLocation("glassential:glass_light"));
    private static final Block keyBlock = ModBlocks.BASIC_ROOM_KEY_BLOCK.get();

    static {

        SimpleMultiBlockAislePatternBuilder pattern = SimpleMultiBlockAislePatternBuilder.start()
                .aisle("BBBBBBBBBBB", "BBBBBBBBBBB", "BBBBBBBBBBB", "BBBBBBBBBBB", "BBBBBBBBBBB", "BBBBBKBBBBB", "BBBBBBBBBBB", "BBBBBBBBBBB", "BBBBBBBBBBB", "BBBBBBBBBBB", "BBBBBBBBBBB")
                .aisle("BGGGBBBGGGB", "G         G", "G         G", "G         G", "B         G", "B         B", "B         G", "G         G", "G         G", "G         G", "BGGGBBBGGGB")
                .aisle("BGGGBBBGGGB", "G         G", "G         G", "G         G", "B         G", "B         B", "B         G", "G         G", "G         G", "G         G", "BGGGBBBGGGB")
                .aisle("BGGGBBBGGGB", "G         G", "G         G", "G         G", "B         G", "B         B", "B         G", "G         G", "G         G", "G         G", "BGGGBBBGGGB")
                .aisle("BGGGBBBGGGB", "G         G", "G         G", "G         G", "B         G", "B         B", "B         G", "G         G", "G         G", "G         G", "BGGGBBBGGGB")
                .aisle("BBBBBBBBBBB", "B         B", "B         B", "B         B", "B         B", "B         B", "B         B", "B         B", "B         B", "B         B", "BBBBBBBBBBB")
                .aisle("BGGGBBBGGGB", "G         G", "G         G", "G         G", "B         G", "B         B", "B         G", "G         G", "G         G", "G         G", "BGGGBBBGGGB")
                .aisle("BGGGBBBGGGB", "G         G", "G         G", "G         G", "B         G", "B         B", "B         G", "G         G", "G         G", "G         G", "BGGGBBBGGGB")
                .aisle("BGGGBKBGGGB", "G         G", "G         G", "G         G", "B         G", "K         K", "B         G", "G         G", "G         G", "G         G", "BGGGBKBGGGB")
                .aisle("BGGGBBBGGGB", "G         G", "G         G", "G         G", "B         G", "B    *    B", "B         G", "G         G", "G         G", "G         G", "BGGGBBBGGGB")
                .aisle("BBBBBBBBBBB", "BBBBBBBBBBB", "BBBBBBBBBBB", "BBBBBBBBBBB", "BBBBBBBBBBB", "BBBBBKBBBBB", "BBBBBBBBBBB", "BBBBBBBBBBB", "BBBBBBBBBBB", "BBBBBBBBBBB", "BBBBBBBBBBB")
                .where('*', a -> a.getState().is(air))
                .where(' ', a -> a.getState().is(air))
                .where('B', a -> a.getState().is(bricks))
                .where('G', a -> a.getState().is(glass))
                .where('K', a -> a.getState().is(keyBlock)
                );

        pattern.block('*', air::defaultBlockState);
        pattern.block(' ', air::defaultBlockState);
        pattern.block('B', bricks::defaultBlockState);
        pattern.block('G', glass::defaultBlockState);
        pattern.block('K', keyBlock::defaultBlockState);

        BASIC_ROOM = pattern.build();
    }

    static {

        SimpleMultiBlockAislePatternBuilder pattern = SimpleMultiBlockAislePatternBuilder.start()
                .aisle("BBBBBBBBBBB", "BBBBBBBBBBB", "BBBBBBBBBBB", "BBBBBBBBBBB", "BBBBBBBBBBB", "BBBBBKBBBBB", "BBBBBBBBBBB", "BBBBBBBBBBB", "BBBBBBBBBBB", "BBBBBBBBBBB", "BBBBBBBBBBB")
                .aisle("BGGGBBBGGGB", "G         G", "G         G", "G         G", "B         B", "B         B", "B         B", "G         G", "G         G", "G         G", "BGGGBBBGGGB")
                .aisle("BGGGBBBGGGB", "G         G", "G         G", "G         G", "B         B", "B         B", "B         B", "G         G", "G         G", "G         G", "BGGGBBBGGGB")
                .aisle("BGGGBBBGGGB", "G         G", "G         G", "G         G", "B         B", "B         B", "B         B", "G         G", "G         G", "G         G", "BGGGBBBGGGB")
                .aisle("BGGGBBBGGGB", "G         G", "G         G", "G         G", "B         B", "B         B", "B         B", "G         G", "G         G", "G         G", "BGGGBBBGGGB")
                .aisle("BBBBBBBBBBB", "B         B", "B         B", "B         B", "B         B", "B         B", "B         B", "B         B", "B         B", "B         B", "BBBBBBBBBBB")
                .aisle("BGGGBBBGGGB", "G         G", "G         G", "G         G", "B         B", "B         B", "B         B", "G         G", "G         G", "G         G", "BGGGBBBGGGB")
                .aisle("BGGGBBBGGGB", "G         G", "G         G", "G         G", "B         B", "B         B", "B         B", "G         G", "G         G", "G         G", "BGGGBBBGGGB")
                .aisle("BGGGBBBGGGB", "G         G", "G         G", "G         G", "B         B", "B         B", "B         B", "G         G", "G         G", "G         G", "BGGGBBBGGGB")
                .aisle("BGGGBBBGGGB", "G         G", "G         G", "G         G", "B         B", "B         B", "B         B", "G         G", "G         G", "G         G", "BGGGBBBGGGB")
                .aisle("BBBBBBBBBBB", "B         B", "B         B", "B         B", "B         B", "B         B", "B         B", "B         B", "B         B", "B         B", "BBBBBBBBBBB")
                .aisle("BGGGBBBGGGB", "G         G", "G         G", "G         G", "B         B", "B         B", "B         B", "G         G", "G         G", "G         G", "BGGGBBBGGGB")
                .aisle("BGGGBBBGGGB", "G         G", "G         G", "G         G", "B         B", "B         B", "B         B", "G         G", "G         G", "G         G", "BGGGBBBGGGB")
                .aisle("BGGGBKBGGGB", "G         G", "G         G", "G         G", "B         B", "K         K", "B         B", "G         G", "G         G", "G         G", "BGGGBKBGGGB")
                .aisle("BGGGBBBGGGB", "G         G", "G         G", "G         G", "B         B", "B    *    B", "B         B", "G         G", "G         G", "G         G", "BGGGBBBGGGB")
                .aisle("BBBBBBBBBBB", "BBBBBBBBBBB", "BBBBBBBBBBB", "BBBBBBBBBBB", "BBBBBBBBBBB", "BBBBBKBBBBB", "BBBBBBBBBBB", "BBBBBBBBBBB", "BBBBBBBBBBB", "BBBBBBBBBBB", "BBBBBBBBBBB")
                .where('*', a -> a.getState().is(air))
                .where(' ', a -> a.getState().is(air))
                .where('B', a -> a.getState().is(bricks))
                .where('G', a -> a.getState().is(glass))
                .where('K', a -> a.getState().is(keyBlock)
                );

        pattern.block('*', air::defaultBlockState);
        pattern.block(' ', air::defaultBlockState);
        pattern.block('B', bricks::defaultBlockState);
        pattern.block('G', glass::defaultBlockState);
        pattern.block('K', keyBlock::defaultBlockState);

        TALL_ROOM = pattern.build();
    }
    static {

        SimpleMultiBlockAislePatternBuilder pattern = SimpleMultiBlockAislePatternBuilder.start()
                .aisle("BBBBBBBBBBB", "BBBBBBBBBBB", "BBBBBBBBBBB", "BBBBBBBBBBB", "BBBBBBBBBBB", "BBBBBKBBBBB", "BBBBBBBBBBB", "BBBBBBBBBBB", "BBBBBBBBBBB", "BBBBBBBBBBB", "BBBBBBBBBBB")
                .aisle("BGGGBBBGGGB", "G         G", "G         G", "G         G", "B         B", "B         B", "B         B", "G         G", "G         G", "G         G", "BGGGBBBGGGB")
                .aisle("BGGGBBBGGGB", "G         G", "G         G", "G         G", "B         B", "B         B", "B         B", "G         G", "G         G", "G         G", "BGGGBBBGGGB")
                .aisle("BGGGBKBGGGB", "G         G", "G         G", "G         G", "B         B", "K         K", "B         B", "G         G", "G         G", "G         G", "BGGGBKBGGGB")
                .aisle("BGGGBBBGGGB", "G         G", "G         G", "G         G", "B         B", "B    *    B", "B         B", "G         G", "G         G", "G         G", "BGGGBBBGGGB")
                .aisle("BBBBBBBBBBB", "BBBBBBBBBBB", "BBBBBBBBBBB", "BBBBBBBBBBB", "BBBBBBBBBBB", "BBBBBKBBBBB", "BBBBBBBBBBB", "BBBBBBBBBBB", "BBBBBBBBBBB", "BBBBBBBBBBB", "BBBBBBBBBBB")
                .where('*', a -> a.getState().is(air))
                .where(' ', a -> a.getState().is(air))
                .where('B', a -> a.getState().is(bricks))
                .where('G', a -> a.getState().is(glass))
                .where('K', a -> a.getState().is(keyBlock)
                );


        pattern.block('*', air::defaultBlockState);
        pattern.block(' ', air::defaultBlockState);
        pattern.block('B', bricks::defaultBlockState);
        pattern.block('G', glass::defaultBlockState);
        pattern.block('K', keyBlock::defaultBlockState);

        SHORT_ROOM = pattern.build();
    }
    static {

        SimpleMultiBlockAislePatternBuilder pattern = SimpleMultiBlockAislePatternBuilder.start()
                .aisle("           ", "           ", "           ", "           ", "     B     ", "    BBB    ", "     B     ", "           ", "           ", "           ", "           ")
                .aisle("           ", "           ", "     B     ", "   BBBBB   ", "   BBBBB   ", "  BBBBBBB  ", "   BBBBB   ", "   BBBBB   ", "     B     ", "           ", "           ")
                .aisle("           ", "    BBB    ", "  BBBBBBB  ", "  BB   BB  ", " BB     BB ", " BB     BB ", " BB     BB ", "  BB   BB  ", "  BBBBBBB  ", "    BBB    ", "           ")
                .aisle("   BBBBB   ", " BBBBBBBBB ", " BB     BB ", "BB       BB", "BB       BB", "BB       BB", "BB       BB", "BB       BB", " BB     BB ", " BBBBBBBBB ", "   BBBBB   ")
                .aisle(" BBBBBBBBB ", "BBB     BBB", "BB       BB", "B         B", "B         B", "B    *    B", "B         B", "B         B", "BB       BB", "BBB     BBB", " BBBBBBBBB ")
                .where('*', a -> a.getState().is(air))
                .where(' ', a -> a.getState().is(air))
                .where('B', a -> a.getState().is(bricks))
                .where('G', a -> a.getState().is(glass))
                .where('K', a -> a.getState().is(keyBlock)
                );


        pattern.block('*', air::defaultBlockState);
        pattern.block(' ', air::defaultBlockState);
        pattern.block('B', bricks::defaultBlockState);
        pattern.block('G', glass::defaultBlockState);
        pattern.block('K', keyBlock::defaultBlockState);

        ROOM_TOPPER = pattern.build();
    }


}