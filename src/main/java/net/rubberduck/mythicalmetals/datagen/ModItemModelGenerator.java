package net.rubberduck.mythicalmetals.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;
import net.rubberduck.mythicalmetals.MythicalMetals;
import net.rubberduck.mythicalmetals.item.ModItems;

import java.util.LinkedHashMap;

public class ModItemModelGenerator extends ItemModelProvider {
    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }

    public ModItemModelGenerator(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MythicalMetals.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItemMisc(ModItems.DIAMOND_STICK);
        simpleItemMisc(ModItems.FLASH_FROZEN_POWDER);
        simpleItemMisc(ModItems.MOLTEN_PEARL);
        simpleItemMisc(ModItems.GLITCHED_EYE);
        //orichalum
        simpleItem(ModItems.RAW_ORICHALCUM, "orichalcum");
        simpleItem(ModItems.ORICHALCUM_INGOT, "orichalcum");
        handheldItem(ModItems.ORICHALCUM_SWORD, "orichalcum");
        handheldItem(ModItems.ORICHALCUM_PICKAXE, "orichalcum");
        handheldItem(ModItems.ORICHALCUM_AXE, "orichalcum");
        handheldItem(ModItems.ORICHALCUM_SHOVEL, "orichalcum");
        handheldItem(ModItems.ORICHALCUM_HOE, "orichalcum");
        handheldItem(ModItems.ORICHALCUM_SHEARS, "orichalcum");
        handheldItem(ModItems.ORICHALCUM_SCYTHE, "orichalcum");
        handheldItem(ModItems.ORICHALCUM_SPEAR, "orichalcum");
        trimmedArmorItem(ModItems.ORICHALCUM_HELMET, "orichalcum");
        trimmedArmorItem(ModItems.ORICHALCUM_CHESTPLATE, "orichalcum");
        trimmedArmorItem(ModItems.ORICHALCUM_LEGGINGS, "orichalcum");
        trimmedArmorItem(ModItems.ORICHALCUM_BOOTS, "orichalcum");
        //mythril
        simpleItem(ModItems.RAW_MYTHRIL, "mythril");
        simpleItem(ModItems.MYTHRIL_INGOT, "mythril");
        handheldItem(ModItems.MYTHRIL_SWORD, "mythril");
        handheldItem(ModItems.MYTHRIL_PICKAXE, "mythril");
        handheldItem(ModItems.MYTHRIL_AXE, "mythril");
        handheldItem(ModItems.MYTHRIL_SHOVEL, "mythril");
        handheldItem(ModItems.MYTHRIL_HOE, "mythril");
        handheldItem(ModItems.MYTHRIL_SHEARS, "mythril");
        handheldItem(ModItems.MYTHRIL_SCYTHE, "mythril");
        handheldItem(ModItems.MYTHRIL_SPEAR, "mythril");
        trimmedArmorItem(ModItems.MYTHRIL_HELMET, "mythril");
        trimmedArmorItem(ModItems.MYTHRIL_CHESTPLATE, "mythril");
        trimmedArmorItem(ModItems.MYTHRIL_LEGGINGS, "mythril");
        trimmedArmorItem(ModItems.MYTHRIL_BOOTS, "mythril");
        //chronite
        simpleItem(ModItems.CHRONITE_INGOT, "chronite");
        handheldItem(ModItems.CHRONITE_SWORD, "chronite");
        handheldItem(ModItems.CHRONITE_PICKAXE, "chronite");
        handheldItem(ModItems.CHRONITE_AXE, "chronite");
        handheldItem(ModItems.CHRONITE_SHOVEL, "chronite");
        handheldItem(ModItems.CHRONITE_HOE, "chronite");
        handheldItem(ModItems.CHRONITE_SHEARS, "chronite");
        handheldItem(ModItems.CHRONITE_SCYTHE, "chronite");
        handheldItem(ModItems.CHRONITE_SPEAR, "chronite");
        trimmedArmorItem(ModItems.CHRONITE_HELMET, "chronite");
        trimmedArmorItem(ModItems.CHRONITE_CHESTPLATE, "chronite");
        trimmedArmorItem(ModItems.CHRONITE_LEGGINGS, "chronite");
        trimmedArmorItem(ModItems.CHRONITE_BOOTS, "chronite");
        //adamantium
        simpleItem(ModItems.ADAMANTIUM_INGOT, "adamantium");
        handheldItem(ModItems.ADAMANTIUM_SWORD, "adamantium");
        handheldItem(ModItems.ADAMANTIUM_PICKAXE, "adamantium");
        handheldItem(ModItems.ADAMANTIUM_AXE, "adamantium");
        handheldItem(ModItems.ADAMANTIUM_SHOVEL, "adamantium");
        handheldItem(ModItems.ADAMANTIUM_HOE, "adamantium");
        handheldItem(ModItems.ADAMANTIUM_SHEARS, "adamantium");
        handheldItem(ModItems.ADAMANTIUM_SCYTHE, "adamantium");
        handheldItem(ModItems.ADAMANTIUM_SPEAR, "adamantium");
        trimmedArmorItem(ModItems.ADAMANTIUM_HELMET, "adamantium");
        trimmedArmorItem(ModItems.ADAMANTIUM_CHESTPLATE, "adamantium");
        trimmedArmorItem(ModItems.ADAMANTIUM_LEGGINGS, "adamantium");
        trimmedArmorItem(ModItems.ADAMANTIUM_BOOTS, "adamantium");
        //infernite
        simpleItem(ModItems.RAW_INFERNITE, "infernite");
        simpleItem(ModItems.INFERNITE_INGOT, "infernite");
        handheldItem(ModItems.INFERNITE_SWORD, "infernite");
        handheldItem(ModItems.INFERNITE_PICKAXE, "infernite");
        handheldItem(ModItems.INFERNITE_AXE, "infernite");
        handheldItem(ModItems.INFERNITE_SHOVEL, "infernite");
        handheldItem(ModItems.INFERNITE_HOE, "infernite");
        handheldItem(ModItems.INFERNITE_SHEARS, "infernite");
        handheldItem(ModItems.INFERNITE_SCYTHE, "infernite");
        handheldItem(ModItems.INFERNITE_SPEAR, "infernite");
        trimmedArmorItem(ModItems.INFERNITE_HELMET, "infernite");
        trimmedArmorItem(ModItems.INFERNITE_CHESTPLATE, "infernite");
        trimmedArmorItem(ModItems.INFERNITE_LEGGINGS, "infernite");
        trimmedArmorItem(ModItems.INFERNITE_BOOTS, "infernite");
        //azurite
        simpleItem(ModItems.RAW_AZURITE, "azurite");
        simpleItem(ModItems.AZURITE_INGOT, "azurite");
        handheldItem(ModItems.AZURITE_SWORD, "azurite");
        handheldItem(ModItems.AZURITE_PICKAXE, "azurite");
        handheldItem(ModItems.AZURITE_AXE, "azurite");
        handheldItem(ModItems.AZURITE_SHOVEL, "azurite");
        handheldItem(ModItems.AZURITE_HOE, "azurite");
        handheldItem(ModItems.AZURITE_SHEARS, "azurite");
        handheldItem(ModItems.AZURITE_SCYTHE, "azurite");
        handheldItem(ModItems.AZURITE_SPEAR, "azurite");
        trimmedArmorItem(ModItems.AZURITE_HELMET, "azurite");
        trimmedArmorItem(ModItems.AZURITE_CHESTPLATE, "azurite");
        trimmedArmorItem(ModItems.AZURITE_LEGGINGS, "azurite");
        trimmedArmorItem(ModItems.AZURITE_BOOTS, "azurite");
    }

    private ItemModelBuilder simpleItemMisc(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(MythicalMetals.MODID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item, String type) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(MythicalMetals.MODID,"item/" + type + "/" + item.getId().getPath()));
    }
    private ItemModelBuilder handheldItem(RegistryObject<Item> item, String type) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(MythicalMetals.MODID,"item/" + type + "/" + item.getId().getPath()));
    }

    // Shoutout to El_Redstoniano for making this, modified by DaRubberDucky1
    private void trimmedArmorItem(RegistryObject<Item> itemRegistryObject, String type) {
        final String MOD_ID = MythicalMetals.MODID; // Change this to your mod id

        if(itemRegistryObject.get() instanceof ArmorItem armorItem) {
            trimMaterials.entrySet().forEach(entry -> {

                ResourceKey<TrimMaterial> trimMaterial = entry.getKey();
                float trimValue = entry.getValue();

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = "item/" + type + "/" + armorItem;
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = new ResourceLocation(MOD_ID, armorItemPath);
                ResourceLocation trimResLoc = new ResourceLocation(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = new ResourceLocation(MOD_ID, currentTrimName);

                // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
                // avoid an IllegalArgumentException
                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                // Trimmed armorItem files
                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc)
                        .texture("layer1", trimResLoc);

                // Non-trimmed armorItem file (normal variant)
                this.withExistingParent(itemRegistryObject.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                new ResourceLocation(MOD_ID,
                                        "item/" + type + "/" + itemRegistryObject.getId().getPath()));
            });
        }
    }
}
