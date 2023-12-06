package net.endil.goldelight.client.recipebook;

import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableList;
import net.endil.goldelight.GolDelight;
import net.endil.goldelight.common.recipe.GoldenCookingPotRecipe;
import net.endil.goldelight.common.registry.GDModItems;
import net.endil.goldelight.common.registry.GDModRecipeTypes;
import net.minecraft.client.RecipeBookCategories;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.client.event.RegisterRecipeBookCategoriesEvent;

import java.util.function.Supplier;

public class GDModRecipeCategories {
    public static final Supplier<RecipeBookCategories> GOLDEN_COOKING_SEARCH = Suppliers.memoize(() -> RecipeBookCategories.create("GOLDEN_COOKING_SEARCH", new ItemStack(Items.COMPASS)));
    public static final Supplier<RecipeBookCategories> GOLDEN_COOKING_MEALS = Suppliers.memoize(() -> RecipeBookCategories.create("GOLDEN_COOKING_MEALS", new ItemStack(GDModItems.GOLDEN_VEGETABLE_NOODLES.get())));
    public static final Supplier<RecipeBookCategories> GOLDEN_COOKING_DRINKS = Suppliers.memoize(() -> RecipeBookCategories.create("GOLDEN_COOKING_DRINKS", new ItemStack(GDModItems.GAPPLE_CIDER.get())));
    public static final Supplier<RecipeBookCategories> GOLDEN_COOKING_MISC = Suppliers.memoize(() -> RecipeBookCategories.create("GOLDEN_COOKING_MISC", new ItemStack(GDModItems.GUMPLINGS.get()), new ItemStack(GDModItems.GOLDEN_TOMATO_SAUCE.get())));

    public static void init(RegisterRecipeBookCategoriesEvent event) {
        event.registerBookCategories(GolDelight.RECIPE_TYPE_GOLDEN_COOKING, ImmutableList.of(GOLDEN_COOKING_SEARCH.get(), GOLDEN_COOKING_MEALS.get(), GOLDEN_COOKING_DRINKS.get(), GOLDEN_COOKING_MISC.get()));
        event.registerAggregateCategory(GOLDEN_COOKING_SEARCH.get(), ImmutableList.of(GOLDEN_COOKING_MEALS.get(), GOLDEN_COOKING_DRINKS.get(), GOLDEN_COOKING_MISC.get()));
        event.registerRecipeCategoryFinder(GDModRecipeTypes.GOLDEN_COOKING.get(), recipe ->
        {
            if (recipe instanceof GoldenCookingPotRecipe cookingRecipe) {
                GoldenCookingPotRecipeBookTab tab = cookingRecipe.getRecipeBookTab();
                if (tab != null) {
                    return switch (tab) {
                        case GOLDEN_MEALS -> GOLDEN_COOKING_MEALS.get();
                        case GOLDEN_DRINKS -> GOLDEN_COOKING_DRINKS.get();
                        case GOLDEN_MISC -> GOLDEN_COOKING_MISC.get();
                    };
                }
            }
            return GOLDEN_COOKING_MISC.get();
        });
    }
}
