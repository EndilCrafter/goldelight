package net.endil.goldelight.common.block.vanilla;

import net.endil.goldelight.common.block.entity.GDModHangingSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class GDModCeilingHangingSignBlock extends CeilingHangingSignBlock {
    public GDModCeilingHangingSignBlock(Properties pProperties, WoodType pType) {
        super(pProperties, pType);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new GDModHangingSignBlockEntity(pPos, pState);
    }
}
