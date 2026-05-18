package net.rubberduck.mythicalmetals.compat;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.rubberduck.mythicalmetals.item.ModItems;
import snownee.jade.addon.harvest.HarvestToolProvider;
import snownee.jade.addon.harvest.SimpleToolHandler;
import snownee.jade.api.IWailaClientRegistration;
import snownee.jade.api.IWailaCommonRegistration;
import snownee.jade.api.IWailaPlugin;
import snownee.jade.api.WailaPlugin;

@WailaPlugin
public class JadeMythicalPlugin implements IWailaPlugin {

    @Override
    public void register(IWailaCommonRegistration registration) {
        //TODO register data providers
    }

    @Override
    public void registerClient(IWailaClientRegistration registration) {
        //TODO register component providers, icon providers, callbacks, and config options here
        HarvestToolProvider.registerHandler(new SimpleToolHandler("pickaxe", BlockTags.MINEABLE_WITH_PICKAXE, new Item[]{
                // Vanilla
                Items.WOODEN_PICKAXE,
                Items.STONE_PICKAXE,
                Items.IRON_PICKAXE,
                Items.DIAMOND_PICKAXE,
                Items.NETHERITE_PICKAXE,
                //MythicMetals
                ModItems.ORICHALCUM_PICKAXE.get(),
                ModItems.ADAMANTIUM_PICKAXE.get(),
                ModItems.CHRONITE_PICKAXE.get(),
                ModItems.MYTHRIL_PICKAXE.get(),
                ModItems.INFERNITE_PICKAXE.get(),
                ModItems.AZURITE_PICKAXE.get()
        }));
    }



}
