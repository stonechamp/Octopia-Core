package me.champ.octopia.shop;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import me.champ.octopia.Core;
import me.champ.octopia.entity.spawners.CustomSpawner;
import net.milkbowl.vault.economy.Economy;

public class ShopClickListener implements Listener {
	
	Core plugin = Core.getInstance();
	
	@EventHandler
	public void ShopClick(InventoryClickEvent event) {
		
		Economy economy = plugin.getEcononomy();
		
		if (event.getWhoClicked() instanceof Player) {
			Player player = (Player) event.getWhoClicked();
			
			if(event.getInventory().getName().equalsIgnoreCase(plugin.getShop().getMainShopTitle()) ) {
				event.setCancelled(true);
				if (event.getRawSlot() == 11) {
					event.setCancelled(true);
					plugin.getShop().openInventory(player, plugin.getShop().getMobShop());
				}
				
				if (event.getRawSlot() == 33) {
					player.closeInventory();
					player.chat("/hoppers");
				}
				
			}
			
			if (event.getInventory().getName().equalsIgnoreCase(plugin.getShop().getMobShopTitle())) {
				
				if(event.getRawSlot() == 14) {
					event.setCancelled(true);
					if (economy.getBalance(player) < 250000) {
		        		player.sendMessage(ChatColor.RED + "[Octopia Shop] You do not have enough money!");
		        		player.closeInventory();
		        		return;
		        	} else {
		        		
		        		double current = economy.getBalance(player);
		        		double newBal = current - 250000;
		        		double cost = 250000;
		        		
		        		economy.withdrawPlayer(player, cost);
		        		player.sendMessage(ChatColor.GREEN + "[Octopia Shop] Purchase successful.");
		        		player.sendMessage(ChatColor.GREEN + "[Octopia Shop] New Balance: " + newBal);
		                player.closeInventory();
		                CustomSpawner dgolem = new CustomSpawner(ChatColor.AQUA + "[Level 1] Diamond Golem", "iron_golem");
		                player.getInventory().addItem(dgolem.toItemStack());
					
		        	}
					
					
				}
				
				if(event.getRawSlot() == 13) {
					event.setCancelled(true);
					if (economy.getBalance(player) < 250000) {
		        		player.sendMessage(ChatColor.RED + "[Octopia Shop] You do not have enough money!");
		        		player.closeInventory();
		        		return;
		        	} else {
		        		
		        		double current = economy.getBalance(player);
		        		double newBal = current - 250000;
		        		double cost = 250000;
		        		
		        		economy.withdrawPlayer(player, cost);
		        		player.sendMessage(ChatColor.GREEN + "[Octopia Shop] Purchase successful.");
		        		player.sendMessage(ChatColor.GREEN + "[Octopia Shop] New Balance: " + newBal);
		                player.closeInventory();
		                CustomSpawner dgolem = new CustomSpawner(ChatColor.GREEN + "[Level 1] Emerald Golem", "iron_golem");
		                player.getInventory().addItem(dgolem.toItemStack());
					
		        	}
				}
			}
		}
		
		
	}

}
