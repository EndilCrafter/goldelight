package net.endil.goldelight.common.block.famersdelight;

import net.endil.goldelight.common.registry.GDModBlocks;
import net.endil.goldelight.common.registry.GDModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.state.BlockState;
import vectorwing.farmersdelight.common.block.RicePaniclesBlock;
import vectorwing.farmersdelight.common.registry.ModItems;

public class GoldenRicePaniclesBlock extends RicePaniclesBlock {
    public GoldenRicePaniclesBlock(Properties properties) {
        super(properties);
    }

    protected ItemLike getBaseSeedId() {
        return GDModItems.GOLDEN_RICE.get();
    }

    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return state.is(GDModBlocks.GOLDEN_RICE_CROP.get());
    }
}
