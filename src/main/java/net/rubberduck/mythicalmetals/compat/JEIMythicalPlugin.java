package net.rubberduck.mythicalmetals.compat;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.runtime.IIngredientManager;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.rubberduck.mythicalmetals.MythicalMetals;
import net.rubberduck.mythicalmetals.item.ModItems;

import java.util.List;

@JeiPlugin
public class JEIMythicalPlugin implements IModPlugin {

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(MythicalMetals.MODID, "jei_plugin");
    }

    @Override
    public void registerRecipes(IRecipeRegistration registry) {
        IIngredientManager ingredientManager = registry.getIngredientManager();
        //ingredientManager.getIngredientType(ItemStack.class);
        ItemStack input = new ItemStack(ModItems.CHRONITE_INGOT.get(), 1);

        registry.addItemStackInfo(input, Component.literal("Chronite ingots can be obtained by holding iron blocks while under the Fractured effect"));

    }
}

