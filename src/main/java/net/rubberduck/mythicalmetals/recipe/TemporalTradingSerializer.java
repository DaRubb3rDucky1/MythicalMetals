package net.rubberduck.mythicalmetals.recipe;

import com.google.gson.JsonObject;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.ForgeRegistries;

public class TemporalTradingSerializer implements RecipeSerializer<TemporalTradingRecipe> {

    @Override
    public TemporalTradingRecipe fromJson(ResourceLocation id, JsonObject json) {
        Ingredient input = Ingredient.fromJson(json.get("input"));

        ResourceLocation outputId = new ResourceLocation(json.get("output").getAsString());
        ItemStack output = new ItemStack(ForgeRegistries.ITEMS.getValue(outputId),
                json.has("count") ? json.get("count").getAsInt() : 1);
        return new TemporalTradingRecipe(input, output, id);
    }

    @Override
    public TemporalTradingRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
        Ingredient input = Ingredient.fromNetwork(buf);
        ItemStack output = buf.readItem();
        return new TemporalTradingRecipe(input, output, id);
    }

    @Override
    public void toNetwork(FriendlyByteBuf buf, TemporalTradingRecipe recipe) {
        recipe.input.toNetwork(buf);
        buf.writeItem(recipe.output);
    }
}
