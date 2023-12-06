package net.endil.goldelight.common.gui;

import net.endil.goldelight.GolDelight;
import net.endil.goldelight.common.recipe.GoldenCookingPotRecipe;
import net.minecraft.client.gui.screens.recipebook.RecipeBookComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import vectorwing.farmersdelight.common.utility.TextUtils;

import javax.annotation.Nonnull;
import java.util.List;

public class GoldenCookingPotRecipeBookComponent extends RecipeBookComponent {
    protected static final ResourceLocation RECIPE_BOOK_BUTTONS = new ResourceLocation(GolDelight.MOD_ID, "textures/gui/recipe_book_buttons.png");

    public GoldenCookingPotRecipeBookComponent() {
    }

    protected void initFilterButtonTextures() {
        this.filterButton.initTextureValues(0, 0, 28, 18, RECIPE_BOOK_BUTTONS);
    }

    public void hide() {
        this.setVisible(false);
    }

    @Nonnull
    protected Component getRecipeFilterName() {
        return TextUtils.getTranslation("container.recipe_book.cookable");
    }

    public void setupGhostRecipe(Recipe<?> recipe, List<Slot> slots) {
        ItemStack resultStack = recipe.getResultItem(this.minecraft.level.registryAccess());
        this.ghostRecipe.setRecipe(recipe);
        if (slots.get(6).getItem().isEmpty()) {
            this.ghostRecipe.addIngredient(Ingredient.of(resultStack), slots.get(6).x, slots.get(6).y);
        }

        if (recipe instanceof GoldenCookingPotRecipe cookingRecipe) {
            ItemStack containerStack = cookingRecipe.getOutputContainer();
            if (!containerStack.isEmpty()) {
                this.ghostRecipe.addIngredient(Ingredient.of(containerStack), slots.get(7).x, slots.get(7).y);
            }
        }

        this.placeRecipe(this.menu.getGridWidth(), this.menu.getGridHeight(), this.menu.getResultSlotIndex(), recipe, recipe.getIngredients().iterator(), 0);
    }
}
