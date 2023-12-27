package net.endil.goldelight.common.recipe;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.endil.goldelight.common.registry.GDModRecipeSerializers;
import net.endil.goldelight.common.registry.GDModRecipeTypes;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class MidasTouchingRecipe implements Recipe<Container> {
    protected final ResourceLocation id;
    protected final Ingredient ingredient;
    protected final ItemStack result;

    public MidasTouchingRecipe(Ingredient ingredient, ItemStack result, ResourceLocation id) {
        this.ingredient = ingredient;
        this.result = result;
        this.id = id;
    }


    @Override
    public boolean matches(Container container, Level level) {
        return this.ingredient.test(container.getItem(0));
    }

    @Override
    public ItemStack assemble(Container pContainer, RegistryAccess pRegistryAccess) {
        return this.result.copy();
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess pRegistryAccess) {
        return this.result;
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return GDModRecipeSerializers.MIDAS_TOUCHING_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return GDModRecipeTypes.MIDAS_TOUCHING.get();
    }

    public static class Serializer implements RecipeSerializer<MidasTouchingRecipe> {

        @Override
        public MidasTouchingRecipe fromJson(ResourceLocation id, JsonObject json) {
            ItemStack result = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "result"));
            JsonElement jsonelement = GsonHelper.isArrayNode(json, "ingredient") ? GsonHelper.getAsJsonArray(json, "ingredient") : GsonHelper.getAsJsonObject(json, "ingredient");
            Ingredient ingredient = Ingredient.fromJson(jsonelement, false);
            return new MidasTouchingRecipe(ingredient, result, id);
        }

        @Override
        public @Nullable MidasTouchingRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buffer) {
            Ingredient ingredient = Ingredient.fromNetwork(buffer);
            ItemStack result = buffer.readItem();
            return new MidasTouchingRecipe(ingredient, result, id);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buffer, MidasTouchingRecipe recipe) {
            recipe.ingredient.toNetwork(buffer);
            buffer.writeItem(recipe.result);
        }
    }
}
