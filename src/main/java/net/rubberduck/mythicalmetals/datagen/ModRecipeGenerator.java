package net.rubberduck.mythicalmetals.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.brewing.BrewingRecipe;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.rubberduck.mythicalmetals.MythicalMetals;
import net.rubberduck.mythicalmetals.block.ModBlocks;
import net.rubberduck.mythicalmetals.item.ModItems;
import net.rubberduck.mythicalmetals.potion.ModPotions;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ModRecipeGenerator extends RecipeProvider implements IConditionBuilder {
    public ModRecipeGenerator(PackOutput pOutput) {
        super(pOutput);
    }

    public static final List<ItemLike> OrichalcumSmelts = List.of(
            ModItems.RAW_ORICHALCUM.get(),
            ModBlocks.ORICHALCUM_ORE.get(),
            ModBlocks.DEEPSLATE_ORICHALCUM_ORE.get()
    );
    public static final List<ItemLike> MythrilSmelts = List.of(
            ModItems.RAW_MYTHRIL.get(),
            ModBlocks.MYTHRIL_ORE.get(),
            ModBlocks.DEEPSLATE_MYTHRIL_ORE.get()
    );
    public static final List<ItemLike> InferniteSmelts = List.of(
            ModItems.RAW_INFERNITE.get(),
            ModBlocks.INFERNITE_ORE.get()
    );
    public static final List<ItemLike> AzuriteSmelts = List.of(
            ModItems.RAW_AZURITE.get(),
            ModBlocks.AZURITE_ORE.get()
    );


    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.DIAMOND_STICK.get())
                .pattern("  D")
                .pattern(" S ")
                .pattern("D  ")
                .define('D', Items.DIAMOND)
                .define('S', Items.STICK)
                .unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND))
                .save(consumer, MythicalMetals.MODID + ":diamond_stick_craft");
        SimpleCookingRecipeBuilder
                .generic(Ingredient.of(new ItemLike[]{Items.ENDER_PEARL}), RecipeCategory.BREWING, ModItems.MOLTEN_PEARL.get(), 10.0f, 1200, RecipeSerializer.BLASTING_RECIPE)
                .unlockedBy(getHasName(Items.ENDER_PEARL), has(Items.ENDER_PEARL))
                .save(consumer, MythicalMetals.MODID + ":ender_pearl_melting");
        ShapedRecipeBuilder.shaped(RecipeCategory.BREWING, ModItems.FLASH_FROZEN_POWDER.get())
                .pattern("BEB")
                .pattern("EZE")
                .pattern("BEB")
                .define('B', Items.BLUE_ICE)
                .define('E', Items.PRISMARINE_SHARD)
                .define('Z', Items.BLAZE_POWDER)
                .unlockedBy(getHasName(Items.BLAZE_POWDER), has(Items.BLAZE_POWDER))
                .save(consumer, MythicalMetals.MODID + ":blaze_powder_freezing");
        ShapedRecipeBuilder.shaped(RecipeCategory.BREWING, ModItems.GLITCHED_EYE.get())
                .pattern("FMF")
                .pattern("MEM")
                .pattern("FMF")
                .define('F', ModItems.FLASH_FROZEN_POWDER.get())
                .define('M', ModItems.MOLTEN_PEARL.get())
                .define('E', Items.ENDER_EYE)
                .unlockedBy(getHasName(Items.ENDER_EYE), has(Items.ENDER_EYE))
                .save(consumer, MythicalMetals.MODID + ":glitched_pearl_crafting");

        compact(consumer, ModItems.ORICHALCUM_INGOT.get(), ModBlocks.ORICHALCUM_BLOCK.get());
        compact(consumer, ModItems.RAW_ORICHALCUM.get(), ModBlocks.RAW_ORICHALCUM_BLOCK.get());
        toolsCraft(consumer, ModItems.ORICHALCUM_INGOT.get(), ModItems.ORICHALCUM_SWORD.get(), ModItems.ORICHALCUM_PICKAXE.get(), ModItems.ORICHALCUM_AXE.get(), ModItems.ORICHALCUM_SHOVEL.get(), ModItems.ORICHALCUM_HOE.get(), ModItems.ORICHALCUM_SHEARS.get(), ModItems.ORICHALCUM_SCYTHE.get(), ModItems.ORICHALCUM_SPEAR.get(), ModItems.ORICHALCUM_HELMET.get(), ModItems.ORICHALCUM_CHESTPLATE.get(), ModItems.ORICHALCUM_LEGGINGS.get(), ModItems.ORICHALCUM_BOOTS.get());
        oreSmelting(consumer, OrichalcumSmelts, RecipeCategory.MISC, ModItems.ORICHALCUM_INGOT.get(), 0.25f, 200, "orichalcum");
        oreBlasting(consumer, OrichalcumSmelts, RecipeCategory.MISC, ModItems.ORICHALCUM_INGOT.get(), 0.25f, 100, "orichalcum");

        compact(consumer, ModItems.CHRONITE_INGOT.get(), ModBlocks.CHRONITE_BLOCK.get());
        toolsCraft(consumer, ModItems.CHRONITE_INGOT.get(), ModItems.CHRONITE_SWORD.get(), ModItems.CHRONITE_PICKAXE.get(), ModItems.CHRONITE_AXE.get(), ModItems.CHRONITE_SHOVEL.get(), ModItems.CHRONITE_HOE.get(), ModItems.CHRONITE_SHEARS.get(), ModItems.CHRONITE_SCYTHE.get(), ModItems.CHRONITE_SPEAR.get(), ModItems.CHRONITE_HELMET.get(), ModItems.CHRONITE_CHESTPLATE.get(), ModItems.CHRONITE_LEGGINGS.get(), ModItems.CHRONITE_BOOTS.get());

        compact(consumer, ModItems.MYTHRIL_INGOT.get(), ModBlocks.MYTHRIL_BLOCK.get());
        compact(consumer, ModItems.RAW_MYTHRIL.get(), ModBlocks.RAW_MYTHRIL_BLOCK.get());
        toolsCraft(consumer, ModItems.MYTHRIL_INGOT.get(), ModItems.MYTHRIL_SWORD.get(), ModItems.MYTHRIL_PICKAXE.get(), ModItems.MYTHRIL_AXE.get(), ModItems.MYTHRIL_SHOVEL.get(), ModItems.MYTHRIL_HOE.get(), ModItems.MYTHRIL_SHEARS.get(), ModItems.MYTHRIL_SCYTHE.get(), ModItems.MYTHRIL_SPEAR.get(), ModItems.MYTHRIL_HELMET.get(), ModItems.MYTHRIL_CHESTPLATE.get(), ModItems.MYTHRIL_LEGGINGS.get(), ModItems.MYTHRIL_BOOTS.get());
        oreSmelting(consumer, MythrilSmelts, RecipeCategory.MISC, ModItems.MYTHRIL_INGOT.get(), 0.25f, 200, "mythril");
        oreBlasting(consumer, MythrilSmelts, RecipeCategory.MISC, ModItems.MYTHRIL_INGOT.get(), 0.25f, 100, "mythril");

        compact(consumer, ModItems.ADAMANTIUM_INGOT.get(), ModBlocks.ADAMANTIUM_BLOCK.get());
        toolsCraft(consumer, ModItems.ADAMANTIUM_INGOT.get(), ModItems.ADAMANTIUM_SWORD.get(), ModItems.ADAMANTIUM_PICKAXE.get(), ModItems.ADAMANTIUM_AXE.get(), ModItems.ADAMANTIUM_SHOVEL.get(), ModItems.ADAMANTIUM_HOE.get(), ModItems.ADAMANTIUM_SHEARS.get(), ModItems.ADAMANTIUM_SCYTHE.get(), ModItems.ADAMANTIUM_SPEAR.get(), ModItems.ADAMANTIUM_HELMET.get(), ModItems.ADAMANTIUM_CHESTPLATE.get(), ModItems.ADAMANTIUM_LEGGINGS.get(), ModItems.ADAMANTIUM_BOOTS.get());

        compact(consumer, ModItems.INFERNITE_INGOT.get(), ModBlocks.INFERNITE_BLOCK.get());
        compact(consumer, ModItems.RAW_INFERNITE.get(), ModBlocks.RAW_INFERNITE_BLOCK.get());
        toolsCraft(consumer, ModItems.INFERNITE_INGOT.get(), ModItems.INFERNITE_SWORD.get(), ModItems.INFERNITE_PICKAXE.get(), ModItems.INFERNITE_AXE.get(), ModItems.INFERNITE_SHOVEL.get(), ModItems.INFERNITE_HOE.get(), ModItems.INFERNITE_SHEARS.get(), ModItems.INFERNITE_SCYTHE.get(), ModItems.INFERNITE_SPEAR.get(), ModItems.INFERNITE_HELMET.get(), ModItems.INFERNITE_CHESTPLATE.get(), ModItems.INFERNITE_LEGGINGS.get(), ModItems.INFERNITE_BOOTS.get());
        oreSmelting(consumer, InferniteSmelts, RecipeCategory.MISC, ModItems.INFERNITE_INGOT.get(), 0.25f, 200, "infernite");
        oreBlasting(consumer, InferniteSmelts, RecipeCategory.MISC, ModItems.INFERNITE_INGOT.get(), 0.25f, 100, "infernite");

        compact(consumer, ModItems.AZURITE_INGOT.get(), ModBlocks.AZURITE_BLOCK.get());
        compact(consumer, ModItems.RAW_AZURITE.get(), ModBlocks.RAW_AZURITE_BLOCK.get());
        toolsCraft(consumer, ModItems.AZURITE_INGOT.get(), ModItems.AZURITE_SWORD.get(), ModItems.AZURITE_PICKAXE.get(), ModItems.AZURITE_AXE.get(), ModItems.AZURITE_SHOVEL.get(), ModItems.AZURITE_HOE.get(), ModItems.AZURITE_SHEARS.get(), ModItems.AZURITE_SCYTHE.get(), ModItems.AZURITE_SPEAR.get(), ModItems.AZURITE_HELMET.get(), ModItems.AZURITE_CHESTPLATE.get(), ModItems.AZURITE_LEGGINGS.get(), ModItems.AZURITE_BOOTS.get());
        oreSmelting(consumer, AzuriteSmelts, RecipeCategory.MISC, ModItems.AZURITE_INGOT.get(), 0.25f, 200, "azurite");
        oreBlasting(consumer, AzuriteSmelts, RecipeCategory.MISC, ModItems.AZURITE_INGOT.get(), 0.25f, 100, "azurite");

    }

    protected static void compact(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike ingot, ItemLike block) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, block)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ingot)
                .unlockedBy(getHasName(ingot), has(ingot))
                .save(pFinishedRecipeConsumer, MythicalMetals.MODID + ":compacting" + getItemName(ingot));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ingot, 9)
                .requires(block)
                .unlockedBy(getHasName(block), has(block))
                .save(pFinishedRecipeConsumer, MythicalMetals.MODID + ":uncompacting" + getItemName(block));
    }
    protected static void toolsCraft(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike ingot, ItemLike sword, ItemLike pickaxe, ItemLike axe, ItemLike shovel, ItemLike hoe, ItemLike shears, ItemLike scythe, ItemLike spear, ItemLike helmet, ItemLike chestplete, ItemLike leggings, ItemLike boots) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, sword)
                .pattern(" I ")
                .pattern(" I ")
                .pattern(" S ")
                .define('S', ModItems.DIAMOND_STICK.get())
                .define('I', ingot)
                .unlockedBy(getHasName(ingot), has(ingot))
                .save(pFinishedRecipeConsumer, MythicalMetals.MODID + ":" + getItemName(sword) + "_craft");
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, pickaxe)
                .pattern("III")
                .pattern(" S ")
                .pattern(" S ")
                .define('S', ModItems.DIAMOND_STICK.get())
                .define('I', ingot)
                .unlockedBy(getHasName(ingot), has(ingot))
                .save(pFinishedRecipeConsumer, MythicalMetals.MODID + ":" + getItemName(pickaxe) + "_craft");
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, axe)
                .pattern("II")
                .pattern("IS")
                .pattern(" S")
                .define('S', ModItems.DIAMOND_STICK.get())
                .define('I', ingot)
                .unlockedBy(getHasName(ingot), has(ingot))
                .save(pFinishedRecipeConsumer, MythicalMetals.MODID + ":" + getItemName(axe) + "_craft");
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, axe)
                .pattern("II")
                .pattern("SI")
                .pattern("S ")
                .define('S', ModItems.DIAMOND_STICK.get())
                .define('I', ingot)
                .unlockedBy(getHasName(ingot), has(ingot))
                .save(pFinishedRecipeConsumer, MythicalMetals.MODID + ":" + getItemName(axe) + "_craft_alt");
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, shovel)
                .pattern("I")
                .pattern("S")
                .pattern("S")
                .define('S', ModItems.DIAMOND_STICK.get())
                .define('I', ingot)
                .unlockedBy(getHasName(ingot), has(ingot))
                .save(pFinishedRecipeConsumer, MythicalMetals.MODID + ":" + getItemName(shovel) + "_craft");
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, hoe)
                .pattern("II")
                .pattern(" S")
                .pattern(" S")
                .define('S', ModItems.DIAMOND_STICK.get())
                .define('I', ingot)
                .unlockedBy(getHasName(ingot), has(ingot))
                .save(pFinishedRecipeConsumer, MythicalMetals.MODID + ":" + getItemName(hoe) + "_craft");
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, shears)
                .pattern("SI")
                .pattern("IS")
                .define('S', Items.DIAMOND)
                .define('I', ingot)
                .unlockedBy(getHasName(ingot), has(ingot))
                .save(pFinishedRecipeConsumer, MythicalMetals.MODID + ":" + getItemName(shears) + "_craft");
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, shears)
                .pattern("IS")
                .pattern("SI")
                .define('S', Items.DIAMOND)
                .define('I', ingot)
                .unlockedBy(getHasName(ingot), has(ingot))
                .save(pFinishedRecipeConsumer, MythicalMetals.MODID + ":" + getItemName(shears) + "alt");
        customToolsCraft(pFinishedRecipeConsumer, ingot, ModItems.DIAMOND_STICK.get(), scythe, hoe, spear);
