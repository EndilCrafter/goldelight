package net.endil.goldelight.data;

import net.endil.goldelight.GolDelight;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.GlobalLootModifierProvider;

public class ModGlobalLootModifier extends GlobalLootModifierProvider {
    public ModGlobalLootModifier(PackOutput output) {
        super(output, GolDelight.MOD_ID);
    }

    @Override
    protected void start() {
    }
}
