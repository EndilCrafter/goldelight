package net.endil.goldelight.data;

import net.endil.goldelight.GolDelight;
import net.endil.goldelight.common.registry.GDModBlocks;
import net.endil.goldelight.common.registry.GDModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModels extends ItemModelProvider {
    public ModItemModels(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, GolDelight.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        ItemGeneratedModel(GDModItems.GOLDEN_BEEF);
        ItemGeneratedModel(GDModItems.GOLDEN_BONE);
        ItemGeneratedModel(GDModItems.GOLDEN_MEAL);
        ItemGeneratedModel(GDModItems.GOLDEN_BREAD);
        ItemGeneratedModel(GDModItems.GOLDEN_CAKE);
        ItemGeneratedModel(GDModItems.GOLDEN_CHICKEN);
        ItemGeneratedModel(GDModItems.GOLDEN_COCOA_BEANS);
        ItemGeneratedModel(GDModItems.GOLDEN_COD);
        ItemGeneratedModel(GDModItems.GOLDEN_COOKIE);
        ItemGeneratedModel(GDModItems.GOLDEN_EGG);
        ItemGeneratedModel(GDModItems.GOLDEN_GLOW_BERRIES);
        ItemGeneratedModel(GDModItems.GOLDEN_HONEY_BOTTLE);
        ItemGeneratedModel(GDModItems.GOLDEN_INK_SAC);
        ItemGeneratedModel(GDModItems.GOLDEN_MELON_SEEDS);
        ItemGeneratedModel(GDModItems.GOLDEN_MELON_SLICE);
        ItemGeneratedModel(GDModItems.GOLDEN_MILK_BUCKET);
        PlantModel(GDModBlocks.GOLDEN_MUSHROOM);
        PlantModel(GDModBlocks.GOLDEN_FUNGUS);
        ItemGeneratedModel(GDModItems.GOLDEN_MUSHROOM_STEW);
        ItemGeneratedModel(GDModItems.GOLDEN_MUTTON);
        ItemGeneratedModel(GDModItems.GOLDEN_PORKCHOP);
        ItemGeneratedModel(GDModItems.GOLDEN_POTATO);
        ItemGeneratedModel(GDModItems.GOLDEN_PUFFERFISH);
        ItemGeneratedModel(GDModItems.GOLDEN_PUMPKIN_SEEDS);
        ItemGeneratedModel(GDModItems.GOLDEN_RABBIT);
        ItemGeneratedModel(GDModItems.GOLDEN_RABBIT_STEW);
        ItemGeneratedModel(GDModItems.ROTTEN_GOLDEN_FLESH);
        ItemGeneratedModel(GDModItems.GOLDEN_SALMON);
        ItemGeneratedModel(GDModItems.GOLDEN_SUGAR);
        ItemGeneratedModel(GDModItems.GOLDEN_SUGAR_CANE);
        ItemGeneratedModel(GDModItems.GOLDEN_TROPICAL_FISH);
        ItemGeneratedModel(GDModItems.GOLDEN_WART);
        ItemGeneratedModel(GDModItems.GOLDEN_WHEAT);
        ItemGeneratedModel(GDModItems.GOLDEN_WHEAT_SEEDS);


        //Farmer's Delight
        ItemGeneratedModel(GDModItems.GOLDEN_CABBAGE);
        ItemGeneratedModel(GDModItems.GOLDEN_TOMATO);
        ItemGeneratedModel(GDModItems.GOLDEN_ONION);
        ItemGeneratedModel(GDModItems.GOLDEN_RICE_PANICLE);
        ItemGeneratedModel(GDModItems.GOLDEN_RICE);
        ItemGeneratedModel(GDModItems.GOLDEN_CABBAGE_SEEDS);
        ItemGeneratedModel(GDModItems.GOLDEN_TOMATO_SEEDS);
        ItemGeneratedModel(GDModItems.ROTTEN_GOLDEN_TOMATO);
        ItemGeneratedModel(GDModItems.FRIED_GOLDEN_EGG);
        ItemGeneratedModel(GDModItems.GOLDEN_MILK_BOTTLE);
        MugModel(GDModItems.GOLDEN_HOT_COCOA);
        MugModel(GDModItems.GAPPLE_CIDER);
        MugModel(GDModItems.GOLDEN_MELON_JUICE);
        ItemGeneratedModel(GDModItems.GOLDEN_TOMATO_SAUCE);
        ItemGeneratedModel(GDModItems.GOLDEN_WHEAT_DOUGH);
        ItemGeneratedModel(GDModItems.RAW_GOLDEN_PASTA);
        ItemGeneratedModel(GDModItems.GOLDEN_PUMPKIN_SLICE);
        ItemGeneratedModel(GDModItems.GOLDEN_CABBAGE_LEAF);
        ItemGeneratedModel(GDModItems.MINCED_GOLDEN_BEEF);
        ItemGeneratedModel(GDModItems.GOLDEN_BEEF_PATTY);
        ItemGeneratedModel(GDModItems.GOLDEN_CHICKEN_CUTS);
        ItemGeneratedModel(GDModItems.COOKED_GOLDEN_CHICKEN_CUTS);
        ItemGeneratedModel(GDModItems.GOLDEN_BACON);
        ItemGeneratedModel(GDModItems.COOKED_GOLDEN_BACON);
        ItemGeneratedModel(GDModItems.GOLDEN_COD_SLICE);
        ItemGeneratedModel(GDModItems.COOKED_GOLDEN_COD_SLICE);
        ItemGeneratedModel(GDModItems.GOLDEN_SALMON_SLICE);
        ItemGeneratedModel(GDModItems.COOKED_GOLDEN_SALMON_SLICE);
        ItemGeneratedModel(GDModItems.GOLDEN_MUTTON_CHOPS);
        ItemGeneratedModel(GDModItems.COOKED_GOLDEN_MUTTON_CHOPS);
        HandheldModel(GDModItems.GOLDEN_HAM);
        HandheldModel(GDModItems.SMOKED_GOLDEN_HAM);
        ItemGeneratedModel(GDModItems.GOLDEN_PIE_CRUST);
        ItemGeneratedModel(GDModItems.GOLDEN_APPLE_PIE);
        ItemGeneratedModel(GDModItems.SWEET_GOLDEN_BERRY_CHEESECAKE);
        ItemGeneratedModel(GDModItems.GOLDEN_CHOCOLATE_PIE);
        ItemGeneratedModel(GDModItems.GOLDEN_CAKE_SLICE);
        ItemGeneratedModel(GDModItems.GOLDEN_APPLE_PIE_SLICE);
        ItemGeneratedModel(GDModItems.SWEET_GOLDEN_BERRY_CHEESECAKE_SLICE);
        ItemGeneratedModel(GDModItems.GOLDEN_CHOCOLATE_PIE_SLICE);
        ItemGeneratedModel(GDModItems.SWEET_GOLDEN_BERRY_COOKIE);
        ItemGeneratedModel(GDModItems.GOLDEN_HONEY_COOKIE);
        ItemGeneratedModel(GDModItems.GOLDEN_POPSICLE);
        ItemGeneratedModel(GDModItems.GOLDEN_GLOW_BERRY_CUSTARD);
        ItemGeneratedModel(GDModItems.GOLDEN_FRUIT_SALAD);
        ItemGeneratedModel(GDModItems.MIXED_GOLDEN_SALAD);
        ItemGeneratedModel(GDModItems.GOLDEN_NETHER_SALAD);
        HandheldModel(GDModItems.GOLDEN_BARBECUE_STICK);
        ItemGeneratedModel(GDModItems.GOLDEN_EGG_SANDWICH);
        ItemGeneratedModel(GDModItems.GOLDEN_CHICKEN_SANDWICH);
        ItemGeneratedModel(GDModItems.GOLDEN_HAMBURGER);
        ItemGeneratedModel(GDModItems.GOLDEN_BACON_SANDWICH);
        ItemGeneratedModel(GDModItems.GOLDEN_WRAP);
        ItemGeneratedModel(GDModItems.GUMPLINGS);
        ItemGeneratedModel(GDModItems.STUFFED_GOLDEN_POTATO);
        ItemGeneratedModel(GDModItems.GOLDEN_CABBAGE_ROLLS);
        ItemGeneratedModel(GDModItems.GOLDEN_SALMON_ROLL);
        ItemGeneratedModel(GDModItems.GOLDEN_COD_ROLL);
        ItemGeneratedModel(GDModItems.GOLDEN_KELP_ROLL);
        ItemGeneratedModel(GDModItems.GOLDEN_KELP_ROLL_SLICE);
        ItemGeneratedModel(GDModItems.COOKED_GOLDEN_RICE);
        ItemGeneratedModel(GDModItems.GOLDEN_BROTH);
        ItemGeneratedModel(GDModItems.GOLDEN_BEEF_STEW);
        ItemGeneratedModel(GDModItems.GOLDEN_CHICKEN_SOUP);
        ItemGeneratedModel(GDModItems.GOLDEN_VEGETABLE_SOUP);
        ItemGeneratedModel(GDModItems.GOLDEN_FISH_STEW);
        ItemGeneratedModel(GDModItems.FRIED_GOLDEN_RICE);
        ItemGeneratedModel(GDModItems.GOLDEN_PUMPKIN_SOUP);
        ItemGeneratedModel(GDModItems.GOLDEN_BAKED_COD_STEW);
        ItemGeneratedModel(GDModItems.GOLDEN_NOODLE_SOUP);
        ItemGeneratedModel(GDModItems.GOLDEN_BACON_AND_EGGS);
        ItemGeneratedModel(GDModItems.GOLDEN_PASTA_WITH_MEATBALLS);
        ItemGeneratedModel(GDModItems.GOLDEN_PASTA_WITH_MUTTON_CHOP);
        ItemGeneratedModel(GDModItems.GOLDEN_MUSHROOM_RICE);
        ItemGeneratedModel(GDModItems.ROASTED_GOLDEN_CHOPS);
        ItemGeneratedModel(GDModItems.GOLDEN_VEGETABLE_NOODLES);
        ItemGeneratedModel(GDModItems.GOLDEN_STEAK_AND_POTATOES);
        ItemGeneratedModel(GDModItems.GOLDEN_RATATOUILLE);
        ItemGeneratedModel(GDModItems.GOLDEN_INK_PASTA);
        ItemGeneratedModel(GDModItems.GRILLED_GOLDEN_SALMON);
        SpriteModel(GDModBlocks.GOLDEN_ROAST_CHICKEN_BLOCK);
        ItemGeneratedModel(GDModItems.GOLDEN_ROAST_CHICKEN);
        SpriteModel(GDModBlocks.STUFFED_GOLDEN_PUMPKIN_BLOCK);
        ItemGeneratedModel(GDModItems.STUFFED_GOLDEN_PUMPKIN);
        SpriteModel(GDModBlocks.GOLDEN_GLAZED_HAM_BLOCK);
        ItemGeneratedModel(GDModItems.GOLDEN_GLAZED_HAM);
        SpriteModel(GDModBlocks.GOLDEN_SHEPHERDS_PIE_BLOCK);
        ItemGeneratedModel(GDModItems.GOLDEN_SHEPHERDS_PIE);
        SpriteModel(GDModBlocks.GOLDEN_RICE_ROLL_MEDLEY_BLOCK);
        ItemGeneratedModel(GDModItems.GOLDEN_DOG_FOOD);
        ItemGeneratedModel(GDModItems.GOLDEN_HORSE_FEED);
    }


    private ItemModelBuilder ItemGeneratedModel(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(GolDelight.MOD_ID, "item/" + item.getId().getPath()));
    }
    private ItemModelBuilder MugModel(RegistryObject<Item> mug) {
        return withExistingParent(mug.getId().getPath(),
                new ResourceLocation(GolDelight.MOD_ID, "item/mug")).texture("layer0",
                new ResourceLocation(GolDelight.MOD_ID, "item/" + mug.getId().getPath()));
    }

    private ItemModelBuilder HandheldModel(RegistryObject<Item> hand) {
        return withExistingParent(hand.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(GolDelight.MOD_ID, "item/" + hand.getId().getPath()));
    }

    private ItemModelBuilder SpriteModel(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(GolDelight.MOD_ID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder PlantModel(RegistryObject<Block> plant) {
        return withExistingParent(plant.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(GolDelight.MOD_ID, "block/" + plant.getId().getPath()));
    }
}
