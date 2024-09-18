package net.rubberduck.mythicalmetals.datagen.loot;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;
import net.rubberduck.mythicalmetals.block.ModBlocks;
import net.rubberduck.mythicalmetals.item.ModItems;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }


    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.CHRONITE_BLOCK.get());
        this.add(ModBlocks.ORICHALCUM_ORE.get(),
                block -> createOreDrop(ModBlocks.ORICHALCUM_ORE.get(), ModItems.RAW_ORICHALCUM.get()));
        this.add(ModBlocks.DEEPSLATE_ORICHALCUM_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_ORICHALCUM_ORE.get(), ModItems.RAW_ORICHALCUM.get()));
        this.dropSelf(ModBlocks.ORICHALCUM_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_ORICHALCUM_BLOCK.get());
        this.add(ModBlocks.MYTHRIL_ORE.get(),
                block -> createOreDrop(ModBlocks.MYTHRIL_ORE.get(), ModItems.RAW_MYTHRIL.get()));
        this.add(ModBlocks.DEEPSLATE_MYTHRIL_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_MYTHRIL_ORE.get(), ModItems.RAW_MYTHRIL.get()));
        this.dropSelf(ModBlocks.MYTHRIL_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_MYTHRIL_BLOCK.get());
        this.dropSelf(ModBlocks.ADAMANTIUM_BLOCK.get());
        this.add(ModBlocks.INFERNITE_ORE.get(),
                block -> createOreDrop(ModBlocks.INFERNITE_ORE.get(), ModItems.RAW_INFERNITE.get()));
        this.dropSelf(ModBlocks.INFERNITE_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_INFERNITE_BLOCK.get());
        this.dropSelf(ModBlocks.AZURITE_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_AZURITE_BLOCK.get());
        this.add(ModBlocks.AZURITE_ORE.get(),
                block -> createOreDrop(ModBlocks.AZURITE_ORE.get(), ModItems.RAW_AZURITE.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
