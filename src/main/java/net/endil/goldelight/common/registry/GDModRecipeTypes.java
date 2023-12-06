package net.endil.goldelight.common.registry;

import net.endil.goldelight.GolDelight;
import net.endil.goldelight.common.recipe.GoldenCookingPotRecipe;
import net.endil.goldelight.common.recipe.MidasTouchingRecipe;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class GDModRecipeTypes {
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES =
            DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, GolDelight.MOD_ID);

    public static final RegistryObject<RecipeType<GoldenCookingPotRecipe>> GOLDEN_COOKING = RECIPE_TYPES.register("golden_cooking",
            () -> registerRecipeType("golden_cooking"));
    public static final RegistryObject<RecipeType<MidasTouchingRecipe>> MIDAS_TOUCHING = RECIPE_TYPES.register("midas_touching",
            () -> registerRecipeType("midas_touching"));


    public static <T extends Recipe<?>> RecipeType<T> registerRecipeType(final String identifier) {
        return new RecipeType<>() {
            public String toString() {
                return GolDelight.MOD_ID + ":" + identifier;
            }
        };
    }

    public static void register(IEventBus eventBus) {
        RECIPE_TYPES.register(eventBus);
    }
}
