package net.endil.goldelight.common.registry;

import net.endil.goldelight.GolDelight;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class GDModTags {
    public static class Blocks {
        public static final TagKey<Block> GOLDEN_CROPS = tag("golden_crops");
        public static final TagKey<Block> GOLDEN_MUSHROOM_GROW_BLOCK = tag("golden_mushroom_grow_block");
        public static final TagKey<Block> GOLDEN_COMPOST_ACTIVATORS = tag("golden_compost_activators");
        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(GolDelight.MOD_ID, name));
        }
    }
    public static class Items {
        //Original
        public static final TagKey<Item> MIDAS_TOUCHABLE = tag("midas_touchable");

        //Minecraft
        public static final TagKey<Item> GOLDEN_FISHES = tag("golden_fishes");

        //Forge
        public static final TagKey<Item> GOLDEN_CROPS = tag("golden_crops");
        public static final TagKey<Item> GOLDEN_CROPS_BEETROOT = tag("golden_crops/beetroot");
        public static final TagKey<Item> GOLDEN_CROPS_CARROT = tag("golden_crops/carrot");
        public static final TagKey<Item> GOLDEN_CROPS_WART = tag("golden_crops/wart");
        public static final TagKey<Item> GOLDEN_CROPS_POTATO = tag("golden_crops/potato");
        public static final TagKey<Item> GOLDEN_CROPS_WHEAT = tag("golden_crops/wheat");
        public static final TagKey<Item> GOLDEN_EGGS = tag("golden_eggs");
        public static final TagKey<Item> GOLDEN_MUSHROOMS = tag("golden_mushrooms");
        public static final TagKey<Item> GOLDEN_SEEDS = tag("golden_seeds");
        public static final TagKey<Item> GOLDEN_SEEDS_BEETROOT = tag("golden_seeds/beetroot");
        public static final TagKey<Item> GOLDEN_SEEDS_MELON = tag("golden_seeds/melon");
        public static final TagKey<Item> GOLDEN_SEEDS_PUMPKIN = tag("golden_seeds/pumpkin");
        public static final TagKey<Item> GOLDEN_SEEDS_WHEAT = tag("golden_seeds/wheat");

        //Farmer's Delight
        public static final TagKey<Item> GOLDEN_WOLF_PREY = tag("golden_wolf_prey");
        public static final TagKey<Item> GOLDEN_CABBAGE_ROLL_INGREDIENTS = tag("golden_cabbage_rolls_ingredients");

        //Forge by Farmer's Delight
        public static final TagKey<Item> GOLDEN_BERRIES = tag("golden_berries");
        public static final TagKey<Item> GOLDEN_BREAD = tag("golden_bread");
        public static final TagKey<Item> GOLDEN_BREAD_WHEAT = tag("golden_bread/wheat");
        public static final TagKey<Item> COOKED_GOLDEN_BACON = tag("cooked_golden_bacon");
        public static final TagKey<Item> COOKED_GOLDEN_BEEF = tag("cooked_golden_beef");
        public static final TagKey<Item> COOKED_GOLDEN_CHICKEN = tag("cooked_golden_chicken");
        public static final TagKey<Item> COOKED_GOLDEN_PORK = tag("cooked_golden_pork");
        public static final TagKey<Item> COOKED_GOLDEN_MUTTON = tag("cooked_golden_mutton");
        public static final TagKey<Item> COOKED_GOLDEN_EGGS = tag("cooked_golden_eggs");
        public static final TagKey<Item> COOKED_GOLDEN_FISHES = tag("cooked_golden_fishes");
        public static final TagKey<Item> COOKED_GOLDEN_FISHES_COD = tag("cooked_golden_fishes/cod");
        public static final TagKey<Item> COOKED_GOLDEN_FISHES_SALMON = tag("cooked_golden_fishes/salmon");
        public static final TagKey<Item> GOLDEN_CROPS_CABBAGE = tag("golden_crops/cabbage");
        public static final TagKey<Item> GOLDEN_CROPS_ONION = tag("golden_crops/onion");
        public static final TagKey<Item> GOLDEN_CROPS_RICE = tag("golden_crops/rice");
        public static final TagKey<Item> GOLDEN_CROPS_TOMATO = tag("golden_crops/tomato");
        public static final TagKey<Item> GOLDEN_DOUGH = tag("golden_dough");
        public static final TagKey<Item> GOLDEN_DOUGH_WHEAT = tag("golden_dough/wheat");
        public static final TagKey<Item> GOLDEN_GRAIN = tag("golden_grain");
        public static final TagKey<Item> GOLDEN_GRAIN_WHEAT = tag("golden_grain/wheat");
        public static final TagKey<Item> GOLDEN_GRAIN_RICE = tag("golden_grain/rice");
        public static final TagKey<Item> GOLDEN_MILK = tag("golden_milk");
        public static final TagKey<Item> GOLDEN_MILK_BUCKET = tag("golden_milk/milk");
        public static final TagKey<Item> GOLDEN_MILK_BOTTLE = tag("golden_milk/milk_bottle");
        public static final TagKey<Item> GOLDEN_PASTA = tag("golden_pasta");
        public static final TagKey<Item> GOLDEN_PASTA_RAW_PASTA = tag("golden_pasta/raw_pasta");
        public static final TagKey<Item> RAW_GOLDEN_BACON = tag("raw_golden_bacon");
        public static final TagKey<Item> RAW_GOLDEN_BEEF = tag("raw_golden_beef");
        public static final TagKey<Item> RAW_GOLDEN_CHICKEN = tag("raw_golden_chicken");
        public static final TagKey<Item> RAW_GOLDEN_PORK = tag("raw_golden_pork");
        public static final TagKey<Item> RAW_GOLDEN_MUTTON = tag("raw_golden_mutton");
        public static final TagKey<Item> RAW_GOLDEN_FISHES = tag("raw_golden_fishes");
        public static final TagKey<Item> RAW_GOLDEN_FISHES_COD = tag("raw_golden_fishes/cod");
        public static final TagKey<Item> RAW_GOLDEN_FISHES_SALMON = tag("raw_golden_fishes/salmon");
        public static final TagKey<Item> RAW_GOLDEN_FISHES_TROPICAL = tag("raw_golden_fishes/tropical_fish");
        public static final TagKey<Item> GOLDEN_SALAD_INGREDIENTS = tag("golden_salad_ingredients");
        public static final TagKey<Item> GOLDEN_SALAD_INGREDIENTS_CABBAGE = tag("golden_salad_ingredients/cabbage");
        public static final TagKey<Item> GOLDEN_SEEDS_CABBAGE = tag("golden_seeds/cabbage");
        public static final TagKey<Item> GOLDEN_SEEDS_RICE = tag("golden_seeds/rice");
        public static final TagKey<Item> GOLDEN_SEEDS_TOMATO = tag("golden_seeds/tomato");
        public static final TagKey<Item> GOLDEN_VEGETABLES = tag("golden_vegetables");
        public static final TagKey<Item> GOLDEN_VEGETABLES_BEETROOT = tag("golden_vegetables/beetroot");
        public static final TagKey<Item> GOLDEN_VEGETABLES_CARROT = tag("golden_vegetables/carrot");
        public static final TagKey<Item> GOLDEN_VEGETABLES_ONION = tag("golden_vegetables/onion");
        public static final TagKey<Item> GOLDEN_VEGETABLES_POTATO = tag("golden_vegetables/potato");
        public static final TagKey<Item> GOLDEN_VEGETABLES_TOMATO = tag("golden_vegetables/tomato");
        private static TagKey<Item> tag(String name) {
        return ItemTags.create(new ResourceLocation(GolDelight.MOD_ID, name));
    }
    }
}
