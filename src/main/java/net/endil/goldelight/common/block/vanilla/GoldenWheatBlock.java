package net.endil.goldelight.common.block.vanilla;

import net.endil.goldelight.common.registry.GDModItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.CropBlock;

public class GoldenWheatBlock extends CropBlock {
    public GoldenWheatBlock(Properties pProperties) {
        super(pProperties);
    }

    protected ItemLike getBaseSeedId() {
        return GDModItems.GOLDEN_WHEAT_SEEDS.get();
    }
}
