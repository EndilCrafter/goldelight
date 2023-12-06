package net.endil.goldelight.common.block.entity;

import net.minecraft.core.Direction;
import net.minecraftforge.items.IItemHandler;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.common.block.entity.inventory.CookingPotItemHandler;

public class GoldenCookingPotItemHandler extends CookingPotItemHandler {
    public GoldenCookingPotItemHandler(IItemHandler itemHandler, @Nullable Direction side) {
        super(itemHandler, side);
    }
}
