package net.ryvrbee.learningmod.util.tags;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.ryvrbee.learningmod.LearningMod;

public class ModTags {
    public static class Blocks{

        public static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(LearningMod.MOD_ID, name));
        }
    }

    public static class Items {

        public static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(LearningMod.MOD_ID, name));
        }
    }

}
