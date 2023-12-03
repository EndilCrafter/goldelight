package net.endil.goldelight.common.registry;

import net.endil.goldelight.GolDelight;
import net.endil.goldelight.common.block.famersdelight.*;
import net.endil.goldelight.common.block.vanilla.*;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.block.*;
import vectorwing.farmersdelight.common.registry.ModBlocks;
import vectorwing.farmersdelight.common.registry.ModItems;

import java.util.function.Supplier;

public class GDModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, GolDelight.MOD_ID);

    //Minecraft



    public static final RegistryObject<Block> GOL_D_LANTERN = registerBlock("gol_d_lantern",
            () -> new CarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.JACK_O_LANTERN)
                    .mapColor(MapColor.COLOR_YELLOW)));

    public static final RegistryObject<Block> GOLDEN_CACTUS = registerBlock("golden_cactus",
            () -> new GoldenCactusBlock(BlockBehaviour.Properties.copy(Blocks.CACTUS).mapColor(MapColor.COLOR_YELLOW)));

    public static final RegistryObject<Block> GOLDEN_CAKE = BLOCKS.register("golden_cake",
            () -> new GoldenCakeBlock(BlockBehaviour.Properties.copy(Blocks.CAKE).noLootTable()
                    .mapColor(MapColor.COLOR_YELLOW)));

    public static final RegistryObject<Block> CANDLE_GOLDEN_CAKE = BLOCKS.register("candle_golden_cake",
            () -> new CandleGoldenCakeBlock(Blocks.CANDLE, BlockBehaviour.Properties.copy(Blocks.CANDLE_CAKE).mapColor(MapColor.COLOR_YELLOW)));

    public static final RegistryObject<Block> BLACK_CANDLE_GOLDEN_CAKE = BLOCKS.register("black_candle_golden_cake",
            () -> new CandleGoldenCakeBlock(Blocks.BLACK_CANDLE, BlockBehaviour.Properties.copy(GDModBlocks.CANDLE_GOLDEN_CAKE.get())));

    public static final RegistryObject<Block> BLUE_CANDLE_GOLDEN_CAKE = BLOCKS.register("blue_candle_golden_cake",
            () -> new CandleGoldenCakeBlock(Blocks.BLUE_CANDLE, BlockBehaviour.Properties.copy(GDModBlocks.CANDLE_GOLDEN_CAKE.get())));

    public static final RegistryObject<Block> BROWN_CANDLE_GOLDEN_CAKE = BLOCKS.register("brown_candle_golden_cake",
            () -> new CandleGoldenCakeBlock(Blocks.BROWN_CANDLE, BlockBehaviour.Properties.copy(GDModBlocks.CANDLE_GOLDEN_CAKE.get())));

    public static final RegistryObject<Block> CYAN_CANDLE_GOLDEN_CAKE = BLOCKS.register("cyan_candle_golden_cake",
            () -> new CandleGoldenCakeBlock(Blocks.CYAN_CANDLE, BlockBehaviour.Properties.copy(GDModBlocks.CANDLE_GOLDEN_CAKE.get())));

    public static final RegistryObject<Block> GRAY_CANDLE_GOLDEN_CAKE = BLOCKS.register("gray_candle_golden_cake",
            () -> new CandleGoldenCakeBlock(Blocks.GRAY_CANDLE, BlockBehaviour.Properties.copy(GDModBlocks.CANDLE_GOLDEN_CAKE.get())));

    public static final RegistryObject<Block> GREEN_CANDLE_GOLDEN_CAKE = BLOCKS.register("green_candle_golden_cake",
            () -> new CandleGoldenCakeBlock(Blocks.GREEN_CANDLE, BlockBehaviour.Properties.copy(GDModBlocks.CANDLE_GOLDEN_CAKE.get())));

    public static final RegistryObject<Block> LIGHT_BLUE_CANDLE_GOLDEN_CAKE = BLOCKS.register("light_blue_candle_golden_cake",
            () -> new CandleGoldenCakeBlock(Blocks.LIGHT_BLUE_CANDLE, BlockBehaviour.Properties.copy(GDModBlocks.CANDLE_GOLDEN_CAKE.get())));

    public static final RegistryObject<Block> LIGHT_GRAY_CANDLE_GOLDEN_CAKE = BLOCKS.register("light_gray_candle_golden_cake",
            () -> new CandleGoldenCakeBlock(Blocks.LIGHT_GRAY_CANDLE, BlockBehaviour.Properties.copy(GDModBlocks.CANDLE_GOLDEN_CAKE.get())));

    public static final RegistryObject<Block> LIME_CANDLE_GOLDEN_CAKE = BLOCKS.register("lime_candle_golden_cake",
            () -> new CandleGoldenCakeBlock(Blocks.LIME_CANDLE, BlockBehaviour.Properties.copy(GDModBlocks.CANDLE_GOLDEN_CAKE.get())));

    public static final RegistryObject<Block> MAGENTA_CANDLE_GOLDEN_CAKE = BLOCKS.register("magenta_candle_golden_cake",
            () -> new CandleGoldenCakeBlock(Blocks.MAGENTA_CANDLE, BlockBehaviour.Properties.copy(GDModBlocks.CANDLE_GOLDEN_CAKE.get())));

    public static final RegistryObject<Block> ORANGE_CANDLE_GOLDEN_CAKE = BLOCKS.register("orange_candle_golden_cake",
            () -> new CandleGoldenCakeBlock(Blocks.ORANGE_CANDLE, BlockBehaviour.Properties.copy(GDModBlocks.CANDLE_GOLDEN_CAKE.get())));

    public static final RegistryObject<Block> PINK_CANDLE_GOLDEN_CAKE = BLOCKS.register("pink_candle_golden_cake",
            () -> new CandleGoldenCakeBlock(Blocks.PINK_CANDLE, BlockBehaviour.Properties.copy(GDModBlocks.CANDLE_GOLDEN_CAKE.get())));

    public static final RegistryObject<Block> PURPLE_CANDLE_GOLDEN_CAKE = BLOCKS.register("purple_candle_golden_cake",
            () -> new CandleGoldenCakeBlock(Blocks.PURPLE_CANDLE, BlockBehaviour.Properties.copy(GDModBlocks.CANDLE_GOLDEN_CAKE.get())));

    public static final RegistryObject<Block> RED_CANDLE_GOLDEN_CAKE = BLOCKS.register("red_candle_golden_cake",
            () -> new CandleGoldenCakeBlock(Blocks.RED_CANDLE, BlockBehaviour.Properties.copy(GDModBlocks.CANDLE_GOLDEN_CAKE.get())));

    public static final RegistryObject<Block> WHITE_CANDLE_GOLDEN_CAKE = BLOCKS.register("white_candle_golden_cake",
            () -> new CandleGoldenCakeBlock(Blocks.WHITE_CANDLE, BlockBehaviour.Properties.copy(GDModBlocks.CANDLE_GOLDEN_CAKE.get())));

    public static final RegistryObject<Block> YELLOW_CANDLE_GOLDEN_CAKE = BLOCKS.register("yellow_candle_golden_cake",
            () -> new CandleGoldenCakeBlock(Blocks.YELLOW_CANDLE, BlockBehaviour.Properties.copy(GDModBlocks.CANDLE_GOLDEN_CAKE.get())));

    public static final RegistryObject<Block> GOLDEN_CARROTS = BLOCKS.register("golden_carrots",
            () -> new GoldenCarrotBlock(BlockBehaviour.Properties.copy(Blocks.CARROTS)));

    public static final RegistryObject<Block> GOLDEN_CARVED_PUMPKIN = registerBlock("golden_carved_pumpkin",
            () -> new CarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.CARVED_PUMPKIN).mapColor(MapColor.COLOR_YELLOW)));

    public static final RegistryObject<Block> GOLDEN_CAVE_VINES = BLOCKS.register("golden_cave_vines",
            () -> new GoldenCaveVinesBlock(BlockBehaviour.Properties.copy(Blocks.CAVE_VINES).mapColor(MapColor.COLOR_BROWN)));

    public static final RegistryObject<Block> GOLDEN_CAVE_VINES_PLANT = BLOCKS.register("golden_cave_vines_plant",
            () -> new GoldenCaveVinesPlantBlock(BlockBehaviour.Properties.copy(Blocks.CAVE_VINES_PLANT).mapColor(MapColor.COLOR_BROWN)));

    public static final RegistryObject<Block> GOLDEN_CHORUS_PLANT = registerBlock("golden_chorus_plant",
            () -> new GoldenChorusPlantBlock(BlockBehaviour.Properties.copy(Blocks.CHORUS_PLANT).mapColor(MapColor.COLOR_YELLOW)));

    public static final RegistryObject<Block> GOLDEN_CHORUS_FLOWER = registerBlock("golden_chorus_flower",
            () -> new GoldenChorusFlowerBlock((GoldenChorusPlantBlock) GDModBlocks.GOLDEN_CHORUS_PLANT.get(), BlockBehaviour.Properties.copy(Blocks.CHORUS_FLOWER).mapColor(MapColor.COLOR_YELLOW)));

    public static final RegistryObject<Block> GOLDEN_COCOA = BLOCKS.register("golden_cocoa",
            () -> new CocoaBlock(BlockBehaviour.Properties.copy(Blocks.COCOA).mapColor(MapColor.COLOR_YELLOW)));

    public static final RegistryObject<Block> GOLDEN_HAY_BLOCK = registerBlock("golden_hay_block",
            () -> new GoldenHayBlock(BlockBehaviour.Properties.copy(Blocks.HAY_BLOCK).mapColor(MapColor.COLOR_YELLOW)));

    public static final RegistryObject<Block> GOLDEN_MELON = registerBlock("golden_melon",
            () -> new GoldenMelonBlock(BlockBehaviour.Properties.copy(Blocks.MELON).mapColor(MapColor.COLOR_YELLOW)));

    public static final RegistryObject<Block> GOLDEN_MELON_STEM = BLOCKS.register("golden_melon_stem",
            () -> new StemBlock((StemGrownBlock) GDModBlocks.GOLDEN_MELON.get(), GDModItems.GOLDEN_MELON_SEEDS,
                    BlockBehaviour.Properties.copy(Blocks.MELON_STEM)));

    public static final RegistryObject<Block> ATTACHED_GOLDEN_MELON_STEM = BLOCKS.register("attached_golden_melon_stem",
            () -> new AttachedStemBlock((StemGrownBlock) GDModBlocks.GOLDEN_MELON.get(), GDModItems.GOLDEN_MELON_SEEDS,
                    BlockBehaviour.Properties.copy(Blocks.ATTACHED_MELON_STEM)));

    public static final RegistryObject<Block> GOLDEN_MUSHROOM = registerBlock("golden_mushroom",
            () -> new GoldenMushroomBlock(BlockBehaviour.Properties.copy(Blocks.RED_MUSHROOM).randomTicks()));

    public static final RegistryObject<Block> GOLDEN_FUNGUS = registerBlock("golden_fungus",
            () -> new GoldenFungusBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_FUNGUS)));

    public static final RegistryObject<Block> GOLDEN_MUSHROOM_BLOCK = registerBlock("golden_mushroom_block",
            () -> new HugeMushroomBlock(BlockBehaviour.Properties.copy(Blocks.RED_MUSHROOM_BLOCK).mapColor(MapColor.COLOR_YELLOW)));

    public static final RegistryObject<Block> GOLDEN_MUSHROOM_STEM = registerBlock("golden_mushroom_stem",
            () -> new HugeMushroomBlock(BlockBehaviour.Properties.copy(Blocks.MUSHROOM_STEM).mapColor(MapColor.COLOR_BROWN)));

    public static final RegistryObject<Block> GOLDEN_POTATOES = BLOCKS.register("golden_potatoes",
            () -> new GoldenPotatoBlock(BlockBehaviour.Properties.copy(Blocks.POTATOES)));

    public static final RegistryObject<Block> GOLDEN_PUMPKIN = registerBlock("golden_pumpkin",
            () -> new GoldenPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.PUMPKIN).mapColor(MapColor.COLOR_YELLOW)));

    public static final RegistryObject<Block> GOLDEN_PUMPKIN_STEM = BLOCKS.register("golden_pumpkin_stem",
            () -> new StemBlock((StemGrownBlock) GDModBlocks.GOLDEN_PUMPKIN.get(), GDModItems.GOLDEN_PUMPKIN_SEEDS,
                    BlockBehaviour.Properties.copy(Blocks.PUMPKIN_STEM)));

    public static final RegistryObject<Block> ATTACHED_GOLDEN_PUMPKIN_STEM = BLOCKS.register("attached_golden_pumpkin_stem",
            () -> new AttachedStemBlock((StemGrownBlock) GDModBlocks.GOLDEN_PUMPKIN.get(), GDModItems.GOLDEN_PUMPKIN_SEEDS,
                    BlockBehaviour.Properties.copy(Blocks.ATTACHED_PUMPKIN_STEM)));

    public static final RegistryObject<Block> GOLDEN_SUGAR_CANE = BLOCKS.register("golden_sugar_cane",
            () -> new SugarCaneBlock(BlockBehaviour.Properties.copy(Blocks.SUGAR_CANE)));

    public static final RegistryObject<Block> GOLDEN_WART = BLOCKS.register("golden_wart",
            () -> new GoldenWartBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_WART)));

    public static final RegistryObject<Block> GOLDEN_WART_BLOCK = registerBlock("golden_wart_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHER_WART_BLOCK).mapColor(MapColor.COLOR_YELLOW)));

    public static final RegistryObject<Block> GOLDEN_WHEAT = BLOCKS.register("golden_wheat",
            () -> new GoldenWheatBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));


    //Farmer's Delight: Crop Storage


    public static final RegistryObject<Block> GOLDEN_CARROT_CRATE = registerBlock("golden_carrot_crate",
            () -> new Block(BlockBehaviour.Properties.copy(ModBlocks.CARROT_CRATE.get())));

    public static final RegistryObject<Block> GOLDEN_POTATO_CRATE = registerBlock("golden_potato_crate",
            () -> new Block(BlockBehaviour.Properties.copy(ModBlocks.POTATO_CRATE.get())));

    public static final RegistryObject<Block> GOLDEN_BEETROOT_CRATE = registerBlock("golden_beetroot_crate",
            () -> new Block(BlockBehaviour.Properties.copy(ModBlocks.BEETROOT_CRATE.get())));

    public static final RegistryObject<Block> GOLDEN_CABBAGE_CRATE = registerBlock("golden_cabbage_crate",
            () -> new Block(BlockBehaviour.Properties.copy(ModBlocks.CABBAGE_CRATE.get())));

    public static final RegistryObject<Block> GOLDEN_TOMATO_CRATE = registerBlock("golden_tomato_crate",
            () -> new Block(BlockBehaviour.Properties.copy(ModBlocks.TOMATO_CRATE.get())));

    public static final RegistryObject<Block> GOLDEN_ONION_CRATE = registerBlock("golden_onion_crate",
            () -> new Block(BlockBehaviour.Properties.copy(ModBlocks.ONION_CRATE.get())));

    public static final RegistryObject<Block> GOLDEN_RICE_BALE = registerBlock("golden_rice_bale",
            () -> new RiceBaleBlock(BlockBehaviour.Properties.copy(ModBlocks.RICE_BALE.get())));

    public static final RegistryObject<Block> GOLDEN_RICE_BAG = registerBlock("golden_rice_bag",
            () -> new Block(BlockBehaviour.Properties.copy(ModBlocks.RICE_BAG.get())));


    //FD: Composting


    public static final RegistryObject<Block> GOLDEN_MUSHROOM_COLONY = BLOCKS.register("golden_mushroom_colony",
            () -> new MushroomColonyBlock(BlockBehaviour.Properties.copy(GDModBlocks.GOLDEN_MUSHROOM.get()), () -> GDModBlocks.GOLDEN_MUSHROOM.get().asItem()));

    public static final RegistryObject<Block> GOLDEN_SOIL = registerBlock("golden_soil",
            () -> new GoldenSoilBlock(BlockBehaviour.Properties.copy(ModBlocks.RICH_SOIL.get())));

    public static final RegistryObject<Block> GOLDEN_SOIL_FARMLAND = registerBlock("golden_soil_farmland",
            () -> new GoldenSoilFarmlandBlock(BlockBehaviour.Properties.copy(ModBlocks.RICH_SOIL_FARMLAND.get())));

    public static final RegistryObject<Block> GOLDEN_COMPOST = registerBlock("golden_compost",
            () -> new GoldenCompostBlock(BlockBehaviour.Properties.copy(ModBlocks.ORGANIC_COMPOST.get())));

    //FD: Pastries


    public static final RegistryObject<Block> GOLDEN_APPLE_PIE = BLOCKS.register("golden_apple_pie",
            () -> new PieBlock(BlockBehaviour.Properties.copy(ModBlocks.APPLE_PIE.get()).noLootTable(), GDModItems.GOLDEN_APPLE_PIE_SLICE));

    public static final RegistryObject<Block> SWEET_GOLDEN_BERRY_CHEESECAKE = BLOCKS.register("sweet_golden_berry_cheesecake",
            () -> new PieBlock(BlockBehaviour.Properties.copy(ModBlocks.SWEET_BERRY_CHEESECAKE.get()).noLootTable(), GDModItems.SWEET_GOLDEN_BERRY_CHEESECAKE_SLICE));

    public static final RegistryObject<Block> GOLDEN_CHOCOLATE_PIE = BLOCKS.register("golden_chocolate_pie",
            () -> new PieBlock(BlockBehaviour.Properties.copy(ModBlocks.CHOCOLATE_PIE.get()).noLootTable(), GDModItems.GOLDEN_CHOCOLATE_PIE_SLICE));


    //FD: Crops


    public static final RegistryObject<Block> GOLDEN_CABBAGE_CROP = BLOCKS.register("golden_cabbages",
            () -> new GoldenCabbageBlock(BlockBehaviour.Properties.copy(ModBlocks.CABBAGE_CROP.get())));

    public static final RegistryObject<Block> GOLDEN_ONION_CROP = BLOCKS.register("golden_onions",
            () -> new GoldenOnionBlock(BlockBehaviour.Properties.copy(ModBlocks.ONION_CROP.get())));

    public static final RegistryObject<Block> BUDDING_GOLDEN_TOMATO_CROP = BLOCKS.register("budding_golden_tomatoes",
            () -> new BuddingGoldenTomatoBlock(BlockBehaviour.Properties.copy(ModBlocks.BUDDING_TOMATO_CROP.get())));

    public static final RegistryObject<Block> GOLDEN_TOMATO_CROP = BLOCKS.register("golden_tomatoes",
            () -> new GoldenTomatoVineBlock(BlockBehaviour.Properties.copy(ModBlocks.TOMATO_CROP.get())));

    public static final RegistryObject<Block> GOLDEN_RICE_CROP = BLOCKS.register("golden_rice",
            () -> new GoldenRiceBlock(BlockBehaviour.Properties.copy(ModBlocks.RICE_CROP.get())));

    public static final RegistryObject<Block> GOLDEN_RICE_CROP_PANICLES = BLOCKS.register("golden_rice_panicles",
            () -> new GoldenRicePaniclesBlock(BlockBehaviour.Properties.copy(ModBlocks.RICE_CROP_PANICLES.get())));


    //FD: Feasts


    public static final RegistryObject<Block> GOLDEN_ROAST_CHICKEN_BLOCK = BLOCKS.register("golden_roast_chicken_block",
            () -> new RoastChickenBlock(BlockBehaviour.Properties.copy(ModBlocks.ROAST_CHICKEN_BLOCK.get()), GDModItems.GOLDEN_ROAST_CHICKEN, true));

    public static final RegistryObject<Block> STUFFED_GOLDEN_PUMPKIN_BLOCK = BLOCKS.register("stuffed_golden_pumpkin_block",
            () -> new FeastBlock(BlockBehaviour.Properties.copy(ModBlocks.STUFFED_PUMPKIN_BLOCK.get()), GDModItems.STUFFED_GOLDEN_PUMPKIN, false));

    public static final RegistryObject<Block> GOLDEN_GLAZED_HAM_BLOCK = BLOCKS.register("golden_glazed_ham_block",
            () -> new HoneyGlazedHamBlock(BlockBehaviour.Properties.copy(ModBlocks.HONEY_GLAZED_HAM_BLOCK.get()), GDModItems.GOLDEN_GLAZED_HAM, true));

    public static final RegistryObject<Block> GOLDEN_SHEPHERDS_PIE_BLOCK = BLOCKS.register("golden_shepherds_pie_block",
            () -> new ShepherdsPieBlock(BlockBehaviour.Properties.copy(ModBlocks.SHEPHERDS_PIE_BLOCK.get()), GDModItems.GOLDEN_SHEPHERDS_PIE, true));

    public static final RegistryObject<Block> GOLDEN_RICE_ROLL_MEDLEY_BLOCK = BLOCKS.register("golden_rice_roll_medley_block",
            () -> new GoldenRiceRollMedleyBlock(BlockBehaviour.Properties.copy(ModBlocks.RICE_ROLL_MEDLEY_BLOCK.get())));

    //FD: Utils(WIP)


    public static final RegistryObject<Block> NETHER_BRICK_STOVE = registerBlock("nether_brick_stove",
            () -> new StoveBlock(BlockBehaviour.Properties.copy(ModBlocks.STOVE.get())));

    public static final RegistryObject<Block> GOLDEN_COOKING_POT = BLOCKS.register("golden_cooking_pot",
            () -> new CookingPotBlock(BlockBehaviour.Properties.copy(ModBlocks.COOKING_POT.get())));


    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return GDModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
