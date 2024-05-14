package net.bball_262.redsmobs;

import net.bball_262.redsmobs.effects.ModEffects;
import net.bball_262.redsmobs.entity.ModEntities;
import net.bball_262.redsmobs.items.ModItems;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Forge's config APIs
@Mod.EventBusSubscriber(modid = RedsMobs.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RedsMobsConfig
{
    public static final double PosInf = Double.POSITIVE_INFINITY;
    public static final double NegInf = Double.NEGATIVE_INFINITY;
    public static void callRegisteries(IEventBus eventBus) {
        ModEffects.register(eventBus);
        ModItems.register(eventBus);
        ModEntities.register(eventBus);
    }
}