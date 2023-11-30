package net.endil.goldelight.common.registry;

import net.endil.goldelight.GolDelight;
import net.endil.goldelight.common.effect.ImmunityEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class GDModEffects {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, GolDelight.MOD_ID);

    public static final RegistryObject<MobEffect> IMMUNITY = EFFECTS.register("immunity", ImmunityEffect::new);

    public static void register(IEventBus eventBus) {EFFECTS.register(eventBus);}
}
