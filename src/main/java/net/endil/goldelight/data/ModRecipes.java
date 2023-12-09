package net.endil.goldelight.data;

import accieo.midas.hunger.registry.ItemRegistry;
import net.endil.goldelight.GolDelight;
import net.endil.goldelight.client.recipebook.GoldenCookingPotRecipeBookTab;
import net.endil.goldelight.common.registry.GDModBlocks;
import net.endil.goldelight.common.registry.GDModItems;
import net.endil.goldelight.common.registry.GDModRecipeSerializers;
import net.endil.goldelight.common.registry.GDModTags;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.ForgeTags;
import vectorwing.farmersdelight.data.ItemTags;
import vectorwing.farmersdelight.data.builder.CuttingBoardRecipeBuilder;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class ModRecipes extends RecipeProvider implements IConditionBuilder {
    public static final int FAST_COOKING = 200;      // 10 seconds
    public static final int NORMAL_COOKING = 400;    // 20 seconds
    public static final int SLOW_COOKING = 800;      // 40 seconds
    public static final float SMALL_EXP = 0.7F;
    public static final float MEDIUM_EXP = 2.0F;
    public static final float LARGE_EXP = 4.0F;

    public ModRecipes(PackOutput pOutput) {
        super(pOutput);
    }

    protected static void Storage(Consumer<FinishedRecipe> consumer, ItemLike itemIng, ItemLike blockIng) {
        StorageBuilder(consumer, itemIng, blockIng, getSimpleRecipeName(blockIng), null, getSimpleRecipeName(itemIng), null);
    }

    protected static void Compact(Consumer<FinishedRecipe> consumer, ItemLike ingredient, ItemLike result) {
        CompactBuilder(consumer, ingredient, result, getSimpleRecipeName(result), null);
    }

    protected static void TwoByTwo(Consumer<FinishedRecipe> consumer, ItemLike ingredient, ItemLike result) {
        TwoByTwoBuilder(consumer, ingredient, result, getSimpleRecipeName(result), null);
    }

    protected static void Golden(Consumer<FinishedRecipe> consumer, ItemLike result, ItemLike ingredient) {
        GoldenBuilder(result, Ingredient.of(ingredient)).unlockedBy(getHasName(ingredient), has(ingredient)).save(consumer, new ResourceLocation(GolDelight.MOD_ID, getItemName(result) + "_from_nugget"));
    }

    protected static void Enchanted(Consumer<FinishedRecipe> consumer, ItemLike result, ItemLike ingredient) {
        EnchantedGoldenBuilder(result, Ingredient.of(ingredient)).unlockedBy(getHasName(ingredient), has(ingredient)).save(consumer, new ResourceLocation(GolDelight.MOD_ID, getItemName(result)));
    }

    public static void BasicCooking(Consumer<FinishedRecipe> consumer, List<ItemLike> ingredient, ItemLike result) {
        Smelting(consumer, ingredient, result);
        Smoking(consumer, ingredient, result);
        Campfire(consumer, ingredient, result);
    }

    protected static void Smelting(Consumer<FinishedRecipe> consumer, List<ItemLike> ingredient, ItemLike result) {
        SmeltingBuilder(consumer, RecipeSerializer.SMELTING_RECIPE, ingredient, result, 200, null, "_from_smelting");
    }

    protected static void Smoking(Consumer<FinishedRecipe> consumer, List<ItemLike> ingredient, ItemLike result) {
        SmeltingBuilder(consumer, RecipeSerializer.SMOKING_RECIPE, ingredient, result, 100, null, "_from_smoking");
    }

    protected static void Campfire(Consumer<FinishedRecipe> consumer, List<ItemLike> ingredient, ItemLike result) {
        SmeltingBuilder(consumer, RecipeSerializer.CAMPFIRE_COOKING_RECIPE, ingredient, result, 600, null, "_from_campfire_cooking");
    }

    protected static void Ham(Consumer<FinishedRecipe> consumer, List<ItemLike> ingredient, ItemLike result) {
        SmeltingBuilder(consumer, RecipeSerializer.SMOKING_RECIPE, ingredient, result, 200, null, "_from_smoking");
    }

    protected static void SimpleConversion(Consumer<FinishedRecipe> consumer, ItemLike result, ItemLike ingredient) {
        ConversionBuilder(result, Ingredient.of(ingredient), 1).unlockedBy(getHasName(ingredient), has(ingredient)).save(consumer, new ResourceLocation(GolDelight.MOD_ID, getItemName(result)));
    }

    protected static void Conversion(Consumer<FinishedRecipe> consumer, ItemLike result, ItemLike ingredient, int count) {
        ConversionBuilder(result, Ingredient.of(ingredient), count).unlockedBy(getHasName(ingredient), has(ingredient)).save(consumer, new ResourceLocation(GolDelight.MOD_ID, getItemName(result)));
    }

    protected static void CropToSeeds(Consumer<FinishedRecipe> consumer, ItemLike result, ItemLike ingredient) {
        ConversionBuilder(result, Ingredient.of(ingredient), 1).unlockedBy(getHasName(ingredient), has(ingredient)).save(consumer, new ResourceLocation(GolDelight.MOD_ID, getItemName(result) + "_from_" + getItemName(ingredient)));
    }

    protected static void StorageBuilder(Consumer<FinishedRecipe> consumer, ItemLike itemIng, ItemLike blockIng, String block, @Nullable String blockGroup, String item, @Nullable String itemGroup) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, itemIng, 9).requires(blockIng).group(itemGroup).unlockedBy(getHasName(blockIng), has(blockIng))
                .save(consumer, new ResourceLocation(GolDelight.MOD_ID, item) + "_from_" + block);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, blockIng).define('#', itemIng).pattern("###").pattern("###").pattern("###").group(blockGroup)
                .unlockedBy(getHasName(itemIng), has(itemIng)).save(consumer, new ResourceLocation(GolDelight.MOD_ID, block));
    }

    protected static void CompactBuilder(Consumer<FinishedRecipe> consumer, ItemLike ingredient, ItemLike result, String block, @Nullable String blockGroup) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, result).define('#', ingredient).pattern("###").pattern("###").pattern("###").group(blockGroup)
                .unlockedBy(getHasName(ingredient), has(ingredient)).save(consumer, new ResourceLocation(GolDelight.MOD_ID, block));
    }

    protected static void TwoByTwoBuilder(Consumer<FinishedRecipe> consumer, ItemLike ingredient, ItemLike result, String block, @Nullable String blockGroup) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, result).define('#', ingredient).pattern("##").pattern("##").group(blockGroup)
                .unlockedBy(getHasName(ingredient), has(ingredient)).save(consumer, new ResourceLocation(GolDelight.MOD_ID, block));
    }

    protected static RecipeBuilder GoldenBuilder(ItemLike result, Ingredient ingredient) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, result).define('#', ingredient).define('G', Ingredient.of(Items.GOLD_NUGGET))
                .pattern("GGG").pattern("G#G").pattern("GGG");
    }

    protected static RecipeBuilder EnchantedGoldenBuilder(ItemLike result, Ingredient ingredient) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, result).define('#', ingredient).define('G', Ingredient.of(Items.GOLD_BLOCK))
                .pattern("GGG").pattern("G#G").pattern("GGG");
    }

    protected static void SmeltingBuilder(Consumer<FinishedRecipe> consumer, RecipeSerializer<? extends AbstractCookingRecipe> serializer, List<ItemLike> ingredient, ItemLike result, int time, String group, String recipe) {
        for (ItemLike ing : ingredient) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(ing), RecipeCategory.FOOD, result, 0.35f, time, serializer)
                    .group(group).unlockedBy(getHasName(ing), has(ing))
                    .save(consumer, new ResourceLocation(GolDelight.MOD_ID, getItemName(result)) + recipe);
        }
    }

    protected static RecipeBuilder ConversionBuilder(ItemLike result, Ingredient ingredient, int count) {
        return ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, result, count).requires(ingredient);
    }

    protected static void stairs(Consumer<FinishedRecipe> consumer, ItemLike stairs, ItemLike ingredient) {
        stairBuilder(stairs, Ingredient.of(ingredient)).unlockedBy(getHasName(ingredient), has(ingredient)).save(consumer, new ResourceLocation(GolDelight.MOD_ID, getItemName(stairs)));
    }

    protected static void woodenFence(Consumer<FinishedRecipe> consumer, ItemLike fence, ItemLike ingredient) {
        fenceBuilder(fence, Ingredient.of(ingredient)).unlockedBy(getHasName(ingredient), has(ingredient)).save(consumer, new ResourceLocation(GolDelight.MOD_ID, getItemName(fence)));
    }

    protected static void fence(Consumer<FinishedRecipe> consumer, ItemLike fence, ItemLike ingredient) {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, fence, 6)
                .define('W', ingredient).pattern("WWW").pattern("WWW")
                .unlockedBy(getHasName(ingredient), has(ingredient)).save(consumer, new ResourceLocation(GolDelight.MOD_ID, getItemName(fence)));
    }

    protected static void fenceGate(Consumer<FinishedRecipe> consumer, ItemLike gate, ItemLike ingredient) {
        fenceGateBuilder(gate, Ingredient.of(ingredient)).unlockedBy(getHasName(ingredient), has(ingredient)).save(consumer, new ResourceLocation(GolDelight.MOD_ID, getItemName(gate)));
    }

    protected static void door(Consumer<FinishedRecipe> consumer, ItemLike door, ItemLike ingredient) {
        doorBuilder(door, Ingredient.of(ingredient)).unlockedBy(getHasName(ingredient), has(ingredient)).save(consumer, new ResourceLocation(GolDelight.MOD_ID, getItemName(door)));
    }

    protected static void trapdoor(Consumer<FinishedRecipe> consumer, ItemLike trap, ItemLike ingredient) {
        trapdoorBuilder(trap, Ingredient.of(ingredient)).unlockedBy(getHasName(ingredient), has(ingredient)).save(consumer, new ResourceLocation(GolDelight.MOD_ID, getItemName(trap)));
    }

    protected static void button(Consumer<FinishedRecipe> consumer, ItemLike button, ItemLike ingredient) {
        buttonBuilder(button, Ingredient.of(ingredient)).unlockedBy(getHasName(ingredient), has(ingredient)).save(consumer, new ResourceLocation(GolDelight.MOD_ID, getItemName(button)));
    }

    protected static void sign(Consumer<FinishedRecipe> consumer, ItemLike sign, ItemLike ingredient) {
        signBuilder(sign, Ingredient.of(ingredient)).unlockedBy(getHasName(ingredient), has(ingredient)).save(consumer, new ResourceLocation(GolDelight.MOD_ID, getItemName(sign)));
    }

    protected static void stoneCutting(Consumer<FinishedRecipe> consumer, ItemLike result, ItemLike ingredient, int count) {
        StoneCuttingBuilder(Ingredient.of(ingredient), result, count).unlockedBy(getHasName(ingredient), has(ingredient)).save(consumer, new ResourceLocation(GolDelight.MOD_ID, getItemName(result) + "_from_" + getItemName(ingredient) + "_stonecutting"));
    }

    public static SingleItemRecipeBuilder StoneCuttingBuilder(Ingredient ingredient, ItemLike result, int count) {
        return new SingleItemRecipeBuilder(RecipeCategory.BUILDING_BLOCKS, RecipeSerializer.STONECUTTER, ingredient, result, count);
    }

    protected static void ancientGoldSmithing(Consumer<FinishedRecipe> consumer, Item netherite, RecipeCategory category, Item ancientGold) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(GDModItems.ANCIENT_GOLD_UPGRADE_SMITHING_TEMPLATE.get()),
                        Ingredient.of(netherite), Ingredient.of(GDModItems.ANCIENT_GOLD_INGOT.get()), category, ancientGold).unlocks("has_ancient_gold_ingot", has(GDModItems.ANCIENT_GOLD_INGOT.get()))
                .save(consumer, new ResourceLocation(GolDelight.MOD_ID, getItemName(ancientGold) + "_smithing"));
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        this.registerSimpleCrafting(consumer);
        this.registerSmelting(consumer);
        this.registerCutting(consumer);
        this.registerFoodCrafting(consumer);
        this.registerCooking(consumer);
        this.registerBuilding(consumer);
        SpecialRecipeBuilder.special(GDModRecipeSerializers.GOLDEN_FOOD_SERVING.get()).save(consumer, "golden_food_serving");
    }

    private void registerSimpleCrafting(Consumer<FinishedRecipe> consumer) {
        Golden(consumer, GDModItems.GOLDEN_BEEF.get(), Items.BEEF);
        Golden(consumer, GDModItems.GOLDEN_BONE.get(), Items.BONE);
        Golden(consumer, GDModItems.GOLDEN_CHICKEN.get(), Items.CHICKEN);
        Golden(consumer, GDModItems.GOLDEN_COCOA_BEANS.get(), Items.COCOA_BEANS);
        Golden(consumer, GDModItems.GOLDEN_COD.get(), Items.COD);
        Golden(consumer, GDModItems.GOLDEN_GLOW_BERRIES.get(), Items.GLOW_BERRIES);
        Golden(consumer, GDModItems.GOLDEN_INK_SAC.get(), Items.INK_SAC);
        Golden(consumer, GDModItems.GOLDEN_MELON_SEEDS.get(), Items.MELON_SEEDS);
        Golden(consumer, GDModItems.GOLDEN_MUTTON.get(), Items.MUTTON);
        Golden(consumer, GDModItems.GOLDEN_PORKCHOP.get(), Items.PORKCHOP);
        Golden(consumer, GDModItems.GOLDEN_POTATO.get(), Items.POTATO);
        Golden(consumer, GDModItems.GOLDEN_PUFFERFISH.get(), Items.PUFFERFISH);
        Golden(consumer, GDModItems.GOLDEN_PUMPKIN_SEEDS.get(), Items.PUMPKIN_SEEDS);
        Golden(consumer, GDModItems.GOLDEN_RABBIT.get(), Items.RABBIT);
        Golden(consumer, GDModItems.ROTTEN_GOLDEN_FLESH.get(), Items.ROTTEN_FLESH);
        Golden(consumer, GDModItems.GOLDEN_SALMON.get(), Items.SALMON);
        Golden(consumer, GDModItems.GOLDEN_SUGAR_CANE.get(), Items.SUGAR_CANE);
        Golden(consumer, GDModItems.GOLDEN_TROPICAL_FISH.get(), Items.TROPICAL_FISH);
        Golden(consumer, GDModItems.GOLDEN_WART.get(), Items.NETHER_WART);
        Golden(consumer, GDModItems.GOLDEN_WHEAT_SEEDS.get(), Items.WHEAT_SEEDS);

        Golden(consumer, GDModBlocks.GOLDEN_CACTUS.get(), Items.CACTUS);
        Golden(consumer, GDModBlocks.GOLDEN_CHORUS_FLOWER.get(), Items.CHORUS_FLOWER);

        Golden(consumer, GDModItems.GOLDEN_ONION.get(), ModItems.ONION.get());
        Golden(consumer, GDModItems.GOLDEN_RICE.get(), ModItems.RICE.get());
        Golden(consumer, GDModItems.GOLDEN_CABBAGE_SEEDS.get(), ModItems.CABBAGE_SEEDS.get());
        Golden(consumer, GDModItems.GOLDEN_TOMATO_SEEDS.get(), ModItems.TOMATO_SEEDS.get());
        Golden(consumer, GDModItems.GOLDEN_HAM.get(), ModItems.HAM.get());

        Storage(consumer, GDModItems.GOLDEN_WHEAT.get(), GDModBlocks.GOLDEN_HAY_BLOCK.get());
        Compact(consumer, GDModItems.GOLDEN_MELON_SLICE.get(), GDModBlocks.GOLDEN_MELON.get());
        TwoByTwo(consumer, GDModItems.GOLDEN_PUMPKIN_SLICE.get(), GDModBlocks.GOLDEN_PUMPKIN.get());
        Storage(consumer, Items.GOLDEN_CARROT, GDModBlocks.GOLDEN_CARROT_CRATE.get());
        Storage(consumer, GDModItems.GOLDEN_POTATO.get(), GDModBlocks.GOLDEN_POTATO_CRATE.get());
        Storage(consumer, ItemRegistry.GOLDEN_BEETROOT.get(), GDModBlocks.GOLDEN_BEETROOT_CRATE.get());
        Storage(consumer, GDModItems.GOLDEN_CABBAGE.get(), GDModBlocks.GOLDEN_CABBAGE_CRATE.get());
        Storage(consumer, GDModItems.GOLDEN_TOMATO.get(), GDModBlocks.GOLDEN_TOMATO_CRATE.get());
        Storage(consumer, GDModItems.GOLDEN_ONION.get(), GDModBlocks.GOLDEN_ONION_CRATE.get());
        Storage(consumer, GDModItems.GOLDEN_RICE_PANICLE.get(), GDModBlocks.GOLDEN_RICE_BALE.get());
        Storage(consumer, GDModItems.GOLDEN_RICE.get(), GDModBlocks.GOLDEN_RICE_BAG.get());
        Compact(consumer, GDModItems.GOLDEN_WART.get(), GDModBlocks.GOLDEN_WART_BLOCK.get());
        Storage(consumer, GDModItems.GOLDEN_MEAL.get(), GDModBlocks.GOLDEN_BONE_BLOCK.get());

        Conversion(consumer, GDModItems.GOLDEN_MEAL.get(), GDModItems.GOLDEN_BONE.get(), 3);
        CropToSeeds(consumer, GDModItems.GOLDEN_MELON_SEEDS.get(), GDModItems.GOLDEN_MELON_SLICE.get());
        Conversion(consumer, GDModItems.GOLDEN_PUMPKIN_SEEDS.get(), GDModBlocks.GOLDEN_PUMPKIN.get(), 4);
        CropToSeeds(consumer, GDModItems.GOLDEN_PUMPKIN_SEEDS.get(), GDModItems.GOLDEN_PUMPKIN_SLICE.get());
        SimpleConversion(consumer, GDModItems.GOLDEN_SUGAR.get(), GDModItems.GOLDEN_SUGAR_CANE.get());
        SimpleConversion(consumer, GDModItems.GOLDEN_RICE.get(), GDModItems.GOLDEN_RICE_PANICLE.get());
        CropToSeeds(consumer, GDModItems.GOLDEN_TOMATO_SEEDS.get(), GDModItems.GOLDEN_TOMATO.get());
        CropToSeeds(consumer, GDModItems.GOLDEN_TOMATO_SEEDS.get(), GDModItems.ROTTEN_GOLDEN_TOMATO.get());
        Conversion(consumer, GDModItems.GOLDEN_HONEY_BOTTLE.get(), GDModItems.GOLDEN_SUGAR.get(), 3);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, GDModBlocks.GOLDEN_MUSHROOM.get())
                .pattern("ggg").pattern("gmg").pattern("ggg")
                .define('g', Items.GOLD_NUGGET).define('m', Tags.Items.MUSHROOMS)
                .unlockedBy("has_mushrooms", InventoryChangeTrigger.TriggerInstance.hasItems(Items.BROWN_MUSHROOM, Items.RED_MUSHROOM))
                .save(consumer, new ResourceLocation(GolDelight.MOD_ID, "golden_mushroom_from_nugget"));
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, GDModBlocks.GOLDEN_FUNGUS.get())
                .pattern("ggg").pattern("gfg").pattern("ggg")
                .define('g', Items.GOLD_NUGGET).define('f', Items.CRIMSON_FUNGUS)
                .unlockedBy("has_mushrooms", InventoryChangeTrigger.TriggerInstance.hasItems(Items.CRIMSON_FUNGUS, Items.WARPED_FUNGUS))
                .save(consumer, new ResourceLocation(GolDelight.MOD_ID, "golden_fungus_from_crimson"));
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, GDModBlocks.GOLDEN_FUNGUS.get())
                .pattern("ggg").pattern("gfg").pattern("ggg")
                .define('g', Items.GOLD_NUGGET).define('f', Items.WARPED_FUNGUS)
                .unlockedBy("has_mushrooms", InventoryChangeTrigger.TriggerInstance.hasItems(Items.CRIMSON_FUNGUS, Items.WARPED_FUNGUS))
                .save(consumer, new ResourceLocation(GolDelight.MOD_ID, "golden_fungus_from_warped"));
        TwoByTwo(consumer, GDModItems.GOLDEN_HONEY_BOTTLE.get(), GDModBlocks.GOLDEN_HONEY_BLOCK.get());
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GDModItems.GOLDEN_HONEY_BOTTLE.get(), 4)
                .requires(Items.GLASS_BOTTLE)
                .requires(Items.GLASS_BOTTLE)
                .requires(Items.GLASS_BOTTLE)
                .requires(Items.GLASS_BOTTLE)
                .requires(GDModBlocks.GOLDEN_HONEY_BLOCK.get())
                .unlockedBy("has_golden_honey_block", InventoryChangeTrigger.TriggerInstance.hasItems(GDModBlocks.GOLDEN_HONEY_BLOCK.get()))
                .save(consumer, new ResourceLocation(GolDelight.MOD_ID, "golden_honey_bottle_from_block"));
        Storage(consumer, GDModItems.ANCIENT_GOLD_NUGGET.get(), GDModItems.ANCIENT_GOLD_INGOT.get());
        Storage(consumer, GDModItems.ANCIENT_GOLD_INGOT.get(), GDModBlocks.ANCIENT_GOLD_BLOCK.get());
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, GDModItems.ANCIENT_GOLD_INGOT.get())
                .requires(GDModItems.ANCIENT_GOLD_DUST.get())
                .requires(GDModItems.ANCIENT_GOLD_DUST.get())
                .requires(GDModItems.ANCIENT_GOLD_DUST.get())
                .requires(GDModItems.ANCIENT_GOLD_DUST.get())
                .requires(Items.NETHERITE_SCRAP)
                .requires(Items.NETHERITE_SCRAP)
                .requires(Items.GOLD_INGOT)
                .requires(Items.GOLD_INGOT)
                .unlockedBy("has_ancient_gold_dust", InventoryChangeTrigger.TriggerInstance.hasItems(GDModItems.ANCIENT_GOLD_DUST.get()))
                .save(consumer, new ResourceLocation(GolDelight.MOD_ID, "ancient_golden_ingot_from_dust"));
        ancientGoldSmithing(consumer, ModItems.NETHERITE_KNIFE.get(), RecipeCategory.TOOLS, GDModItems.MIDAS_KNIFE.get());
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, GDModItems.ANCIENT_GOLD_UPGRADE_SMITHING_TEMPLATE.get(), 2)
                .pattern("GTG")
                .pattern("GDG")
                .pattern("GGG")
                .define('G', Items.GOLD_INGOT)
                .define('T', GDModItems.ANCIENT_GOLD_UPGRADE_SMITHING_TEMPLATE.get())
                .define('D', GDModItems.ANCIENT_GOLD_DUST.get())
                .unlockedBy("has_ancient_gold_upgrade_smithing_template", InventoryChangeTrigger.TriggerInstance.hasItems(GDModItems.ANCIENT_GOLD_UPGRADE_SMITHING_TEMPLATE.get()))
                .save(consumer);
    }

    private void registerSmelting(Consumer<FinishedRecipe> consumer) {
        BasicCooking(consumer, List.of(GDModItems.GOLDEN_BEEF.get()), ItemRegistry.COOKED_GOLDEN_BEEF.get());
        BasicCooking(consumer, List.of(GDModItems.GOLDEN_CHICKEN.get()), ItemRegistry.COOKED_GOLDEN_CHICKEN.get());
        BasicCooking(consumer, List.of(GDModItems.GOLDEN_COD.get()), ItemRegistry.COOKED_GOLDEN_COD.get());
        BasicCooking(consumer, List.of(GDModItems.GOLDEN_EGG.get()), GDModItems.FRIED_GOLDEN_EGG.get());
        BasicCooking(consumer, List.of(GDModItems.GOLDEN_MUTTON.get()), ItemRegistry.COOKED_GOLDEN_MUTTON.get());
        BasicCooking(consumer, List.of(GDModItems.GOLDEN_PORKCHOP.get()), ItemRegistry.COOKED_GOLDEN_PORKCHOP.get());
        BasicCooking(consumer, List.of(GDModItems.GOLDEN_RABBIT.get()), ItemRegistry.COOKED_GOLDEN_RABBIT.get());
        BasicCooking(consumer, List.of(GDModItems.GOLDEN_SALMON.get()), ItemRegistry.COOKED_GOLDEN_SALMON.get());
        BasicCooking(consumer, List.of(GDModItems.MINCED_GOLDEN_BEEF.get()), GDModItems.GOLDEN_BEEF_PATTY.get());
        BasicCooking(consumer, List.of(GDModItems.GOLDEN_CHICKEN_CUTS.get()), GDModItems.COOKED_GOLDEN_CHICKEN_CUTS.get());
        BasicCooking(consumer, List.of(GDModItems.GOLDEN_BACON.get()), GDModItems.COOKED_GOLDEN_BACON.get());
        BasicCooking(consumer, List.of(GDModItems.GOLDEN_COD_SLICE.get()), GDModItems.COOKED_GOLDEN_COD_SLICE.get());
        BasicCooking(consumer, List.of(GDModItems.GOLDEN_SALMON_SLICE.get()), GDModItems.COOKED_GOLDEN_SALMON_SLICE.get());
        BasicCooking(consumer, List.of(GDModItems.GOLDEN_MUTTON_CHOPS.get()), GDModItems.COOKED_GOLDEN_MUTTON_CHOPS.get());
        BasicCooking(consumer, List.of(GDModItems.GOLDEN_WHEAT_DOUGH.get()), GDModItems.GOLDEN_BREAD.get());
        BasicCooking(consumer, List.of(GDModItems.GOLDEN_POTATO.get()), ItemRegistry.BAKED_GOLDEN_POTATO.get());
        Ham(consumer, List.of(GDModItems.GOLDEN_HAM.get()), GDModItems.SMOKED_GOLDEN_HAM.get());
    }

    private void registerCutting(Consumer<FinishedRecipe> consumer) {
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(GDModItems.GOLDEN_BEEF.get()), Ingredient.of(ForgeTags.TOOLS_KNIVES), GDModItems.MINCED_GOLDEN_BEEF.get(), 2)
                .build(consumer);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(GDModItems.GOLDEN_PORKCHOP.get()), Ingredient.of(ForgeTags.TOOLS_KNIVES), GDModItems.GOLDEN_BACON.get(), 2)
                .build(consumer);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(GDModItems.GOLDEN_CHICKEN.get()), Ingredient.of(ForgeTags.TOOLS_KNIVES), GDModItems.GOLDEN_CHICKEN_CUTS.get(), 2)
                .addResult(GDModItems.GOLDEN_MEAL.get())
                .build(consumer);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(ItemRegistry.COOKED_GOLDEN_CHICKEN.get()), Ingredient.of(ForgeTags.TOOLS_KNIVES), GDModItems.COOKED_GOLDEN_CHICKEN_CUTS.get(), 2)
                .addResult(GDModItems.GOLDEN_MEAL.get())
                .build(consumer);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(GDModItems.GOLDEN_COD.get()), Ingredient.of(ForgeTags.TOOLS_KNIVES), GDModItems.GOLDEN_COD_SLICE.get(), 2)
                .addResult(GDModItems.GOLDEN_MEAL.get())
                .build(consumer);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(ItemRegistry.COOKED_GOLDEN_COD.get()), Ingredient.of(ForgeTags.TOOLS_KNIVES), GDModItems.COOKED_GOLDEN_COD_SLICE.get(), 2)
                .addResult(GDModItems.GOLDEN_MEAL.get())
                .build(consumer);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(GDModItems.GOLDEN_SALMON.get()), Ingredient.of(ForgeTags.TOOLS_KNIVES), GDModItems.GOLDEN_SALMON_SLICE.get(), 2)
                .addResult(GDModItems.GOLDEN_MEAL.get())
                .build(consumer);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(ItemRegistry.COOKED_GOLDEN_SALMON.get()), Ingredient.of(ForgeTags.TOOLS_KNIVES), GDModItems.COOKED_GOLDEN_SALMON_SLICE.get(), 2)
                .addResult(GDModItems.GOLDEN_MEAL.get())
                .build(consumer);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(GDModItems.GOLDEN_HAM.get()), Ingredient.of(ForgeTags.TOOLS_KNIVES), GDModItems.GOLDEN_PORKCHOP.get(), 2)
                .addResult(GDModItems.GOLDEN_BONE.get())
                .build(consumer);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(GDModItems.SMOKED_GOLDEN_HAM.get()), Ingredient.of(ForgeTags.TOOLS_KNIVES), ItemRegistry.COOKED_GOLDEN_PORKCHOP.get(), 2)
                .addResult(GDModItems.GOLDEN_MEAL.get())
                .build(consumer);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(GDModItems.GOLDEN_MUTTON.get()), Ingredient.of(ForgeTags.TOOLS_KNIVES), GDModItems.GOLDEN_MUTTON_CHOPS.get(), 2)
                .build(consumer);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(ItemRegistry.COOKED_GOLDEN_MUTTON.get()), Ingredient.of(ForgeTags.TOOLS_KNIVES), GDModItems.COOKED_GOLDEN_MUTTON_CHOPS.get(), 2)
                .build(consumer);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(GDModItems.GOLDEN_CAKE.get()), Ingredient.of(ForgeTags.TOOLS_KNIVES), GDModItems.GOLDEN_CAKE_SLICE.get(), 7)
                .build(consumer);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(GDModItems.GOLDEN_APPLE_PIE.get()), Ingredient.of(ForgeTags.TOOLS_KNIVES), GDModItems.GOLDEN_APPLE_PIE_SLICE.get(), 4)
                .build(consumer);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(GDModItems.SWEET_GOLDEN_BERRY_CHEESECAKE.get()), Ingredient.of(ForgeTags.TOOLS_KNIVES), GDModItems.SWEET_GOLDEN_BERRY_CHEESECAKE_SLICE.get(), 4)
                .build(consumer);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(GDModItems.GOLDEN_CHOCOLATE_PIE.get()), Ingredient.of(ForgeTags.TOOLS_KNIVES), GDModItems.GOLDEN_CHOCOLATE_PIE_SLICE.get(), 4)
                .build(consumer);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(GDModBlocks.GOLDEN_MELON.get()), Ingredient.of(ForgeTags.TOOLS_KNIVES), GDModItems.GOLDEN_MELON_SLICE.get(), 9)
                .build(consumer);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(GDModBlocks.GOLDEN_PUMPKIN.get()), Ingredient.of(ForgeTags.TOOLS_KNIVES), GDModItems.GOLDEN_PUMPKIN_SLICE.get(), 4)
                .build(consumer);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(GDModItems.GOLDEN_WHEAT_DOUGH.get()), Ingredient.of(ForgeTags.TOOLS_KNIVES), GDModItems.RAW_GOLDEN_PASTA.get(), 1)
                .build(consumer);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(GDModItems.GOLDEN_KELP_ROLL.get()), Ingredient.of(ForgeTags.TOOLS_KNIVES), GDModItems.GOLDEN_KELP_ROLL_SLICE.get(), 3)
                .build(consumer);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(GDModBlocks.GOLDEN_MUSHROOM_COLONY.get()), Ingredient.of(ForgeTags.TOOLS_KNIVES), GDModBlocks.GOLDEN_MUSHROOM.get(), 5)
                .build(consumer);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(GDModBlocks.GOLDEN_FUNGUS_COLONY.get()), Ingredient.of(ForgeTags.TOOLS_KNIVES), GDModBlocks.GOLDEN_FUNGUS.get(), 5)
                .build(consumer);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(GDModBlocks.GOLDEN_STEM.get()), Ingredient.of(ForgeTags.TOOLS_AXES), GDModBlocks.STRIPPED_GOLDEN_STEM.get(), 1).addResult(ModItems.TREE_BARK.get())
                .build(consumer);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(GDModBlocks.GOLDEN_HYPHAE.get()), Ingredient.of(ForgeTags.TOOLS_AXES), GDModBlocks.STRIPPED_GOLDEN_HYPHAE.get(), 1).addResult(ModItems.TREE_BARK.get())
                .build(consumer);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(GDModItems.GOLDEN_RICE_PANICLE.get()), Ingredient.of(ForgeTags.TOOLS_KNIVES), GDModItems.GOLDEN_RICE.get(), 1).addResult(ModItems.STRAW.get())
                .build(consumer);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(GDModItems.GOLDEN_CABBAGE.get()), Ingredient.of(ForgeTags.TOOLS_KNIVES), GDModItems.GOLDEN_CABBAGE_LEAF.get(), 2)
                .build(consumer);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(GDModBlocks.GOLDEN_HANGING_SIGN.get()), Ingredient.of(ForgeTags.TOOLS_AXES), GDModBlocks.GOLDEN_PLANKS.get()).build(consumer);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(GDModBlocks.GOLDEN_TRAPDOOR.get()), Ingredient.of(ForgeTags.TOOLS_AXES), GDModBlocks.GOLDEN_PLANKS.get()).build(consumer);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(GDModBlocks.GOLDEN_SIGN.get()), Ingredient.of(ForgeTags.TOOLS_AXES), GDModBlocks.GOLDEN_PLANKS.get()).build(consumer);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(GDModBlocks.GOLDEN_DOOR.get()), Ingredient.of(ForgeTags.TOOLS_AXES), GDModBlocks.GOLDEN_PLANKS.get()).build(consumer);
    }

    private void registerFoodCrafting(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, GDModItems.GOLDEN_BREAD.get())
                .pattern("www").define('w', GDModItems.GOLDEN_WHEAT.get())
                .unlockedBy("has_golden_wheat", InventoryChangeTrigger.TriggerInstance.hasItems(GDModItems.GOLDEN_WHEAT.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GDModItems.GOLDEN_MILK_BUCKET.get())
                .requires(Items.BUCKET)
                .requires(GDModItems.GOLDEN_MILK_BOTTLE.get())
                .requires(GDModItems.GOLDEN_MILK_BOTTLE.get())
                .requires(GDModItems.GOLDEN_MILK_BOTTLE.get())
                .requires(GDModItems.GOLDEN_MILK_BOTTLE.get())
                .unlockedBy("has_golden_milk_bottle", InventoryChangeTrigger.TriggerInstance.hasItems(GDModItems.GOLDEN_MILK_BOTTLE.get()))
                .save(consumer, new ResourceLocation(GolDelight.MOD_ID, "golden_milk_from_bottles"));
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, GDModItems.GOLDEN_CAKE.get())
                .pattern("mmm")
                .pattern("ses")
                .pattern("www")
                .define('m', GDModTags.Items.GOLDEN_MILK)
                .define('s', GDModItems.GOLDEN_SUGAR.get())
                .define('e', GDModTags.Items.GOLDEN_EGGS)
                .define('w', GDModItems.GOLDEN_WHEAT.get())
                .unlockedBy("has_golden_egg", InventoryChangeTrigger.TriggerInstance.hasItems(GDModItems.GOLDEN_EGG.get()))
                .save(consumer, new ResourceLocation(GolDelight.MOD_ID, "golden_cake_from_milk"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GDModItems.GOLDEN_CAKE.get())
                .requires(GDModItems.GOLDEN_CAKE_SLICE.get())
                .requires(GDModItems.GOLDEN_CAKE_SLICE.get())
                .requires(GDModItems.GOLDEN_CAKE_SLICE.get())
                .requires(GDModItems.GOLDEN_CAKE_SLICE.get())
                .requires(GDModItems.GOLDEN_CAKE_SLICE.get())
                .requires(GDModItems.GOLDEN_CAKE_SLICE.get())
                .requires(GDModItems.GOLDEN_CAKE_SLICE.get())
                .unlockedBy("has_golden_cake_slice", InventoryChangeTrigger.TriggerInstance.hasItems(GDModItems.GOLDEN_CAKE_SLICE.get()))
                .save(consumer, new ResourceLocation(GolDelight.MOD_ID, "golden_cake_from_slices"));
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, GDModItems.GOLDEN_COOKIE.get(), 8)
                .pattern("wcw").define('w', GDModItems.GOLDEN_WHEAT.get()).define('c', GDModItems.GOLDEN_COCOA_BEANS.get())
                .unlockedBy("has_golden_cocoa", InventoryChangeTrigger.TriggerInstance.hasItems(GDModItems.GOLDEN_COCOA_BEANS.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GDModItems.GOLDEN_MUSHROOM_STEW.get())
                .requires(GDModBlocks.GOLDEN_MUSHROOM.get().asItem())
                .requires(GDModBlocks.GOLDEN_MUSHROOM.get().asItem())
                .requires(Items.BOWL)
                .unlockedBy("has_golden_mushroom", InventoryChangeTrigger.TriggerInstance.hasItems(GDModBlocks.GOLDEN_MUSHROOM.get().asItem()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GDModItems.GOLDEN_RABBIT_STEW.get())
                .requires(ItemRegistry.BAKED_GOLDEN_POTATO.get())
                .requires(ItemRegistry.COOKED_GOLDEN_RABBIT.get())
                .requires(Items.BOWL)
                .requires(Items.GOLDEN_CARROT)
                .requires(GDModBlocks.GOLDEN_MUSHROOM.get().asItem())
                .unlockedBy("has_cooked_golden_rabbit", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.COOKED_GOLDEN_RABBIT.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, GDModBlocks.GOL_D_LANTERN.get())
                .pattern("p").pattern("t").define('p', GDModBlocks.GOLDEN_CARVED_PUMPKIN.get()).define('t', Items.TORCH)
                .unlockedBy("has_golden_carved_pumpkin", InventoryChangeTrigger.TriggerInstance.hasItems(GDModBlocks.GOLDEN_CARVED_PUMPKIN.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GDModItems.GOLDEN_MILK_BOTTLE.get(), 4)
                .requires(GDModItems.GOLDEN_MILK_BUCKET.get())
                .requires(Items.GLASS_BOTTLE)
                .requires(Items.GLASS_BOTTLE)
                .requires(Items.GLASS_BOTTLE)
                .requires(Items.GLASS_BOTTLE)
                .unlockedBy("has_golden_milk_bucket", InventoryChangeTrigger.TriggerInstance.hasItems(GDModItems.GOLDEN_MILK_BUCKET.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GDModItems.GOLDEN_MELON_JUICE.get(), 1)
                .requires(GDModItems.GOLDEN_MELON_SLICE.get())
                .requires(GDModItems.GOLDEN_MELON_SLICE.get())
                .requires(GDModItems.GOLDEN_SUGAR.get())
                .requires(GDModItems.GOLDEN_MELON_SLICE.get())
                .requires(GDModItems.GOLDEN_MELON_SLICE.get())
                .requires(Items.GLASS_BOTTLE)
                .unlockedBy("has_golden_melon_slice", InventoryChangeTrigger.TriggerInstance.hasItems(GDModItems.GOLDEN_MELON_SLICE.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GDModItems.GOLDEN_WHEAT_DOUGH.get(), 3)
                .requires(Items.WATER_BUCKET)
                .requires(GDModItems.GOLDEN_WHEAT.get())
                .requires(GDModItems.GOLDEN_WHEAT.get())
                .requires(GDModItems.GOLDEN_WHEAT.get())
                .unlockedBy("has_golden_wheat", InventoryChangeTrigger.TriggerInstance.hasItems(GDModItems.GOLDEN_WHEAT.get()))
                .save(consumer, new ResourceLocation(GolDelight.MOD_ID, "golden_wheat_dough_from_water"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GDModItems.GOLDEN_WHEAT_DOUGH.get(), 3)
                .requires(GDModTags.Items.GOLDEN_EGGS)
                .requires(GDModItems.GOLDEN_WHEAT.get())
                .requires(GDModItems.GOLDEN_WHEAT.get())
                .requires(GDModItems.GOLDEN_WHEAT.get())
                .unlockedBy("has_golden_wheat", InventoryChangeTrigger.TriggerInstance.hasItems(GDModItems.GOLDEN_WHEAT.get()))
                .save(consumer, new ResourceLocation(GolDelight.MOD_ID, "wheat_dough_from_eggs"));
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, GDModItems.GOLDEN_PIE_CRUST.get(), 1)
                .pattern("wMw")
                .pattern(" w ")
                .define('w', GDModItems.GOLDEN_WHEAT.get())
                .define('M', GDModTags.Items.GOLDEN_MILK)
                .unlockedBy("has_golden_wheat", InventoryChangeTrigger.TriggerInstance.hasItems(GDModItems.GOLDEN_WHEAT.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GDModItems.SWEET_GOLDEN_BERRY_COOKIE.get(), 8)
                .requires(ItemRegistry.SWEET_GOLDEN_BERRIES.get())
                .requires(GDModItems.GOLDEN_WHEAT.get())
                .requires(GDModItems.GOLDEN_WHEAT.get())
                .unlockedBy("has_sweet_golden_berries", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.SWEET_GOLDEN_BERRIES.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GDModItems.GOLDEN_HONEY_COOKIE.get(), 8)
                .requires(GDModItems.GOLDEN_HONEY_BOTTLE.get())
                .requires(GDModItems.GOLDEN_WHEAT.get())
                .requires(GDModItems.GOLDEN_WHEAT.get())
                .unlockedBy("has_golden_honey_bottle", InventoryChangeTrigger.TriggerInstance.hasItems(GDModItems.GOLDEN_HONEY_BOTTLE.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GDModItems.GOLDEN_CABBAGE.get())
                .requires(GDModItems.GOLDEN_CABBAGE_LEAF.get())
                .requires(GDModItems.GOLDEN_CABBAGE_LEAF.get())
                .unlockedBy("has_golden_cabbage_leaf", InventoryChangeTrigger.TriggerInstance.hasItems(GDModItems.GOLDEN_CABBAGE_LEAF.get()))
                .save(consumer, new ResourceLocation(GolDelight.MOD_ID, "golden_cabbage_from_leaves"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GDModItems.GOLDEN_HORSE_FEED.get(), 1)
                .requires(Ingredient.of(GDModBlocks.GOLDEN_HAY_BLOCK.get().asItem(), GDModBlocks.GOLDEN_RICE_BALE.get().asItem()))
                .requires(Items.GOLDEN_APPLE)
                .requires(Items.GOLDEN_APPLE)
                .requires(Items.GOLDEN_CARROT)
                .unlockedBy("has_golden_carrot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GOLDEN_CARROT))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, GDModItems.GOLDEN_POPSICLE.get(), 1)
                .pattern(" mm")
                .pattern("imm")
                .pattern("-i ")
                .define('m', GDModItems.GOLDEN_MELON_SLICE.get())
                .define('i', Items.ICE)
                .define('-', Items.STICK)
                .unlockedBy("has_golden_melon", InventoryChangeTrigger.TriggerInstance.hasItems(GDModItems.GOLDEN_MELON_SLICE.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GDModItems.GOLDEN_FRUIT_SALAD.get(), 1)
                .requires(Items.GOLDEN_APPLE)
                .requires(GDModItems.GOLDEN_MELON_SLICE.get())
                .requires(GDModItems.GOLDEN_MELON_SLICE.get())
                .requires(GDModTags.Items.GOLDEN_BERRIES)
                .requires(GDModTags.Items.GOLDEN_BERRIES)
                .requires(GDModItems.GOLDEN_PUMPKIN_SLICE.get())
                .requires(Items.BOWL)
                .unlockedBy("has_golden_fruits", InventoryChangeTrigger.TriggerInstance.hasItems(GDModItems.GOLDEN_MELON_SLICE.get(), ItemRegistry.SWEET_GOLDEN_BERRIES.get(), Items.GOLDEN_APPLE, GDModItems.GOLDEN_PUMPKIN_SLICE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, GDModItems.GOLDEN_APPLE_PIE.get(), 1)
                .pattern("###")
                .pattern("aaa")
                .pattern("xOx")
                .define('#', GDModItems.GOLDEN_WHEAT.get())
                .define('a', Items.GOLDEN_APPLE)
                .define('x', GDModItems.GOLDEN_SUGAR.get())
                .define('O', GDModItems.GOLDEN_PIE_CRUST.get())
                .unlockedBy("has_golden_pie_crust", InventoryChangeTrigger.TriggerInstance.hasItems(GDModItems.GOLDEN_PIE_CRUST.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, GDModItems.GOLDEN_APPLE_PIE.get(), 1)
                .pattern("##")
                .pattern("##")
                .define('#', GDModItems.GOLDEN_APPLE_PIE_SLICE.get())
                .unlockedBy("has_golden_apple_pie_slice", InventoryChangeTrigger.TriggerInstance.hasItems(GDModItems.GOLDEN_APPLE_PIE_SLICE.get()))
                .save(consumer, new ResourceLocation(GolDelight.MOD_ID, "golden_apple_pie_from_slices"));
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, GDModItems.SWEET_GOLDEN_BERRY_CHEESECAKE.get(), 1)
                .pattern("sss")
                .pattern("sss")
                .pattern("mOm")
                .define('s', ItemRegistry.SWEET_GOLDEN_BERRIES.get())
                .define('m', GDModTags.Items.GOLDEN_MILK)
                .define('O', GDModItems.GOLDEN_PIE_CRUST.get())
                .unlockedBy("has_golden_pie_crust", InventoryChangeTrigger.TriggerInstance.hasItems(GDModItems.GOLDEN_PIE_CRUST.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, GDModItems.SWEET_GOLDEN_BERRY_CHEESECAKE.get(), 1)
                .pattern("##")
                .pattern("##")
                .define('#', GDModItems.SWEET_GOLDEN_BERRY_CHEESECAKE_SLICE.get())
                .unlockedBy("has_sweet_golden_berry_cheesecake_slice", InventoryChangeTrigger.TriggerInstance.hasItems(GDModItems.SWEET_GOLDEN_BERRY_CHEESECAKE_SLICE.get()))
                .save(consumer, new ResourceLocation(GolDelight.MOD_ID, "sweet_golden_berry_cheesecake_from_slices"));
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, GDModItems.GOLDEN_CHOCOLATE_PIE.get(), 1)
                .pattern("ccc")
                .pattern("mmm")
                .pattern("xOx")
                .define('c', GDModItems.GOLDEN_COCOA_BEANS.get())
                .define('m', GDModTags.Items.GOLDEN_MILK)
                .define('x', GDModItems.GOLDEN_SUGAR.get())
                .define('O', GDModItems.GOLDEN_PIE_CRUST.get())
                .unlockedBy("has_golden_pie_crust", InventoryChangeTrigger.TriggerInstance.hasItems(GDModItems.GOLDEN_PIE_CRUST.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, GDModItems.GOLDEN_CHOCOLATE_PIE.get(), 1)
                .pattern("##")
                .pattern("##")
                .define('#', GDModItems.GOLDEN_CHOCOLATE_PIE_SLICE.get())
                .unlockedBy("has_golden_chocolate_pie_slice", InventoryChangeTrigger.TriggerInstance.hasItems(GDModItems.GOLDEN_CHOCOLATE_PIE_SLICE.get()))
                .save(consumer, new ResourceLocation(GolDelight.MOD_ID, "golden_chocolate_pie_from_slices"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GDModItems.MIXED_GOLDEN_SALAD.get())
                .requires(GDModTags.Items.GOLDEN_SALAD_INGREDIENTS)
                .requires(GDModTags.Items.GOLDEN_CROPS_TOMATO)
                .requires(ItemRegistry.GOLDEN_BEETROOT.get())
                .requires(Items.BOWL)
                .unlockedBy("has_bowl", InventoryChangeTrigger.TriggerInstance.hasItems(Items.BOWL))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GDModItems.GOLDEN_NETHER_SALAD.get())
                .requires(GDModBlocks.GOLDEN_FUNGUS.get().asItem())
                .requires(GDModBlocks.GOLDEN_FUNGUS.get().asItem())
                .requires(Items.BOWL)
                .unlockedBy("has_bowl", InventoryChangeTrigger.TriggerInstance.hasItems(Items.BOWL))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GDModItems.GOLDEN_BARBECUE_STICK.get())
                .requires(GDModTags.Items.GOLDEN_CROPS_TOMATO)
                .requires(GDModTags.Items.GOLDEN_CROPS_ONION)
                .requires(Ingredient.fromValues(Stream.of(
                        new Ingredient.TagValue(GDModTags.Items.COOKED_GOLDEN_BEEF),
                        new Ingredient.TagValue(GDModTags.Items.COOKED_GOLDEN_PORK),
                        new Ingredient.TagValue(GDModTags.Items.COOKED_GOLDEN_CHICKEN),
                        new Ingredient.TagValue(GDModTags.Items.COOKED_GOLDEN_MUTTON),
                        new Ingredient.TagValue(GDModTags.Items.COOKED_GOLDEN_FISHES),
                        new Ingredient.ItemValue(new ItemStack(ItemRegistry.COOKED_GOLDEN_RABBIT.get()))
                )))
                .requires(Items.STICK)
                .unlockedBy("has_golden_tomato", InventoryChangeTrigger.TriggerInstance.hasItems(GDModItems.GOLDEN_TOMATO.get()))
                .unlockedBy("has_golden_onion", InventoryChangeTrigger.TriggerInstance.hasItems(GDModItems.GOLDEN_ONION.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GDModItems.GOLDEN_EGG_SANDWICH.get())
                .requires(GDModTags.Items.GOLDEN_BREAD)
                .requires(GDModTags.Items.COOKED_GOLDEN_EGGS)
                .requires(GDModTags.Items.COOKED_GOLDEN_EGGS)
                .unlockedBy("has_fried_golden_egg", InventoryChangeTrigger.TriggerInstance.hasItems(GDModItems.FRIED_GOLDEN_EGG.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GDModItems.GOLDEN_CHICKEN_SANDWICH.get())
                .requires(GDModTags.Items.GOLDEN_BREAD)
                .requires(GDModTags.Items.COOKED_GOLDEN_CHICKEN)
                .requires(GDModTags.Items.GOLDEN_SALAD_INGREDIENTS)
                .requires(Items.GOLDEN_CARROT)
                .unlockedBy("has_cooked_golden_chicken", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.COOKED_GOLDEN_CHICKEN.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GDModItems.GOLDEN_HAMBURGER.get())
                .requires(GDModTags.Items.GOLDEN_BREAD)
                .requires(GDModItems.GOLDEN_BEEF_PATTY.get())
                .requires(GDModTags.Items.GOLDEN_SALAD_INGREDIENTS)
                .requires(GDModTags.Items.GOLDEN_CROPS_TOMATO)
                .requires(GDModTags.Items.GOLDEN_CROPS_ONION)
                .unlockedBy("has_golden_beef_patty", InventoryChangeTrigger.TriggerInstance.hasItems(GDModItems.GOLDEN_BEEF_PATTY.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GDModItems.GOLDEN_BACON_SANDWICH.get())
                .requires(GDModTags.Items.GOLDEN_BREAD)
                .requires(GDModTags.Items.COOKED_GOLDEN_BACON)
                .requires(GDModTags.Items.GOLDEN_SALAD_INGREDIENTS)
                .requires(GDModTags.Items.GOLDEN_CROPS_TOMATO)
                .unlockedBy("has_golden_bacon", InventoryChangeTrigger.TriggerInstance.hasItems(GDModItems.COOKED_GOLDEN_BACON.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GDModItems.GOLDEN_WRAP.get())
                .requires(GDModTags.Items.GOLDEN_BREAD)
                .requires(GDModTags.Items.COOKED_GOLDEN_MUTTON)
                .requires(GDModTags.Items.GOLDEN_SALAD_INGREDIENTS)
                .requires(GDModTags.Items.GOLDEN_CROPS_ONION)
                .unlockedBy("has_golden_mutton", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.COOKED_GOLDEN_MUTTON.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GDModItems.STUFFED_GOLDEN_POTATO.get())
                .requires(ItemRegistry.BAKED_GOLDEN_POTATO.get())
                .requires(GDModTags.Items.COOKED_GOLDEN_BEEF)
                .requires(GDModTags.Items.GOLDEN_MILK)
                .unlockedBy("has_baked_golden_potato", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.BAKED_GOLDEN_POTATO.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GDModItems.GOLDEN_SALMON_ROLL.get(), 2)
                .requires(GDModItems.GOLDEN_SALMON_SLICE.get())
                .requires(GDModItems.GOLDEN_SALMON_SLICE.get())
                .requires(GDModItems.COOKED_GOLDEN_RICE.get())
                .unlockedBy("has_golden_salmon_slice", InventoryChangeTrigger.TriggerInstance.hasItems(GDModItems.GOLDEN_SALMON_SLICE.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GDModItems.GOLDEN_COD_ROLL.get(), 2)
                .requires(GDModItems.GOLDEN_COD_SLICE.get())
                .requires(GDModItems.GOLDEN_COD_SLICE.get())
                .requires(GDModItems.COOKED_GOLDEN_RICE.get())
                .unlockedBy("has_golden_cod_slice", InventoryChangeTrigger.TriggerInstance.hasItems(GDModItems.GOLDEN_COD_SLICE.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, GDModItems.GOLDEN_KELP_ROLL.get(), 1)
                .pattern("RXR")
                .pattern("###")
                .define('#', ItemRegistry.DRIED_GOLDEN_KELP.get())
                .define('R', GDModItems.COOKED_GOLDEN_RICE.get())
                .define('X', Items.GOLDEN_CARROT)
                .unlockedBy("has_dried_golden_kelp", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.DRIED_GOLDEN_KELP.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GDModItems.GRILLED_GOLDEN_SALMON.get())
                .requires(GDModTags.Items.COOKED_GOLDEN_FISHES_SALMON)
                .requires(ItemRegistry.SWEET_GOLDEN_BERRIES.get())
                .requires(Items.BOWL)
                .requires(GDModTags.Items.GOLDEN_CROPS_CABBAGE)
                .requires(GDModTags.Items.GOLDEN_CROPS_ONION)
                .unlockedBy("has_golden_salmon", InventoryChangeTrigger.TriggerInstance.hasItems(GDModItems.GOLDEN_SALMON.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GDModItems.GOLDEN_STEAK_AND_POTATOES.get())
                .requires(ItemRegistry.BAKED_GOLDEN_POTATO.get())
                .requires(ItemRegistry.COOKED_GOLDEN_BEEF.get())
                .requires(Items.BOWL)
                .requires(GDModTags.Items.GOLDEN_CROPS_ONION)
                .requires(GDModItems.COOKED_GOLDEN_RICE.get())
                .unlockedBy("has_baked_golden_potato", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.BAKED_GOLDEN_POTATO.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GDModItems.ROASTED_GOLDEN_CHOPS.get())
                .requires(GDModItems.COOKED_GOLDEN_MUTTON_CHOPS.get())
                .requires(ItemRegistry.GOLDEN_BEETROOT.get())
                .requires(Items.BOWL)
                .requires(GDModItems.COOKED_GOLDEN_RICE.get())
                .requires(GDModTags.Items.GOLDEN_CROPS_TOMATO)
                .unlockedBy("has_golden_mutton", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.COOKED_GOLDEN_MUTTON.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GDModItems.GOLDEN_BACON_AND_EGGS.get())
                .requires(GDModItems.COOKED_GOLDEN_BACON.get())
                .requires(GDModItems.COOKED_GOLDEN_BACON.get())
                .requires(Items.BOWL)
                .requires(GDModTags.Items.COOKED_GOLDEN_EGGS)
                .requires(GDModTags.Items.COOKED_GOLDEN_EGGS)
                .unlockedBy("has_golden_bacon", InventoryChangeTrigger.TriggerInstance.hasItems(GDModItems.COOKED_GOLDEN_BACON.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GDModItems.GOLDEN_ROAST_CHICKEN_BLOCK.get())
                .requires(GDModTags.Items.GOLDEN_CROPS_ONION)
                .requires(GDModTags.Items.GOLDEN_EGGS)
                .requires(GDModItems.GOLDEN_BREAD.get())
                .requires(Items.GOLDEN_CARROT)
                .requires(ItemRegistry.COOKED_GOLDEN_CHICKEN.get())
                .requires(ItemRegistry.BAKED_GOLDEN_POTATO.get())
                .requires(Items.GOLDEN_CARROT)
                .requires(Items.BOWL)
                .requires(ItemRegistry.BAKED_GOLDEN_POTATO.get())
                .unlockedBy("has_cooked_golden_chicken", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.COOKED_GOLDEN_CHICKEN.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GDModItems.GOLDEN_SHEPHERDS_PIE_BLOCK.get())
                .requires(ItemRegistry.BAKED_GOLDEN_POTATO.get())
                .requires(GDModTags.Items.GOLDEN_MILK)
                .requires(ItemRegistry.BAKED_GOLDEN_POTATO.get())
                .requires(GDModTags.Items.COOKED_GOLDEN_MUTTON)
                .requires(GDModTags.Items.COOKED_GOLDEN_MUTTON)
                .requires(GDModTags.Items.COOKED_GOLDEN_MUTTON)
                .requires(GDModTags.Items.GOLDEN_CROPS_ONION)
                .requires(Items.BOWL)
                .requires(GDModTags.Items.GOLDEN_CROPS_ONION)
                .unlockedBy("has_cooked_golden_mutton", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.COOKED_GOLDEN_MUTTON.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GDModItems.GOLDEN_GLAZED_HAM_BLOCK.get())
                .requires(ItemRegistry.SWEET_GOLDEN_BERRIES.get())
                .requires(GDModItems.GOLDEN_HONEY_BOTTLE.get())
                .requires(ItemRegistry.SWEET_GOLDEN_BERRIES.get())
                .requires(ItemRegistry.SWEET_GOLDEN_BERRIES.get())
                .requires(GDModItems.SMOKED_GOLDEN_HAM.get())
                .requires(ItemRegistry.SWEET_GOLDEN_BERRIES.get())
                .requires(GDModItems.COOKED_GOLDEN_RICE.get())
                .requires(Items.BOWL)
                .requires(GDModItems.COOKED_GOLDEN_RICE.get())
                .unlockedBy("has_smoked_golden_ham", InventoryChangeTrigger.TriggerInstance.hasItems(GDModItems.SMOKED_GOLDEN_HAM.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GDModItems.GOLDEN_RICE_ROLL_MEDLEY_BLOCK.get())
                .requires(GDModItems.GOLDEN_KELP_ROLL_SLICE.get())
                .requires(GDModItems.GOLDEN_KELP_ROLL_SLICE.get())
                .requires(GDModItems.GOLDEN_KELP_ROLL_SLICE.get())
                .requires(GDModItems.GOLDEN_SALMON_ROLL.get())
                .requires(GDModItems.GOLDEN_SALMON_ROLL.get())
                .requires(GDModItems.GOLDEN_SALMON_ROLL.get())
                .requires(GDModItems.GOLDEN_COD_ROLL.get())
                .requires(Items.BOWL)
                .requires(GDModItems.GOLDEN_COD_ROLL.get())
                .unlockedBy("has_golden_rice_roll", InventoryChangeTrigger.TriggerInstance.hasItems(GDModItems.GOLDEN_SALMON_ROLL.get(), GDModItems.GOLDEN_COD_ROLL.get(), GDModItems.GOLDEN_KELP_ROLL_SLICE.get()))
                .save(consumer);
    }

    private void registerCooking(Consumer<FinishedRecipe> consumer) {
        GoldenCookingPotRecipeBuilder.goldenCookingPotRecipe(GDModItems.GOLDEN_HOT_COCOA.get(), 1, NORMAL_COOKING, MEDIUM_EXP)
                .addIngredient(GDModTags.Items.GOLDEN_MILK)
                .addIngredient(GDModItems.GOLDEN_SUGAR.get())
                .addIngredient(GDModItems.GOLDEN_COCOA_BEANS.get())
                .addIngredient(GDModItems.GOLDEN_COCOA_BEANS.get())
                .unlockedByAnyIngredient(GDModItems.GOLDEN_COCOA_BEANS.get(), GDModItems.GOLDEN_MILK_BUCKET.get(), GDModItems.GOLDEN_MILK_BOTTLE.get())
                .setRecipeBookTab(GoldenCookingPotRecipeBookTab.GOLDEN_DRINKS)
                .build(consumer);
        GoldenCookingPotRecipeBuilder.goldenCookingPotRecipe(GDModItems.GAPPLE_CIDER.get(), 1, NORMAL_COOKING, MEDIUM_EXP)
                .addIngredient(Items.GOLDEN_APPLE)
                .addIngredient(Items.GOLDEN_APPLE)
                .addIngredient(GDModItems.GOLDEN_SUGAR.get())
                .unlockedByItems("has_golden_apple", Items.GOLDEN_APPLE)
                .setRecipeBookTab(GoldenCookingPotRecipeBookTab.GOLDEN_DRINKS)
                .build(consumer);
        GoldenCookingPotRecipeBuilder.goldenCookingPotRecipe(GDModItems.GOLDEN_TOMATO_SAUCE.get(), 1, FAST_COOKING, SMALL_EXP)
                .addIngredient(GDModTags.Items.GOLDEN_CROPS_TOMATO)
                .addIngredient(GDModTags.Items.GOLDEN_CROPS_TOMATO)
                .unlockedByItems("has_golden_tomato", GDModItems.GOLDEN_TOMATO.get())
                .setRecipeBookTab(GoldenCookingPotRecipeBookTab.GOLDEN_MISC)
                .build(consumer);
        GoldenCookingPotRecipeBuilder.goldenCookingPotRecipe(GDModItems.GOLDEN_DOG_FOOD.get(), 1, NORMAL_COOKING, MEDIUM_EXP)
                .addIngredient(GDModItems.ROTTEN_GOLDEN_FLESH.get())
                .addIngredient(GDModItems.GOLDEN_MEAL.get())
                .addIngredient(GDModTags.Items.GOLDEN_WOLF_PREY)
                .addIngredient(GDModTags.Items.GOLDEN_CROPS_RICE)
                .unlockedByAnyIngredient(GDModItems.ROTTEN_GOLDEN_FLESH.get(), GDModItems.GOLDEN_MEAL.get(), GDModItems.GOLDEN_RICE.get())
                .setRecipeBookTab(GoldenCookingPotRecipeBookTab.GOLDEN_MISC)
                .build(consumer);
        GoldenCookingPotRecipeBuilder.goldenCookingPotRecipe(GDModItems.GOLDEN_GLOW_BERRY_CUSTARD.get(), 1, NORMAL_COOKING, MEDIUM_EXP)
                .addIngredient(GDModItems.GOLDEN_GLOW_BERRIES.get())
                .addIngredient(GDModTags.Items.GOLDEN_MILK)
                .addIngredient(GDModTags.Items.GOLDEN_EGGS)
                .addIngredient(GDModItems.GOLDEN_SUGAR.get())
                .unlockedByAnyIngredient(GDModItems.GOLDEN_GLOW_BERRIES.get(), GDModItems.GOLDEN_MILK_BUCKET.get(), GDModItems.GOLDEN_MILK_BOTTLE.get())
                .setRecipeBookTab(GoldenCookingPotRecipeBookTab.GOLDEN_MISC)
                .build(consumer);

        GoldenCookingPotRecipeBuilder.goldenCookingPotRecipe(GDModItems.GOLDEN_MUSHROOM_STEW.get(), 1, NORMAL_COOKING, MEDIUM_EXP)
                .addIngredient(GDModTags.Items.GOLDEN_MUSHROOMS)
                .addIngredient(GDModBlocks.GOLDEN_MUSHROOM.get().asItem())
                .unlockedByAnyIngredient(GDModBlocks.GOLDEN_MUSHROOM.get())
                .setRecipeBookTab(GoldenCookingPotRecipeBookTab.GOLDEN_MEALS)
                .build(consumer);
        GoldenCookingPotRecipeBuilder.goldenCookingPotRecipe(ItemRegistry.GOLDEN_BEETROOT_SOUP.get(), 1, NORMAL_COOKING, MEDIUM_EXP, Items.BOWL)
                .addIngredient(ItemRegistry.GOLDEN_BEETROOT.get())
                .addIngredient(ItemRegistry.GOLDEN_BEETROOT.get())
                .addIngredient(ItemRegistry.GOLDEN_BEETROOT.get())
                .unlockedByItems("has_golden_beetroot", ItemRegistry.GOLDEN_BEETROOT.get())
                .setRecipeBookTab(GoldenCookingPotRecipeBookTab.GOLDEN_MEALS)
                .build(consumer);
        GoldenCookingPotRecipeBuilder.goldenCookingPotRecipe(GDModItems.GOLDEN_RABBIT_STEW.get(), 1, NORMAL_COOKING, MEDIUM_EXP, Items.BOWL)
                .addIngredient(ItemRegistry.BAKED_GOLDEN_POTATO.get())
                .addIngredient(GDModItems.GOLDEN_RABBIT.get())
                .addIngredient(Items.GOLDEN_CARROT)
                .addIngredient(Ingredient.of(GDModBlocks.GOLDEN_MUSHROOM.get().asItem()))
                .unlockedByAnyIngredient(GDModItems.GOLDEN_RABBIT.get(), GDModBlocks.GOLDEN_MUSHROOM.get().asItem(), Items.GOLDEN_CARROT, ItemRegistry.BAKED_GOLDEN_POTATO.get())
                .setRecipeBookTab(GoldenCookingPotRecipeBookTab.GOLDEN_MEALS)
                .build(consumer);

        GoldenCookingPotRecipeBuilder.goldenCookingPotRecipe(GDModItems.GOLDEN_BAKED_COD_STEW.get(), 1, NORMAL_COOKING, MEDIUM_EXP, Items.BOWL)
                .addIngredient(GDModTags.Items.RAW_GOLDEN_FISHES_COD)
                .addIngredient(GDModItems.GOLDEN_POTATO.get())
                .addIngredient(GDModTags.Items.GOLDEN_EGGS)
                .addIngredient(GDModTags.Items.GOLDEN_CROPS_TOMATO)
                .unlockedByAnyIngredient(GDModItems.GOLDEN_COD.get(), GDModItems.GOLDEN_POTATO.get(), GDModItems.GOLDEN_TOMATO.get(), GDModItems.GOLDEN_EGG.get())
                .setRecipeBookTab(GoldenCookingPotRecipeBookTab.GOLDEN_MEALS)
                .build(consumer);
        GoldenCookingPotRecipeBuilder.goldenCookingPotRecipe(GDModItems.GOLDEN_BEEF_STEW.get(), 1, NORMAL_COOKING, MEDIUM_EXP, Items.BOWL)
                .addIngredient(GDModTags.Items.RAW_GOLDEN_BEEF)
                .addIngredient(Items.GOLDEN_CARROT)
                .addIngredient(GDModItems.GOLDEN_POTATO.get())
                .unlockedByAnyIngredient(GDModItems.GOLDEN_BEEF.get(), Items.GOLDEN_CARROT, GDModItems.GOLDEN_POTATO.get())
                .setRecipeBookTab(GoldenCookingPotRecipeBookTab.GOLDEN_MEALS)
                .build(consumer);
        GoldenCookingPotRecipeBuilder.goldenCookingPotRecipe(GDModItems.GOLDEN_BROTH.get(), 1, NORMAL_COOKING, SMALL_EXP, Items.BOWL)
                .addIngredient(GDModItems.GOLDEN_BONE.get())
                .addIngredient(Ingredient.fromValues(Stream.of(
                        new Ingredient.ItemValue(new ItemStack(GDModItems.GOLDEN_GLOW_BERRIES.get())),
                        new Ingredient.TagValue(GDModTags.Items.GOLDEN_MUSHROOMS)
                )))
                .unlockedByItems("has_golden_bone", GDModItems.GOLDEN_BONE.get())
                .setRecipeBookTab(GoldenCookingPotRecipeBookTab.GOLDEN_MEALS)
                .build(consumer);
        GoldenCookingPotRecipeBuilder.goldenCookingPotRecipe(GDModItems.GOLDEN_CABBAGE_ROLLS.get(), 1, FAST_COOKING, SMALL_EXP)
                .addIngredient(GDModTags.Items.GOLDEN_CROPS_CABBAGE)
                .addIngredient(GDModTags.Items.GOLDEN_CABBAGE_ROLL_INGREDIENTS)
                .unlockedByAnyIngredient(GDModItems.GOLDEN_CABBAGE.get(), GDModItems.GOLDEN_CABBAGE_LEAF.get())
                .setRecipeBookTab(GoldenCookingPotRecipeBookTab.GOLDEN_MISC)
                .build(consumer);
        GoldenCookingPotRecipeBuilder.goldenCookingPotRecipe(GDModItems.GOLDEN_CHICKEN_SOUP.get(), 1, NORMAL_COOKING, MEDIUM_EXP, Items.BOWL)
                .addIngredient(GDModTags.Items.RAW_GOLDEN_CHICKEN)
                .addIngredient(Items.GOLDEN_CARROT)
                .addIngredient(GDModTags.Items.GOLDEN_SALAD_INGREDIENTS)
                .addIngredient(GDModTags.Items.GOLDEN_VEGETABLES)
                .unlockedByAnyIngredient(GDModItems.GOLDEN_CHICKEN.get(), Items.GOLDEN_CARROT)
                .setRecipeBookTab(GoldenCookingPotRecipeBookTab.GOLDEN_MEALS)
                .build(consumer);
        GoldenCookingPotRecipeBuilder.goldenCookingPotRecipe(GDModItems.COOKED_GOLDEN_RICE.get(), 1, FAST_COOKING, SMALL_EXP, Items.BOWL)
                .addIngredient(GDModTags.Items.GOLDEN_CROPS_RICE)
                .unlockedByItems("has_golden_rice", GDModItems.GOLDEN_RICE.get())
                .setRecipeBookTab(GoldenCookingPotRecipeBookTab.GOLDEN_MISC)
                .build(consumer);
        GoldenCookingPotRecipeBuilder.goldenCookingPotRecipe(GDModItems.GUMPLINGS.get(), 2, NORMAL_COOKING, MEDIUM_EXP)
                .addIngredient(GDModTags.Items.GOLDEN_DOUGH)
                .addIngredient(GDModTags.Items.GOLDEN_CROPS_CABBAGE)
                .addIngredient(GDModTags.Items.GOLDEN_CROPS_ONION)
                .addIngredient(Ingredient.fromValues(Stream.of(
                        new Ingredient.TagValue(GDModTags.Items.RAW_GOLDEN_CHICKEN),
                        new Ingredient.TagValue(GDModTags.Items.RAW_GOLDEN_PORK),
                        new Ingredient.TagValue(GDModTags.Items.RAW_GOLDEN_BEEF),
                        new Ingredient.ItemValue(new ItemStack(GDModBlocks.GOLDEN_MUSHROOM.get().asItem()))
                )))
                .unlockedByAnyIngredient(GDModItems.GOLDEN_WHEAT_DOUGH.get(), GDModItems.GOLDEN_CABBAGE.get(), GDModItems.GOLDEN_ONION.get())
                .setRecipeBookTab(GoldenCookingPotRecipeBookTab.GOLDEN_MISC)
                .build(consumer);
        GoldenCookingPotRecipeBuilder.goldenCookingPotRecipe(GDModItems.GOLDEN_FISH_STEW.get(), 1, NORMAL_COOKING, MEDIUM_EXP)
                .addIngredient(GDModTags.Items.RAW_GOLDEN_FISHES)
                .addIngredient(GDModItems.GOLDEN_TOMATO_SAUCE.get())
                .addIngredient(GDModTags.Items.GOLDEN_CROPS_ONION)
                .unlockedByAnyIngredient(GDModItems.GOLDEN_SALMON.get(), GDModItems.GOLDEN_COD.get(), GDModItems.GOLDEN_TROPICAL_FISH.get(), GDModItems.GOLDEN_TOMATO_SAUCE.get(), GDModItems.GOLDEN_ONION.get())
                .setRecipeBookTab(GoldenCookingPotRecipeBookTab.GOLDEN_MEALS)
                .build(consumer);
        GoldenCookingPotRecipeBuilder.goldenCookingPotRecipe(GDModItems.FRIED_GOLDEN_RICE.get(), 1, NORMAL_COOKING, MEDIUM_EXP)
                .addIngredient(GDModTags.Items.GOLDEN_CROPS_RICE)
                .addIngredient(GDModTags.Items.GOLDEN_EGGS)
                .addIngredient(Items.GOLDEN_CARROT)
                .addIngredient(GDModTags.Items.GOLDEN_CROPS_ONION)
                .unlockedByAnyIngredient(GDModItems.GOLDEN_RICE.get(), GDModItems.GOLDEN_EGG.get(), Items.GOLDEN_CARROT, GDModItems.GOLDEN_ONION.get())
                .setRecipeBookTab(GoldenCookingPotRecipeBookTab.GOLDEN_MEALS)
                .build(consumer);
        GoldenCookingPotRecipeBuilder.goldenCookingPotRecipe(GDModItems.GOLDEN_MUSHROOM_RICE.get(), 1, NORMAL_COOKING, MEDIUM_EXP)
                .addIngredient(GDModTags.Items.GOLDEN_MUSHROOMS)
                .addIngredient(GDModBlocks.GOLDEN_MUSHROOM.get().asItem())
                .addIngredient(GDModTags.Items.GOLDEN_CROPS_RICE)
                .addIngredient(Ingredient.of(Items.GOLDEN_CARROT, GDModItems.GOLDEN_POTATO.get()))
                .unlockedByAnyIngredient(GDModBlocks.GOLDEN_MUSHROOM.get(), GDModItems.GOLDEN_RICE.get())
                .setRecipeBookTab(GoldenCookingPotRecipeBookTab.GOLDEN_MEALS)
                .build(consumer);
        GoldenCookingPotRecipeBuilder.goldenCookingPotRecipe(GDModItems.GOLDEN_NOODLE_SOUP.get(), 1, NORMAL_COOKING, MEDIUM_EXP)
                .addIngredient(GDModTags.Items.GOLDEN_PASTA)
                .addIngredient(GDModTags.Items.COOKED_GOLDEN_EGGS)
                .addIngredient(ItemRegistry.DRIED_GOLDEN_KELP.get())
                .addIngredient(GDModTags.Items.RAW_GOLDEN_PORK)
                .unlockedByAnyIngredient(GDModItems.RAW_GOLDEN_PASTA.get(), ItemRegistry.DRIED_GOLDEN_KELP.get(), GDModItems.GOLDEN_PORKCHOP.get())
                .setRecipeBookTab(GoldenCookingPotRecipeBookTab.GOLDEN_MEALS)
                .build(consumer);
        GoldenCookingPotRecipeBuilder.goldenCookingPotRecipe(GDModItems.GOLDEN_PASTA_WITH_MEATBALLS.get(), 1, NORMAL_COOKING, MEDIUM_EXP)
                .addIngredient(GDModItems.MINCED_GOLDEN_BEEF.get())
                .addIngredient(GDModTags.Items.GOLDEN_PASTA)
                .addIngredient(GDModItems.GOLDEN_TOMATO_SAUCE.get())
                .unlockedByAnyIngredient(GDModItems.RAW_GOLDEN_PASTA.get(), GDModItems.GOLDEN_BEEF.get(), GDModItems.GOLDEN_TOMATO_SAUCE.get())
                .setRecipeBookTab(GoldenCookingPotRecipeBookTab.GOLDEN_MEALS)
                .build(consumer);
        GoldenCookingPotRecipeBuilder.goldenCookingPotRecipe(GDModItems.GOLDEN_PASTA_WITH_MUTTON_CHOP.get(), 1, NORMAL_COOKING, MEDIUM_EXP)
                .addIngredient(GDModTags.Items.RAW_GOLDEN_MUTTON)
                .addIngredient(GDModTags.Items.GOLDEN_PASTA)
                .addIngredient(GDModItems.GOLDEN_TOMATO_SAUCE.get())
                .unlockedByAnyIngredient(GDModItems.RAW_GOLDEN_PASTA.get(), GDModItems.GOLDEN_MUTTON.get(), GDModItems.GOLDEN_TOMATO_SAUCE.get())
                .setRecipeBookTab(GoldenCookingPotRecipeBookTab.GOLDEN_MEALS)
                .build(consumer);
        GoldenCookingPotRecipeBuilder.goldenCookingPotRecipe(GDModItems.GOLDEN_PUMPKIN_SOUP.get(), 1, NORMAL_COOKING, MEDIUM_EXP)
                .addIngredient(GDModItems.GOLDEN_PUMPKIN_SLICE.get())
                .addIngredient(GDModTags.Items.GOLDEN_SALAD_INGREDIENTS)
                .addIngredient(GDModTags.Items.RAW_GOLDEN_PORK)
                .addIngredient(GDModTags.Items.GOLDEN_MILK)
                .unlockedByAnyIngredient(GDModBlocks.GOLDEN_PUMPKIN.get().asItem(), GDModItems.GOLDEN_PUMPKIN_SLICE.get(), GDModItems.GOLDEN_PORKCHOP.get(), GDModItems.GOLDEN_MILK_BUCKET.get(), GDModItems.GOLDEN_MILK_BOTTLE.get())
                .setRecipeBookTab(GoldenCookingPotRecipeBookTab.GOLDEN_MEALS)
                .build(consumer);
        GoldenCookingPotRecipeBuilder.goldenCookingPotRecipe(GDModItems.GOLDEN_RATATOUILLE.get(), 1, NORMAL_COOKING, MEDIUM_EXP)
                .addIngredient(GDModTags.Items.GOLDEN_CROPS_TOMATO)
                .addIngredient(GDModTags.Items.GOLDEN_CROPS_ONION)
                .addIngredient(ItemRegistry.GOLDEN_BEETROOT.get())
                .addIngredient(GDModTags.Items.GOLDEN_VEGETABLES)
                .unlockedByAnyIngredient(GDModItems.GOLDEN_TOMATO.get(), GDModItems.GOLDEN_ONION.get(), ItemRegistry.GOLDEN_BEETROOT.get())
                .setRecipeBookTab(GoldenCookingPotRecipeBookTab.GOLDEN_MEALS)
                .build(consumer);
        GoldenCookingPotRecipeBuilder.goldenCookingPotRecipe(GDModItems.GOLDEN_INK_PASTA.get(), 1, NORMAL_COOKING, MEDIUM_EXP)
                .addIngredient(GDModTags.Items.RAW_GOLDEN_FISHES)
                .addIngredient(GDModTags.Items.GOLDEN_PASTA)
                .addIngredient(GDModTags.Items.GOLDEN_CROPS_TOMATO)
                .addIngredient(GDModItems.GOLDEN_INK_SAC.get())
                .unlockedByAnyIngredient(GDModItems.RAW_GOLDEN_PASTA.get(), GDModItems.GOLDEN_INK_SAC.get(), GDModItems.GOLDEN_TOMATO.get())
                .setRecipeBookTab(GoldenCookingPotRecipeBookTab.GOLDEN_MEALS)
                .build(consumer);
        GoldenCookingPotRecipeBuilder.goldenCookingPotRecipe(GDModItems.STUFFED_GOLDEN_PUMPKIN_BLOCK.get(), 1, SLOW_COOKING, LARGE_EXP, GDModBlocks.GOLDEN_PUMPKIN.get().asItem())
                .addIngredient(GDModTags.Items.GOLDEN_CROPS_RICE)
                .addIngredient(GDModTags.Items.GOLDEN_CROPS_ONION)
                .addIngredient(GDModTags.Items.GOLDEN_MUSHROOMS)
                .addIngredient(GDModItems.GOLDEN_POTATO.get())
                .addIngredient(GDModTags.Items.GOLDEN_BERRIES)
                .addIngredient(GDModTags.Items.GOLDEN_VEGETABLES)
                .unlockedByItems("has_golden_pumpkin", GDModBlocks.GOLDEN_PUMPKIN.get())
                .setRecipeBookTab(GoldenCookingPotRecipeBookTab.GOLDEN_MEALS)
                .build(consumer);
        GoldenCookingPotRecipeBuilder.goldenCookingPotRecipe(GDModItems.GOLDEN_VEGETABLE_NOODLES.get(), 1, NORMAL_COOKING, MEDIUM_EXP)
                .addIngredient(Items.GOLDEN_CARROT)
                .addIngredient(GDModTags.Items.GOLDEN_MUSHROOMS)
                .addIngredient(GDModTags.Items.GOLDEN_PASTA)
                .addIngredient(GDModTags.Items.GOLDEN_SALAD_INGREDIENTS)
                .addIngredient(GDModTags.Items.GOLDEN_VEGETABLES)
                .unlockedByAnyIngredient(GDModItems.RAW_GOLDEN_PASTA.get(), GDModBlocks.GOLDEN_MUSHROOM.get().asItem(), Items.GOLDEN_CARROT)
                .setRecipeBookTab(GoldenCookingPotRecipeBookTab.GOLDEN_MEALS)
                .build(consumer);
        GoldenCookingPotRecipeBuilder.goldenCookingPotRecipe(GDModItems.GOLDEN_VEGETABLE_SOUP.get(), 1, NORMAL_COOKING, MEDIUM_EXP)
                .addIngredient(Items.GOLDEN_CARROT)
                .addIngredient(GDModItems.GOLDEN_POTATO.get())
                .addIngredient(ItemRegistry.GOLDEN_BEETROOT.get())
                .addIngredient(GDModTags.Items.GOLDEN_SALAD_INGREDIENTS)
                .unlockedByAnyIngredient(Items.GOLDEN_CARROT, GDModItems.GOLDEN_ONION.get(), ItemRegistry.GOLDEN_BEETROOT.get())
                .setRecipeBookTab(GoldenCookingPotRecipeBookTab.GOLDEN_MEALS)
                .build(consumer);
    }

    private void registerBuilding(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, GDModBlocks.NETHER_BRICK_STOVE.get())
                .pattern("iii")
                .pattern("N N")
                .pattern("NCN")
                .define('i', Tags.Items.INGOTS_IRON)
                .define('N', Blocks.NETHER_BRICKS)
                .define('C', Blocks.SOUL_CAMPFIRE)
                .unlockedBy("has_soul_campfire", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.SOUL_CAMPFIRE))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, GDModBlocks.GOLDEN_COOKING_POT.get())
                .pattern("bSb")
                .pattern("gWg")
                .pattern("ggg")
                .define('b', Items.NETHER_BRICK)
                .define('g', Tags.Items.INGOTS_GOLD)
                .define('S', Items.WOODEN_SHOVEL)
                .define('W', Items.WATER_BUCKET)
                .unlockedBy("has_gol_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GOLD_INGOT))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, GDModBlocks.GOLDEN_CABINET.get())
                .pattern("___")
                .pattern("D D")
                .pattern("___")
                .define('_', GDModBlocks.GOLDEN_SLAB.get())
                .define('D', GDModBlocks.GOLDEN_TRAPDOOR.get())
                .unlockedBy("has_golden_trapdoor", InventoryChangeTrigger.TriggerInstance.hasItems(GDModBlocks.GOLDEN_TRAPDOOR.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, GDModBlocks.GOLDEN_COMPOST.get(), 1)
                .requires(ModItems.ORGANIC_COMPOST.get())
                .requires(GDModItems.ROTTEN_GOLDEN_FLESH.get())
                .requires(GDModItems.ROTTEN_GOLDEN_FLESH.get())
                .requires(ModItems.STRAW.get())
                .requires(ModItems.STRAW.get())
                .requires(GDModItems.GOLDEN_MEAL.get())
                .requires(GDModItems.GOLDEN_MEAL.get())
                .requires(GDModItems.GOLDEN_MEAL.get())
                .requires(GDModItems.GOLDEN_MEAL.get())
                .unlockedBy("has_rotten_golden_flesh", InventoryChangeTrigger.TriggerInstance.hasItems(GDModItems.ROTTEN_GOLDEN_FLESH.get()))
                .unlockedBy("has_organic_compost", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ORGANIC_COMPOST.get()))
                .save(consumer, new ResourceLocation(GolDelight.MOD_ID, "golden_compost_from_rotten_golden_flesh"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, GDModBlocks.GOLDEN_COMPOST.get(), 1)
                .requires(ModItems.ORGANIC_COMPOST.get())
                .requires(ModItems.STRAW.get())
                .requires(ModItems.STRAW.get())
                .requires(GDModItems.GOLDEN_MEAL.get())
                .requires(GDModItems.GOLDEN_MEAL.get())
                .requires(ModItems.TREE_BARK.get())
                .requires(ModItems.TREE_BARK.get())
                .requires(ModItems.TREE_BARK.get())
                .requires(ModItems.TREE_BARK.get())
                .unlockedBy("has_organic_compost", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ORGANIC_COMPOST.get()))
                .save(consumer, new ResourceLocation(GolDelight.MOD_ID, "golden_compost_from_tree_bark"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, GDModBlocks.GOLDEN_NETHER_BRICKS.get())
                .pattern("NG")
                .pattern("GN")
                .define('N', Items.NETHER_BRICK)
                .define('G', GDModItems.GOLDEN_WART.get())
                .unlockedBy("has_golden_wart", InventoryChangeTrigger.TriggerInstance.hasItems(GDModItems.GOLDEN_WART.get()))
                .save(consumer);
        Smelting(consumer, List.of(GDModBlocks.CRACKED_GOLDEN_NETHER_BRICKS.get()), GDModBlocks.CRACKED_GOLDEN_NETHER_BRICKS.get());
        chiseled(consumer, RecipeCategory.BUILDING_BLOCKS, GDModBlocks.CHISELED_GOLDEN_NETHER_BRICKS.get(), GDModBlocks.GOLDEN_NETHER_BRICK_SLAB.get());
        slab(consumer, RecipeCategory.BUILDING_BLOCKS, GDModBlocks.GOLDEN_NETHER_BRICK_SLAB.get(), GDModBlocks.GOLDEN_NETHER_BRICKS.get());
        stairs(consumer, GDModBlocks.GOLDEN_NETHER_BRICK_STAIRS.get(), GDModBlocks.GOLDEN_NETHER_BRICKS.get());
        fence(consumer, GDModBlocks.GOLDEN_NETHER_BRICK_FENCE.get(), GDModBlocks.GOLDEN_NETHER_BRICKS.get());
        wall(consumer, RecipeCategory.DECORATIONS, GDModBlocks.GOLDEN_NETHER_BRICK_WALL.get(), GDModBlocks.GOLDEN_NETHER_BRICKS.get());
        planksFromLogs(consumer, GDModBlocks.GOLDEN_PLANKS.get(), GDModTags.Items.GOLDEN_STEMS, 4);
        woodFromLogs(consumer, GDModBlocks.GOLDEN_HYPHAE.get(), GDModBlocks.GOLDEN_STEM.get());
        woodFromLogs(consumer, GDModBlocks.STRIPPED_GOLDEN_HYPHAE.get(), GDModBlocks.STRIPPED_GOLDEN_STEM.get());
        slab(consumer, RecipeCategory.BUILDING_BLOCKS, GDModBlocks.GOLDEN_SLAB.get(), GDModBlocks.GOLDEN_PLANKS.get());
        stairs(consumer, GDModBlocks.GOLDEN_STAIRS.get(), GDModBlocks.GOLDEN_PLANKS.get());
        woodenFence(consumer, GDModBlocks.GOLDEN_FENCE.get(), GDModBlocks.GOLDEN_PLANKS.get());
        fenceGate(consumer, GDModBlocks.GOLDEN_FENCE_GATE.get(), GDModBlocks.GOLDEN_PLANKS.get());
        button(consumer, GDModBlocks.GOLDEN_BUTTON.get(), GDModBlocks.GOLDEN_PLANKS.get());
        pressurePlate(consumer, GDModBlocks.GOLDEN_PRESSURE_PLATE.get(), GDModBlocks.GOLDEN_PLANKS.get());
        door(consumer, GDModBlocks.GOLDEN_DOOR.get(), GDModBlocks.GOLDEN_PLANKS.get());
        trapdoor(consumer, GDModBlocks.GOLDEN_TRAPDOOR.get(), GDModBlocks.GOLDEN_PLANKS.get());
        sign(consumer, GDModBlocks.GOLDEN_SIGN.get(), GDModBlocks.GOLDEN_PLANKS.get());
        hangingSign(consumer, GDModItems.GOLDEN_HANGING_SIGN.get(), GDModBlocks.GOLDEN_PLANKS.get());
        stoneCutting(consumer, GDModBlocks.GOLDEN_SLAB.get(), GDModBlocks.GOLDEN_NETHER_BRICKS.get(), 2);
        stoneCutting(consumer, GDModBlocks.GOLDEN_STAIRS.get(), GDModBlocks.GOLDEN_NETHER_BRICKS.get(), 1);
        stoneCutting(consumer, GDModBlocks.GOLDEN_NETHER_BRICK_FENCE.get(), GDModBlocks.GOLDEN_NETHER_BRICKS.get(), 1);
        stoneCutting(consumer, GDModBlocks.GOLDEN_NETHER_BRICK_WALL.get(), GDModBlocks.GOLDEN_NETHER_BRICKS.get(), 1);
        stoneCutting(consumer, GDModBlocks.CHISELED_GOLDEN_NETHER_BRICKS.get(), GDModBlocks.GOLDEN_NETHER_BRICKS.get(), 1);
        TwoByTwo(consumer, GDModItems.GOLDEN_HONEYCOMB.get(), GDModBlocks.GOLDEN_HONEYCOMB_BLOCK.get());
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, GDModBlocks.GOLDEN_BEEHIVE.get())
                .pattern("PPP")
                .pattern("HGH")
                .pattern("PPP")
                .define('P', GDModBlocks.GOLDEN_PLANKS.get())
                .define('H', Items.HONEYCOMB)
                .define('G', Items.GOLD_INGOT)
                .unlockedBy("has_honeycomb", InventoryChangeTrigger.TriggerInstance.hasItems(Items.HONEYCOMB))
                .save(consumer);
    }
}
