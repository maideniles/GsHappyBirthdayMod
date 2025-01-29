package com.mamailes.gabbysgrove.init;

import com.mamailes.gabbysgrove.GabbysGrove;
import com.mamailes.gabbysgrove.particle.LightningBugGlowParticle;
import com.mamailes.gabbysgrove.particle.LightningBugGlowParticle;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;


@EventBusSubscriber(modid = GabbysGrove.MODID,bus = EventBusSubscriber.Bus.MOD)
public class GGParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES =
            DeferredRegister.create(BuiltInRegistries.PARTICLE_TYPE, GabbysGrove.MODID);

    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> LBG_PARTICLES = PARTICLE_TYPES.register("lbg_particles", () -> new SimpleParticleType(true));




    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void registerFactories(RegisterParticleProvidersEvent event) {

        event.registerSpriteSet(GGParticles.LBG_PARTICLES.get(), LightningBugGlowParticle.LightningBugProvider::new);

    }

    public static void register(IEventBus eventBus) {
        PARTICLE_TYPES.register(eventBus);
    }


}
