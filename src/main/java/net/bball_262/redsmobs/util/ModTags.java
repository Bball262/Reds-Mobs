package net.bball_262.redsmobs.util;

import net.bball_262.redsmobs.RedsMobs;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;

public class ModTags {

    public static void init() {
        Biomes.init();
        Blocks.init();
    }

    public static class Biomes {
        public static final TagKey<Biome> IS_WARM_OCEAN = create("is_warm_ocean");
        public static final TagKey<Biome> IS_SNAIL_ALLOWED = create("is_snail_allowed");

        public static void init() {
        }

        private static TagKey<Biome> create(String name) {
            return TagKey.create(Registries.BIOME, new ResourceLocation(RedsMobs.MODID, name));
        }
    }

    public static class Blocks {

        public static final TagKey<Block> SNAIL_SPAWNABLE_ON = create("snail_spawnable_on");

        public static void init() {
        }

        private static TagKey<Block> create(String name) {
            return TagKey.create(Registries.BLOCK, new ResourceLocation(RedsMobs.MODID, name));
        }
    }
}