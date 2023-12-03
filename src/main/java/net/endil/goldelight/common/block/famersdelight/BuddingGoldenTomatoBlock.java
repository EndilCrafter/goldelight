package net.endil.goldelight.common.block.famersdelight;

import net.endil.goldelight.common.registry.GDModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import vectorwing.farmersdelight.common.block.BuddingTomatoBlock;

public class BuddingGoldenTomatoBlock extends BuddingTomatoBlock {
    public BuddingGoldenTomatoBlock(Properties properties) {
        super(properties);
    }

    public BlockState getPlant(BlockGetter world, BlockPos pos) {
        return GDModBlocks.BUDDING_GOLDEN_TOMATO_CROP.get().defaultBlockState();
    }

    public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
        if (state.getValue(BuddingGoldenBushBlock.AGE) == 4) {
            level.setBlock(currentPos, GDModBlocks.GOLDEN_TOMATO_CROP.get().defaultBlockState(), 3);
        }

        return super.updateShape(state, facing, facingState, level, currentPos, facingPos);
    }

    public void growPastMaxAge(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        level.setBlockAndUpdate(pos, GDModBlocks.GOLDEN_TOMATO_CROP.get().defaultBlockState());
    }

    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        int maxAge = this.getMaxAge();
        int ageGrowth = Math.min(this.getAge(state) + this.getBonemealAgeIncrease(level), 7);
        if (ageGrowth <= maxAge) {
            level.setBlockAndUpdate(pos, state.setValue(AGE, ageGrowth));
        } else {
            int remainingGrowth = ageGrowth - maxAge - 1;
            level.setBlockAndUpdate(pos, GDModBlocks.GOLDEN_TOMATO_CROP.get().defaultBlockState().setValue(GoldenTomatoVineBlock.VINE_AGE, remainingGrowth));
        }

    }
}
