package net.endil.goldelight.common.item;

import net.endil.goldelight.GolDelight;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.SmithingTemplateItem;

import java.util.List;

public class AncientGoldUpgradeSmithingTemplateItem {
    private static final ChatFormatting TITLE = ChatFormatting.GRAY;
    private static final ChatFormatting DESCRIPTION = ChatFormatting.BLUE;
    private static final ResourceLocation NETHERITE_KNIFE = new ResourceLocation(GolDelight.MOD_ID, "item/empty_slot_netherite_knife");
    private static final ResourceLocation INGOT = new ResourceLocation("item/empty_slot_ingot");

    private static final Component APPLIES_TO = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(GolDelight.MOD_ID, "smithing_template.ancient_gold_upgrade.applies_to"))).withStyle(DESCRIPTION);
    private static final Component INGREDIENTS = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(GolDelight.MOD_ID, "smithing_template.ancient_gold_upgrade.ingredients"))).withStyle(DESCRIPTION);
    private static final Component BASE_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(GolDelight.MOD_ID, "smithing_template.ancient_gold_upgrade.base_slot_description")));
    private static final Component ADDITIONS_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(GolDelight.MOD_ID, "smithing_template.ancient_gold_upgrade.additions_slot_description")));
    private static final Component UPGRADE = Component.translatable(Util.makeDescriptionId("upgrade", new ResourceLocation(GolDelight.MOD_ID, "ancient_gold_upgrade"))).withStyle(TITLE);

    private static List<ResourceLocation> createAncientGoldUpgradeIconList() {
        return List.of(NETHERITE_KNIFE);
    }

    private static List<ResourceLocation> createAncientGoldUpgradeMaterialList() {
        return List.of(INGOT);
    }

    public static SmithingTemplateItem createAncientGoldUpgradeSmithingTemplate() {
        return new SmithingTemplateItem(APPLIES_TO, INGREDIENTS, UPGRADE, BASE_SLOT_DESCRIPTION, ADDITIONS_SLOT_DESCRIPTION, createAncientGoldUpgradeIconList(), createAncientGoldUpgradeMaterialList());
    }
}
