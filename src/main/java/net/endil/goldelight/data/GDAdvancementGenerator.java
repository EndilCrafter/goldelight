package net.endil.goldelight.data;

import accieo.midas.hunger.registry.ItemRegistry;
import net.endil.goldelight.GDTextUtils;
import net.endil.goldelight.GolDelight;
import net.endil.goldelight.common.registry.GDModBlocks;
import net.endil.goldelight.common.registry.GDModEffects;
import net.endil.goldelight.common.registry.GDModItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;

import java.util.function.Consumer;

public class GDAdvancementGenerator implements ForgeAdvancementProvider.AdvancementGenerator {
    protected static Advancement.Builder getAdvancement(Advancement parent, ItemLike display, String name, FrameType frame, boolean showToast, boolean announceToChat, boolean hidden) {
        return Advancement.Builder.advancement().parent(parent).display(display,
                GDTextUtils.getTranslation("advancement." + name),
                GDTextUtils.getTranslation("advancement." + name + ".desc"),
                null, frame, showToast, announceToChat, hidden);
    }

    @Override
    public void generate(HolderLookup.Provider registries, Consumer<Advancement> consumer, ExistingFileHelper existingFileHelper) {
        Advancement goDelight = Advancement.Builder.advancement()
                .display(GDModItems.GOLDEN_COOKING_POT.get(),
                        GDTextUtils.getTranslation("advancement.root"),
                        GDTextUtils.getTranslation("advancement.root.desc"),
                        new ResourceLocation("goldelight:textures/block/golden_nether_bricks.png"),
                        FrameType.TASK, false, false, false)
                .addCriterion("seeds", InventoryChangeTrigger.TriggerInstance.hasItems(new ItemLike[]{}))
                .save(consumer, getNameId("main/root"));

        //Crop
        Advancement cropsOfTheGold = getAdvancement(goDelight, GDModItems.GOLDEN_WHEAT_SEEDS.get(), "get_gd_seed", FrameType.TASK, true, false, false)
                .addCriterion("golden_cabbage_seeds", InventoryChangeTrigger.TriggerInstance.hasItems(GDModItems.GOLDEN_CABBAGE_SEEDS.get()))
                .addCriterion("golden_tomato_seeds", InventoryChangeTrigger.TriggerInstance.hasItems(GDModItems.GOLDEN_TOMATO_SEEDS.get()))
                .addCriterion("golden_onion", InventoryChangeTrigger.TriggerInstance.hasItems(GDModItems.GOLDEN_ONION.get()))
                .addCriterion("golden_rice", InventoryChangeTrigger.TriggerInstance.hasItems(GDModItems.GOLDEN_RICE.get()))
                .addCriterion("golden_wheat_seeds", InventoryChangeTrigger.TriggerInstance.hasItems(GDModItems.GOLDEN_WHEAT_SEEDS.get()))
                .addCriterion("golden_melon_seeds", InventoryChangeTrigger.TriggerInstance.hasItems(GDModItems.GOLDEN_MELON_SEEDS.get()))
                .addCriterion("golden_pumpkin_seeds", InventoryChangeTrigger.TriggerInstance.hasItems(GDModItems.GOLDEN_PUMPKIN_SEEDS.get()))
                .addCriterion("golden_beetroot_seeds", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.GOLDEN_BEETROOT_SEEDS.get()))
                .requirements(RequirementsStrategy.OR)
                .save(consumer, getNameId("main/get_gd_seed"));

        Advancement isThisBeDecomposed = getAdvancement(cropsOfTheGold, GDModBlocks.GOLDEN_COMPOST.get(), "place_golden_compost", FrameType.TASK, true, false, false)
                .addCriterion("place_golden_compost", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(GDModBlocks.GOLDEN_COMPOST.get()))
                .save(consumer, getNameId("main/place_golden_compost"));

        Advancement kingMushroom = getAdvancement(isThisBeDecomposed, GDModItems.GOLDEN_MUSHROOM_COLONY.get(), "get_golden_mushroom_colony", FrameType.TASK, true, false, false)
                .addCriterion("golden_mushroom_colony", InventoryChangeTrigger.TriggerInstance.hasItems(GDModItems.GOLDEN_MUSHROOM_COLONY.get()))
                .save(consumer, getNameId("main/get_golden_mushroom_colony"));

        Advancement decomposersSeriousness = getAdvancement(isThisBeDecomposed, GDModBlocks.GOLDEN_SOIL.get(), "place_golden_soil", FrameType.GOAL, true, false, false)
                .addCriterion("place_golden_soil", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(GDModBlocks.GOLDEN_SOIL.get()))
                .save(consumer, getNameId("main/place_golden_soil"));

