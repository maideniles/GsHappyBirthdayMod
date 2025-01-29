package com.mamailes.gabbysgrove.entity.client.render;

import com.mamailes.gabbysgrove.entity.Moth;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
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
}
