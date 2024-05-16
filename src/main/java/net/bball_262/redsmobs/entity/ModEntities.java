package net.bball_262.redsmobs.entity;

import net.bball_262.redsmobs.RedsMobs;
import net.bball_262.redsmobs.entity.custom.Humuhumu;
import net.bball_262.redsmobs.entity.custom.Snail;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, RedsMobs.MODID);

    public static final RegistryObject<EntityType<Snail>> SNAIL =
            ENTITY_TYPES.register("snail", () -> EntityType.Builder.of(Snail::new, MobCategory.CREATURE)
                    .sized(0.2F, 0.2F)
                    .build("snail"));
    public static final RegistryObject<EntityType<Humuhumu>> HUMUHUMU =
            ENTITY_TYPES.register("humuhumunukunukuapuaa", () -> EntityType.Builder.of(Humuhumu::new, MobCategory.WATER_AMBIENT)
                    .sized(0.3F, 0.3F)
                    .build("humuhumunukunukuapuaa"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
