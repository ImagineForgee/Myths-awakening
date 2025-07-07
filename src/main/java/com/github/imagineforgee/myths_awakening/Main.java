package com.github.imagineforgee.myths_awakening;

import com.github.imagineforgee.myths_awakening.registries.CreativeTabs;
import com.github.imagineforgee.myths_awakening.registries.Entitys;
import com.github.imagineforgee.myths_awakening.registries.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Constants.MODID)
public class Main {

    public Main() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        CreativeTabs.TABS.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);
        Entitys.register(modEventBus);
        Items.register(modEventBus);
    }
}
