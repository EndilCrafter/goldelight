package net.endil.goldelight.integration.jei;

import com.google.common.collect.ImmutableList;
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
import net.endil.goldelight.common.registry.GDModBlocks;
import net.endil.goldelight.common.registry.GDModTags;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;
import vectorwing.farmersdelight.common.utility.ClientRenderUtils;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class GolDecompositionRecipeCategory implements IRecipeCategory<GolDecompositionDummy> {
    public static final ResourceLocation UID = new ResourceLocation(GolDelight.MOD_ID, "goldecomposition");
    private static final int slotSize = 22;

    private final Component title;
    private final IDrawable background;
    private final IDrawable slotIcon;
    private final IDrawable icon;
    private final ItemStack compost;
    private final ItemStack soil;

    public GolDecompositionRecipeCategory(IGuiHelper helper) {
        title = GDTextUtils.getTranslation("jei.goldecomposition");
        ResourceLocation backgroundImage = new ResourceLocation(GolDelight.MOD_ID, "textures/gui/jei/goldecomposition.png");
        background = helper.createDrawable(backgroundImage, 0, 0, 118, 80);
        compost = new ItemStack(GDModBlocks.GOLDEN_COMPOST.get());
        soil = new ItemStack(GDModBlocks.GOLDEN_SOIL.get());
        icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, soil);
        slotIcon = helper.createDrawable(backgroundImage, 119, 0, slotSize, slotSize);
    }

    private static MutableComponent translateKey(@Nonnull String suffix) {
        return Component.translatable(GolDelight.MOD_ID + ".jei.goldecomposition" + suffix);
    }

    @Override
    public RecipeType<GolDecompositionDummy> getRecipeType() {
        return GDRecipeTypes.GOLDECOMPOSITION;
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
    public void setRecipe(IRecipeLayoutBuilder builder, GolDecompositionDummy recipe, IFocusGroup focusGroup) {
        List<ItemStack> accelerators = ForgeRegistries.BLOCKS.tags().getTag(GDModTags.Blocks.GOLDEN_COMPOST_ACTIVATORS).stream().map(ItemStack::new).collect(Collectors.toList());

        builder.addSlot(RecipeIngredientRole.INPUT, 9, 26).addItemStack(compost);
        builder.addSlot(RecipeIngredientRole.OUTPUT, 93, 26).addItemStack(soil);
        builder.addSlot(RecipeIngredientRole.RENDER_ONLY, 64, 54).addItemStacks(accelerators);
    }

    @Override
    public void draw(GolDecompositionDummy recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        this.slotIcon.draw(guiGraphics, 63, 53);
    }

    @Override
    public List<Component> getTooltipStrings(GolDecompositionDummy recipe, IRecipeSlotsView recipeSlotsView, double mouseX, double mouseY) {
        if (ClientRenderUtils.isCursorInsideBounds(40, 38, 11, 11, mouseX, mouseY)) {
            return ImmutableList.of(translateKey(".light"));
        }
        if (ClientRenderUtils.isCursorInsideBounds(53, 38, 11, 11, mouseX, mouseY)) {
            return ImmutableList.of(translateKey(".fluid"));
        }
        if (ClientRenderUtils.isCursorInsideBounds(67, 38, 11, 11, mouseX, mouseY)) {
            return ImmutableList.of(translateKey(".accelerators"));
        }
        return Collections.emptyList();
    }
}