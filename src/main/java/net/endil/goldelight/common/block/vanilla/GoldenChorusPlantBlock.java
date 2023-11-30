package net.endil.goldelight.common.block.vanilla;

import net.endil.goldelight.common.registry.GDModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ChorusPlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class GoldenChorusPlantBlock extends ChorusPlantBlock {
    public GoldenChorusPlantBlock(Properties properties) {
        super(properties);
    }

    public @NotNull BlockState getStateForPlacement(BlockGetter pLevel, BlockPos pPos) {
        BlockState blockstate = pLevel.getBlockState(pPos.below());
        BlockState blockstate1 = pLevel.getBlockState(pPos.above());
        BlockState blockstate2 = pLevel.getBlockState(pPos.north());
        BlockState blockstate3 = pLevel.getBlockState(pPos.east());
        BlockState blockstate4 = pLevel.getBlockState(pPos.south());
        BlockState blockstate5 = pLevel.getBlockState(pPos.west());
        return this.defaultBlockState().setValue(DOWN, Boolean.valueOf(blockstate.is(this) || blockstate.is(GDModBlocks.GOLDEN_CHORUS_FLOWER.get()) || blockstate.is(Blocks.END_STONE))).setValue(UP, Boolean.valueOf(blockstate1.is(this) || blockstate1.is(GDModBlocks.GOLDEN_CHORUS_FLOWER.get()))).setValue(NORTH, Boolean.valueOf(blockstate2.is(this) || blockstate2.is(GDModBlocks.GOLDEN_CHORUS_FLOWER.get()))).setValue(EAST, Boolean.valueOf(blockstate3.is(this) || blockstate3.is(GDModBlocks.GOLDEN_CHORUS_FLOWER.get()))).setValue(SOUTH, Boolean.valueOf(blockstate4.is(this) || blockstate4.is(GDModBlocks.GOLDEN_CHORUS_FLOWER.get()))).setValue(WEST, Boolean.valueOf(blockstate5.is(this) || blockstate5.is(GDModBlocks.GOLDEN_CHORUS_FLOWER.get())));
    }

    public @NotNull BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pFacingPos) {
        if (!pState.canSurvive(pLevel, pCurrentPos)) {
            pLevel.scheduleTick(pCurrentPos, this, 1);
            return super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
        } else {
            boolean flag = pFacingState.is(this) || pFacingState.is(GDModBlocks.GOLDEN_CHORUS_FLOWER.get()) || pFacing == Direction.DOWN && pFacingState.is(Blocks.END_STONE);
            return pState.setValue(PROPERTY_BY_DIRECTION.get(pFacing), Boolean.valueOf(flag));
        }
    }
}
