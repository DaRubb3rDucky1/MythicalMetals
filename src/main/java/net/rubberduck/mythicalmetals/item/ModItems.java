package net.rubberduck.mythicalmetals.item;

import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rubberduck.mythicalmetals.MythicalMetals;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MythicalMetals.MODID);
    //misc
    public static final RegistryObject<Item> DIAMOND_STICK = ITEMS.register("diamond_stick",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FLASH_FROZEN_POWDER = ITEMS.register("flash_frozen_powder",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MOLTEN_PEARL = ITEMS.register("molten_pearl",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GLITCHED_EYE = ITEMS.register("glitched_eye",
            () -> new Item(new Item.Properties()));
    //orichalcum
    public static final RegistryObject<Item> ORICHALCUM_INGOT = ITEMS.register("orichalcum_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_ORICHALCUM = ITEMS.register("raw_orichalcum",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ORICHALCUM_SWORD = ITEMS.register("orichalcum_sword",
            () -> new SwordItem(ModToolTiers.ORICHALCUM, 5, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> ORICHALCUM_PICKAXE = ITEMS.register("orichalcum_pickaxe",
            () -> new PickaxeItem(ModToolTiers.ORICHALCUM, 1, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> ORICHALCUM_AXE = ITEMS.register("orichalcum_axe",
            () -> new AxeItem(ModToolTiers.ORICHALCUM, 7, -3.4f, new Item.Properties()));
    public static final RegistryObject<Item> ORICHALCUM_SHOVEL = ITEMS.register("orichalcum_shovel",
            () -> new ShovelItem(ModToolTiers.ORICHALCUM, 1.5f, -3, new Item.Properties()));
    public static final RegistryObject<Item> ORICHALCUM_HOE = ITEMS.register("orichalcum_hoe",
            () -> new HoeItem(ModToolTiers.ORICHALCUM, -4, 0, new Item.Properties()));
    public static final RegistryObject<Item> ORICHALCUM_SHEARS = ITEMS.register("orichalcum_shears",
            () -> new ShearsItem(new Item.Properties()));
    public static final RegistryObject<Item> ORICHALCUM_SCYTHE = ITEMS.register("orichalcum_scythe",
            () -> new ScytheItem(ModToolTiers.ORICHALCUM, 6, -3, new Item.Properties()));
    public static final RegistryObject<Item> ORICHALCUM_SPEAR = ITEMS.register("orichalcum_spear",
            () -> new TridentItem(new Item.Properties()));
    public static final RegistryObject<Item> ORICHALCUM_HELMET = ITEMS.register("orichalcum_helmet",
            () -> new ModArmorItem(ModArmorMaterials.ORICHALCUM, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> ORICHALCUM_CHESTPLATE = ITEMS.register("orichalcum_chestplate",
            () -> new ArmorItem(ModArmorMaterials.ORICHALCUM, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> ORICHALCUM_LEGGINGS = ITEMS.register("orichalcum_leggings",
            () -> new ArmorItem(ModArmorMaterials.ORICHALCUM, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> ORICHALCUM_BOOTS = ITEMS.register("orichalcum_boots",
            () -> new ArmorItem(ModArmorMaterials.ORICHALCUM, ArmorItem.Type.BOOTS, new Item.Properties()));
    //mythril
    public static final RegistryObject<Item> MYTHRIL_INGOT = ITEMS.register("mythril_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_MYTHRIL = ITEMS.register("raw_mythril",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MYTHRIL_SWORD = ITEMS.register("mythril_sword",
            () -> new SwordItem(ModToolTiers.MYTHRIL, 2, -1.4f, new Item.Properties()));
    public static final RegistryObject<Item> MYTHRIL_PICKAXE = ITEMS.register("mythril_pickaxe",
            () -> new PickaxeItem(ModToolTiers.MYTHRIL, -1, -1.8f, new Item.Properties()));
    public static final RegistryObject<Item> MYTHRIL_AXE = ITEMS.register("mythril_axe",
            () -> new AxeItem(ModToolTiers.MYTHRIL, 4, -2, new Item.Properties()));
    public static final RegistryObject<Item> MYTHRIL_SHOVEL = ITEMS.register("mythril_shovel",
            () -> new ShovelItem(ModToolTiers.MYTHRIL, -1.5f, -2, new Item.Properties()));
    public static final RegistryObject<Item> MYTHRIL_HOE = ITEMS.register("mythril_hoe",
            () -> new HoeItem(ModToolTiers.MYTHRIL, -8, 1, new Item.Properties()));
    public static final RegistryObject<Item> MYTHRIL_SHEARS = ITEMS.register("mythril_shears",
            () -> new ShearsItem(new Item.Properties()));
    public static final RegistryObject<Item> MYTHRIL_SCYTHE = ITEMS.register("mythril_scythe",
            () -> new ScytheItem(ModToolTiers.MYTHRIL, 3, -1.6f, new Item.Properties()));
    public static final RegistryObject<Item> MYTHRIL_SPEAR = ITEMS.register("mythril_spear",
            () -> new TridentItem(new Item.Properties()));
    public static final RegistryObject<Item> MYTHRIL_HELMET = ITEMS.register("mythril_helmet",
            () -> new ModArmorItem(ModArmorMaterials.MYTHRIL, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> MYTHRIL_CHESTPLATE = ITEMS.register("mythril_chestplate",
            () -> new ArmorItem(ModArmorMaterials.MYTHRIL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> MYTHRIL_LEGGINGS = ITEMS.register("mythril_leggings",
            () -> new ArmorItem(ModArmorMaterials.MYTHRIL, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> MYTHRIL_BOOTS = ITEMS.register("mythril_boots",
            () -> new ArmorItem(ModArmorMaterials.MYTHRIL, ArmorItem.Type.BOOTS, new Item.Properties()));
    //chronite
    public static final RegistryObject<Item> CHRONITE_INGOT = ITEMS.register("chronite_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CHRONITE_SWORD = ITEMS.register("chronite_sword",
            () -> new SwordItem(ModToolTiers.CHRONITE, 4, -2.4f, new Item.Properties()));
    public static final RegistryObject<Item> CHRONITE_PICKAXE = ITEMS.register("chronite_pickaxe",
            () -> new PickaxeItem(ModToolTiers.CHRONITE, 1, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> CHRONITE_AXE = ITEMS.register("chronite_axe",
            () -> new AxeItem(ModToolTiers.CHRONITE, 7, -3, new Item.Properties()));
    public static final RegistryObject<Item> CHRONITE_SHOVEL = ITEMS.register("chronite_shovel",
            () -> new ShovelItem(ModToolTiers.CHRONITE, 1.5f, -3, new Item.Properties()));
    public static final RegistryObject<Item> CHRONITE_HOE = ITEMS.register("chronite_hoe",
            () -> new HoeItem(ModToolTiers.CHRONITE, -7, 0, new Item.Properties()));
    public static final RegistryObject<Item> CHRONITE_SHEARS = ITEMS.register("chronite_shears",
            () -> new ShearsItem(new Item.Properties()));
    public static final RegistryObject<Item> CHRONITE_SCYTHE = ITEMS.register("chronite_scythe",
            () -> new ScytheItem(ModToolTiers.CHRONITE, 5, -2.6f, new Item.Properties()));
    public static final RegistryObject<Item> CHRONITE_SPEAR = ITEMS.register("chronite_spear",
            () -> new TridentItem(new Item.Properties()));
    public static final RegistryObject<Item> CHRONITE_HELMET = ITEMS.register("chronite_helmet",
            () -> new ModArmorItem(ModArmorMaterials.CHRONITE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> CHRONITE_CHESTPLATE = ITEMS.register("chronite_chestplate",
            () -> new ArmorItem(ModArmorMaterials.CHRONITE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> CHRONITE_LEGGINGS = ITEMS.register("chronite_leggings",
            () -> new ArmorItem(ModArmorMaterials.CHRONITE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> CHRONITE_BOOTS = ITEMS.register("chronite_boots",
            () -> new ArmorItem(ModArmorMaterials.CHRONITE, ArmorItem.Type.BOOTS, new Item.Properties()));
    //adamantium
    public static final RegistryObject<Item> ADAMANTIUM_INGOT = ITEMS.register("adamantium_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ADAMANTIUM_SWORD = ITEMS.register("adamantium_sword",
            () -> new SwordItem(ModToolTiers.ADAMANTIUM, 4, -2.4f, new Item.Properties()));
    public static final RegistryObject<Item> ADAMANTIUM_PICKAXE = ITEMS.register("adamantium_pickaxe",
            () -> new PickaxeItem(ModToolTiers.ADAMANTIUM, 1, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> ADAMANTIUM_AXE = ITEMS.register("adamantium_axe",
            () -> new AxeItem(ModToolTiers.ADAMANTIUM, 7, -3, new Item.Properties()));
    public static final RegistryObject<Item> ADAMANTIUM_SHOVEL = ITEMS.register("adamantium_shovel",
            () -> new ShovelItem(ModToolTiers.ADAMANTIUM, 1.5f, -3, new Item.Properties()));
    public static final RegistryObject<Item> ADAMANTIUM_HOE = ITEMS.register("adamantium_hoe",
            () -> new HoeItem(ModToolTiers.ADAMANTIUM, -7, 0, new Item.Properties()));
    public static final RegistryObject<Item> ADAMANTIUM_SHEARS = ITEMS.register("adamantium_shears",
            () -> new ShearsItem(new Item.Properties()));
    public static final RegistryObject<Item> ADAMANTIUM_SCYTHE = ITEMS.register("adamantium_scythe",
            () -> new ScytheItem(ModToolTiers.ADAMANTIUM, 5, -2.6f, new Item.Properties()));
    public static final RegistryObject<Item> ADAMANTIUM_SPEAR = ITEMS.register("adamantium_spear",
            () -> new TridentItem(new Item.Properties()));
    public static final RegistryObject<Item> ADAMANTIUM_HELMET = ITEMS.register("adamantium_helmet",
            () -> new ModArmorItem(ModArmorMaterials.ADAMANTIUM, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> ADAMANTIUM_CHESTPLATE = ITEMS.register("adamantium_chestplate",
            () -> new ArmorItem(ModArmorMaterials.ADAMANTIUM, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> ADAMANTIUM_LEGGINGS = ITEMS.register("adamantium_leggings",
            () -> new ArmorItem(ModArmorMaterials.ADAMANTIUM, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> ADAMANTIUM_BOOTS = ITEMS.register("adamantium_boots",
            () -> new ArmorItem(ModArmorMaterials.ADAMANTIUM, ArmorItem.Type.BOOTS, new Item.Properties()));
    //infernite
    public static final RegistryObject<Item> INFERNITE_INGOT = ITEMS.register("infernite_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_INFERNITE = ITEMS.register("raw_infernite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INFERNITE_SWORD = ITEMS.register("infernite_sword",
            () -> new SwordItem(ModToolTiers.INFERNITE, 7, -2.4f, new Item.Properties()));
    public static final RegistryObject<Item> INFERNITE_PICKAXE = ITEMS.register("infernite_pickaxe",
            () -> new PickaxeItem(ModToolTiers.INFERNITE, 1, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> INFERNITE_AXE = ITEMS.register("infernite_axe",
            () -> new AxeItem(ModToolTiers.INFERNITE, 10.3f, -3, new Item.Properties()));
    public static final RegistryObject<Item> INFERNITE_SHOVEL = ITEMS.register("infernite_shovel",
            () -> new ShovelItem(ModToolTiers.INFERNITE, 1.5f, -3, new Item.Properties()));
    public static final RegistryObject<Item> INFERNITE_HOE = ITEMS.register("infernite_hoe",
            () -> new HoeItem(ModToolTiers.INFERNITE, -7, 0, new Item.Properties()));
    public static final RegistryObject<Item> INFERNITE_SHEARS = ITEMS.register("infernite_shears",
            () -> new ShearsItem(new Item.Properties()));
    public static final RegistryObject<Item> INFERNITE_SCYTHE = ITEMS.register("infernite_scythe",
            () -> new ScytheItem(ModToolTiers.INFERNITE, 5, -2.6f, new Item.Properties()));
    public static final RegistryObject<Item> INFERNITE_SPEAR = ITEMS.register("infernite_spear",
            () -> new TridentItem(new Item.Properties()));
    public static final RegistryObject<Item> INFERNITE_HELMET = ITEMS.register("infernite_helmet",
            () -> new ModArmorItem(ModArmorMaterials.INFERNITE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> INFERNITE_CHESTPLATE = ITEMS.register("infernite_chestplate",
            () -> new ArmorItem(ModArmorMaterials.INFERNITE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> INFERNITE_LEGGINGS = ITEMS.register("infernite_leggings",
            () -> new ArmorItem(ModArmorMaterials.INFERNITE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> INFERNITE_BOOTS = ITEMS.register("infernite_boots",
            () -> new ArmorItem(ModArmorMaterials.INFERNITE, ArmorItem.Type.BOOTS, new Item.Properties()));
    //azurite
    public static final RegistryObject<Item> AZURITE_INGOT = ITEMS.register("azurite_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_AZURITE = ITEMS.register("raw_azurite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> AZURITE_SWORD = ITEMS.register("azurite_sword",
            () -> new SwordItem(ModToolTiers.AZURITE, 4, -2.4f, new Item.Properties()));
    public static final RegistryObject<Item> AZURITE_PICKAXE = ITEMS.register("azurite_pickaxe",
            () -> new PickaxeItem(ModToolTiers.AZURITE, 1, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> AZURITE_AXE = ITEMS.register("azurite_axe",
            () -> new AxeItem(ModToolTiers.AZURITE, 7, -3, new Item.Properties()));
    public static final RegistryObject<Item> AZURITE_SHOVEL = ITEMS.register("azurite_shovel",
            () -> new ShovelItem(ModToolTiers.AZURITE, 1.5f, -3, new Item.Properties()));
    public static final RegistryObject<Item> AZURITE_HOE = ITEMS.register("azurite_hoe",
            () -> new HoeItem(ModToolTiers.AZURITE, -7, 0, new Item.Properties()));
    public static final RegistryObject<Item> AZURITE_SHEARS = ITEMS.register("azurite_shears",
            () -> new ShearsItem(new Item.Properties()));
    public static final RegistryObject<Item> AZURITE_SCYTHE = ITEMS.register("azurite_scythe",
            () -> new ScytheItem(ModToolTiers.AZURITE, 5, -2.6f, new Item.Properties()));
    public static final RegistryObject<Item> AZURITE_SPEAR = ITEMS.register("azurite_spear",
            () -> new TridentItem(new Item.Properties()));
    public static final RegistryObject<Item> AZURITE_HELMET = ITEMS.register("azurite_helmet",
            () -> new ModArmorItem(ModArmorMaterials.AZURITE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> AZURITE_CHESTPLATE = ITEMS.register("azurite_chestplate",
            () -> new ArmorItem(ModArmorMaterials.AZURITE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> AZURITE_LEGGINGS = ITEMS.register("azurite_leggings",
            () -> new ArmorItem(ModArmorMaterials.AZURITE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> AZURITE_BOOTS = ITEMS.register("azurite_boots",
            () -> new ArmorItem(ModArmorMaterials.AZURITE, ArmorItem.Type.BOOTS, new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
