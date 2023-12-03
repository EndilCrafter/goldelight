package net.endil.goldelight.common.block.vanilla;

import net.endil.goldelight.common.registry.GDModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CactusBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.IPlantable;

public class GoldenCactusBlock extends CactusBlock {
    public GoldenCactusBlock(BlockBehaviour.Properties pProperties) {
        super(pProperties);
    }
    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        BlockPos blockpos = pPos.above();
        if (pLevel.isEmptyBlock(blockpos)) {
            int i;
            for(i = 1; pLevel.getBlockState(pPos.below(i)).is(this); ++i) {
            }

            if (i < 3) {
                int j = pState.getValue(AGE);
                if(net.minecraftforge.common.ForgeHooks.onCropsGrowPre(pLevel, blockpos, pState, true)) {
                    if (j == 15) {
                        pLevel.setBlockAndUpdate(blockpos, this.defaultBlockState());
                        BlockState blockstate = pState.setValue(AGE, 0);
                        pLevel.setBlock(pPos, blockstate, 4);
                        pLevel.neighborChanged(blockstate, blockpos, this, pPos, false);
                    } else {
                        pLevel.setBlock(pPos, pState.setValue(AGE, j + 1), 4);
                    }
                    net.minecraftforge.common.ForgeHooks.onCropsGrowPost(pLevel, pPos, pState);
                }
            }
        }
    }

    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        for(Direction direction : Direction.Plane.HORIZONTAL) {
            BlockState blockstate = pLevel.getBlockState(pPos.relative(direction));
            if (blockstate.isSolid() || pLevel.getFluidState(pPos.relative(direction)).is(FluidTags.LAVA)) {
                return false;
            }
        }

        BlockState blockstate1 = pLevel.getBlockState(pPos.below());
        return (blockstate1.canSustainPlant(pLevel, pPos, Direction.UP, this) || blockstate1.is(GDModBlocks.GOLDEN_CACTUS.get())) && !pLevel.getBlockState(pPos.above()).liquid();
    }

    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        pEntity.hurt(pLevel.damageSources().cactus(), 3.0F);
    }
}
