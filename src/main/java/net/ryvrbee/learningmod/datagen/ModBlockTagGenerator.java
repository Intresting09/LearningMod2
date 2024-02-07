package net.ryvrbee.learningmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.ryvrbee.learningmod.LearningMod;
import net.ryvrbee.learningmod.block.ModBlocks;
import net.ryvrbee.learningmod.util.tags.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {

    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, LearningMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.RAW_WOITR_BLOCK.get(),
                        ModBlocks.WOITR_GEM_BLOCK.get()
                );

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.WOITR_ORE.get()
                );

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.RAW_WOITR_BLOCK.get(),
                        ModBlocks.WOITR_GEM_BLOCK.get()
                        );

        this.tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(ModBlocks.WOITR_ORE.get()
                );

        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL);

        this.tag(BlockTags.FENCES)
                .add(ModBlocks.WOITR_FENCE.get());
        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.WOITR_FENCE_GATE.get());
        this.tag(BlockTags.WALLS)
                .add(ModBlocks.WOITR_WALL.get());



    }
}
