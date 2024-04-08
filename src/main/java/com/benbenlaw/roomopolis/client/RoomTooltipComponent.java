package com.benbenlaw.roomopolis.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.client.resources.PaintingTextureManager;
import net.minecraft.world.entity.decoration.PaintingVariant;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class RoomTooltipComponent implements ClientTooltipComponent {
    private final int size = 30;

    private final PaintingVariant pattern;
    private final int height;
    private final int width;

    public RoomTooltipComponent(RoomTooltipComponent tooltip) {
        this.pattern = tooltip.pattern;
        float h = pattern.getHeight();
        float w = pattern.getWidth();
        if (h > w) {
            this.height = size;
            this.width = (int) ((size / h) * w);
        } else {
            this.width = size;
            this.height = (int) ((size / w) * h);
        }
    }


    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getWidth(Font font) {
        return width;
    }

    @Override
    public void renderImage(Font font, int x, int y, GuiGraphics guiGraphics) {
        guiGraphics.pose();

        PaintingTextureManager paintingTextureManager = Minecraft.getInstance().getPaintingTextures();
        var sprite = paintingTextureManager.get(pattern);


        guiGraphics.blit(x, y, 0,height, width, sprite);
        guiGraphics.pose().popPose();
    }
}
