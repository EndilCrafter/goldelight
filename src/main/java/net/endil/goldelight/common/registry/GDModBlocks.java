package net.endil.goldelight.common.registry;

import net.endil.goldelight.GolDelight;
import net.endil.goldelight.common.block.famersdelight.*;
import net.endil.goldelight.common.block.vanilla.*;
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

import java.util.function.Supplier;

public class GDModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, GolDelight.MOD_ID);

    //Minecraft


    public static final RegistryObject<Block> GOL_D_LANTERN;
    public static final RegistryObject<Block> GOLDEN_CACTUS;
    public static final RegistryObject<Block> GOLDEN_CAKE;
    public static final RegistryObject<Block> CANDLE_GOLDEN_CAKE;
    public static final RegistryObject<Block> BLACK_CANDLE_GOLDEN_CAKE;
    public static final RegistryObject<Block> BLUE_CANDLE_GOLDEN_CAKE;
    public static final RegistryObject<Block> BROWN_CANDLE_GOLDEN_CAKE;
    public static final RegistryObject<Block> CYAN_CANDLE_GOLDEN_CAKE;
    public static final RegistryObject<Block> GRAY_CANDLE_GOLDEN_CAKE;
    public static final RegistryObject<Block> GREEN_CANDLE_GOLDEN_CAKE;
    public static final RegistryObject<Block> LIGHT_BLUE_CANDLE_GOLDEN_CAKE;
    public static final RegistryObject<Block> LIGHT_GRAY_CANDLE_GOLDEN_CAKE;
    public static final RegistryObject<Block> LIME_CANDLE_GOLDEN_CAKE;
    public static final RegistryObject<Block> MAGENTA_CANDLE_GOLDEN_CAKE;
    public static final RegistryObject<Block> ORANGE_CANDLE_GOLDEN_CAKE;
    public static final RegistryObject<Block> PINK_CANDLE_GOLDEN_CAKE;
    public static final RegistryObject<Block> PURPLE_CANDLE_GOLDEN_CAKE;
    public static final RegistryObject<Block> RED_CANDLE_GOLDEN_CAKE;
    public static final RegistryObject<Block> WHITE_CANDLE_GOLDEN_CAKE;
    public static final RegistryObject<Block> YELLOW_CANDLE_GOLDEN_CAKE;
    public static final RegistryObject<Block> GOLDEN_CARROTS;
    public static final RegistryObject<Block> GOLDEN_CARVED_PUMPKIN;
    public static final RegistryObject<Block> GOLDEN_CAVE_VINES;
    public static final RegistryObject<Block> GOLDEN_CAVE_VINES_PLANT;
    public static final RegistryObject<Block> GOLDEN_CHORUS_PLANT;
    public static final RegistryObject<Block> GOLDEN_CHORUS_FLOWER;
    public static final RegistryObject<Block> GOLDEN_COCOA;
    public static final RegistryObject<Block> GOLDEN_HAY_BLOCK;
    public static final RegistryObject<Block> GOLDEN_MELON;
    public static final RegistryObject<Block> GOLDEN_MELON_STEM;
    public static final RegistryObject<Block> ATTACHED_GOLDEN_MELON_STEM;
    public static final RegistryObject<Block> GOLDEN_MUSHROOM;
    public static final RegistryObject<Block> GOLDEN_MUSHROOM_COLONY;
    public static final RegistryObject<Block> GOLDEN_FUNGUS;
    public static final RegistryObject<Block> GOLDEN_FUNGUS_COLONY;
    public static final RegistryObject<Block> GOLDEN_MUSHROOM_BLOCK;
    public static final RegistryObject<Block> GOLDEN_MUSHROOM_STEM;
    public static final RegistryObject<Block> GOLDEN_POTATOES;
    public static final RegistryObject<Block> GOLDEN_PUMPKIN;
    public static final RegistryObject<Block> GOLDEN_PUMPKIN_STEM;
    public static final RegistryObject<Block> ATTACHED_GOLDEN_PUMPKIN_STEM;
    public static final RegistryObject<Block> GOLDEN_SUGAR_CANE;
    public static final RegistryObject<Block> GOLDEN_WART;
    public static final RegistryObject<Block> GOLDEN_WART_BLOCK;
    public static final RegistryObject<Block> GOLDEN_BONE_BLOCK;
    public static final RegistryObject<Block> GOLDEN_NETHER_BRICKS;
    public static final RegistryObject<Block> GOLDEN_NETHER_BRICK_STAIRS;
    public static final RegistryObject<Block> CRACKED_GOLDEN_NETHER_BRICKS;
    public static final RegistryObject<Block> CHISELED_GOLDEN_NETHER_BRICKS;
    public static final RegistryObject<Block> GOLDEN_NETHER_BRICK_SLAB;
    public static final RegistryObject<Block> GOLDEN_NETHER_BRICK_FENCE;
    public static final RegistryObject<Block> GOLDEN_NETHER_BRICK_WALL;
    public static final RegistryObject<Block> GOLDEN_HONEY_BLOCK;
    public static final RegistryObject<Block> GOLDEN_HONEYCOMB_BLOCK;
    public static final RegistryObject<Block> GROOMLIGHT;
    public static final RegistryObject<Block> GOLDEN_STEM;
    public static final RegistryObject<Block> GOLDEN_HYPHAE;
    public static final RegistryObject<Block> STRIPPED_GOLDEN_STEM;
    public static final RegistryObject<Block> STRIPPED_GOLDEN_HYPHAE;
    public static final RegistryObject<Block> GOLDEN_PLANKS;
    public static final RegistryObject<Block> GOLDEN_STAIRS;
    public static final RegistryObject<Block> GOLDEN_SLAB;
    public static final RegistryObject<Block> GOLDEN_PRESSURE_PLATE;
    public static final RegistryObject<Block> GOLDEN_BUTTON;
    public static final RegistryObject<Block> GOLDEN_FENCE;
    public static final RegistryObject<Block> GOLDEN_FENCE_GATE;
    public static final RegistryObject<Block> GOLDEN_DOOR;
    public static final RegistryObject<Block> GOLDEN_TRAPDOOR;
    public static final RegistryObject<Block> GOLDEN_SIGN;
    public static final RegistryObject<Block> GOLDEN_WALL_SIGN;
    public static final RegistryObject<Block> GOLDEN_HANGING_SIGN;
    public static final RegistryObject<Block> GOLDEN_WALL_HANGING_SIGN;
    public static final RegistryObject<Block> GOLDEN_BEEHIVE;
    public static final RegistryObject<Block> GOLDEN_WHEAT;
    public static final RegistryObject<Block> GOLDEN_CARROT_CRATE;
    public static final RegistryObject<Block> GOLDEN_POTATO_CRATE;
    public static final RegistryObject<Block> GOLDEN_BEETROOT_CRATE;
    public static final RegistryObject<Block> GOLDEN_CABBAGE_CRATE;
    public static final RegistryObject<Block> GOLDEN_TOMATO_CRATE;
    public static final RegistryObject<Block> GOLDEN_ONION_CRATE;
    public static final RegistryObject<Block> GOLDEN_RICE_BALE;
    public static final RegistryObject<Block> GOLDEN_RICE_BAG;
    public static final RegistryObject<Block> GOLDEN_SOIL;
    public static final RegistryObject<Block> GOLDEN_SOIL_FARMLAND;
    public static final RegistryObject<Block> GOLDEN_COMPOST;
    public static final RegistryObject<Block> GOLDEN_APPLE_PIE;
    public static final RegistryObject<Block> SWEET_GOLDEN_BERRY_CHEESECAKE;
    public static final RegistryObject<Block> GOLDEN_CHOCOLATE_PIE;
    public static final RegistryObject<Block> GOLDEN_CABBAGE_CROP;
    public static final RegistryObject<Block> GOLDEN_ONION_CROP;
    public static final RegistryObject<Block> BUDDING_GOLDEN_TOMATO_CROP;
    public static final RegistryObject<Block> GOLDEN_TOMATO_CROP;
    public static final RegistryObject<Block> GOLDEN_RICE_CROP;
    public static final RegistryObject<Block> GOLDEN_RICE_CROP_PANICLES;
    public static final RegistryObject<Block> GOLDEN_ROAST_CHICKEN_BLOCK;
    //FD: Feasts
    public static final RegistryObject<Block> STUFFED_GOLDEN_PUMPKIN_BLOCK;
    public static final RegistryObject<Block> GOLDEN_GLAZED_HAM_BLOCK;
    public static final RegistryObject<Block> GOLDEN_SHEPHERDS_PIE_BLOCK;
    public static final RegistryObject<Block> GOLDEN_RICE_ROLL_MEDLEY_BLOCK;
    public static final RegistryObject<Block> NETHER_BRICK_STOVE;
    public static final RegistryObject<Block> GOLDEN_COOKING_POT;
    public static final RegistryObject<Block> GOLDEN_CABINET;
    public static final RegistryObject<Block> ANCIENT_GOLD_BLOCK;
    public static final RegistryObject<Block> POTTED_GOLDEN_CACTUS;
    public static final RegistryObject<Block> POTTED_GOLDEN_MUSHROOM;
    public static final RegistryObject<Block> POTTED_GOLDEN_FUNGUS;
    public static final RegistryObject<Block> GOLDEN_CUTTING_BOARD;

    static {
        GOLDEN_CUTTING_BOARD = registerBlock("golden_cutting_board",
                () -> new GoldenCuttingBoardBlock(BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK).strength(2.0f)));
        POTTED_GOLDEN_CACTUS = BLOCKS.register("potted_golden_cactus",
                () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), GDModBlocks.GOLDEN_CACTUS,
                        BlockBehaviour.Properties.copy(Blocks.POTTED_CACTUS)));
        POTTED_GOLDEN_MUSHROOM = BLOCKS.register("potted_golden_mushroom",
                () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), GDModBlocks.GOLDEN_MUSHROOM,
                        BlockBehaviour.Properties.copy(Blocks.POTTED_RED_MUSHROOM)));
        POTTED_GOLDEN_FUNGUS = BLOCKS.register("potted_golden_fungus",
                () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), GDModBlocks.GOLDEN_FUNGUS,
                        BlockBehaviour.Properties.copy(Blocks.POTTED_WARPED_FUNGUS)));
        ANCIENT_GOLD_BLOCK = BLOCKS.register("ancient_gold_block",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK).mapColor(MapColor.GOLD).sound(GDModSounds.ANCIENT_GOLD_BLOCK)));
        GOLDEN_PLANKS = registerBlock("golden_planks",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS).mapColor(MapColor.GOLD)));
        GOLDEN_NETHER_BRICKS = registerBlock("golden_nether_bricks",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHER_BRICKS).mapColor(MapColor.GOLD)));
        GOLDEN_PUMPKIN = registerBlock("golden_pumpkin",
                () -> new GoldenPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.PUMPKIN).mapColor(MapColor.GOLD)));
        GOLDEN_FUNGUS = registerBlock("golden_fungus",
                () -> new GoldenFungusBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_FUNGUS).randomTicks().mapColor(MapColor.GOLD), GDModConfiguredFeatures.GOLDEN_FUNGUS_PLANTED, ModBlocks.RICH_SOIL.get()));
        GOLDEN_MUSHROOM = registerBlock("golden_mushroom",
                () -> new GoldenMushroomBlock(BlockBehaviour.Properties.copy(Blocks.RED_MUSHROOM).randomTicks().mapColor(MapColor.GOLD), GDModConfiguredFeatures.HUGE_GOLDEN_MUSHROOM));
        GOLDEN_MELON = registerBlock("golden_melon",
                () -> new GoldenMelonBlock(BlockBehaviour.Properties.copy(Blocks.MELON).mapColor(MapColor.COLOR_YELLOW)));
        GOLDEN_CHORUS_PLANT = registerBlock("golden_chorus_plant",
                () -> new GoldenChorusPlantBlock(BlockBehaviour.Properties.copy(Blocks.CHORUS_PLANT).mapColor(MapColor.COLOR_YELLOW)));
        CANDLE_GOLDEN_CAKE = BLOCKS.register("candle_golden_cake",
                () -> new CandleGoldenCakeBlock(Blocks.CANDLE, BlockBehaviour.Properties.copy(Blocks.CANDLE_CAKE).mapColor(MapColor.COLOR_YELLOW)));
        GOLDEN_CABINET = registerBlock("golden_cabinet",
                () -> new CabinetBlock(BlockBehaviour.Properties.copy(ModBlocks.CRIMSON_CABINET.get()).mapColor(MapColor.GOLD)));
        GOLDEN_COOKING_POT = BLOCKS.register("golden_cooking_pot",
                () -> new GoldenCookingPotBlock(BlockBehaviour.Properties.copy(ModBlocks.COOKING_POT.get())));
        NETHER_BRICK_STOVE = registerBlock("nether_brick_stove",
                () -> new NetherBrickStoveBlock(BlockBehaviour.Properties.copy(ModBlocks.STOVE.get())));
        GOLDEN_RICE_ROLL_MEDLEY_BLOCK = BLOCKS.register("golden_rice_roll_medley_block",
                () -> new GoldenRiceRollMedleyBlock(BlockBehaviour.Properties.copy(ModBlocks.RICE_ROLL_MEDLEY_BLOCK.get())));
        GOLDEN_SHEPHERDS_PIE_BLOCK = BLOCKS.register("golden_shepherds_pie_block",
                () -> new ShepherdsPieBlock(BlockBehaviour.Properties.copy(ModBlocks.SHEPHERDS_PIE_BLOCK.get()), GDModItems.GOLDEN_SHEPHERDS_PIE, true));
        GOLDEN_GLAZED_HAM_BLOCK = BLOCKS.register("golden_glazed_ham_block",
                () -> new HoneyGlazedHamBlock(BlockBehaviour.Properties.copy(ModBlocks.HONEY_GLAZED_HAM_BLOCK.get()), GDModItems.GOLDEN_GLAZED_HAM, true));
        STUFFED_GOLDEN_PUMPKIN_BLOCK = BLOCKS.register("stuffed_golden_pumpkin_block",
                () -> new FeastBlock(BlockBehaviour.Properties.copy(ModBlocks.STUFFED_PUMPKIN_BLOCK.get()), GDModItems.STUFFED_GOLDEN_PUMPKIN, false));
        GOLDEN_ROAST_CHICKEN_BLOCK = BLOCKS.register("golden_roast_chicken_block",
                () -> new RoastChickenBlock(BlockBehaviour.Properties.copy(ModBlocks.ROAST_CHICKEN_BLOCK.get()), GDModItems.GOLDEN_ROAST_CHICKEN, true));
        GOLDEN_RICE_CROP_PANICLES = BLOCKS.register("golden_rice_panicles",
                () -> new GoldenRicePaniclesBlock(BlockBehaviour.Properties.copy(ModBlocks.RICE_CROP_PANICLES.get())));
        GOLDEN_RICE_CROP = BLOCKS.register("golden_rice",
                () -> new GoldenRiceBlock(BlockBehaviour.Properties.copy(ModBlocks.RICE_CROP.get())));
        GOLDEN_TOMATO_CROP = BLOCKS.register("golden_tomatoes",
                () -> new GoldenTomatoVineBlock(BlockBehaviour.Properties.copy(ModBlocks.TOMATO_CROP.get())));
        BUDDING_GOLDEN_TOMATO_CROP = BLOCKS.register("budding_golden_tomatoes",
                () -> new BuddingGoldenTomatoBlock(BlockBehaviour.Properties.copy(ModBlocks.BUDDING_TOMATO_CROP.get())));
        GOLDEN_ONION_CROP = BLOCKS.register("golden_onions",
                () -> new GoldenOnionBlock(BlockBehaviour.Properties.copy(ModBlocks.ONION_CROP.get())));
        GOLDEN_CABBAGE_CROP = BLOCKS.register("golden_cabbages",
                () -> new GoldenCabbageBlock(BlockBehaviour.Properties.copy(ModBlocks.CABBAGE_CROP.get())));
        GOLDEN_CHOCOLATE_PIE = BLOCKS.register("golden_chocolate_pie",
                () -> new PieBlock(BlockBehaviour.Properties.copy(ModBlocks.CHOCOLATE_PIE.get()).noLootTable(), GDModItems.GOLDEN_CHOCOLATE_PIE_SLICE));
        SWEET_GOLDEN_BERRY_CHEESECAKE = BLOCKS.register("sweet_golden_berry_cheesecake",
                () -> new PieBlock(BlockBehaviour.Properties.copy(ModBlocks.SWEET_BERRY_CHEESECAKE.get()).noLootTable(), GDModItems.SWEET_GOLDEN_BERRY_CHEESECAKE_SLICE));
        GOLDEN_APPLE_PIE = BLOCKS.register("golden_apple_pie",
                () -> new PieBlock(BlockBehaviour.Properties.copy(ModBlocks.APPLE_PIE.get()).noLootTable(), GDModItems.GOLDEN_APPLE_PIE_SLICE));
        GOLDEN_COMPOST = registerBlock("golden_compost",
                () -> new GoldenCompostBlock(BlockBehaviour.Properties.copy(ModBlocks.ORGANIC_COMPOST.get()).mapColor(MapColor.GOLD)));
        GOLDEN_SOIL_FARMLAND = registerBlock("golden_soil_farmland",
                () -> new GoldenSoilFarmlandBlock(BlockBehaviour.Properties.copy(ModBlocks.RICH_SOIL_FARMLAND.get()).mapColor(MapColor.GOLD)));
        GOLDEN_SOIL = registerBlock("golden_soil",
                () -> new GoldenSoilBlock(BlockBehaviour.Properties.copy(ModBlocks.RICH_SOIL.get()).mapColor(MapColor.GOLD)));
        GOLDEN_RICE_BAG = registerBlock("golden_rice_bag",
                () -> new Block(BlockBehaviour.Properties.copy(ModBlocks.RICE_BAG.get()).mapColor(MapColor.GOLD)));
        GOLDEN_RICE_BALE = registerBlock("golden_rice_bale",
                () -> new RiceBaleBlock(BlockBehaviour.Properties.copy(ModBlocks.RICE_BALE.get()).mapColor(MapColor.GOLD)));
        GOLDEN_ONION_CRATE = registerBlock("golden_onion_crate",
                () -> new Block(BlockBehaviour.Properties.copy(ModBlocks.ONION_CRATE.get()).mapColor(MapColor.GOLD)));
        GOLDEN_TOMATO_CRATE = registerBlock("golden_tomato_crate",
                () -> new Block(BlockBehaviour.Properties.copy(ModBlocks.TOMATO_CRATE.get()).mapColor(MapColor.GOLD)));
        GOLDEN_CABBAGE_CRATE = registerBlock("golden_cabbage_crate",
                () -> new Block(BlockBehaviour.Properties.copy(ModBlocks.CABBAGE_CRATE.get()).mapColor(MapColor.GOLD)));
        GOLDEN_BEETROOT_CRATE = registerBlock("golden_beetroot_crate",
                () -> new Block(BlockBehaviour.Properties.copy(ModBlocks.BEETROOT_CRATE.get()).mapColor(MapColor.GOLD)));
        GOLDEN_POTATO_CRATE = registerBlock("golden_potato_crate",
                () -> new Block(BlockBehaviour.Properties.copy(ModBlocks.POTATO_CRATE.get()).mapColor(MapColor.GOLD)));
        GOLDEN_CARROT_CRATE = registerBlock("golden_carrot_crate",
                () -> new Block(BlockBehaviour.Properties.copy(ModBlocks.CARROT_CRATE.get()).mapColor(MapColor.GOLD)));
        GOLDEN_WHEAT = BLOCKS.register("golden_wheat",
                () -> new GoldenWheatBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).mapColor(MapColor.GOLD)));
        GOLDEN_BEEHIVE = registerBlock("golden_beehive",
                () -> new GoldenBeehiveBlock(BlockBehaviour.Properties.copy(Blocks.BEEHIVE).mapColor(MapColor.GOLD)));
        GOLDEN_WALL_HANGING_SIGN = BLOCKS.register("golden_wall_hanging_sign",
                () -> new GDModWallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_WALL_HANGING_SIGN).mapColor(MapColor.GOLD), GDModWoodTypes.GOLDEN));
        GOLDEN_HANGING_SIGN = BLOCKS.register("golden_hanging_sign",
                () -> new GDModCeilingHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_HANGING_SIGN).mapColor(MapColor.GOLD), GDModWoodTypes.GOLDEN));
        GOLDEN_WALL_SIGN = BLOCKS.register("golden_wall_sign",
                () -> new GDModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_WALL_SIGN).mapColor(MapColor.GOLD), GDModWoodTypes.GOLDEN));
        GOLDEN_SIGN = BLOCKS.register("golden_sign",
                () -> new GDModStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_SIGN).mapColor(MapColor.GOLD), GDModWoodTypes.GOLDEN));
        GOLDEN_TRAPDOOR = registerBlock("golden_trapdoor",
                () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_TRAPDOOR).mapColor(MapColor.GOLD), GDModBlockSetTypes.GOLDEN));
        GOLDEN_DOOR = registerBlock("golden_door",
                () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_DOOR).mapColor(MapColor.GOLD), GDModBlockSetTypes.GOLDEN));
        GOLDEN_FENCE_GATE = registerBlock("golden_fence_gate",
                () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_FENCE_GATE).mapColor(MapColor.GOLD), GDModWoodTypes.GOLDEN));
        GOLDEN_FENCE = registerBlock("golden_fence",
                () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_FENCE).mapColor(MapColor.GOLD)));
        GOLDEN_BUTTON = registerBlock("golden_button",
                () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_BUTTON).mapColor(MapColor.GOLD), GDModBlockSetTypes.GOLDEN, 10, false));
        GOLDEN_PRESSURE_PLATE = registerBlock("golden_pressure_plate",
                () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, BlockBehaviour.Properties.copy(Blocks.CRIMSON_PRESSURE_PLATE).mapColor(MapColor.GOLD), GDModBlockSetTypes.GOLDEN));
        GOLDEN_SLAB = registerBlock("golden_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_SLAB).mapColor(MapColor.GOLD)));
        GOLDEN_STAIRS = registerBlock("golden_stairs",
                () -> new StairBlock(GDModBlocks.GOLDEN_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(GDModBlocks.GOLDEN_PLANKS.get())));
        STRIPPED_GOLDEN_HYPHAE = registerBlock("stripped_golden_hyphae",
                () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_CRIMSON_HYPHAE).mapColor(MapColor.GOLD)));
        STRIPPED_GOLDEN_STEM = registerBlock("stripped_golden_stem",
                () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_CRIMSON_STEM).mapColor(MapColor.GOLD)));
        GOLDEN_HYPHAE = registerBlock("golden_hyphae",
                () -> new GoldenStemBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_HYPHAE).mapColor(MapColor.GOLD)));
        GOLDEN_STEM = registerBlock("golden_stem.json",
                () -> new GoldenStemBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_STEM).mapColor(MapColor.GOLD)));
        GROOMLIGHT = registerBlock("groomlight",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.SHROOMLIGHT).mapColor(MapColor.GOLD)));
        GOLDEN_HONEYCOMB_BLOCK = registerBlock("golden_honeycomb_block",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.HONEYCOMB_BLOCK).mapColor(MapColor.GOLD)));
        GOLDEN_HONEY_BLOCK = registerBlock("golden_honey_block",
                () -> new GoldenHoneyBlock(BlockBehaviour.Properties.copy(Blocks.HONEY_BLOCK).mapColor(MapColor.GOLD)));
        GOLDEN_NETHER_BRICK_WALL = registerBlock("golden_nether_brick_wall",
                () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_BRICK_WALL).mapColor(MapColor.GOLD)));
        GOLDEN_NETHER_BRICK_FENCE = registerBlock("golden_nether_brick_fence",
                () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_BRICK_FENCE).mapColor(MapColor.GOLD)));
        GOLDEN_NETHER_BRICK_SLAB = registerBlock("golden_nether_brick_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_BRICK_SLAB).mapColor(MapColor.GOLD)));
        CHISELED_GOLDEN_NETHER_BRICKS = registerBlock("chiseled_golden_nether_bricks",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.CHISELED_NETHER_BRICKS).mapColor(MapColor.GOLD)));
        CRACKED_GOLDEN_NETHER_BRICKS = registerBlock("cracked_golden_nether_bricks",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.CRACKED_NETHER_BRICKS).mapColor(MapColor.GOLD)));
        GOLDEN_NETHER_BRICK_STAIRS = registerBlock("golden_nether_brick_stairs",
                () -> new StairBlock(GDModBlocks.GOLDEN_NETHER_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(GDModBlocks.GOLDEN_NETHER_BRICKS.get())));
        GOLDEN_BONE_BLOCK = registerBlock("golden_bone_block",
                () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.BONE_BLOCK).mapColor(MapColor.GOLD)));
        GOLDEN_WART_BLOCK = registerBlock("golden_wart_block",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHER_WART_BLOCK).mapColor(MapColor.GOLD)));
        GOLDEN_WART = BLOCKS.register("golden_wart",
                () -> new GoldenWartBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_WART).mapColor(MapColor.GOLD)));
        GOLDEN_SUGAR_CANE = BLOCKS.register("golden_sugar_cane",
                () -> new SugarCaneBlock(BlockBehaviour.Properties.copy(Blocks.SUGAR_CANE).mapColor(MapColor.GOLD)));
        ATTACHED_GOLDEN_PUMPKIN_STEM = BLOCKS.register("attached_golden_pumpkin_stem",
                () -> new AttachedStemBlock((StemGrownBlock) GDModBlocks.GOLDEN_PUMPKIN.get(), GDModItems.GOLDEN_PUMPKIN_SEEDS,
                        BlockBehaviour.Properties.copy(Blocks.ATTACHED_PUMPKIN_STEM)));
        GOLDEN_PUMPKIN_STEM = BLOCKS.register("golden_pumpkin_stem",
                () -> new StemBlock((StemGrownBlock) GDModBlocks.GOLDEN_PUMPKIN.get(), GDModItems.GOLDEN_PUMPKIN_SEEDS,
                        BlockBehaviour.Properties.copy(Blocks.PUMPKIN_STEM)));
        GOLDEN_POTATOES = BLOCKS.register("golden_potatoes",
                () -> new GoldenPotatoBlock(BlockBehaviour.Properties.copy(Blocks.POTATOES).mapColor(MapColor.GOLD)));
        GOLDEN_MUSHROOM_STEM = registerBlock("golden_mushroom_stem",
                () -> new HugeMushroomBlock(BlockBehaviour.Properties.copy(Blocks.MUSHROOM_STEM).mapColor(MapColor.COLOR_BROWN)));
        GOLDEN_MUSHROOM_BLOCK = registerBlock("golden_mushroom_block",
                () -> new HugeMushroomBlock(BlockBehaviour.Properties.copy(Blocks.RED_MUSHROOM_BLOCK).mapColor(MapColor.GOLD)));
        GOLDEN_FUNGUS_COLONY = BLOCKS.register("golden_fungus_colony",
                () -> new MushroomColonyBlock(BlockBehaviour.Properties.copy(GDModBlocks.GOLDEN_FUNGUS.get()), () -> GDModBlocks.GOLDEN_FUNGUS.get().asItem()));
        GOLDEN_MUSHROOM_COLONY = BLOCKS.register("golden_mushroom_colony",
                () -> new MushroomColonyBlock(BlockBehaviour.Properties.copy(GDModBlocks.GOLDEN_MUSHROOM.get()), () -> GDModBlocks.GOLDEN_MUSHROOM.get().asItem()));
        ATTACHED_GOLDEN_MELON_STEM = BLOCKS.register("attached_golden_melon_stem",
                () -> new AttachedStemBlock((StemGrownBlock) GDModBlocks.GOLDEN_MELON.get(), GDModItems.GOLDEN_MELON_SEEDS,
                        BlockBehaviour.Properties.copy(Blocks.ATTACHED_MELON_STEM)));
        GOLDEN_MELON_STEM = BLOCKS.register("golden_melon_stem",
                () -> new StemBlock((StemGrownBlock) GDModBlocks.GOLDEN_MELON.get(), GDModItems.GOLDEN_MELON_SEEDS,
                        BlockBehaviour.Properties.copy(Blocks.MELON_STEM)));
        GOLDEN_HAY_BLOCK = registerBlock("golden_hay_block",
                () -> new GoldenHayBlock(BlockBehaviour.Properties.copy(Blocks.HAY_BLOCK).mapColor(MapColor.COLOR_YELLOW)));
        GOLDEN_COCOA = BLOCKS.register("golden_cocoa",
                () -> new CocoaBlock(BlockBehaviour.Properties.copy(Blocks.COCOA).mapColor(MapColor.COLOR_YELLOW)));
        GOLDEN_CHORUS_FLOWER = registerBlock("golden_chorus_flower",
                () -> new GoldenChorusFlowerBlock((GoldenChorusPlantBlock) GDModBlocks.GOLDEN_CHORUS_PLANT.get(), BlockBehaviour.Properties.copy(Blocks.CHORUS_FLOWER).mapColor(MapColor.COLOR_YELLOW)));
        GOLDEN_CAVE_VINES_PLANT = BLOCKS.register("golden_cave_vines_plant",
                () -> new GoldenCaveVinesPlantBlock(BlockBehaviour.Properties.copy(Blocks.CAVE_VINES_PLANT).mapColor(MapColor.COLOR_BROWN)));
        GOLDEN_CAVE_VINES = BLOCKS.register("golden_cave_vines",
                () -> new GoldenCaveVinesBlock(BlockBehaviour.Properties.copy(Blocks.CAVE_VINES).mapColor(MapColor.COLOR_BROWN)));
        GOLDEN_CARVED_PUMPKIN = registerBlock("golden_carved_pumpkin",
                () -> new CarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.CARVED_PUMPKIN).mapColor(MapColor.COLOR_YELLOW)));
        GOLDEN_CARROTS = BLOCKS.register("golden_carrots",
                () -> new GoldenCarrotBlock(BlockBehaviour.Properties.copy(Blocks.CARROTS)));
        YELLOW_CANDLE_GOLDEN_CAKE = BLOCKS.register("yellow_candle_golden_cake",
                () -> new CandleGoldenCakeBlock(Blocks.YELLOW_CANDLE, BlockBehaviour.Properties.copy(GDModBlocks.CANDLE_GOLDEN_CAKE.get())));
        WHITE_CANDLE_GOLDEN_CAKE = BLOCKS.register("white_candle_golden_cake",
                () -> new CandleGoldenCakeBlock(Blocks.WHITE_CANDLE, BlockBehaviour.Properties.copy(GDModBlocks.CANDLE_GOLDEN_CAKE.get())));
        RED_CANDLE_GOLDEN_CAKE = BLOCKS.register("red_candle_golden_cake",
                () -> new CandleGoldenCakeBlock(Blocks.RED_CANDLE, BlockBehaviour.Properties.copy(GDModBlocks.CANDLE_GOLDEN_CAKE.get())));
        PURPLE_CANDLE_GOLDEN_CAKE = BLOCKS.register("purple_candle_golden_cake",
                () -> new CandleGoldenCakeBlock(Blocks.PURPLE_CANDLE, BlockBehaviour.Properties.copy(GDModBlocks.CANDLE_GOLDEN_CAKE.get())));
        PINK_CANDLE_GOLDEN_CAKE = BLOCKS.register("pink_candle_golden_cake",
                () -> new CandleGoldenCakeBlock(Blocks.PINK_CANDLE, BlockBehaviour.Properties.copy(GDModBlocks.CANDLE_GOLDEN_CAKE.get())));
        ORANGE_CANDLE_GOLDEN_CAKE = BLOCKS.register("orange_candle_golden_cake",
                () -> new CandleGoldenCakeBlock(Blocks.ORANGE_CANDLE, BlockBehaviour.Properties.copy(GDModBlocks.CANDLE_GOLDEN_CAKE.get())));
        MAGENTA_CANDLE_GOLDEN_CAKE = BLOCKS.register("magenta_candle_golden_cake",
                () -> new CandleGoldenCakeBlock(Blocks.MAGENTA_CANDLE, BlockBehaviour.Properties.copy(GDModBlocks.CANDLE_GOLDEN_CAKE.get())));
        LIME_CANDLE_GOLDEN_CAKE = BLOCKS.register("lime_candle_golden_cake",
                () -> new CandleGoldenCakeBlock(Blocks.LIME_CANDLE, BlockBehaviour.Properties.copy(GDModBlocks.CANDLE_GOLDEN_CAKE.get())));
        LIGHT_GRAY_CANDLE_GOLDEN_CAKE = BLOCKS.register("light_gray_candle_golden_cake",
                () -> new CandleGoldenCakeBlock(Blocks.LIGHT_GRAY_CANDLE, BlockBehaviour.Properties.copy(GDModBlocks.CANDLE_GOLDEN_CAKE.get())));
        LIGHT_BLUE_CANDLE_GOLDEN_CAKE = BLOCKS.register("light_blue_candle_golden_cake",
                () -> new CandleGoldenCakeBlock(Blocks.LIGHT_BLUE_CANDLE, BlockBehaviour.Properties.copy(GDModBlocks.CANDLE_GOLDEN_CAKE.get())));
        GREEN_CANDLE_GOLDEN_CAKE = BLOCKS.register("green_candle_golden_cake",
                () -> new CandleGoldenCakeBlock(Blocks.GREEN_CANDLE, BlockBehaviour.Properties.copy(GDModBlocks.CANDLE_GOLDEN_CAKE.get())));
        GRAY_CANDLE_GOLDEN_CAKE = BLOCKS.register("gray_candle_golden_cake",
                () -> new CandleGoldenCakeBlock(Blocks.GRAY_CANDLE, BlockBehaviour.Properties.copy(GDModBlocks.CANDLE_GOLDEN_CAKE.get())));
        CYAN_CANDLE_GOLDEN_CAKE = BLOCKS.register("cyan_candle_golden_cake",
                () -> new CandleGoldenCakeBlock(Blocks.CYAN_CANDLE, BlockBehaviour.Properties.copy(GDModBlocks.CANDLE_GOLDEN_CAKE.get())));
        BROWN_CANDLE_GOLDEN_CAKE = BLOCKS.register("brown_candle_golden_cake",
                () -> new CandleGoldenCakeBlock(Blocks.BROWN_CANDLE, BlockBehaviour.Properties.copy(GDModBlocks.CANDLE_GOLDEN_CAKE.get())));
        BLUE_CANDLE_GOLDEN_CAKE = BLOCKS.register("blue_candle_golden_cake",
                () -> new CandleGoldenCakeBlock(Blocks.BLUE_CANDLE, BlockBehaviour.Properties.copy(GDModBlocks.CANDLE_GOLDEN_CAKE.get())));
        BLACK_CANDLE_GOLDEN_CAKE = BLOCKS.register("black_candle_golden_cake",
                () -> new CandleGoldenCakeBlock(Blocks.BLACK_CANDLE, BlockBehaviour.Properties.copy(GDModBlocks.CANDLE_GOLDEN_CAKE.get())));
        GOLDEN_CAKE = BLOCKS.register("golden_cake",
                () -> new GoldenCakeBlock(BlockBehaviour.Properties.copy(Blocks.CAKE).noLootTable()
                        .mapColor(MapColor.COLOR_YELLOW)));
        GOLDEN_CACTUS = registerBlock("golden_cactus",
                () -> new GoldenCactusBlock(BlockBehaviour.Properties.copy(Blocks.CACTUS).mapColor(MapColor.COLOR_YELLOW)));
        GOL_D_LANTERN = registerBlock("gol_d_lantern",
                () -> new CarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.JACK_O_LANTERN)
                        .mapColor(MapColor.COLOR_YELLOW)));
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return GDModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
