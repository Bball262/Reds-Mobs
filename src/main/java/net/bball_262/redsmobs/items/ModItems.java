package net.bball_262.redsmobs.items;

import net.bball_262.redsmobs.RedsMobs;
import net.bball_262.redsmobs.entity.ModEntities;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.MobBucketItem;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.WaterFluid;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RedsMobs.MODID);

    public static final RegistryObject<Item> SNAIL_SPAWN_EGG = ITEMS.register("snail_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.SNAIL,
                    0xBF7D00,
                    0xFAE22D,
                    new Item.Properties()));
    public static final RegistryObject<Item> HUMUHUMU_SPAWN_EGG = ITEMS.register("humuhumunukunukuapuaa_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.HUMUHUMU,
                    0x3AFF23,
                    0x23ACFF,
                    new Item.Properties()));
    public static final RegistryObject<Item> BUCKET_OF_HUMUHUMU = ITEMS.register("bucket_of_humuhumunukunukuapuaa",
            () -> new MobBucketItem(() -> ModEntities.HUMUHUMU.get(),
                    () -> Fluids.WATER,
                    () -> SoundEvents.BUCKET_EMPTY,
                    new Item.Properties()));

    public static final RegistryObject<Item> SNAIL_SHELL = ITEMS.register("snail_shell",
            () -> new Item(new Item.Properties().stacksTo(16)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}