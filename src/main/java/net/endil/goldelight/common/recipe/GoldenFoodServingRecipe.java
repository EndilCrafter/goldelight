package net.endil.goldelight.common.recipe;

import net.endil.goldelight.common.block.entity.GoldenCookingPotBlockEntity;
import net.endil.goldelight.common.registry.GDModItems;
import net.endil.goldelight.common.registry.GDModRecipeSerializers;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;

public class GoldenFoodServingRecipe extends CustomRecipe
{
    public GoldenFoodServingRecipe(ResourceLocation id, CraftingBookCategory category) {
        super(id, category);
    }

    @Override
    public boolean matches(CraftingContainer container, Level level) {
        ItemStack cookingPotStack = ItemStack.EMPTY;
        ItemStack containerStack = ItemStack.EMPTY;
        ItemStack secondStack = ItemStack.EMPTY;

        for (int index = 0; index < container.getContainerSize(); ++index) {
            ItemStack selectedStack = container.getItem(index);
            if (!selectedStack.isEmpty()) {
                if (cookingPotStack.isEmpty()) {
                    ItemStack mealStack = GoldenCookingPotBlockEntity.getMealFromItem(selectedStack);
                    if (!mealStack.isEmpty()) {
                        cookingPotStack = selectedStack;
                        containerStack = GoldenCookingPotBlockEntity.getContainerFromItem(selectedStack);
                        continue;
                    }
                }
                if (secondStack.isEmpty()) {
                    secondStack = selectedStack;
                } else {
                    return false;
                }
            }
        }

        return !cookingPotStack.isEmpty() && !secondStack.isEmpty() && secondStack.is(containerStack.getItem());
    }

    @Override
    public ItemStack assemble(CraftingContainer container, RegistryAccess access) {
        for (int i = 0; i < container.getContainerSize(); ++i) {
            ItemStack selectedStack = container.getItem(i);
            if (!selectedStack.isEmpty() && selectedStack.is(GDModItems.GOLDEN_COOKING_POT.get())) {
                ItemStack resultStack = GoldenCookingPotBlockEntity.getMealFromItem(selectedStack).copy();
                resultStack.setCount(1);
                return resultStack;
            }
        }

        return ItemStack.EMPTY;
    }

    @Override
    public NonNullList<ItemStack> getRemainingItems(CraftingContainer container) {
        NonNullList<ItemStack> remainders = NonNullList.withSize(container.getContainerSize(), ItemStack.EMPTY);

        for (int i = 0; i < remainders.size(); ++i) {
            ItemStack selectedStack = container.getItem(i);
            if (selectedStack.hasCraftingRemainingItem()) {
                remainders.set(i, selectedStack.getCraftingRemainingItem());
            } else if (selectedStack.is(GDModItems.GOLDEN_COOKING_POT.get())) {
                GoldenCookingPotBlockEntity.takeServingFromItem(selectedStack);
                ItemStack newCookingPotStack = selectedStack.copy();
                newCookingPotStack.setCount(1);
                remainders.set(i, newCookingPotStack);
                break;
            }
        }

        return remainders;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return width >= 2 && height >= 2;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return GDModRecipeSerializers.GOLDEN_FOOD_SERVING.get();
    }
}