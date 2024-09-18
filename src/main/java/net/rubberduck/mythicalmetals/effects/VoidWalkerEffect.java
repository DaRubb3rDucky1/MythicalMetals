package net.rubberduck.mythicalmetals.effects;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class VoidWalkerEffect extends MobEffect {

    protected VoidWalkerEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amp) {
        Level level = entity.level();
        if(!entity.level().isClientSide()) {
            BlockPos below = entity.blockPosition().below(5);
            BlockState belowBlock = entity.level().getBlockState(below);
            entity.resetFallDistance();
                if(belowBlock == Blocks.AIR.defaultBlockState() && !entity.isCrouching()) {
                    entity.setNoGravity(true);
                } else {
                    entity.setNoGravity(false);
                }
        }
    }

    public void removeAttributeModifiers(LivingEntity entity, AttributeMap map, int amp) {
        super.removeAttributeModifiers(entity, map, amp);
        if(!entity.level().isClientSide() && entity.isNoGravity()) {
            entity.setNoGravity(false);
        }
    }

    public boolean isDurationEffectTick(int duration, int amp) {
        return true;
    }

}
