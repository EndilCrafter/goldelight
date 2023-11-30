package net.endil.goldelight.common.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.MobEffectEvent;

import java.util.ArrayList;
import java.util.Iterator;

public class ImmunityEffect extends MobEffect {
    public ImmunityEffect() {
        super(MobEffectCategory.BENEFICIAL, 0);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        Iterator<MobEffectInstance> itr = pLivingEntity.getActiveEffects().iterator();
        ArrayList<MobEffect> compatibleEffects = new ArrayList<>();
        MobEffectInstance selectedEffect;

            selectedEffect = itr.next();
            if (selectedEffect.getEffect().getCategory().equals(MobEffectCategory.HARMFUL) && selectedEffect.isCurativeItem(new ItemStack(Items.MILK_BUCKET))) {
                compatibleEffects.add(selectedEffect.getEffect());
            }

        if (!compatibleEffects.isEmpty()) {
            if (!MinecraftForge.EVENT_BUS.post(new MobEffectEvent.Remove(pLivingEntity, selectedEffect))) {
                pLivingEntity.removeEffect(selectedEffect.getEffect());

            }

        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
