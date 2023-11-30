package net.endil.goldelight.common.block.famersdelight;

import net.endil.goldelight.common.registry.GDModBlocks;
import net.endil.goldelight.common.registry.GDModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ForgeHooks;
import vectorwing.farmersdelight.common.block.RiceBlock;
import vectorwing.farmersdelight.common.block.RicePaniclesBlock;
import vectorwing.farmersdelight.common.registry.ModBlocks;
import vectorwing.farmersdelight.common.registry.ModItems;

public class GoldenRiceBlock extends RiceBlock {
    public GoldenRiceBlock(Properties properties) {
        super(properties);
    }

    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        super.tick(state, level, pos, random);
        if (level.isAreaLoaded(pos, 1)) {
            if (level.getRawBrightness(pos.above(), 0) >= 6) {
                int age = this.getAge(state);
                if (age <= this.getMaxAge()) {
                    float chance = 10.0F;
                    if (ForgeHooks.onCropsGrowPre(level, pos, state, random.nextInt((int)(25.0F / chance) + 1) == 0)) {
                        if (age == this.getMaxAge()) {
                            GoldenRicePaniclesBlock riceUpper = (GoldenRicePaniclesBlock) GDModBlocks.GOLDEN_RICE_CROP_PANICLES.get();
                            if (riceUpper.defaultBlockState().canSurvive(level, pos.above()) && level.isEmptyBlock(pos.above())) {
                                level.setBlockAndUpdate(pos.above(), riceUpper.defaultBlockState());
                                ForgeHooks.onCropsGrowPost(level, pos, state);
                            }
                        } else {
                            level.setBlock(pos, this.withAge(age + 1), 2);
                            ForgeHooks.onCropsGrowPost(level, pos, state);
                        }
                    }
                }
            }

        }
    }

    public ItemStack getCloneItemStack(BlockGetter level, BlockPos pos, BlockState state) {
        return new ItemStack(GDModItems.GOLDEN_RICE.get());
    }

    public boolean isSupportingRiceUpper(BlockState topState) {
        return topState.getBlock() == GDModBlocks.GOLDEN_RICE_CROP_PANICLES.get();
    }

    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state, boolean isClient) {
        BlockState upperState = level.getBlockState(pos.above());
        if (upperState.getBlock() instanceof GoldenRicePaniclesBlock) {
            return !((GoldenRicePaniclesBlock)upperState.getBlock()).isMaxAge(upperState);
        } else {
            return true;
        }
    }

    public void performBonemeal(ServerLevel level, RandomSource rand, BlockPos pos, BlockState state) {
        int ageGrowth = Math.min(this.getAge(state) + this.getBonemealAgeIncrease(level), 7);
        if (ageGrowth <= this.getMaxAge()) {
            level.setBlockAndUpdate(pos, state.setValue(AGE, ageGrowth));
        } else {
            BlockState top = level.getBlockState(pos.above());
            if (top.getBlock() == GDModBlocks.GOLDEN_RICE_CROP_PANICLES.get()) {
                BonemealableBlock growable = (BonemealableBlock)level.getBlockState(pos.above()).getBlock();
                if (growable.isValidBonemealTarget(level, pos.above(), top, false)) {
                    growable.performBonemeal(level, level.random, pos.above(), top);
                }
            } else {
                GoldenRicePaniclesBlock riceUpper = (GoldenRicePaniclesBlock) GDModBlocks.GOLDEN_RICE_CROP_PANICLES.get();
                int remainingGrowth = ageGrowth - this.getMaxAge() - 1;
                if (riceUpper.defaultBlockState().canSurvive(level, pos.above()) && level.isEmptyBlock(pos.above())) {
                    level.setBlockAndUpdate(pos, state.setValue(AGE, this.getMaxAge()));
                    level.setBlock(pos.above(), riceUpper.defaultBlockState().setValue(GoldenRicePaniclesBlock.RICE_AGE, remainingGrowth), 2);
                }
            }
        }

    }
}
