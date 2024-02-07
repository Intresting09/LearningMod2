package net.ryvrbee.learningmod.datagen.loot;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import net.ryvrbee.learningmod.block.ModBlocks;
import net.ryvrbee.learningmod.item.ModItems;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.RAW_WOITR_BLOCK.get());
        this.dropSelf(ModBlocks.WOITR_GEM_BLOCK.get());

        this.add(ModBlocks.WOITR_ORE.get(),
                block -> createOreDrop(ModBlocks.WOITR_ORE.get(), ModItems.WOITR.get()));

        this.dropSelf(ModBlocks.WOITR_STAIRS.get());
        this.dropSelf(ModBlocks.WOITR_TRAPDOOR.get());
        this.dropSelf(ModBlocks.WOITR_BUTTON.get());
        this.dropSelf(ModBlocks.WOITR_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.WOITR_FENCE.get());
        this.dropSelf(ModBlocks.WOITR_FENCE_GATE.get());
        this.dropSelf(ModBlocks.WOITR_WALL.get());

        this.add(ModBlocks.WOITR_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.WOITR_SLAB.get()));
        this.add(ModBlocks.WOITR_DOOR.get(),
                block -> createDoorTable(ModBlocks.WOITR_DOOR.get()));

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
