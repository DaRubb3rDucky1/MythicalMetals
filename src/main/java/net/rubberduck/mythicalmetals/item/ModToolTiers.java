package net.rubberduck.mythicalmetals.item;

import net.minecraft.client.tutorial.Tutorial;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.TierSortingRegistry;
import net.rubberduck.mythicalmetals.MythicalMetals;
import net.rubberduck.mythicalmetals.util.ModTags;

import java.util.List;

public class ModToolTiers {
    //netherite from wish
    //dont need to go to nether, less durabilty, slower attack speed, higher damage, much higher defense
    public static final Tier ORICHALCUM = TierSortingRegistry.registerTier(
            new ForgeTier(4, 1578, 9.0F, 4.0F, 15,
                    Tags.Blocks.NEEDS_NETHERITE_TOOL, () -> Ingredient.of(ModItems.CHRONITE_INGOT.get())),
            new ResourceLocation(MythicalMetals.MODID, "orichalcum"), List.of(Tiers.DIAMOND), List.of(Tiers.NETHERITE));
    //stronk and speed
    //slightly higher attack damage, much higher durability, much higher speed, less defense as netherite
    public static final Tier MYTHRIL = TierSortingRegistry.registerTier(
            new ForgeTier(5, 2682, 16.8f, 8.0f, 22,
                    ModTags.Blocks.NEEDS_MAGICAL_TOOL, () -> Ingredient.of(ModItems.MYTHRIL_INGOT.get())),
            new ResourceLocation(MythicalMetals.MODID, "mithril"), List.of(Tiers.NETHERITE), List.of());
    //much stronk
    //higher attack damage, higher durability, higher speed, higher defense than netherite
    public static final Tier CHRONITE = TierSortingRegistry.registerTier(
            new ForgeTier(5, 3760, 10f, 8.0f, 28,
    ModTags.Blocks.NEEDS_MAGICAL_TOOL, () -> Ingredient.of(ModItems.CHRONITE_INGOT.get())),
            new ResourceLocation(MythicalMetals.MODID, "chronite"), List.of(Tiers.NETHERITE), List.of());
    //adamantium
    //nothing for now
    public static final Tier ADAMANTIUM = TierSortingRegistry.registerTier(
            new ForgeTier(5, 3760, 10f, 8f, 22,
                    ModTags.Blocks.NEEDS_MAGICAL_TOOL, () -> Ingredient.of(ModItems.ADAMANTIUM_INGOT.get())),
            new ResourceLocation(MythicalMetals.MODID, "adamantium"), List.of(ModToolTiers.MYTHRIL), List.of());
    //infernite
    //nothing for now
    public static final Tier INFERNITE = TierSortingRegistry.registerTier(
            new ForgeTier(6, 7645, 25f, 2.7f, 32,
                    ModTags.Blocks.NEEDS_HELLISH_TOOL, () -> Ingredient.of(ModItems.INFERNITE_INGOT.get())),
            new ResourceLocation(MythicalMetals.MODID, "infernite"), List.of(ModToolTiers.ADAMANTIUM), List.of());
    //azurite
    //nothing for now
    public static final Tier AZURITE = TierSortingRegistry.registerTier(
            new ForgeTier(7, 7645, 25f, 2.7f, 32,
                    ModTags.Blocks.NEEDS_MAGICAL_TOOL, () -> Ingredient.of(ModItems.AZURITE_INGOT.get())),
            new ResourceLocation(MythicalMetals.MODID, "azurite"), List.of(ModToolTiers.INFERNITE), List.of());

}
