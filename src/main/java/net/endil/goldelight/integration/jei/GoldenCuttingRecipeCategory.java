package net.endil.goldelight.integration.jei;

import com.mojang.blaze3d.vertex.PoseStack;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.endil.goldelight.GDTextUtils;
import net.endil.goldelight.GolDelight;
import net.endil.goldelight.common.recipe.GoldenCuttingBoardRecipe;
import net.endil.goldelight.common.registry.GDModBlocks;
import net.minecraft.ChatFormatting;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import vectorwing.farmersdelight.FarmersDelight;
import vectorwing.farmersdelight.common.crafting.CuttingBoardRecipe;
import vectorwing.farmersdelight.common.crafting.ingredient.ChanceResult;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.utility.TextUtils;
import vectorwing.farmersdelight.integration.jei.FDRecipeTypes;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class GoldenCuttingRecipeCategory implements IRecipeCategory<GoldenCuttingBoardRecipe>
{
    public static final int OUTPUT_GRID_X = 76;
    public static final int OUTPUT_GRID_Y = 10;
    private final IDrawable slot;
    private final IDrawable slotChance;
    private final Component title;
    private final IDrawable background;
    private final IDrawable icon;

    public GoldenCuttingRecipeCategory(IGuiHelper helper) {
        title = GDTextUtils.getTranslation("jei.golden_cutting");
        ResourceLocation backgroundImage = new ResourceLocation(GolDelight.MOD_ID, "textures/gui/jei/golden_cutting_board.png");
        slot = helper.createDrawable(backgroundImage, 0, 58, 18, 18);
        slotChance = helper.createDrawable(backgroundImage, 18, 58, 18, 18);
        background = helper.createDrawable(backgroundImage, 0, 0, 117, 57);
        icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(GDModBlocks.GOLDEN_CUTTING_BOARD.get()));
    }

    @Override
    public RecipeType<GoldenCuttingBoardRecipe> getRecipeType() {
        return GDRecipeTypes.GOLDEN_CUTTING;
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
    public void setRecipe(IRecipeLayoutBuilder builder, GoldenCuttingBoardRecipe recipe, IFocusGroup focusGroup) {
        builder.addSlot(RecipeIngredientRole.INPUT, 16, 8).addIngredients(recipe.getTool());
        builder.addSlot(RecipeIngredientRole.INPUT, 16, 27).addIngredients(recipe.getIngredients().get(0));

        NonNullList<ChanceResult> recipeOutputs = recipe.getRollableResults();

        int size = recipeOutputs.size();
        int centerX = size > 1 ? 1 : 10;
        int centerY = size > 2 ? 1 : 10;

        for (int i = 0; i < size; i++) {
            int xOffset = centerX + (i % 2 == 0 ? 0 : 19);
            int yOffset = centerY + ((i / 2) * 19);

            int index = i;
            builder.addSlot(RecipeIngredientRole.OUTPUT, OUTPUT_GRID_X + xOffset, OUTPUT_GRID_Y + yOffset)
                    .addItemStack(recipeOutputs.get(i).getStack())
                    .addTooltipCallback((slotView, tooltip) -> {
                        ChanceResult output = recipeOutputs.get(index);
                        float chance = output.getChance();
                        if (chance != 1)
                            tooltip.add(1, TextUtils.getTranslation("jei.chance", chance < 0.01 ? "<1" : (int) (chance * 100))
                                    .withStyle(ChatFormatting.GOLD));
                    });
        }
    }

    @Override
    public void draw(GoldenCuttingBoardRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        NonNullList<ChanceResult> recipeOutputs = recipe.getRollableResults();

        int size = recipe.getResults().size();
        int centerX = size > 1 ? 0 : 9;
        int centerY = size > 2 ? 0 : 9;

        for (int i = 0; i < size; i++) {
            int xOffset = centerX + (i % 2 == 0 ? 0 : 19);
            int yOffset = centerY + ((i / 2) * 19);

            if (recipeOutputs.get(i).getChance() != 1) {
                slotChance.draw(guiGraphics, OUTPUT_GRID_X + xOffset, OUTPUT_GRID_Y + yOffset);
            } else {
                slot.draw(guiGraphics, OUTPUT_GRID_X + xOffset, OUTPUT_GRID_Y + yOffset);
            }
        }
    }
}