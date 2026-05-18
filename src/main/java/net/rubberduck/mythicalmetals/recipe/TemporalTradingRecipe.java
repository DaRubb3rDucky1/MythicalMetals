package net.rubberduck.mythicalmetals.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class TemporalTradingRecipe implements Recipe<Container> {
    final Ingredient input;
    final ItemStack output;
    private final ResourceLocation id;

    public TemporalTradingRecipe(Ingredient input, ItemStack output, ResourceLocation id) {
        this.input = input;
        this.output = output;
        this.id = id;
    }

    public boolean matches(ItemStack stack) {
        return input.test(stack);
    }

    public Ingredient getInput() {
        return input;
    }

    public ItemStack getResult() {
        return output.copy();
    }

    @Override
    public boolean matches(Container pContainer, Level pLevel) {
        return false;
    }

    @Override
    public ItemStack assemble(Container pContainer, RegistryAccess pRegistryAccess) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return false;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess pRegistryAccess) {
        return output;
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.TEMPORAL_TRADING_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.TEMPORAL_TRADING_TYPE.get();
    }

}
