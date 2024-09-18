package net.rubberduck.mythicalmetals.item;

import com.google.common.collect.ImmutableMap;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.rubberduck.mythicalmetals.effects.ModEffects;

import java.util.Map;

public class ModArmorItem extends ArmorItem {
    private static final Map<ArmorMaterial, MobEffectInstance> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<ArmorMaterial, MobEffectInstance>())
                .put(ModArmorMaterials.ORICHALCUM, new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 400, 1,
                   false, false, true))
                .put(ModArmorMaterials.MYTHRIL, new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0,
                        false, false, true))
                .put(ModArmorMaterials.ADAMANTIUM, new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 400, 1,
                        false, false, true))
                .put(ModArmorMaterials.CHRONITE, new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 4,
                        false, false, true))
                .put(ModArmorMaterials.INFERNITE, new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 400, 1,
                        false, false, true))
                .put(ModArmorMaterials.AZURITE, new MobEffectInstance(ModEffects.VOID_WALKER.get(), 400, 0,
                        false, false, true)).build();

    public ModArmorItem(ArmorMaterial pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
    }

    @SuppressWarnings("removal")
    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        if(!world.isClientSide()) {
            if(hasFullSuitOfArmorOn(player)) {
                evaluateArmorEffects(player);
            }
        }
    }

    private void evaluateArmorEffects(Player player) {
        for (Map.Entry<ArmorMaterial, MobEffectInstance> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            MobEffectInstance mapStatusEffect = entry.getValue();

            if(hasCorrectArmorOn(mapArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapArmorMaterial, mapStatusEffect);
            }
        }
    }

    private void addStatusEffectForMaterial(Player player, ArmorMaterial mapArmorMaterial,
                                            MobEffectInstance mapStatusEffect) {
        boolean hasPlayerEffect = player.hasEffect(mapStatusEffect.getEffect());
        boolean hasResEffect = player.hasEffect(MobEffects.DAMAGE_RESISTANCE);
        boolean hasChroEffect = player.hasEffect(MobEffects.JUMP);

        if(hasCorrectArmorOn(mapArmorMaterial, player) && !hasPlayerEffect) {
            player.addEffect(new MobEffectInstance(mapStatusEffect));
        }
        if(mapArmorMaterial == ModArmorMaterials.ORICHALCUM && !hasResEffect) {
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 200, 2));
        } else if (mapArmorMaterial == ModArmorMaterials.CHRONITE && !hasChroEffect) {
            player.addEffect(new MobEffectInstance(MobEffects.JUMP, 200, 4));
        }
    }

    private boolean hasFullSuitOfArmorOn(Player player) {
        ItemStack boots = player.getInventory().getArmor(0);
        ItemStack leggings = player.getInventory().getArmor(1);
        ItemStack breastplate = player.getInventory().getArmor(2);
        ItemStack helmet = player.getInventory().getArmor(3);

        return !helmet.isEmpty() && !breastplate.isEmpty()
                && !leggings.isEmpty() && !boots.isEmpty();
    }

    private boolean hasCorrectArmorOn(ArmorMaterial material, Player player) {
        for (ItemStack armorStack : player.getInventory().armor) {
            if(!(armorStack.getItem() instanceof ArmorItem)) {
                return false;
            }
        }

        ArmorItem boots = ((ArmorItem)player.getInventory().getArmor(0).getItem());
        ArmorItem leggings = ((ArmorItem)player.getInventory().getArmor(1).getItem());
        ArmorItem breastplate = ((ArmorItem)player.getInventory().getArmor(2).getItem());
        ArmorItem helmet = ((ArmorItem)player.getInventory().getArmor(3).getItem());

        return helmet.getMaterial() == material && breastplate.getMaterial() == material &&
                leggings.getMaterial() == material && boots.getMaterial() == material;
    }

}
