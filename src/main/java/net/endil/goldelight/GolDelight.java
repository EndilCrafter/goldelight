package net.endil.goldelight;

import com.mojang.logging.LogUtils;
import net.endil.goldelight.client.GDClientSetup;
import net.endil.goldelight.common.GDCommonSetup;
import net.endil.goldelight.common.block.entity.GoldenBeehiveBlockEntity;
import net.endil.goldelight.common.entity.GoldenBee;
import net.endil.goldelight.common.registry.*;
import net.minecraft.core.BlockPos;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

//I used Farmer's Delight Code as Reference.

@Mod(GolDelight.MOD_ID)
public class GolDelight {

    public static final String MOD_ID = "goldelight";
    public static final RecipeBookType RECIPE_TYPE_GOLDEN_COOKING = RecipeBookType.create("GOLDEN_COOKING");
    private static final Logger LOGGER = LogUtils.getLogger();

    public GolDelight() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        GDModItems.register(modEventBus);

        GDModBlocks.register(modEventBus);

        GDModEffects.register(modEventBus);

        GDModBlockEntityTypes.register(modEventBus);

        GDModEntityTypes.register(modEventBus);

        GDModLootModifier.register(modEventBus);

        GDModEnchantments.register(modEventBus);

        GDModRecipeSerializers.register(modEventBus);

        GDModRecipeTypes.register(modEventBus);

        GDModMenuTypes.register(modEventBus);

        GDModPoiTypes.register(modEventBus);

        GDModTabs.register(modEventBus);

        GDModSounds.register(modEventBus);

