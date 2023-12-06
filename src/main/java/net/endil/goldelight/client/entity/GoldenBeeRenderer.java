package net.endil.goldelight.client.entity;

import net.endil.goldelight.GolDelight;
import net.endil.goldelight.common.entity.GoldenBee;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class GoldenBeeRenderer extends MobRenderer<GoldenBee, GoldenBeeModel<GoldenBee>> {
    private static final ResourceLocation ANGRY_BEE_TEXTURE = new ResourceLocation(GolDelight.MOD_ID, "textures/entity/golden_bee/golden_bee_angry.png");
    private static final ResourceLocation ANGRY_NECTAR_BEE_TEXTURE = new ResourceLocation(GolDelight.MOD_ID, "textures/entity/golden_bee/golden_bee_angry_nectar.png");
    private static final ResourceLocation BEE_TEXTURE = new ResourceLocation(GolDelight.MOD_ID, "textures/entity/golden_bee/golden_bee.png");
    private static final ResourceLocation NECTAR_BEE_TEXTURE = new ResourceLocation(GolDelight.MOD_ID, "textures/entity/golden_bee/golden_bee_nectar.png");

    public GoldenBeeRenderer(EntityRendererProvider.Context p_173931_) {
        super(p_173931_, new GoldenBeeModel(p_173931_.bakeLayer(GDModModelLayers.GOLDEN_BEE)), 0.4F);
    }

    /**
     * Returns the location of an entity's texture.
     */
    public ResourceLocation getTextureLocation(GoldenBee pEntity) {
        if (pEntity.isAngry()) {
            return pEntity.hasNectar() ? ANGRY_NECTAR_BEE_TEXTURE : ANGRY_BEE_TEXTURE;
        } else {
            return pEntity.hasNectar() ? NECTAR_BEE_TEXTURE : BEE_TEXTURE;
        }
    }
}