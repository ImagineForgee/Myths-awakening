package com.github.imagineforgee.myths_awakening.registries;

import com.github.imagineforgee.myths_awakening.Constants;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CreativeTabs {
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), Constants.MODID);

    public static final RegistryObject<CreativeModeTab> DUNGEONS_TAB = TABS.register("dungeons_tab", () ->
            CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.myths_awakening.dungeons_tab"))
                    .icon(() -> new ItemStack(Items.DIAMOND))
                    .displayItems((parameters, output) -> {
                        BuiltInRegistries.ITEM.entrySet().stream()
                                .filter(entry -> entry.getKey().location().getNamespace().equals(Constants.MODID))
                                .map(entry -> entry.getValue())
                                .forEach(output::accept);
                    })
                    .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                    .build());
}
