package com.mamailes.gabbysgrove.event;

import com.mamailes.gabbysgrove.GabbysGrove;
import com.mamailes.gabbysgrove.init.GGParticles;
import com.mamailes.gabbysgrove.particle.LightningBugGlowParticle;
import com.mamailes.gabbysgrove.particle.LightningBugGlowParticle;
import net.minecraft.client.Minecraft;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;

@EventBusSubscriber(modid = GabbysGrove.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerParticleFactories(final RegisterParticleProvidersEvent event) {
        Minecraft.getInstance().particleEngine.register(GGParticles.LBG_PARTICLES.get(),
                LightningBugGlowParticle.LightningBugProvider::new);
    }
}
