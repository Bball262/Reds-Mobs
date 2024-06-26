package net.bball_262.redsmobs;

import com.mojang.logging.LogUtils;
import net.bball_262.redsmobs.entity.ModEntities;
import net.bball_262.redsmobs.entity.client.HumuhumuRenderer;
import net.bball_262.redsmobs.entity.client.SnailRenderer;
import net.bball_262.redsmobs.items.ModItems;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
@Mod(RedsMobs.MODID)
public class RedsMobs
{
    public static final String MODID = "redsmobs";
    private static final Logger LOGGER = LogUtils.getLogger();

    public RedsMobs()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);
        RedsMobsConfig.callRegisteries(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
            event.accept(ModItems.BUCKET_OF_HUMUHUMU);
            event.accept(ModItems.HUMUHUMU_SPAWN_EGG);
            event.accept(ModItems.SNAIL_SPAWN_EGG);
            event.accept(ModItems.SNAIL_SHELL);
        }
    }
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            event.enqueueWork(() -> {
                EntityRenderers.register(ModEntities.SNAIL.get(), SnailRenderer::new);
                EntityRenderers.register(ModEntities.HUMUHUMU.get(), HumuhumuRenderer::new);
            });
        }
    }
}