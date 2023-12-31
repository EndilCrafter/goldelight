package net.endil.goldelight.integration.jei;

import mezz.jei.api.recipe.RecipeType;
import net.endil.goldelight.GolDelight;
import net.endil.goldelight.common.recipe.GoldenCookingPotRecipe;
import net.endil.goldelight.common.recipe.GoldenCuttingBoardRecipe;

public class GDRecipeTypes {
    public static final RecipeType<GoldenCookingPotRecipe> GOLDEN_COOKING = RecipeType.create(GolDelight.MOD_ID, "golden_cooking", GoldenCookingPotRecipe.class);
    public static final RecipeType<GoldenCuttingBoardRecipe> GOLDEN_CUTTING = RecipeType.create(GolDelight.MOD_ID, "golden_cutting", GoldenCuttingBoardRecipe.class);
    public static final RecipeType<GolDecompositionDummy> GOLDECOMPOSITION = RecipeType.create(GolDelight.MOD_ID, "goldecomposition", GolDecompositionDummy.class);
}
