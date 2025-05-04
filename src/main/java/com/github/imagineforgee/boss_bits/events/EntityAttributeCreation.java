package com.github.imagineforgee.boss_bits.events;

import com.github.imagineforgee.boss_bits.Constants;
import com.github.imagineforgee.boss_bits.entitys.HitboxPart;
import com.github.imagineforgee.boss_bits.entitys.cerberus.Cerberus;
import com.github.imagineforgee.boss_bits.registries.Entitys;
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
