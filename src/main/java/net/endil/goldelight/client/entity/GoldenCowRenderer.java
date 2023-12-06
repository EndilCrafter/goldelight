package net.endil.goldelight.client.entity;

import net.endil.goldelight.GolDelight;
import net.endil.goldelight.common.entity.GoldenCow;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class GoldenCowRenderer extends MobRenderer<GoldenCow, GoldenCowModel<GoldenCow>> {
    private static final ResourceLocation GOLDEN_COW_LOCATION = new ResourceLocation(GolDelight.MOD_ID, "textures/entity/golden_cow.png");
    public GoldenCowRenderer(EntityRendererProvider.Context p_173956_) {
        super(p_173956_, new GoldenCowModel<>(p_173956_.bakeLayer(GDModModelLayers.GOLDEN_COW)), 0.7F);
    }

    @Override
    public ResourceLocation getTextureLocation(GoldenCow pEntity) {
        return GOLDEN_COW_LOCATION;
    }
}
