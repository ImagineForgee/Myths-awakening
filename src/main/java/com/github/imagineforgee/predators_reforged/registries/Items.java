package com.github.imagineforgee.predators_reforged.registries;

import com.github.imagineforgee.predators_reforged.Constants;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Items {
    static final List<RegistryObject<Item>> ITEMS_TO_ADD = new ArrayList<>();
    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MODID);

    public static RegistryObject<Item> TEMP = registerItem("temp", () -> new Item(new Item.Properties()));

    private static RegistryObject<Item> registerItem(String name, Supplier<Item> itemSupplier) {
        RegistryObject<Item> item = ITEMS.register(name, itemSupplier);
        ITEMS_TO_ADD.add(item);
        return item;
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
