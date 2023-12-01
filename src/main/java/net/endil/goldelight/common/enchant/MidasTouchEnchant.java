package net.endil.goldelight.common.enchant;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import vectorwing.farmersdelight.common.registry.ModEnchantments;

public class MidasTouchEnchant extends Enchantment {
    //確率で金の食べ物がドロップ
    public MidasTouchEnchant() {
        super(Rarity.RARE, ModEnchantments.KNIFE, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMinCost(int enchantmentLevel) {
        return enchantmentLevel * 10;
    }

    @Override
    public int getMaxCost(int enchantmentLevel) {
        return this.getMinCost(enchantmentLevel) + 30;
    }
    public boolean isTreasureOnly() {
        return true;
    }


}
