package me.champ.octopia;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.metadata.FixedMetadataValue;

import net.md_5.bungee.api.ChatColor;

public class CoreListener implements Listener {
	
	private Core plugin = Core.getInstance();
	
	@EventHandler
	public void onClick(InventoryClickEvent event) {
		
		if (event.getInventory().getName().equalsIgnoreCase("Help Menu")) {
			event.setCancelled(true);
			Player player = (Player) event.getWhoClicked();
			if (event.getRawSlot() == 12) {
				player.performCommand("oc");
				player.closeInventory();
			}
			
			if (event.getRawSlot() == 20) {
				player.sendMessage(ChatColor.GOLD + " " + ChatColor.BOLD + "Island Commands" + ChatColor.WHITE + " (v 0.1)");
				player.sendMessage(ChatColor.GRAY + "----------------------------");
				player.sendMessage(ChatColor.WHITE + "/island" + ChatColor.GRAY + " - Access the island panel. ");
				player.closeInventory();
			}
			
			if (event.getRawSlot() == 14 ) {
				player.sendMessage(ChatColor.GOLD + " " + ChatColor.BOLD + "PvP Commands" + ChatColor.WHITE + " (v 0.1)");
				player.sendMessage(ChatColor.GRAY + "----------------------------");
				player.sendMessage(ChatColor.WHITE + "/pvp" + ChatColor.GRAY + " - Access the pvp panel. ");
				player.closeInventory();
			}
			
			if (event.getRawSlot() == 24) {
				player.sendMessage(ChatColor.GOLD + " " + ChatColor.BOLD + "Tokens" + ChatColor.WHITE + " (v 0.1)");
				player.sendMessage(ChatColor.GRAY + "----------------------------");
				player.sendMessage(ChatColor.WHITE + "/token shop" + ChatColor.GRAY + " - Access the server token shop. ");
				player.closeInventory();
			}
			
			if (event.getRawSlot() == 31) {
				player.closeInventory();
			}
		}
	}
	
	public static List<Block> getNearbyBlocks(Location location, int radius) {
        List<Block> blocks = new ArrayList<Block>();
        for(int x = location.getBlockX() - radius; x <= location.getBlockX() + radius; x++) {
            for(int y = location.getBlockY() - radius; y <= location.getBlockY() + radius; y++) {
                for(int z = location.getBlockZ() - radius; z <= location.getBlockZ() + radius; z++) {
                   blocks.add(location.getWorld().getBlockAt(x, y, z));
                }
            }
        }
        return blocks;
    }

}
