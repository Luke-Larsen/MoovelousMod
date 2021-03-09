package com.lukehanslarsen.Moovelous.setup;

import com.lukehanslarsen.Moovelous.MoovelousMod;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;

public class ModTags {
	public static final class Blocks{
		public static final ITag.INamedTag<Block> COW_BEE_HIVE = forge("misc/cow_bee_hive");
		
				
		private static ITag.INamedTag<Block> forge(String path){
			return BlockTags.makeWrapperTag(new ResourceLocation("forge",path).toString());
		}
		private static ITag.INamedTag<Block> mod(String path){
			return BlockTags.makeWrapperTag(new ResourceLocation(MoovelousMod.MOD_ID,path).toString());
		}
	}
	
	public static final class Items{
		public static final ITag.INamedTag<Item> COW_BEE_HIVE = forge("misc/cow_bee_hive");
		public static final ITag.INamedTag<Item> HONEY_MILK = forge("misc/honey_milk");
		
		private static ITag.INamedTag<Item> forge(String path){
			return ItemTags.makeWrapperTag(new ResourceLocation("forge", path).toString());
		}
		private static ITag.INamedTag<Item> mod(String path){
			return ItemTags.makeWrapperTag(new ResourceLocation(MoovelousMod.MOD_ID,path).toString());
		}
		
	}
}
