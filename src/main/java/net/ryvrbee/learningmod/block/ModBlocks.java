package net.ryvrbee.learningmod.block;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.ai.behavior.Behavior;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.ryvrbee.learningmod.LearningMod;
import net.ryvrbee.learningmod.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, LearningMod.MOD_ID);

    public static final RegistryObject<Block> RAW_WOITR_BLOCK = registerBlock("raw_woitr_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK)
                    .sound(SoundType.CORAL_BLOCK).strength(20.0F, 1200.0F).mapColor(MapColor.COLOR_CYAN)));
    public static final RegistryObject<Block> WOITR_GEM_BLOCK = registerBlock( "woitr_gem_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK)
                    .sound(SoundType.AMETHYST).strength(20.0F, 1200.0F).mapColor(MapColor.COLOR_CYAN)));

    public static final RegistryObject<Block> WOITR_ORE = registerBlock("woitr_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.GRAVEL)
                    .strength(3f).requiresCorrectToolForDrops(), UniformInt.of(5, 10)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
