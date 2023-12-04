package net.endil.goldelight.common.block.vanilla;

import net.endil.goldelight.common.registry.GDModBlocks;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import org.jetbrains.annotations.Nullable;

public class GoldenStemBlock extends RotatedPillarBlock {
    public GoldenStemBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
        if (context.getItemInHand().getItem() instanceof AxeItem) {
            if (state.is(GDModBlocks.GOLDEN_STEM.get())) {
                return GDModBlocks.STRIPPED_GOLDEN_STEM.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if (state.is(GDModBlocks.GOLDEN_HYPHAE.get())) {
                return GDModBlocks.STRIPPED_GOLDEN_HYPHAE.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
        }
        return super.getToolModifiedState(state, context, toolAction, simulate);
    }
}
