package com.benbenlaw;

import com.benbenlaw.roomopolis.block.RoomopolisBlocks;
import com.benbenlaw.roomopolis.item.RoomopolisCreativeTab;
import com.benbenlaw.roomopolis.item.RoomopolisItems;
import com.benbenlaw.roomopolis.network.RoomopolisMessages;
import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Roomopolis.MOD_ID)
public class Roomopolis {

    public static final String MOD_ID = "roomopolis";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Roomopolis (final IEventBus eventBus, final ModContainer modContainer) {

        RoomopolisItems.ITEMS.register(eventBus);
        RoomopolisBlocks.BLOCKS.register(eventBus);
        RoomopolisCreativeTab.CREATIVE_MODE_TABS.register(eventBus);

        eventBus.addListener(this::networkingSetup);
    }

    public void networkingSetup(RegisterPayloadHandlersEvent event) {
        RoomopolisMessages.registerNetworking(event);
    }




}

