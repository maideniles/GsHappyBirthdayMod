package com.mamailes.gabbysgrove.entity.client.render;

import com.mamailes.gabbysgrove.entity.Moth;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class MothGeoRenderer extends GeoEntityRenderer<Moth> {
    public MothGeoRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new MothGeoModel());
    }
}
