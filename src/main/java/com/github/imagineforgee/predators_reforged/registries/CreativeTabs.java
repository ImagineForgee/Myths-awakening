package com.github.imagineforgee.predators_reforged.registries;

import com.github.imagineforgee.predators_reforged.Constants;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CreativeTabs {
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), Constants.MODID);

    public static final RegistryObject<CreativeModeTab> DUNGEONS_TAB = TABS.register("predators_reforged_tab", () ->
            CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.predators_reforged.predators_reforged_tab"))
                    .icon(() -> new ItemStack(Items.DIAMOND))
                    .displayItems((parameters, output) -> {
                        com.github.imagineforgee.predators_reforged.registries.Items.ITEMS_TO_ADD.forEach(item -> output.accept(item.get()));
                    })
                    .build());
}
