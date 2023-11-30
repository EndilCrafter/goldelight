package net.endil.goldelight.common.registry;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class GDCompatTags {

    //Serene Seasons
    public static final String SERENE_SEASONS = "sereneseasons";
    public static final TagKey<Block> SERENE_SEASONS_AUTUMN_CROPS_BLOCK = externalBlockTag(SERENE_SEASONS, "autumn_crops");
    public static final TagKey<Block> SERENE_SEASONS_SPRING_CROPS_BLOCK = externalBlockTag(SERENE_SEASONS, "spring_crops");
    public static final TagKey<Block> SERENE_SEASONS_SUMMER_CROPS_BLOCK = externalBlockTag(SERENE_SEASONS, "summer_crops");
    public static final TagKey<Block> SERENE_SEASONS_WINTER_CROPS_BLOCK = externalBlockTag(SERENE_SEASONS, "winter_crops");
    public static final TagKey<Block> SERENE_SEASONS_UNBREAKABLE_FERTILE_CROPS = externalBlockTag(SERENE_SEASONS, "unbreakable_infertile_crops");
    public static final TagKey<Item> SERENE_SEASONS_AUTUMN_CROPS = externalItemTag(SERENE_SEASONS, "autumn_crops");
    public static final TagKey<Item> SERENE_SEASONS_SPRING_CROPS = externalItemTag(SERENE_SEASONS, "spring_crops");
    public static final TagKey<Item> SERENE_SEASONS_SUMMER_CROPS = externalItemTag(SERENE_SEASONS, "summer_crops");
    public static final TagKey<Item> SERENE_SEASONS_WINTER_CROPS = externalItemTag(SERENE_SEASONS, "winter_crops");


    //Diet
    public static final String DIET = "diet";
    public static final TagKey<Item> DIET_FRUITS = externalItemTag(DIET, "fruits");
    public static final TagKey<Item> DIET_GRAINS = externalItemTag(DIET, "grains");
    public static final TagKey<Item> DIET_INGREDIENTS = externalItemTag(DIET, "ingredients");
    public static final TagKey<Item> DIET_PROTEINS = externalItemTag(DIET, "proteins");
    public static final TagKey<Item> DIET_SPECIAL_FOOD = externalItemTag(DIET, "special_food");
    public static final TagKey<Item> DIET_SUGARS = externalItemTag(DIET, "sugars");
    public static final TagKey<Item> DIET_VEGETABLES = externalItemTag(DIET, "vegetables");



    private static TagKey<Item> externalItemTag(String modId, String path) {
        return ItemTags.create(new ResourceLocation(modId, path));
    }

    private static TagKey<Block> externalBlockTag(String modId, String path) {
        return BlockTags.create(new ResourceLocation(modId, path));
    }
}
