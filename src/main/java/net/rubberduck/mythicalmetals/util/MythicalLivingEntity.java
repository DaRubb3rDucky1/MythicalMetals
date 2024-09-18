package net.rubberduck.mythicalmetals.util;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.common.ForgeHooks;
import net.rubberduck.mythicalmetals.effects.ModEffects;
import net.rubberduck.mythicalmetals.item.ModArmorMaterials;
import net.rubberduck.mythicalmetals.item.ModItems;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class MythicalLivingEntity extends LivingEntity {
    private final Map<EquipmentSlot, ItemStack> equipment = new EnumMap<>(EquipmentSlot.class);
    private final Entity entity;
    protected MythicalLivingEntity(EntityType<? extends LivingEntity> pEntityType, Level pLevel, Entity entity) {
        super(pEntityType, pLevel);
        this.entity = entity;
        // Initialize equipment slots
        for (EquipmentSlot slot : EquipmentSlot.values()) {
            equipment.put(slot, ItemStack.EMPTY);
        }
    }

    @Override
    public Iterable<ItemStack> getArmorSlots() {
        return Collections.unmodifiableCollection(equipment.values());
    }

    @Override
    public ItemStack getItemBySlot(EquipmentSlot pSlot) {
        return equipment.getOrDefault(pSlot, ItemStack.EMPTY);
    }

    @Override
    public void setItemSlot(EquipmentSlot pSlot, ItemStack pStack) {
        equipment.put(pSlot, pStack);
    }

    @Override
    public HumanoidArm getMainArm() {
        return HumanoidArm.RIGHT;
    }
}
