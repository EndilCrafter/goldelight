package net.endil.goldelight.client;

import net.endil.goldelight.client.entity.GoldenBeeRenderer;
import net.endil.goldelight.client.entity.GoldenChickenRenderer;
import net.endil.goldelight.client.entity.GoldenCowRenderer;
import net.endil.goldelight.common.gui.GoldenCookingPotScreen;
import net.endil.goldelight.common.registry.GDModEntityTypes;
import net.endil.goldelight.common.registry.GDModMenuTypes;
import net.endil.goldelight.common.registry.GDModWoodTypes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class GDClientSetUp {
    public static void init(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> MenuScreens.register(GDModMenuTypes.GOLDEN_COOKING_POT.get(), GoldenCookingPotScreen::new));
        Sheets.addWoodType(GDModWoodTypes.GOLDEN);
        EntityRenderers.register(GDModEntityTypes.GOLDEN_COW.get(), GoldenCowRenderer::new);
        EntityRenderers.register(GDModEntityTypes.GOLDEN_CHICKEN.get(), GoldenChickenRenderer::new);
        EntityRenderers.register(GDModEntityTypes.GOLDEN_BEE.get(), GoldenBeeRenderer::new);
    }
}
