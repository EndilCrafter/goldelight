package net.endil.goldelight.client;

import net.endil.goldelight.common.gui.GoldenCookingPotScreen;
import net.endil.goldelight.common.registry.GDModMenuTypes;
import net.endil.goldelight.common.registry.GDModWoodTypes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.Sheets;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class GDClientSetup {
    public static void init(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> MenuScreens.register(GDModMenuTypes.GOLDEN_COOKING_POT.get(), GoldenCookingPotScreen::new));
        Sheets.addWoodType(GDModWoodTypes.GOLDEN);
    }
}
