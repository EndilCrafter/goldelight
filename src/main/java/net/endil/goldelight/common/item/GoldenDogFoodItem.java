package net.endil.goldelight.common.item;

import com.google.common.collect.Lists;
import net.endil.goldelight.common.registry.GDModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectUtil;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import vectorwing.farmersdelight.common.Configuration;
import vectorwing.farmersdelight.common.item.DogFoodItem;
import vectorwing.farmersdelight.common.registry.ModParticleTypes;
import vectorwing.farmersdelight.common.tag.ModTags;
import vectorwing.farmersdelight.common.utility.MathUtils;
import vectorwing.farmersdelight.common.utility.TextUtils;

import javax.annotation.Nullable;
import java.util.Iterator;
import java.util.List;

public class GoldenDogFoodItem extends DogFoodItem {
    public static final List<MobEffectInstance> EFFECTS;

    static {
        EFFECTS = Lists.newArrayList(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 12000, 2),
                new MobEffectInstance(MobEffects.DAMAGE_BOOST, 12000, 2),
                new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 12000, 2),
                new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 12000, 0),
                new MobEffectInstance(MobEffects.REGENERATION, 12000, 0));
    }

    public GoldenDogFoodItem(Properties properties) {
        super(properties);
    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag isAdvanced) {
        if (Configuration.FOOD_EFFECT_TOOLTIP.get()) {
            MutableComponent textWhenFeeding = TextUtils.getTranslation("tooltip.golden_dog_food.when_feeding");
            tooltip.add(textWhenFeeding.withStyle(ChatFormatting.GRAY));

            MutableComponent effectDescription;
            MobEffect effect;
            for (Iterator var6 = EFFECTS.iterator(); var6.hasNext(); tooltip.add(effectDescription.withStyle(effect.getCategory().getTooltipFormatting()))) {
                MobEffectInstance effectInstance = (MobEffectInstance) var6.next();
                effectDescription = Component.literal(" ");
                MutableComponent effectName = Component.translatable(effectInstance.getDescriptionId());
                effectDescription.append(effectName);
                effect = effectInstance.getEffect();
                if (effectInstance.getAmplifier() > 0) {
                    effectDescription.append(" ").append(Component.translatable("potion.potency." + effectInstance.getAmplifier()));
                }

                if (effectInstance.getDuration() > 20) {
                    effectDescription.append(" (").append(MobEffectUtil.formatDuration(effectInstance, 1.0F)).append(")");
                }
            }

        }
    }

    @Mod.EventBusSubscriber(
            modid = "goldelight",
            bus = Mod.EventBusSubscriber.Bus.FORGE
    )
    public static class GoldenDogFoodEvent {
        public GoldenDogFoodEvent() {
        }

        @SubscribeEvent
        public static void onDogFoodApplied(PlayerInteractEvent.EntityInteract event) {
            Player player = event.getEntity();
            Entity target = event.getTarget();
            ItemStack itemStack = event.getItemStack();
            if (target instanceof LivingEntity entity) {
                if (target.getType().is(ModTags.DOG_FOOD_USERS)) {
                    boolean isTameable = entity instanceof TamableAnimal;
                    if (entity.isAlive() && (!isTameable || ((TamableAnimal) entity).isTame()) && itemStack.getItem().equals(GDModItems.GOLDEN_DOG_FOOD.get())) {
                        entity.setHealth(entity.getMaxHealth());
                        Iterator var6 = GoldenDogFoodItem.EFFECTS.iterator();

                        while (var6.hasNext()) {
                            MobEffectInstance effect = (MobEffectInstance) var6.next();
                            entity.addEffect(new MobEffectInstance(effect));
                        }

                        entity.level().playSound(null, target.blockPosition(), SoundEvents.GENERIC_EAT, SoundSource.PLAYERS, 0.8F, 0.8F);

                        for (int i = 0; i < 5; ++i) {
                            double xSpeed = MathUtils.RAND.nextGaussian() * 0.02;
                            double ySpeed = MathUtils.RAND.nextGaussian() * 0.02;
                            double zSpeed = MathUtils.RAND.nextGaussian() * 0.02;
                            entity.level().addParticle(ModParticleTypes.STAR.get(), entity.getRandomX(1.0), entity.getRandomY() + 0.5, entity.getRandomZ(1.0), xSpeed, ySpeed, zSpeed);
                        }

                        if (itemStack.getCraftingRemainingItem() != ItemStack.EMPTY && !player.isCreative()) {
                            player.addItem(itemStack.getCraftingRemainingItem());
                            itemStack.shrink(1);
                        }

                        event.setCancellationResult(InteractionResult.SUCCESS);
                        event.setCanceled(true);
                    }
                }
            }

        }
    }
}
