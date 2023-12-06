package net.endil.goldelight;

import com.mojang.logging.LogUtils;
import net.endil.goldelight.client.GDClientSetUp;
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

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
        modEventBus.addListener(GDClientSetUp::init);
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
