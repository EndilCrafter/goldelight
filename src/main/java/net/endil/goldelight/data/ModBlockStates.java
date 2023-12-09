package net.endil.goldelight.data;

import net.endil.goldelight.GolDelight;
import net.endil.goldelight.common.block.famersdelight.BuddingGoldenTomatoBlock;
import net.endil.goldelight.common.block.famersdelight.GoldenCabbageBlock;
import net.endil.goldelight.common.block.famersdelight.GoldenOnionBlock;
import net.endil.goldelight.common.block.famersdelight.GoldenRicePaniclesBlock;
import net.endil.goldelight.common.registry.GDModBlocks;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.block.*;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class ModBlockStates extends BlockStateProvider {
    public ModBlockStates(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, GolDelight.MOD_ID, exFileHelper);
    }

    private String blockName(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block).getPath();
    }

    public ResourceLocation resourceBlock(String path) {
        return new ResourceLocation(GolDelight.MOD_ID, "block/" + path);
    }

    public ModelFile existingModel(Block block) {
        return new ModelFile.ExistingModelFile(resourceBlock(blockName(block)), models().existingFileHelper);
    }

    public ModelFile existingModel(String path) {
        return new ModelFile.ExistingModelFile(resourceBlock(path), models().existingFileHelper);
    }


    @Override
    protected void registerStatesAndModels() {
        horizontalBlock(GDModBlocks.GOL_D_LANTERN.get(), models().withExistingParent(GDModBlocks.GOL_D_LANTERN.getId().getPath(), "block/orientable")
                .texture("front", "goldelight:block/gol_d_lantern")
                .texture("side", "goldelight:block/golden_pumpkin_side")
                .texture("top", "goldelight:block/golden_pumpkin_top")
        );
        simpleBlockItem(GDModBlocks.GOL_D_LANTERN.get(), models().withExistingParent("goldelight:gol_d_lantern", "minecraft:block/orientable"));

        horizontalBlock(GDModBlocks.GOLDEN_CARVED_PUMPKIN.get(), models().withExistingParent(GDModBlocks.GOLDEN_CARVED_PUMPKIN.getId().getPath(), "block/orientable")
                .texture("front", "goldelight:block/golden_carved_pumpkin")
                .texture("side", "goldelight:block/golden_pumpkin_side")
                .texture("top", "goldelight:block/golden_pumpkin_top")
        );
        simpleBlockItem(GDModBlocks.GOLDEN_CARVED_PUMPKIN.get(), models().withExistingParent("goldelight:golden_carved_pumpkin", "minecraft:block/orientable"));

        axisBlock((RotatedPillarBlock) GDModBlocks.GOLDEN_HAY_BLOCK.get(), new ResourceLocation(GolDelight.MOD_ID, "block/golden_hay_block_side"),
                new ResourceLocation(GolDelight.MOD_ID, "block/golden_hay_block_top"));

        simpleBlockItem(GDModBlocks.GOLDEN_HAY_BLOCK.get(), models().withExistingParent("goldelight:golden_hay_block", "minecraft:block/cube_column"));

        simpleBlock(GDModBlocks.GOLDEN_MELON.get(), models().withExistingParent(GDModBlocks.GOLDEN_MELON.getId().getPath(), "block/cube_column")
                .texture("end", "goldelight:block/golden_melon_top")
                .texture("side", "goldelight:block/golden_melon_side")
        );
        simpleBlockItem(GDModBlocks.GOLDEN_MELON.get(), models().withExistingParent("goldelight:golden_melon", "minecraft:block/cube_column"));

        plantBlock(GDModBlocks.GOLDEN_MUSHROOM);
        plantBlock(GDModBlocks.GOLDEN_FUNGUS);

        simpleBlock(GDModBlocks.GOLDEN_PUMPKIN.get(), models().withExistingParent(GDModBlocks.GOLDEN_PUMPKIN.getId().getPath(), "block/cube_column")
                .texture("end", "goldelight:block/golden_pumpkin_top")
                .texture("side", "goldelight:block/golden_pumpkin_side")
        );
        simpleBlockItem(GDModBlocks.GOLDEN_PUMPKIN.get(), models().withExistingParent("goldelight:golden_pumpkin", "minecraft:block/cube_column"));

        blockWithItem(GDModBlocks.GOLDEN_WART_BLOCK);

        plantBlock(GDModBlocks.GOLDEN_SUGAR_CANE);

        blockWithItem(GDModBlocks.GOLDEN_NETHER_BRICKS);
        blockWithItem(GDModBlocks.CHISELED_GOLDEN_NETHER_BRICKS);
        blockWithItem(GDModBlocks.CRACKED_GOLDEN_NETHER_BRICKS);
        blockWithItem(GDModBlocks.GROOMLIGHT);
        logBlock((RotatedPillarBlock) GDModBlocks.GOLDEN_STEM.get());
        logBlock((RotatedPillarBlock) GDModBlocks.STRIPPED_GOLDEN_STEM.get());
        axisBlock((RotatedPillarBlock) GDModBlocks.GOLDEN_HYPHAE.get(), blockTexture(GDModBlocks.GOLDEN_STEM.get()), blockTexture(GDModBlocks.GOLDEN_STEM.get()));
        axisBlock((RotatedPillarBlock) GDModBlocks.STRIPPED_GOLDEN_HYPHAE.get(), blockTexture(GDModBlocks.STRIPPED_GOLDEN_STEM.get()), blockTexture(GDModBlocks.STRIPPED_GOLDEN_STEM.get()));
        blockItem(GDModBlocks.GOLDEN_STEM);
        blockItem(GDModBlocks.STRIPPED_GOLDEN_STEM);
        blockItem(GDModBlocks.GOLDEN_HYPHAE);
        blockItem(GDModBlocks.STRIPPED_GOLDEN_HYPHAE);
        blockWithItem(GDModBlocks.GOLDEN_PLANKS);
        slabBlock((SlabBlock) GDModBlocks.GOLDEN_NETHER_BRICK_SLAB.get(), blockTexture(GDModBlocks.GOLDEN_NETHER_BRICKS.get()), blockTexture(GDModBlocks.GOLDEN_NETHER_BRICKS.get()));
        stairsBlock((StairBlock) GDModBlocks.GOLDEN_NETHER_BRICK_STAIRS.get(), blockTexture(GDModBlocks.GOLDEN_NETHER_BRICKS.get()));
        fenceBlock((FenceBlock) GDModBlocks.GOLDEN_NETHER_BRICK_FENCE.get(), blockTexture(GDModBlocks.GOLDEN_NETHER_BRICKS.get()));
        wallBlock((WallBlock) GDModBlocks.GOLDEN_NETHER_BRICK_WALL.get(), blockTexture(GDModBlocks.GOLDEN_NETHER_BRICKS.get()));
        slabBlock((SlabBlock) GDModBlocks.GOLDEN_SLAB.get(), blockTexture(GDModBlocks.GOLDEN_PLANKS.get()), blockTexture(GDModBlocks.GOLDEN_PLANKS.get()));
        stairsBlock((StairBlock) GDModBlocks.GOLDEN_STAIRS.get(), blockTexture(GDModBlocks.GOLDEN_PLANKS.get()));
        buttonBlock((ButtonBlock) GDModBlocks.GOLDEN_BUTTON.get(), blockTexture(GDModBlocks.GOLDEN_PLANKS.get()));
        pressurePlateBlock((PressurePlateBlock) GDModBlocks.GOLDEN_PRESSURE_PLATE.get(), blockTexture(GDModBlocks.GOLDEN_PLANKS.get()));
        doorBlock(((DoorBlock) GDModBlocks.GOLDEN_DOOR.get()), modLoc("block/golden_door_bottom"), modLoc("block/golden_door_top"));
        trapdoorBlockWithRenderType(((TrapDoorBlock) GDModBlocks.GOLDEN_TRAPDOOR.get()), modLoc("block/golden_trapdoor"), true, "cutout");
        fenceBlock((FenceBlock) GDModBlocks.GOLDEN_FENCE.get(), blockTexture(GDModBlocks.GOLDEN_PLANKS.get()));
        fenceGateBlock((FenceGateBlock) GDModBlocks.GOLDEN_FENCE_GATE.get(), blockTexture(GDModBlocks.GOLDEN_PLANKS.get()));
        axisBlock((RotatedPillarBlock) GDModBlocks.GOLDEN_BONE_BLOCK.get(), modLoc("block/golden_bone_block_side"), modLoc("block/golden_bone_block_top"));
        blockItem(GDModBlocks.GOLDEN_BONE_BLOCK);
        signBlock((StandingSignBlock) GDModBlocks.GOLDEN_SIGN.get(), (WallSignBlock) GDModBlocks.GOLDEN_WALL_SIGN.get(),
                blockTexture(GDModBlocks.GOLDEN_PLANKS.get()));
        HangingSignBlock(GDModBlocks.GOLDEN_HANGING_SIGN.get(), GDModBlocks.GOLDEN_WALL_HANGING_SIGN.get(), blockTexture(GDModBlocks.GOLDEN_PLANKS.get()));
        blockItem(GDModBlocks.GOLDEN_NETHER_BRICK_SLAB);
        blockItem(GDModBlocks.GOLDEN_SLAB);
        blockItem(GDModBlocks.GOLDEN_NETHER_BRICK_STAIRS);
        blockItem(GDModBlocks.GOLDEN_STAIRS);
        blockItem(GDModBlocks.GOLDEN_PRESSURE_PLATE);
        blockItem(GDModBlocks.GOLDEN_FENCE_GATE);
        simpleBlockItem(GDModBlocks.GOLDEN_TRAPDOOR.get(), models().withExistingParent("goldelight:golden_trapdoor", "minecraft:block/template_orientable_trapdoor_bottom").texture("texture", "goldelight:block/golden_trapdoor"));
        blockItem(GDModBlocks.GOLDEN_HONEY_BLOCK);
        blockWithItem(GDModBlocks.GOLDEN_HONEYCOMB_BLOCK);
        simpleBlock(GDModBlocks.POTTED_GOLDEN_MUSHROOM.get(), models().singleTexture("potted_golden_mushroom", new ResourceLocation("flower_pot_cross"), "plant",
                blockTexture(GDModBlocks.GOLDEN_MUSHROOM.get())).renderType("cutout"));
        simpleBlock(GDModBlocks.POTTED_GOLDEN_FUNGUS.get(), models().singleTexture("potted_golden_fungus", new ResourceLocation("flower_pot_cross"), "plant",
                blockTexture(GDModBlocks.GOLDEN_FUNGUS.get())).renderType("cutout"));

        //Farmer's Delight


        String riceBag = blockName(GDModBlocks.GOLDEN_RICE_BAG.get());
        this.simpleBlockWithItem(GDModBlocks.GOLDEN_RICE_BAG.get(), models().withExistingParent(riceBag, "cube")
                .texture("particle", resourceBlock(riceBag + "_top"))
                .texture("down", resourceBlock("bag_bottom"))
                .texture("up", resourceBlock(riceBag + "_top"))
                .texture("north", resourceBlock("bag_side_tied"))
                .texture("south", resourceBlock("bag_side_tied"))
                .texture("east", resourceBlock("bag_side"))
                .texture("west", resourceBlock("bag_side"))
        );


        this.customDirectionalBlock(GDModBlocks.GOLDEN_RICE_BALE.get(),
                $ -> existingModel(GDModBlocks.GOLDEN_RICE_BALE.get()));
        simpleBlockItem(GDModBlocks.GOLDEN_RICE_BALE.get(), models().withExistingParent(blockName(GDModBlocks.GOLDEN_RICE_BALE.get()), "cube_bottom_top")
                .texture("top", resourceBlock(blockName(GDModBlocks.GOLDEN_RICE_BALE.get()) + "_top"))
                .texture("side", resourceBlock(blockName(GDModBlocks.GOLDEN_RICE_BALE.get()) + "_side"))
                .texture("bottom", resourceBlock(blockName(GDModBlocks.GOLDEN_RICE_BALE.get()) + "_bottom")));


        this.stageBlock(GDModBlocks.GOLDEN_MUSHROOM_COLONY.get(), MushroomColonyBlock.COLONY_AGE);
        this.stageBlock(GDModBlocks.GOLDEN_FUNGUS_COLONY.get(), MushroomColonyBlock.COLONY_AGE);
        this.stageBlock(GDModBlocks.GOLDEN_RICE_CROP_PANICLES.get(), GoldenRicePaniclesBlock.RICE_AGE);
        this.customStageBlock(GDModBlocks.GOLDEN_CABBAGE_CROP.get(), resourceBlock("crop_cross"), "cross", GoldenCabbageBlock.AGE, new ArrayList<>());
        this.customStageBlock(GDModBlocks.GOLDEN_ONION_CROP.get(), mcLoc("crop"), "crop", GoldenOnionBlock.AGE, Arrays.asList(0, 0, 1, 1, 2, 2, 2, 3));
        this.customStageBlock(GDModBlocks.BUDDING_GOLDEN_TOMATO_CROP.get(), resourceBlock("crop_cross"), "cross", BuddingGoldenTomatoBlock.AGE, Arrays.asList(0, 1, 2, 3, 3));

        this.crateBlock(GDModBlocks.GOLDEN_CARROT_CRATE.get(), "golden_carrot");
        this.crateBlock(GDModBlocks.GOLDEN_POTATO_CRATE.get(), "golden_potato");
        this.crateBlock(GDModBlocks.GOLDEN_BEETROOT_CRATE.get(), "golden_beetroot");
        this.crateBlock(GDModBlocks.GOLDEN_CABBAGE_CRATE.get(), "golden_cabbage");
        this.crateBlock(GDModBlocks.GOLDEN_TOMATO_CRATE.get(), "golden_tomato");
        this.crateBlock(GDModBlocks.GOLDEN_ONION_CRATE.get(), "golden_onion");

        this.horizontalBlock(GDModBlocks.NETHER_BRICK_STOVE.get(), state -> {
            String name = blockName(GDModBlocks.NETHER_BRICK_STOVE.get());
            String suffix = state.getValue(StoveBlock.LIT) ? "_on" : "";

            return models().orientableWithBottom(name + suffix,
                    resourceBlock(name + "_side"),
                    resourceBlock(name + "_front" + suffix),
                    resourceBlock(name + "_bottom"),
                    resourceBlock(name + "_top" + suffix));
        });
        simpleBlockItem(GDModBlocks.NETHER_BRICK_STOVE.get(), models().orientableWithBottom(blockName(GDModBlocks.NETHER_BRICK_STOVE.get()),
                resourceBlock(blockName(GDModBlocks.NETHER_BRICK_STOVE.get()) + "_side"),
                resourceBlock(blockName(GDModBlocks.NETHER_BRICK_STOVE.get()) + "_front"),
                resourceBlock(blockName(GDModBlocks.NETHER_BRICK_STOVE.get()) + "_bottom"),
                resourceBlock(blockName(GDModBlocks.NETHER_BRICK_STOVE.get()) + "_top")));

        this.cabinetBlock(GDModBlocks.GOLDEN_CABINET.get(), "golden");
        blockItem(GDModBlocks.GOLDEN_CABINET);

        pieBlock(GDModBlocks.GOLDEN_APPLE_PIE.get());
        pieBlock(GDModBlocks.SWEET_GOLDEN_BERRY_CHEESECAKE.get());
        pieBlock(GDModBlocks.GOLDEN_CHOCOLATE_PIE.get());

        feastBlock((FeastBlock) GDModBlocks.GOLDEN_ROAST_CHICKEN_BLOCK.get());
        feastBlock((FeastBlock) GDModBlocks.STUFFED_GOLDEN_PUMPKIN_BLOCK.get());
        feastBlock((FeastBlock) GDModBlocks.GOLDEN_GLAZED_HAM_BLOCK.get());
        feastBlock((FeastBlock) GDModBlocks.GOLDEN_SHEPHERDS_PIE_BLOCK.get());
        feastBlock((FeastBlock) GDModBlocks.GOLDEN_RICE_ROLL_MEDLEY_BLOCK.get());

        blockWithItem(GDModBlocks.GOLDEN_SOIL);
        blockWithItem(GDModBlocks.ANCIENT_GOLD_BLOCK);
    }

    private void blockItem(RegistryObject<Block> block) {
        simpleBlockItem(block.get(), new ModelFile.UncheckedModelFile(GolDelight.MOD_ID + ":block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void plantBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void customDirectionalBlock(Block block, Function<BlockState, ModelFile> modelFunc, Property<?>... ignored) {
        getVariantBuilder(block)
                .forAllStatesExcept(state -> {
                    Direction dir = state.getValue(BlockStateProperties.FACING);
                    return ConfiguredModel.builder()
                            .modelFile(modelFunc.apply(state))
                            .rotationX(dir == Direction.DOWN ? 180 : dir.getAxis().isHorizontal() ? 90 : 0)
                            .rotationY(dir.getAxis().isVertical() ? 0 : ((int) dir.toYRot() + 180) % 360)
                            .build();
                }, ignored);
    }

    private void stageBlock(Block block, IntegerProperty ageProperty, Property<?>... ignored) {
        getVariantBuilder(block)
                .forAllStatesExcept(state -> {
                    int ageSuffix = state.getValue(ageProperty);
                    String stageName = blockName(block) + "_stage" + ageSuffix;
                    return ConfiguredModel.builder()
                            .modelFile(models().cross(stageName, resourceBlock(stageName)).renderType("cutout")).build();
                }, ignored);
    }

    private void customStageBlock(Block block, @Nullable ResourceLocation parent, String textureKey, IntegerProperty ageProperty, List<Integer> suffixes, Property<?>... ignored) {
        getVariantBuilder(block)
                .forAllStatesExcept(state -> {
                    int ageSuffix = state.getValue(ageProperty);
                    String stageName = blockName(block) + "_stage";
                    stageName += suffixes.isEmpty() ? ageSuffix : suffixes.get(Math.min(suffixes.size(), ageSuffix));
                    if (parent == null) {
                        return ConfiguredModel.builder()
                                .modelFile(models().cross(stageName, resourceBlock(stageName)).renderType("cutout")).build();
                    }
                    return ConfiguredModel.builder()
                            .modelFile(models().singleTexture(stageName, parent, textureKey, resourceBlock(stageName)).renderType("cutout")).build();
                }, ignored);
    }

    private void crateBlock(Block block, String cropName) {
        this.simpleBlock(block,
                models().cubeBottomTop(blockName(block), resourceBlock(cropName + "_crate_side"), resourceBlock("crate_bottom"), resourceBlock(cropName + "_crate_top")));
        simpleBlockItem(block, models().withExistingParent("goldelight:" + cropName + "_crate", "minecraft:block/cube_bottom_top"));
    }

    public void pieBlock(Block block) {
        getVariantBuilder(block)
                .forAllStates(state -> {
                            int bites = state.getValue(PieBlock.BITES);
                            String suffix = bites > 0 ? "_slice" + bites : "";
                            return ConfiguredModel.builder()
                                    .modelFile(existingModel(blockName(block) + suffix))
                                    .rotationY(((int) state.getValue(PieBlock.FACING).toYRot() + 180) % 360)
                                    .build();
                        }
                );
    }

    public void feastBlock(FeastBlock block) {
        getVariantBuilder(block)
                .forAllStates(state -> {
                    IntegerProperty servingsProperty = block.getServingsProperty();
                    int servings = state.getValue(servingsProperty);

                    String suffix = "_stage" + (block.getMaxServings() - servings);

                    if (servings == 0) {
                        suffix = block.hasLeftovers ? "_leftover" : "_stage" + (servingsProperty.getPossibleValues().toArray().length - 2);
                    }

                    return ConfiguredModel.builder()
                            .modelFile(existingModel(blockName(block) + suffix))
                            .rotationY(((int) state.getValue(FeastBlock.FACING).toYRot() + 180) % 360)
                            .build();
                });
    }

    public void HangingSignBlock(Block signBlock, Block wallSignBlock, ResourceLocation texture) {
        ModelFile sign = models().sign(name(signBlock), texture);
        hangingSignBlock(signBlock, wallSignBlock, sign);
    }

    public void hangingSignBlock(Block signBlock, Block wallSignBlock, ModelFile sign) {
        simpleBlock(signBlock, sign);
        simpleBlock(wallSignBlock, sign);
    }

    private String name(Block block) {
        return key(block).getPath();
    }

    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }

    public void cabinetBlock(Block block, String woodType) {
        this.horizontalBlock(block, state -> {
            String suffix = state.getValue(CabinetBlock.OPEN) ? "_open" : "";
            return models().orientable(blockName(block) + suffix,
                    resourceBlock(woodType + "_cabinet_side"),
                    resourceBlock(woodType + "_cabinet_front" + suffix),
                    resourceBlock(woodType + "_cabinet_top"));
        });
    }
}
