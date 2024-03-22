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
        MANAGER.register("basic_room", BASIC_ROOM);
    }


    private static final Block roomBlock = ModBlocks.BASIC_ROOM_BLOCK.get();
    private static final Block air = Blocks.AIR;
    public static Block bricks = ForgeRegistries.BLOCKS.getValue(new ResourceLocation("caveopolis:light_blue_colored_stone_bricks"));


    private static final Block vanillaGlass = Blocks.GLASS;
    private static final Block glassentialGlass = ForgeRegistries.BLOCKS.getValue(new ResourceLocation("glassential:glass_light"));
    private static final Block glass = ModList.get().isLoaded("glassential") ? glassentialGlass : vanillaGlass;
    private static final Block keyBlock = ModBlocks.BASIC_ROOM_KEY_BLOCK.get();

    static {

        SimpleMultiBlockAislePatternBuilder basicRoom = SimpleMultiBlockAislePatternBuilder.start()
                .aisle("BBBBBBBBBBB", "BBBBBBBBBBB", "BBBBBBBBBBB", "BBBBBBBBBBB", "BBBBBBBBBBB", "BBBBBKBBBBB", "BBBBBBBBBBB", "BBBBBBBBBBB", "BBBBBBBBBBB", "BBBBBBBBBBB", "BBBBBBBBBBB")
                .aisle("BGGGBBBGGGB", "G         G", "G         G", "G         G", "B         B", "B         B", "B         B", "G         G", "G         G", "G         G", "BGGGBBBGGGB")
                .aisle("BGGGBBBGGGB", "G         G", "G         G", "G         G", "B         B", "B         B", "B         B", "G         G", "G         G", "G         G", "BGGGBBBGGGB")
                .aisle("BGGGBBBGGGB", "G         G", "G         G", "G         G", "B         B", "B         B", "B         B", "G         G", "G         G", "G         G", "BGGGBBBGGGB")
                .aisle("BGGGBBBGGGB", "G         G", "G         G", "G         G", "B         B", "B         B", "B         B", "G         G", "G         G", "G         G", "BGGGBBBGGGB")
                .aisle("BBBBBBBBBBB", "B         B", "B         B", "B         B", "B         B", "B         B", "B         B", "B         B", "B         B", "B         B", "BBBBBBBBBBB")
                .aisle("BGGGBBBGGGB", "G         G", "G         G", "G         G", "B         B", "B         B", "B         B", "G         G", "G         G", "G         G", "BGGGBBBGGGB")
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

        basicRoom.block('*', air::defaultBlockState);
        basicRoom.block(' ', air::defaultBlockState);
        basicRoom.block('B', bricks::defaultBlockState);
        basicRoom.block('G', glass::defaultBlockState);
        basicRoom.block('K', keyBlock::defaultBlockState);

        BASIC_ROOM = basicRoom.build();



        SimpleMultiBlockAislePatternBuilder tallRoom = SimpleMultiBlockAislePatternBuilder.start()
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

        tallRoom.block('*', air::defaultBlockState);
        tallRoom.block(' ', air::defaultBlockState);
        tallRoom.block('B', bricks::defaultBlockState);
        tallRoom.block('G', glass::defaultBlockState);
        tallRoom.block('K', keyBlock::defaultBlockState);

        TALL_ROOM = tallRoom.build();



        SimpleMultiBlockAislePatternBuilder shortRoom = SimpleMultiBlockAislePatternBuilder.start()
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


        shortRoom.block('*', air::defaultBlockState);
        shortRoom.block(' ', air::defaultBlockState);
        shortRoom.block('B', bricks::defaultBlockState);
        shortRoom.block('G', glass::defaultBlockState);
        shortRoom.block('K', keyBlock::defaultBlockState);

        SHORT_ROOM = shortRoom.build();



        SimpleMultiBlockAislePatternBuilder topperRoom = SimpleMultiBlockAislePatternBuilder.start()
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


        topperRoom.block('*', air::defaultBlockState);
        topperRoom.block(' ', air::defaultBlockState);
        topperRoom.block('B', bricks::defaultBlockState);
        topperRoom.block('G', glass::defaultBlockState);
        topperRoom.block('K', keyBlock::defaultBlockState);

        ROOM_TOPPER = topperRoom.build();
    }


}