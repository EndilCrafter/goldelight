package net.endil.goldelight.client.event;

import net.endil.goldelight.GolDelight;
import net.endil.goldelight.client.entity.*;
import net.endil.goldelight.client.particle.GoldenGlintParticle;
import net.endil.goldelight.client.recipebook.GDModRecipeCategories;
import net.endil.goldelight.common.block.entity.renderer.NetherBrickStoveRenderer;
import net.endil.goldelight.common.registry.GDModBlockEntityTypes;
import net.endil.goldelight.common.registry.GDModEntityTypes;
import net.endil.goldelight.common.registry.GDModParticles;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.client.event.RegisterRecipeBookCategoriesEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = GolDelight.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class GDClientSetupEvents {
    @SubscribeEvent
    public static void onRegisterRecipeBookCategories(RegisterRecipeBookCategoriesEvent event) {
        GDModRecipeCategories.init(event);
    }

    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(GDModModelLayers.GOLDEN_COW, GoldenCowModel::createBodyLayer);
        event.registerLayerDefinition(GDModModelLayers.GOLDEN_CHICKEN, GoldenChickenModel::createBodyLayer);
        event.registerLayerDefinition(GDModModelLayers.GOLDEN_BEE, GoldenBeeModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerBlockEntityRender(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(GDModBlockEntityTypes.MOD_SIGN.get(), SignRenderer::new);
        event.registerBlockEntityRenderer(GDModBlockEntityTypes.MOD_HANGING_SIGN.get(), HangingSignRenderer::new);
        event.registerBlockEntityRenderer(GDModBlockEntityTypes.NETHER_BRICK_STOVE.get(), NetherBrickStoveRenderer::new);
    }

    @SubscribeEvent
    public static void onEntityRendererRegister(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(GDModEntityTypes.GOLDEN_EGG.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer(GDModEntityTypes.ROTTEN_GOLDEN_TOMATO.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer(GDModEntityTypes.GOLDEN_COW.get(), GoldenCowRenderer::new);
        event.registerEntityRenderer(GDModEntityTypes.GOLDEN_CHICKEN.get(), GoldenChickenRenderer::new);
        event.registerEntityRenderer(GDModEntityTypes.GOLDEN_BEE.get(), GoldenBeeRenderer::new);
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void registerParticles(RegisterParticleProvidersEvent event) {
        Minecraft.getInstance().particleEngine.register(GDModParticles.GOLDEN_GLINT.get(), GoldenGlintParticle.GoldenGlintProvider::new);
    }
}
