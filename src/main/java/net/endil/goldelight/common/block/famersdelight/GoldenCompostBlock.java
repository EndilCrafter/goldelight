package net.endil.goldelight.common.block.famersdelight;

import net.endil.goldelight.common.registry.GDModBlocks;
import net.endil.goldelight.common.registry.GDModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.state.BlockState;
import vectorwing.farmersdelight.common.block.OrganicCompostBlock;
import vectorwing.farmersdelight.common.tag.ModTags;

public class GoldenCompostBlock extends OrganicCompostBlock {
    public GoldenCompostBlock(Properties properties) {
        super(properties);
    }
    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!level.isClientSide) {
            float chance = 0.0F;
            boolean hasWater = false;
            int maxLight = 0;

            for (BlockPos neighborPos : BlockPos.betweenClosed(pos.offset(-1, -1, -1), pos.offset(1, 1, 1))) {
                BlockState neighborState = level.getBlockState(neighborPos);
                if (neighborState.is(GDModTags.Blocks.GOLDEN_COMPOST_ACTIVATORS)) {
                    chance += 0.02F;
                }

                if (neighborState.getFluidState().is(FluidTags.WATER)) {
                    hasWater = true;
                }

                int light = level.getBrightness(LightLayer.SKY, neighborPos.above());
                if (light > maxLight) {
                    maxLight = light;
                }
            }

            chance += maxLight > 12 ? 0.1F : 0.05F;
            chance += hasWater ? 0.1F : 0.0F;
            if (level.getRandom().nextFloat() <= chance) {
                if (state.getValue(COMPOSTING) == this.getMaxCompostingStage()) {
                    level.setBlock(pos, GDModBlocks.GOLDEN_SOIL.get().defaultBlockState(), 3);
                } else {
                    level.setBlock(pos, state.setValue(COMPOSTING, state.getValue(COMPOSTING) + 1), 3);
                }
            }

        }
    }
}
