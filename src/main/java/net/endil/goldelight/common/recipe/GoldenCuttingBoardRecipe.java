package net.endil.goldelight.common.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import net.endil.goldelight.common.registry.GDModRecipeSerializers;
import net.endil.goldelight.common.registry.GDModRecipeTypes;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraftforge.items.wrapper.RecipeWrapper;
import vectorwing.farmersdelight.common.crafting.ingredient.ChanceResult;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class GoldenCuttingBoardRecipe implements Recipe<RecipeWrapper> {
    public static final int MAX_RESULTS = 4;
    private final ResourceLocation id;
    private final String group;
    private final Ingredient input;
    private final Ingredient tool;
    private final NonNullList<ChanceResult> results;
    private final String soundEvent;

    public GoldenCuttingBoardRecipe(ResourceLocation id, String group, Ingredient input, Ingredient tool, NonNullList<ChanceResult> results, String soundEvent) {
        this.id = id;
        this.group = group;
        this.input = input;
        this.tool = tool;
        this.results = results;
        this.soundEvent = soundEvent;
    }

    public boolean isSpecial() {
        return true;
    }

    public ResourceLocation getId() {
        return this.id;
    }

    public String getGroup() {
        return this.group;
    }

    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> nonnulllist = NonNullList.create();
        nonnulllist.add(this.input);
        return nonnulllist;
    }

    public Ingredient getTool() {
        return this.tool;
    }

    public ItemStack assemble(RecipeWrapper inv, RegistryAccess access) {
        return this.results.get(0).getStack().copy();
    }

    public ItemStack getResultItem(RegistryAccess access) {
        return this.results.get(0).getStack();
    }

    public List<ItemStack> getResults() {
        return this.getRollableResults().stream().map(ChanceResult::getStack).collect(Collectors.toList());
    }

    public NonNullList<ChanceResult> getRollableResults() {
        return this.results;
    }

    public List<ItemStack> rollResults(RandomSource rand, int fortuneLevel) {
        List<ItemStack> results = new ArrayList();
        NonNullList<ChanceResult> rollableResults = this.getRollableResults();
        Iterator var5 = rollableResults.iterator();

        while (var5.hasNext()) {
            ChanceResult output = (ChanceResult) var5.next();
            ItemStack stack = output.rollOutput(rand, fortuneLevel);
            if (!stack.isEmpty()) {
                results.add(stack);
            }
        }

        return results;
    }

    public String getSoundEventID() {
        return this.soundEvent;
    }

    public boolean matches(RecipeWrapper inv, Level level) {
        return !inv.isEmpty() && this.input.test(inv.getItem(0));
    }

    protected int getMaxInputCount() {
        return 1;
    }

    public boolean canCraftInDimensions(int width, int height) {
        return width * height >= this.getMaxInputCount();
    }

    public RecipeSerializer<?> getSerializer() {
        return GDModRecipeSerializers.GOLDEN_CUTTING_SERIALIZER.get();
    }

    public RecipeType<?> getType() {
        return GDModRecipeTypes.GOLDEN_CUTTING.get();
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            GoldenCuttingBoardRecipe that = (GoldenCuttingBoardRecipe) o;
            if (!this.getId().equals(that.getId())) {
                return false;
            } else if (!this.getGroup().equals(that.getGroup())) {
                return false;
            } else if (!this.input.equals(that.input)) {
                return false;
            } else if (!this.getTool().equals(that.getTool())) {
                return false;
            } else {
                return this.getResults().equals(that.getResults()) && Objects.equals(this.soundEvent, that.soundEvent);
            }
        } else {
            return false;
        }
    }

    public int hashCode() {
        int result = this.getId().hashCode();
        result = 31 * result + (this.getGroup() != null ? this.getGroup().hashCode() : 0);
        result = 31 * result + this.input.hashCode();
        result = 31 * result + this.getTool().hashCode();
        result = 31 * result + this.getResults().hashCode();
        result = 31 * result + (this.soundEvent != null ? this.soundEvent.hashCode() : 0);
        return result;
    }

    public static class Serializer implements RecipeSerializer<GoldenCuttingBoardRecipe> {
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

        private static NonNullList<ChanceResult> readResults(JsonArray resultArray) {
            NonNullList<ChanceResult> results = NonNullList.create();
            Iterator var2 = resultArray.iterator();

            while (var2.hasNext()) {
                JsonElement result = (JsonElement) var2.next();
                results.add(ChanceResult.deserialize(result));
            }

            return results;
        }

        public GoldenCuttingBoardRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
            String groupIn = GsonHelper.getAsString(json, "group", "");
            NonNullList<Ingredient> inputItemsIn = readIngredients(GsonHelper.getAsJsonArray(json, "ingredients"));
            JsonObject toolObject = GsonHelper.getAsJsonObject(json, "tool");
            Ingredient toolIn = Ingredient.fromJson(toolObject);
            if (inputItemsIn.isEmpty()) {
                throw new JsonParseException("No ingredients for cutting recipe");
            } else if (toolIn.isEmpty()) {
                throw new JsonParseException("No tool for cutting recipe");
            } else if (inputItemsIn.size() > 1) {
                throw new JsonParseException("Too many ingredients for cutting recipe! Please define only one ingredient");
            } else {
                NonNullList<ChanceResult> results = readResults(GsonHelper.getAsJsonArray(json, "result"));
                if (results.size() > 4) {
                    throw new JsonParseException("Too many results for cutting recipe! The maximum quantity of unique results is 4");
                } else {
                    String soundID = GsonHelper.getAsString(json, "sound", "");
                    return new GoldenCuttingBoardRecipe(recipeId, groupIn, inputItemsIn.get(0), toolIn, results, soundID);
                }
            }
        }

        @Nullable
        public GoldenCuttingBoardRecipe fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer) {
            String groupIn = buffer.readUtf(32767);
            Ingredient inputItemIn = Ingredient.fromNetwork(buffer);
            Ingredient toolIn = Ingredient.fromNetwork(buffer);
            int i = buffer.readVarInt();
            NonNullList<ChanceResult> resultsIn = NonNullList.withSize(i, ChanceResult.EMPTY);

            for (int j = 0; j < resultsIn.size(); ++j) {
                resultsIn.set(j, ChanceResult.read(buffer));
            }

            String soundEventIn = buffer.readUtf();
            return new GoldenCuttingBoardRecipe(recipeId, groupIn, inputItemIn, toolIn, resultsIn, soundEventIn);
        }

        public void toNetwork(FriendlyByteBuf buffer, GoldenCuttingBoardRecipe recipe) {
            buffer.writeUtf(recipe.group);
            recipe.input.toNetwork(buffer);
            recipe.tool.toNetwork(buffer);
            buffer.writeVarInt(recipe.results.size());
            Iterator var3 = recipe.results.iterator();

            while (var3.hasNext()) {
                ChanceResult result = (ChanceResult) var3.next();
                result.write(buffer);
            }

            buffer.writeUtf(recipe.soundEvent);
        }
    }
}

