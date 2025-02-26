package com.benbenlaw.roomopolis.network.packet;

import com.benbenlaw.caveopolis.screen.WorktableMenu;
import com.benbenlaw.roomopolis.item.KeyItem;
import com.benbenlaw.roomopolis.item.KeyItemSizeCache;
import com.benbenlaw.roomopolis.network.payload.GetStructureSizePayload;
import net.minecraft.core.Vec3i;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.Optional;

public class GetStructureSizePacket {
    public static final GetStructureSizePacket INSTANCE = new GetStructureSizePacket();

    public static GetStructureSizePacket get() {
        return INSTANCE;
    }

    public void handle(final GetStructureSizePayload payload, IPayloadContext context) {

        ResourceLocation templateId = ResourceLocation.parse(payload.templateID());
        Level level = context.player().level();
        StructureTemplateManager structureManager = Objects.requireNonNull(level.getServer()).getStructureManager();
        Optional<StructureTemplate> optionalTemplate = structureManager.get(templateId);

        if (optionalTemplate.isPresent()) {
            StructureTemplate template = optionalTemplate.get();
            Vec3i size = template.getSize();
            //Set the size in the cache for keys to read client side
            KeyItemSizeCache.setTemplateSize(templateId, size);
        }
    }


}
