package net.rubberduck.mythicalmetals.effects;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.rubberduck.mythicalmetals.config.MythicalCommonConfig;
import net.rubberduck.mythicalmetals.damage.ModDamageSource;
import net.rubberduck.mythicalmetals.item.ModItems;
import net.rubberduck.mythicalmetals.util.DimensionalTrading;
import org.joml.Random;

public class FracturedEffect extends MobEffect {
    protected FracturedEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amp) {
        Level level = entity.level();

        DimensionalTrading.temporalEffectTrading(level, entity);

        double multi = MythicalCommonConfig.FRACTURED_MULTIPLIER.get();
        multi = Math.min(multi, 0.9);
        multi = Math.max(multi, 0);
        multi = 1 - multi;

        if (!entity.level().isClientSide()) {
            if (entity.getHealth() > (entity.getMaxHealth() * multi)) {
                entity.hurt(ModDamageSource.fracturing(level), 1);
            }


        }
    }

    public boolean isDurationEffectTick(int duration, int amp) {
        return true;
    }
}
