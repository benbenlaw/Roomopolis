package com.benbenlaw.block;

import com.benbenlaw.Roomopolis;
import com.benbenlaw.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Roomopolis.MOD_ID);

    public static final RegistryObject<Block> BASIC_ROOM_BLOCK = registerBlock("basic_room_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.BEDROCK).sound(SoundType.METAL)));

    public static final RegistryObject<Block> BASIC_ROOM_KEY_BLOCK = registerBlock("basic_room_key_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.BEDROCK).sound(SoundType.METAL)));

    public static final RegistryObject<Block> ADVANCED_ROOM_KEY_BLOCK = registerBlock("advanced_room_key_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.BEDROCK).sound(SoundType.METAL)));

    public static final RegistryObject<Block> ELITE_ROOM_KEY_BLOCK = registerBlock("elite_room_key_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.BEDROCK).sound(SoundType.METAL)));


    //Light Level When Interacted With

    private static ToIntFunction<BlockState> litBlockEmission(int p_50760_) {
        return (p_50763_) -> {
            return p_50763_.getValue(BlockStateProperties.LIT) ? p_50760_ : 0;
        };
    }




    private static <T extends Block> RegistryObject<T> registerBlockWithoutBlockItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}