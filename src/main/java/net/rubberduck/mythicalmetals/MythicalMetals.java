package net.rubberduck.mythicalmetals;

import com.mojang.logging.LogUtils;
import com.mojang.realmsclient.gui.ErrorCallback;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipe;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.common.brewing.IBrewingRecipe;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.NamedEventListener;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.rubberduck.mythicalmetals.block.ModBlocks;
import net.rubberduck.mythicalmetals.effects.ModEffects;
import net.rubberduck.mythicalmetals.item.ModCreativeModTabs;
import net.rubberduck.mythicalmetals.item.ModItems;
import net.rubberduck.mythicalmetals.potion.ModPotions;
import net.rubberduck.mythicalmetals.util.BetterBrewingRecipe;
import net.rubberduck.mythicalmetals.util.CropRightclickHarvest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.minecraft.world.item.alchemy.PotionBrewing.*;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MythicalMetals.MODID)
public class MythicalMetals {

    // Define mod id in a common place for everything to reference
    public static final String NAME = "Mythical Metals";
    public static final String MODID = "mythicalmetals";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LoggerFactory.getLogger(NAME);


    public MythicalMetals() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModEffects.register(modEventBus);
        ModPotions.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::setup);

        MinecraftForge.EVENT_BUS.register(this);
    }
    @SubscribeEvent
    public void commonSetup(final FMLCommonSetupEvent event) {
        //MinecraftForge.EVENT_BUS.register(new CropRightclickHarvest());

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.AWKWARD, ModItems.GLITCHED_EYE.get(), ModPotions.FRACTURED_POTION.get()));
        });
    }
}
