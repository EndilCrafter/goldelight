package net.endil.goldelight.common.registry;

import net.endil.goldelight.GolDelight;
import net.endil.goldelight.common.block.entity.*;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class GDModBlockEntityTypes {
    public static final DeferredRegister<BlockEntityType<?>> TILES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, GolDelight.MOD_ID);

    public static void register(IEventBus eventBus) {
        TILES.register(eventBus);
    }

    public static final RegistryObject<BlockEntityType<GDModSignBlockEntity>> MOD_SIGN = TILES.register("mod_sign",
            () -> BlockEntityType.Builder.of(GDModSignBlockEntity::new, GDModBlocks.GOLDEN_SIGN.get(), GDModBlocks.GOLDEN_WALL_SIGN.get()).build(null));

    public static final RegistryObject<BlockEntityType<GDModHangingSignBlockEntity>> MOD_HANGING_SIGN = TILES.register("mod_hanging_sign",
            () -> BlockEntityType.Builder.of(GDModHangingSignBlockEntity::new, GDModBlocks.GOLDEN_HANGING_SIGN.get(), GDModBlocks.GOLDEN_WALL_HANGING_SIGN.get()).build(null));

    public static final RegistryObject<BlockEntityType<NetherBrickStoveEntity>> NETHER_BRICK_STOVE = TILES.register("nether_brick_stove",
            () -> BlockEntityType.Builder.of(NetherBrickStoveEntity::new, GDModBlocks.NETHER_BRICK_STOVE.get()).build(null));

    public static final RegistryObject<BlockEntityType<GoldenCookingPotBlockEntity>> GOLDEN_COOKING_POT = TILES.register("golden_cooking_pot",
            () -> BlockEntityType.Builder.of(GoldenCookingPotBlockEntity::new, GDModBlocks.GOLDEN_COOKING_POT.get()).build(null));

    public static final RegistryObject<BlockEntityType<GoldenCuttingBoardBlockEntity>> GOLDEN_CUTTING_BOARD = TILES.register("golden_cutting_board",
            () -> BlockEntityType.Builder.of(GoldenCuttingBoardBlockEntity::new, GDModBlocks.GOLDEN_CUTTING_BOARD.get()).build(null));

    public static final RegistryObject<BlockEntityType<GoldenBeehiveBlockEntity>> GOLDEN_BEEHIVE = TILES.register("golden_beehive",
            () -> BlockEntityType.Builder.of(GoldenBeehiveBlockEntity::new, GDModBlocks.GOLDEN_BEEHIVE.get()).build(null));


}
