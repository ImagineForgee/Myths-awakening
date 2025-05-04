package com.github.imagineforgee.boss_bits.client.renderer;

import com.github.imagineforgee.boss_bits.entitys.cerberus.Cerberus;
import com.github.imagineforgee.boss_bits.entitys.cerberus.CerberusEntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class CerberusRenderer extends GeoEntityRenderer<Cerberus> {
    public CerberusRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new CerberusEntityModel());
        this.shadowRadius = 0.5f;
    }
}
