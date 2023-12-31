package net.endil.goldelight.data;

import accieo.midas.hunger.registry.ItemRegistry;
import net.endil.goldelight.common.block.famersdelight.GoldenCabbageBlock;
import net.endil.goldelight.common.block.famersdelight.GoldenOnionBlock;
import net.endil.goldelight.common.block.famersdelight.GoldenTomatoVineBlock;
import net.endil.goldelight.common.block.vanilla.*;
import net.endil.goldelight.common.event.GoldenCaveVines;
import net.endil.goldelight.common.registry.GDModBlocks;
import net.endil.goldelight.common.registry.GDModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CocoaBlock;
import net.minecraft.world.level.storage.loot.IntRange;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.*;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.nbt.ContextNbtProvider;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import vectorwing.farmersdelight.common.loot.function.CopyMealFunction;

import java.util.HashSet;
import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    private final Set<Block> generatedLootTables = new HashSet<>();
    LootItemCondition.Builder goldenWheat = LootItemBlockStatePropertyCondition.hasBlockStateProperties(GDModBlocks.GOLDEN_WHEAT.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(GoldenWheatBlock.AGE, 7));
    LootItemCondition.Builder goldenCarrot = LootItemBlockStatePropertyCondition.hasBlockStateProperties(GDModBlocks.GOLDEN_CARROTS.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(GoldenCarrotBlock.AGE, 7));
    LootItemCondition.Builder goldenPotato = LootItemBlockStatePropertyCondition.hasBlockStateProperties(GDModBlocks.GOLDEN_POTATOES.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(GoldenPotatoBlock.AGE, 7));
    LootItemCondition.Builder goldenCabbage = LootItemBlockStatePropertyCondition.hasBlockStateProperties(GDModBlocks.GOLDEN_CABBAGE_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(GoldenCabbageBlock.AGE, 7));
    LootItemCondition.Builder goldenOnion = LootItemBlockStatePropertyCondition.hasBlockStateProperties(GDModBlocks.GOLDEN_ONION_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(GoldenOnionBlock.AGE, 7));
    LootItemCondition.Builder goldenTomato = LootItemBlockStatePropertyCondition.hasBlockStateProperties(GDModBlocks.GOLDEN_TOMATO_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(GoldenTomatoVineBlock.AGE, 7));

    protected ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    protected static LootTable.Builder createGoldenCaveVinesDrop(Block pBlock) {
        return LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(GDModItems.GOLDEN_GLOW_BERRIES.get()))
                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(GoldenCaveVines.BERRIES, true))));
    }

    protected static LootTable.Builder createGoldenBeeHiveDrop(Block pBlock) {
        return LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(pBlock).when(HAS_SILK_TOUCH).apply(CopyNbtFunction.copyData(ContextNbtProvider.BLOCK_ENTITY).copy("Bees", "BlockEntityTag.Bees")).apply(CopyBlockState.copyState(pBlock).copy(GoldenBeehiveBlock.HONEY_LEVEL)).otherwise(LootItem.lootTableItem(pBlock))));
    }

    @Override
    protected void generate() {
        this.registerMinecraftBuildings();
        this.registerMinecraftCrops();
        this.registerFD();
    }

    private void registerMinecraftBuildings() {
        this.dropSelf(GDModBlocks.CHISELED_GOLDEN_NETHER_BRICKS.get());
        this.dropSelf(GDModBlocks.CRACKED_GOLDEN_NETHER_BRICKS.get());
        this.dropSelf(GDModBlocks.GOL_D_LANTERN.get());
        this.dropSelf(GDModBlocks.GOLDEN_BONE_BLOCK.get());
        this.dropSelf(GDModBlocks.GOLDEN_BUTTON.get());
        this.dropSelf(GDModBlocks.GOLDEN_CARVED_PUMPKIN.get());
        this.add(GDModBlocks.GOLDEN_DOOR.get(), block -> createDoorTable(GDModBlocks.GOLDEN_DOOR.get()));
        this.dropSelf(GDModBlocks.GOLDEN_FENCE.get());
        this.dropSelf(GDModBlocks.GOLDEN_FENCE_GATE.get());
        this.dropSelf(GDModBlocks.GOLDEN_HANGING_SIGN.get());
        this.dropSelf(GDModBlocks.GOLDEN_HYPHAE.get());
        this.add(GDModBlocks.GOLDEN_MUSHROOM_BLOCK.get(), block -> createMushroomBlockDrop(block, GDModBlocks.GOLDEN_MUSHROOM.get()));
        this.dropWhenSilkTouch(GDModBlocks.GOLDEN_MUSHROOM_STEM.get());
        this.dropSelf(GDModBlocks.GOLDEN_NETHER_BRICKS.get());
        this.dropSelf(GDModBlocks.GOLDEN_NETHER_BRICK_FENCE.get());
        this.dropSelf(GDModBlocks.GOLDEN_NETHER_BRICK_WALL.get());
        this.add(GDModBlocks.GOLDEN_NETHER_BRICK_SLAB.get(), block -> createSlabItemTable(GDModBlocks.GOLDEN_NETHER_BRICK_SLAB.get()));
        this.dropSelf(GDModBlocks.GOLDEN_NETHER_BRICK_STAIRS.get());
        this.dropSelf(GDModBlocks.GOLDEN_PLANKS.get());
        this.dropSelf(GDModBlocks.GOLDEN_PRESSURE_PLATE.get());
        this.dropSelf(GDModBlocks.GOLDEN_SIGN.get());
        this.add(GDModBlocks.GOLDEN_SLAB.get(), block -> createSlabItemTable(GDModBlocks.GOLDEN_SLAB.get()));
        this.dropSelf(GDModBlocks.GOLDEN_STAIRS.get());
        this.dropSelf(GDModBlocks.GOLDEN_STEM.get());
        this.dropSelf(GDModBlocks.GOLDEN_TRAPDOOR.get());
        this.dropSelf(GDModBlocks.GROOMLIGHT.get());
        this.dropSelf(GDModBlocks.STRIPPED_GOLDEN_STEM.get());
        this.dropSelf(GDModBlocks.STRIPPED_GOLDEN_HYPHAE.get());
        this.dropSelf(GDModBlocks.GOLDEN_WART_BLOCK.get());
        this.dropOther(GDModBlocks.GOLDEN_WALL_SIGN.get(), GDModBlocks.GOLDEN_SIGN.get());
        this.dropOther(GDModBlocks.GOLDEN_WALL_HANGING_SIGN.get(), GDModBlocks.GOLDEN_HANGING_SIGN.get());
        this.dropSelf(GDModBlocks.GOLDEN_HONEY_BLOCK.get());
        this.dropSelf(GDModBlocks.GOLDEN_HONEYCOMB_BLOCK.get());
        this.add(GDModBlocks.GOLDEN_BEEHIVE.get(),
                block -> createGoldenBeeHiveDrop(GDModBlocks.GOLDEN_BEEHIVE.get()));
        this.dropSelf(GDModBlocks.ANCIENT_GOLD_BLOCK.get());
        this.add(GDModBlocks.POTTED_GOLDEN_CACTUS.get(),
                block -> createPotFlowerItemTable(GDModBlocks.GOLDEN_CACTUS.get()));
        this.add(GDModBlocks.POTTED_GOLDEN_MUSHROOM.get(),
                block -> createPotFlowerItemTable(GDModBlocks.GOLDEN_MUSHROOM.get()));
        this.add(GDModBlocks.POTTED_GOLDEN_FUNGUS.get(),
                block -> createPotFlowerItemTable(GDModBlocks.GOLDEN_FUNGUS.get()));

    }

    private void registerMinecraftCrops() {
        this.dropSelf(GDModBlocks.GOLDEN_CACTUS.get());
        this.dropOther(GDModBlocks.CANDLE_GOLDEN_CAKE.get(), Items.CANDLE);
        this.dropOther(GDModBlocks.BLACK_CANDLE_GOLDEN_CAKE.get(), Items.BLACK_CANDLE);
        this.dropOther(GDModBlocks.BLUE_CANDLE_GOLDEN_CAKE.get(), Items.BLUE_CANDLE);
        this.dropOther(GDModBlocks.BROWN_CANDLE_GOLDEN_CAKE.get(), Items.BROWN_CANDLE);
        this.dropOther(GDModBlocks.CYAN_CANDLE_GOLDEN_CAKE.get(), Items.CYAN_CANDLE);
        this.dropOther(GDModBlocks.GRAY_CANDLE_GOLDEN_CAKE.get(), Items.GRAY_CANDLE);
        this.dropOther(GDModBlocks.GREEN_CANDLE_GOLDEN_CAKE.get(), Items.GREEN_CANDLE);
        this.dropOther(GDModBlocks.LIGHT_BLUE_CANDLE_GOLDEN_CAKE.get(), Items.LIGHT_BLUE_CANDLE);
        this.dropOther(GDModBlocks.LIGHT_GRAY_CANDLE_GOLDEN_CAKE.get(), Items.LIGHT_GRAY_CANDLE);
        this.dropOther(GDModBlocks.LIME_CANDLE_GOLDEN_CAKE.get(), Items.LIME_CANDLE);
        this.dropOther(GDModBlocks.MAGENTA_CANDLE_GOLDEN_CAKE.get(), Items.MAGENTA_CANDLE);
        this.dropOther(GDModBlocks.ORANGE_CANDLE_GOLDEN_CAKE.get(), Items.ORANGE_CANDLE);
        this.dropOther(GDModBlocks.PINK_CANDLE_GOLDEN_CAKE.get(), Items.PINK_CANDLE);
        this.dropOther(GDModBlocks.PURPLE_CANDLE_GOLDEN_CAKE.get(), Items.PURPLE_CANDLE);
        this.dropOther(GDModBlocks.RED_CANDLE_GOLDEN_CAKE.get(), Items.RED_CANDLE);
        this.dropOther(GDModBlocks.WHITE_CANDLE_GOLDEN_CAKE.get(), Items.WHITE_CANDLE);
        this.dropOther(GDModBlocks.YELLOW_CANDLE_GOLDEN_CAKE.get(), Items.YELLOW_CANDLE);
        this.dropSelf(GDModBlocks.GOLDEN_HAY_BLOCK.get());
        this.add(GDModBlocks.GOLDEN_MELON.get(),
                block -> createCropBlock(GDModBlocks.GOLDEN_MELON.get(), GDModItems.GOLDEN_MELON_SLICE.get()));
        this.dropSelf(GDModBlocks.GOLDEN_PUMPKIN.get());
        this.add(GDModBlocks.ATTACHED_GOLDEN_MELON_STEM.get(),
                block -> createAttachedStemDrops(GDModBlocks.ATTACHED_GOLDEN_MELON_STEM.get(), GDModItems.GOLDEN_MELON_SEEDS.get()));

        this.add(GDModBlocks.ATTACHED_GOLDEN_PUMPKIN_STEM.get(),
                block -> createAttachedStemDrops(GDModBlocks.ATTACHED_GOLDEN_PUMPKIN_STEM.get(), GDModItems.GOLDEN_PUMPKIN_SEEDS.get()));

        this.add(GDModBlocks.GOLDEN_CARROTS.get(),
                block -> applyExplosionDecay(GDModBlocks.GOLDEN_CARROTS.get(), LootTable.lootTable().withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(Items.GOLDEN_CARROT))).withPool(LootPool.lootPool().when(goldenCarrot)
                        .add(LootItem.lootTableItem(Items.GOLDEN_CARROT).apply(ApplyBonusCount.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.5714286F, 3))))));

        this.add(GDModBlocks.GOLDEN_CAVE_VINES.get(), block -> createGoldenCaveVinesDrop(GDModBlocks.GOLDEN_CAVE_VINES.get()));
        this.add(GDModBlocks.GOLDEN_CAVE_VINES_PLANT.get(), block -> createGoldenCaveVinesDrop(GDModBlocks.GOLDEN_CAVE_VINES_PLANT.get()));

        this.add(GDModBlocks.GOLDEN_CHORUS_FLOWER.get(),
                block -> LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(this.applyExplosionCondition(block, LootItem.lootTableItem(block)).when(LootItemEntityPropertyCondition.entityPresent(LootContext.EntityTarget.THIS)))));

        this.add(GDModBlocks.GOLDEN_CHORUS_PLANT.get(), createSingleItemTable(ItemRegistry.GOLDEN_CHORUS_FRUIT.get(), UniformGenerator.between(0.0F, 1.0F)));

        this.add(GDModBlocks.GOLDEN_COCOA.get(), block -> LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                .add(this.applyExplosionDecay(block, LootItem.lootTableItem(GDModItems.GOLDEN_COCOA_BEANS.get()).apply(SetItemCountFunction.setCount(ConstantValue.exactly(3.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CocoaBlock.AGE, 2))))))));

        this.add(GDModBlocks.GOLDEN_MELON_STEM.get(),
                block -> createStemDrops(GDModBlocks.GOLDEN_MELON_STEM.get(), GDModItems.GOLDEN_MELON_SEEDS.get()));
        this.dropSelf(GDModBlocks.GOLDEN_MUSHROOM.get());
        this.dropSelf(GDModBlocks.GOLDEN_FUNGUS.get());

        this.add(GDModBlocks.GOLDEN_PUMPKIN_STEM.get(),
                block -> createStemDrops(GDModBlocks.GOLDEN_PUMPKIN_STEM.get(), GDModItems.GOLDEN_PUMPKIN_SEEDS.get()));

        this.add(GDModBlocks.GOLDEN_POTATOES.get(),
                block -> applyExplosionDecay(GDModBlocks.GOLDEN_POTATOES.get(), LootTable.lootTable().withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(GDModItems.GOLDEN_POTATO.get()))).withPool(LootPool.lootPool().when(goldenPotato)
                        .add(LootItem.lootTableItem(GDModItems.GOLDEN_POTATO.get()).apply(ApplyBonusCount.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.5714286F, 3)))).withPool(LootPool.lootPool().when(goldenPotato)
                        .add(LootItem.lootTableItem(ItemRegistry.POISONOUS_GOLDEN_POTATO.get()).when(LootItemRandomChanceCondition.randomChance(0.02F))))));

        this.dropOther(GDModBlocks.GOLDEN_SUGAR_CANE.get(), GDModItems.GOLDEN_SUGAR_CANE.get());

        this.add(GDModBlocks.GOLDEN_WHEAT.get(),
                block -> createCropDrops(GDModBlocks.GOLDEN_WHEAT.get(), GDModItems.GOLDEN_WHEAT.get(), GDModItems.GOLDEN_WHEAT_SEEDS.get(), goldenWheat));

        this.add(GDModBlocks.GOLDEN_WART.get(),
                block -> LootTable.lootTable().withPool(this.applyExplosionDecay(block, LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(GDModItems.GOLDEN_WART.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 4.0F)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(GoldenWartBlock.AGE, 3)))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(GoldenWartBlock.AGE, 3))))))));

    }

    private void registerFD() {
        this.add(GDModBlocks.GOLDEN_COOKING_POT.get(), (block) -> LootTable.lootTable().withPool(this.applyExplosionCondition(block, LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(block)
                .apply(CopyNameFunction.copyName(CopyNameFunction.NameSource.BLOCK_ENTITY)).apply(CopyMealFunction.builder())))));
        this.dropSelf(GDModBlocks.GOLDEN_CARROT_CRATE.get());
        this.dropSelf(GDModBlocks.GOLDEN_POTATO_CRATE.get());
        this.dropSelf(GDModBlocks.GOLDEN_BEETROOT_CRATE.get());
        this.dropSelf(GDModBlocks.GOLDEN_CABBAGE_CRATE.get());
        this.dropSelf(GDModBlocks.GOLDEN_TOMATO_CRATE.get());
        this.dropSelf(GDModBlocks.GOLDEN_ONION_CRATE.get());
        this.dropSelf(GDModBlocks.GOLDEN_RICE_BAG.get());
        this.dropSelf(GDModBlocks.GOLDEN_RICE_BALE.get());
        this.dropSelf(GDModBlocks.GOLDEN_COMPOST.get());
        this.dropSelf(GDModBlocks.GOLDEN_SOIL.get());
        this.dropOther(GDModBlocks.GOLDEN_SOIL_FARMLAND.get(), GDModBlocks.GOLDEN_SOIL.get());
        this.dropSelf(GDModBlocks.GOLDEN_CUTTING_BOARD.get());

        this.add(GDModBlocks.GOLDEN_CABBAGE_CROP.get(),
                block -> createCropDrops(GDModBlocks.GOLDEN_CABBAGE_CROP.get(), GDModItems.GOLDEN_CABBAGE.get(), GDModItems.GOLDEN_CABBAGE_SEEDS.get(), goldenCabbage));

        this.add(GDModBlocks.GOLDEN_ONION_CROP.get(),
                block -> applyExplosionDecay(GDModBlocks.GOLDEN_ONION_CROP.get(), LootTable.lootTable().withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(GDModItems.GOLDEN_ONION.get()))).withPool(LootPool.lootPool().when(goldenOnion)
                        .add(LootItem.lootTableItem(GDModItems.GOLDEN_ONION.get()).apply(ApplyBonusCount.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.5714286F, 3))))));

        this.add(GDModBlocks.BUDDING_GOLDEN_TOMATO_CROP.get(),
                block -> applyExplosionDecay(GDModBlocks.BUDDING_GOLDEN_TOMATO_CROP.get(),
                        LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(GDModItems.GOLDEN_TOMATO_SEEDS.get())))));

        this.add(GDModBlocks.GOLDEN_RICE_CROP.get(),
                block -> applyExplosionDecay(GDModBlocks.GOLDEN_RICE_CROP.get(),
                        LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(GDModItems.GOLDEN_RICE.get())))));

        this.dropSelf(GDModBlocks.NETHER_BRICK_STOVE.get());
        this.dropNamedContainer(GDModBlocks.GOLDEN_CABINET.get());
    }

    protected LootTable.Builder createCropBlock(Block pBlock, Item pItem) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(pItem)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0F, 7.0F)))
                        .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))))
                .apply(LimitCount.limitCount(IntRange.upperBound(9)));
    }

    protected void add(Block block, LootTable.Builder builder) {
        this.generatedLootTables.add(block);
        this.map.put(block.getLootTable(), builder);
    }

    protected void dropNamedContainer(Block block) {
        add(block, this::createNameableBlockEntityTable);
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return generatedLootTables;
    }
}
