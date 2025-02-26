package com.benbenlaw.roomopolis.network.payload;

import com.benbenlaw.Roomopolis;
import com.benbenlaw.caveopolis.Caveopolis;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

public record GetStructureSizePayload(String templateID) implements CustomPacketPayload {


    public static final Type<GetStructureSizePayload> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(Roomopolis.MOD_ID, "structure_size"));

    @Override
    public Type<GetStructureSizePayload> type() {
        return TYPE;
    }

    public static final StreamCodec<FriendlyByteBuf, GetStructureSizePayload> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.STRING_UTF8, GetStructureSizePayload::templateID,
            GetStructureSizePayload::new
    );

}