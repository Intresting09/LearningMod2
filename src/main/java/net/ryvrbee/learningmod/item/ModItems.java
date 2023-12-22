package net.ryvrbee.learningmod.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.ryvrbee.learningmod.LearningMod;
import net.ryvrbee.learningmod.item.custom.FuelItem;
import net.ryvrbee.learningmod.item.custom.WoitrWandItem;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, LearningMod.MOD_ID);

    public static final RegistryObject<Item> TWIG = ITEMS.register("twig",
            () -> new FuelItem(new Item.Properties(), 200));
    public static final RegistryObject<Item> WOITR = ITEMS.register("woitr",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WOITR_GEM = ITEMS.register("woitr_gem",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WOITR_WAND = ITEMS.register("woitr_wand",
            () -> new WoitrWandItem(new Item.Properties().durability(300)));
    public static final RegistryObject<Item> PIZZA = ITEMS.register("pizza",
            () -> new Item(new Item.Properties().food(ModFoods.PIZZA)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
