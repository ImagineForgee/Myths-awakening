package com.github.imagineforgee.boss_bits;

import com.github.imagineforgee.boss_bits.network.NetworkManager;
import com.github.imagineforgee.boss_bits.registries.CreativeTabs;
import com.github.imagineforgee.boss_bits.registries.Entitys;
import com.github.imagineforgee.boss_bits.registries.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Constants.MODID)
public class Main {

    public Main() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        MinecraftForge.EVENT_BUS.register(this);
        CreativeTabs.TABS.register(modEventBus);
        Entitys.register(modEventBus);
        Items.register(modEventBus);
    }
}
