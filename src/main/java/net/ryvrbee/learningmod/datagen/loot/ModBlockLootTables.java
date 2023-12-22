package net.ryvrbee.learningmod.datagen.loot;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import net.ryvrbee.learningmod.block.ModBlocks;
import net.ryvrbee.learningmod.item.ModItems;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    protected ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.RAW_WOITR_BLOCK);
        this.dropSelf(ModBlocks.WOITR_GEM_BLOCK);

        this.add(ModBlocks.WOITR_ORE.get(),
                block -> createOreDrop(ModBlocks.WOITR_ORE.get(), ModItems.WOITR.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
