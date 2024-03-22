package com.benbenlaw.roomopolis.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.client.renderer.texture.AbstractTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.awt.*;

public class KeyTooltipComponent implements ClientTooltipComponent {
    @Override
    public int getHeight() {
        return 3;
    }

    @Override
    public int getWidth(Font p_169952_) {
        return 3;
    }

    @Override
    public void renderImage(Font font, int x, int y, GuiGraphics guiGraphics) {

        guiGraphics.pose().pushPose();
        TextureAtlasSprite texture = Minecraft.getInstance().getTextureAtlas(InventoryMenu.BLOCK_ATLAS).apply(new ResourceLocation("minecraft:dirt"));

        guiGraphics.blit(x, y, 0, 0, 16, texture);

        guiGraphics.pose().popPose();
   }



}
