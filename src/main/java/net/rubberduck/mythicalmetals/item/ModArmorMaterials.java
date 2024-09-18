package net.rubberduck.mythicalmetals.item;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.rubberduck.mythicalmetals.MythicalMetals;

import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {
    //netherite from wish
    //dont need to go to nether, less durabilty, slower attack speed, higher damage, much higher defense
    //tank
    ORICHALCUM("orichalcum", 26, new int[]{5, 11, 9, 5}, 25,
            SoundEvents.ARMOR_EQUIP_NETHERITE, 4f, 0.2f, () -> Ingredient.of(ModItems.ORICHALCUM_INGOT.get())),
    //lighter metal, lower defense, gives speed.
    //
    MYTHRIL("mythril", 26, new int[]{4, 8, 6, 4}, 25,
            SoundEvents.ARMOR_EQUIP_NETHERITE, 1f, 0f, () -> Ingredient.of(ModItems.MYTHRIL_INGOT.get())),
    //
    ADAMANTIUM("adamantium", 26, new int[]{6, 12, 10, 6}, 25,
            SoundEvents.ARMOR_EQUIP_NETHERITE, 1f, 0.2f, () -> Ingredient.of(ModItems.ADAMANTIUM_INGOT.get())),
    //
    CHRONITE("chronite", 26, new int[]{6, 12, 10, 6}, 25,
            SoundEvents.ARMOR_EQUIP_NETHERITE, 1f, 0.2f, () -> Ingredient.of(ModItems.CHRONITE_INGOT.get())),

    INFERNITE("infernite", 26, new int[]{3, 8, 6, 3}, 25,
            SoundEvents.ARMOR_EQUIP_NETHERITE, 1f, 0.2f, () -> Ingredient.of(ModItems.INFERNITE_INGOT.get())),

    AZURITE("azurite", 26, new int[]{3, 8, 6, 3}, 25,
            SoundEvents.ARMOR_EQUIP_NETHERITE, 1f, 0.2f, () -> Ingredient.of(ModItems.AZURITE_INGOT.get()));

    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantmentValue;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    private static final int[] BASE_DURABILITY = new int[] {11, 16, 15, 13};

    ModArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantability, SoundEvent sound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantmentValue = enchantability;
        this.equipSound = sound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurabilityForType(ArmorItem.Type pType) {
        return BASE_DURABILITY[pType.ordinal()] * this.durabilityMultiplier;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type pType) {
        return this.protectionAmounts[pType.ordinal()];
    }

    @Override
    public int getEnchantmentValue() {
        return enchantmentValue;
    }

    @Override
    public SoundEvent getEquipSound() {
        return equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return MythicalMetals.MODID + ":" + name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
