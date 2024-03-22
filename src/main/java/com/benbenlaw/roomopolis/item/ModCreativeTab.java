package com.benbenlaw.roomopolis.item;

import com.benbenlaw.Roomopolis;
import com.benbenlaw.roomopolis.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTab {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Roomopolis.MOD_ID);

    public static final RegistryObject<CreativeModeTab> ROOMOPOLIS_TAB = CREATIVE_MODE_TABS.register("roomopolis", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> ModItems.NORMAL_ROOM_KEY.get().getDefaultInstance())
            .title(Component.translatable("itemGroup.roomopolis"))
            .displayItems((parameters, output) -> {


                output.accept(ModBlocks.BASIC_ROOM_BLOCK.get());
                output.accept(ModBlocks.BASIC_ROOM_KEY_BLOCK.get());
                output.accept(ModBlocks.ADVANCED_ROOM_KEY_BLOCK.get());

                output.accept(ModItems.SHORT_ROOM_KEY.get());
                output.accept(ModItems.TALL_ROOM_KEY.get());
                output.accept(ModItems.NORMAL_ROOM_KEY.get());

                output.accept(ModItems.CORRIDOR_KEY_1.get());
                output.accept(ModItems.CORRIDOR_KEY_2.get());
                output.accept(ModItems.CORRIDOR_KEY_3.get());

                output.accept(ModItems.ROOM_TOPPER_KEY.get());

                output.accept(ModItems.WALL_REMOVER_KEY_1.get());
                output.accept(ModItems.WALL_REMOVER_KEY_2.get());

                output.accept(ModItems.FIRE_KEY.get());
                output.accept(ModItems.EARTH_KEY.get());
                output.accept(ModItems.AIR_KEY.get());
                output.accept(ModItems.WATER_KEY.get());

                output.accept(ModItems.KEY_BLOCK_REMOVER.get());

                output.accept(ModBlocks.ELITE_ROOM_KEY_BLOCK.get());
                output.accept(ModBlocks.ELITE_ROOM_KEY_BLOCK.get());

            }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }


}
