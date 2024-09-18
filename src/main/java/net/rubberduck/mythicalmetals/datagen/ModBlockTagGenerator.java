package net.rubberduck.mythicalmetals.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.rubberduck.mythicalmetals.MythicalMetals;
import net.rubberduck.mythicalmetals.block.ModBlocks;
import net.rubberduck.mythicalmetals.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MythicalMetals.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                ModBlocks.CHRONITE_BLOCK.get(),
                ModBlocks.ORICHALCUM_BLOCK.get(),
                ModBlocks.ORICHALCUM_ORE.get(),
                ModBlocks.DEEPSLATE_ORICHALCUM_ORE.get(),
                ModBlocks.RAW_ORICHALCUM_BLOCK.get(),
                ModBlocks.DEEPSLATE_MYTHRIL_ORE.get(),
                ModBlocks.MYTHRIL_ORE.get(),
                ModBlocks.RAW_MYTHRIL_BLOCK.get(),
                ModBlocks.MYTHRIL_BLOCK.get(),
                ModBlocks.ADAMANTIUM_BLOCK.get(),
                ModBlocks.INFERNITE_BLOCK.get(),
                ModBlocks.RAW_INFERNITE_BLOCK.get(),
                ModBlocks.INFERNITE_ORE.get(),
                ModBlocks.AZURITE_BLOCK.get(),
                ModBlocks.RAW_AZURITE_BLOCK.get(),
                ModBlocks.AZURITE_ORE.get()
        );
        this.tag(ModTags.Blocks.NEEDS_MAGICAL_TOOL).add(
                ModBlocks.CHRONITE_BLOCK.get(),
                ModBlocks.ADAMANTIUM_BLOCK.get(),
                ModBlocks.INFERNITE_ORE.get(),
                ModBlocks.RAW_INFERNITE_BLOCK.get(),
                ModBlocks.MYTHRIL_BLOCK.get()
        );

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL).add(
                ModBlocks.ORICHALCUM_ORE.get(),
                ModBlocks.DEEPSLATE_ORICHALCUM_ORE.get(),
                ModBlocks.RAW_ORICHALCUM_BLOCK.get()
        );

        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL).add(
                ModBlocks.ORICHALCUM_BLOCK.get(),
                ModBlocks.DEEPSLATE_MYTHRIL_ORE.get(),
                ModBlocks.MYTHRIL_ORE.get(),
                ModBlocks.RAW_MYTHRIL_BLOCK.get()
        );

        this.tag(ModTags.Blocks.NEEDS_HELLISH_TOOL).add(
                ModBlocks.INFERNITE_BLOCK.get(),
                ModBlocks.AZURITE_ORE.get(),
                ModBlocks.RAW_AZURITE_BLOCK.get()
        );
        this.tag(ModTags.Blocks.NEEDS_ENDERIC_TOOL).add(
                ModBlocks.AZURITE_BLOCK.get()
        );
    }


}
