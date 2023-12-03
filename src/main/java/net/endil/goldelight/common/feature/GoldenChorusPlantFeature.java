package net.endil.goldelight.common.feature;

import com.mojang.serialization.Codec;
import net.endil.goldelight.common.block.vanilla.GoldenChorusFlowerBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ChorusPlantFeature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class GoldenChorusPlantFeature extends ChorusPlantFeature {
    public GoldenChorusPlantFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> p_159521_) {
        WorldGenLevel worldgenlevel = p_159521_.level();
        BlockPos blockpos = p_159521_.origin();
        RandomSource randomsource = p_159521_.random();
        if (worldgenlevel.isEmptyBlock(blockpos) && worldgenlevel.getBlockState(blockpos.below()).is(Blocks.END_STONE)) {
            GoldenChorusFlowerBlock.generatePlant(worldgenlevel, blockpos, randomsource, 8);
            return true;
        } else {
            return false;
        }
    }
}
