package net.rubberduck.mythicalmetals.damage;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.world.damagesource.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.rubberduck.mythicalmetals.MythicalMetals;

public class ModDamageSource implements DamageTypes {

    public static final ResourceKey<DamageType> FRACTURING = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(MythicalMetals.MODID, "fracturing"));

    public static void bootstrap(BootstapContext<DamageType> context) {
        context.register(FRACTURING, new DamageType(
                "fracturing", DamageScaling.ALWAYS, 0F, DamageEffects.HURT, DeathMessageType.DEFAULT
        ));
    }

    public static DamageSource fracturing(Level level) {
        return new DamageSource(
                level.registryAccess()
                        .registryOrThrow(Registries.DAMAGE_TYPE)
                        .getHolderOrThrow(FRACTURING)
        );
    }

}
