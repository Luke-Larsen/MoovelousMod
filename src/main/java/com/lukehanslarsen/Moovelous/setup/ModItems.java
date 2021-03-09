package com.lukehanslarsen.Moovelous.setup;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.RegistryObject;

public class ModItems {
	
	public static final RegistryObject<Item> HONEY_MILK = Registration.ITEMS.register("honey_milk",()->
		new Item(new Item.Properties().group(ItemGroup.FOOD)
				.food(new Food.Builder().effect(()->new EffectInstance(Effects.REGENERATION,100,2), 0.5f).hunger(6).saturation(0.1f).build())));
	
	static void register() {}
}
