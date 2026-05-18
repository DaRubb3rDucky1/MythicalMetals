package net.rubberduck.mythicalmetals.item;


import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.NetherWartBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.rubberduck.mythicalmetals.MythicalMetals;
import net.rubberduck.mythicalmetals.config.MythicalCommonConfig;
import net.rubberduck.mythicalmetals.util.CropRightclickHarvest;
import net.rubberduck.mythicalmetals.util.LawnMower;
import net.rubberduck.mythicalmetals.util.ModTags;
import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Text;

import java.util.Arrays;

public class ScytheItem extends HoeItem {
    private final float attackDamage;
    private final Multimap<Attribute, AttributeModifier> defaultModifiers;

    public ScytheItem(Tier pTier, int attackDamageModifier, float attackSpeedModifier, Properties pProperties) {
            super(pTier, attackDamageModifier, attackSpeedModifier, pProperties);
        this.attackDamage = (float) attackDamageModifier + pTier.getAttackDamageBonus();
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", this.attackDamage, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", attackSpeedModifier, AttributeModifier.Operation.ADDITION));
        this.defaultModifiers = builder.build();

    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        // allow sweeping edge
        if (enchantment == Enchantments.SWEEPING_EDGE) {
            return true;
        }

        return super.canApplyAtEnchantingTable(stack, enchantment);
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    @Override
    public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
        return true;
    }

    @Override
    public boolean canPerformAction(ItemStack stack, ToolAction toolAction) {
        return ToolActions.DEFAULT_SWORD_ACTIONS.contains(toolAction)
                || super.canPerformAction(stack, toolAction);
    }

    public InteractionResult useOn(UseOnContext pContext) {
            super.useOn(pContext);
        Player player = pContext.getPlayer();
        InteractionHand hand = pContext.getHand();
        BlockPos pos = pContext.getClickedPos();
        BlockState state = pContext.getLevel().getBlockState(pos);
        Block block = state.getBlock();
        BlockHitResult blockHitResult = pContext.getLevel().clip(new ClipContext(pContext.getClickLocation(), pContext.getClickLocation(), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, player));
        Level level = pContext.getLevel();
        assert player != null;
        if ((block instanceof CropBlock) || (block instanceof NetherWartBlock)) {
            CropRightclickHarvest.rightClickHarvest(new PlayerInteractEvent.RightClickBlock(player, hand, pos, blockHitResult));
            pContext.getItemInHand().hurtAndBreak(1, player, (user) -> user.broadcastBreakEvent(hand));
        }
        //(block == Blocks.GRASS) || (block == Blocks.TALL_GRASS) || (block == Blocks.FERN) || (block == Blocks.LARGE_FERN)
        String[] configWeeds = MythicalCommonConfig.WEEDS.get().split(",");
        for (String weed : configWeeds) {
            Block targetBlock = BuiltInRegistries.BLOCK.get(ResourceLocation.tryParse(weed));
            if ((targetBlock != null) && block.equals(targetBlock)) {
                LawnMower.lawnMowEvent(new PlayerInteractEvent.RightClickBlock(player, hand, pos, blockHitResult));
            }
            pContext.getItemInHand().hurtAndBreak(1, player, (user) -> user.broadcastBreakEvent(hand));
        }

        return InteractionResult.SUCCESS;
    }
}
