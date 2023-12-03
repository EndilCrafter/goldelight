package net.endil.goldelight.common.block.famersdelight;

import net.endil.goldelight.common.registry.GDModBlocks;
import net.endil.goldelight.common.registry.GDModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import vectorwing.farmersdelight.common.block.TomatoVineBlock;
import vectorwing.farmersdelight.common.registry.ModSounds;

public class GoldenTomatoVineBlock extends TomatoVineBlock {
    public GoldenTomatoVineBlock(Properties properties) {
        super(properties);
    }

    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        int age = state.getValue(this.getAgeProperty());
        boolean isMature = age == this.getMaxAge();
        if (!isMature && player.getItemInHand(hand).is(Items.BONE_MEAL)) {
            return InteractionResult.PASS;
        } else if (isMature) {
            int quantity = 1 + level.random.nextInt(2);
            popResource(level, pos, new ItemStack(GDModItems.GOLDEN_TOMATO.get(), quantity));
            if ((double) level.random.nextFloat() < 0.05) {
                popResource(level, pos, new ItemStack(GDModItems.ROTTEN_GOLDEN_TOMATO.get()));
            }

            level.playSound(null, pos, ModSounds.ITEM_TOMATO_PICK_FROM_BUSH.get(), SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
            level.setBlock(pos, state.setValue(this.getAgeProperty(), 0), 2);
            return InteractionResult.SUCCESS;
        } else {
            return super.use(state, level, pos, player, hand, hit);
        }
    }

    protected ItemLike getBaseSeedId() {
        return GDModItems.GOLDEN_TOMATO_SEEDS.get();
    }

    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos belowPos = pos.below();
        BlockState belowState = level.getBlockState(belowPos);
        if (!(Boolean) state.getValue(ROPELOGGED)) {
            return super.canSurvive(state, level, pos);
        } else {
            return belowState.is(GDModBlocks.GOLDEN_TOMATO_CROP.get()) && this.hasGoodCropConditions(level, pos);
        }
    }
}