        Advancement hardToTellApart = getAdvancement(cropsOfTheGold, GDModBlocks.GOLDEN_CARROT_CRATE.get(), "get_all_gd_crates", FrameType.TASK, true, false, false)
                .addCriterion("golden_carrot_crate", InventoryChangeTrigger.TriggerInstance.hasItems(GDModBlocks.GOLDEN_CARROT_CRATE.get()))
                .addCriterion("golden_potato_crate", InventoryChangeTrigger.TriggerInstance.hasItems(GDModBlocks.GOLDEN_POTATO_CRATE.get()))
                .addCriterion("golden_beetroot_crate", InventoryChangeTrigger.TriggerInstance.hasItems(GDModBlocks.GOLDEN_BEETROOT_CRATE.get()))
                .addCriterion("golden_cabbage_crate", InventoryChangeTrigger.TriggerInstance.hasItems(GDModBlocks.GOLDEN_CABBAGE_CRATE.get()))
                .addCriterion("golden_tomato_crate", InventoryChangeTrigger.TriggerInstance.hasItems(GDModBlocks.GOLDEN_TOMATO_CRATE.get()))
                .addCriterion("golden_onion_crate", InventoryChangeTrigger.TriggerInstance.hasItems(GDModBlocks.GOLDEN_ONION_CRATE.get()))
                .save(consumer, getNameId("main/get_all_gd_crates"));

        //Cooking
        Advancement aGoldForAGold = getAdvancement(goDelight, GDModItems.GOLDEN_COOKING_POT.get(), "place_golden_cooking_pot", FrameType.TASK, true, false, false)
                .addCriterion("place_golden_cooking_pot", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(GDModBlocks.GOLDEN_COOKING_POT.get()))
                .save(consumer, getNameId("main/place_golden_cooking_pot"));

        Advancement theColdNeverBotheredMeAnyway = getAdvancement(aGoldForAGold, GDModItems.GOLDEN_HOT_COCOA.get(), "drink_golden_hot_cocoa", FrameType.TASK, true, false, false)
                .addCriterion("drink_golden_hot_cocoa", EffectsChangedTrigger.TriggerInstance.hasEffects(MobEffectsPredicate.effects().and(GDModEffects.MILDNESS.get())))
                .save(consumer, getNameId("main/drink_golden_hot_cocoa"));

        Advancement doNotNeedDoctorsAnymore = getAdvancement(theColdNeverBotheredMeAnyway, GDModItems.GOLDEN_SHEPHERDS_PIE_BLOCK.get(), "eat_golden_shepherds_pie", FrameType.GOAL, true, false, false)
                .addCriterion("eat_golden_shepherds_pie", EffectsChangedTrigger.TriggerInstance.hasEffects(MobEffectsPredicate.effects().and(GDModEffects.IMMUNITY.get())))
                .save(consumer, getNameId("main/eat_golden_shepherds_pie"));

        Advancement avatarOfAvarice = getAdvancement(doNotNeedDoctorsAnymore, GDModItems.GOLDEN_GLAZED_HAM.get(), "avarice", FrameType.CHALLENGE, true, false, false)
                .addCriterion("mixed_golden_salad", ConsumeItemTrigger.TriggerInstance.usedItem(GDModItems.MIXED_GOLDEN_SALAD.get()))
                .addCriterion("golden_beef_stew", ConsumeItemTrigger.TriggerInstance.usedItem(GDModItems.GOLDEN_BEEF_STEW.get()))
                .addCriterion("golden_chicken_soup", ConsumeItemTrigger.TriggerInstance.usedItem(GDModItems.GOLDEN_CHICKEN_SOUP.get()))
                .addCriterion("golden_vegetable_soup", ConsumeItemTrigger.TriggerInstance.usedItem(GDModItems.GOLDEN_VEGETABLE_SOUP.get()))
                .addCriterion("golden_fish_stew", ConsumeItemTrigger.TriggerInstance.usedItem(GDModItems.GOLDEN_FISH_STEW.get()))
                .addCriterion("fried_golden_rice", ConsumeItemTrigger.TriggerInstance.usedItem(GDModItems.FRIED_GOLDEN_RICE.get()))
                .addCriterion("golden_pumpkin_soup", ConsumeItemTrigger.TriggerInstance.usedItem(GDModItems.GOLDEN_PUMPKIN_SOUP.get()))
                .addCriterion("golden_baked_cod_stew", ConsumeItemTrigger.TriggerInstance.usedItem(GDModItems.GOLDEN_BAKED_COD_STEW.get()))
                .addCriterion("golden_noodle_soup", ConsumeItemTrigger.TriggerInstance.usedItem(GDModItems.GOLDEN_NOODLE_SOUP.get()))
                .addCriterion("golden_pasta_with_meatballs", ConsumeItemTrigger.TriggerInstance.usedItem(GDModItems.GOLDEN_PASTA_WITH_MEATBALLS.get()))
                .addCriterion("golden_pasta_with_mutton_chop", ConsumeItemTrigger.TriggerInstance.usedItem(GDModItems.GOLDEN_PASTA_WITH_MUTTON_CHOP.get()))
                .addCriterion("roasted_golden_chops", ConsumeItemTrigger.TriggerInstance.usedItem(GDModItems.ROASTED_GOLDEN_CHOPS.get()))
                .addCriterion("golden_vegetable_noodles", ConsumeItemTrigger.TriggerInstance.usedItem(GDModItems.GOLDEN_VEGETABLE_NOODLES.get()))
                .addCriterion("golden_steak_and_potatoes", ConsumeItemTrigger.TriggerInstance.usedItem(GDModItems.GOLDEN_STEAK_AND_POTATOES.get()))
                .addCriterion("golden_ratatouille", ConsumeItemTrigger.TriggerInstance.usedItem(GDModItems.GOLDEN_RATATOUILLE.get()))
                .addCriterion("golden_ink_pasta", ConsumeItemTrigger.TriggerInstance.usedItem(GDModItems.GOLDEN_INK_PASTA.get()))
                .addCriterion("grilled_golden_salmon", ConsumeItemTrigger.TriggerInstance.usedItem(GDModItems.GRILLED_GOLDEN_SALMON.get()))
                .addCriterion("golden_roast_chicken", ConsumeItemTrigger.TriggerInstance.usedItem(GDModItems.GOLDEN_ROAST_CHICKEN.get()))
                .addCriterion("stuffed_golden_pumpkin", ConsumeItemTrigger.TriggerInstance.usedItem(GDModItems.STUFFED_GOLDEN_PUMPKIN.get()))
                .addCriterion("golden_glazed_ham", ConsumeItemTrigger.TriggerInstance.usedItem(GDModItems.GOLDEN_GLAZED_HAM.get()))
                .addCriterion("golden_shepherds_pie", ConsumeItemTrigger.TriggerInstance.usedItem(GDModItems.GOLDEN_SHEPHERDS_PIE.get()))
                .addCriterion("golden_bacon_and_eggs", ConsumeItemTrigger.TriggerInstance.usedItem(GDModItems.GOLDEN_BACON_AND_EGGS.get()))
                .addCriterion("golden_", ConsumeItemTrigger.TriggerInstance.usedItem(GDModItems.GOLDEN_MUSHROOM_RICE.get()))
                .rewards(AdvancementRewards.Builder.experience(400))
                .save(consumer, getNameId("main/avarice"));

