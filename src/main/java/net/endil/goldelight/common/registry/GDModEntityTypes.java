package net.endil.goldelight.common.registry;

import net.endil.goldelight.GolDelight;
import net.endil.goldelight.common.entity.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class GDModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, GolDelight.MOD_ID);
    public static final RegistryObject<EntityType<GoldenCow>> GOLDEN_COW = ENTITY_TYPES.register("golden_cow",
            () -> EntityType.Builder.of(GoldenCow::new, MobCategory.CREATURE).sized(0.9F, 1.4F).clientTrackingRange(10).build("golden_cow"));
    public static final RegistryObject<EntityType<GoldenChicken>> GOLDEN_CHICKEN = ENTITY_TYPES.register("golden_chicken",
            () -> EntityType.Builder.of(GoldenChicken::new, MobCategory.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("golden_chicken"));
    public static final RegistryObject<EntityType<GoldenBee>> GOLDEN_BEE = ENTITY_TYPES.register("golden_bee",
            () -> EntityType.Builder.of(GoldenBee::new, MobCategory.CREATURE).sized(0.7F, 0.6F).clientTrackingRange(8).build("golden_bee"));
    public static final RegistryObject<EntityType<ThrownGoldenEgg>> GOLDEN_EGG = ENTITY_TYPES.register("golden_egg",
            () -> EntityType.Builder.<ThrownGoldenEgg>of(ThrownGoldenEgg::new, MobCategory.MISC).sized(0.25F, 0.25F).clientTrackingRange(4).updateInterval(10).build("golden_egg"));
    public static final RegistryObject<EntityType<RottenGoldenTomato>> ROTTEN_GOLDEN_TOMATO = ENTITY_TYPES.register("rotten_golden_tomato",
            () -> EntityType.Builder.<RottenGoldenTomato>of(RottenGoldenTomato::new, MobCategory.MISC).sized(0.25F, 0.25F).clientTrackingRange(4).updateInterval(10).build("rotten_golden_tomato"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
