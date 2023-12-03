package net.endil.goldelight.common.block.famersdelight;

import net.minecraft.world.level.ItemLike;
import vectorwing.farmersdelight.common.block.BuddingBushBlock;
import vectorwing.farmersdelight.common.registry.ModItems;

public class BuddingGoldenBushBlock extends BuddingBushBlock {
    public BuddingGoldenBushBlock(Properties properties) {
        super(properties);
    }

    protected ItemLike getBaseSeedId() {
        return ModItems.TOMATO_SEEDS.get();
    }
}
