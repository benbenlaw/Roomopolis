package com.benbenlaw.roomopolis.client;

import com.benbenlaw.Roomopolis;
import com.benbenlaw.roomopolis.events.HoldingKeyHoverWarning;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.client.gui.overlay.VanillaGuiOverlay;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Roomopolis.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientListener {

    @SubscribeEvent
    public static void registerOverlay(RegisterGuiOverlaysEvent event) {
        event.registerAbove(VanillaGuiOverlay.CROSSHAIR.id(), "holding_key_warning", (gui, guiGraphics, partialTick, screenWidth, screenHeight)
                -> HoldingKeyHoverWarning.renderHoldingKeyWarning(guiGraphics));
    }
}
