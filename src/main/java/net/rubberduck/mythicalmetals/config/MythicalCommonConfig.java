package net.rubberduck.mythicalmetals.config;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.ForgeConfigSpec;

import java.util.List;

public class MythicalCommonConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Boolean> ARMOR_EFFECTS;
    public static final ForgeConfigSpec.ConfigValue<Double> FRACTURED_MULTIPLIER;
    public static final ForgeConfigSpec.ConfigValue<Integer> SCYTHE_RADIUS_MULTIPLIER;
    public static final ForgeConfigSpec.ConfigValue<String> WEEDS;

    static {
        BUILDER.push("Configs for Mythical Metals");

        BUILDER.comment("# Effects");
        ARMOR_EFFECTS = BUILDER.comment(" Should players get effects when wearing full sets of armor")
                .define("Armor Effects Enabled", true);
        FRACTURED_MULTIPLIER = BUILDER.comment(" Multiplier of the Fractured effect.\n This is what percentage of the players max health the players health will drop to, as well as the player's dodge chance while under the Fractured effect.\n Range: 0 -> 0.9")
                .define("Fractured Multiplier", 0.5);

        BUILDER.comment("# Scythe");
        SCYTHE_RADIUS_MULTIPLIER = BUILDER.comment(" What is the radius multiplier of the Scythe?").comment(" The radius of any scythe is the Multiplier * Tier Level")
                .define("Radius Multiplier", 3);
        WEEDS = BUILDER.comment(" What blocks will the Scythe break when mowing").comment(" Default: \"minecraft:grass,minecraft:tall_grass,minecraft:fern,minecraft:large_fern\"").define(
                "Weeds",
                "minecraft:grass,minecraft:tall_grass,minecraft:fern,minecraft:large_fern"
        );
//                .define("Weeds", new Block[]{Blocks.GRASS, Blocks.TALL_GRASS, Blocks.FERN, Blocks.LARGE_FERN}.toString());

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
