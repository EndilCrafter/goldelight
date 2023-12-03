package net.endil.goldelight.common.registry;

import net.endil.goldelight.GolDelight;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class GDModBlockEntityTypes {
    public static final DeferredRegister<BlockEntityType<?>> TILES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, GolDelight.MOD_ID);

    public static void register(IEventBus eventBus) {
        TILES.register(eventBus);
    }
}
