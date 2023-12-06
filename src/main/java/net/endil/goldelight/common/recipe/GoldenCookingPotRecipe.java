package net.endil.goldelight.common.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import net.endil.goldelight.client.recipebook.GoldenCookingPotRecipeBookTab;
import net.endil.goldelight.common.registry.GDModItems;
import net.endil.goldelight.common.registry.GDModRecipeSerializers;
import net.endil.goldelight.common.registry.GDModRecipeTypes;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.items.wrapper.RecipeWrapper;
import vectorwing.farmersdelight.FarmersDelight;

import javax.annotation.Nullable;
import java.util.EnumSet;

@SuppressWarnings("ClassCanBeRecord")
public class GoldenCookingPotRecipe implements Recipe<RecipeWrapper> {
    public static final int INPUT_SLOTS = 6;

    private final ResourceLocation id;
    private final String group;
    private final GoldenCookingPotRecipeBookTab tab;
    private final NonNullList<Ingredient> inputItems;
    private final ItemStack output;
    private final ItemStack container;
    private final float experience;
    private final int cookTime;

    public GoldenCookingPotRecipe(ResourceLocation id, String group, @Nullable GoldenCookingPotRecipeBookTab tab, NonNullList<Ingredient> inputItems, ItemStack output, ItemStack container, float experience, int cookTime) {
        this.id = id;
        this.group = group;
        this.tab = tab;
        this.inputItems = inputItems;
        this.output = output;

        if (!container.isEmpty()) {
            this.container = container;
        } else if (!output.getCraftingRemainingItem().isEmpty()) {
            this.container = output.getCraftingRemainingItem();
        } else {
            this.container = ItemStack.EMPTY;
        }

        this.experience = experience;
        this.cookTime = cookTime;
    }

    @Override
    public ResourceLocation getId() {
        return this.id;
    }

    @Override
    public String getGroup() {
        return this.group;
    }

    @Nullable
    public GoldenCookingPotRecipeBookTab getRecipeBookTab() {
        return this.tab;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return this.inputItems;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess access) {
        return this.output;
    }

    public ItemStack getOutputContainer() {
        return this.container;
    }

    @Override
    public ItemStack assemble(RecipeWrapper inv, RegistryAccess access) {
        return this.output.copy();
    }

    public float getExperience() {
        return this.experience;
    }

    public int getCookTime() {
        return this.cookTime;
    }

    @Override
    public boolean matches(RecipeWrapper inv, Level level) {
        java.util.List<ItemStack> inputs = new java.util.ArrayList<>();
        int i = 0;

        for (int j = 0; j < INPUT_SLOTS; ++j) {
            ItemStack itemstack = inv.getItem(j);
            if (!itemstack.isEmpty()) {
                ++i;
                inputs.add(itemstack);
            }
        }
        return i == this.inputItems.size() && net.minecraftforge.common.util.RecipeMatcher.findMatches(inputs, this.inputItems) != null;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return width * height >= this.inputItems.size();
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return GDModRecipeSerializers.GOLDEN_COOKING_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return GDModRecipeTypes.GOLDEN_COOKING.get();
    }

    @Override
    public ItemStack getToastSymbol() {
        return new ItemStack(GDModItems.GOLDEN_COOKING_POT.get());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GoldenCookingPotRecipe that = (GoldenCookingPotRecipe) o;

        if (Float.compare(that.getExperience(), getExperience()) != 0) return false;
        if (getCookTime() != that.getCookTime()) return false;
        if (!getId().equals(that.getId())) return false;
        if (!getGroup().equals(that.getGroup())) return false;
        if (tab != that.tab) return false;
        if (!inputItems.equals(that.inputItems)) return false;
        if (!output.equals(that.output)) return false;
        return container.equals(that.container);
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getGroup().hashCode();
        result = 31 * result + (getRecipeBookTab() != null ? getRecipeBookTab().hashCode() : 0);
        result = 31 * result + inputItems.hashCode();
        result = 31 * result + output.hashCode();
        result = 31 * result + container.hashCode();
        result = 31 * result + (getExperience() != +0.0f ? Float.floatToIntBits(getExperience()) : 0);
        result = 31 * result + getCookTime();
        return result;
    }

