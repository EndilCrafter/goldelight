package net.endil.goldelight.common.block.vanilla;

import net.endil.goldelight.common.registry.GDModItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.CarrotBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.jetbrains.annotations.NotNull;

public class GoldenCarrotBlock extends CarrotBlock {
    public GoldenCarrotBlock(BlockBehaviour.Properties pProperties) {
        super(pProperties);
    }

    protected @NotNull ItemLike getBaseSeedId() {
        return GDModItems.GOLDEN_CARROT.get();
    }

}