package com.mamailes.gabbysgrove.event;

import com.mamailes.gabbysgrove.GabbysGrove;
import com.mamailes.gabbysgrove.entity.Moth;
import com.mamailes.gabbysgrove.entity.client.render.MothGeoRenderer;
import com.mamailes.gabbysgrove.init.GGEntities;
import com.mamailes.gabbysgrove.init.GGParticles;
import com.mamailes.gabbysgrove.particle.LightningBugGlowParticle;
import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@EventBusSubscriber(modid = GabbysGrove.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    static void onEntityAttributeCreation(EntityAttributeCreationEvent event){
        event.put(GGEntities.MOTH.get(), Moth.createAttributes().build());
    }

    @EventBusSubscriber(modid = GabbysGrove.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class Client {

        @SubscribeEvent
        public static void registerParticleFactories(final RegisterParticleProvidersEvent event) {
            Minecraft.getInstance().particleEngine.register(GGParticles.LBG_PARTICLES.get(),
                    LightningBugGlowParticle.LightningBugProvider::new);
        }

        @SubscribeEvent
        public static void registerParticleFactories(final EntityRenderersEvent.RegisterRenderers event) {
            event.registerEntityRenderer(GGEntities.MOTH.get(), MothGeoRenderer::new);
        }
    }
}
