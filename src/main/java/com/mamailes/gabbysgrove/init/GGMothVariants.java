package com.mamailes.gabbysgrove.init;

import com.mamailes.gabbysgrove.GabbysGrove;
import com.mamailes.gabbysgrove.entity.MothVariant;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

import java.util.Objects;

public class GGMothVariants {
    public static final ResourceKey<Registry<MothVariant>> MOTH_VARIANT_REGISTRY_KEY = ResourceKey.createRegistryKey(GabbysGrove.prefix("moth_variant"));
    public static final ResourceKey<MothVariant> DEFAULT = createKey("default");

    private static ResourceKey<MothVariant> createKey(String name) {
        return ResourceKey.create(MOTH_VARIANT_REGISTRY_KEY, GabbysGrove.prefix(name));
    }

    static void register(BootstrapContext<MothVariant> context, ResourceKey<MothVariant> key, String name) {
        ResourceLocation textureLocation = GabbysGrove.prefix("entity/moth/" + name);
        context.register(key, new MothVariant(textureLocation));
    }

    public static Holder<MothVariant> getSpawnVariant(RegistryAccess registryAccess) {
        Registry<MothVariant> registry = registryAccess.registryOrThrow(MOTH_VARIANT_REGISTRY_KEY);
        Objects.requireNonNull(registry);
        return registry.getAny().orElseThrow();
    }

    public static void bootstrap(BootstrapContext<MothVariant> context) {
        register(context, DEFAULT, "default");
    }
}
