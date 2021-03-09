package com.lukehanslarsen.Moovelous.data.client;

import com.lukehanslarsen.Moovelous.MoovelousMod;
import com.lukehanslarsen.Moovelous.setup.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;


public class ModBlockStateProvider extends BlockStateProvider{

	public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
		super(gen, MoovelousMod.MOD_ID, exFileHelper);
	}
	
	@Override
	protected void registerStatesAndModels() {
		honeyBlock(ModBlocks.COW_BEE_HIVE.get(),modLoc("block/cow_bee_hive_side"),modLoc("block/cow_bee_hive_front"),modLoc("block/cow_bee_hive_bottom"),modLoc("block/cow_bee_hive_top"));
	}
	
    public void honeyBlock(Block block, ResourceLocation side, ResourceLocation front, ResourceLocation bottom, ResourceLocation top) {
    	simpleBlock(block, models().orientableWithBottom(block.getRegistryName().getPath(), side, front, bottom, top));
    }
}
