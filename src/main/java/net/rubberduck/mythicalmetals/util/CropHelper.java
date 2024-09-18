package net.rubberduck.mythicalmetals.util;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.rubberduck.mythicalmetals.MythicalMetals;

import java.lang.reflect.Method;
import java.util.HashSet;
// Code from BlakeBr0's Pickle Tweaks
public final class CropHelper {
    private static final HashSet<Block> ERRORED_BLOCKS = new HashSet<>();
    private static final Method GET_SEED;

    static {
        GET_SEED = ObfuscationReflectionHelper.findMethod(CropBlock.class, "m_6404_");
    }

    public static Item getSeedsItem(Block block) {
        try {
            return ((ItemLike) GET_SEED.invoke(block)).asItem();
        } catch (Exception e) {
            if (ERRORED_BLOCKS.add(block)) {
                MythicalMetals.LOGGER.error("Unable to get seed from crop {}", e.getLocalizedMessage());
            }
        }

        return null;
    }
}
