package com.github.imagineforgee.boss_bits.registries;

import com.github.imagineforgee.boss_bits.Constants;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Items {
    static final List<RegistryObject<? extends Item>> ITEMS_TO_ADD = new ArrayList<>();
    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MODID);

    public static RegistryObject<SpawnEggItem> CERBERUS_EGG = registerSpawnEgg("cerberus", Entitys.CERBERUS, 0x1F1F1F, 0x0D0D0D, new Item.Properties());
    public static RegistryObject<Item> TEMP = registerItem("temp", () -> new Item(new Item.Properties()));

    private static RegistryObject<Item> registerItem(String name, Supplier<Item> itemSupplier) {
        RegistryObject<Item> item = ITEMS.register(name, itemSupplier);
        ITEMS_TO_ADD.add(item);
        return item;
    }

    public static <E extends Mob> RegistryObject<SpawnEggItem> registerSpawnEgg(String name, Supplier<EntityType<E>> entityType, int primaryEggColour, int secondaryEggColour, Item.Properties itemProperties) {
        RegistryObject<SpawnEggItem> egg = ITEMS.register(name,
                () -> new ForgeSpawnEggItem(entityType, primaryEggColour, secondaryEggColour, itemProperties));
        ITEMS_TO_ADD.add(egg);
        return egg;
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
