package com.github.imagineforgee.boss_bits.entitys.cerberus;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;
import org.joml.Quaternionf;
import org.joml.Vector3f;
import software.bernie.geckolib.model.GeoModel;

public class CerberusEntityModel extends GeoModel<Cerberus> {


    @Override
    public ResourceLocation getModelResource(Cerberus animatable) {
        return new ResourceLocation("boss_bits", "geo/cerberus.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Cerberus animatable) {
        return new ResourceLocation("boss_bits", "textures/entity/cerbtextfinal2.png");
    }

    @Override
    public ResourceLocation getAnimationResource(Cerberus animatable) {
        return new ResourceLocation("boss_bits", "animations/cerberus.animation.json");
    }
}
