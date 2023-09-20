package com.benbenlaw.item;

import com.benbenlaw.Roomopolis;
import com.benbenlaw.item.custom.AdvancedKeyItem;
import com.benbenlaw.item.custom.BasicKeyItem;

import com.benbenlaw.item.custom.EliteKeyItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@SuppressWarnings("unused")
public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Roomopolis.MOD_ID);

    public static final RegistryObject<Item> BASIC_ROOM_KEY = ITEMS.register("basic_room_key", () -> new BasicKeyItem(
            new Item.Properties()));
    public static final RegistryObject<Item> ADVANCED_ROOM_KEY = ITEMS.register("advanced_room_key", () -> new AdvancedKeyItem(
            new Item.Properties()));
    public static final RegistryObject<Item> ELITE_ROOM_KEY = ITEMS.register("elite_room_key", () -> new EliteKeyItem(
            new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }


}
