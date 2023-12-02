package net.endil.goldelight.common.registry;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.registry.ModEffects;

public class GDModFoods {
    private static FoodProperties.Builder rawMeat(int pNutrition) {
        return (new FoodProperties.Builder()).nutrition(pNutrition).saturationMod(0.3F).meat();
    }
    private static FoodProperties.Builder rawFish(int pNutrition) {
        return (new FoodProperties.Builder()).nutrition(pNutrition).saturationMod(0.1F);
    }
    private static FoodProperties.Builder rawCut(int pNutrition) {
        return rawMeat(pNutrition).fast();
    }
    private static FoodProperties.Builder rawSlice(int pNutrition) {
        return rawFish(pNutrition).fast();
    }


    //Minecraft
    public static final FoodProperties GOLDEN_BEEF = rawMeat(4).build();
    public static final FoodProperties GOLDEN_BREAD = new FoodProperties.Builder()
            .nutrition(8).saturationMod(0.6f).build();
    public static final FoodProperties GOLDEN_CHICKEN = rawMeat(3).build();
    public static final FoodProperties GOLDEN_COD = rawFish(3).build();
    public static final FoodProperties GOLDEN_COOKIE = new FoodProperties.Builder()
            .nutrition(3).saturationMod(0.1f).fast().build();
    public static final FoodProperties GOLDEN_GLOW_BERRIES = new FoodProperties.Builder()
            .nutrition(3).saturationMod(0.1f).fast().build();
    public static final FoodProperties GOLDEN_HONEY_BOTTLE = new FoodProperties.Builder()
            .nutrition(8).saturationMod(0.1f).build();
    public static final FoodProperties GOLDEN_MELON_SLICE = new FoodProperties.Builder()
            .nutrition(3).saturationMod(0.3f).build();
    public static final FoodProperties GOLDEN_MUSHROOM_STEW = new FoodProperties.Builder()
            .nutrition(8).saturationMod(0.6f).build();
    public static final FoodProperties GOLDEN_MUTTON = rawMeat(3).build();
    public static final FoodProperties GOLDEN_PORKCHOP = rawMeat(4).build();
    public static final FoodProperties GOLDEN_POTATO = new FoodProperties.Builder()
            .nutrition(2).saturationMod(0.3f).build();
    public static final FoodProperties GOLDEN_PUFFERFISH = rawFish(2).build();
    public static final FoodProperties GOLDEN_RABBIT = rawMeat(5).build();
    public static final FoodProperties GOLDEN_RABBIT_STEW = new FoodProperties.Builder()
            .nutrition(12).saturationMod(0.6f).build();
    public static final FoodProperties ROTTEN_GOLDEN_FLESH = new FoodProperties.Builder()
            .nutrition(6).saturationMod(0.1f).meat().build();
    public static final FoodProperties GOLDEN_SALMON = rawFish(3).build();
    public static final FoodProperties GOLDEN_TROPICAL_FISH = rawFish(2).build();

    //Farmer's Delight

    public static final FoodProperties GOLDEN_CABBAGE = new FoodProperties.Builder()
            .nutrition(4).saturationMod(0.4f).build();

    public static final FoodProperties GOLDEN_TOMATO = new FoodProperties.Builder()
            .nutrition(3).saturationMod(0.3f).build();

    public static final FoodProperties GOLDEN_ONION = new FoodProperties.Builder()
            .nutrition(4).saturationMod(0.4f).build();

