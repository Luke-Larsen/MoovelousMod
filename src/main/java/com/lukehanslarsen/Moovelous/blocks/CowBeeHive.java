package com.lukehanslarsen.Moovelous.blocks;

import java.util.List;

import com.lukehanslarsen.Moovelous.setup.ModItems;

import net.minecraft.block.BeehiveBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.CampfireBlock;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.tileentity.BeehiveTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
public class CowBeeHive extends BeehiveBlock{
	
	public CowBeeHive(Properties properties) {
		super(properties);
		// TODO Auto-generated constructor stub
	}

	@Override
   public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
      ItemStack itemstack = player.getHeldItem(handIn);
      int i = state.get(HONEY_LEVEL);
      boolean flag = false;
      if (i >= 0) {
         if (itemstack.getItem() == Items.SHEARS) {
            worldIn.playSound(player, player.getPosX(), player.getPosY(), player.getPosZ(), SoundEvents.BLOCK_BEEHIVE_SHEAR, SoundCategory.NEUTRAL, 1.0F, 1.0F);
            dropHoneyComb(worldIn, pos);
            itemstack.damageItem(1, player, (playerEntity) -> {
               playerEntity.sendBreakAnimation(handIn);
            });
            flag = true;
         } else if (itemstack.getItem() == Items.GLASS_BOTTLE) {
            itemstack.shrink(1);
            worldIn.playSound(player, player.getPosX(), player.getPosY(), player.getPosZ(), SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.NEUTRAL, 1.0F, 1.0F);
            if (itemstack.isEmpty()) {
               player.setHeldItem(handIn, new ItemStack((ModItems.HONEY_MILK.get())));
            } else if (!player.inventory.addItemStackToInventory(new ItemStack(ModItems.HONEY_MILK.get()))) {
               player.dropItem(new ItemStack(ModItems.HONEY_MILK.get()), false);
            }

            flag = true;
         }
      }

      if (flag) {
         if (!CampfireBlock.isSmokingBlockAt(worldIn, pos)) {
            if (this.hasBees(worldIn, pos)) {
               this.angerNearbyBees(worldIn, pos);
            }

            this.takeHoney(worldIn, state, pos, player, BeehiveTileEntity.State.EMERGENCY);
         } else {
            this.takeHoney(worldIn, state, pos);
         }

         return ActionResultType.func_233537_a_(worldIn.isRemote);
      } else {
         return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
      }
   }
   private boolean hasBees(World world, BlockPos pos) {
	      TileEntity tileentity = world.getTileEntity(pos);
	      if (tileentity instanceof BeehiveTileEntity) {
	         BeehiveTileEntity beehivetileentity = (BeehiveTileEntity)tileentity;
	         return !beehivetileentity.hasNoBees();
	      } else {
	         return false;
	      }
	   }
   private void angerNearbyBees(World world, BlockPos pos) {
	      List<BeeEntity> list = world.getEntitiesWithinAABB(BeeEntity.class, (new AxisAlignedBB(pos)).grow(8.0D, 6.0D, 8.0D));
	      if (!list.isEmpty()) {
	         List<PlayerEntity> list1 = world.getEntitiesWithinAABB(PlayerEntity.class, (new AxisAlignedBB(pos)).grow(8.0D, 6.0D, 8.0D));
	         if (list1.isEmpty()) return; //Forge: Prevent Error when no players are around.
	         int i = list1.size();

	         for(BeeEntity beeentity : list) {
	            if (beeentity.getAttackTarget() == null) {
	               beeentity.setAttackTarget(list1.get(world.rand.nextInt(i)));
	            }
	         }
	      }

	   }
}
