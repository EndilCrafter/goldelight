package net.endil.goldelight.common.effect;

import com.google.common.collect.Maps;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import org.jetbrains.annotations.NotNull;
import vectorwing.farmersdelight.common.registry.ModItems;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class ImmunityEffect extends MobEffect {
    public ImmunityEffect() {
        super(MobEffectCategory.BENEFICIAL, 0);
    }

    @Override
    public void applyEffectTick(@NotNull LivingEntity pLivingEntity, int pAmplifier) {
        cure(pLivingEntity);

    }
    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
    private void cure(LivingEntity consumer) {
        Iterator<MobEffectInstance> itr = consumer.getActiveEffects().iterator();
        ArrayList<MobEffect> compatibleEffects = new ArrayList();

        MobEffectInstance selectedEffect;
        while(itr.hasNext()) {
            selectedEffect = itr.next();
            if (selectedEffect.getEffect().getCategory().equals(MobEffectCategory.HARMFUL) && selectedEffect.isCurativeItem(new ItemStack(Items.MILK_BUCKET))) {
                compatibleEffects.add(selectedEffect.getEffect());
            }
        }

        if (!compatibleEffects.isEmpty()) {
            selectedEffect = consumer.getEffect(compatibleEffects.iterator().next());
            if (selectedEffect != null && !MinecraftForge.EVENT_BUS.post(new MobEffectEvent.Remove(consumer, selectedEffect))) {
                consumer.removeEffect(selectedEffect.getEffect());
            }
        }

    }
}
