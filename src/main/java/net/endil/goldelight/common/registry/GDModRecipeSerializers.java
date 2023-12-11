package net.endil.goldelight.common.registry;

import net.endil.goldelight.GolDelight;
import net.endil.goldelight.common.recipe.GoldenCookingPotRecipe;
import net.endil.goldelight.common.recipe.GoldenCuttingBoardRecipe;
import net.endil.goldelight.common.recipe.GoldenFoodServingRecipe;
import net.endil.goldelight.common.recipe.MidasTouchingRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleCraftingRecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class GDModRecipeSerializers {
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, GolDelight.MOD_ID);

    public static final RegistryObject<RecipeSerializer<MidasTouchingRecipe>> MIDAS_TOUCHING_SERIALIZER =
            RECIPE_SERIALIZERS.register("midas_touching", MidasTouchingRecipe.Serializer::new);

    public static final RegistryObject<RecipeSerializer<?>> GOLDEN_COOKING_SERIALIZER =
            RECIPE_SERIALIZERS.register("golden_cooking", GoldenCookingPotRecipe.Serializer::new);

    public static final RegistryObject<RecipeSerializer<?>> GOLDEN_CUTTING_SERIALIZER =
            RECIPE_SERIALIZERS.register("golden_cutting", GoldenCuttingBoardRecipe.Serializer::new);

    public static final RegistryObject<SimpleCraftingRecipeSerializer<?>> GOLDEN_FOOD_SERVING =
            RECIPE_SERIALIZERS.register("golden_food_serving", () -> new SimpleCraftingRecipeSerializer<>(GoldenFoodServingRecipe::new));

    public static void register(IEventBus eventBus) {
        RECIPE_SERIALIZERS.register(eventBus);
    }
}