    public static class Serializer implements RecipeSerializer<GoldenCookingPotRecipe> {
        public Serializer() {
        }

        private static NonNullList<Ingredient> readIngredients(JsonArray ingredientArray) {
            NonNullList<Ingredient> nonnulllist = NonNullList.create();

            for (int i = 0; i < ingredientArray.size(); ++i) {
                Ingredient ingredient = Ingredient.fromJson(ingredientArray.get(i));
                if (!ingredient.isEmpty()) {
                    nonnulllist.add(ingredient);
                }
            }

            return nonnulllist;
        }

        @Override
        public GoldenCookingPotRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
            final String groupIn = GsonHelper.getAsString(json, "group", "");
            final NonNullList<Ingredient> inputItemsIn = readIngredients(GsonHelper.getAsJsonArray(json, "ingredients"));
            if (inputItemsIn.isEmpty()) {
                throw new JsonParseException("No ingredients for cooking recipe");
            } else if (inputItemsIn.size() > GoldenCookingPotRecipe.INPUT_SLOTS) {
                throw new JsonParseException("Too many ingredients for cooking recipe! The max is " + GoldenCookingPotRecipe.INPUT_SLOTS);
            } else {
                final String tabKeyIn = GsonHelper.getAsString(json, "recipe_book_tab", null);
                final GoldenCookingPotRecipeBookTab tabIn = GoldenCookingPotRecipeBookTab.findByName(tabKeyIn);
                if (tabKeyIn != null && tabIn == null) {
                    FarmersDelight.LOGGER.warn("Optional field 'recipe_book_tab' does not match any valid tab. If defined, must be one of the following: " + EnumSet.allOf(GoldenCookingPotRecipeBookTab.class));
                }
                final ItemStack outputIn = CraftingHelper.getItemStack(GsonHelper.getAsJsonObject(json, "result"), true);
                ItemStack container = GsonHelper.isValidNode(json, "container") ? CraftingHelper.getItemStack(GsonHelper.getAsJsonObject(json, "container"), true) : ItemStack.EMPTY;
                final float experienceIn = GsonHelper.getAsFloat(json, "experience", 0.0F);
                final int cookTimeIn = GsonHelper.getAsInt(json, "cookingtime", 200);
                return new GoldenCookingPotRecipe(recipeId, groupIn, tabIn, inputItemsIn, outputIn, container, experienceIn, cookTimeIn);
            }
        }

        @Nullable
        @Override
        public GoldenCookingPotRecipe fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer) {
            String groupIn = buffer.readUtf();
            GoldenCookingPotRecipeBookTab tabIn = GoldenCookingPotRecipeBookTab.findByName(buffer.readUtf());
            int i = buffer.readVarInt();
            NonNullList<Ingredient> inputItemsIn = NonNullList.withSize(i, Ingredient.EMPTY);

            for (int j = 0; j < inputItemsIn.size(); ++j) {
                inputItemsIn.set(j, Ingredient.fromNetwork(buffer));
            }

            ItemStack outputIn = buffer.readItem();
            ItemStack container = buffer.readItem();
            float experienceIn = buffer.readFloat();
            int cookTimeIn = buffer.readVarInt();
            return new GoldenCookingPotRecipe(recipeId, groupIn, tabIn, inputItemsIn, outputIn, container, experienceIn, cookTimeIn);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buffer, GoldenCookingPotRecipe recipe) {
            buffer.writeUtf(recipe.group);
            buffer.writeUtf(recipe.tab != null ? recipe.tab.toString() : "");
            buffer.writeVarInt(recipe.inputItems.size());

            for (Ingredient ingredient : recipe.inputItems) {
                ingredient.toNetwork(buffer);
            }

            buffer.writeItem(recipe.output);
            buffer.writeItem(recipe.container);
            buffer.writeFloat(recipe.experience);
            buffer.writeVarInt(recipe.cookTime);
        }
    }
}