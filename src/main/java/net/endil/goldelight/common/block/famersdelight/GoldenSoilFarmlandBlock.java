package net.endil.goldelight.common.block.famersdelight;

import net.endil.goldelight.common.registry.GDModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.TallFlowerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.FarmlandWaterManager;
import net.minecraftforge.common.ForgeHooks;
import vectorwing.farmersdelight.common.Configuration;
import vectorwing.farmersdelight.common.block.RichSoilFarmlandBlock;
import vectorwing.farmersdelight.common.tag.ModTags;
import vectorwing.farmersdelight.common.utility.MathUtils;

import java.util.Iterator;

public class GoldenSoilFarmlandBlock extends RichSoilFarmlandBlock {
    public GoldenSoilFarmlandBlock(Properties properties) {
        super(properties);
    }

    private static boolean hasWater(LevelReader level, BlockPos pos) {
        Iterator var2 = BlockPos.betweenClosed(pos.offset(-4, 0, -4), pos.offset(4, 1, 4)).iterator();

        BlockPos nearbyPos;
        do {
            if (!var2.hasNext()) {
                return FarmlandWaterManager.hasBlockWaterTicket(level, pos);
            }

            nearbyPos = (BlockPos) var2.next();
        } while (!level.getFluidState(nearbyPos).is(FluidTags.WATER));

        return true;
    }

    public static void turnToRichSoil(BlockState state, Level level, BlockPos pos) {
        level.setBlockAndUpdate(pos, pushEntitiesUp(state, GDModBlocks.GOLDEN_SOIL.get().defaultBlockState(), level, pos));
    }

    public boolean isFertile(BlockState state, BlockGetter world, BlockPos pos) {
        if (state.is(GDModBlocks.GOLDEN_SOIL_FARMLAND.get())) {
            return state.getValue(MOISTURE) > 0;
        } else {
            return false;
        }
    }

    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource rand) {
        if (!state.canSurvive(level, pos)) {
            turnToRichSoil(state, level, pos);
        }

    }

    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        int moisture = state.getValue(MOISTURE);
        if (!hasWater(level, pos) && !level.isRainingAt(pos.above())) {
            if (moisture > 0) {
                level.setBlock(pos, state.setValue(MOISTURE, moisture - 1), 2);
            }
        } else if (moisture < 7) {
            level.setBlock(pos, state.setValue(MOISTURE, 7), 2);
        } else if (moisture == 7) {
            if (Configuration.RICH_SOIL_BOOST_CHANCE.get() == 0.0) {
                return;
            }

            BlockState aboveState = level.getBlockState(pos.above());
            Block aboveBlock = aboveState.getBlock();
            if (aboveState.is(ModTags.UNAFFECTED_BY_RICH_SOIL) || aboveBlock instanceof TallFlowerBlock) {
                return;
            }

            if (aboveBlock instanceof BonemealableBlock growable) {
                if ((double) MathUtils.RAND.nextFloat() <= Configuration.RICH_SOIL_BOOST_CHANCE.get() * 2 && growable.isValidBonemealTarget(level, pos.above(), aboveState, false) && ForgeHooks.onCropsGrowPre(level, pos.above(), aboveState, true)) {
                    growable.performBonemeal(level, level.random, pos.above(), aboveState);
                    if (!level.isClientSide) {
                        level.levelEvent(2005, pos.above(), 0);
                    }

                    ForgeHooks.onCropsGrowPost(level, pos.above(), aboveState);
                }
            }
        }

    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return !this.defaultBlockState().canSurvive(context.getLevel(), context.getClickedPos()) ? GDModBlocks.GOLDEN_SOIL.get().defaultBlockState() : super.getStateForPlacement(context);
    }
}
