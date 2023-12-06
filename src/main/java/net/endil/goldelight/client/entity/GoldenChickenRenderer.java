package net.endil.goldelight.client.entity;

import net.endil.goldelight.GolDelight;
import net.endil.goldelight.common.entity.GoldenChicken;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class GoldenChickenRenderer extends MobRenderer<GoldenChicken, GoldenChickenModel<GoldenChicken>> {
    private static final ResourceLocation GOLDEN_CHICKEN_LOCATION = new ResourceLocation(GolDelight.MOD_ID, "textures/entity/golden_chicken.png");

    public GoldenChickenRenderer(EntityRendererProvider.Context p_173952_) {
        super(p_173952_, new GoldenChickenModel<>(p_173952_.bakeLayer(GDModModelLayers.GOLDEN_CHICKEN)), 0.3F);
    }

    /**
     * Returns the location of an entity's texture.
     */
    @Override
    public ResourceLocation getTextureLocation(GoldenChicken pEntity) {
        return GOLDEN_CHICKEN_LOCATION;
    }

    /**
     * Defines what float the third param in setRotationAngles of ModelBase is
     */
    protected float getBob(GoldenChicken pLivingBase, float pPartialTicks) {
        float f = Mth.lerp(pPartialTicks, pLivingBase.oFlap, pLivingBase.flap);
        float f1 = Mth.lerp(pPartialTicks, pLivingBase.oFlapSpeed, pLivingBase.flapSpeed);
        return (Mth.sin(f) + 1.0F) * f1;
    }
}