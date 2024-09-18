package net.rubberduck.mythicalmetals.potion;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rubberduck.mythicalmetals.MythicalMetals;
import net.rubberduck.mythicalmetals.effects.ModEffects;
import net.rubberduck.mythicalmetals.item.ModItems;
import net.rubberduck.mythicalmetals.util.BetterBrewingRecipe;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS
            = DeferredRegister.create(ForgeRegistries.POTIONS, MythicalMetals.MODID);

    public static final RegistryObject<Potion> FRACTURED_POTION = POTIONS.register("fractured_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.FRACTURED.get(), 4800, 0)));

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }

}


