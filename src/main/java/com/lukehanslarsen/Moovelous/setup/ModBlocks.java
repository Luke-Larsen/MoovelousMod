package com.lukehanslarsen.Moovelous.setup;

import java.util.function.Supplier;

import com.lukehanslarsen.Moovelous.blocks.CowBeeHive;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;

public class ModBlocks {
	public static final RegistryObject<Block> COW_BEE_HIVE = register("cow_bee_hive", ()->
			new CowBeeHive(Block.Properties.create(Material.WOOD).hardnessAndResistance(3,10).harvestLevel(2).sound(SoundType.HONEY)));
	
	
	static void register() {}
	
	//registers the block
	private static <T extends Block>RegistryObject<T> registerNoItem(String name, Supplier<T> block){
		return Registration.BLOCKS.register(name, block);
	}
	
	//Registers the block item
	private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block){
		RegistryObject<T> ret = registerNoItem(name,block);
		Registration.ITEMS.register(name, ()-> new BlockItem(ret.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
		return ret;
	}

}
