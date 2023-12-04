package net.endil.goldelight.common.block.entity;

import net.endil.goldelight.common.registry.GDModBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class GDModSignBlockEntity extends SignBlockEntity {
    public GDModSignBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(GDModBlockEntityTypes.MOD_SIGN.get(), pPos, pBlockState);
    }

    @Override
    public BlockEntityType<?> getType() {
        return GDModBlockEntityTypes.MOD_SIGN.get();
    }
}
