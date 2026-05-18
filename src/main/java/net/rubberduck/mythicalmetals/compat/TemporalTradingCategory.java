package net.rubberduck.mythicalmetals.compat;

import com.mojang.blaze3d.platform.InputConstants;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.helpers.IJeiHelpers;
import mezz.jei.api.ingredients.IIngredientType;
import mezz.jei.api.recipe.*;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.recipe.vanilla.IJeiBrewingRecipe;
import mezz.jei.api.runtime.IJeiRuntime;
import mezz.jei.api.runtime.IRecipesGui;
import net.mehvahdjukaar.jeed.Jeed;
import net.mehvahdjukaar.jeed.api.JeedAPI;
import net.mehvahdjukaar.jeed.forge.JeedClient;
import net.mehvahdjukaar.jeed.forge.JeedImpl;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.inventory.RecipeHolder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraftforge.common.brewing.IBrewingRecipe;
import net.rubberduck.mythicalmetals.MythicalMetals;
import net.rubberduck.mythicalmetals.effects.ModEffects;
import net.rubberduck.mythicalmetals.item.ModItems;
import net.rubberduck.mythicalmetals.potion.ModPotions;
import net.rubberduck.mythicalmetals.recipe.TemporalTradingRecipe;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TemporalTradingCategory implements IRecipeCategory<TemporalTradingRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(MythicalMetals.MODID, "temporal_trading");
    public static final ResourceLocation TEXTURE = new ResourceLocation(MythicalMetals.MODID, "textures/gui/fractured_recipe.png");
    public static final RecipeType<TemporalTradingRecipe> TEMPORAL_TRADING_RECIPE_RECIPE_TYPE = new RecipeType<>(UID, TemporalTradingRecipe.class);
    private final IDrawable background;
    private final IDrawable icon;

    public TemporalTradingCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 172, 76);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModItems.GLITCHED_EYE.get()));
    }

    @Override
    public RecipeType<TemporalTradingRecipe> getRecipeType() {
        return TEMPORAL_TRADING_RECIPE_RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("recipe.mythicalmetals.temporal_trading");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public List<Component> getTooltipStrings(TemporalTradingRecipe recipe, IRecipeSlotsView recipeSlotsView, double mouseX, double mouseY) {
        if ((mouseX >= 73 && mouseX <= 95) && (mouseY >= 18 && mouseY <= 52)) {
            return List.of(Component.literal("The player must be under the Fractured effect, obtained by drinking the ").setStyle(Style.EMPTY.withColor(ChatFormatting.DARK_PURPLE)).append(
                    Component.literal("Unstable Mixture").setStyle(Style.EMPTY.withColor(6823145))
            ));
        } else {
            return List.of();
        }
    }

    @Override
    public boolean handleInput(TemporalTradingRecipe recipe, double mouseX, double mouseY, InputConstants.Key input) {
        if ((mouseX >= 73 && mouseX <= 95) && (mouseY >= 18 && mouseY <= 52) && (input.getName().equals("key.mouse.left"))) {
            IJeiRuntime jeiRuntime = JEIMythicalPlugin.runtime;
            assert (jeiRuntime != null);
            IRecipesGui recipesGui = jeiRuntime.getRecipesGui();
            IRecipeManager recipeManager = jeiRuntime.getRecipeManager();
            ResourceLocation potionID = new ResourceLocation("minecraft:minecraft_potion_fractured_potion_effect.mythicalmetals.fractured___uration__4800");
            ResourceLocation splashPotionID = new ResourceLocation("minecraft:minecraft_potion_fractured_potion_effect.mythicalmetals.fractured___uration__4800.to.minecraft_splash_potion_fractured_potion_effect.mythicalmetals.fractured___uration__4800");
            ResourceLocation lingerPotionID = new ResourceLocation("minecraft:minecraft_splash_potion_fractured_potion_effect.mythicalmetals.fractured___uration__4800.to.minecraft_lingering_potion_fractured_potion_effect.mythicalmetals.fractured___uration__4800");
            ResourceLocation arrowPotionID = new ResourceLocation("minecraft:jei.tipped.arrow.item.minecraft.tipped_arrow.effect.fractured_potion");
//            Arrays.stream(new Array[]).anyMatch()
            List<ResourceLocation> resourceArray = List.of(potionID, splashPotionID, lingerPotionID, arrowPotionID);

            IFocusFactory focusFactory = jeiRuntime.getJeiHelpers().getFocusFactory();
            List<IFocus<?>> focusList = focusFactory.getEmptyFocusGroup().getAllFocuses();

            RecipeType<IJeiBrewingRecipe> brewingRecipeType = RecipeTypes.BREWING;
            RecipeType<CraftingRecipe> craftingRecipeType = RecipeTypes.CRAFTING;
            IRecipeCategory<IJeiBrewingRecipe> brewingCategory = recipeManager.getRecipeCategory(brewingRecipeType);
            List<IJeiBrewingRecipe> matchingBrewingRecipes = recipeManager
                    .createRecipeLookup(brewingRecipeType)
                    .get()
                    .filter(r -> resourceArray.contains(r.getUid()))
                    .collect(Collectors.toList());

            if (!matchingBrewingRecipes.isEmpty()) {
                if (JEEDMythicalPlugin.isLoaded()) {
                    JEEDMythicalPlugin.invokeEffect(new MobEffectInstance(ModEffects.FRACTURED.get()), mouseX, mouseY);
                } else {
                    recipesGui.showRecipes(brewingCategory, matchingBrewingRecipes, focusList);
                }
            }

            return true;
        } else {
            return false;
        }
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, TemporalTradingRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 31, 30).addIngredients(recipe.getInput()).addTooltipCallback((recipeSlotView, tooltip) -> tooltip.add(2,
                Component.literal("Hold to convert").setStyle(Style.EMPTY.withColor(ChatFormatting.DARK_PURPLE).withItalic(true))
        ));
        builder.addSlot(RecipeIngredientRole.OUTPUT, 121, 30).addItemStack(recipe.getResult());
    }
}
