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
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import vectorwing.farmersdelight.common.Configuration;
import vectorwing.farmersdelight.common.item.HorseFeedItem;
import vectorwing.farmersdelight.common.registry.ModParticleTypes;
import vectorwing.farmersdelight.common.tag.ModTags;
import vectorwing.farmersdelight.common.utility.MathUtils;
import vectorwing.farmersdelight.common.utility.TextUtils;

import javax.annotation.Nullable;
import java.util.Iterator;
import java.util.List;

public class GoldenHorseFeedItem extends HorseFeedItem {
    public static final List<MobEffectInstance> EFFECTS;

    static {
        EFFECTS = Lists.newArrayList(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 18000, 2),
                new MobEffectInstance(MobEffects.JUMP, 18000, 1),
                new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 18000, 0),
                new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 18000, 0),
                new MobEffectInstance(MobEffects.REGENERATION, 18000, 0));
    }

    public GoldenHorseFeedItem(Properties properties) {
        super(properties);
    }

    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag isAdvanced) {
        if (Configuration.FOOD_EFFECT_TOOLTIP.get()) {
            MutableComponent textWhenFeeding = TextUtils.getTranslation("tooltip.horse_feed.when_feeding");
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
    public static class HorseFeedEvent {
        public HorseFeedEvent() {
        }

        @SubscribeEvent
        public static void onHorseFeedApplied(PlayerInteractEvent.EntityInteract event) {
            Player player = event.getEntity();
            Entity target = event.getTarget();
            ItemStack heldStack = event.getItemStack();
            if (target instanceof LivingEntity entity) {
                if (target.getType().is(ModTags.HORSE_FEED_USERS)) {
                    boolean isTameable = entity instanceof AbstractHorse;
                    if (entity.isAlive() && (!isTameable || ((AbstractHorse) entity).isTamed()) && heldStack.getItem().equals(GDModItems.GOLDEN_HORSE_FEED.get())) {
                        entity.setHealth(entity.getMaxHealth());
                        Iterator var6 = GoldenHorseFeedItem.EFFECTS.iterator();

                        while (var6.hasNext()) {
                            MobEffectInstance effect = (MobEffectInstance) var6.next();
                            entity.addEffect(new MobEffectInstance(effect));
                        }

                        entity.level().playSound(null, target.blockPosition(), SoundEvents.HORSE_EAT, SoundSource.PLAYERS, 0.8F, 0.8F);

                        for (int i = 0; i < 5; ++i) {
                            double d0 = MathUtils.RAND.nextGaussian() * 0.02;
                            double d1 = MathUtils.RAND.nextGaussian() * 0.02;
                            double d2 = MathUtils.RAND.nextGaussian() * 0.02;
                            entity.level().addParticle(ModParticleTypes.STAR.get(), entity.getRandomX(1.0), entity.getRandomY() + 0.5, entity.getRandomZ(1.0), d0, d1, d2);
                        }

                        if (!player.isCreative()) {
                            heldStack.shrink(1);
                        }

                        event.setCancellationResult(InteractionResult.SUCCESS);
                        event.setCanceled(true);
                    }
                }
            }

        }
    }
}
