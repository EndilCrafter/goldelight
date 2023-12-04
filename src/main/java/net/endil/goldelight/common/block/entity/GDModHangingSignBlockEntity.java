package net.endil.goldelight.common.block.entity;

import net.endil.goldelight.common.registry.GDModBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class GDModHangingSignBlockEntity extends SignBlockEntity {
    public GDModHangingSignBlockEntity(BlockPos pos, BlockState state) {
        super(GDModBlockEntityTypes.MOD_HANGING_SIGN.get(), pos, state);
    }

    @Override
    public BlockEntityType<?> getType() {
        return GDModBlockEntityTypes.MOD_HANGING_SIGN.get();
    }
}
