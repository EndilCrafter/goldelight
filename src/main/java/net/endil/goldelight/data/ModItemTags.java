package net.endil.goldelight.data;

import accieo.midas.hunger.registry.ItemRegistry;
import net.endil.goldelight.GolDelight;
import net.endil.goldelight.common.registry.GDCompatTags;
import net.endil.goldelight.common.registry.GDModBlocks;
import net.endil.goldelight.common.registry.GDModItems;
import net.endil.goldelight.common.registry.GDModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.ForgeTags;
import vectorwing.farmersdelight.common.tag.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTags extends ItemTagsProvider {
    public ModItemTags(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_,
                       CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, GolDelight.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.registerGDModTags();
        this.registerMinecraftTags();
        this.registerFDModTags();
        this.registerForgeTags();
        this.registerCompatTags();
    }
    private void registerGDModTags() {
        //Minecraft
        this.tag(GDModTags.Items.GOLDEN_FISHES).addTag(GDModTags.Items.RAW_GOLDEN_FISHES).addTag(GDModTags.Items.COOKED_GOLDEN_FISHES);
        //Forge
        this.tag(GDModTags.Items.GOLDEN_CROPS)
                .addTag(GDModTags.Items.GOLDEN_CROPS_BEETROOT).addTag(GDModTags.Items.GOLDEN_CROPS_CARROT).addTag(GDModTags.Items.GOLDEN_CROPS_WART)
                .addTag(GDModTags.Items.GOLDEN_CROPS_POTATO).addTag(GDModTags.Items.GOLDEN_CROPS_WHEAT).addTag(GDModTags.Items.GOLDEN_CROPS_CABBAGE)
                .addTag(GDModTags.Items.GOLDEN_CROPS_ONION).addTag(GDModTags.Items.GOLDEN_CROPS_RICE).addTag(GDModTags.Items.GOLDEN_CROPS_TOMATO);
        this.tag(GDModTags.Items.GOLDEN_CROPS_BEETROOT).add(ItemRegistry.GOLDEN_BEETROOT.get());
        this.tag(GDModTags.Items.GOLDEN_CROPS_CARROT).add(Items.GOLDEN_CARROT);
        this.tag(GDModTags.Items.GOLDEN_CROPS_WART).add(GDModItems.GOLDEN_WART.get());
        this.tag(GDModTags.Items.GOLDEN_CROPS_POTATO).add(GDModItems.GOLDEN_POTATO.get());
        this.tag(GDModTags.Items.GOLDEN_CROPS_WHEAT).add(GDModItems.GOLDEN_WHEAT.get());
        this.tag(GDModTags.Items.GOLDEN_EGGS).add(GDModItems.GOLDEN_EGG.get()).add(ItemRegistry.GOLDEN_TURTLE_EGG.get());
        this.tag(GDModTags.Items.GOLDEN_MUSHROOMS).add(GDModBlocks.GOLDEN_MUSHROOM.get().asItem());
        this.tag(GDModTags.Items.GOLDEN_SEEDS)
                .addTag(GDModTags.Items.GOLDEN_SEEDS_BEETROOT).addTag(GDModTags.Items.GOLDEN_SEEDS_MELON).addTag(GDModTags.Items.GOLDEN_SEEDS_PUMPKIN)
                .addTag(GDModTags.Items.GOLDEN_SEEDS_WHEAT).addTag(GDModTags.Items.GOLDEN_SEEDS_CABBAGE).addTag(GDModTags.Items.GOLDEN_SEEDS_RICE).addTag(GDModTags.Items.GOLDEN_SEEDS_TOMATO);
        this.tag(GDModTags.Items.GOLDEN_SEEDS_BEETROOT).add(ItemRegistry.GOLDEN_BEETROOT_SEEDS.get());
        this.tag(GDModTags.Items.GOLDEN_SEEDS_MELON).add(GDModItems.GOLDEN_MELON_SEEDS.get());
        this.tag(GDModTags.Items.GOLDEN_SEEDS_PUMPKIN).add(GDModItems.GOLDEN_PUMPKIN_SEEDS.get());
        this.tag(GDModTags.Items.GOLDEN_SEEDS_WHEAT).add(GDModItems.GOLDEN_WHEAT_SEEDS.get());
        //Farmer's Delight
        this.tag(GDModTags.Items.GOLDEN_WOLF_PREY)
                .add(GDModItems.GOLDEN_RABBIT.get()).addTag(GDModTags.Items.RAW_GOLDEN_CHICKEN).addTag(GDModTags.Items.RAW_GOLDEN_MUTTON);
        this.tag(GDModTags.Items.GOLDEN_CABBAGE_ROLL_INGREDIENTS)
                .addTag(GDModTags.Items.RAW_GOLDEN_PORK).addTag(GDModTags.Items.RAW_GOLDEN_FISHES).addTag(GDModTags.Items.RAW_GOLDEN_CHICKEN)
                .addTag(GDModTags.Items.RAW_GOLDEN_BEEF).addTag(GDModTags.Items.RAW_GOLDEN_MUTTON).addTag(GDModTags.Items.GOLDEN_EGGS).addTag(GDModTags.Items.GOLDEN_MUSHROOMS)
                .add(Items.GOLDEN_CARROT, GDModItems.GOLDEN_POTATO.get(), ItemRegistry.GOLDEN_BEETROOT.get());
        //Forge by Farmer's Delight
        this.tag(GDModTags.Items.GOLDEN_BERRIES).add(ItemRegistry.SWEET_GOLDEN_BERRIES.get(), GDModItems.GOLDEN_GLOW_BERRIES.get());
        this.tag(GDModTags.Items.GOLDEN_BREAD).addTag(GDModTags.Items.GOLDEN_BREAD_WHEAT);
        this.tag(GDModTags.Items.GOLDEN_BREAD_WHEAT).add(GDModItems.GOLDEN_BREAD.get());
        this.tag(GDModTags.Items.COOKED_GOLDEN_BACON).add(GDModItems.COOKED_GOLDEN_BACON.get());
        this.tag(GDModTags.Items.COOKED_GOLDEN_BEEF).add(ItemRegistry.COOKED_GOLDEN_BEEF.get(), GDModItems.GOLDEN_BEEF_PATTY.get());
        this.tag(GDModTags.Items.COOKED_GOLDEN_CHICKEN).add(ItemRegistry.COOKED_GOLDEN_CHICKEN.get(), GDModItems.COOKED_GOLDEN_CHICKEN_CUTS.get());
        this.tag(GDModTags.Items.COOKED_GOLDEN_PORK).add(ItemRegistry.COOKED_GOLDEN_PORKCHOP.get(), GDModItems.GOLDEN_BACON.get());
        this.tag(GDModTags.Items.COOKED_GOLDEN_MUTTON).add(ItemRegistry.COOKED_GOLDEN_MUTTON.get(), GDModItems.COOKED_GOLDEN_MUTTON_CHOPS.get());
        this.tag(GDModTags.Items.COOKED_GOLDEN_EGGS).add(GDModItems.FRIED_GOLDEN_EGG.get());
        this.tag(GDModTags.Items.COOKED_GOLDEN_FISHES).addTag(GDModTags.Items.COOKED_GOLDEN_FISHES_COD).addTag(GDModTags.Items.COOKED_GOLDEN_FISHES_SALMON);
        this.tag(GDModTags.Items.COOKED_GOLDEN_FISHES_COD).add(ItemRegistry.COOKED_GOLDEN_COD.get(), GDModItems.COOKED_GOLDEN_COD_SLICE.get());
        this.tag(GDModTags.Items.COOKED_GOLDEN_FISHES_SALMON).add(ItemRegistry.COOKED_GOLDEN_SALMON.get(), GDModItems.COOKED_GOLDEN_SALMON_SLICE.get());
        this.tag(GDModTags.Items.GOLDEN_CROPS_CABBAGE).add(GDModItems.GOLDEN_CABBAGE.get(), GDModItems.GOLDEN_CABBAGE_LEAF.get());
        this.tag(GDModTags.Items.GOLDEN_CROPS_ONION).add(GDModItems.GOLDEN_ONION.get());
        this.tag(GDModTags.Items.GOLDEN_CROPS_RICE).add(GDModItems.GOLDEN_RICE.get());
        this.tag(GDModTags.Items.GOLDEN_CROPS_TOMATO).add(GDModItems.GOLDEN_TOMATO.get());
        this.tag(GDModTags.Items.GOLDEN_DOUGH).addTag(GDModTags.Items.GOLDEN_DOUGH_WHEAT);
        this.tag(GDModTags.Items.GOLDEN_DOUGH_WHEAT).add(GDModItems.GOLDEN_WHEAT_DOUGH.get());
        this.tag(GDModTags.Items.GOLDEN_GRAIN).addTag(GDModTags.Items.GOLDEN_GRAIN_WHEAT).addTag(GDModTags.Items.GOLDEN_GRAIN_RICE);
        this.tag(GDModTags.Items.GOLDEN_GRAIN_WHEAT).add(GDModItems.GOLDEN_WHEAT.get());
        this.tag(GDModTags.Items.GOLDEN_GRAIN_RICE).add(GDModItems.GOLDEN_RICE.get());
        this.tag(GDModTags.Items.GOLDEN_MILK).addTag(GDModTags.Items.GOLDEN_MILK_BUCKET).addTag(GDModTags.Items.GOLDEN_MILK_BOTTLE);
        this.tag(GDModTags.Items.GOLDEN_MILK_BUCKET).add(GDModItems.GOLDEN_MILK_BUCKET.get());
        this.tag(GDModTags.Items.GOLDEN_MILK_BOTTLE).add(GDModItems.GOLDEN_MILK_BOTTLE.get());
        this.tag(GDModTags.Items.GOLDEN_PASTA).addTag(GDModTags.Items.GOLDEN_PASTA_RAW_PASTA);
        this.tag(GDModTags.Items.GOLDEN_PASTA_RAW_PASTA).add(GDModItems.RAW_GOLDEN_PASTA.get());
        this.tag(GDModTags.Items.RAW_GOLDEN_BACON).add(GDModItems.GOLDEN_BACON.get());
        this.tag(GDModTags.Items.RAW_GOLDEN_BEEF).add(GDModItems.GOLDEN_BEEF.get(), GDModItems.MINCED_GOLDEN_BEEF.get());
        this.tag(GDModTags.Items.RAW_GOLDEN_CHICKEN).add(GDModItems.GOLDEN_CHICKEN.get(), GDModItems.GOLDEN_CHICKEN_CUTS.get());
        this.tag(GDModTags.Items.RAW_GOLDEN_PORK).add(GDModItems.GOLDEN_PORKCHOP.get(), GDModItems.GOLDEN_BACON.get());
        this.tag(GDModTags.Items.RAW_GOLDEN_MUTTON).add(GDModItems.GOLDEN_MUTTON.get(), GDModItems.GOLDEN_MUTTON_CHOPS.get());
        this.tag(GDModTags.Items.RAW_GOLDEN_FISHES)
                .addTag(GDModTags.Items.RAW_GOLDEN_FISHES_COD).addTag(GDModTags.Items.RAW_GOLDEN_FISHES_SALMON).addTag(GDModTags.Items.RAW_GOLDEN_FISHES_TROPICAL);
        this.tag(GDModTags.Items.RAW_GOLDEN_FISHES_COD).add(GDModItems.GOLDEN_COD.get(), GDModItems.GOLDEN_COD_SLICE.get());
        this.tag(GDModTags.Items.RAW_GOLDEN_FISHES_SALMON).add(GDModItems.GOLDEN_SALMON.get(), GDModItems.GOLDEN_SALMON_SLICE.get());
        this.tag(GDModTags.Items.RAW_GOLDEN_FISHES_TROPICAL).add(GDModItems.GOLDEN_TROPICAL_FISH.get());
        this.tag(GDModTags.Items.GOLDEN_SALAD_INGREDIENTS).addTag(GDModTags.Items.GOLDEN_SALAD_INGREDIENTS_CABBAGE);
        this.tag(GDModTags.Items.GOLDEN_SALAD_INGREDIENTS_CABBAGE).add(GDModItems.GOLDEN_CABBAGE.get(), GDModItems.GOLDEN_CABBAGE_LEAF.get());
        this.tag(GDModTags.Items.GOLDEN_SEEDS_CABBAGE).add(GDModItems.GOLDEN_CABBAGE_SEEDS.get());
        this.tag(GDModTags.Items.GOLDEN_SEEDS_RICE).add(GDModItems.GOLDEN_RICE.get());
        this.tag(GDModTags.Items.GOLDEN_SEEDS_TOMATO).add(GDModItems.GOLDEN_TOMATO_SEEDS.get());
        this.tag(GDModTags.Items.GOLDEN_VEGETABLES)
                .addTag(GDModTags.Items.GOLDEN_VEGETABLES_BEETROOT).addTag(GDModTags.Items.GOLDEN_VEGETABLES_CARROT).addTag(GDModTags.Items.GOLDEN_VEGETABLES_ONION)
                .addTag(GDModTags.Items.GOLDEN_VEGETABLES_POTATO).addTag(GDModTags.Items.GOLDEN_VEGETABLES_TOMATO);
        this.tag(GDModTags.Items.GOLDEN_VEGETABLES_BEETROOT).add(ItemRegistry.GOLDEN_BEETROOT.get());
        this.tag(GDModTags.Items.GOLDEN_VEGETABLES_CARROT).add(Items.GOLDEN_CARROT);
        this.tag(GDModTags.Items.GOLDEN_VEGETABLES_ONION).add(GDModItems.GOLDEN_ONION.get());
        this.tag(GDModTags.Items.GOLDEN_VEGETABLES_POTATO).add(GDModItems.GOLDEN_POTATO.get());
        this.tag(GDModTags.Items.GOLDEN_VEGETABLES_TOMATO).add(GDModItems.GOLDEN_TOMATO.get());
    }
    private void registerMinecraftTags() {
        this.tag(ItemTags.PIGLIN_LOVED)
                .addTag(GDModTags.Items.GOLDEN_CROPS);
        this.tag(ItemTags.PIGLIN_FOOD)
                .addTag(ForgeTags.RAW_PORK).addTag(ForgeTags.COOKED_PORK).addTag(ForgeTags.RAW_BACON).addTag(ForgeTags.COOKED_BACON)
                .add(ModItems.HAM.get())
                .add(ModItems.SMOKED_HAM.get())
                .add(GDModItems.GOLDEN_HAM.get())
                .add(GDModItems.SMOKED_GOLDEN_HAM.get());
        this.tag(ItemTags.FOX_FOOD).add(GDModItems.GOLDEN_GLOW_BERRIES.get());
        this.tag(ItemTags.FISHES).addTag(GDModTags.Items.GOLDEN_FISHES);

    }
    private void registerFDModTags() {
        this.tag(ModTags.WOLF_PREY).addTag(GDModTags.Items.GOLDEN_WOLF_PREY);
        this.tag(ForgeTags.BERRIES).addTag(GDModTags.Items.GOLDEN_BERRIES);
        this.tag(ForgeTags.BREAD).addTag(GDModTags.Items.GOLDEN_BREAD);
        this.tag(ForgeTags.BREAD_WHEAT).addTag(GDModTags.Items.GOLDEN_BREAD_WHEAT);
        this.tag(ForgeTags.COOKED_BACON).addTag(GDModTags.Items.COOKED_GOLDEN_BACON);
        this.tag(ForgeTags.COOKED_BEEF).addTag(GDModTags.Items.COOKED_GOLDEN_BEEF);
        this.tag(ForgeTags.COOKED_CHICKEN).addTag(GDModTags.Items.COOKED_GOLDEN_CHICKEN);
        this.tag(ForgeTags.COOKED_PORK).addTag(GDModTags.Items.COOKED_GOLDEN_PORK);
        this.tag(ForgeTags.COOKED_MUTTON).addTag(GDModTags.Items.COOKED_GOLDEN_MUTTON);
        this.tag(ForgeTags.EGGS).addTag(GDModTags.Items.COOKED_GOLDEN_EGGS);
        this.tag(ForgeTags.COOKED_FISHES).addTag(GDModTags.Items.COOKED_GOLDEN_FISHES);
        this.tag(ForgeTags.COOKED_FISHES_COD).addTag(GDModTags.Items.COOKED_GOLDEN_FISHES_COD);
        this.tag(ForgeTags.COOKED_FISHES_SALMON).addTag(GDModTags.Items.COOKED_GOLDEN_FISHES_SALMON);
        this.tag(ForgeTags.CROPS_CABBAGE).addTag(GDModTags.Items.GOLDEN_CROPS_CABBAGE);
        this.tag(ForgeTags.CROPS_ONION).addTag(GDModTags.Items.GOLDEN_CROPS_ONION);
        this.tag(ForgeTags.CROPS_RICE).addTag(GDModTags.Items.GOLDEN_CROPS_RICE);
        this.tag(ForgeTags.CROPS_TOMATO).addTag(GDModTags.Items.GOLDEN_CROPS_TOMATO);
        this.tag(ForgeTags.DOUGH).addTag(GDModTags.Items.GOLDEN_DOUGH);
        this.tag(ForgeTags.DOUGH_WHEAT).addTag(GDModTags.Items.GOLDEN_DOUGH_WHEAT);
        this.tag(ForgeTags.GRAIN).addTag(GDModTags.Items.GOLDEN_GRAIN);
        this.tag(ForgeTags.GRAIN_WHEAT).addTag(GDModTags.Items.GOLDEN_GRAIN_WHEAT);
        this.tag(ForgeTags.GRAIN_RICE).addTag(GDModTags.Items.GOLDEN_GRAIN_RICE);
        this.tag(ForgeTags.MILK).addTag(GDModTags.Items.GOLDEN_MILK);
        this.tag(ForgeTags.MILK_BUCKET).addTag(GDModTags.Items.GOLDEN_MILK_BUCKET);
        this.tag(ForgeTags.MILK_BOTTLE).addTag(GDModTags.Items.GOLDEN_MILK_BOTTLE);
        this.tag(ForgeTags.PASTA).addTag(GDModTags.Items.GOLDEN_PASTA);
        this.tag(ForgeTags.PASTA_RAW_PASTA).addTag(GDModTags.Items.GOLDEN_PASTA_RAW_PASTA);
        this.tag(ForgeTags.RAW_BACON).addTag(GDModTags.Items.RAW_GOLDEN_BACON);
        this.tag(ForgeTags.RAW_BEEF).addTag(GDModTags.Items.RAW_GOLDEN_BEEF);
        this.tag(ForgeTags.RAW_CHICKEN).addTag(GDModTags.Items.RAW_GOLDEN_CHICKEN);
        this.tag(ForgeTags.RAW_PORK).addTag(GDModTags.Items.RAW_GOLDEN_PORK);
        this.tag(ForgeTags.RAW_MUTTON).addTag(GDModTags.Items.RAW_GOLDEN_MUTTON);
        this.tag(ForgeTags.RAW_FISHES).addTag(GDModTags.Items.RAW_GOLDEN_FISHES);
        this.tag(ForgeTags.RAW_FISHES_COD).addTag(GDModTags.Items.RAW_GOLDEN_FISHES_COD);
        this.tag(ForgeTags.RAW_FISHES_SALMON).addTag(GDModTags.Items.RAW_GOLDEN_FISHES_SALMON);
        this.tag(ForgeTags.RAW_FISHES_TROPICAL).addTag(GDModTags.Items.RAW_GOLDEN_FISHES_TROPICAL);
        this.tag(ForgeTags.SALAD_INGREDIENTS).addTag(GDModTags.Items.GOLDEN_SALAD_INGREDIENTS);
        this.tag(ForgeTags.SALAD_INGREDIENTS_CABBAGE).addTag(GDModTags.Items.GOLDEN_SALAD_INGREDIENTS_CABBAGE);
        this.tag(ForgeTags.SEEDS_CABBAGE).addTag(GDModTags.Items.GOLDEN_SEEDS_CABBAGE);
        this.tag(ForgeTags.SEEDS_RICE).addTag(GDModTags.Items.GOLDEN_SEEDS_RICE);
        this.tag(ForgeTags.SEEDS_TOMATO).addTag(GDModTags.Items.GOLDEN_SEEDS_TOMATO);
        this.tag(ForgeTags.VEGETABLES).addTag(GDModTags.Items.GOLDEN_VEGETABLES);
        this.tag(ForgeTags.VEGETABLES_BEETROOT).addTag(GDModTags.Items.GOLDEN_VEGETABLES_BEETROOT);
        this.tag(ForgeTags.VEGETABLES_CARROT).addTag(GDModTags.Items.GOLDEN_VEGETABLES_CARROT);
        this.tag(ForgeTags.VEGETABLES_ONION).addTag(GDModTags.Items.GOLDEN_VEGETABLES_ONION);
        this.tag(ForgeTags.VEGETABLES_POTATO).addTag(GDModTags.Items.GOLDEN_VEGETABLES_POTATO);
        this.tag(ForgeTags.VEGETABLES_TOMATO).addTag(GDModTags.Items.GOLDEN_VEGETABLES_TOMATO);
    }
    private void registerForgeTags() {
        this.tag(Tags.Items.BONES).add(GDModItems.GOLDEN_BONE.get());
        this.tag(Tags.Items.CROPS).addTag(GDModTags.Items.GOLDEN_CROPS);
    }
    private void registerCompatTags() {
        this.tag(GDCompatTags.DIET_FRUITS)
                .addTag(ForgeTags.BERRIES).add(ItemRegistry.GOLDEN_CHORUS_FRUIT.get(), GDModBlocks.GOLDEN_MELON.get().asItem(), GDModItems.GOLDEN_MELON_SLICE.get());

        this.tag(GDCompatTags.DIET_GRAINS)
                .add(GDModItems.GOLDEN_BREAD.get(), GDModItems.GOLDEN_CAKE.get(), GDModItems.GOLDEN_WHEAT.get(),
                        GDModItems.GOLDEN_GLAZED_HAM.get(), GDModItems.GOLDEN_PIE_CRUST.get(), GDModItems.RAW_GOLDEN_PASTA.get(),
                        GDModItems.GOLDEN_RICE.get(), GDModItems.GOLDEN_ROAST_CHICKEN.get(), GDModItems.STUFFED_GOLDEN_PUMPKIN.get());

        this.tag(GDCompatTags.DIET_PROTEINS)
                .addTag(ForgeTags.RAW_BEEF).addTag(ForgeTags.RAW_CHICKEN).addTag(ForgeTags.EGGS).addTag(ForgeTags.MILK)
                .addTag(ForgeTags.RAW_MUTTON).addTag(ForgeTags.RAW_PORK).add(GDModItems.GOLDEN_BONE.get(), GDModItems.GOLDEN_INK_SAC.get(),
                        GDModItems.GOLDEN_RABBIT.get(), GDModItems.ROTTEN_GOLDEN_FLESH.get(), GDModItems.GOLDEN_CABBAGE_ROLLS.get(),
                        GDModItems.FRIED_GOLDEN_EGG.get(), GDModItems.GOLDEN_HAM.get(), GDModItems.GOLDEN_GLAZED_HAM.get(),
                        GDModItems.GOLDEN_ROAST_CHICKEN.get(), GDModItems.GOLDEN_SHEPHERDS_PIE.get());

        this.tag(GDCompatTags.DIET_SPECIAL_FOOD)
                .add(GDModItems.GOLDEN_CAKE.get(), GDModItems.GOLDEN_APPLE_PIE.get(), GDModItems.GOLDEN_CHOCOLATE_PIE.get(),
                        GDModItems.SWEET_GOLDEN_BERRY_CHEESECAKE.get());

        this.tag(GDCompatTags.DIET_SUGARS)
                .add(GDModItems.GOLDEN_CAKE.get(), GDModItems.GOLDEN_COCOA_BEANS.get(), GDModItems.GOLDEN_HONEY_BOTTLE.get(),
                        GDModItems.GOLDEN_SUGAR.get(), GDModItems.GOLDEN_GLAZED_HAM.get());

        this.tag(GDCompatTags.DIET_VEGETABLES)
                .add(ItemRegistry.GOLDEN_BEETROOT.get(), ItemRegistry.GOLDEN_BEETROOT_SEEDS.get(), GDModBlocks.GOLDEN_CACTUS.get().asItem(),
                        ItemRegistry.DRIED_GOLDEN_KELP.get(), ItemRegistry.GOLDEN_KELP.get(), GDModItems.GOLDEN_MELON_SEEDS.get(),
                        GDModItems.GOLDEN_WART.get(), ItemRegistry.POISONOUS_GOLDEN_POTATO.get(), GDModItems.GOLDEN_POTATO.get(),
                        GDModBlocks.GOLDEN_PUMPKIN.get().asItem(), GDModItems.GOLDEN_PUMPKIN_SEEDS.get(), GDModItems.GOLDEN_WHEAT_SEEDS.get(),
                        GDModItems.GOLDEN_CABBAGE.get(), GDModItems.GOLDEN_CABBAGE_ROLLS.get(), GDModItems.GOLDEN_ONION.get(),
                        GDModItems.GOLDEN_ROAST_CHICKEN.get(), GDModItems.GOLDEN_SHEPHERDS_PIE.get(), GDModItems.STUFFED_GOLDEN_PUMPKIN.get(),
                        GDModItems.GOLDEN_TOMATO.get());

        this.tag(GDCompatTags.SERENE_SEASONS_SPRING_CROPS)
                .add(GDModBlocks.GOLDEN_MUSHROOM.get().asItem(), GDModItems.GOLDEN_WART.get(), ItemRegistry.DRIED_GOLDEN_KELP.get(),
                        GDModItems.GOLDEN_GLOW_BERRIES.get(), ItemRegistry.SWEET_GOLDEN_BERRIES.get(), Items.GOLDEN_CARROT,
                        GDModItems.GOLDEN_POTATO.get(), GDModItems.GOLDEN_ONION.get());

        this.tag(GDCompatTags.SERENE_SEASONS_SUMMER_CROPS)
                .add(GDModBlocks.GOLDEN_MUSHROOM.get().asItem(), GDModItems.GOLDEN_WART.get(), ItemRegistry.DRIED_GOLDEN_KELP.get(),
                        GDModItems.GOLDEN_GLOW_BERRIES.get(), ItemRegistry.SWEET_GOLDEN_BERRIES.get(), GDModItems.GOLDEN_SUGAR_CANE.get(),
                        GDModItems.GOLDEN_WHEAT_SEEDS.get(), GDModItems.GOLDEN_MELON_SEEDS.get(), GDModItems.GOLDEN_COCOA_BEANS.get(),
                        GDModItems.GOLDEN_TOMATO_SEEDS.get(), GDModItems.GOLDEN_RICE.get());

        this.tag(GDCompatTags.SERENE_SEASONS_AUTUMN_CROPS).add(GDModBlocks.GOLDEN_MUSHROOM.get().asItem(), GDModItems.GOLDEN_WART.get(), ItemRegistry.DRIED_GOLDEN_KELP.get(),
                GDModItems.GOLDEN_GLOW_BERRIES.get(), ItemRegistry.SWEET_GOLDEN_BERRIES.get(), GDModItems.GOLDEN_WHEAT_SEEDS.get(),
                GDModItems.GOLDEN_PUMPKIN_SEEDS.get(), ItemRegistry.GOLDEN_BEETROOT_SEEDS.get(), Items.GOLDEN_CARROT,
                GDModItems.GOLDEN_CABBAGE_SEEDS.get(), GDModItems.GOLDEN_ONION.get(), GDModItems.GOLDEN_RICE.get());

        this.tag(GDCompatTags.SERENE_SEASONS_WINTER_CROPS)
                .add(GDModBlocks.GOLDEN_MUSHROOM.get().asItem(), GDModItems.GOLDEN_WART.get(), ItemRegistry.DRIED_GOLDEN_KELP.get(),
                GDModItems.GOLDEN_GLOW_BERRIES.get(), GDModItems.GOLDEN_CABBAGE_SEEDS.get());
    }
}