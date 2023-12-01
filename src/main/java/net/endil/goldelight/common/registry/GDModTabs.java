package net.endil.goldelight.common.registry;

import accieo.midas.hunger.registry.ItemRegistry;
import net.endil.goldelight.GolDelight;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class GDModTabs {
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GolDelight.MOD_ID);

    public static final RegistryObject<CreativeModeTab> GOLDELIHT_TAB = TABS.register("goldelight_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(GDModBlocks.NETHER_BRICK_STOVE.get()))
                    .title(Component.translatable("itemgroup.goldelight"))
                    .displayItems(((pParameters, pOutput) -> {
                        //Minecraft
                        pOutput.accept(Items.GOLDEN_APPLE);
                        pOutput.accept(Items.GOLDEN_CARROT);
                        pOutput.accept(Items.ENCHANTED_GOLDEN_APPLE);

                        //GolDelight Items
                        pOutput.accept(GDModItems.GOLDEN_BEEF.get());
                        pOutput.accept(GDModItems.GOLDEN_BONE.get());
                        pOutput.accept(GDModItems.GOLDEN_MEAL.get());
                        pOutput.accept(GDModItems.GOLDEN_BREAD.get());
                        pOutput.accept(GDModItems.GOLDEN_CAKE.get());
                        pOutput.accept(GDModItems.GOLDEN_CHICKEN.get());
                        pOutput.accept(GDModItems.GOLDEN_COCOA_BEANS.get());
                        pOutput.accept(GDModItems.GOLDEN_COD.get());
                        pOutput.accept(GDModItems.GOLDEN_COOKIE.get());
                        pOutput.accept(GDModItems.GOLDEN_EGG.get());
                        pOutput.accept(GDModItems.GOLDEN_GLOW_BERRIES.get());
                        pOutput.accept(GDModItems.GOLDEN_HONEY_BOTTLE.get());
                        pOutput.accept(GDModItems.GOLDEN_INK_SAC.get());
                        pOutput.accept(GDModItems.GOLDEN_MELON_SEEDS.get());
                        pOutput.accept(GDModItems.GOLDEN_MELON_SLICE.get());
                        pOutput.accept(GDModItems.GOLDEN_MILK_BUCKET.get());
                        pOutput.accept(GDModItems.GOLDEN_MUSHROOM_STEW.get());
                        pOutput.accept(GDModItems.GOLDEN_MUTTON.get());
                        pOutput.accept(GDModItems.GOLDEN_PORKCHOP.get());
                        pOutput.accept(GDModItems.GOLDEN_POTATO.get());
                        pOutput.accept(GDModItems.GOLDEN_PUFFERFISH.get());
                        pOutput.accept(GDModItems.GOLDEN_PUMPKIN_SEEDS.get());
                        pOutput.accept(GDModItems.GOLDEN_RABBIT.get());
                        pOutput.accept(GDModItems.GOLDEN_RABBIT_STEW.get());
                        pOutput.accept(GDModItems.ROTTEN_GOLDEN_FLESH.get());
                        pOutput.accept(GDModItems.GOLDEN_SALMON.get());
                        pOutput.accept(GDModItems.GOLDEN_SUGAR.get());
                        pOutput.accept(GDModItems.GOLDEN_SUGAR_CANE.get());
                        pOutput.accept(GDModItems.GOLDEN_TROPICAL_FISH.get());
                        // pOutput.accept(GDModItems.GOLDEN_WART.get());
                        pOutput.accept(GDModItems.GOLDEN_WHEAT.get());
                        pOutput.accept(GDModItems.GOLDEN_WHEAT_SEEDS.get());

                        //GolDelight Blocks
                        pOutput.accept(GDModBlocks.GOL_D_LANTERN.get());
                        // pOutput.accept(GDModBlocks.GOLDEN_CACTUS.get());
                        pOutput.accept(GDModBlocks.GOLDEN_CARVED_PUMPKIN.get());
                        pOutput.accept(GDModBlocks.GOLDEN_CHORUS_FLOWER.get());
                        pOutput.accept(GDModBlocks.GOLDEN_CHORUS_PLANT.get());
                        pOutput.accept(GDModBlocks.GOLDEN_HAY_BLOCK.get());
                        pOutput.accept(GDModBlocks.GOLDEN_MELON.get());
                        pOutput.accept(GDModBlocks.GOLDEN_MUSHROOM.get());
                        pOutput.accept(GDModBlocks.GOLDEN_FUNGUS.get());
                        /*
                         pOutput.accept(GDModBlocks.GOLDEN_MUSHROOM_BLOCK.get());
                         pOutput.accept(GDModBlocks.GOLDEN_MUSHROOM_STEM.get());
                        */
                        pOutput.accept(GDModBlocks.GOLDEN_PUMPKIN.get());
                        // pOutput.accept(GDModBlocks.GOLDEN_WART_BLOCK.get());

                        //Farmer's Delight Items
                        // pOutput.accept(GDModItems.GOLDEN_COOKING_POT.get());
                        pOutput.accept(GDModItems.GOLDEN_MUSHROOM_COLONY.get());
                        pOutput.accept(GDModItems.GOLDEN_CABBAGE.get());
                        pOutput.accept(GDModItems.GOLDEN_TOMATO.get());
                        pOutput.accept(GDModItems.GOLDEN_ONION.get());
                        pOutput.accept(GDModItems.GOLDEN_RICE_PANICLE.get());
                        pOutput.accept(GDModItems.GOLDEN_RICE.get());
                        pOutput.accept(GDModItems.GOLDEN_CABBAGE_SEEDS.get());
                        pOutput.accept(GDModItems.GOLDEN_TOMATO_SEEDS.get());
                        pOutput.accept(GDModItems.ROTTEN_GOLDEN_TOMATO.get());
                        pOutput.accept(GDModItems.FRIED_GOLDEN_EGG.get());
                        pOutput.accept(GDModItems.GOLDEN_MILK_BOTTLE.get());
                        pOutput.accept(GDModItems.GOLDEN_HOT_COCOA.get());
                        pOutput.accept(GDModItems.GAPPLE_CIDER.get());
                        pOutput.accept(GDModItems.GOLDEN_MELON_JUICE.get());
                        pOutput.accept(GDModItems.GOLDEN_TOMATO_SAUCE.get());
                        pOutput.accept(GDModItems.GOLDEN_WHEAT_DOUGH.get());
                        pOutput.accept(GDModItems.RAW_GOLDEN_PASTA.get());
                        pOutput.accept(GDModItems.GOLDEN_PUMPKIN_SLICE.get());
                        pOutput.accept(GDModItems.GOLDEN_CABBAGE_LEAF.get());
                        pOutput.accept(GDModItems.MINCED_GOLDEN_BEEF.get());
                        pOutput.accept(GDModItems.GOLDEN_BEEF_PATTY.get());
                        pOutput.accept(GDModItems.GOLDEN_CHICKEN_CUTS.get());
                        pOutput.accept(GDModItems.COOKED_GOLDEN_CHICKEN_CUTS.get());
                        pOutput.accept(GDModItems.GOLDEN_BACON.get());
                        pOutput.accept(GDModItems.COOKED_GOLDEN_BACON.get());
                        pOutput.accept(GDModItems.GOLDEN_COD_SLICE.get());
                        pOutput.accept(GDModItems.COOKED_GOLDEN_COD_SLICE.get());
                        pOutput.accept(GDModItems.GOLDEN_SALMON_SLICE.get());
                        pOutput.accept(GDModItems.COOKED_GOLDEN_SALMON_SLICE.get());
                        pOutput.accept(GDModItems.GOLDEN_MUTTON_CHOPS.get());
                        pOutput.accept(GDModItems.COOKED_GOLDEN_MUTTON_CHOPS.get());
                        pOutput.accept(GDModItems.GOLDEN_HAM.get());
                        pOutput.accept(GDModItems.SMOKED_GOLDEN_HAM.get());
                        pOutput.accept(GDModItems.GOLDEN_PIE_CRUST.get());
                        pOutput.accept(GDModItems.GOLDEN_APPLE_PIE.get());
                        pOutput.accept(GDModItems.SWEET_GOLDEN_BERRY_CHEESECAKE.get());
                        pOutput.accept(GDModItems.GOLDEN_CHOCOLATE_PIE.get());
                        pOutput.accept(GDModItems.GOLDEN_CAKE_SLICE.get());
                        pOutput.accept(GDModItems.GOLDEN_APPLE_PIE_SLICE.get());
                        pOutput.accept(GDModItems.SWEET_GOLDEN_BERRY_CHEESECAKE_SLICE.get());
                        pOutput.accept(GDModItems.GOLDEN_CHOCOLATE_PIE_SLICE.get());
                        pOutput.accept(GDModItems.SWEET_GOLDEN_BERRY_COOKIE.get());
                        pOutput.accept(GDModItems.GOLDEN_HONEY_COOKIE.get());
                        pOutput.accept(GDModItems.GOLDEN_POPSICLE.get());
                        pOutput.accept(GDModItems.GOLDEN_GLOW_BERRY_CUSTARD.get());
                        pOutput.accept(GDModItems.GOLDEN_FRUIT_SALAD.get());
                        pOutput.accept(GDModItems.MIXED_GOLDEN_SALAD.get());
                        pOutput.accept(GDModItems.GOLDEN_NETHER_SALAD.get());
                        pOutput.accept(GDModItems.GOLDEN_BARBECUE_STICK.get());
                        pOutput.accept(GDModItems.GOLDEN_EGG_SANDWICH.get());
                        pOutput.accept(GDModItems.GOLDEN_CHICKEN_SANDWICH.get());
                        pOutput.accept(GDModItems.GOLDEN_HAMBURGER.get());
                        pOutput.accept(GDModItems.GOLDEN_BACON_SANDWICH.get());
                        pOutput.accept(GDModItems.GOLDEN_WRAP.get());
                        pOutput.accept(GDModItems.GUMPLINGS.get());
                        pOutput.accept(GDModItems.STUFFED_GOLDEN_POTATO.get());
                        pOutput.accept(GDModItems.GOLDEN_CABBAGE_ROLLS.get());
                        pOutput.accept(GDModItems.GOLDEN_SALMON_ROLL.get());
                        pOutput.accept(GDModItems.GOLDEN_COD_ROLL.get());
                        pOutput.accept(GDModItems.GOLDEN_KELP_ROLL.get());
                        pOutput.accept(GDModItems.GOLDEN_KELP_ROLL_SLICE.get());
                        pOutput.accept(GDModItems.COOKED_GOLDEN_RICE.get());
                        pOutput.accept(GDModItems.GOLDEN_BROTH.get());
                        pOutput.accept(GDModItems.GOLDEN_BEEF_STEW.get());
                        pOutput.accept(GDModItems.GOLDEN_CHICKEN_SOUP.get());
                        pOutput.accept(GDModItems.GOLDEN_VEGETABLE_SOUP.get());
                        pOutput.accept(GDModItems.GOLDEN_FISH_STEW.get());
                        pOutput.accept(GDModItems.FRIED_GOLDEN_RICE.get());
                        pOutput.accept(GDModItems.GOLDEN_PUMPKIN_SOUP.get());
                        pOutput.accept(GDModItems.GOLDEN_BAKED_COD_STEW.get());
                        pOutput.accept(GDModItems.GOLDEN_NOODLE_SOUP.get());
                        pOutput.accept(GDModItems.GOLDEN_BACON_AND_EGGS.get());
                        pOutput.accept(GDModItems.GOLDEN_PASTA_WITH_MEATBALLS.get());
                        pOutput.accept(GDModItems.GOLDEN_PASTA_WITH_MUTTON_CHOP.get());
                        pOutput.accept(GDModItems.GOLDEN_MUSHROOM_RICE.get());
                        pOutput.accept(GDModItems.ROASTED_GOLDEN_CHOPS.get());
                        pOutput.accept(GDModItems.GOLDEN_VEGETABLE_NOODLES.get());
                        pOutput.accept(GDModItems.GOLDEN_STEAK_AND_POTATOES.get());
                        pOutput.accept(GDModItems.GOLDEN_RATATOUILLE.get());
                        pOutput.accept(GDModItems.GOLDEN_INK_PASTA.get());
                        pOutput.accept(GDModItems.GRILLED_GOLDEN_SALMON.get());
                        pOutput.accept(GDModItems.GOLDEN_ROAST_CHICKEN_BLOCK.get());
                        pOutput.accept(GDModItems.GOLDEN_ROAST_CHICKEN.get());
                        pOutput.accept(GDModItems.STUFFED_GOLDEN_PUMPKIN_BLOCK.get());
                        pOutput.accept(GDModItems.STUFFED_GOLDEN_PUMPKIN.get());
                        pOutput.accept(GDModItems.GOLDEN_GLAZED_HAM_BLOCK.get());
                        pOutput.accept(GDModItems.GOLDEN_GLAZED_HAM.get());
                        pOutput.accept(GDModItems.GOLDEN_SHEPHERDS_PIE_BLOCK.get());
                        pOutput.accept(GDModItems.GOLDEN_SHEPHERDS_PIE.get());
                        pOutput.accept(GDModItems.GOLDEN_RICE_ROLL_MEDLEY_BLOCK.get());
                        pOutput.accept(GDModItems.GOLDEN_DOG_FOOD.get());
                        pOutput.accept(GDModItems.GOLDEN_HORSE_FEED.get());


                        //FD Blocks
                        pOutput.accept(GDModBlocks.GOLDEN_CARROT_CRATE.get());
                        pOutput.accept(GDModBlocks.GOLDEN_POTATO_CRATE.get());
                        pOutput.accept(GDModBlocks.GOLDEN_BEETROOT_CRATE.get());
                        pOutput.accept(GDModBlocks.GOLDEN_CABBAGE_CRATE.get());
                        pOutput.accept(GDModBlocks.GOLDEN_TOMATO_CRATE.get());
                        pOutput.accept(GDModBlocks.GOLDEN_ONION_CRATE.get());
                        pOutput.accept(GDModBlocks.GOLDEN_RICE_BALE.get());
                        pOutput.accept(GDModBlocks.GOLDEN_RICE_BAG.get());
                        // pOutput.accept(GDModBlocks.NETHER_BRICK_STOVE.get());
                        pOutput.accept(GDModBlocks.GOLDEN_SOIL.get());
                        pOutput.accept(GDModBlocks.GOLDEN_SOIL_FARMLAND.get());
                        pOutput.accept(GDModBlocks.GOLDEN_COMPOST.get());


                        //MidasHunger
                        pOutput.accept(ItemRegistry.BAKED_GOLDEN_POTATO.get());
                        pOutput.accept(ItemRegistry.COOKED_GOLDEN_BEEF.get());
                        pOutput.accept(ItemRegistry.COOKED_GOLDEN_CHICKEN.get());
                        pOutput.accept(ItemRegistry.COOKED_GOLDEN_COD.get());
                        pOutput.accept(ItemRegistry.COOKED_GOLDEN_MUTTON.get());
                        pOutput.accept(ItemRegistry.COOKED_GOLDEN_PORKCHOP.get());
                        pOutput.accept(ItemRegistry.COOKED_GOLDEN_RABBIT.get());
                        pOutput.accept(ItemRegistry.COOKED_GOLDEN_SALMON.get());
                        pOutput.accept(ItemRegistry.DRIED_GOLDEN_KELP.get());
                        pOutput.accept(ItemRegistry.DRIED_GOLDEN_KELP_BLOCK.get());
                        pOutput.accept(ItemRegistry.ENCHANTED_GOLDEN_CARROT.get());
                        pOutput.accept(ItemRegistry.GOLDEN_BEETROOT.get());
                        pOutput.accept(ItemRegistry.GOLDEN_BEETROOT_SEEDS.get());
                        pOutput.accept(ItemRegistry.GOLDEN_BEETROOT_SOUP.get());
                        pOutput.accept(ItemRegistry.GOLDEN_CHORUS_FRUIT.get());
                        pOutput.accept(ItemRegistry.GOLDEN_KELP.get());
                        pOutput.accept(ItemRegistry.GOLDEN_PUMPKIN_PIE.get());
                        pOutput.accept(ItemRegistry.GOLDEN_TURTLE_EGG.get());
                        pOutput.accept(ItemRegistry.POISONOUS_GOLDEN_POTATO.get());
                        pOutput.accept(ItemRegistry.SWEET_GOLDEN_BERRIES.get());
                    }))
                    .build());

    public static void register(IEventBus eventBus) {
        TABS.register(eventBus);
    }
}
