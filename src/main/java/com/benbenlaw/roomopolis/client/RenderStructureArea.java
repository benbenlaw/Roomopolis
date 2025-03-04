package com.benbenlaw.roomopolis.client;

import com.benbenlaw.Roomopolis;
import com.benbenlaw.roomopolis.item.KeyItem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.RenderHighlightEvent;

@EventBusSubscriber(modid = Roomopolis.MOD_ID,value = Dist.CLIENT)
public class RenderStructureArea {


    @SubscribeEvent
    public static void renderStructureOutline(RenderHighlightEvent.Block event) {

    }

}
