package com.benbenlaw;

import com.benbenlaw.roomopolis.block.ModBlocks;
import com.benbenlaw.roomopolis.config.RoomopolisConfigFile;
import com.benbenlaw.roomopolis.item.ModCreativeTab;
import com.benbenlaw.roomopolis.item.ModItems;
import com.benbenlaw.roomopolis.multiblock.rooms.Rooms;
import com.benbenlaw.roomopolis.util.KeyTooltipComponent;
import com.benbenlaw.roomopolis.util.ModTags;
import com.mojang.logging.LogUtils;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Roomopolis.MOD_ID)
public class Roomopolis {

    public static final String MOD_ID = "roomopolis";
    private static final Logger LOGGER = LogUtils.getLogger();


    public Roomopolis() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeTab.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        ModLoadingContext.get().registerConfig(net.minecraftforge.fml.config.ModConfig.Type.COMMON, RoomopolisConfigFile.SPEC, "roomopolis.toml");

        MinecraftForge.EVENT_BUS.register(this);

    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            //    ModMessages.register();
        });

    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

            event.enqueueWork(() -> {

            });
        }
    }


}

