package net.rubberduck.mythicalmetals.util;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.rubberduck.mythicalmetals.MythicalMetals;
import net.rubberduck.mythicalmetals.item.ModItems;
import net.rubberduck.mythicalmetals.recipe.ModRecipes;
import net.rubberduck.mythicalmetals.recipe.TemporalTradingRecipe;

import java.util.Arrays;

public class DimensionalTrading {

    public static void temporalEffectTrading(Level level, LivingEntity entity) {
        if (entity instanceof Player player) {

            ItemStack held = player.getMainHandItem();

            var recipes = level.getRecipeManager().getAllRecipesFor(ModRecipes.TEMPORAL_TRADING_TYPE.get());

            for (TemporalTradingRecipe recipe : recipes) {

                if (!level.isClientSide) {
                    if (recipe.matches(held)) {
                        ItemStack result = recipe.getResult();

                        player.getInventory().placeItemBackInInventory(result);

                        if (!player.getAbilities().instabuild) {
                            held.shrink(1);
                        }

                        break;
                    }
                }
            }
        }


    }

}
