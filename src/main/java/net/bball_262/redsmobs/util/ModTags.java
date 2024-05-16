package net.bball_262.redsmobs.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public class ModTags {
    private static TagKey<Biome> forgeTag(String name) {
        return TagKey.create(Registries.BIOME, new ResourceLocation("forge", name));
    }

    public static class Biomes {
        public static final TagKey<Biome> SPAWNS_CORAL_REEFS = forgeTag("spawns_coral_reef");
    }
}