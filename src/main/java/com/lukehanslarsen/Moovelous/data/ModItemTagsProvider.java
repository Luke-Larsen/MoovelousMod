package com.lukehanslarsen.Moovelous.data;

import com.lukehanslarsen.Moovelous.MoovelousMod;
import com.lukehanslarsen.Moovelous.setup.ModItems;
import com.lukehanslarsen.Moovelous.setup.ModTags;

import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemTagsProvider extends ItemTagsProvider{

	public ModItemTagsProvider(DataGenerator dataGenerator, BlockTagsProvider blockTagProvider,ExistingFileHelper existingFileHelper) {
		super(dataGenerator, blockTagProvider, MoovelousMod.MOD_ID,existingFileHelper);
	}
	
	@Override
	protected void registerTags() {
		copy(ModTags.Blocks.COW_BEE_HIVE,ModTags.Items.COW_BEE_HIVE);
		
		getOrCreateBuilder(ModTags.Items.HONEY_MILK).add(ModItems.HONEY_MILK.get());
	}

}
