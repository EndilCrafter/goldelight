package net.endil.goldelight.integration.jei;

import com.google.common.collect.ImmutableList;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.*;
import net.endil.goldelight.GDTextUtils;
import net.endil.goldelight.GolDelight;
import net.endil.goldelight.common.block.entity.container.GoldenCookingPotMenu;
import net.endil.goldelight.common.gui.GoldenCookingPotScreen;
import net.endil.goldelight.common.registry.GDModBlocks;
import net.endil.goldelight.common.registry.GDModItems;
import net.endil.goldelight.common.registry.GDModMenuTypes;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import javax.annotation.ParametersAreNonnullByDefault;

@JeiPlugin
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
@SuppressWarnings("unused")
public class GDJEIPlugin implements IModPlugin {
    private static final ResourceLocation ID = new ResourceLocation(GolDelight.MOD_ID, "jei_plugin");

    @Override
    public void registerCategories(IRecipeCategoryRegistration registry) {
        registry.addRecipeCategories(new GoldenCookingRecipeCategory(registry.getJeiHelpers().getGuiHelper()));
        registry.addRecipeCategories(new GolDecompositionRecipeCategory(registry.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        GDRecipes modRecipes = new GDRecipes();
        registration.addRecipes(GDRecipeTypes.GOLDEN_COOKING, modRecipes.getGoldenCookingPotRecipes());
        registration.addRecipes(GDRecipeTypes.GOLDECOMPOSITION, ImmutableList.of(new GolDecompositionDummy()));
        registration.addIngredientInfo(new ItemStack(GDModItems.MIDAS_KNIFE.get()), VanillaTypes.ITEM_STACK, GDTextUtils.getTranslation("jei.info.midas_knife"));
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(GDModItems.GOLDEN_COOKING_POT.get()), GDRecipeTypes.GOLDEN_COOKING);
        registration.addRecipeCatalyst(new ItemStack(GDModBlocks.NETHER_BRICK_STOVE.get()), RecipeTypes.CAMPFIRE_COOKING);
        registration.addRecipeCatalyst(new ItemStack(GDModBlocks.GOLDEN_COMPOST.get()), GDRecipeTypes.GOLDECOMPOSITION);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(GoldenCookingPotScreen.class, 89, 25, 24, 17, GDRecipeTypes.GOLDEN_COOKING);
    }

    @Override
    public void registerRecipeTransferHandlers(IRecipeTransferRegistration registration) {
        registration.addRecipeTransferHandler(GoldenCookingPotMenu.class, GDModMenuTypes.GOLDEN_COOKING_POT.get(), GDRecipeTypes.GOLDEN_COOKING, 0, 6, 9, 36);
    }

    @Override
    public ResourceLocation getPluginUid() {
        return ID;
    }
}
