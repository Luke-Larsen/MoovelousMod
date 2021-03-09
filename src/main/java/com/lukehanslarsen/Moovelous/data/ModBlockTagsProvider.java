package com.lukehanslarsen.Moovelous.data;

import com.lukehanslarsen.Moovelous.MoovelousMod;
import com.lukehanslarsen.Moovelous.setup.ModBlocks;
import com.lukehanslarsen.Moovelous.setup.ModTags;

import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockTagsProvider extends BlockTagsProvider{

	public ModBlockTagsProvider(DataGenerator generatorIn, ExistingFileHelper exisitingFileHelper) {
		super(generatorIn, MoovelousMod.MOD_ID, exisitingFileHelper);
	}
	
	@Override
	protected void registerTags() {
		getOrCreateBuilder(ModTags.Blocks.COW_BEE_HIVE)
			.add(ModBlocks.COW_BEE_HIVE.get());
		
		
	}

}
