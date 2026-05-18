package net.rubberduck.mythicalmetals.compat;

import net.mehvahdjukaar.jeed.api.JeedAPI;
import net.minecraft.world.effect.MobEffectInstance;

public class JEEDMythicalPlugin {
    public static boolean isLoaded() {
        return net.minecraftforge.fml.ModList.get().isLoaded("jeed");
    }

    public static void invokeEffect(MobEffectInstance effect, double mouseX, double mouseY) {
        JeedAPI.invokeEffectClicked(effect, mouseX, mouseY, 1);
    }
}
