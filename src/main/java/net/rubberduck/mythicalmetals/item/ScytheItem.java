package net.rubberduck.mythicalmetals.item;


import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.rubberduck.mythicalmetals.util.CropRightclickHarvest;
import net.rubberduck.mythicalmetals.util.ModTags;
import org.jetbrains.annotations.NotNull;

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
        if (block instanceof CropBlock) {
            CropRightclickHarvest.rightClickHarvest(new PlayerInteractEvent.RightClickBlock(player, hand, pos, blockHitResult));
        }
        pContext.getItemInHand().hurtAndBreak(1, player, (user) -> user.broadcastBreakEvent(hand));
        return InteractionResult.SUCCESS;
    }
}
