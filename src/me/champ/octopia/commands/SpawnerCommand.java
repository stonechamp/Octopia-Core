package me.champ.octopia.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

import me.champ.octopia.Core;
import net.md_5.bungee.api.ChatColor;

public class SpawnerCommand extends SubCommand {
	
	private Core plugin = Core.getInstance();

	@Override
	public void onCommand(Player player, String[] args) {
		
		if (!(player.hasPermission("oc.uspawner"))) {
			player.sendMessage(ChatColor.RED + "You don't have permission!");
			return;
		}
		
		if (args.length == 1) {
			ItemStack spawner = new ItemStack(Material.MOB_SPAWNER);
			ItemMeta meta = spawner.getItemMeta();
			meta.setDisplayName(ChatColor.GOLD + "[Spawner] Level 1");
			spawner.setItemMeta(meta);
			player.getInventory().addItem(spawner);
			return;
		}
		
		if (args.length == 2) {
			
			if (!(player.hasPermission("oc.uspawner"))) {
				player.sendMessage(ChatColor.RED + "You don't have permission!");
				return;
			}
			
			if (args[1].equalsIgnoreCase("slay")) {
				for (Entity entity : player.getNearbyEntities(20, 20, 20)) {
					if (entity.hasMetadata("Diamond Golem") || entity.hasMetadata("Emerald Golem")) {
						entity.remove();
					}
					entity.remove();
				}
				return;
			}
		}
	}

	@Override
	public String name() {

		return plugin.commandHandler.uspawner;
	}

}
