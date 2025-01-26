package com.mamailes.gabbysgrove.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LightLayer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class LightningBugGlowParticle extends TextureSheetParticle {

    private final boolean checkSkylight;



    LightningBugGlowParticle(ClientLevel p_172409_, SpriteSet p_172410_, double p_172411_, double p_172412_, double p_172413_, double p_172414_, double p_172415_, double p_172416_, boolean checkSkylight) {
        super(p_172409_, p_172411_, p_172412_ - 0.125D, p_172413_, p_172414_, p_172415_, p_172416_);
        this.checkSkylight = checkSkylight;
        this.setSize(0.01F, 0.01F);
        this.pickSprite(p_172410_);
        this.quadSize *= this.random.nextFloat() * 0.6F + 0.6F;
        this.lifetime = (int)(16.0D / (Math.random() * 0.8D + 0.2D));
        this.hasPhysics = false;
        this.friction = 1.0F;
        this.gravity = 0.0F;
    }

    @Override
    public void tick() {
        if (this.checkSkylight && this.level.getBrightness(LightLayer.SKY, BlockPos.containing(this.x, this.y, this.z)) < 8) {
            this.remove();
        }
        super.tick();
    }

    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    @OnlyIn(Dist.CLIENT)
    public static class FlyingBugProvider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprite;

        public FlyingBugProvider(SpriteSet p_108042_) {
            this.sprite = p_108042_;
        }

        public Particle createParticle(SimpleParticleType p_108053_, ClientLevel p_108054_, double p_108055_, double p_108056_, double p_108057_, double p_108058_, double p_108059_, double p_108060_) {
            RandomSource randomsource = p_108054_.random;
            double d0 = randomsource.nextGaussian() * (double)1.0E-6F;
            double d1 = randomsource.nextGaussian() * (double)1.0E-4F;
            double d2 = randomsource.nextGaussian() * (double)1.0E-6F;
            LightningBugGlowParticle suspendedparticle = new LightningBugGlowParticle(p_108054_, this.sprite, p_108055_, p_108056_, p_108057_, d0, d1, d2,true);
            suspendedparticle.setColor(0.9F, 0.4F, 0.5F);
            return suspendedparticle;
        }
    }





    @OnlyIn(Dist.CLIENT)
    public static class LightningBugProvider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprite;

        public LightningBugProvider(SpriteSet p_108063_) {
            this.sprite = p_108063_;
        }

        public Particle createParticle(SimpleParticleType p_108074_, ClientLevel p_108075_, double p_108076_, double p_108077_, double p_108078_, double p_108079_, double p_108080_, double p_108081_) {
            LightningBugGlowParticle suspendedparticle = new LightningBugGlowParticle(p_108075_, this.sprite, p_108076_, p_108077_, p_108078_,0.0D, (double)-0.8F, 0.0D,true);
         //   suspendedparticle.setColor(0.45F, 0.6F, 0.2F);
            return suspendedparticle;
        }
    }





}