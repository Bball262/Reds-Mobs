package net.bball_262.redsmobs.worldgen;

import net.bball_262.redsmobs.RedsMobs;
import net.bball_262.redsmobs.entity.ModEntities;
import net.bball_262.redsmobs.util.ModTags;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

public class ModBiomeModifiers {
    public static final ResourceKey<BiomeModifier> SPAWN_HUMUHUMU = registerKey("humuhumu_spawn");
    public static final ResourceKey<BiomeModifier> SPAWN_SNAIL = registerKey("snail_spawn");

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var biomes = context.lookup(Registries.BIOME);

        context.register(SPAWN_HUMUHUMU, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(ModTags.Biomes.IS_WARM_OCEAN),
                List.of(new MobSpawnSettings.SpawnerData(ModEntities.HUMUHUMU.get(), 10, 3, 8))));

        context.register(SPAWN_SNAIL, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(ModTags.Biomes.IS_SNAIL_ALLOWED),
                List.of(new MobSpawnSettings.SpawnerData(ModEntities.SNAIL.get(), 15, 1, 2))));
    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(RedsMobs.MODID, name));
    }
}