        Advancement mightyFriend = getAdvancement(aGoldForAGold, GDModItems.GOLDEN_DOG_FOOD.get(), "give_golden_dog_food", FrameType.TASK, true, false, false)
                .addCriterion("give_golden_dog_food", PlayerInteractTrigger.TriggerInstance.itemUsedOnEntity(ItemPredicate.Builder.item().of(GDModItems.GOLDEN_DOG_FOOD.get()), ContextAwarePredicate.ANY))
                .save(consumer, getNameId("main/give_golden_dog_food"));

        Advancement muchFasterThanSalamander = getAdvancement(mightyFriend, GDModItems.GOLDEN_HORSE_FEED.get(), "give_golden_horse_feed", FrameType.TASK, true, false, false)
                .addCriterion("give_golden_horse_feed", PlayerInteractTrigger.TriggerInstance.itemUsedOnEntity(ItemPredicate.Builder.item().of(GDModItems.GOLDEN_HORSE_FEED.get()), ContextAwarePredicate.ANY))
                .save(consumer, getNameId("main/give_golden_horse_feed"));

        //Midas
        Advancement cursedDebris = getAdvancement(goDelight, GDModItems.ANCIENT_GOLD_DUST.get(), "get_ancient_gold_dust", FrameType.TASK, true, false, false)
                .addCriterion("ancient_gold_dust", InventoryChangeTrigger.TriggerInstance.hasItems(GDModItems.ANCIENT_GOLD_DUST.get()))
                .save(consumer, getNameId("main/get_ancient_gold_dust"));

        Advancement smithsTreasure = getAdvancement(cursedDebris, GDModItems.ANCIENT_GOLD_UPGRADE_SMITHING_TEMPLATE.get(), "get_ancient_gold_upgrade_smithing_template", FrameType.TASK, true, false, false)
                .addCriterion("ancient_gold_upgrade_smithing_template", InventoryChangeTrigger.TriggerInstance.hasItems(GDModItems.ANCIENT_GOLD_UPGRADE_SMITHING_TEMPLATE.get()))
                .save(consumer, getNameId("main/get_ancient_gold_upgrade_smithing_template"));

        Advancement goldMutation = getAdvancement(cursedDebris, GDModItems.MIDAS_POTION.get(), "get_midas_potion", FrameType.TASK, true, false, false)
                .addCriterion("midas_potion", InventoryChangeTrigger.TriggerInstance.hasItems(GDModItems.MIDAS_POTION.get()))
                .save(consumer, getNameId("main/get_midas_potion"));

        Advancement kingsHand = getAdvancement(smithsTreasure, GDModItems.MIDAS_KNIFE.get(), "get_midas_knife", FrameType.CHALLENGE, true, false, false)
                .addCriterion("midas_knife", InventoryChangeTrigger.TriggerInstance.hasItems(GDModItems.MIDAS_KNIFE.get()))
                .rewards(AdvancementRewards.Builder.experience(200))
                .save(consumer, getNameId("main/get_midas_knife"));
    }

    private String getNameId(String id) {
        return GolDelight.MOD_ID + ":" + id;
    }
}
