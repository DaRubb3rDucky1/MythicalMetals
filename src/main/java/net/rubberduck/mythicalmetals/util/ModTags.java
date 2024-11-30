package net.rubberduck.mythicalmetals.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.rubberduck.mythicalmetals.MythicalMetals;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_MAGICAL_TOOL = tag("needs_magical_tool");
        public static final TagKey<Block> NEEDS_ADAMANITE_TOOL = tag("needs_adamanite_tool");
        public static final TagKey<Block> NEEDS_MYTHIC_TOOL = tag("needs_mythic_tool");
        public static final TagKey<Block> NEEDS_TEMPORAL_TOOL = tag("needs_temporal_tool");
        public static final TagKey<Block> NEEDS_HELLISH_TOOL = tag("needs_hellish_tool");
        public static final TagKey<Block> NEEDS_ENDERIC_TOOL = tag("needs_enderic_tool");
        public static final TagKey<Block> NEEDS_DIMENSIONAL_TOOL = tag("needs_dimensional_tool");
        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(MythicalMetals.MODID, name));
        }
    }
    public static class Items {
        public static final TagKey<Item> MAGICAL_METAL = tag("magical_metal");
        public static final TagKey<Item> SCYTHE = tag("scythe");
        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(MythicalMetals.MODID, name));
        }
    }
}
