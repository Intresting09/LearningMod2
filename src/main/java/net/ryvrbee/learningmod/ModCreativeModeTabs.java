package net.ryvrbee.learningmod;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.ryvrbee.learningmod.item.ModItems;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, LearningMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> LEARNING_TAB = CREATIVE_MODE_TABS.register("learning_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.WOITR_GEM.get()))
                    .title(Component.translatable("creativetab.learning_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.TWIG.get());
                        pOutput.accept(ModItems.WOITR.get());
                        pOutput.accept(ModItems.WOITR_GEM.get());

                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