//        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, shears)
//                .pattern("SI")
//                .pattern("IS")
//                .pattern("IS")
//                .define('S', Items.DIAMOND)
//                .define('I', ingot)
//                .unlockedBy(getHasName(ingot), has(ingot))
//                .save(pFinishedRecipeConsumer, MythicalMetals.MODID + ":" + getItemName(shears) + "_craft");
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, helmet)
                .pattern("III")
                .pattern("I I")
                .define('I', ingot)
                .unlockedBy(getHasName(ingot), has(ingot))
                .save(pFinishedRecipeConsumer, MythicalMetals.MODID + ":" + getItemName(helmet) + "_craft");
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, chestplete)
                .pattern("I I")
                .pattern("III")
                .pattern("III")
                .define('I', ingot)
                .unlockedBy(getHasName(ingot), has(ingot))
                .save(pFinishedRecipeConsumer, MythicalMetals.MODID + ":" + getItemName(chestplete) + "_craft");
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, leggings)
                .pattern("III")
                .pattern("I I")
                .pattern("I I")
                .define('I', ingot)
                .unlockedBy(getHasName(ingot), has(ingot))
                .save(pFinishedRecipeConsumer, MythicalMetals.MODID + ":" + getItemName(leggings) + "_craft");
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, boots)
                .pattern("I I")
                .pattern("I I")
                .define('I', ingot)
                .unlockedBy(getHasName(ingot), has(ingot))
                .save(pFinishedRecipeConsumer, MythicalMetals.MODID + ":" + getItemName(boots) + "_craft");

    }

    protected static void customToolsCraft(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike ingot, ItemLike stick, ItemLike scythe, ItemLike hoe, ItemLike spear) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, scythe)
                .pattern("II ")
                .pattern(" HI")
                .pattern("S  ")
                .define('S', stick)
                .define('I', ingot)
                .define('H', hoe)
                .unlockedBy(getHasName(ingot), has(ingot))
                .save(pFinishedRecipeConsumer, MythicalMetals.MODID + ":" + getItemName(scythe) + "_craft");
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, spear)
                .pattern("  I")
                .pattern(" S ")
                .pattern("S  ")
                .define('S', stick)
                .define('I', ingot)
                .unlockedBy(getHasName(ingot), has(ingot))
                .save(pFinishedRecipeConsumer, MythicalMetals.MODID + ":" + getItemName(spear) + "_craft");
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }
    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        Iterator var9 = pIngredients.iterator();

        while(var9.hasNext()) {
            ItemLike itemlike = (ItemLike)var9.next();
            SimpleCookingRecipeBuilder
                    .generic(Ingredient.of(new ItemLike[]{itemlike}), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, MythicalMetals.MODID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
