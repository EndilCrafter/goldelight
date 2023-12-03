package net.endil.goldelight.common.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import vectorwing.farmersdelight.common.item.MelonJuiceItem;

public class GoldenMelonJuiceItem extends MelonJuiceItem {
    public GoldenMelonJuiceItem(Properties properties) {
        super(properties);
    }

    public void affectConsumer(ItemStack stack, Level level, LivingEntity consumer) {
        consumer.heal(4.0F);
    }
}
