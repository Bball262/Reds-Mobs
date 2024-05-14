package net.bball_262.redsmobs.event;

import net.bball_262.redsmobs.RedsMobs;
import net.bball_262.redsmobs.entity.ModEntities;
import net.bball_262.redsmobs.entity.client.SnailModel;
import net.bball_262.redsmobs.entity.custom.SnailEntity;
import net.bball_262.redsmobs.entity.layers.ModModelLayers;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RedsMobs.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.SNAIL_LAYER, SnailModel::createBodyLayer);
    }
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.SNAIL.get(), SnailEntity.CreateAttributes().build());
    }
}