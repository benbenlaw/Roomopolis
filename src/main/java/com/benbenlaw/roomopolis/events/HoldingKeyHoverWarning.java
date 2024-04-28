package com.benbenlaw.roomopolis.events;

import com.benbenlaw.Roomopolis;
import com.benbenlaw.roomopolis.block.custom.RoomBlock;
import com.benbenlaw.roomopolis.util.ModTags;
import com.mojang.blaze3d.platform.Window;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.common.Mod;

import java.awt.*;
import java.util.Optional;

@Mod.EventBusSubscriber(modid = Roomopolis.MOD_ID)

public class HoldingKeyHoverWarning {

    @OnlyIn(Dist.CLIENT)
    public static void renderHoldingKeyWarning(GuiGraphics graphics) {

        Minecraft minecraft = Minecraft.getInstance();
        Player player = minecraft.player;
        Level level = player.level();
        Window window = minecraft.getWindow();

        int centerX = window.getGuiScaledWidth() / 2;
        int centerY = window.getGuiScaledHeight() / 2;

        if (player.getMainHandItem().getItem().asItem().getDefaultInstance().is(ModTags.Items.KEYS)) {

            if (minecraft.screen == null) {

                HitResult roomBlock = minecraft.hitResult;

                if (roomBlock instanceof BlockHitResult hit) {
                    BlockPos blockPos = hit.getBlockPos();
                    BlockState blockState = level.getBlockState(blockPos);

                    if (blockState.getBlock() instanceof RoomBlock) {
                        graphics.renderTooltip(minecraft.font, Component.literal("This will override blocks in the area!").withStyle(ChatFormatting.RED),
                                centerX - minecraft.font.width("This will override blocks in the area!") / 2,
                                centerY - minecraft.font.lineHeight);

                        graphics.pose().pushPose();
                        graphics.pose().scale(0.75F, 0.75F, 0.75F);
                        graphics.pose().popPose();

                    }


                }

            }
        }
    }

}
