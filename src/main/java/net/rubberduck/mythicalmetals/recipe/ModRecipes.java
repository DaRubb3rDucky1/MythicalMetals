package net.rubberduck.mythicalmetals.recipe;

import com.google.gson.JsonObject;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rubberduck.mythicalmetals.MythicalMetals;

public class ModRecipes {

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
        TYPES.register(eventBus);
        MythicalMetals.LOGGER.debug("Registered MythicalMetals recipes");
    }

    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, MythicalMetals.MODID);

    public static final DeferredRegister<RecipeType<?>> TYPES =
            DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, MythicalMetals.MODID);

    public static final RegistryObject<RecipeSerializer<TemporalTradingRecipe>> TEMPORAL_TRADING_SERIALIZER =
            SERIALIZERS.register("temporal_trading", TemporalTradingSerializer::new);

    public static final RegistryObject<RecipeType<TemporalTradingRecipe>> TEMPORAL_TRADING_TYPE =
            TYPES.register("temporal_trading", () -> new RecipeType<>() {
                public String toString() {
                    return "temporal_trading";
                }
            });

}
