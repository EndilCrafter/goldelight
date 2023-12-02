package net.endil.goldelight.common.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class MildnessEffect extends MobEffect {
    public MildnessEffect() {
        super(MobEffectCategory.BENEFICIAL, 0);
    }
    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if (pLivingEntity.isFreezing()) {
            pLivingEntity.setTicksFrozen(0);
        }
    }
    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }

}
