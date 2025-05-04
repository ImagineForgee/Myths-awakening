package com.github.imagineforgee.boss_bits.client;

import com.github.imagineforgee.boss_bits.Constants;
import com.github.imagineforgee.boss_bits.client.renderer.CerberusRenderer;
import com.github.imagineforgee.boss_bits.registries.Entitys;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import java.util.function.BiConsumer;

@Mod.EventBusSubscriber(modid = Constants.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class Client {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {

    }

    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
        registerRenderers(event::registerEntityRenderer);
    }

    private static void registerRenderers(BiConsumer<EntityType<? extends Entity>, EntityRendererProvider> entityRenderers) {
        entityRenderers.accept(Entitys.CERBERUS.get(), CerberusRenderer::new);

        // Uncomment if we ever add blockentitys that require gecko lib
//        blockEntityRenderers.accept(BlockEntityRegistry.GECKO_HABITAT.get(), context -> new GeckoHabitatBlockRenderer());
//        blockEntityRenderers.accept(BlockEntityRegistry.FERTILIZER_BLOCK.get(), context -> new FertilizerBlockRenderer());
    }
}
