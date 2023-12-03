package net.endil.goldelight.common.block.vanilla;

import net.endil.goldelight.common.registry.GDModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;

import javax.annotation.Nullable;

public class GoldenChorusFlowerBlock extends Block {
    public static final int DEAD_AGE = 5;
    public static final IntegerProperty AGE = BlockStateProperties.AGE_5;
    private final GoldenChorusPlantBlock plant;

    public GoldenChorusFlowerBlock(GoldenChorusPlantBlock pPlant, BlockBehaviour.Properties pProperties) {
        super(pProperties);
        this.plant = pPlant;
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, Integer.valueOf(0)));
    }

    private static boolean allNeighborsEmpty(LevelReader pLevel, BlockPos pPos, @Nullable Direction pExcludingSide) {
        for (Direction direction : Direction.Plane.HORIZONTAL) {
            if (direction != pExcludingSide && !pLevel.isEmptyBlock(pPos.relative(direction))) {
                return false;
            }
        }

        return true;
    }

    public static void generatePlant(LevelAccessor pLevel, BlockPos pPos, RandomSource pRandom, int pMaxHorizontalDistance) {
        pLevel.setBlock(pPos, ((GoldenChorusPlantBlock) GDModBlocks.GOLDEN_CHORUS_PLANT.get()).getStateForPlacement(pLevel, pPos), 2);
        growTreeRecursive(pLevel, pPos, pRandom, pPos, pMaxHorizontalDistance, 0);
    }

    private static void growTreeRecursive(LevelAccessor pLevel, BlockPos pBranchPos, RandomSource pRandom, BlockPos pOriginalBranchPos, int pMaxHorizontalDistance, int pIterations) {
        GoldenChorusPlantBlock plantBlock = (GoldenChorusPlantBlock) GDModBlocks.GOLDEN_CHORUS_PLANT.get();
        int i = pRandom.nextInt(4) + 1;
        if (pIterations == 0) {
            ++i;
        }

        for (int j = 0; j < i; ++j) {
            BlockPos blockpos = pBranchPos.above(j + 1);
            if (!allNeighborsEmpty(pLevel, blockpos, null)) {
                return;
            }

            pLevel.setBlock(blockpos, plantBlock.getStateForPlacement(pLevel, blockpos), 2);
            pLevel.setBlock(blockpos.below(), plantBlock.getStateForPlacement(pLevel, blockpos.below()), 2);
        }

        boolean flag = false;
        if (pIterations < 4) {
            int l = pRandom.nextInt(4);
            if (pIterations == 0) {
                ++l;
            }

            for (int k = 0; k < l; ++k) {
                Direction direction = Direction.Plane.HORIZONTAL.getRandomDirection(pRandom);
                BlockPos blockpos1 = pBranchPos.above(i).relative(direction);
                if (Math.abs(blockpos1.getX() - pOriginalBranchPos.getX()) < pMaxHorizontalDistance && Math.abs(blockpos1.getZ() - pOriginalBranchPos.getZ()) < pMaxHorizontalDistance && pLevel.isEmptyBlock(blockpos1) && pLevel.isEmptyBlock(blockpos1.below()) && allNeighborsEmpty(pLevel, blockpos1, direction.getOpposite())) {
                    flag = true;
                    pLevel.setBlock(blockpos1, plantBlock.getStateForPlacement(pLevel, blockpos1), 2);
                    pLevel.setBlock(blockpos1.relative(direction.getOpposite()), plantBlock.getStateForPlacement(pLevel, blockpos1.relative(direction.getOpposite())), 2);
                    growTreeRecursive(pLevel, blockpos1, pRandom, pOriginalBranchPos, pMaxHorizontalDistance, pIterations + 1);
                }
            }
        }

        if (!flag) {
            pLevel.setBlock(pBranchPos.above(i), GDModBlocks.GOLDEN_CHORUS_FLOWER.get().defaultBlockState().setValue(AGE, Integer.valueOf(5)), 2);
        }

    }

    public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (!pState.canSurvive(pLevel, pPos)) {
            pLevel.destroyBlock(pPos, true);
        }

    }

    public boolean isRandomlyTicking(BlockState pState) {
        return pState.getValue(AGE) < 5;
    }

    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        BlockPos blockpos = pPos.above();
        if (pLevel.isEmptyBlock(blockpos) && blockpos.getY() < pLevel.getMaxBuildHeight()) {
            int i = pState.getValue(AGE);
            if (i < 5 && net.minecraftforge.common.ForgeHooks.onCropsGrowPre(pLevel, blockpos, pState, true)) {
                boolean flag = false;
                boolean flag1 = false;
                BlockState blockstate = pLevel.getBlockState(pPos.below());
                if (blockstate.is(Blocks.END_STONE)) {
                    flag = true;
                } else if (blockstate.is(this.plant)) {
                    int j = 1;

                    for (int k = 0; k < 4; ++k) {
                        BlockState blockstate1 = pLevel.getBlockState(pPos.below(j + 1));
                        if (!blockstate1.is(this.plant)) {
                            if (blockstate1.is(Blocks.END_STONE)) {
                                flag1 = true;
                            }
                            break;
                        }

                        ++j;
                    }

                    if (j < 2 || j <= pRandom.nextInt(flag1 ? 5 : 4)) {
                        flag = true;
                    }
                } else if (blockstate.isAir()) {
                    flag = true;
                }

                if (flag && allNeighborsEmpty(pLevel, blockpos, null) && pLevel.isEmptyBlock(pPos.above(2))) {
                    pLevel.setBlock(pPos, this.plant.getStateForPlacement(pLevel, pPos), 2);
                    this.placeGrownFlower(pLevel, blockpos, i);
                } else if (i < 4) {
                    int l = pRandom.nextInt(4);
                    if (flag1) {
                        ++l;
                    }

                    boolean flag2 = false;

                    for (int i1 = 0; i1 < l; ++i1) {
                        Direction direction = Direction.Plane.HORIZONTAL.getRandomDirection(pRandom);
                        BlockPos blockpos1 = pPos.relative(direction);
                        if (pLevel.isEmptyBlock(blockpos1) && pLevel.isEmptyBlock(blockpos1.below()) && allNeighborsEmpty(pLevel, blockpos1, direction.getOpposite())) {
                            this.placeGrownFlower(pLevel, blockpos1, i + 1);
                            flag2 = true;
                        }
                    }

                    if (flag2) {
                        pLevel.setBlock(pPos, this.plant.getStateForPlacement(pLevel, pPos), 2);
                    } else {
                        this.placeDeadFlower(pLevel, pPos);
                    }
                } else {
                    this.placeDeadFlower(pLevel, pPos);
                }
                net.minecraftforge.common.ForgeHooks.onCropsGrowPost(pLevel, pPos, pState);
            }
        }
    }

    private void placeGrownFlower(Level pLevel, BlockPos pPos, int pAge) {
        pLevel.setBlock(pPos, this.defaultBlockState().setValue(AGE, Integer.valueOf(pAge)), 2);
        pLevel.levelEvent(1033, pPos, 0);
    }

    private void placeDeadFlower(Level pLevel, BlockPos pPos) {
        pLevel.setBlock(pPos, this.defaultBlockState().setValue(AGE, Integer.valueOf(5)), 2);
        pLevel.levelEvent(1034, pPos, 0);
    }

    public BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pFacingPos) {
        if (pFacing != Direction.UP && !pState.canSurvive(pLevel, pCurrentPos)) {
            pLevel.scheduleTick(pCurrentPos, this, 1);
        }

        return super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
    }

    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        BlockState blockstate = pLevel.getBlockState(pPos.below());
        if (!blockstate.is(this.plant) && !blockstate.is(Blocks.END_STONE)) {
            if (!blockstate.isAir()) {
                return false;
            } else {
                boolean flag = false;

                for (Direction direction : Direction.Plane.HORIZONTAL) {
                    BlockState blockstate1 = pLevel.getBlockState(pPos.relative(direction));
                    if (blockstate1.is(this.plant)) {
                        if (flag) {
                            return false;
                        }

                        flag = true;
                    } else if (!blockstate1.isAir()) {
                        return false;
                    }
                }

                return flag;
            }
        } else {
            return true;
        }
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(AGE);
    }

    public void onProjectileHit(Level pLevel, BlockState pState, BlockHitResult pHit, Projectile pProjectile) {
        BlockPos blockpos = pHit.getBlockPos();
        if (!pLevel.isClientSide && pProjectile.mayInteract(pLevel, blockpos) && pProjectile.getType().is(EntityTypeTags.IMPACT_PROJECTILES)) {
            pLevel.destroyBlock(blockpos, true, pProjectile);
        }

    }
}
