package net.bball_262.redsmobs.effects;

import net.bball_262.redsmobs.RedsMobs;
import net.bball_262.redsmobs.effects.custom.VenomousEffect;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(Registries.MOB_EFFECT, RedsMobs.MODID);

    public static final RegistryObject<MobEffect> VENOMOUS_EFFECT = MOB_EFFECTS.register("venomous", () ->
            new VenomousEffect());
    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
