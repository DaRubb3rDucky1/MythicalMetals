package net.rubberduck.mythicalmetals.util;

import net.minecraft.world.damagesource.*;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.rubberduck.mythicalmetals.MythicalMetals;
import net.rubberduck.mythicalmetals.config.MythicalCommonConfig;
import net.rubberduck.mythicalmetals.damage.ModDamageSource;
import net.rubberduck.mythicalmetals.effects.ModEffects;

import java.util.Objects;
import java.util.Random;

@Mod.EventBusSubscriber(modid = MythicalMetals.MODID)
public class MythicalDamageHandler {

    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        LivingEntity entity = event.getEntity();
        if (!(entity.level().isClientSide()) && event.getEntity().hasEffect(ModEffects.FRACTURED.get()) && !event.getSource().is(ModDamageSource.FRACTURING)) {
            double dodgeChance = MythicalCommonConfig.FRACTURED_MULTIPLIER.get();
            dodgeChance = Math.min(dodgeChance, 0.9F);
            dodgeChance = Math.max(dodgeChance, 0F);
            float randFloat = entity.getRandom().nextFloat();
            MythicalMetals.LOGGER.debug("blep: " + dodgeChance + " bwop: " + randFloat);
            if (randFloat <= dodgeChance) {
                event.setAmount(0F);
                event.setCanceled(true);
//                MythicalMetals.LOGGER.debug("True!");
            }

        }

    }

}