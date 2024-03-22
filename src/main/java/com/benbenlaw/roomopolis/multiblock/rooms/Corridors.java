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

public class Corridors {
    public static final MultiBlockManager MANAGER = MultiBlockManager.getOrCreate("mangomultiblock", "roomopolis");

    public static IMultiBlockPattern CORRIDOR_5x5x5;
    public static final IMultiBlockPattern CORRIDOR_5x5x7;
    public static final IMultiBlockPattern CORRIDOR_5x5x9;

    public Corridors() {
    }
    private static final Block air = Blocks.AIR;
    public static Block bricks = ForgeRegistries.BLOCKS.getValue(new ResourceLocation("caveopolis:light_blue_colored_stone_bricks"));
    public static void setBricksBlock(Block block) {
        bricks = block;
    }
    private static final Block keyBlock = ModBlocks.BASIC_ROOM_KEY_BLOCK.get();
    private static final Block vanillaGlass = Blocks.GLASS;
    private static final Block glassentialGlass = ForgeRegistries.BLOCKS.getValue(new ResourceLocation("glassential:glass_light"));
    private static final Block glass = ModList.get().isLoaded("glassential") ? glassentialGlass : vanillaGlass;

    static {

        SimpleMultiBlockAislePatternBuilder corridor1 = SimpleMultiBlockAislePatternBuilder.start()
                .aisle("BBBBBBB", "BBBBBBB", "BBBBBBB", "BBBBBBB", "BBBBBBB")
                .aisle("BGGGGGB", "B     B", "B     B", "B     B", "BGGGGGB")
                .aisle("BGGKGGB", "B     B", "K     K", "B     B", "BGGKGGB")
                .aisle("BGGGGGB", "B     B", "B  *  B", "B     B", "BGGGGGB")
                .aisle("BBBBBBB", "BBBBBBB", "BBBBBBB", "BBBBBBB", "BBBBBBB")
                .where('*', a -> a.getState().is(air))
                .where(' ', a -> a.getState().is(air))
                .where('G', a -> a.getState().is(glass))
                .where('K', a -> a.getState().is(keyBlock))
                .where('B', a -> a.getState().is(bricks)
                );
        corridor1.block('*', air::defaultBlockState);
        corridor1.block(' ', air::defaultBlockState);
        corridor1.block('G', glass::defaultBlockState);
        corridor1.block('K', keyBlock::defaultBlockState);
        corridor1.block('B', bricks::defaultBlockState);

        CORRIDOR_5x5x5 = corridor1.build();


        SimpleMultiBlockAislePatternBuilder corridor2 = SimpleMultiBlockAislePatternBuilder.start()
                .aisle("BBBBBBBBB", "BBBBBBBBB", "BBBBBBBBB", "BBBBBBBBB", "BBBBBBBBB")
                .aisle("BGGGGGGGB", "B       B", "B       B", "B       B", "BGGGGGGGB")
                .aisle("BGGGKGGGB", "B       B", "K       K", "B       B", "BGGGKGGGB")
                .aisle("BGGGGGGGB", "B       B", "B   *   B", "B       B", "BGGGGGGGB")
                .aisle("BBBBBBBBB", "BBBBBBBBB", "BBBBBBBBB", "BBBBBBBBB", "BBBBBBBBB")
                .where('*', a -> a.getState().is(air))
                .where(' ', a -> a.getState().is(air))
                .where('G', a -> a.getState().is(glass))
                .where('K', a -> a.getState().is(keyBlock))
                .where('B', a -> a.getState().is(bricks)
                );

        corridor2.block('*', air::defaultBlockState);
        corridor2.block(' ', air::defaultBlockState);
        corridor2.block('G', glass::defaultBlockState);
        corridor2.block('K', keyBlock::defaultBlockState);
        corridor2.block('B', bricks::defaultBlockState);

        CORRIDOR_5x5x7 = corridor2.build();

        SimpleMultiBlockAislePatternBuilder corridor3 = SimpleMultiBlockAislePatternBuilder.start()
                .aisle("BBBBBBBBBBB", "BBBBBBBBBBB", "BBBBBBBBBBB", "BBBBBBBBBBB", "BBBBBBBBBBB")
                .aisle("BGGGGGGGGGB", "B         B", "B         B", "B         B", "BGGGGGGGGGB")
                .aisle("BGGGGKGGGGB", "B         B", "K         K", "B         B", "BGGGGKGGGGB")
                .aisle("BGGGGGGGGGB", "B         B", "B    *    B", "B         B", "BGGGGGGGGGB")
                .aisle("BBBBBBBBBBB", "BBBBBBBBBBB", "BBBBBBBBBBB", "BBBBBBBBBBB", "BBBBBBBBBBB")
                .where('*', a -> a.getState().is(air))
                .where(' ', a -> a.getState().is(air))
                .where('G', a -> a.getState().is(glass))
                .where('K', a -> a.getState().is(keyBlock))
                .where('B', a -> a.getState().is(bricks)
                );

        corridor3.block('*', air::defaultBlockState);
        corridor3.block(' ', air::defaultBlockState);
        corridor3.block('G', glass::defaultBlockState);
        corridor3.block('K', keyBlock::defaultBlockState);
        corridor3.block('B', bricks::defaultBlockState);

        CORRIDOR_5x5x9 = corridor3.build();
    }


}