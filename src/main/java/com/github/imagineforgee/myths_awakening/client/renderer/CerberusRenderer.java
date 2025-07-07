package com.github.imagineforgee.myths_awakening.client.renderer;

import com.github.imagineforgee.myths_awakening.entitys.cerberus.Cerberus;
import com.github.imagineforgee.myths_awakening.entitys.cerberus.CerberusEntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class CerberusRenderer extends GeoEntityRenderer<Cerberus> {
    public CerberusRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new CerberusEntityModel());
        this.shadowRadius = 0.5f;
    }
}
