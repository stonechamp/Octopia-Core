package me.champ.octopia.entity.spawners;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.candc.SilkSpawners;
import de.candc.api.SilkSpawnersAPI;
import me.champ.octopia.Core;

public class CustomSpawner {
	
	private Core plugin = Core.getInstance();
	
	public ItemStack itemStack;
	public String displayName;
	public EntityType entity;
	
	public CustomSpawner(String name, String type) {
		this.displayName = name;
		this.entity = EntityType.valueOf(type.toUpperCase());
	}
	
	public ItemStack toItemStack() {
		SilkSpawnersAPI silkSpawnerApi = SilkSpawners.getApi();
		ItemStack spawner = silkSpawnerApi.getSpawner(entity);
		ItemMeta meta = spawner.getItemMeta();
		meta.setDisplayName(displayName);
		spawner.setItemMeta(meta);
		return spawner;
	}

}
