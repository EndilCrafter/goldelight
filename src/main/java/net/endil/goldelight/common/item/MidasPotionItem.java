package net.endil.goldelight.common.item;

import net.endil.goldelight.common.entity.GoldenBee;
import net.endil.goldelight.common.entity.GoldenChicken;
import net.endil.goldelight.common.entity.GoldenCow;
import net.endil.goldelight.common.registry.GDModEntityTypes;
import net.endil.goldelight.common.registry.GDModParticles;
import net.endil.goldelight.common.registry.GDModSounds;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class MidasPotionItem extends Item {
    public MidasPotionItem(Properties pProperties) {
        super(pProperties);
    }
    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity entity, InteractionHand hand) {
        if (entity instanceof Cow) {
            if (!player.level().isClientSide) {
                GoldenCow goldenCow = ((Cow) entity).convertTo(GDModEntityTypes.GOLDEN_COW.get(), true);
                player.swing(hand);
                entity.playSound(GDModSounds.ENTITY_CONVERT_TO_GOLD.get());
                net.minecraftforge.event.ForgeEventFactory.onLivingConvert(entity, goldenCow);
            }
            if (!player.isCreative()) {
                player.setItemInHand(hand, stack.getCraftingRemainingItem());
            }
            return InteractionResult.sidedSuccess(player.level().isClientSide);
        } else if (entity instanceof Chicken) {
            if (!player.level().isClientSide) {
                GoldenChicken goldenChicken = ((Chicken) entity).convertTo(GDModEntityTypes.GOLDEN_CHICKEN.get(), true);
                player.swing(hand);
                entity.playSound(GDModSounds.ENTITY_CONVERT_TO_GOLD.get());
                net.minecraftforge.event.ForgeEventFactory.onLivingConvert(entity, goldenChicken);
            }
            if (!player.isCreative()) {
                player.setItemInHand(hand, stack.getCraftingRemainingItem());
            }
            return InteractionResult.sidedSuccess(player.level().isClientSide);
        } else if (entity instanceof Bee) {
            if (!player.level().isClientSide) {
                GoldenBee goldenBee = ((Bee) entity).convertTo(GDModEntityTypes.GOLDEN_BEE.get(), true);
                player.swing(hand);
                entity.playSound(GDModSounds.ENTITY_CONVERT_TO_GOLD.get(),1.0f, 1.0f);
                net.minecraftforge.event.ForgeEventFactory.onLivingConvert(entity, goldenBee);
            }
            if (!player.isCreative()) {
                player.setItemInHand(hand, stack.getCraftingRemainingItem());
            }
            return InteractionResult.sidedSuccess(player.level().isClientSide);
        }

        return InteractionResult.PASS;
    }
    public boolean isFoil(ItemStack pStack) {
        return true;
    }
}
