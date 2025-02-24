package com.benbenlaw.roomopolis.integration.kubejs;

import com.benbenlaw.roomopolis.item.KeyItem;
import dev.latvian.mods.kubejs.item.ItemBuilder;
import dev.latvian.mods.kubejs.typings.Info;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class KeyItemBuilder extends ItemBuilder {

    private String templateId;
    private int heightAdjustment;
    private String keyBlock;

    public KeyItemBuilder(ResourceLocation i) {
        super(i);
    }

    @Info("Resource location of the template eg roomopolis:tiny_room")
    public KeyItemBuilder templateId(String templateId) {
        this.templateId = templateId;
        return this;
    }

    @Info("The height adjustment for the template to be placed")
    public KeyItemBuilder heightAdjustment(int heightAdjustment) {
        this.heightAdjustment = heightAdjustment;
        return this;
    }

    @Info("The block to use as the key eg minecraft:iron_block, this is not required")
    public KeyItemBuilder keyBlock(String keyBlock) {

        if (keyBlock.isEmpty()) {
            this.keyBlock = null;
        } else {
            this.keyBlock = keyBlock;
        }

        return this;
    }

    @Override
    public Item createObject() {
        return new KeyItem(createItemProperties(), templateId, heightAdjustment, keyBlock);
    }
}
