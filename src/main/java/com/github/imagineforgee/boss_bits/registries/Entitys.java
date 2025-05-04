package com.github.imagineforgee.boss_bits.registries;

import com.github.imagineforgee.boss_bits.Constants;
import com.github.imagineforgee.boss_bits.entitys.cerberus.Cerberus;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class Entitys {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(Registries.ENTITY_TYPE, Constants.MODID);

    // Note calculates the hotbox's with e.g., z/16=width, y/16=height
    public static final Supplier<EntityType<Cerberus>> CERBERUS = registerEntity("cerberus", Cerberus::new, 1.5f, 1.5f, 0x1F1F1F, 0x0D0D0D);

    private static <T extends Mob> Supplier<EntityType<T>> registerEntity(String name, EntityType.EntityFactory<T> entity, float width, float height, int primaryEggColor, int secondaryEggColor) {
        return ENTITIES.register(name, () -> EntityType.Builder.of(entity, MobCategory.CREATURE).sized(width, height).build(name));
    }

    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }
}
