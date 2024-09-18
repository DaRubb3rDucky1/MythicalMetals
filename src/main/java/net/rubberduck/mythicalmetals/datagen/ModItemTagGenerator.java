package net.rubberduck.mythicalmetals.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.rubberduck.mythicalmetals.MythicalMetals;
import net.rubberduck.mythicalmetals.item.ModItems;
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
    }
}
