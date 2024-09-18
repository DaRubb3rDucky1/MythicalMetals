package net.rubberduck.mythicalmetals.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rubberduck.mythicalmetals.MythicalMetals;


public class ModEffects extends MobEffects {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, MythicalMetals.MODID);

    public static final RegistryObject<MobEffect> FRACTURED = EFFECTS.register("fractured",
            () -> new FracturedEffect(MobEffectCategory.BENEFICIAL, 0x441791));
    public static final RegistryObject<MobEffect> VOID_WALKER = EFFECTS.register("void_walker",
            () -> new VoidWalkerEffect(MobEffectCategory.BENEFICIAL, 0x97A7FF));

    public static void register(IEventBus modEventBus) {
        EFFECTS.register(modEventBus);
    }

    public static class ModEffect extends MobEffect {
        private ModEffect(MobEffectCategory category, int color) {
            super (category, color);
        }
    }


}
