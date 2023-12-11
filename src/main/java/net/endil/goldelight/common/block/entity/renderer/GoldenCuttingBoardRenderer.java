package net.endil.goldelight.common.block.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.endil.goldelight.common.block.entity.GoldenCuttingBoardBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.core.Direction;
import net.minecraft.world.item.*;
import vectorwing.farmersdelight.common.block.CuttingBoardBlock;
import vectorwing.farmersdelight.common.tag.ModTags;

public class GoldenCuttingBoardRenderer implements BlockEntityRenderer<GoldenCuttingBoardBlockEntity> {
    public GoldenCuttingBoardRenderer(BlockEntityRendererProvider.Context pContext) {
    }

    public void render(GoldenCuttingBoardBlockEntity goldenCuttingBoardBlockEntity, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        Direction direction = goldenCuttingBoardBlockEntity.getBlockState().getValue(CuttingBoardBlock.FACING).getOpposite();
        ItemStack boardStack = goldenCuttingBoardBlockEntity.getStoredItem();
        int posLong = (int)goldenCuttingBoardBlockEntity.getBlockPos().asLong();
        if (!boardStack.isEmpty()) {
            poseStack.pushPose();
            ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
            poseStack.pushPose();
            boolean isBlockItem = itemRenderer.getModel(boardStack, goldenCuttingBoardBlockEntity.getLevel(), null, 0).applyTransform(ItemDisplayContext.FIXED, poseStack, false).isGui3d();
            poseStack.popPose();
            if (goldenCuttingBoardBlockEntity.isItemCarvingBoard()) {
                this.renderItemCarved(poseStack, direction, boardStack);
            } else if (isBlockItem && !boardStack.is(ModTags.FLAT_ON_CUTTING_BOARD)) {
                this.renderBlock(poseStack, direction);
            } else {
                this.renderItemLayingDown(poseStack, direction);
            }

            Minecraft.getInstance().getItemRenderer().renderStatic(boardStack, ItemDisplayContext.FIXED, combinedLight, combinedOverlay, poseStack, buffer, goldenCuttingBoardBlockEntity.getLevel(), posLong);
            poseStack.popPose();
        }

    }

    public void renderItemLayingDown(PoseStack matrixStackIn, Direction direction) {
        matrixStackIn.translate(0.5, 0.08, 0.5);
        float f = -direction.toYRot();
        matrixStackIn.mulPose(Axis.YP.rotationDegrees(f));
        matrixStackIn.mulPose(Axis.XP.rotationDegrees(90.0F));
        matrixStackIn.scale(0.6F, 0.6F, 0.6F);
    }

    public void renderBlock(PoseStack matrixStackIn, Direction direction) {
        matrixStackIn.translate(0.5, 0.27, 0.5);
        float f = -direction.toYRot();
        matrixStackIn.mulPose(Axis.YP.rotationDegrees(f));
        matrixStackIn.scale(0.8F, 0.8F, 0.8F);
    }

    public void renderItemCarved(PoseStack matrixStackIn, Direction direction, ItemStack itemStack) {
        matrixStackIn.translate(0.5, 0.23, 0.5);
        float f = -direction.toYRot() + 180.0F;
        matrixStackIn.mulPose(Axis.YP.rotationDegrees(f));
        Item toolItem = itemStack.getItem();
        float poseAngle;
        if (!(toolItem instanceof PickaxeItem) && !(toolItem instanceof HoeItem)) {
            if (toolItem instanceof TridentItem) {
                poseAngle = 135.0F;
            } else {
                poseAngle = 180.0F;
            }
        } else {
            poseAngle = 225.0F;
        }

        matrixStackIn.mulPose(Axis.ZP.rotationDegrees(poseAngle));
        matrixStackIn.scale(0.6F, 0.6F, 0.6F);
    }
}
