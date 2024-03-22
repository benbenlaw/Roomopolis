package com.benbenlaw.roomopolis.util;

import com.benbenlaw.Roomopolis;
import com.benbenlaw.opolisutilities.OpolisUtilities;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {

    public static class Blocks {

        public static final TagKey<Block> REPLACEABLE_BLOCKS = tag("replaceable_blocks");
        public static final TagKey<Block> KEY_BLOCK_SMART_BLOCKS = tag("key_block_smart_blocks");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(Roomopolis.MOD_ID, name));
        }

        private static TagKey<Block> forgeTag(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }

    public static class Items {

        public static final TagKey<Item> REPLACEABLE_BLOCKS = tag("replaceable_blocks");
        public static final TagKey<Item> KEY_BLOCK_SMART_BLOCKS = tag("key_block_smart_blocks");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(Roomopolis.MOD_ID, name));
        }

        private static TagKey<Item> forgeTag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }

}
