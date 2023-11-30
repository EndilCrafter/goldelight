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
import net.minecraft.world.level.block.CaveVinesPlantBlock;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class GoldenCaveVinesPlantBlock extends CaveVinesPlantBlock {
    public GoldenCaveVinesPlantBlock(Properties properties) {
        super(properties);
    }

    protected GrowingPlantHeadBlock getHeadBlock() {
        return (GrowingPlantHeadBlock) GDModBlocks.GOLDEN_CAVE_VINES.get();
    }

    public ItemStack getCloneItemStack(BlockGetter blockGetter, BlockPos pos, BlockState state) {
        return new ItemStack(GDModItems.GOLDEN_GLOW_BERRIES.get());
    }

    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        return GoldenCaveVines.use(player, state, level, pos);
    }
}
