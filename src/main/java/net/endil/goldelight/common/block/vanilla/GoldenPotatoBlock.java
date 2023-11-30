package net.endil.goldelight.common.block.vanilla;

import net.endil.goldelight.common.registry.GDModItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.PotatoBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class GoldenPotatoBlock extends PotatoBlock {

    public GoldenPotatoBlock(BlockBehaviour.Properties pProperties) {
        super(pProperties);
    }

    protected ItemLike getBaseSeedId() {
        return GDModItems.GOLDEN_POTATO.get();
    }

}