package net.endil.goldelight.common.item;

import net.endil.goldelight.GolDelight;
import net.endil.goldelight.common.registry.GDModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class GDModToolTiers {
    public static final Tier ANCIENT_GOLD = TierSortingRegistry.registerTier(
            new ForgeTier(4, 2031, 12.0F, 4.0F, 22,
                    Tags.Blocks.NEEDS_NETHERITE_TOOL, () -> Ingredient.of(GDModItems.ANCIENT_GOLD_INGOT.get())),
            new ResourceLocation(GolDelight.MOD_ID, "ancient_gold"), List.of(Tiers.NETHERITE), List.of());
}
