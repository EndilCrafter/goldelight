package net.endil.goldelight.data;

import accieo.midas.hunger.registry.BlockRegistry;
import net.endil.goldelight.GolDelight;
import net.endil.goldelight.common.registry.GDCompatTags;
import net.endil.goldelight.common.registry.GDModBlocks;
import net.endil.goldelight.common.registry.GDModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.common.registry.ModBlocks;
import vectorwing.farmersdelight.common.tag.ForgeTags;
import vectorwing.farmersdelight.common.tag.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTags extends BlockTagsProvider {
    public ModBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, GolDelight.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.registerMineable();
        this.registerMinecraftTags();
        this.registerFDTags();
        this.registerGDModTags();
        this.registerCompatTags();
        this.registerForgeTags();
    }

    private void registerMineable() {
        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(GDModBlocks.ATTACHED_GOLDEN_MELON_STEM.get(), GDModBlocks.ATTACHED_GOLDEN_PUMPKIN_STEM.get(), BlockRegistry.GOLDEN_BEETROOTS.get(),
                        GDModBlocks.GOLDEN_MUSHROOM_BLOCK.get(), GDModBlocks.GOLDEN_MUSHROOM.get(), GDModBlocks.GOLDEN_CARROTS.get(),
                        GDModBlocks.GOLDEN_CARVED_PUMPKIN.get(), GDModBlocks.GOLDEN_CAVE_VINES_PLANT.get(), GDModBlocks.GOLDEN_CAVE_VINES.get(),
                        GDModBlocks.GOLDEN_CHORUS_FLOWER.get(), GDModBlocks.GOLDEN_CHORUS_PLANT.get(), GDModBlocks.GOLDEN_COCOA.get(),
                        GDModBlocks.GOLDEN_FUNGUS.get(), GDModBlocks.GOL_D_LANTERN.get(), GDModBlocks.GOLDEN_MELON_STEM.get(),
                        GDModBlocks.GOLDEN_MELON.get(), GDModBlocks.GOLDEN_MUSHROOM_STEM.get(), GDModBlocks.GOLDEN_WART.get(),
                        GDModBlocks.GOLDEN_POTATOES.get(), GDModBlocks.GOLDEN_PUMPKIN_STEM.get(), GDModBlocks.GOLDEN_PUMPKIN.get(),
                        GDModBlocks.GOLDEN_SUGAR_CANE.get(), BlockRegistry.SWEET_GOLDEN_BERRY_BUSH.get(), GDModBlocks.GOLDEN_WHEAT.get(),
                        GDModBlocks.GOLDEN_CARROT_CRATE.get(), GDModBlocks.GOLDEN_POTATO_CRATE.get(), GDModBlocks.GOLDEN_BEETROOT_CRATE.get(),
                        GDModBlocks.GOLDEN_CABBAGE_CRATE.get(), GDModBlocks.GOLDEN_TOMATO_CRATE.get(), GDModBlocks.GOLDEN_ONION_CRATE.get(),
                        GDModBlocks.STUFFED_GOLDEN_PUMPKIN_BLOCK.get(), GDModBlocks.GOLDEN_STEM.get(), GDModBlocks.GOLDEN_HYPHAE.get(),
                        GDModBlocks.STRIPPED_GOLDEN_STEM.get(), GDModBlocks.STRIPPED_GOLDEN_HYPHAE.get(), GDModBlocks.GOLDEN_PLANKS.get(),
                        GDModBlocks.GOLDEN_SLAB.get(), GDModBlocks.GOLDEN_STAIRS.get(), GDModBlocks.GOLDEN_FENCE.get(),
                        GDModBlocks.GOLDEN_FENCE_GATE.get(), GDModBlocks.GOLDEN_BUTTON.get(), GDModBlocks.GOLDEN_PRESSURE_PLATE.get(),
                        GDModBlocks.GOLDEN_DOOR.get(), GDModBlocks.GOLDEN_TRAPDOOR.get(), GDModBlocks.GOLDEN_CABINET.get(),
                        GDModBlocks.GOLDEN_SIGN.get(), GDModBlocks.GOLDEN_WALL_SIGN.get(), GDModBlocks.GOLDEN_HANGING_SIGN.get(),
                        GDModBlocks.GOLDEN_WALL_HANGING_SIGN.get(), GDModBlocks.GOLDEN_BEEHIVE.get());

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(GDModBlocks.GOLDEN_NETHER_BRICKS.get(), GDModBlocks.CHISELED_GOLDEN_NETHER_BRICKS.get(), GDModBlocks.CRACKED_GOLDEN_NETHER_BRICKS.get(),
                        GDModBlocks.GOLDEN_NETHER_BRICK_SLAB.get(), GDModBlocks.GOLDEN_NETHER_BRICK_STAIRS.get(), GDModBlocks.GOLDEN_NETHER_BRICK_FENCE.get(),
                        GDModBlocks.GOLDEN_NETHER_BRICK_WALL.get(), GDModBlocks.GOLDEN_BONE_BLOCK.get(), GDModBlocks.NETHER_BRICK_STOVE.get(),
                        GDModBlocks.GOLDEN_COOKING_POT.get(), GDModBlocks.ANCIENT_GOLD_BLOCK.get(), GDModBlocks.GOLDEN_CUTTING_BOARD.get());

        this.tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(GDModBlocks.GOLDEN_COMPOST.get(), GDModBlocks.GOLDEN_SOIL.get(), GDModBlocks.GOLDEN_SOIL_FARMLAND.get());

        this.tag(BlockTags.MINEABLE_WITH_HOE)
                .add(GDModBlocks.GOLDEN_WART_BLOCK.get(), GDModBlocks.GOLDEN_HAY_BLOCK.get(), BlockRegistry.DRIED_GOLDEN_KELP_BLOCK.get(),
                        GDModBlocks.GOLDEN_RICE_BALE.get(), GDModBlocks.GROOMLIGHT.get());

        this.tag(ForgeTags.MINEABLE_WITH_KNIFE)
                .add(GDModBlocks.GOLDEN_CAKE.get(), GDModBlocks.GOLDEN_APPLE_PIE.get(), GDModBlocks.SWEET_GOLDEN_BERRY_CHEESECAKE.get(),
                        GDModBlocks.GOLDEN_CHOCOLATE_PIE.get(), GDModBlocks.GOLDEN_ROAST_CHICKEN_BLOCK.get(), GDModBlocks.GOLDEN_GLAZED_HAM_BLOCK.get(),
                        GDModBlocks.GOLDEN_SHEPHERDS_PIE_BLOCK.get(), GDModBlocks.GOLDEN_RICE_ROLL_MEDLEY_BLOCK.get());
        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL).add(GDModBlocks.ANCIENT_GOLD_BLOCK.get());
    }

    private void registerMinecraftTags() {
        this.tag(BlockTags.DIRT).add(GDModBlocks.GOLDEN_SOIL.get());
        this.tag(BlockTags.MUSHROOM_GROW_BLOCK).addTag(GDModTags.Blocks.GOLDEN_MUSHROOM_GROW_BLOCK);
        this.tag(BlockTags.WART_BLOCKS).add(GDModBlocks.GOLDEN_WART_BLOCK.get());
        this.tag(BlockTags.CROPS).addTag(GDModTags.Blocks.GOLDEN_CROPS);
        this.tag(BlockTags.CLIMBABLE).add(GDModBlocks.GOLDEN_TOMATO_CROP.get());
        this.tag(BlockTags.CANDLE_CAKES)
                .add(GDModBlocks.CANDLE_GOLDEN_CAKE.get())
                .add(GDModBlocks.BLACK_CANDLE_GOLDEN_CAKE.get())
                .add(GDModBlocks.BLUE_CANDLE_GOLDEN_CAKE.get())
                .add(GDModBlocks.BROWN_CANDLE_GOLDEN_CAKE.get())
                .add(GDModBlocks.CYAN_CANDLE_GOLDEN_CAKE.get())
                .add(GDModBlocks.GRAY_CANDLE_GOLDEN_CAKE.get())
                .add(GDModBlocks.GREEN_CANDLE_GOLDEN_CAKE.get())
                .add(GDModBlocks.LIGHT_BLUE_CANDLE_GOLDEN_CAKE.get())
                .add(GDModBlocks.LIGHT_GRAY_CANDLE_GOLDEN_CAKE.get())
                .add(GDModBlocks.LIME_CANDLE_GOLDEN_CAKE.get())
                .add(GDModBlocks.MAGENTA_CANDLE_GOLDEN_CAKE.get())
                .add(GDModBlocks.ORANGE_CANDLE_GOLDEN_CAKE.get())
                .add(GDModBlocks.PINK_CANDLE_GOLDEN_CAKE.get())
                .add(GDModBlocks.PURPLE_CANDLE_GOLDEN_CAKE.get())
                .add(GDModBlocks.RED_CANDLE_GOLDEN_CAKE.get())
                .add(GDModBlocks.WHITE_CANDLE_GOLDEN_CAKE.get())
                .add(GDModBlocks.YELLOW_CANDLE_GOLDEN_CAKE.get());
        this.tag(BlockTags.CAVE_VINES).add(GDModBlocks.GOLDEN_CAVE_VINES_PLANT.get(), GDModBlocks.GOLDEN_CAVE_VINES.get());
        this.tag(BlockTags.WOODEN_BUTTONS).add(GDModBlocks.GOLDEN_BUTTON.get());
        this.tag(BlockTags.WOODEN_DOORS).add(GDModBlocks.GOLDEN_DOOR.get());
        this.tag(BlockTags.WOODEN_FENCES).add(GDModBlocks.GOLDEN_FENCE.get());
        this.tag(BlockTags.FENCE_GATES).add(GDModBlocks.GOLDEN_FENCE_GATE.get());
        this.tag(BlockTags.WOODEN_STAIRS).add(GDModBlocks.GOLDEN_STAIRS.get());
        this.tag(BlockTags.WOODEN_SLABS).add(GDModBlocks.GOLDEN_SLAB.get());
        this.tag(BlockTags.WOODEN_PRESSURE_PLATES).add(GDModBlocks.GOLDEN_PRESSURE_PLATE.get());
        this.tag(BlockTags.WOODEN_TRAPDOORS).add(GDModBlocks.GOLDEN_TRAPDOOR.get());
        this.tag(BlockTags.PLANKS).add(GDModBlocks.GOLDEN_PLANKS.get());
        this.tag(BlockTags.LOGS).addTag(GDModTags.Blocks.GOLDEN_STEMS);
        this.tag(BlockTags.SLABS).add(GDModBlocks.GOLDEN_NETHER_BRICK_SLAB.get());
        this.tag(BlockTags.STAIRS).add(GDModBlocks.GOLDEN_NETHER_BRICK_STAIRS.get());
        this.tag(BlockTags.FENCES).add(GDModBlocks.GOLDEN_NETHER_BRICK_FENCE.get());
        this.tag(BlockTags.WALLS).add(GDModBlocks.GOLDEN_NETHER_BRICK_WALL.get());
        this.tag(BlockTags.STANDING_SIGNS).add(GDModBlocks.GOLDEN_SIGN.get());
        this.tag(BlockTags.WALL_SIGNS).add(GDModBlocks.GOLDEN_WALL_SIGN.get());
        this.tag(BlockTags.CEILING_HANGING_SIGNS).add(GDModBlocks.GOLDEN_HANGING_SIGN.get());
        this.tag(BlockTags.WALL_HANGING_SIGNS).add(GDModBlocks.GOLDEN_WALL_HANGING_SIGN.get());
        this.tag(BlockTags.SNOW_LAYER_CAN_SURVIVE_ON).add(GDModBlocks.GOLDEN_HONEY_BLOCK.get());
        this.tag(BlockTags.DRAGON_IMMUNE).add(GDModBlocks.ANCIENT_GOLD_BLOCK.get());
        this.tag(BlockTags.WITHER_IMMUNE).add(GDModBlocks.ANCIENT_GOLD_BLOCK.get());
        this.tag(BlockTags.BEACON_BASE_BLOCKS).add(GDModBlocks.ANCIENT_GOLD_BLOCK.get());
    }

    private void registerFDTags() {
        this.tag(ModTags.COMPOST_ACTIVATORS).addTag(GDModTags.Blocks.GOLDEN_COMPOST_ACTIVATORS);
        this.tag(ModTags.UNAFFECTED_BY_RICH_SOIL).add(GDModBlocks.GOLDEN_MUSHROOM_COLONY.get(), GDModBlocks.GOLDEN_FUNGUS_COLONY.get());
        this.tag(ModTags.MUSHROOM_COLONY_GROWABLE_ON).add(GDModBlocks.GOLDEN_SOIL.get());
        this.tag(ModTags.HEAT_SOURCES).add(GDModBlocks.NETHER_BRICK_STOVE.get());
    }

    private void registerGDModTags() {
        this.tag(GDModTags.Blocks.GOLDEN_CROPS)
                .add(BlockRegistry.GOLDEN_BEETROOTS.get(), GDModBlocks.GOLDEN_CARROTS.get(), GDModBlocks.GOLDEN_POTATOES.get(),
                        GDModBlocks.GOLDEN_WHEAT.get(), GDModBlocks.GOLDEN_MELON_STEM.get(), GDModBlocks.GOLDEN_PUMPKIN_STEM.get(),
                        GDModBlocks.GOLDEN_CABBAGE_CROP.get(), GDModBlocks.GOLDEN_ONION_CROP.get(), GDModBlocks.GOLDEN_RICE_CROP_PANICLES.get(),
                        GDModBlocks.BUDDING_GOLDEN_TOMATO_CROP.get(), GDModBlocks.GOLDEN_TOMATO_CROP.get());
        this.tag(GDModTags.Blocks.GOLDEN_COMPOST_ACTIVATORS)
                .add(GDModBlocks.GOLDEN_MUSHROOM.get(), GDModBlocks.GOLDEN_MUSHROOM_COLONY.get(), GDModBlocks.GOLDEN_FUNGUS.get(), GDModBlocks.GOLDEN_FUNGUS_COLONY.get(),
                        GDModBlocks.GOLDEN_SOIL.get(), GDModBlocks.GOLDEN_SOIL_FARMLAND.get(), GDModBlocks.GOLDEN_COMPOST.get());
        this.tag(GDModTags.Blocks.GOLDEN_MUSHROOM_GROW_BLOCK).add(GDModBlocks.GOLDEN_SOIL.get(), GDModBlocks.GOLDEN_COMPOST.get(), ModBlocks.ORGANIC_COMPOST.get(), ModBlocks.RICH_SOIL.get());
        this.tag(GDModTags.Blocks.GOLDEN_STEMS).add(GDModBlocks.GOLDEN_STEM.get(), GDModBlocks.GOLDEN_HYPHAE.get(),
                GDModBlocks.STRIPPED_GOLDEN_STEM.get(), GDModBlocks.STRIPPED_GOLDEN_HYPHAE.get());
        this.tag(GDModTags.Blocks.SOUL_HEAT_SOURCES).addTag(GDModTags.Blocks.TRAY_SOUL_HEAT_SOURCES);
        this.tag(GDModTags.Blocks.TRAY_SOUL_HEAT_SOURCES).add(Blocks.SOUL_CAMPFIRE).add(GDModBlocks.NETHER_BRICK_STOVE.get());
        this.tag(GDModTags.Blocks.GOLDEN_BEEHIVES).add(GDModBlocks.GOLDEN_BEEHIVE.get());
        this.tag(GDModTags.Blocks.GOLDEN_BEE_GROWABLES).addTag(GDModTags.Blocks.GOLDEN_CROPS).addTag(BlockTags.BEE_GROWABLES)
                .add(BlockRegistry.SWEET_GOLDEN_BERRY_BUSH.get(), GDModBlocks.GOLDEN_CAVE_VINES.get(), GDModBlocks.GOLDEN_CAVE_VINES_PLANT.get());
        this.tag(GDModTags.Blocks.STORAGE_BLOCKS_ANCIENT_GOLD).add(GDModBlocks.ANCIENT_GOLD_BLOCK.get());
    }

    private void registerCompatTags() {
        this.tag(GDCompatTags.SERENE_SEASONS_SPRING_CROPS_BLOCK)
                .add(GDModBlocks.GOLDEN_MUSHROOM.get(), GDModBlocks.GOLDEN_WART.get(), GDModBlocks.GOLDEN_FUNGUS.get(),
                        BlockRegistry.GOLDEN_KELP.get(), BlockRegistry.GOLDEN_KELP_PLANT.get(), GDModBlocks.GOLDEN_CAVE_VINES.get(),
                        GDModBlocks.GOLDEN_CAVE_VINES_PLANT.get(), BlockRegistry.SWEET_GOLDEN_BERRY_BUSH.get(), GDModBlocks.GOLDEN_CARROTS.get(),
                        GDModBlocks.GOLDEN_POTATOES.get(), GDModBlocks.GOLDEN_ONION_CROP.get());

        this.tag(GDCompatTags.SERENE_SEASONS_SUMMER_CROPS_BLOCK)
                .add(GDModBlocks.GOLDEN_MUSHROOM.get(), GDModBlocks.GOLDEN_WART.get(), GDModBlocks.GOLDEN_FUNGUS.get(),
                        BlockRegistry.GOLDEN_KELP.get(), BlockRegistry.GOLDEN_KELP_PLANT.get(), GDModBlocks.GOLDEN_CAVE_VINES.get(),
                        GDModBlocks.GOLDEN_CAVE_VINES_PLANT.get(), BlockRegistry.SWEET_GOLDEN_BERRY_BUSH.get(), GDModBlocks.GOLDEN_CACTUS.get(),
                        GDModBlocks.GOLDEN_SUGAR_CANE.get(), GDModBlocks.GOLDEN_WHEAT.get(), GDModBlocks.GOLDEN_MELON_STEM.get(),
                        GDModBlocks.GOLDEN_COCOA.get(), GDModBlocks.BUDDING_GOLDEN_TOMATO_CROP.get(), GDModBlocks.GOLDEN_TOMATO_CROP.get(),
                        GDModBlocks.GOLDEN_RICE_CROP.get(), GDModBlocks.GOLDEN_RICE_CROP_PANICLES.get());

        this.tag(GDCompatTags.SERENE_SEASONS_AUTUMN_CROPS_BLOCK)
                .add(GDModBlocks.GOLDEN_MUSHROOM.get(), GDModBlocks.GOLDEN_WART.get(), GDModBlocks.GOLDEN_FUNGUS.get(),
                        BlockRegistry.GOLDEN_KELP.get(), BlockRegistry.GOLDEN_KELP_PLANT.get(), GDModBlocks.GOLDEN_CAVE_VINES.get(),
                        GDModBlocks.GOLDEN_CAVE_VINES_PLANT.get(), BlockRegistry.SWEET_GOLDEN_BERRY_BUSH.get(), GDModBlocks.GOLDEN_WHEAT.get(),
                        GDModBlocks.GOLDEN_PUMPKIN_STEM.get(), BlockRegistry.GOLDEN_BEETROOTS.get(), GDModBlocks.GOLDEN_CARROTS.get(),
                        GDModBlocks.GOLDEN_CABBAGE_CROP.get(), GDModBlocks.GOLDEN_ONION_CROP.get(), GDModBlocks.GOLDEN_RICE_CROP.get(),
                        GDModBlocks.GOLDEN_RICE_CROP_PANICLES.get());

        this.tag(GDCompatTags.SERENE_SEASONS_WINTER_CROPS_BLOCK)
                .add(GDModBlocks.GOLDEN_MUSHROOM.get(), GDModBlocks.GOLDEN_WART.get(), GDModBlocks.GOLDEN_FUNGUS.get(),
                        BlockRegistry.GOLDEN_KELP.get(), BlockRegistry.GOLDEN_KELP_PLANT.get(), GDModBlocks.GOLDEN_CAVE_VINES.get(),
                        GDModBlocks.GOLDEN_CAVE_VINES_PLANT.get(), GDModBlocks.GOLDEN_CABBAGE_CROP.get());

        this.tag(GDCompatTags.SERENE_SEASONS_UNBREAKABLE_FERTILE_CROPS)
                .add(GDModBlocks.GOLDEN_SUGAR_CANE.get(), GDModBlocks.GOLDEN_CACTUS.get(), GDModBlocks.GOLDEN_MUSHROOM.get(),
                        GDModBlocks.GOLDEN_FUNGUS.get(), GDModBlocks.GOLDEN_ONION_CROP.get());
    }
    private void registerForgeTags() {
        this.tag(Tags.Blocks.STORAGE_BLOCKS).add(GDModBlocks.ANCIENT_GOLD_BLOCK.get());
    }
}
