package me.champ.octopia.entity;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.metadata.FixedMetadataValue;

import me.champ.octopia.Core;


public class CustomGolem {
	
	private Core plugin = Core.getInstance();
	
	public String name;
	Entity entity;
	
	public CustomGolem(String name) {
		this.name = name;
	}
	
	public void spawn(Location loc) {
		entity = loc.getWorld().spawnEntity(loc, EntityType.IRON_GOLEM);
		entity.setCustomName(name);
		entity.setCustomNameVisible(true);
		
	}
	
	public void setMetaData(String name) {
		entity.setMetadata(name, new FixedMetadataValue(plugin, "customgolem"));
	}

}
