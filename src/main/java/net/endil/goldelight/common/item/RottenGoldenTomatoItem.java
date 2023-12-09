package net.endil.goldelight.common.item;

import net.endil.goldelight.common.entity.RottenGoldenTomato;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import vectorwing.farmersdelight.common.entity.RottenTomatoEntity;
import vectorwing.farmersdelight.common.registry.ModSounds;

public class RottenGoldenTomatoItem extends Item {
    public RottenGoldenTomatoItem(Properties pProperties) {
        super(pProperties);
    }
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack heldStack = player.getItemInHand(hand);
        level.playSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.ENTITY_ROTTEN_TOMATO_THROW.get(), SoundSource.NEUTRAL, 0.5F, 0.4F / (level.random.nextFloat() * 0.4F + 0.8F));
        if (!level.isClientSide) {
            RottenGoldenTomato projectile = new RottenGoldenTomato(level, player);
            projectile.setItem(heldStack);
            projectile.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
            level.addFreshEntity(projectile);
        }

        player.awardStat(Stats.ITEM_USED.get(this));
        if (!player.getAbilities().instabuild) {
            heldStack.shrink(1);
        }

        return InteractionResultHolder.sidedSuccess(heldStack, level.isClientSide());
    }
}
