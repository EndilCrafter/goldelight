package net.endil.goldelight.common.mixin;

import net.endil.goldelight.common.registry.GDModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.Feature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Feature.class)
public class KeepGoldenSoilGiantTreeMixin {
    @Inject(at = @At(value = "HEAD"), method = "isGrassOrDirt", cancellable = true)
    private static void keepGoldenSoil(LevelSimulatedReader world, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        if (world.isStateAtPosition(pos, state -> state.is(GDModBlocks.GOLDEN_SOIL.get()))) {
            cir.setReturnValue(false);
            cir.cancel();
        }
    }
}
