package net.endil.goldelight.common.registry;

import com.google.common.collect.ImmutableSet;
import net.endil.goldelight.GolDelight;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class GDModPoiTypes {
    public static final DeferredRegister<PoiType> POI =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, GolDelight.MOD_ID);

    public static final RegistryObject<PoiType> GOLDEN_BEEHIVE = POI.register("golden_beehive",
            () -> new PoiType(getBlockStates(GDModBlocks.GOLDEN_BEEHIVE.get()), 0, 1));


    private static Set<BlockState> getBlockStates(Block pBlock) {
        return ImmutableSet.copyOf(pBlock.getStateDefinition().getPossibleStates());
    }

    public static void register(IEventBus eventBus) {
        POI.register(eventBus);
    }
}
