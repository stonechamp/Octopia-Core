package me.champ.octopia.entity.spawners;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.SpawnerSpawnEvent;

import me.champ.octopia.entity.CustomGolem;
import net.minecraft.server.v1_8_R3.BlockPosition;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import net.minecraft.server.v1_8_R3.TileEntityMobSpawner;


public class SpawnerSpawnListener implements Listener {
	
	
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onSpawnerSpawn(SpawnerSpawnEvent event) {
		
		Random random = new Random();
		
		CreatureSpawner spawner = event.getSpawner();
		World world = event.getSpawner().getWorld();
		Location loc = event.getSpawner().getLocation();
		BlockPosition blockPos = new BlockPosition(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ());

		
		
		event.setCancelled(true);
		if (spawner.hasMetadata("Level One")) {
			//event.setCancelled(true);
			Entity mob = event.getEntity();
		    //World world = (World) event.getSpawner().getWorld(); 
		    
		    
		    world.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)), mob.getClass());
		    world.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)), mob.getClass());
		    world.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)), mob.getClass());
		    
		    
		}
		
		if (spawner.hasMetadata("Level Two")) {
			
			//event.setCancelled(true);
			Entity mob = event.getEntity();
		    //World world = (World) event.getSpawner().getWorld(); 
		    
			world.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)), mob.getClass());
			world.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)), mob.getClass());
			world.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)), mob.getClass());
			world.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)), mob.getClass());

		}
		
        if (spawner.hasMetadata("Level Three")) {
			
			//event.setCancelled(true);
			Entity mob = event.getEntity();
		    //World world = (World) event.getSpawner().getWorld(); 
		    
		    world.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)), mob.getClass());
		    world.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)), mob.getClass());
		    world.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)), mob.getClass());
		    world.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)), mob.getClass());
		    world.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)), mob.getClass());
		    
		}
		
		if (spawner.hasMetadata("Level Four")) {
			
			//event.setCancelled(true);
			Entity mob = event.getEntity();
		    //World world = (World) event.getSpawner().getWorld(); 
		    
			world.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)), mob.getClass());
			world.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)), mob.getClass());
			world.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)), mob.getClass());
			world.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)), mob.getClass());
			world.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)), mob.getClass());
			world.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)), mob.getClass());
		}
		
		if (spawner.hasMetadata("Level Five")) {
			
			//event.setCancelled(true);
			Entity mob = event.getEntity();
		    //World world = (World) event.getSpawner().getWorld(); 
		    
		    world.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)), mob.getClass());
		    world.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)), mob.getClass());
		    world.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)), mob.getClass());
		    world.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)), mob.getClass());
		    world.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)), mob.getClass());
		    world.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)), mob.getClass());
		    world.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)), mob.getClass());
		}
		
		if (spawner.hasMetadata("Emerald Golem Level One")) {
			//event.setCancelled(true);
			CustomGolem emeralgGolem = new CustomGolem(ChatColor.GREEN + "Emerald Golem");
			
			
			emeralgGolem.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)));
			emeralgGolem.setMetaData("Emerald Golem");
			emeralgGolem.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)));
			emeralgGolem.setMetaData("Emerald Golem");
			emeralgGolem.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)));
			emeralgGolem.setMetaData("Emerald Golem");
		}
		
		if (spawner.hasMetadata("Emerald Golem Level Two")) {
			//event.setCancelled(true);
			CustomGolem emeralgGolem = new CustomGolem(ChatColor.GREEN + "Emerald Golem");
			
			
			emeralgGolem.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)));
			emeralgGolem.setMetaData("Emerald Golem");
			emeralgGolem.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)));
			emeralgGolem.setMetaData("Emerald Golem");
			emeralgGolem.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)));
			emeralgGolem.setMetaData("Emerald Golem");
			emeralgGolem.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)));
			emeralgGolem.setMetaData("Emerald Golem");
		}
		
		if (spawner.hasMetadata("Emerald Golem Level Three")) {
			//event.setCancelled(true);
			CustomGolem emeralgGolem = new CustomGolem(ChatColor.GREEN + "Emerald Golem");
			
			emeralgGolem.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)));
			emeralgGolem.setMetaData("Emerald Golem");
			emeralgGolem.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)));
			emeralgGolem.setMetaData("Emerald Golem");
			emeralgGolem.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)));
			emeralgGolem.setMetaData("Emerald Golem");
			emeralgGolem.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)));
			emeralgGolem.setMetaData("Emerald Golem");
			emeralgGolem.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)));
			
			emeralgGolem.setMetaData("Emerald Golem");
		}
		
		if (spawner.hasMetadata("Emerald Golem Level Four")) {
			//event.setCancelled(true);
			CustomGolem emeralgGolem = new CustomGolem(ChatColor.GREEN + "Emerald Golem");
			
			emeralgGolem.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)));
			emeralgGolem.setMetaData("Emerald Golem");
			emeralgGolem.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)));
			emeralgGolem.setMetaData("Emerald Golem");
			emeralgGolem.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)));
			emeralgGolem.setMetaData("Emerald Golem");
			emeralgGolem.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)));
			emeralgGolem.setMetaData("Emerald Golem");
			emeralgGolem.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)));
			emeralgGolem.setMetaData("Emerald Golem");
			emeralgGolem.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)));
			
			emeralgGolem.setMetaData("Emerald Golem");
		}
		
		if (spawner.hasMetadata("Emerald Golem Level Five")) {
			//event.setCancelled(true);
			CustomGolem emeralgGolem = new CustomGolem(ChatColor.GREEN + "Emerald Golem");
			
			emeralgGolem.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)));
			emeralgGolem.setMetaData("Emerald Golem");
			emeralgGolem.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)));
			emeralgGolem.setMetaData("Emerald Golem");
			emeralgGolem.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)));
			emeralgGolem.setMetaData("Emerald Golem");
			emeralgGolem.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)));
			emeralgGolem.setMetaData("Emerald Golem");
			emeralgGolem.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)));
			emeralgGolem.setMetaData("Emerald Golem");
			emeralgGolem.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)));
			emeralgGolem.setMetaData("Emerald Golem");
			emeralgGolem.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)));
			
			emeralgGolem.setMetaData("Emerald Golem");
		}
		
		if (spawner.hasMetadata("Diamond Golem Level One")) {
			//event.setCancelled(true);
			CustomGolem diamondGolem = new CustomGolem(ChatColor.AQUA + "Diamond Golem");
			
			
			diamondGolem.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)));
			diamondGolem.setMetaData("Diamond Golem");
			diamondGolem.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)));
			diamondGolem.setMetaData("Diamond Golem");
			diamondGolem.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)));
			diamondGolem.setMetaData("Diamond Golem");
		}
		
		if (spawner.hasMetadata("Diamond Golem Level Two")) {
			//event.setCancelled(true);
			CustomGolem diamondGolem = new CustomGolem(ChatColor.AQUA + "Diamond Golem");
			
			diamondGolem.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)));
			diamondGolem.setMetaData("Diamond Golem");
			diamondGolem.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)));
			diamondGolem.setMetaData("Diamond Golem");
			diamondGolem.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)));
			diamondGolem.setMetaData("Diamond Golem");
			diamondGolem.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)));
			diamondGolem.setMetaData("Diamond Golem");
		}
		
		if (spawner.hasMetadata("Diamond Golem Level Three")) {
			//event.setCancelled(true);
			CustomGolem diamondGolem = new CustomGolem(ChatColor.AQUA + "Diamond Golem");
			
			diamondGolem.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)));
			diamondGolem.setMetaData("Diamond Golem");
			diamondGolem.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)));
			diamondGolem.setMetaData("Diamond Golem");
			diamondGolem.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)));
			diamondGolem.setMetaData("Diamond Golem");
			diamondGolem.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)));
			diamondGolem.setMetaData("Diamond Golem");
			diamondGolem.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)));
			
			diamondGolem.setMetaData("Diamond Golem");
		}
		
		if (spawner.hasMetadata("Diamond Golem Level Four")) {
			//event.setCancelled(true);
			CustomGolem diamondGolem = new CustomGolem(ChatColor.AQUA + "Diamond Golem");
			
			diamondGolem.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)));
			diamondGolem.setMetaData("Diamond Golem");
			diamondGolem.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)));
			diamondGolem.setMetaData("Diamond Golem");
			diamondGolem.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)));
			diamondGolem.setMetaData("Diamond Golem");
			diamondGolem.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)));
			diamondGolem.setMetaData("Diamond Golem");
			diamondGolem.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)));
			diamondGolem.setMetaData("Diamond Golem");
			diamondGolem.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)));
			
			diamondGolem.setMetaData("Diamond Golem");
		}
		
		if (spawner.hasMetadata("Diamond Golem Level Five")) {
			//event.setCancelled(true);
			CustomGolem diamondGolem = new CustomGolem(ChatColor.AQUA + "Diamond Golem");
			
			diamondGolem.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)));
			diamondGolem.setMetaData("Diamond Golem");
			diamondGolem.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)));
			diamondGolem.setMetaData("Diamond Golem");
			diamondGolem.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)));
			diamondGolem.setMetaData("Diamond Golem");
			diamondGolem.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)));
			diamondGolem.setMetaData("Diamond Golem");
			diamondGolem.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)));
			diamondGolem.setMetaData("Diamond Golem");
			diamondGolem.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)));
			diamondGolem.setMetaData("Diamond Golem");
			diamondGolem.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 2, 3), getRandomNumberInRange(random, 0, 2), getRandomNumberInRange(random, 2, 3)));
			
			diamondGolem.setMetaData("Diamond Golem");
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
