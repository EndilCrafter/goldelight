package net.endil.goldelight.integration.jei;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.endil.goldelight.GDTextUtils;
import net.endil.goldelight.GolDelight;
import net.endil.goldelight.common.recipe.GoldenCookingPotRecipe;
import net.endil.goldelight.common.registry.GDModItems;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import vectorwing.farmersdelight.common.utility.ClientRenderUtils;
import vectorwing.farmersdelight.common.utility.RecipeUtils;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class GoldenCookingRecipeCategory implements IRecipeCategory<GoldenCookingPotRecipe>
{
    protected final IDrawable heatIndicator;
    protected final IDrawable timeIcon;
    protected final IDrawable expIcon;
    protected final IDrawableAnimated arrow;
    private final Component title;
    private final IDrawable background;
    private final IDrawable icon;

    public GoldenCookingRecipeCategory(IGuiHelper helper) {
        title = GDTextUtils.getTranslation("jei.golden_cooking");
        ResourceLocation backgroundImage = new ResourceLocation(GolDelight.MOD_ID, "textures/gui/golden_cooking_pot.png");
        background = helper.createDrawable(backgroundImage, 29, 16, 116, 56);
        icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(GDModItems.GOLDEN_COOKING_POT.get()));
        heatIndicator = helper.createDrawable(backgroundImage, 176, 0, 17, 15);
        timeIcon = helper.createDrawable(backgroundImage, 176, 32, 8, 11);
        expIcon = helper.createDrawable(backgroundImage, 176, 43, 9, 9);
        arrow = helper.drawableBuilder(backgroundImage, 176, 15, 24, 17)
                .buildAnimated(200, IDrawableAnimated.StartDirection.LEFT, false);
    }

    @Override
    public RecipeType<GoldenCookingPotRecipe> getRecipeType() {
        return GDRecipeTypes.GOLDEN_COOKING;
    }

    @Override
    public Component getTitle() {
        return this.title;
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, GoldenCookingPotRecipe recipe, IFocusGroup focusGroup) {
        NonNullList<Ingredient> recipeIngredients = recipe.getIngredients();
        ItemStack resultStack = RecipeUtils.getResultItem(recipe);
        ItemStack containerStack = recipe.getOutputContainer();

        int borderSlotSize = 18;
        for (int row = 0; row < 2; ++row) {
            for (int column = 0; column < 3; ++column) {
                int inputIndex = row * 3 + column;
                if (inputIndex < recipeIngredients.size()) {
                    builder.addSlot(RecipeIngredientRole.INPUT, (column * borderSlotSize) + 1, (row * borderSlotSize) + 1)
                            .addItemStacks(Arrays.asList(recipeIngredients.get(inputIndex).getItems()));
                }
            }
        }

        builder.addSlot(RecipeIngredientRole.OUTPUT, 95, 10).addItemStack(resultStack);

        if (!containerStack.isEmpty()) {
            builder.addSlot(RecipeIngredientRole.CATALYST, 63, 39).addItemStack(containerStack);
        }

        builder.addSlot(RecipeIngredientRole.OUTPUT, 95, 39).addItemStack(resultStack);
    }

    @Override
    public void draw(GoldenCookingPotRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        arrow.draw(guiGraphics, 60, 9);
        heatIndicator.draw(guiGraphics, 18, 39);
        timeIcon.draw(guiGraphics, 64, 2);
        if (recipe.getExperience() > 0) {
            expIcon.draw(guiGraphics, 63, 21);
        }
    }

    @Override
    public List<Component> getTooltipStrings(GoldenCookingPotRecipe recipe, IRecipeSlotsView recipeSlotsView, double mouseX, double mouseY) {
        if (ClientRenderUtils.isCursorInsideBounds(61, 2, 22, 28, mouseX, mouseY)) {
            List<Component> tooltipStrings = new ArrayList<>();

            int cookTime = recipe.getCookTime();
            if (cookTime > 0) {
                int cookTimeSeconds = cookTime / 20;
                tooltipStrings.add(Component.translatable("gui.jei.category.smelting.time.seconds", cookTimeSeconds));
            }
            float experience = recipe.getExperience();
            if (experience > 0) {
                tooltipStrings.add(Component.translatable("gui.jei.category.smelting.experience", experience));
            }

            return tooltipStrings;
        }
        return Collections.emptyList();
    }
}