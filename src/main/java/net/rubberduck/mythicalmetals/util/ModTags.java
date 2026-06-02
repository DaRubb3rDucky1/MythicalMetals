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

        public static final TagKey<Block> STORAGE_BLOCK = forgeTag("storage_blocks");
        public static final TagKey<Block> STORAGE_BLOCK_ORICHALCUM = forgeTag("storage_blocks/orichalcum");
        public static final TagKey<Block> STORAGE_BLOCK_RAW_ORICHALCUM = forgeTag("storage_blocks/raw_orichalcum");
        public static final TagKey<Block> STORAGE_BLOCK_MYTHRIL = forgeTag("storage_blocks/mythril");
        public static final TagKey<Block> STORAGE_BLOCK_RAW_MYTHRIL = forgeTag("storage_blocks/raw_mythril");
        public static final TagKey<Block> STORAGE_BLOCK_ADAMANTIUM = forgeTag("storage_blocks/adamantium");
        public static final TagKey<Block> STORAGE_BLOCK_CHRONITE = forgeTag("storage_blocks/chronite");
        public static final TagKey<Block> STORAGE_BLOCK_INFERNITE = forgeTag("storage_blocks/infernite");
        public static final TagKey<Block> STORAGE_BLOCK_RAW_INFERNITE = forgeTag("storage_blocks/raw_infernite");
        public static final TagKey<Block> STORAGE_BLOCK_AZURITE = forgeTag("storage_blocks/azurite");
        public static final TagKey<Block> STORAGE_BLOCK_RAW_AZURITE = forgeTag("storage_blocks/raw_azurite");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(MythicalMetals.MODID, name));
        }
        private static TagKey<Block> forgeTag(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }
    public static class Items {
        public static final TagKey<Item> MAGICAL_METAL = tag("magical_metal");
        public static final TagKey<Item> SCYTHE = tag("scythe");

        public static final TagKey<Item> ORICHALCUM_ARMOR = tag("armor/orichalcum");
        public static final TagKey<Item> MYTHRIL_ARMOR = tag("armor/mythril");
        public static final TagKey<Item> ADAMANTIUM_ARMOR = tag("armor/adamantium");
        public static final TagKey<Item> CHRONITE_ARMOR = tag("armor/chronite");
        public static final TagKey<Item> INFERNITE_ARMOR = tag("armor/infernite");
        public static final TagKey<Item> AZURITE_ARMOR = tag("armor/azurite");

        public static final TagKey<Item> ORICHALCUM_INGOT = forgeTag("ingots/orchicalcum");
        public static final TagKey<Item> MYTHRIL_INGOT = forgeTag("ingots/mythril");
        public static final TagKey<Item> ADAMANTIUM_INGOT = forgeTag("ingots/adamantium");
        public static final TagKey<Item> INFERNITE_INGOT = forgeTag("ingots/infernite");
        public static final TagKey<Item> AZURITE_INGOT = forgeTag("ingots/azurite");
        public static final TagKey<Item> CHRONITE_INGOT = forgeTag("ingots/chronite");

        public static final TagKey<Item> STORAGE_BLOCK = forgeTag("storage_blocks");

        public static final TagKey<Item> STORAGE_BLOCK_ORICHALCUM = forgeTag("storage_blocks/orichalcum");
        public static final TagKey<Item> STORAGE_BLOCK_RAW_ORICHALCUM = forgeTag("storage_blocks/raw_orichalcum");
        public static final TagKey<Item> STORAGE_BLOCK_MYTHRIL = forgeTag("storage_blocks/mythril");
        public static final TagKey<Item> STORAGE_BLOCK_RAW_MYTHRIL = forgeTag("storage_blocks/raw_mythril");
        public static final TagKey<Item> STORAGE_BLOCK_ADAMANTIUM = forgeTag("storage_blocks/adamantium");
        public static final TagKey<Item> STORAGE_BLOCK_CHRONITE = forgeTag("storage_blocks/chronite");
        public static final TagKey<Item> STORAGE_BLOCK_INFERNITE = forgeTag("storage_blocks/infernite");
        public static final TagKey<Item> STORAGE_BLOCK_RAW_INFERNITE = forgeTag("storage_blocks/raw_infernite");
        public static final TagKey<Item> STORAGE_BLOCK_AZURITE = forgeTag("storage_blocks/azurite");
        public static final TagKey<Item> STORAGE_BLOCK_RAW_AZURITE = forgeTag("storage_blocks/raw_azurite");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(MythicalMetals.MODID, name));
        }
        private static TagKey<Item> forgeTag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }
}
