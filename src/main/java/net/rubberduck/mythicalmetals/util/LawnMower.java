package net.rubberduck.mythicalmetals.util;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.rubberduck.mythicalmetals.MythicalMetals;
import net.rubberduck.mythicalmetals.config.MythicalCommonConfig;

public class LawnMower {

    public static void lawnMowEvent(PlayerInteractEvent.RightClickBlock event) {

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
            int sweepingLevel = item.getItem().getEnchantmentLevel(item, Enchantments.SWEEPING_EDGE);
            sweepingLevel = 2 * (sweepingLevel - 1) + 1;

//            MythicalMetals.LOGGER.debug("test :3");
//            MythicalMetals.LOGGER.debug("targeted block is: " + pos.getX() + " " + pos.getY() + " " + pos.getZ());
//            MythicalMetals.LOGGER.debug("" + sweepingLevel);
//            MythicalMetals.LOGGER.debug("");

            int radius = (MythicalCommonConfig.SCYTHE_RADIUS_MULTIPLIER.get() * itemTier.getLevel()) + sweepingLevel;
            int distX = 0;
            int distY = 0;
            int distZ = 0;
//            MythicalMetals.LOGGER.debug("" + radius);

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

                        String[] configWeeds = MythicalCommonConfig.WEEDS.get().split(",");
                        for (String weed : configWeeds) {
                            Block weeds = BuiltInRegistries.BLOCK.get(ResourceLocation.tryParse(weed));
                            if ((weeds != null) && level.getBlockState(targetBlockPos).getBlock().equals(weeds)) {
//                                MythicalMetals.LOGGER.debug("bwop");
                                if (!entity.isCrouching()) CropRightclickHarvest.handleDrops(level.getBlockState(targetBlockPos), level, targetBlockPos, Items.AIR, pos);
                                level.destroyBlock(targetBlockPos, false, entity);
                            }
                        }
                    }
                }
            }

        }

    }

}
