package net.endil.goldelight.common.block.vanilla;

import net.endil.goldelight.common.registry.GDModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Optional;

public class GoldenMushroomBlock extends BushBlock implements BonemealableBlock {
    protected static final VoxelShape SHAPE = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 6.0D, 11.0D);
    private final ResourceKey<ConfiguredFeature<?, ?>> feature;

    public GoldenMushroomBlock(Properties pProperties, ResourceKey<ConfiguredFeature<?, ?>> pFeature) {
        super(pProperties);
        this.feature = pFeature;
    }

    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    protected boolean mayPlaceOn(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        return pState.isSolidRender(pLevel, pPos);
    }

    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        BlockPos blockpos = pPos.below();
        BlockState blockstate = pLevel.getBlockState(blockpos);
        if (blockstate.is(GDModTags.Blocks.GOLDEN_MUSHROOM_GROW_BLOCK)) {
            return true;
        } else {
            return pLevel.getRawBrightness(pPos, 0) < 13 && blockstate.canSustainPlant(pLevel, blockpos, net.minecraft.core.Direction.UP, this);
        }
    }
    public boolean growMushroom(ServerLevel pLevel, BlockPos pPos, BlockState pState, RandomSource pRandom) {
        Optional<? extends Holder<ConfiguredFeature<?, ?>>> optional = pLevel.registryAccess().registryOrThrow(Registries.CONFIGURED_FEATURE).getHolder(this.feature);
        if (optional.isEmpty()) {
            return false;
        } else {
            var event = net.minecraftforge.event.ForgeEventFactory.blockGrowFeature(pLevel, pRandom, pPos, optional.get());
            if (event.getResult().equals(net.minecraftforge.eventbus.api.Event.Result.DENY)) return false;
            pLevel.removeBlock(pPos, false);
            if (event.getFeature().value().place(pLevel, pLevel.getChunkSource().getGenerator(), pRandom, pPos)) {
                return true;
            } else {
                pLevel.setBlock(pPos, pState, 3);
                return false;
            }
        }
    }
    public boolean isValidBonemealTarget(LevelReader pLevel, BlockPos pPos, BlockState pState, boolean pIsClient) {
        return true;
    }

    public boolean isBonemealSuccess(Level pLevel, RandomSource pRandom, BlockPos pPos, BlockState pState) {
        return (double)pRandom.nextFloat() < 0.4D;
    }

    public void performBonemeal(ServerLevel pLevel, RandomSource pRandom, BlockPos pPos, BlockState pState) {
        this.growMushroom(pLevel, pPos, pState, pRandom);
    }
}
