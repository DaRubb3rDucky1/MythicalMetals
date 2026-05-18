package net.rubberduck.mythicalmetals.compat;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.runtime.IIngredientManager;
import mezz.jei.api.runtime.IJeiRuntime;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;
import net.rubberduck.mythicalmetals.MythicalMetals;
import net.rubberduck.mythicalmetals.item.ModItems;
import net.rubberduck.mythicalmetals.recipe.ModRecipes;
import net.rubberduck.mythicalmetals.recipe.TemporalTradingRecipe;
import net.rubberduck.mythicalmetals.recipe.TemporalTradingSerializer;

import java.util.List;

@JeiPlugin
public class JEIMythicalPlugin implements IModPlugin {
    public static IJeiRuntime runtime;

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(MythicalMetals.MODID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new TemporalTradingCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void onRuntimeAvailable(IJeiRuntime jeiRuntime) {
        runtime = jeiRuntime;
    }

    @Override
    public void registerRecipes(IRecipeRegistration registry) {
        IIngredientManager ingredientManager = registry.getIngredientManager();
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();
        //ingredientManager.getIngredientType(ItemStack.class);
        ItemStack input = new ItemStack(ModItems.GLITCHED_EYE.get(), 1);

        List<TemporalTradingRecipe> temporalTradingRecipeList = recipeManager.getAllRecipesFor(ModRecipes.TEMPORAL_TRADING_TYPE.get());
        registry.addRecipes(TemporalTradingCategory.TEMPORAL_TRADING_RECIPE_RECIPE_TYPE, temporalTradingRecipeList);

    }


}