    public static final FoodProperties GAPPLE_CIDER = (new FoodProperties.Builder()).alwaysEat()
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 1800, 1), 1.0F).build();

    public static final FoodProperties FRIED_GOLDEN_EGG = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.4F).build();

    public static final FoodProperties GOLDEN_TOMATO_SAUCE = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.4F).build();

    public static final FoodProperties GOLDEN_WHEAT_DOUGH = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.3F)
            .effect(() -> new MobEffectInstance(MobEffects.HUNGER, 300, 0), 0.15F).build();

    public static final FoodProperties RAW_GOLDEN_PASTA = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.3F)
            .effect(() -> new MobEffectInstance(MobEffects.HUNGER, 300, 0), 0.15F).build();

    public static final FoodProperties GOLDEN_PIE_CRUST = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.2F).build();

    public static final FoodProperties GOLDEN_PUMPKIN_SLICE = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.3F).build();

    public static final FoodProperties GOLDEN_CABBAGE_LEAF = new FoodProperties.Builder()
            .nutrition(2).saturationMod(0.4f).fast().build();

    public static final FoodProperties MINCED_GOLDEN_BEEF = rawCut(2).build();

    public static final FoodProperties GOLDEN_BEEF_PATTY = new FoodProperties.Builder()
            .nutrition(5).saturationMod(0.8f).meat().fast().build();

    public static final FoodProperties GOLDEN_CHICKEN_CUTS = rawCut(2)
            .effect(() -> new MobEffectInstance(MobEffects.HUNGER, 300, 0), 0.15F).build();
    public static final FoodProperties COOKED_GOLDEN_CHICKEN_CUTS = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.6F).meat().fast()
            .effect(() -> new  MobEffectInstance(MobEffects.SLOW_FALLING, 600, 0), 1.0F).build();
    public static final FoodProperties GOLDEN_BACON = rawCut(2).build();

    public static final FoodProperties COOKED_GOLDEN_BACON = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.8F).meat().fast().build();
    public static final FoodProperties GOLDEN_COD_SLICE = rawSlice(2).build();
    public static final FoodProperties COOKED_GOLDEN_COD_SLICE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.5F).fast().build();
    public static final FoodProperties GOLDEN_SALMON_SLICE = rawSlice(2).build();
    public static final FoodProperties COOKED_GOLDEN_SALMON_SLICE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.8F).fast()
            .effect(() -> new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 1050, 0), 1.0F).build();
    public static final FoodProperties GOLDEN_MUTTON_CHOP = rawCut(2).build();
    public static final FoodProperties COOKED_GOLDEN_MUTTON_CHOP = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.8F).meat().fast().build();
    public static final FoodProperties GOLDEN_HAM = rawMeat(9).build();
    public static final FoodProperties SMOKED_GOLDEN_HAM = (new FoodProperties.Builder()).nutrition(18).saturationMod(0.8F).meat().build();
    public static final FoodProperties GOLDEN_POPSICLE = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.2F).fast().alwaysEat()
            .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 600, 0, false, false), 1.0F).build();
    public static final FoodProperties GOLDEN_COOKIES = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.1F).fast().build();
    public static final FoodProperties GOLDEN_CAKE_SLICE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.1F).fast()
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 600, 1, false, false), 1.0F).build();
    public static final FoodProperties GOLDEN_PIE_SLICE = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.3F).fast()
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 900, 1, false, false), 1.0F).build();
    public static final FoodProperties GOLDEN_FRUIT_SALAD = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.6F)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 150, 1), 1.0F).build();
    public static final FoodProperties GOLDEN_GLOW_BERRY_CUSTARD = (new FoodProperties.Builder()).nutrition(10).saturationMod(0.6F).alwaysEat()
            .effect(() -> new MobEffectInstance(MobEffects.GLOWING, 50, 0), 0.5F).build();
    public static final FoodProperties MIXED_GOLDEN_SALAD = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.6F)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 150, 1), 1.0F).build();
    public static final FoodProperties GOLDEN_NETHER_SALAD = (new FoodProperties.Builder()).nutrition(7).saturationMod(0.4F)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 120, 0), 0.15F).build();
    public static final FoodProperties GOLDEN_BARBECUE_STICK = (new FoodProperties.Builder()).nutrition(10).saturationMod(0.9F).build();
    public static final FoodProperties GOLDEN_EGG_SANDWICH = (new FoodProperties.Builder()).nutrition(10).saturationMod(0.8F).build();
    public static final FoodProperties GOLDEN_CHICKEN_SANDWICH = (new FoodProperties.Builder()).nutrition(12).saturationMod(0.8F).build();
    public static final FoodProperties GOLDEN_HAMBURGER = (new FoodProperties.Builder()).nutrition(14).saturationMod(0.8F).build();
    public static final FoodProperties GOLDEN_BACON_SANDWICH = (new FoodProperties.Builder()).nutrition(12).saturationMod(0.8F).build();
    public static final FoodProperties GOLDEN_WRAP = (new FoodProperties.Builder()).nutrition(12).saturationMod(0.8F).build();
    public static final FoodProperties GUMPLINGS = (new FoodProperties.Builder()).nutrition(10).saturationMod(0.8F).build();
    public static final FoodProperties STUFFED_GOLDEN_POTATO = (new FoodProperties.Builder()).nutrition(12).saturationMod(0.7F).build();
    public static final FoodProperties GOLDEN_CABBAGE_ROLLS = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.5F).build();
    public static final FoodProperties GOLDEN_SALMON_ROLL = (new FoodProperties.Builder()).nutrition(9).saturationMod(0.6F).build();
    public static final FoodProperties GOLDEN_COD_ROLL = (new FoodProperties.Builder()).nutrition(9).saturationMod(0.6F).build();
    public static final FoodProperties GOLDEN_KELP_ROLL = (new FoodProperties.Builder()).nutrition(14).saturationMod(0.6F).build();
    public static final FoodProperties GOLDEN_KELP_ROLL_SLICE = (new FoodProperties.Builder()).nutrition(7).saturationMod(0.5F).fast().build();
    public static final FoodProperties COOKED_GOLDEN_RICE = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.4F).effect(() -> {
        return new MobEffectInstance(ModEffects.COMFORT.get(), 900, 0);
    }, 1.0F).build();
    public static final FoodProperties GOLDEN_BROTH = (new FoodProperties.Builder()).nutrition(10).saturationMod(0.7F).effect(() -> {
        return new MobEffectInstance(ModEffects.COMFORT.get(), 1800, 0);
    }, 1.0F).build();
    public static final FoodProperties GOLDEN_BEEF_STEW = (new FoodProperties.Builder()).nutrition(15).saturationMod(0.8F).effect(() -> {
        return new MobEffectInstance(ModEffects.COMFORT.get(), 5400, 0);
    }, 1.0F).build();
    public static final FoodProperties GOLDEN_VEGETABLE_SOUP = (new FoodProperties.Builder()).nutrition(15).saturationMod(0.8F).effect(() -> {
        return new MobEffectInstance(ModEffects.COMFORT.get(), 5400, 0);
    }, 1.0F).build();
    public static final FoodProperties GOLDEN_FISH_STEW = (new FoodProperties.Builder()).nutrition(15).saturationMod(0.8F).effect(() -> {
        return new MobEffectInstance(ModEffects.COMFORT.get(), 5400, 0);
    }, 1.0F).build();
    public static final FoodProperties GOLDEN_CHICKEN_SOUP = (new FoodProperties.Builder()).nutrition(18).saturationMod(0.75F).effect(() -> {
        return new MobEffectInstance(ModEffects.COMFORT.get(), 9000, 0);
    }, 1.0F).build();
    public static final FoodProperties FRIED_GOLDEN_RICE = (new FoodProperties.Builder()).nutrition(18).saturationMod(0.75F).effect(() -> {
        return new MobEffectInstance(ModEffects.COMFORT.get(), 9000, 0);
    }, 1.0F).build();
    public static final FoodProperties GOLDEN_PUMPKIN_SOUP = (new FoodProperties.Builder()).nutrition(18).saturationMod(0.75F).effect(() -> {
        return new MobEffectInstance(ModEffects.COMFORT.get(), 9000, 0);
    }, 1.0F).build();
    public static final FoodProperties GOLDEN_BAKED_COD_STEW = (new FoodProperties.Builder()).nutrition(18).saturationMod(0.75F).effect(() -> {
        return new MobEffectInstance(ModEffects.COMFORT.get(), 9000, 0);
    }, 1.0F).build();
    public static final FoodProperties GOLDEN_NOODLE_SOUP = (new FoodProperties.Builder()).nutrition(18).saturationMod(0.75F).effect(() -> {
        return new MobEffectInstance(ModEffects.COMFORT.get(), 9000, 0);
    }, 1.0F).build();
    public static final FoodProperties GOLDEN_BACON_AND_EGGS = (new FoodProperties.Builder()).nutrition(13).saturationMod(0.6F).effect(() -> {
        return new MobEffectInstance(ModEffects.NOURISHMENT.get(), 1800, 0);
    }, 1.0F).build();
    public static final FoodProperties GOLDEN_RATATOUILLE = (new FoodProperties.Builder()).nutrition(13).saturationMod(0.6F).effect(() -> {
        return new MobEffectInstance(ModEffects.NOURISHMENT.get(), 1800, 0);
    }, 1.0F).build();
    public static final FoodProperties GOLDEN_STEAK_AND_POTATOES = (new FoodProperties.Builder()).nutrition(14).saturationMod(0.8F).effect(() -> {
        return new MobEffectInstance(ModEffects.NOURISHMENT.get(), 5400, 0);
    }, 1.0F).build();
    public static final FoodProperties GOLDEN_PASTA_WITH_MEATBALLS = (new FoodProperties.Builder()).nutrition(15).saturationMod(0.8F).effect(() -> {
        return new MobEffectInstance(ModEffects.NOURISHMENT.get(), 5400, 0);
    }, 1.0F).build();
    public static final FoodProperties GOLDEN_PASTA_WITH_MUTTON_CHOP = (new FoodProperties.Builder()).nutrition(15).saturationMod(0.8F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 5400, 0), 1.0F).build();
    public static final FoodProperties GOLDEN_MUSHROOM_RICE = (new FoodProperties.Builder()).nutrition(15).saturationMod(0.8F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 5400, 0), 1.0F).build();
    public static final FoodProperties ROASTED_GOLDEN_CHOPS = (new FoodProperties.Builder()).nutrition(15).saturationMod(0.75F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 9000, 0), 1.0F).build();
    public static final FoodProperties GOLDEN_VEGETABLE_NOODLES = (new FoodProperties.Builder()).nutrition(15).saturationMod(0.75F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 9000, 0), 1.0F).build();
    public static final FoodProperties GOLDEN_INK_PASTA = (new FoodProperties.Builder()).nutrition(15).saturationMod(0.75F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 9000, 0), 1.0F).build();
    public static final FoodProperties GRILLED_GOLDEN_SALMON = (new FoodProperties.Builder()).nutrition(15).saturationMod(0.75F).effect(() -> {
        return new MobEffectInstance(ModEffects.NOURISHMENT.get(), 5400, 0);
    }, 1.0F).build();
    public static final FoodProperties GOLDEN_ROAST_CHICKEN = (new FoodProperties.Builder()).nutrition(20).saturationMod(0.75F).effect(() -> {
        return new MobEffectInstance(ModEffects.NOURISHMENT.get(), 9000, 0);
    }, 1.0F).build();
    public static final FoodProperties STUFFED_GOLDEN_PUMPKIN = (new FoodProperties.Builder()).nutrition(20).saturationMod(0.75F).effect(() -> {
        return new MobEffectInstance(ModEffects.NOURISHMENT.get(), 9000, 0);
    }, 1.0F).build();
    public static final FoodProperties GOLDEN_GLAZED_HAM = (new FoodProperties.Builder()).nutrition(20).saturationMod(0.75F).effect(() -> {
        return new MobEffectInstance(ModEffects.NOURISHMENT.get(), 9000, 0);
    }, 1.0F).build();
    public static final FoodProperties GOLDEN_SHEPHERDS_PIE = (new FoodProperties.Builder()).nutrition(20).saturationMod(0.75F).effect(() -> {
        return new MobEffectInstance(ModEffects.NOURISHMENT.get(), 9000, 0);
    }, 1.0F).build();
    public static final FoodProperties GOLDEN_DOG_FOOD = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.2F).meat().build();

}
