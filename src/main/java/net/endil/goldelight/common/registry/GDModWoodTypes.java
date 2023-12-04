package net.endil.goldelight.common.registry;

import net.endil.goldelight.GolDelight;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.WoodType;

public class GDModWoodTypes {
    public static final WoodType GOLDEN = register("golden");

    private static WoodType register(final String name) {
        return WoodType.register(new WoodType(new ResourceLocation(GolDelight.MOD_ID, name).toString(), GDModBlockSetTypes.GOLDEN));
    }
}
