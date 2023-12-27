package net.endil.goldelight.integration.jei;

import net.endil.goldelight.common.recipe.GoldenCookingPotRecipe;
import net.endil.goldelight.common.recipe.GoldenCuttingBoardRecipe;
import net.endil.goldelight.common.registry.GDModRecipeTypes;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;

public class GDRecipes {
    private final RecipeManager recipeManager;

    public GDRecipes() {
        Minecraft minecraft = Minecraft.getInstance();
        ClientLevel level = minecraft.level;

        if (level != null) {
            this.recipeManager = level.getRecipeManager();
        } else {
            throw new NullPointerException("minecraft world must not be null.");
        }
    }

    public List<GoldenCookingPotRecipe> getGoldenCookingPotRecipes() {
        return recipeManager.getAllRecipesFor(GDModRecipeTypes.GOLDEN_COOKING.get()).stream().toList();
    }

    public List<GoldenCuttingBoardRecipe> getGoldenCuttingBoardRecipes() {
        return recipeManager.getAllRecipesFor(GDModRecipeTypes.GOLDEN_CUTTING.get()).stream().toList();
    }

}
