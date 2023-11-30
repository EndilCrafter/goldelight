package net.endil.goldelight.common.block.famersdelight;

import net.endil.goldelight.common.registry.GDModBlocks;
import net.endil.goldelight.common.registry.GDModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.state.BlockState;
import vectorwing.farmersdelight.common.block.CabbageBlock;
import vectorwing.farmersdelight.common.registry.ModItems;

public class GoldenCabbageBlock extends CabbageBlock {
    public GoldenCabbageBlock(Properties properties) {
        super(properties);
    }
    public BlockState getPlant(BlockGetter level, BlockPos pos) {
        return GDModBlocks.GOLDEN_CABBAGE_CROP.get().defaultBlockState();
    }

    protected ItemLike getBaseSeedId() {
        return GDModItems.GOLDEN_CABBAGE_SEEDS.get();
    }
}
