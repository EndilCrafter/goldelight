package net.endil.goldelight.common.registry;

import net.endil.goldelight.GolDelight;
import net.endil.goldelight.common.block.entity.container.GoldenCookingPotMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class GDModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENU_TYPES =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, GolDelight.MOD_ID);

    public static void register(IEventBus eventBus) {
        MENU_TYPES.register(eventBus);
    }

    public static final RegistryObject<MenuType<GoldenCookingPotMenu>> GOLDEN_COOKING_POT =
            MENU_TYPES.register("golden_cooking_pot", () -> IForgeMenuType.create(GoldenCookingPotMenu::new));


}
