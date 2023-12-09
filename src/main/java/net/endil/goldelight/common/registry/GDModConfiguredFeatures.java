package net.endil.goldelight.common.registry;

import net.endil.goldelight.GolDelight;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.HugeFungusConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.HugeMushroomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import vectorwing.farmersdelight.common.registry.ModBlocks;

public class GDModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> HUGE_GOLDEN_MUSHROOM = registerKey("huge_golden_mushroom");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GOLDEN_FUNGUS_PLANTED = registerKey("golden_fungus_planted");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        register(context, HUGE_GOLDEN_MUSHROOM, Feature.HUGE_RED_MUSHROOM, new HugeMushroomFeatureConfiguration(
                BlockStateProvider.simple(GDModBlocks.GOLDEN_MUSHROOM_BLOCK.get().defaultBlockState().setValue(HugeMushroomBlock.DOWN, Boolean.valueOf(false))),
                BlockStateProvider.simple(GDModBlocks.GOLDEN_MUSHROOM_STEM.get().defaultBlockState().setValue(HugeMushroomBlock.UP, Boolean.valueOf(false)).setValue(HugeMushroomBlock.DOWN, Boolean.valueOf(false))), 2));
        register(context, GOLDEN_FUNGUS_PLANTED, Feature.HUGE_FUNGUS, new HugeFungusConfiguration(
                ModBlocks.RICH_SOIL.get().defaultBlockState(), GDModBlocks.GOLDEN_STEM.get().defaultBlockState(), GDModBlocks.GOLDEN_WART_BLOCK.get().defaultBlockState(), GDModBlocks.GROOMLIGHT.get().defaultBlockState(), BlockPredicate.matchesBlocks(GDModBlocks.GOLDEN_FUNGUS.get()), true));
    }


    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(GolDelight.MOD_ID, name));
    }

    public static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC config) {
        context.register(key, new ConfiguredFeature<>(feature, config));
    }
}
