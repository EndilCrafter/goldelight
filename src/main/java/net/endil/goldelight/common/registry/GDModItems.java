package net.endil.goldelight.common.registry;

import net.endil.goldelight.GolDelight;
import net.endil.goldelight.common.item.GoldenDogFoodItem;
import net.endil.goldelight.common.item.GoldenHoneyBottleItem;
import net.endil.goldelight.common.item.GoldenHorseFeedItem;
import net.endil.goldelight.common.item.GoldenMelonJuiceItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.item.*;

public class GDModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, GolDelight.MOD_ID);

    public static final DeferredRegister<Item> VANILLA_ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, "minecraft");

    //Minecraft
    public static final RegistryObject<Item> GOLDEN_BEEF = ITEMS.register("golden_beef",
            () -> new Item(foodItem(GDModFoods.GOLDEN_BEEF)));
    public static final RegistryObject<Item> GOLDEN_BONE = ITEMS.register("golden_bone",
            () -> new Item(basicItem()));
    public static final RegistryObject<Item> GOLDEN_MEAL = ITEMS.register("golden_meal",
            () -> new BoneMealItem(basicItem()));
    public static final RegistryObject<Item> GOLDEN_BREAD = ITEMS.register("golden_bread",
            () -> new Item(foodItem(GDModFoods.GOLDEN_BREAD)));
    public static final RegistryObject<Item> GOLDEN_CAKE = ITEMS.register("golden_cake",
            () -> new BlockItem(GDModBlocks.GOLDEN_CAKE.get(), basicItem().stacksTo(1)));
    public static final RegistryObject<Item> GOLDEN_CHICKEN = ITEMS.register("golden_chicken",
            () -> new Item(foodItem(GDModFoods.GOLDEN_CHICKEN)));
    public static final RegistryObject<Item> GOLDEN_COCOA_BEANS = ITEMS.register("golden_cocoa_beans",
            () -> new ItemNameBlockItem(GDModBlocks.GOLDEN_COCOA.get(), basicItem()));
    public static final RegistryObject<Item> GOLDEN_COD = ITEMS.register("golden_cod",
            () -> new Item(foodItem(GDModFoods.GOLDEN_COD)));
    public static final RegistryObject<Item> GOLDEN_COOKIE = ITEMS.register("golden_cookie",
            () -> new Item(foodItem(GDModFoods.GOLDEN_COOKIE)));
    public static final RegistryObject<Item> GOLDEN_EGG = ITEMS.register("golden_egg",
            () -> new Item(basicItem().stacksTo(16)));
    public static final RegistryObject<Item> GOLDEN_GLOW_BERRIES = ITEMS.register("golden_glow_berries",
            () -> new ItemNameBlockItem(GDModBlocks.GOLDEN_CAVE_VINES.get(), foodItem(GDModFoods.GOLDEN_GLOW_BERRIES)));
    public static final RegistryObject<Item> GOLDEN_HONEY_BOTTLE = ITEMS.register("golden_honey_bottle",
            () -> new GoldenHoneyBottleItem(new Item.Properties().food(GDModFoods.GOLDEN_HONEY_BOTTLE).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16)));
    public static final RegistryObject<Item> GOLDEN_INK_SAC = ITEMS.register("golden_ink_sac", () -> new Item(basicItem()));
    public static final RegistryObject<Item> GOLDEN_MELON_SEEDS = ITEMS.register("golden_melon_seeds",
            () -> new ItemNameBlockItem(GDModBlocks.GOLDEN_MELON_STEM.get(), basicItem()));
    public static final RegistryObject<Item> GOLDEN_MELON_SLICE = ITEMS.register("golden_melon_slice",
            () -> new Item(foodItem(GDModFoods.GOLDEN_MELON_SLICE)));
    public static final RegistryObject<Item> GOLDEN_MILK_BUCKET = ITEMS.register("golden_milk_bucket",
            () -> new MilkBucketItem(new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final RegistryObject<Item> GOLDEN_MUSHROOM_STEW = ITEMS.register("golden_mushroom_stew",
            () -> new BowlFoodItem(bowlItem(GDModFoods.GOLDEN_MUSHROOM_STEW)));
    public static final RegistryObject<Item> GOLDEN_MUTTON = ITEMS.register("golden_mutton",
            () -> new Item(foodItem(GDModFoods.GOLDEN_MUTTON)));
    public static final RegistryObject<Item> GOLDEN_PORKCHOP = ITEMS.register("golden_porkchop",
            () -> new Item(foodItem(GDModFoods.GOLDEN_PORKCHOP)));
    public static final RegistryObject<Item> GOLDEN_POTATO = ITEMS.register("golden_potato",
            () -> new ItemNameBlockItem(GDModBlocks.GOLDEN_POTATOES.get(), foodItem(GDModFoods.GOLDEN_POTATO)));
    public static final RegistryObject<Item> GOLDEN_PUFFERFISH = ITEMS.register("golden_pufferfish",
            () -> new Item(foodItem(GDModFoods.GOLDEN_PUFFERFISH)));
    public static final RegistryObject<Item> GOLDEN_PUMPKIN_SEEDS = ITEMS.register("golden_pumpkin_seeds",
            () -> new ItemNameBlockItem(GDModBlocks.GOLDEN_PUMPKIN_STEM.get(), basicItem()));
    public static final RegistryObject<Item> GOLDEN_RABBIT = ITEMS.register("golden_rabbit",
            () -> new Item(foodItem(GDModFoods.GOLDEN_RABBIT)));
    public static final RegistryObject<Item> GOLDEN_RABBIT_STEW = ITEMS.register("golden_rabbit_stew",
            () -> new Item(bowlItem(GDModFoods.GOLDEN_RABBIT_STEW)));
    public static final RegistryObject<Item> ROTTEN_GOLDEN_FLESH = ITEMS.register("rotten_golden_flesh",
            () -> new Item(foodItem(GDModFoods.ROTTEN_GOLDEN_FLESH)));
    public static final RegistryObject<Item> GOLDEN_SALMON = ITEMS.register("golden_salmon",
            () -> new Item(foodItem(GDModFoods.GOLDEN_SALMON)));
    public static final RegistryObject<Item> GOLDEN_SUGAR = ITEMS.register("golden_sugar", () -> new Item(basicItem()));
    public static final RegistryObject<Item> GOLDEN_SUGAR_CANE = ITEMS.register("golden_sugar_cane",
            () -> new ItemNameBlockItem(GDModBlocks.GOLDEN_SUGAR_CANE.get(), basicItem()));
    public static final RegistryObject<Item> GOLDEN_TROPICAL_FISH = ITEMS.register("golden_tropical_fish",
            () -> new Item(foodItem(GDModFoods.GOLDEN_TROPICAL_FISH)));
    public static final RegistryObject<Item> GOLDEN_WART = ITEMS.register("golden_wart",
            () -> new ItemNameBlockItem(GDModBlocks.GOLDEN_WART.get(), basicItem()));
    public static final RegistryObject<Item> GOLDEN_WHEAT = ITEMS.register("golden_wheat", () -> new Item(basicItem()));
    public static final RegistryObject<Item> GOLDEN_WHEAT_SEEDS = ITEMS.register("golden_wheat_seeds",
            () -> new ItemNameBlockItem(GDModBlocks.GOLDEN_WHEAT.get(), basicItem()));
    public static final RegistryObject<Item> GOLDEN_SIGN = ITEMS.register("golden_sign",
            () -> new SignItem(basicItem().stacksTo(16), GDModBlocks.GOLDEN_SIGN.get(), GDModBlocks.GOLDEN_WALL_SIGN.get()));
    public static final RegistryObject<Item> GOLDEN_HANGING_SIGN = ITEMS.register("golden_hanging_sign",
            () -> new HangingSignItem(GDModBlocks.GOLDEN_HANGING_SIGN.get(), GDModBlocks.GOLDEN_WALL_HANGING_SIGN.get(), basicItem().stacksTo(16)));
    public static final RegistryObject<Item> GOLDEN_LEATHER = ITEMS.register("golden_leather",
            () -> new Item(basicItem()));
    public static final RegistryObject<Item> GOLDEN_FEATHER = ITEMS.register("golden_feather",
            () -> new Item(basicItem()));
    public static final RegistryObject<Item> GOLDEN_HONEYCOMB = ITEMS.register("golden_honeycomb",
            () -> new HoneycombItem(basicItem()));
    public static final RegistryObject<Item> GOLDEN_COW_SPAWN_EGG = ITEMS.register("golden_cow_spawn_egg",
            () -> new ForgeSpawnEggItem(GDModEntityTypes.GOLDEN_COW, 2552550, 10592673, basicItem()));
    public static final RegistryObject<Item> GOLDEN_CHICKEN_SPAWN_EGG = ITEMS.register("golden_chicken_spawn_egg",
            () -> new ForgeSpawnEggItem(GDModEntityTypes.GOLDEN_CHICKEN, 2552550, 16711680, basicItem()));
    public static final RegistryObject<Item> GOLDEN_BEE_SPAWN_EGG = ITEMS.register("golden_bee_spawn_egg",
            () -> new ForgeSpawnEggItem(GDModEntityTypes.GOLDEN_BEE, 2552550, 4400155, basicItem()));

    //Vanilla Changes + Original
    public static final RegistryObject<Item> GOLDEN_APPLE = VANILLA_ITEMS.register("golden_apple",
            () -> new Item(foodItem(GDModFoods.GOLDEN_APPLE)));
    public static final RegistryObject<Item> GOLDEN_CARROT = VANILLA_ITEMS.register("golden_carrot",
            () -> new ItemNameBlockItem(GDModBlocks.GOLDEN_CARROTS.get(), foodItem(Foods.GOLDEN_CARROT)));
    public static final RegistryObject<Item> MIDAS_KNIFE = ITEMS.register("midas_knife",
            () -> new KnifeItem(Tiers.NETHERITE, 0.5F, -2.0F, basicItem().fireResistant().rarity(Rarity.EPIC)));

    //Farmer's Delight
    public static final RegistryObject<Item> GOLDEN_MUSHROOM_COLONY = ITEMS.register("golden_mushroom_colony",
            () -> new MushroomColonyItem(GDModBlocks.GOLDEN_MUSHROOM_COLONY.get(), basicItem()));
    public static final RegistryObject<Item> GOLDEN_FUNGUS_COLONY = ITEMS.register("golden_fungus_colony",
            () -> new MushroomColonyItem(GDModBlocks.GOLDEN_FUNGUS_COLONY.get(), basicItem()));

    public static final RegistryObject<Item> GOLDEN_COOKING_POT = ITEMS.register("golden_cooking_pot",
            () -> new BlockItem(GDModBlocks.GOLDEN_COOKING_POT.get(), basicItem().stacksTo(1)));
    public static final RegistryObject<Item> GOLDEN_CABBAGE = ITEMS.register("golden_cabbage",
            () -> new Item(foodItem(GDModFoods.GOLDEN_CABBAGE)));
    public static final RegistryObject<Item> GOLDEN_TOMATO = ITEMS.register("golden_tomato",
            () -> new Item(foodItem(GDModFoods.GOLDEN_TOMATO)));
    public static final RegistryObject<Item> GOLDEN_ONION = ITEMS.register("golden_onion",
            () -> new ItemNameBlockItem(GDModBlocks.GOLDEN_ONION_CROP.get(), foodItem(GDModFoods.GOLDEN_ONION)));
    public static final RegistryObject<Item> GOLDEN_RICE_PANICLE = ITEMS.register("golden_rice_panicle", () -> new Item(basicItem()));
    public static final RegistryObject<Item> GOLDEN_RICE = ITEMS.register("golden_rice",
            () -> new RiceItem(GDModBlocks.GOLDEN_RICE_CROP.get(), basicItem()));
    public static final RegistryObject<Item> GOLDEN_CABBAGE_SEEDS = ITEMS.register("golden_cabbage_seeds",
            () -> new ItemNameBlockItem(GDModBlocks.GOLDEN_CABBAGE_CROP.get(), basicItem()));
    public static final RegistryObject<Item> GOLDEN_TOMATO_SEEDS = ITEMS.register("golden_tomato_seeds",
            () -> new ItemNameBlockItem(GDModBlocks.BUDDING_GOLDEN_TOMATO_CROP.get(), basicItem()));
    public static final RegistryObject<Item> ROTTEN_GOLDEN_TOMATO = ITEMS.register("rotten_golden_tomato",
            () -> new RottenTomatoItem(basicItem().stacksTo(16)));
    public static final RegistryObject<Item> FRIED_GOLDEN_EGG = ITEMS.register("fried_golden_egg",
            () -> new Item(foodItem(GDModFoods.FRIED_GOLDEN_EGG)));
    public static final RegistryObject<Item> GOLDEN_MILK_BOTTLE = ITEMS.register("golden_milk_bottle",
            () -> new MilkBottleItem(drinkItem()));
    public static final RegistryObject<Item> GOLDEN_HOT_COCOA = ITEMS.register("golden_hot_cocoa",
            () -> new HotCocoaItem(drinkItem()));
    public static final RegistryObject<Item> GAPPLE_CIDER = ITEMS.register("gapple_cider",
            () -> new DrinkableItem(drinkItem().food(GDModFoods.GAPPLE_CIDER), true, false));
    public static final RegistryObject<Item> GOLDEN_MELON_JUICE = ITEMS.register("golden_melon_juice",
            () -> new GoldenMelonJuiceItem(drinkItem()));
    public static final RegistryObject<Item> GOLDEN_TOMATO_SAUCE = ITEMS.register("golden_tomato_sauce",
            () -> new ConsumableItem(foodItem(GDModFoods.GOLDEN_TOMATO_SAUCE).craftRemainder(Items.BOWL)));
    public static final RegistryObject<Item> GOLDEN_WHEAT_DOUGH = ITEMS.register("golden_wheat_dough",
            () -> new Item(foodItem(GDModFoods.GOLDEN_WHEAT_DOUGH)));
    public static final RegistryObject<Item> RAW_GOLDEN_PASTA = ITEMS.register("raw_golden_pasta",
            () -> new Item(foodItem(GDModFoods.RAW_GOLDEN_PASTA)));
    public static final RegistryObject<Item> GOLDEN_PUMPKIN_SLICE = ITEMS.register("golden_pumpkin_slice",
            () -> new Item(foodItem(GDModFoods.GOLDEN_PUMPKIN_SLICE)));
    public static final RegistryObject<Item> GOLDEN_CABBAGE_LEAF = ITEMS.register("golden_cabbage_leaf",
            () -> new Item(foodItem(GDModFoods.GOLDEN_CABBAGE_LEAF)));
    public static final RegistryObject<Item> MINCED_GOLDEN_BEEF = ITEMS.register("minced_golden_beef",
            () -> new Item(foodItem(GDModFoods.MINCED_GOLDEN_BEEF)));
    public static final RegistryObject<Item> GOLDEN_BEEF_PATTY = ITEMS.register("golden_beef_patty",
            () -> new Item(foodItem(GDModFoods.GOLDEN_BEEF_PATTY)));
    public static final RegistryObject<Item> GOLDEN_CHICKEN_CUTS = ITEMS.register("golden_chicken_cuts",
            () -> new Item(foodItem(GDModFoods.GOLDEN_CHICKEN_CUTS)));
    public static final RegistryObject<Item> COOKED_GOLDEN_CHICKEN_CUTS = ITEMS.register("cooked_golden_chicken_cuts",
            () -> new Item(foodItem(GDModFoods.COOKED_GOLDEN_CHICKEN_CUTS)));
    public static final RegistryObject<Item> GOLDEN_BACON = ITEMS.register("golden_bacon",
            () -> new Item(foodItem(GDModFoods.GOLDEN_BACON)));
    public static final RegistryObject<Item> COOKED_GOLDEN_BACON = ITEMS.register("cooked_golden_bacon",
            () -> new Item(foodItem(GDModFoods.COOKED_GOLDEN_BACON)));
    public static final RegistryObject<Item> GOLDEN_COD_SLICE = ITEMS.register("golden_cod_slice",
            () -> new Item(foodItem(GDModFoods.GOLDEN_COD_SLICE)));
    public static final RegistryObject<Item> COOKED_GOLDEN_COD_SLICE = ITEMS.register("cooked_golden_cod_slice",
            () -> new Item(foodItem(GDModFoods.COOKED_GOLDEN_COD_SLICE)));
    public static final RegistryObject<Item> GOLDEN_SALMON_SLICE = ITEMS.register("golden_salmon_slice",
            () -> new Item(foodItem(GDModFoods.GOLDEN_SALMON_SLICE)));
    public static final RegistryObject<Item> COOKED_GOLDEN_SALMON_SLICE = ITEMS.register("cooked_golden_salmon_slice",
            () -> new Item(foodItem(GDModFoods.COOKED_GOLDEN_SALMON_SLICE)));
    public static final RegistryObject<Item> GOLDEN_MUTTON_CHOPS = ITEMS.register("golden_mutton_chops",
            () -> new Item(foodItem(GDModFoods.GOLDEN_MUTTON_CHOP)));
    public static final RegistryObject<Item> COOKED_GOLDEN_MUTTON_CHOPS = ITEMS.register("cooked_golden_mutton_chops",
            () -> new Item(foodItem(GDModFoods.COOKED_GOLDEN_MUTTON_CHOP)));
    public static final RegistryObject<Item> GOLDEN_HAM = ITEMS.register("golden_ham",
            () -> new Item(foodItem(GDModFoods.GOLDEN_HAM)));
    public static final RegistryObject<Item> SMOKED_GOLDEN_HAM = ITEMS.register("smoked_golden_ham",
            () -> new Item(foodItem(GDModFoods.SMOKED_GOLDEN_HAM)));
    public static final RegistryObject<Item> GOLDEN_PIE_CRUST = ITEMS.register("golden_pie_crust",
            () -> new Item(foodItem(GDModFoods.GOLDEN_PIE_CRUST)));
    public static final RegistryObject<Item> GOLDEN_APPLE_PIE = ITEMS.register("golden_apple_pie",
            () -> new BlockItem(GDModBlocks.GOLDEN_APPLE_PIE.get(), basicItem()));
    public static final RegistryObject<Item> SWEET_GOLDEN_BERRY_CHEESECAKE = ITEMS.register("sweet_golden_berry_cheesecake",
            () -> new BlockItem(GDModBlocks.SWEET_GOLDEN_BERRY_CHEESECAKE.get(), basicItem()));
    public static final RegistryObject<Item> GOLDEN_CHOCOLATE_PIE = ITEMS.register("golden_chocolate_pie",
            () -> new BlockItem(GDModBlocks.GOLDEN_CHOCOLATE_PIE.get(), basicItem()));
    public static final RegistryObject<Item> GOLDEN_CAKE_SLICE = ITEMS.register("golden_cake_slice",
            () -> new Item(foodItem(GDModFoods.GOLDEN_CAKE_SLICE)));
    public static final RegistryObject<Item> GOLDEN_APPLE_PIE_SLICE = ITEMS.register("golden_apple_pie_slice",
            () -> new Item(foodItem(GDModFoods.GOLDEN_PIE_SLICE)));
    public static final RegistryObject<Item> SWEET_GOLDEN_BERRY_CHEESECAKE_SLICE = ITEMS.register("sweet_golden_berry_cheesecake_slice",
            () -> new Item(foodItem(GDModFoods.GOLDEN_PIE_SLICE)));
    public static final RegistryObject<Item> GOLDEN_CHOCOLATE_PIE_SLICE = ITEMS.register("golden_chocolate_pie_slice",
            () -> new Item(foodItem(GDModFoods.GOLDEN_PIE_SLICE)));
    public static final RegistryObject<Item> SWEET_GOLDEN_BERRY_COOKIE = ITEMS.register("sweet_golden_berry_cookie",
            () -> new Item(foodItem(GDModFoods.GOLDEN_COOKIES)));
    public static final RegistryObject<Item> GOLDEN_HONEY_COOKIE = ITEMS.register("golden_honey_cookie",
            () -> new Item(foodItem(GDModFoods.GOLDEN_COOKIES)));
    public static final RegistryObject<Item> GOLDEN_POPSICLE = ITEMS.register("golden_popsicle",
            () -> new PopsicleItem(foodItem(GDModFoods.GOLDEN_POPSICLE)));
    public static final RegistryObject<Item> GOLDEN_GLOW_BERRY_CUSTARD = ITEMS.register("golden_glow_berry_custard",
            () -> new ConsumableItem(foodItem(GDModFoods.GOLDEN_GLOW_BERRY_CUSTARD).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16)));
    public static final RegistryObject<Item> GOLDEN_FRUIT_SALAD = ITEMS.register("golden_fruit_salad",
            () -> new ConsumableItem(bowlItem(GDModFoods.GOLDEN_FRUIT_SALAD), true));
    public static final RegistryObject<Item> MIXED_GOLDEN_SALAD = ITEMS.register("mixed_golden_salad",
            () -> new ConsumableItem(bowlItem(GDModFoods.MIXED_GOLDEN_SALAD), true));
    public static final RegistryObject<Item> GOLDEN_NETHER_SALAD = ITEMS.register("golden_nether_salad",
            () -> new ConsumableItem(bowlItem(GDModFoods.GOLDEN_NETHER_SALAD)));
    public static final RegistryObject<Item> GOLDEN_BARBECUE_STICK = ITEMS.register("golden_barbecue_stick",
            () -> new Item(foodItem(GDModFoods.GOLDEN_BARBECUE_STICK)));
    public static final RegistryObject<Item> GOLDEN_EGG_SANDWICH = ITEMS.register("golden_egg_sandwich",
            () -> new Item(foodItem(GDModFoods.GOLDEN_EGG_SANDWICH)));
    public static final RegistryObject<Item> GOLDEN_CHICKEN_SANDWICH = ITEMS.register("golden_chicken_sandwich",
            () -> new Item(foodItem(GDModFoods.GOLDEN_CHICKEN_SANDWICH)));
    public static final RegistryObject<Item> GOLDEN_HAMBURGER = ITEMS.register("golden_hamburger",
            () -> new Item(foodItem(GDModFoods.GOLDEN_HAMBURGER)));
    public static final RegistryObject<Item> GOLDEN_BACON_SANDWICH = ITEMS.register("golden_bacon_sandwich",
            () -> new Item(foodItem(GDModFoods.GOLDEN_BACON_SANDWICH)));
    public static final RegistryObject<Item> GOLDEN_WRAP = ITEMS.register("golden_wrap",
            () -> new Item(foodItem(GDModFoods.GOLDEN_WRAP)));
    public static final RegistryObject<Item> GUMPLINGS = ITEMS.register("gumplings",
            () -> new Item(foodItem(GDModFoods.GUMPLINGS)));
    public static final RegistryObject<Item> STUFFED_GOLDEN_POTATO = ITEMS.register("stuffed_golden_potato",
            () -> new Item(foodItem(GDModFoods.STUFFED_GOLDEN_POTATO)));
    public static final RegistryObject<Item> GOLDEN_CABBAGE_ROLLS = ITEMS.register("golden_cabbage_rolls",
            () -> new Item(foodItem(GDModFoods.GOLDEN_CABBAGE_ROLLS)));
    public static final RegistryObject<Item> GOLDEN_SALMON_ROLL = ITEMS.register("golden_salmon_roll",
            () -> new Item(foodItem(GDModFoods.GOLDEN_SALMON_ROLL)));
    public static final RegistryObject<Item> GOLDEN_COD_ROLL = ITEMS.register("golden_cod_roll",
            () -> new Item(foodItem(GDModFoods.GOLDEN_COD_ROLL)));
    public static final RegistryObject<Item> GOLDEN_KELP_ROLL = ITEMS.register("golden_kelp_roll",
            () -> new KelpRollItem(foodItem(GDModFoods.GOLDEN_KELP_ROLL)));
    public static final RegistryObject<Item> GOLDEN_KELP_ROLL_SLICE = ITEMS.register("golden_kelp_roll_slice",
            () -> new Item(foodItem(GDModFoods.GOLDEN_KELP_ROLL_SLICE)));
    public static final RegistryObject<Item> COOKED_GOLDEN_RICE = ITEMS.register("cooked_golden_rice",
            () -> new ConsumableItem(foodItem(GDModFoods.COOKED_GOLDEN_RICE), true));
    public static final RegistryObject<Item> GOLDEN_BROTH = ITEMS.register("golden_broth",
            () -> new DrinkableItem(foodItem(GDModFoods.GOLDEN_BROTH), true));
    public static final RegistryObject<Item> GOLDEN_BEEF_STEW = ITEMS.register("golden_beef_stew",
            () -> new ConsumableItem(bowlItem(GDModFoods.GOLDEN_BEEF_STEW), true));
    public static final RegistryObject<Item> GOLDEN_CHICKEN_SOUP = ITEMS.register("golden_chicken_soup",
            () -> new ConsumableItem(bowlItem(GDModFoods.GOLDEN_CHICKEN_SOUP), true));
    public static final RegistryObject<Item> GOLDEN_VEGETABLE_SOUP = ITEMS.register("golden_vegetable_soup",
            () -> new ConsumableItem(bowlItem(GDModFoods.GOLDEN_VEGETABLE_SOUP), true));
    public static final RegistryObject<Item> GOLDEN_FISH_STEW = ITEMS.register("golden_fish_stew",
            () -> new ConsumableItem(bowlItem(GDModFoods.GOLDEN_FISH_STEW), true));
    public static final RegistryObject<Item> FRIED_GOLDEN_RICE = ITEMS.register("fried_golden_rice",
            () -> new ConsumableItem(bowlItem(GDModFoods.FRIED_GOLDEN_RICE), true));
    public static final RegistryObject<Item> GOLDEN_PUMPKIN_SOUP = ITEMS.register("golden_pumpkin_soup",
            () -> new ConsumableItem(bowlItem(GDModFoods.GOLDEN_PUMPKIN_SOUP), true));
    public static final RegistryObject<Item> GOLDEN_BAKED_COD_STEW = ITEMS.register("golden_baked_cod_stew",
            () -> new ConsumableItem(bowlItem(GDModFoods.GOLDEN_BAKED_COD_STEW), true));
    public static final RegistryObject<Item> GOLDEN_NOODLE_SOUP = ITEMS.register("golden_noodle_soup",
            () -> new ConsumableItem(bowlItem(GDModFoods.GOLDEN_NOODLE_SOUP), true));
    public static final RegistryObject<Item> GOLDEN_BACON_AND_EGGS = ITEMS.register("golden_bacon_and_eggs",
            () -> new ConsumableItem(bowlItem(GDModFoods.GOLDEN_BACON_AND_EGGS), true));
    public static final RegistryObject<Item> GOLDEN_PASTA_WITH_MEATBALLS = ITEMS.register("golden_pasta_with_meatballs",
            () -> new ConsumableItem(bowlItem(GDModFoods.GOLDEN_PASTA_WITH_MEATBALLS), true));
    public static final RegistryObject<Item> GOLDEN_PASTA_WITH_MUTTON_CHOP = ITEMS.register("golden_pasta_with_mutton_chop",
            () -> new ConsumableItem(bowlItem(GDModFoods.GOLDEN_PASTA_WITH_MUTTON_CHOP), true));
    public static final RegistryObject<Item> GOLDEN_MUSHROOM_RICE = ITEMS.register("golden_mushroom_rice",
            () -> new ConsumableItem(bowlItem(GDModFoods.GOLDEN_MUSHROOM_RICE), true));
    public static final RegistryObject<Item> ROASTED_GOLDEN_CHOPS = ITEMS.register("roasted_golden_chops",
            () -> new ConsumableItem(bowlItem(GDModFoods.ROASTED_GOLDEN_CHOPS), true));
    public static final RegistryObject<Item> GOLDEN_VEGETABLE_NOODLES = ITEMS.register("golden_vegetable_noodles",
            () -> new ConsumableItem(bowlItem(GDModFoods.GOLDEN_VEGETABLE_NOODLES), true));
    public static final RegistryObject<Item> GOLDEN_STEAK_AND_POTATOES = ITEMS.register("golden_steak_and_potatoes",
            () -> new ConsumableItem(bowlItem(GDModFoods.GOLDEN_STEAK_AND_POTATOES), true));
    public static final RegistryObject<Item> GOLDEN_RATATOUILLE = ITEMS.register("golden_ratatouille",
            () -> new ConsumableItem(bowlItem(GDModFoods.GOLDEN_RATATOUILLE), true));
    public static final RegistryObject<Item> GOLDEN_INK_PASTA = ITEMS.register("golden_ink_pasta",
            () -> new ConsumableItem(bowlItem(GDModFoods.GOLDEN_INK_PASTA), true));
    public static final RegistryObject<Item> GRILLED_GOLDEN_SALMON = ITEMS.register("grilled_golden_salmon",
            () -> new ConsumableItem(bowlItem(GDModFoods.GRILLED_GOLDEN_SALMON), true));
    public static final RegistryObject<Item> GOLDEN_ROAST_CHICKEN_BLOCK = ITEMS.register("golden_roast_chicken_block",
            () -> new BlockItem(GDModBlocks.GOLDEN_ROAST_CHICKEN_BLOCK.get(), basicItem().stacksTo(1)));
    public static final RegistryObject<Item> GOLDEN_ROAST_CHICKEN = ITEMS.register("golden_roast_chicken",
            () -> new ConsumableItem(bowlItem(GDModFoods.GOLDEN_ROAST_CHICKEN), true));
    public static final RegistryObject<Item> STUFFED_GOLDEN_PUMPKIN_BLOCK = ITEMS.register("stuffed_golden_pumpkin_block",
            () -> new BlockItem(GDModBlocks.STUFFED_GOLDEN_PUMPKIN_BLOCK.get(), basicItem().stacksTo(1)));
    public static final RegistryObject<Item> STUFFED_GOLDEN_PUMPKIN = ITEMS.register("stuffed_golden_pumpkin",
            () -> new ConsumableItem(bowlItem(GDModFoods.STUFFED_GOLDEN_PUMPKIN), true));
    public static final RegistryObject<Item> GOLDEN_GLAZED_HAM_BLOCK = ITEMS.register("golden_glazed_ham_block",
            () -> new BlockItem(GDModBlocks.GOLDEN_GLAZED_HAM_BLOCK.get(), basicItem().stacksTo(1)));
    public static final RegistryObject<Item> GOLDEN_GLAZED_HAM = ITEMS.register("golden_glazed_ham",
            () -> new ConsumableItem(bowlItem(GDModFoods.GOLDEN_GLAZED_HAM), true));
    public static final RegistryObject<Item> GOLDEN_SHEPHERDS_PIE_BLOCK = ITEMS.register("golden_shepherds_pie_block",
            () -> new BlockItem(GDModBlocks.GOLDEN_SHEPHERDS_PIE_BLOCK.get(), basicItem().stacksTo(1)));
    public static final RegistryObject<Item> GOLDEN_SHEPHERDS_PIE = ITEMS.register("golden_shepherds_pie",
            () -> new ConsumableItem(bowlItem(GDModFoods.GOLDEN_SHEPHERDS_PIE), true));
    public static final RegistryObject<Item> GOLDEN_RICE_ROLL_MEDLEY_BLOCK = ITEMS.register("golden_rice_roll_medley_block",
            () -> new BlockItem(GDModBlocks.GOLDEN_RICE_ROLL_MEDLEY_BLOCK.get(), basicItem().stacksTo(1)));
    public static final RegistryObject<Item> GOLDEN_DOG_FOOD = ITEMS.register("golden_dog_food",
            () -> new GoldenDogFoodItem(bowlItem(GDModFoods.GOLDEN_DOG_FOOD)));
    public static final RegistryObject<Item> GOLDEN_HORSE_FEED = ITEMS.register("golden_horse_feed",
            () -> new GoldenHorseFeedItem(basicItem().stacksTo(16)));

    private static Item.Properties basicItem() {
        return new Item.Properties();
    }

    private static Item.Properties foodItem(FoodProperties food) {
        return new Item.Properties().food(food);
    }

    private static Item.Properties bowlItem(FoodProperties food) {
        return foodItem(food).craftRemainder(Items.BOWL).stacksTo(16);
    }

    private static Item.Properties drinkItem() {
        return new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16);
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
        VANILLA_ITEMS.register(eventBus);
    }
}
