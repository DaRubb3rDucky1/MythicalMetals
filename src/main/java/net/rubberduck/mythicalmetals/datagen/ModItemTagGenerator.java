package net.rubberduck.mythicalmetals.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.rubberduck.mythicalmetals.MythicalMetals;
import net.rubberduck.mythicalmetals.block.ModBlocks;
import net.rubberduck.mythicalmetals.item.ModItems;
import net.rubberduck.mythicalmetals.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, MythicalMetals.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(
                        ModItems.ORICHALCUM_HELMET.get(),
                        ModItems.ORICHALCUM_CHESTPLATE.get(),
                        ModItems.ORICHALCUM_LEGGINGS.get(),
                        ModItems.ORICHALCUM_BOOTS.get(),
                        ModItems.MYTHRIL_HELMET.get(),
                        ModItems.MYTHRIL_CHESTPLATE.get(),
                        ModItems.MYTHRIL_LEGGINGS.get(),
                        ModItems.MYTHRIL_BOOTS.get(),
                        ModItems.CHRONITE_HELMET.get(),
                        ModItems.CHRONITE_CHESTPLATE.get(),
                        ModItems.CHRONITE_LEGGINGS.get(),
                        ModItems.CHRONITE_BOOTS.get(),
                        ModItems.ADAMANTIUM_HELMET.get(),
                        ModItems.ADAMANTIUM_CHESTPLATE.get(),
                        ModItems.ADAMANTIUM_LEGGINGS.get(),
                        ModItems.ADAMANTIUM_BOOTS.get(),
                        ModItems.INFERNITE_HELMET.get(),
                        ModItems.INFERNITE_CHESTPLATE.get(),
                        ModItems.INFERNITE_LEGGINGS.get(),
                        ModItems.INFERNITE_BOOTS.get(),
                        ModItems.AZURITE_HELMET.get(),
                        ModItems.AZURITE_CHESTPLATE.get(),
                        ModItems.AZURITE_LEGGINGS.get(),
                        ModItems.AZURITE_BOOTS.get()
                );
        this.tag(Tags.Items.INGOTS).add(
                ModItems.ORICHALCUM_INGOT.get(),
                ModItems.MYTHRIL_INGOT.get(),
                ModItems.ADAMANTIUM_INGOT.get(),
                ModItems.INFERNITE_INGOT.get(),
                ModItems.AZURITE_INGOT.get(),
                ModItems.CHRONITE_INGOT.get()
        );
        this.tag(ModTags.Items.ORICHALCUM_ARMOR).add(
                ModItems.ORICHALCUM_HELMET.get(),
                ModItems.ORICHALCUM_CHESTPLATE.get(),
                ModItems.ORICHALCUM_LEGGINGS.get(),
                ModItems.ORICHALCUM_BOOTS.get()
        );
        this.tag(ModTags.Items.MYTHRIL_ARMOR).add(
                ModItems.MYTHRIL_HELMET.get(),
                ModItems.MYTHRIL_CHESTPLATE.get(),
                ModItems.MYTHRIL_LEGGINGS.get(),
                ModItems.MYTHRIL_BOOTS.get()
        );
        this.tag(ModTags.Items.CHRONITE_ARMOR).add(
                ModItems.CHRONITE_HELMET.get(),
                ModItems.CHRONITE_CHESTPLATE.get(),
                ModItems.CHRONITE_LEGGINGS.get(),
                ModItems.CHRONITE_BOOTS.get()

        );
        this.tag(ModTags.Items.ADAMANTIUM_ARMOR).add(
                ModItems.ADAMANTIUM_HELMET.get(),
                ModItems.ADAMANTIUM_CHESTPLATE.get(),
                ModItems.ADAMANTIUM_LEGGINGS.get(),
                ModItems.ADAMANTIUM_BOOTS.get()
        );
        this.tag(ModTags.Items.INFERNITE_ARMOR).add(
                ModItems.INFERNITE_HELMET.get(),
                ModItems.INFERNITE_CHESTPLATE.get(),
                ModItems.INFERNITE_LEGGINGS.get(),
                ModItems.INFERNITE_BOOTS.get()
        );
        this.tag(ModTags.Items.AZURITE_ARMOR).add(
                ModItems.AZURITE_HELMET.get(),
                ModItems.AZURITE_CHESTPLATE.get(),
                ModItems.AZURITE_LEGGINGS.get(),
                ModItems.AZURITE_BOOTS.get()
        );
        this.tag(ModTags.Items.ORICHALCUM_INGOT).add(
                ModItems.ORICHALCUM_INGOT.get()
        );
        this.tag(ModTags.Items.MYTHRIL_INGOT).add(
                ModItems.MYTHRIL_INGOT.get()
        );
        this.tag(ModTags.Items.ADAMANTIUM_INGOT).add(
                ModItems.ADAMANTIUM_INGOT.get()
        );
        this.tag(ModTags.Items.INFERNITE_INGOT).add(
                ModItems.INFERNITE_INGOT.get()
        );
        this.tag(ModTags.Items.AZURITE_INGOT).add(
                ModItems.AZURITE_INGOT.get()
        );
        this.tag(ModTags.Items.CHRONITE_INGOT).add(
                ModItems.CHRONITE_INGOT.get()
        );

        this.tag(ModTags.Items.STORAGE_BLOCK).add(
                ModBlocks.RAW_ORICHALCUM_BLOCK.get().asItem(),
                ModBlocks.ORICHALCUM_BLOCK.get().asItem(),
                ModBlocks.RAW_MYTHRIL_BLOCK.get().asItem(),
                ModBlocks.MYTHRIL_BLOCK.get().asItem(),
                ModBlocks.ADAMANTIUM_BLOCK.get().asItem(),
                ModBlocks.CHRONITE_BLOCK.get().asItem(),
                ModBlocks.RAW_INFERNITE_BLOCK.get().asItem(),
                ModBlocks.INFERNITE_BLOCK.get().asItem(),
                ModBlocks.RAW_AZURITE_BLOCK.get().asItem(),
                ModBlocks.AZURITE_BLOCK.get().asItem()
        );
        this.tag(ModTags.Items.STORAGE_BLOCK_ORICHALCUM).add(
                ModBlocks.ORICHALCUM_BLOCK.get().asItem()
        );
        this.tag(ModTags.Items.STORAGE_BLOCK_RAW_ORICHALCUM).add(
                ModBlocks.ORICHALCUM_BLOCK.get().asItem()
        );
        this.tag(ModTags.Items.STORAGE_BLOCK_MYTHRIL).add(
                ModBlocks.RAW_MYTHRIL_BLOCK.get().asItem()
        );
        this.tag(ModTags.Items.STORAGE_BLOCK_RAW_MYTHRIL).add(
                ModBlocks.RAW_MYTHRIL_BLOCK.get().asItem()
        );
        this.tag(ModTags.Items.STORAGE_BLOCK_ADAMANTIUM).add(
                ModBlocks.ADAMANTIUM_BLOCK.get().asItem()
        );
        this.tag(ModTags.Items.STORAGE_BLOCK_INFERNITE).add(
                ModBlocks.INFERNITE_BLOCK.get().asItem()
        );
        this.tag(ModTags.Items.STORAGE_BLOCK_RAW_INFERNITE).add(
                ModBlocks.RAW_INFERNITE_BLOCK.get().asItem()
        );
        this.tag(ModTags.Items.STORAGE_BLOCK_AZURITE).add(
                ModBlocks.AZURITE_BLOCK.get().asItem()
        );
        this.tag(ModTags.Items.STORAGE_BLOCK_RAW_AZURITE).add(
                ModBlocks.RAW_AZURITE_BLOCK.get().asItem()
        );
        this.tag(ModTags.Items.STORAGE_BLOCK_CHRONITE).add(
                ModBlocks.CHRONITE_BLOCK.get().asItem()
        );
    }
}
