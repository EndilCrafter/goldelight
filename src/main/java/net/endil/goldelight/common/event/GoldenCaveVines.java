package net.endil.goldelight.common.event;

import net.endil.goldelight.common.registry.GDModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CaveVines;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

import javax.annotation.Nullable;

public interface GoldenCaveVines extends CaveVines {
    static InteractionResult use(@Nullable Entity pEntity, BlockState pState, Level pLevel, BlockPos pPos) {
        if (pState.getValue(BERRIES)) {
            Block.popResource(pLevel, pPos, new ItemStack(GDModItems.GOLDEN_GLOW_BERRIES.get(), 1));
            float f = Mth.randomBetween(pLevel.random, 0.8F, 1.2F);
            pLevel.playSound(null, pPos, SoundEvents.CAVE_VINES_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, f);
            BlockState blockstate = pState.setValue(BERRIES, Boolean.valueOf(false));
            pLevel.setBlock(pPos, blockstate, 2);
            pLevel.gameEvent(GameEvent.BLOCK_CHANGE, pPos, GameEvent.Context.of(pEntity, blockstate));
            return InteractionResult.sidedSuccess(pLevel.isClientSide);
        } else {
            return InteractionResult.PASS;
        }
    }
}
