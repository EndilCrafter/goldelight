package net.endil.goldelight.common.registry;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.registry.ModEffects;

public class GDModFoods {
    //Minecraft
    public static final FoodProperties GOLDEN_BEEF = rawMeat(4).build();
    public static final FoodProperties GOLDEN_BREAD = new FoodProperties.Builder()
            .nutrition(8).saturationMod(0.6f).build();
    public static final FoodProperties GOLDEN_CHICKEN = rawMeat(3).build();
    public static final FoodProperties GOLDEN_COD = rawFish(3).build();
    public static final FoodProperties GOLDEN_COOKIE = new FoodProperties.Builder()
            .nutrition(3).saturationMod(0.1f).fast()
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 90), 1.0F).build();
    public static final FoodProperties GOLDEN_GLOW_BERRIES = new FoodProperties.Builder()
            .nutrition(3).saturationMod(0.1f).fast()
            .effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 600), 1.0F).build();
    public static final FoodProperties GOLDEN_HONEY_BOTTLE = new FoodProperties.Builder()
            .nutrition(8).saturationMod(0.1f)
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 1800), 1.0F).build();
    public static final FoodProperties GOLDEN_MELON_SLICE = new FoodProperties.Builder()
            .nutrition(3).saturationMod(0.3f)
            .effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 200), 1.0F).build();
    public static final FoodProperties GOLDEN_MUSHROOM_STEW = new FoodProperties.Builder()
            .nutrition(8).saturationMod(0.6f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 1000), 1.0F).build();
    public static final FoodProperties GOLDEN_MUTTON = rawMeat(3).build();
    public static final FoodProperties GOLDEN_PORKCHOP = rawMeat(4).build();
    public static final FoodProperties GOLDEN_POTATO = new FoodProperties.Builder()
            .nutrition(2).saturationMod(0.3f).build();
    public static final FoodProperties GOLDEN_PUFFERFISH = rawFish(2)
            .effect(() -> new MobEffectInstance(MobEffects.DARKNESS, 600), 0.5F)
            .effect(() -> new MobEffectInstance(MobEffects.UNLUCK, 600), 0.5F).build();
    public static final FoodProperties GOLDEN_RABBIT = rawMeat(5).build();
    public static final FoodProperties GOLDEN_RABBIT_STEW = new FoodProperties.Builder()
            .nutrition(12).saturationMod(0.6f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 480), 1.0F).build();
    public static final FoodProperties ROTTEN_GOLDEN_FLESH = new FoodProperties.Builder()
            .nutrition(6).saturationMod(0.1f).meat()
            .effect(() -> new MobEffectInstance(MobEffects.HUNGER, 300, 2), 0.4F)
            .effect(() -> new MobEffectInstance(MobEffects.WEAKNESS, 300, 1), 0.4F)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 600, 1), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 600, 1), 1.0F).build();
    public static final FoodProperties GOLDEN_SALMON = rawFish(3).build();
    public static final FoodProperties GOLDEN_TROPICAL_FISH = rawFish(2)
            .effect(() -> new MobEffectInstance(MobEffects.JUMP, 1200), 1.0F).build();
    public static final FoodProperties GOLDEN_CABBAGE = new FoodProperties.Builder()
            .nutrition(4).saturationMod(0.5f).build();
    public static final FoodProperties GOLDEN_TOMATO = new FoodProperties.Builder()
            .nutrition(3).saturationMod(0.5f).build();
    public static final FoodProperties GOLDEN_ONION = new FoodProperties.Builder()
            .nutrition(4).saturationMod(0.5f).build();
    public static final FoodProperties GAPPLE_CIDER = (new FoodProperties.Builder()).alwaysEat()
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 1700, 1), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 750), 1.0F).build();
    public static final FoodProperties GOLDEN_HOT_COCOA = new FoodProperties.Builder().alwaysEat()
            .effect(() -> new MobEffectInstance(GDModEffects.MILDNESS.get(), 3600, 0), 1.0F).build();
    public static final FoodProperties GOLDEN_MELON_JUICE = new FoodProperties.Builder().alwaysEat()
            .effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 1000, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 750, 0), 1.0F)
            .build();
    public static final FoodProperties FRIED_GOLDEN_EGG = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.4F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 400), 1.0F).build();
    public static final FoodProperties GOLDEN_TOMATO_SAUCE = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.6F).build();
    public static final FoodProperties GOLDEN_WHEAT_DOUGH = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.3F)
            .effect(() -> new MobEffectInstance(MobEffects.HUNGER, 300, 0), 0.15F).build();
    public static final FoodProperties RAW_GOLDEN_PASTA = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.3F)
            .effect(() -> new MobEffectInstance(MobEffects.HUNGER, 300, 0), 0.15F).build();
    public static final FoodProperties GOLDEN_PIE_CRUST = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.2F).build();
    public static final FoodProperties GOLDEN_PUMPKIN_SLICE = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.3F)
            .effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 900), 1.0F).build();
    public static final FoodProperties GOLDEN_CABBAGE_LEAF = new FoodProperties.Builder()
            .nutrition(2).saturationMod(0.4f).fast().build();
    public static final FoodProperties MINCED_GOLDEN_BEEF = rawCut(2).build();
    public static final FoodProperties GOLDEN_BEEF_PATTY = new FoodProperties.Builder()
            .nutrition(5).saturationMod(0.8f).meat().fast().build();
    public static final FoodProperties GOLDEN_CHICKEN_CUTS = rawCut(2)
            .effect(() -> new MobEffectInstance(MobEffects.HUNGER, 300, 0), 0.15F).build();
    public static final FoodProperties COOKED_GOLDEN_CHICKEN_CUTS = (new FoodProperties.Builder())
            .nutrition(4).saturationMod(0.6F).meat().fast()
            .effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, 600), 1.0F).build();
    public static final FoodProperties GOLDEN_BACON = rawCut(2).build();
    public static final FoodProperties COOKED_GOLDEN_BACON = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.8F).meat().fast().build();
    public static final FoodProperties GOLDEN_COD_SLICE = rawSlice(2).build();
    public static final FoodProperties COOKED_GOLDEN_COD_SLICE = (new FoodProperties.Builder())
            .nutrition(4).saturationMod(0.5F).fast()
            .effect(() -> new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 600), 1.0F).build();
    public static final FoodProperties GOLDEN_SALMON_SLICE = rawSlice(2).build();
    public static final FoodProperties COOKED_GOLDEN_SALMON_SLICE = (new FoodProperties.Builder())
            .nutrition(4).saturationMod(0.8F).fast()
            .effect(() -> new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 1050), 1.0F).build();
    public static final FoodProperties GOLDEN_MUTTON_CHOP = rawCut(2).build();
    public static final FoodProperties COOKED_GOLDEN_MUTTON_CHOP = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.8F).meat().fast().build();
    public static final FoodProperties GOLDEN_HAM = rawMeat(9).build();
    public static final FoodProperties SMOKED_GOLDEN_HAM = (new FoodProperties.Builder()).nutrition(18).saturationMod(0.8F).meat().build();
    public static final FoodProperties GOLDEN_POPSICLE = (new FoodProperties.Builder())
            .nutrition(5).saturationMod(0.2F).fast().alwaysEat()
            .effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 1000), 1.0F).build();
    public static final FoodProperties SWEET_GOLDEN_BERRY_COOKIE = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.1F).fast()
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 100), 1.0F).build();
    public static final FoodProperties GOLDEN_HONEY_COOKIE = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.1F).fast()
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 420), 1.0F).build();
    public static final FoodProperties GOLDEN_CAKE_SLICE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.1F).fast()
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 1, false, false), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 125, 0, false, false), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 375, 0, false, false), 1.0F)
            .build();
    public static final FoodProperties GOLDEN_APPLE_PIE_SLICE = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.3F).fast()
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 600, 1, false, false), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 470, 0, false, false), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 1400, 0, false, false), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 940, 0, false, false), 1.0F)
            .build();
    public static final FoodProperties SWEET_GOLDEN_CHEESECAKE_SLICE = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.3F).fast()
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1910, 1, false, false), 1.0F).build();
    public static final FoodProperties GOLDEN_CHOCOLATE_PIE_SLICE = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.3F).fast()
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1260, 1, false, false), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 660, 0, false, false), 1.0F).build();

    public static final FoodProperties GOLDEN_FRUIT_SALAD = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.6F)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 350, 1), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 2625, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 750, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 500, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 500, 0), 1.0F).build();
    public static final FoodProperties GOLDEN_GLOW_BERRY_CUSTARD = (new FoodProperties.Builder()).nutrition(10).saturationMod(0.6F).alwaysEat()
            .effect(() -> new MobEffectInstance(MobEffects.GLOWING, 50, 0), 0.5F)
            .effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 750, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 500, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 750, 0), 1.0F)
            .build();
    public static final FoodProperties MIXED_GOLDEN_SALAD = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.8F)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100, 1), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 4500, 0), 1.0F)
            .build();
    public static final FoodProperties GOLDEN_NETHER_SALAD = (new FoodProperties.Builder()).nutrition(7).saturationMod(0.4F)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 120, 0), 0.15F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1500, 0), 1.0F)
            .build();
    public static final FoodProperties GOLDEN_BARBECUE_STICK = (new FoodProperties.Builder()).nutrition(10).saturationMod(1.1F)
            .effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, 210, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 375, 0), 1.0F).build();
    public static final FoodProperties GOLDEN_EGG_SANDWICH = (new FoodProperties.Builder()).nutrition(10).saturationMod(0.8F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1750, 0), 1.0F).build();
    public static final FoodProperties GOLDEN_CHICKEN_SANDWICH = (new FoodProperties.Builder()).nutrition(12).saturationMod(0.9F)
            .effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, 2625, 0), 1.0F).build();
    public static final FoodProperties GOLDEN_HAMBURGER = (new FoodProperties.Builder()).nutrition(14).saturationMod(1.1F).build();
    public static final FoodProperties GOLDEN_BACON_SANDWICH = (new FoodProperties.Builder()).nutrition(12).saturationMod(1.0F).build();
    public static final FoodProperties GOLDEN_WRAP = (new FoodProperties.Builder()).nutrition(12).saturationMod(1.0F).build();
    public static final FoodProperties GUMPLINGS = (new FoodProperties.Builder()).nutrition(10).saturationMod(1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, 330, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 110, 0), 1.0F)
            .build();
    public static final FoodProperties STUFFED_GOLDEN_POTATO = (new FoodProperties.Builder()).nutrition(12).saturationMod(0.7F).build();
    public static final FoodProperties GOLDEN_CABBAGE_ROLLS = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.6F)
            .effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, 125, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.JUMP, 125, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 220, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 375, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 40, 0), 1.0F)
            .build();
    public static final FoodProperties GOLDEN_SALMON_ROLL = (new FoodProperties.Builder()).nutrition(9).saturationMod(0.6F)
            .effect(() -> new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 2625, 0), 1.0F).build();
    public static final FoodProperties GOLDEN_COD_ROLL = (new FoodProperties.Builder()).nutrition(9).saturationMod(0.6F)
            .effect(() -> new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 1500, 0), 1.0F).build();
    public static final FoodProperties GOLDEN_KELP_ROLL = (new FoodProperties.Builder()).nutrition(14).saturationMod(0.6F)
            .effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 2250, 0), 1.0F).build();
    public static final FoodProperties GOLDEN_KELP_ROLL_SLICE = (new FoodProperties.Builder()).nutrition(7).saturationMod(0.5F).fast()
            .effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 750, 0), 1.0F).build();
    public static final FoodProperties COOKED_GOLDEN_RICE = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.4F)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 1125, 0), 1.0F).build();
    public static final FoodProperties GOLDEN_BROTH = (new FoodProperties.Builder()).nutrition(10).saturationMod(0.7F)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 1800, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 750, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 375, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 250, 0), 1.0F)
            .build();
    public static final FoodProperties GOLDEN_BEEF_STEW = (new FoodProperties.Builder()).nutrition(15).saturationMod(0.8F)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 5400, 0), 1.0F).build();
    public static final FoodProperties GOLDEN_VEGETABLE_SOUP = (new FoodProperties.Builder()).nutrition(15).saturationMod(0.9F)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 5400, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 4500, 0), 1.0F)
            .build();
    public static final FoodProperties GOLDEN_FISH_STEW = (new FoodProperties.Builder()).nutrition(15).saturationMod(1.1F)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 5400, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 1310, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.JUMP, 750, 0), 1.0F)
            .build();
    public static final FoodProperties GOLDEN_CHICKEN_SOUP = (new FoodProperties.Builder()).nutrition(18).saturationMod(0.875F)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 9000, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, 1500, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1125, 0), 1.0F).build();
    public static final FoodProperties FRIED_GOLDEN_RICE = (new FoodProperties.Builder()).nutrition(18).saturationMod(0.85F)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 11250, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 500, 0), 1.0F)
            .build();
    public static final FoodProperties GOLDEN_PUMPKIN_SOUP = (new FoodProperties.Builder()).nutrition(18).saturationMod(0.85F)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 9000, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 1125, 0), 1.0F).build();
    public static final FoodProperties GOLDEN_BAKED_COD_STEW = (new FoodProperties.Builder()).nutrition(18).saturationMod(0.85F)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 9000, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 500, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 1500, 0), 1.0F)
            .build();
    public static final FoodProperties GOLDEN_NOODLE_SOUP = (new FoodProperties.Builder()).nutrition(18).saturationMod(0.75F)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 9000, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 875, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 1310, 0), 1.0F).build();
    public static final FoodProperties GOLDEN_BACON_AND_EGGS = (new FoodProperties.Builder()).nutrition(13).saturationMod(0.6F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 1800, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1000, 0), 1.0F).build();
    public static final FoodProperties GOLDEN_RATATOUILLE = (new FoodProperties.Builder()).nutrition(13).saturationMod(0.825F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 1800, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 5625, 0), 1.0F).build();
    public static final FoodProperties GOLDEN_STEAK_AND_POTATOES = (new FoodProperties.Builder()).nutrition(14).saturationMod(0.9F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 6750, 0), 1.0F).build();
    public static final FoodProperties GOLDEN_PASTA_WITH_MEATBALLS = (new FoodProperties.Builder()).nutrition(15).saturationMod(1.0F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 5400, 0), 1.0F).build();
    public static final FoodProperties GOLDEN_PASTA_WITH_MUTTON_CHOP = (new FoodProperties.Builder()).nutrition(15).saturationMod(1.0F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 5400, 0), 1.0F).build();
    public static final FoodProperties GOLDEN_MUSHROOM_RICE = (new FoodProperties.Builder()).nutrition(15).saturationMod(0.8F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 5400, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 1000, 0), 1.0F).build();
    public static final FoodProperties ROASTED_GOLDEN_CHOPS = (new FoodProperties.Builder()).nutrition(15).saturationMod(0.85F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 11250, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 4500, 0), 1.0F).build();
    public static final FoodProperties GOLDEN_VEGETABLE_NOODLES = (new FoodProperties.Builder()).nutrition(15).saturationMod(0.875F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 9000, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 875, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 2000, 0), 1.0F)
            .build();
    public static final FoodProperties GOLDEN_INK_PASTA = (new FoodProperties.Builder()).nutrition(15).saturationMod(0.85F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 9000, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 3610, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.JUMP, 1310, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.INVISIBILITY, 1310, 0), 1.0F)
            .build();
    public static final FoodProperties GRILLED_GOLDEN_SALMON = (new FoodProperties.Builder()).nutrition(15).saturationMod(0.95F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 5400, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 500, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 2625, 0), 1.0F)
            .build();
    public static final FoodProperties GOLDEN_ROAST_CHICKEN = (new FoodProperties.Builder()).nutrition(20).saturationMod(0.85F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 9000, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 875, 1), 1.0F).build();
    public static final FoodProperties STUFFED_GOLDEN_PUMPKIN = (new FoodProperties.Builder()).nutrition(20).saturationMod(0.875F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 11250, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1125, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 500, 1), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 250, 1), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 4875, 0), 1.0F).build();
    public static final FoodProperties GOLDEN_GLAZED_HAM = (new FoodProperties.Builder()).nutrition(20).saturationMod(0.75F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 13500, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2000, 1), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 2250, 1), 1.0F)
            .build();
    public static final FoodProperties GOLDEN_SHEPHERDS_PIE = (new FoodProperties.Builder()).nutrition(20).saturationMod(0.95F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 9000, 0), 1.0F)
            .effect(() -> new MobEffectInstance(GDModEffects.IMMUNITY.get(), 9000, 0), 1.0F).build();
    public static final FoodProperties GOLDEN_DOG_FOOD = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.2F).meat().build();
    public static final FoodProperties GOLDEN_APPLE = (new FoodProperties.Builder()).nutrition(4).saturationMod(1.2F)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 200, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 600, 0), 1.0F).alwaysEat().build();

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
}
