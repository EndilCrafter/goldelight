package net.endil.goldelight.common.block.vanilla;

import net.endil.goldelight.common.registry.GDModBlocks;
import net.minecraft.world.level.block.AttachedStemBlock;
import net.minecraft.world.level.block.StemBlock;
import net.minecraft.world.level.block.StemGrownBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class GoldenMelonBlock extends StemGrownBlock {
    public GoldenMelonBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    public StemBlock getStem() {
        return (StemBlock) GDModBlocks.GOLDEN_MELON_STEM.get();
    }

    public AttachedStemBlock getAttachedStem() {
        return (AttachedStemBlock) GDModBlocks.ATTACHED_GOLDEN_MELON_STEM.get();
    }
}