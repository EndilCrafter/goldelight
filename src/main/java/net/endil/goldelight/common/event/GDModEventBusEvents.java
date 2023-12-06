package net.endil.goldelight.common.event;

import net.endil.goldelight.GolDelight;
import net.endil.goldelight.common.entity.GoldenBee;
import net.endil.goldelight.common.entity.GoldenChicken;
import net.endil.goldelight.common.entity.GoldenCow;
import net.endil.goldelight.common.registry.GDModEntityTypes;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = GolDelight.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class GDModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(GDModEntityTypes.GOLDEN_COW.get(), GoldenCow.createAttributes().build());
        event.put(GDModEntityTypes.GOLDEN_CHICKEN.get(), GoldenChicken.createAttributes().build());
        event.put(GDModEntityTypes.GOLDEN_BEE.get(), GoldenBee.createAttributes().build());
    }
}
