package com.lukehanslarsen.Moovelous.setup;

import com.lukehanslarsen.Moovelous.entity.CowBee;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;


public class ModEntity {	
	
	//Registers entity
	//START CowBee
	public static final RegistryObject<EntityType<CowBee>> COW_BEE = Registration.ENTITY_TYPES.register("cow_bee", ()->
		EntityType.Builder.create(CowBee::new, EntityClassification.AMBIENT).size(0.5F, 0.9F).build(null));
	public static final RegistryObject<Item> COW_BEE_EGG = Registration.ITEMS.register("cow_bee_egg",()->
		new ModdedSpawnEggItem(null, null, 0xf0f0f0, 0xdf51f5, new Item.Properties().group(ItemGroup.MISC)));
	//END CowBee

	
	static void register() {}	
	
}
