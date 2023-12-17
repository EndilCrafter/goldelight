package net.endil.goldelight.common.block.vanilla;

import net.endil.goldelight.common.registry.GDModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.CocoaBlock;
import net.minecraft.world.level.block.state.BlockState;

public class GoldenCocoaBlock extends CocoaBlock {
    public GoldenCocoaBlock(Properties pProperties) {
        super(pProperties);
    }

    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        BlockState blockstate = pLevel.getBlockState(pPos.relative(pState.getValue(FACING)));
        return blockstate.is(GDModTags.Blocks.GOLDEN_STEMS);
    }
}
