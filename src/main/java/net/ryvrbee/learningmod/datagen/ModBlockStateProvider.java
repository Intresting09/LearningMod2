package net.ryvrbee.learningmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.ryvrbee.learningmod.LearningMod;
import net.ryvrbee.learningmod.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, LearningMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.RAW_WOITR_BLOCK);
        blockWithItem(ModBlocks.WOITR_GEM_BLOCK);
        blockWithItem(ModBlocks.WOITR_ORE);
        blockWithItem(ModBlocks.IGNITION_BLOCK);

        stairsBlock(((StairBlock) ModBlocks.WOITR_STAIRS.get()), blockTexture(ModBlocks.WOITR_GEM_BLOCK.get()));
        slabBlock(((SlabBlock) ModBlocks.WOITR_SLAB.get()), blockTexture(ModBlocks.WOITR_GEM_BLOCK.get()), blockTexture(ModBlocks.WOITR_GEM_BLOCK.get()));

        buttonBlock(((ButtonBlock) ModBlocks.WOITR_BUTTON.get()), blockTexture(ModBlocks.WOITR_GEM_BLOCK.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.WOITR_PRESSURE_PLATE.get()), blockTexture(ModBlocks.WOITR_GEM_BLOCK.get()));
        fenceBlock(((FenceBlock) ModBlocks.WOITR_FENCE.get()), blockTexture(ModBlocks.WOITR_GEM_BLOCK.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.WOITR_FENCE_GATE.get()), blockTexture(ModBlocks.WOITR_GEM_BLOCK.get()));
        wallBlock(((WallBlock) ModBlocks.WOITR_WALL.get()), blockTexture(ModBlocks.WOITR_GEM_BLOCK.get()));

        doorBlockWithRenderType(((DoorBlock) ModBlocks.WOITR_DOOR.get()), modLoc("block/woitr_door_bottom"), modLoc("block/woitr_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.WOITR_TRAPDOOR.get()), modLoc("block/woitr_trapdoor"), true, "cutout");


    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
