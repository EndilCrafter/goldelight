package net.endil.goldelight.common.block.famersdelight;

import net.endil.goldelight.common.registry.GDModBlocks;
import net.endil.goldelight.common.registry.GDModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.state.BlockState;
import vectorwing.farmersdelight.common.block.OnionBlock;

public class GoldenOnionBlock extends OnionBlock {
    public GoldenOnionBlock(Properties properties) {
        super(properties);
    }

    public BlockState getPlant(BlockGetter world, BlockPos pos) {
        return GDModBlocks.GOLDEN_ONION_CROP.get().defaultBlockState();
    }

    protected ItemLike getBaseSeedId() {
        return GDModItems.GOLDEN_ONION.get();
    }
}
