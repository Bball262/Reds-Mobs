package net.bball_262.redsmobs.event;

import net.bball_262.redsmobs.RedsMobs;
import net.bball_262.redsmobs.entity.ModEntities;
import net.bball_262.redsmobs.entity.client.HumuhumuModel;
import net.bball_262.redsmobs.entity.client.SnailModel;
import net.bball_262.redsmobs.entity.custom.Humuhumu;
import net.bball_262.redsmobs.entity.custom.Snail;
import net.bball_262.redsmobs.entity.layers.ModModelLayers;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.entity.animal.AbstractSchoolingFish;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RedsMobs.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.SNAIL_LAYER, SnailModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.HUMUHUMU_LAYER, HumuhumuModel::createBodyLayer);
    }
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.SNAIL.get(), Snail.CreateAttributes().build());
        event.put(ModEntities.HUMUHUMU.get(), Humuhumu.CreateAttributes().build());
    }

    @SubscribeEvent
    public static void registerSpawnPlacements(SpawnPlacementRegisterEvent event) {
        event.register(ModEntities.HUMUHUMU.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.OCEAN_FLOOR_WG,
                AbstractSchoolingFish::checkMobSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
    }
}