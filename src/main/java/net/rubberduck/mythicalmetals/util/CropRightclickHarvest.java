package net.rubberduck.mythicalmetals.util;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.NetherWartBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.rubberduck.mythicalmetals.config.MythicalCommonConfig;

public class CropRightclickHarvest {
    // Credit: Pickle Tweaks
    // https://github.com/BlakeBr0/PickleTweaks/blob/1.21/src/main/java/com/blakebr0/pickletweaks/feature/FeatureRightClickHarvest.java
    public static void rightClickHarvest(PlayerInteractEvent.RightClickBlock event) {
        if (event.getEntity() == null) {
            return;
        }
        if (event.getHand() != InteractionHand.MAIN_HAND) {
            return;
        }
        var level = event.getLevel();

        if (!level.isClientSide()) {
            var pos = event.getPos();
            var state = level.getBlockState(pos);
            var block = state.getBlock();
            var entity = event.getEntity();
            var hand = event.getHand();
            var item = entity.getItemInHand(hand);

            Tier itemTier = Tiers.WOOD;
            if (item.getItem() instanceof TieredItem tieredItem) {
                itemTier = tieredItem.getTier();
            }
            int distX = 0;
            int distY = 0;
            int distZ = 0;
            int sweepingLevel = item.getItem().getEnchantmentLevel(item, Enchantments.SWEEPING_EDGE);
            sweepingLevel = 2 * (sweepingLevel - 1) + 1;
            int radius = (MythicalCommonConfig.SCYTHE_RADIUS_MULTIPLIER.get() * itemTier.getLevel()) + sweepingLevel;

            // X vals
            for (int i = 0; i <= (radius * 2); i++) {
                distX = pos.getX() + (i - radius);

                //Y vals
                for (int j = 0; j <= (radius * 2); j++) {
                    distY = pos.getY() + (j - radius);

                    //Z vals
                    for (int k = 0; k <= (radius * 2); k++) {
                        distZ = pos.getZ() + (k - radius);

                        BlockPos targetBlockPos = new BlockPos(distX, distY, distZ);
                        BlockState targetState = level.getBlockState(targetBlockPos);
                        Block targetBlock = targetState.getBlock();

                            if (targetBlock instanceof CropBlock crop) {
                                var seed = CropHelper.getSeedsItem(crop);

                                if (crop.isMaxAge(targetState) && seed != null) {
                                    handleDrops(targetState, level, targetBlockPos, seed, pos);

                                    entity.swing(hand, true);

                                    var sound = targetBlock.getSoundType(targetState, level, targetBlockPos, entity).getBreakSound();

                                    level.playSound(null, targetBlockPos, sound, SoundSource.BLOCKS, 1.0F, 1.0F);
                                    level.setBlockAndUpdate(targetBlockPos, crop.getStateForAge(0));
                                }
                            }

                            if (targetBlock instanceof NetherWartBlock && targetState.getValue(NetherWartBlock.AGE) == 3) {
                                handleDrops(targetState, level, targetBlockPos, Items.NETHER_WART, pos);

                                entity.swing(hand, true);

                                var sound = targetBlock.getSoundType(targetState, level, targetBlockPos, entity).getBreakSound();

                                level.playSound(null, targetBlockPos, sound, SoundSource.BLOCKS, 1.0F, 1.0F);
                                level.setBlockAndUpdate(targetBlockPos, targetState.setValue(NetherWartBlock.AGE, 0));
                            }
                    }
                }
            }

        }
    }

    public static void handleDrops(BlockState state, Level level, BlockPos pos, ItemLike seed, BlockPos playerPos) {
        var drops = Block.getDrops(state, (ServerLevel) level, pos, level.getBlockEntity(pos));

        for (var drop : drops) {
            var item = drop.getItem();

            if (!drop.isEmpty() && item == seed) {
                drop.shrink(1);
                break;
            }
        }

        for (var drop : drops) {
            if (!drop.isEmpty()) {
                Block.popResource(level, playerPos, drop);
            }
        }
    }
}
