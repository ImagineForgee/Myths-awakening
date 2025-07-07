package com.github.imagineforgee.myths_awakening.events;

import com.github.imagineforgee.myths_awakening.Constants;
import com.github.imagineforgee.myths_awakening.entitys.cerberus.Cerberus;
import com.github.imagineforgee.myths_awakening.registries.Entitys;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Constants.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityAttributeCreation {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(Entitys.CERBERUS.get(), Cerberus.createAttributes().build());
    }
}
