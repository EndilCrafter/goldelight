package net.endil.goldelight.common.block.vanilla;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class GoldenHayBlock extends RotatedPillarBlock {
    public GoldenHayBlock(BlockBehaviour.Properties p_53976_) {
        super(p_53976_);
        this.registerDefaultState(this.stateDefinition.any().setValue(AXIS, Direction.Axis.Y));
    }

    public void fallOn(Level p_153362_, BlockState state, BlockPos pos, Entity entity, float pFallDistance) {
        entity.causeFallDamage(pFallDistance, 0.1F, p_153362_.damageSources().fall());
    }
}