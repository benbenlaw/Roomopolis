package com.benbenlaw.roomopolis.item;

import com.benbenlaw.Roomopolis;

import com.benbenlaw.roomopolis.item.custom.CorridorKeys.CorridorKey1;
import com.benbenlaw.roomopolis.item.custom.CorridorKeys.CorridorKey2;
import com.benbenlaw.roomopolis.item.custom.CorridorKeys.CorridorKey3;
import com.benbenlaw.roomopolis.item.custom.KeyBlockRemover;
import com.benbenlaw.roomopolis.item.custom.RoomKeys.NormalRoomKey;
import com.benbenlaw.roomopolis.item.custom.RoomKeys.RoomTopperKey;
import com.benbenlaw.roomopolis.item.custom.RoomKeys.ShortRoomKey;
import com.benbenlaw.roomopolis.item.custom.RoomKeys.TallRoomKey;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Roomopolis.MOD_ID);

    public static final RegistryObject<Item> SHORT_ROOM_KEY = ITEMS.register("short_room_key", () -> new ShortRoomKey(
            new Item.Properties()));
    public static final RegistryObject<Item> TALL_ROOM_KEY = ITEMS.register("tall_room_key", () -> new TallRoomKey(
            new Item.Properties()));
    public static final RegistryObject<Item> NORMAL_ROOM_KEY = ITEMS.register("normal_room_key", () -> new NormalRoomKey(
            new Item.Properties()));
    public static final RegistryObject<Item> CORRIDOR_KEY_1 = ITEMS.register("corridor_key_1", () -> new CorridorKey1(
            new Item.Properties()));
    public static final RegistryObject<Item> CORRIDOR_KEY_2 = ITEMS.register("corridor_key_2", () -> new CorridorKey2(
            new Item.Properties()));
    public static final RegistryObject<Item> CORRIDOR_KEY_3 = ITEMS.register("corridor_key_3", () -> new CorridorKey3(
            new Item.Properties()));
    public static final RegistryObject<Item> ROOM_TOPPER_KEY = ITEMS.register("room_topper_key", () -> new RoomTopperKey(
            new Item.Properties()));

    public static final RegistryObject<Item> KEY_BLOCK_REMOVER = ITEMS.register("key_block_remover", () -> new KeyBlockRemover(
            new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }


}
