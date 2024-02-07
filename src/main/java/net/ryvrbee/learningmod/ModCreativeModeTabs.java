package net.ryvrbee.learningmod;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.ryvrbee.learningmod.block.ModBlocks;
import net.ryvrbee.learningmod.item.ModItems;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, LearningMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> LEARNING_TAB = CREATIVE_MODE_TABS.register("learning_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.WOITR_GEM.get()))
                    .title(Component.translatable("creativetab.learning_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.PIZZA.get());
                        pOutput.accept(ModItems.TWIG.get());
                        pOutput.accept(ModBlocks.WOITR_ORE.get());
                        pOutput.accept(ModItems.WOITR.get());
                        pOutput.accept(ModBlocks.RAW_WOITR_BLOCK.get());
                        pOutput.accept(ModItems.WOITR_WAND.get());

                        pOutput.accept(ModItems.WOITR_GEM.get());
                        pOutput.accept(ModBlocks.WOITR_GEM_BLOCK.get());

                        pOutput.accept(ModBlocks.WOITR_STAIRS.get());
                        pOutput.accept(ModBlocks.WOITR_SLAB.get());
                        pOutput.accept(ModBlocks.WOITR_BUTTON.get());
                        pOutput.accept(ModBlocks.WOITR_PRESSURE_PLATE.get());
                        pOutput.accept(ModBlocks.WOITR_FENCE.get());
                        pOutput.accept(ModBlocks.WOITR_FENCE_GATE.get());
                        pOutput.accept(ModBlocks.WOITR_WALL.get());
                        pOutput.accept(ModBlocks.WOITR_DOOR.get());
                        pOutput.accept(ModBlocks.WOITR_TRAPDOOR.get());



                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
