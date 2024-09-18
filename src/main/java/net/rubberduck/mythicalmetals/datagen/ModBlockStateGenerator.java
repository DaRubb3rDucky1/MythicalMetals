package net.rubberduck.mythicalmetals.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.rubberduck.mythicalmetals.MythicalMetals;
import net.rubberduck.mythicalmetals.block.ModBlocks;

public class ModBlockStateGenerator extends BlockStateProvider {

    public ModBlockStateGenerator(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MythicalMetals.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.RAW_ORICHALCUM_BLOCK);
        blockWithItem(ModBlocks.ORICHALCUM_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_ORICHALCUM_ORE);
        blockWithItem(ModBlocks.ORICHALCUM_BLOCK);
        blockWithItem(ModBlocks.CHRONITE_BLOCK);
        blockWithItem(ModBlocks.RAW_MYTHRIL_BLOCK);
        blockWithItem(ModBlocks.MYTHRIL_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_MYTHRIL_ORE);
        blockWithItem(ModBlocks.MYTHRIL_BLOCK);
        blockWithItem(ModBlocks.ADAMANTIUM_BLOCK);
        blockWithItem(ModBlocks.RAW_INFERNITE_BLOCK);
        blockWithItem(ModBlocks.INFERNITE_BLOCK);
        blockWithItem(ModBlocks.INFERNITE_ORE);
        blockWithItem(ModBlocks.AZURITE_BLOCK);
        blockWithItem(ModBlocks.RAW_AZURITE_BLOCK);
        blockWithItem(ModBlocks.AZURITE_ORE);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
