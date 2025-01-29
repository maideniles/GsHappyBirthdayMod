package com.mamailes.gabbysgrove.entity.client.render;

import com.mamailes.gabbysgrove.entity.Moth;
import com.mamailes.gabbysgrove.init.GGEntities;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class MothGeoModel extends DefaultedEntityGeoModel<Moth> {
    public MothGeoModel() {
        super(GGEntities.MOTH.getId());
    }

    @Override
    public ResourceLocation getTextureResource(Moth animatable) {
        return animatable.getTexture();
    }
}
