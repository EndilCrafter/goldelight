package net.endil.goldelight.data;

import net.endil.goldelight.GolDelight;
import net.endil.goldelight.common.registry.GDModPoiTypes;
import net.endil.goldelight.common.registry.GDModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.PoiTypeTagsProvider;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModPoiTypeTags extends PoiTypeTagsProvider {
    public ModPoiTypeTags(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pProvider) {
        super(pOutput, pProvider);
    }
    protected void addTags(HolderLookup.@NotNull Provider pProvider) {
        this.tag(GDModTags.PoiTypes.GOLDEN_BEE_HOME).add(GDModPoiTypes.GOLDEN_BEEHIVE.getKey());
    }
}
