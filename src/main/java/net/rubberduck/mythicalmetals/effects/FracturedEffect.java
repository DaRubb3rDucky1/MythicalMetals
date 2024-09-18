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
import net.rubberduck.mythicalmetals.item.ModItems;

public class FracturedEffect extends MobEffect {
    protected FracturedEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amp) {
        Level level = entity.level();
        InteractionHand hand = entity.getUsedItemHand();
        Item chronite = ModItems.CHRONITE_INGOT.get();
        ItemStack itemStack = new ItemStack(chronite, 1);
        if (!entity.level().isClientSide()) {
            if (entity.getHealth() > (entity.getMaxHealth() / 2)) {
                entity.hurt(entity.damageSources().magic(), 1);
            }
            if (entity.isHolding(Items.IRON_BLOCK)) {
                if (entity instanceof Player) {
                    Player player = ((Player) entity);
                    player.getInventory().placeItemBackInInventory(itemStack);
                    if(!player.getAbilities().instabuild) {
                        player.getItemInHand(hand).shrink(1);
                    }
                }
            }
        }
    }

    public boolean isDurationEffectTick(int duration, int amp) {
        return true;
    }
}
