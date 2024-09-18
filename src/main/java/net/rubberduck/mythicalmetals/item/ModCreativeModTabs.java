package net.rubberduck.mythicalmetals.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.rubberduck.mythicalmetals.MythicalMetals;
import net.rubberduck.mythicalmetals.block.ModBlocks;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MythicalMetals.MODID);

    public static final RegistryObject<CreativeModeTab> MM_TABS = CREATIVE_MODE_TABS.register("mythical_metals",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ORICHALCUM_INGOT.get()))
                    .title(Component.translatable("creativetab.mythicalmetals"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.DIAMOND_STICK.get());
                        output.accept(ModItems.FLASH_FROZEN_POWDER.get());
                        output.accept(ModItems.MOLTEN_PEARL.get());
                        output.accept(ModItems.GLITCHED_EYE.get());
                        //orichalum
                        output.accept(ModItems.RAW_ORICHALCUM.get());
                        output.accept(ModItems.ORICHALCUM_INGOT.get());
                        output.accept(ModItems.ORICHALCUM_SWORD.get());
                        output.accept(ModItems.ORICHALCUM_PICKAXE.get());
                        output.accept(ModItems.ORICHALCUM_AXE.get());
                        output.accept(ModItems.ORICHALCUM_SHOVEL.get());
                        output.accept(ModItems.ORICHALCUM_HOE.get());
                        output.accept(ModItems.ORICHALCUM_SHEARS.get());
                        output.accept(ModItems.ORICHALCUM_SCYTHE.get());
                        output.accept(ModItems.ORICHALCUM_SPEAR.get());
                        output.accept(ModItems.ORICHALCUM_HELMET.get());
                        output.accept(ModItems.ORICHALCUM_CHESTPLATE.get());
                        output.accept(ModItems.ORICHALCUM_LEGGINGS.get());
                        output.accept(ModItems.ORICHALCUM_BOOTS.get());
                        output.accept(ModBlocks.ORICHALCUM_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_ORICHALCUM_ORE.get());
                        output.accept(ModBlocks.RAW_ORICHALCUM_BLOCK.get());
                        output.accept(ModBlocks.ORICHALCUM_BLOCK.get());
                        //mythril
                        output.accept(ModItems.RAW_MYTHRIL.get());
                        output.accept(ModItems.MYTHRIL_INGOT.get());
                        output.accept(ModItems.MYTHRIL_SWORD.get());
                        output.accept(ModItems.MYTHRIL_PICKAXE.get());
                        output.accept(ModItems.MYTHRIL_AXE.get());
                        output.accept(ModItems.MYTHRIL_SHOVEL.get());
                        output.accept(ModItems.MYTHRIL_HOE.get());
                        output.accept(ModItems.MYTHRIL_SHEARS.get());
                        output.accept(ModItems.MYTHRIL_SCYTHE.get());
                        output.accept(ModItems.MYTHRIL_SPEAR.get());
                        output.accept(ModItems.MYTHRIL_HELMET.get());
                        output.accept(ModItems.MYTHRIL_CHESTPLATE.get());
                        output.accept(ModItems.MYTHRIL_LEGGINGS.get());
                        output.accept(ModItems.MYTHRIL_BOOTS.get());
                        output.accept(ModBlocks.MYTHRIL_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_MYTHRIL_ORE.get());
                        output.accept(ModBlocks.RAW_MYTHRIL_BLOCK.get());
                        output.accept(ModBlocks.MYTHRIL_BLOCK.get());
                        //chronite
                        output.accept(ModItems.CHRONITE_INGOT.get());
                        output.accept(ModItems.CHRONITE_SWORD.get());
                        output.accept(ModItems.CHRONITE_PICKAXE.get());
                        output.accept(ModItems.CHRONITE_AXE.get());
                        output.accept(ModItems.CHRONITE_SHOVEL.get());
                        output.accept(ModItems.CHRONITE_HOE.get());
                        output.accept(ModItems.CHRONITE_SHEARS.get());
                        output.accept(ModItems.CHRONITE_SCYTHE.get());
                        output.accept(ModItems.CHRONITE_SPEAR.get());
                        output.accept(ModItems.CHRONITE_HELMET.get());
                        output.accept(ModItems.CHRONITE_CHESTPLATE.get());
                        output.accept(ModItems.CHRONITE_LEGGINGS.get());
                        output.accept(ModItems.CHRONITE_BOOTS.get());
                        output.accept(ModBlocks.CHRONITE_BLOCK.get());
                        //adamantium
                        output.accept(ModItems.ADAMANTIUM_INGOT.get());
                        output.accept(ModItems.ADAMANTIUM_SWORD.get());
                        output.accept(ModItems.ADAMANTIUM_PICKAXE.get());
                        output.accept(ModItems.ADAMANTIUM_AXE.get());
                        output.accept(ModItems.ADAMANTIUM_SHOVEL.get());
                        output.accept(ModItems.ADAMANTIUM_HOE.get());
                        output.accept(ModItems.ADAMANTIUM_SHEARS.get());
                        output.accept(ModItems.ADAMANTIUM_SCYTHE.get());
                        output.accept(ModItems.ADAMANTIUM_SPEAR.get());
                        output.accept(ModItems.ADAMANTIUM_HELMET.get());
                        output.accept(ModItems.ADAMANTIUM_CHESTPLATE.get());
                        output.accept(ModItems.ADAMANTIUM_LEGGINGS.get());
                        output.accept(ModItems.ADAMANTIUM_BOOTS.get());
                        output.accept(ModBlocks.ADAMANTIUM_BLOCK.get());
                        //infernite
                        output.accept(ModItems.RAW_INFERNITE.get());
                        output.accept(ModItems.INFERNITE_INGOT.get());
                        output.accept(ModItems.INFERNITE_SWORD.get());
                        output.accept(ModItems.INFERNITE_PICKAXE.get());
                        output.accept(ModItems.INFERNITE_AXE.get());
                        output.accept(ModItems.INFERNITE_SHOVEL.get());
                        output.accept(ModItems.INFERNITE_HOE.get());
                        output.accept(ModItems.INFERNITE_SHEARS.get());
                        output.accept(ModItems.INFERNITE_SCYTHE.get());
                        output.accept(ModItems.INFERNITE_SPEAR.get());
                        output.accept(ModItems.INFERNITE_HELMET.get());
                        output.accept(ModItems.INFERNITE_CHESTPLATE.get());
                        output.accept(ModItems.INFERNITE_LEGGINGS.get());
                        output.accept(ModItems.INFERNITE_BOOTS.get());
                        output.accept(ModBlocks.INFERNITE_ORE.get());
                        output.accept(ModBlocks.RAW_INFERNITE_BLOCK.get());
                        output.accept(ModBlocks.INFERNITE_BLOCK.get());
                        //azurite
                        output.accept(ModItems.RAW_AZURITE.get());
                        output.accept(ModItems.AZURITE_INGOT.get());
                        output.accept(ModItems.AZURITE_SWORD.get());
                        output.accept(ModItems.AZURITE_PICKAXE.get());
                        output.accept(ModItems.AZURITE_AXE.get());
                        output.accept(ModItems.AZURITE_SHOVEL.get());
                        output.accept(ModItems.AZURITE_HOE.get());
                        output.accept(ModItems.AZURITE_SHEARS.get());
                        output.accept(ModItems.AZURITE_SCYTHE.get());
                        output.accept(ModItems.AZURITE_SPEAR.get());
                        output.accept(ModItems.AZURITE_HELMET.get());
                        output.accept(ModItems.AZURITE_CHESTPLATE.get());
                        output.accept(ModItems.AZURITE_LEGGINGS.get());
                        output.accept(ModItems.AZURITE_BOOTS.get());
                        output.accept(ModBlocks.AZURITE_ORE.get());
                        output.accept(ModBlocks.RAW_AZURITE_BLOCK.get());
                        output.accept(ModBlocks.AZURITE_BLOCK.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
