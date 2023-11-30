package net.endil.goldelight.common.block.vanilla;

import net.endil.goldelight.common.event.GoldenCaveVines;
import net.endil.goldelight.common.registry.GDModBlocks;
import net.endil.goldelight.common.registry.GDModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CaveVinesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class GoldenCaveVinesBlock extends CaveVinesBlock {
    public GoldenCaveVinesBlock(Properties properties) {
        super(properties);
    }

    protected Block getBodyBlock() {
        return GDModBlocks.GOLDEN_CAVE_VINES_PLANT.get();
    }

    public ItemStack getCloneItemStack(BlockGetter blockGetter, BlockPos pos, BlockState state) {
        return new ItemStack(GDModItems.GOLDEN_GLOW_BERRIES.get());
    }

    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        return GoldenCaveVines.use(player, state, level, pos);
    }
}
