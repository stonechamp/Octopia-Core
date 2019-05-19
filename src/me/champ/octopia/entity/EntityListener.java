package me.champ.octopia.entity;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class EntityListener implements Listener {
	
	@EventHandler
	public void onEntityDeath(EntityDeathEvent event) {
		
		Random rand = new Random();
		
		if(event.getEntity().hasMetadata("Diamond Golem")){
			ArrayList<ItemStack> drops = new ArrayList<ItemStack>();
			ItemStack diamond = new ItemStack(Material.DIAMOND);
			for (int i = 0; i < getRandomNumberInRange(rand, 3, 6); i++) {
				drops.add(diamond);
			}
			event.getDrops().clear();
			event.getDrops().addAll(drops);
			drops.clear();
		}
		
		if (event.getEntity().hasMetadata("Emerald Golem")) {
			ArrayList<ItemStack> drops = new ArrayList<ItemStack>();
			ItemStack emerald = new ItemStack(Material.EMERALD);
			for (int i = 0; i < getRandomNumberInRange(rand, 3, 6); i++) {
				drops.add(emerald);
			}
			event.getDrops().clear();
			event.getDrops().addAll(drops);
			drops.clear();
		}
		
		
	}
	
	private int getRandomNumberInRange(Random r, int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
	
	

}
