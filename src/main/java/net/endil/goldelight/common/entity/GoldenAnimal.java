package net.endil.goldelight.common.entity;

import net.endil.goldelight.common.registry.GDModItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public abstract class GoldenAnimal extends Animal {
    protected GoldenAnimal(EntityType<? extends GoldenAnimal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }
    public int getExperienceReward() {
        return 2 + this.level().random.nextInt(4);
    }
    public boolean isFood(ItemStack pStack) {
        return pStack.is(GDModItems.GOLDEN_WHEAT.get());
    }
}
