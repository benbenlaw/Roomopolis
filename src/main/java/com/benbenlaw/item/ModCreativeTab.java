package com.benbenlaw.item;

import com.benbenlaw.Roomopolis;
import com.benbenlaw.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTab {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Roomopolis.MOD_ID);

    public static final RegistryObject<CreativeModeTab> STRAINERS_TAB = CREATIVE_MODE_TABS.register("roomopolis", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> ModItems.BASIC_ROOM_KEY.get().getDefaultInstance())
            .title(Component.translatable("itemGroup.roomopolis"))
            .displayItems((parameters, output) -> {

                output.accept(ModBlocks.BASIC_ROOM_BLOCK.get());
                output.accept(ModItems.BASIC_ROOM_KEY.get());
                output.accept(ModBlocks.BASIC_ROOM_KEY_BLOCK.get());
                output.accept(ModItems.ADVANCED_ROOM_KEY.get());
                output.accept(ModBlocks.ADVANCED_ROOM_KEY_BLOCK.get());
                output.accept(ModItems.ELITE_ROOM_KEY.get());
                output.accept(ModBlocks.ELITE_ROOM_KEY_BLOCK.get());

            }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }


}
