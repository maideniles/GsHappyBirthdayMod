package com.mamailes.gabbysgrove.entity.client.render;

import com.mamailes.gabbysgrove.entity.Moth;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class MothGeoRenderer extends GeoEntityRenderer<Moth> {
    public MothGeoRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new MothGeoModel());
    }

    @Override
    public void scaleModelForRender(float widthScale, float heightScale, PoseStack poseStack, Moth animatable, BakedGeoModel model, boolean isReRender, float partialTick, int packedLight, int packedOverlay) {
        if(animatable.isBaby()){
            super.scaleModelForRender(widthScale * 0.5F, heightScale * 0.5F, poseStack, animatable, model, isReRender, partialTick, packedLight, packedOverlay);
        } else{
            super.scaleModelForRender(widthScale, heightScale, poseStack, animatable, model, isReRender, partialTick, packedLight, packedOverlay);
        }
    }

    @Override
    public void preRender(PoseStack poseStack, Moth animatable, BakedGeoModel model, @Nullable MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int colour) {
        this.model.getBone("saddle2").ifPresent(saddle2 -> saddle2.setHidden(!animatable.isSaddled()));
        super.preRender(poseStack, animatable, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, colour);
    }
}
