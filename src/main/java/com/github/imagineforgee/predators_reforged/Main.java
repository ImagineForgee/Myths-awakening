package com.github.imagineforgee.predators_reforged;

import com.github.imagineforgee.predators_reforged.registries.CreativeTabs;
import com.github.imagineforgee.predators_reforged.registries.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Constants.MODID)
public class Main {

    public Main() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        MinecraftForge.EVENT_BUS.register(this);
        CreativeTabs.TABS.register(modEventBus);
        Items.register(modEventBus);
    }

}