        GDModParticles.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);

        modEventBus.addListener(GDClientSetup::init);
        modEventBus.addListener(GDCommonSetup::init);
    }

    public static void sendHiveInfo(Level pLevel, BlockPos pPos, BlockState pBlockState, GoldenBeehiveBlockEntity pHiveBlockEntity) {
    }

    public static void sendBeeInfo(GoldenBee pBee) {
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(GDModItems.GOLDEN_BEEF);
            event.accept(GDModItems.GOLDEN_BREAD);
            event.accept(GDModItems.GOLDEN_CAKE);
            event.accept(GDModItems.GOLDEN_CHICKEN);
            event.accept(GDModItems.GOLDEN_COD);
            event.accept(GDModItems.GOLDEN_COOKIE);
            event.accept(GDModItems.GOLDEN_GLOW_BERRIES);
            event.accept(GDModItems.GOLDEN_HONEY_BOTTLE);
            event.accept(GDModItems.GOLDEN_MELON_SLICE);
            event.accept(GDModItems.GOLDEN_MUSHROOM_STEW);
            event.accept(GDModItems.GOLDEN_MUTTON);
            event.accept(GDModItems.GOLDEN_PORKCHOP);
            event.accept(GDModItems.GOLDEN_POTATO);
            event.accept(GDModItems.GOLDEN_PUFFERFISH);
            event.accept(GDModItems.GOLDEN_RABBIT);
            event.accept(GDModItems.GOLDEN_RABBIT_STEW);
            event.accept(GDModItems.ROTTEN_GOLDEN_FLESH);
            event.accept(GDModItems.GOLDEN_SALMON);
            event.accept(GDModItems.GOLDEN_TROPICAL_FISH);
        }
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(GDModBlocks.GOLDEN_STEM);
            event.accept(GDModBlocks.GOLDEN_HYPHAE);
            event.accept(GDModBlocks.STRIPPED_GOLDEN_STEM);
            event.accept(GDModBlocks.STRIPPED_GOLDEN_HYPHAE);
            event.accept(GDModBlocks.GOLDEN_PLANKS);
            event.accept(GDModBlocks.GOLDEN_SLAB);
            event.accept(GDModBlocks.GOLDEN_STAIRS);
            event.accept(GDModBlocks.GOLDEN_PRESSURE_PLATE);
            event.accept(GDModBlocks.GOLDEN_BUTTON);
            event.accept(GDModBlocks.GOLDEN_FENCE);
            event.accept(GDModBlocks.GOLDEN_FENCE_GATE);
            event.accept(GDModBlocks.GOLDEN_DOOR);
            event.accept(GDModBlocks.GOLDEN_TRAPDOOR);
            event.accept(GDModBlocks.GOLDEN_NETHER_BRICKS);
            event.accept(GDModBlocks.CHISELED_GOLDEN_NETHER_BRICKS);
            event.accept(GDModBlocks.CRACKED_GOLDEN_NETHER_BRICKS);
            event.accept(GDModBlocks.GOLDEN_NETHER_BRICK_SLAB);
            event.accept(GDModBlocks.GOLDEN_NETHER_BRICK_STAIRS);
            event.accept(GDModBlocks.GOLDEN_NETHER_BRICK_FENCE);
            event.accept(GDModBlocks.GOLDEN_NETHER_BRICK_WALL);
            event.accept(GDModItems.ANCIENT_GOLD_BLOCK);
        }
        if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(GDModItems.GOLDEN_COCOA_BEANS);
            event.accept(GDModItems.GOLDEN_GLOW_BERRIES);
            event.accept(GDModItems.GOLDEN_MELON_SEEDS);
            event.accept(GDModItems.GOLDEN_PUMPKIN_SEEDS);
            event.accept(GDModItems.GOLDEN_SUGAR_CANE);
            event.accept(GDModItems.GOLDEN_WART);
            event.accept(GDModItems.GOLDEN_WHEAT_SEEDS);
            event.accept(GDModBlocks.GOL_D_LANTERN);
            event.accept(GDModBlocks.GOLDEN_CACTUS);
            event.accept(GDModBlocks.GOLDEN_CARVED_PUMPKIN);
            event.accept(GDModBlocks.GOLDEN_CHORUS_FLOWER);
            event.accept(GDModBlocks.GOLDEN_CHORUS_PLANT);
            event.accept(GDModBlocks.GOLDEN_HAY_BLOCK);
            event.accept(GDModBlocks.GOLDEN_HONEY_BLOCK);
            event.accept(GDModBlocks.GOLDEN_HONEYCOMB_BLOCK);
            event.accept(GDModBlocks.GOLDEN_MELON);
            event.accept(GDModBlocks.GOLDEN_MUSHROOM);
            event.accept(GDModBlocks.GOLDEN_FUNGUS);
            event.accept(GDModBlocks.GOLDEN_BONE_BLOCK);
            event.accept(GDModBlocks.GOLDEN_STEM);
            event.accept(GDModBlocks.GOLDEN_MUSHROOM_BLOCK);
            event.accept(GDModBlocks.GOLDEN_MUSHROOM_STEM);
            event.accept(GDModBlocks.GOLDEN_PUMPKIN);
            event.accept(GDModBlocks.GOLDEN_WART_BLOCK);
        }
        if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            event.accept(GDModBlocks.GROOMLIGHT);
            event.accept(GDModItems.GOLDEN_SIGN);
            event.accept(GDModItems.GOLDEN_HANGING_SIGN);
            event.accept(GDModBlocks.GOLDEN_BEEHIVE);
        }
        if (event.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS) {
            event.accept(GDModBlocks.GOLDEN_BUTTON);
        }
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(GDModItems.GOLDEN_MILK_BUCKET);
        }
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(GDModItems.GOLDEN_BONE);
            event.accept(GDModItems.GOLDEN_MEAL);
            event.accept(GDModItems.GOLDEN_EGG);
            event.accept(GDModItems.GOLDEN_INK_SAC);
            event.accept(GDModItems.GOLDEN_SUGAR);
            event.accept(GDModItems.GOLDEN_WHEAT);
            event.accept(GDModItems.GOLDEN_LEATHER);
            event.accept(GDModItems.GOLDEN_FEATHER);
            event.accept(GDModItems.GOLDEN_HONEYCOMB);
            event.accept(GDModItems.ANCIENT_GOLD_DUST);
            event.accept(GDModItems.ANCIENT_GOLD_INGOT);
            event.accept(GDModItems.ANCIENT_GOLD_NUGGET);
            event.accept(GDModItems.ANCIENT_GOLD_UPGRADE_SMITHING_TEMPLATE);
        }
        if (event.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
            event.accept(GDModItems.GOLDEN_COW_SPAWN_EGG);
            event.accept(GDModItems.GOLDEN_CHICKEN_SPAWN_EGG);
            event.accept(GDModItems.GOLDEN_BEE_SPAWN_EGG);
        }

    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
