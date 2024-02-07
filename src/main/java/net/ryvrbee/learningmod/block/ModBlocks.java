package net.ryvrbee.learningmod.block;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.ryvrbee.learningmod.LearningMod;
import net.ryvrbee.learningmod.block.custom.IgnitionBlock;
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

    public static final RegistryObject<Block> WOITR_STAIRS = registerBlock( "woitr_stairs",
            () -> new StairBlock(() -> ModBlocks.WOITR_GEM_BLOCK.get().defaultBlockState(),
                BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK)
                        .sound(SoundType.AMETHYST).strength(20.0F, 1200.0F).mapColor(MapColor.COLOR_CYAN)));
    public static final RegistryObject<Block> WOITR_SLAB = registerBlock( "woitr_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK)
                    .sound(SoundType.AMETHYST).strength(20.0F, 1200.0F).mapColor(MapColor.COLOR_CYAN)));

    public static final RegistryObject<Block> WOITR_BUTTON = registerBlock( "woitr_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON)
                    .sound(SoundType.AMETHYST).strength(20.0F, 1200.0F).mapColor(MapColor.COLOR_CYAN),
                    BlockSetType.WARPED, 30, false));
    public static final RegistryObject<Block> WOITR_PRESSURE_PLATE = registerBlock( "woitr_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK)
                    .sound(SoundType.AMETHYST).strength(20.0F, 1200.0F).mapColor(MapColor.COLOR_CYAN),
                    BlockSetType.WARPED));

    public static final RegistryObject<Block> WOITR_FENCE = registerBlock( "woitr_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK)
                    .sound(SoundType.AMETHYST).strength(20.0F, 1200.0F).mapColor(MapColor.COLOR_CYAN)));
    public static final RegistryObject<Block> WOITR_FENCE_GATE = registerBlock( "woitr_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK)
                    .sound(SoundType.AMETHYST).strength(20.0F, 1200.0F).mapColor(MapColor.COLOR_CYAN),
                    SoundEvents.AMETHYST_BLOCK_HIT, SoundEvents.AMETHYST_BLOCK_FALL));
    public static final RegistryObject<Block> WOITR_WALL = registerBlock( "woitr_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK)
                    .sound(SoundType.AMETHYST).strength(20.0F, 1200.0F).mapColor(MapColor.COLOR_CYAN)));

    public static final RegistryObject<Block> WOITR_DOOR = registerBlock( "woitr_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK)
                    .sound(SoundType.AMETHYST).strength(20.0F, 1200.0F).mapColor(MapColor.COLOR_CYAN),
                    BlockSetType.WARPED));
    public static final RegistryObject<Block> WOITR_TRAPDOOR = registerBlock( "woitr_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK)
                    .sound(SoundType.AMETHYST).strength(20.0F, 1200.0F).mapColor(MapColor.COLOR_CYAN),
                    BlockSetType.WARPED));


    public static final RegistryObject<Block> WOITR_ORE = registerBlock("woitr_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.GRAVEL)
                    .strength(3f).requiresCorrectToolForDrops(), UniformInt.of(5, 10)));

    public static final RegistryObject<Block> IGNITION_BLOCK = registerBlock("ignition_block",
            () -> new IgnitionBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

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
