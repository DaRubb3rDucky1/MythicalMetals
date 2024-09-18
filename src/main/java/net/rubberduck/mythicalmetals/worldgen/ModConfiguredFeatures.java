package net.rubberduck.mythicalmetals.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.rubberduck.mythicalmetals.MythicalMetals;
import net.rubberduck.mythicalmetals.block.ModBlocks;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORICHALCUM_ORE_KEY = registerKey("orichalcum_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MYTHRIL_ORE_KEY = registerKey("mythril_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> INFERNITE_ORE_KEY = registerKey("infernite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> AZURITE_ORE_KEY = registerKey("azurite_ore");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplacables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplacables = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest endstoneReplacables = new BlockMatchTest(Blocks.END_STONE);

        List<OreConfiguration.TargetBlockState> orichalcumOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.ORICHALCUM_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplacables, ModBlocks.DEEPSLATE_ORICHALCUM_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> mythrilOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.MYTHRIL_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplacables, ModBlocks.DEEPSLATE_MYTHRIL_ORE.get().defaultBlockState()));

        register(context, ORICHALCUM_ORE_KEY, Feature.ORE, new OreConfiguration(orichalcumOres, 4));
        register(context, MYTHRIL_ORE_KEY, Feature.ORE, new OreConfiguration(mythrilOres, 4));
        register(context, INFERNITE_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplacables, ModBlocks.INFERNITE_ORE.get().defaultBlockState(), 3));
        register(context, AZURITE_ORE_KEY, Feature.ORE, new OreConfiguration(endstoneReplacables, ModBlocks.AZURITE_ORE.get().defaultBlockState(), 3));

    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(MythicalMetals.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

}
