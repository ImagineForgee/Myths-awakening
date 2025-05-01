package com.github.imagineforgee.predators_reforged.client;

import com.github.imagineforgee.predators_reforged.Constants;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Constants.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class Client {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {

    }
}
