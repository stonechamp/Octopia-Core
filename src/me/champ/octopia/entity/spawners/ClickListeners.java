package me.champ.octopia.entity.spawners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.util.BlockIterator;

import me.champ.octopia.Core;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

public class ClickListeners implements Listener  {
	
	Core plugin = Core.getInstance();
	
	
	@EventHandler
	public void onBlockClick(PlayerInteractEvent event) {
		
		Action action = event.getAction();
		Player player = event.getPlayer();
		Block block = event.getClickedBlock();
		
		if (action.equals(Action.RIGHT_CLICK_BLOCK)) {
			if (block.getType().equals(Material.MOB_SPAWNER)) {
				if (block.hasMetadata("Level One")) {
					plugin.upgradeMenu.initializeItems();
					plugin.upgradeMenu.openInventory(player, plugin.upgradeMenu.inv);
					
				} else if (block.hasMetadata("Level Two")){
					plugin.upgradeMenu.initializeItems();
					plugin.upgradeMenu.openInventory(player, plugin.upgradeMenu.lvl2inv);
				} else if (block.hasMetadata("Level Three")) {
					plugin.upgradeMenu.initializeItems();
					plugin.upgradeMenu.openInventory(player, plugin.upgradeMenu.lvl3inv);
				} else if (block.hasMetadata("Level Four")) {
					plugin.upgradeMenu.initializeItems();
					plugin.upgradeMenu.openInventory(player, plugin.upgradeMenu.lvl4inv);
				} else if (block.hasMetadata("Level Five")) {
					plugin.upgradeMenu.initializeItems();
					plugin.upgradeMenu.openInventory(player, plugin.upgradeMenu.lvl5inv);
				}
				
				if (block.hasMetadata("Diamond Golem Level One")) {
					plugin.upgradeMenu.initializeItems();
					plugin.upgradeMenu.openInventory(player, plugin.upgradeMenu.dgolem1);
					
				} else if (block.hasMetadata("Diamond Golem Level Two")){
					plugin.upgradeMenu.initializeItems();
					plugin.upgradeMenu.openInventory(player, plugin.upgradeMenu.dgolem2);
				} else if (block.hasMetadata("Diamond Golem Level Three")) {
					plugin.upgradeMenu.initializeItems();
					plugin.upgradeMenu.openInventory(player, plugin.upgradeMenu.dgolem3);
				} else if (block.hasMetadata("Diamond Golem Level Four")) {
					plugin.upgradeMenu.initializeItems();
					plugin.upgradeMenu.openInventory(player, plugin.upgradeMenu.dgolem4);
				} else if (block.hasMetadata("Diamond Golem Level Five")) {
					plugin.upgradeMenu.initializeItems();
					plugin.upgradeMenu.openInventory(player, plugin.upgradeMenu.dgolem5);
				}
				
				if (block.hasMetadata("Emerald Golem Level One")) {
					plugin.upgradeMenu.initializeItems();
					plugin.upgradeMenu.openInventory(player, plugin.upgradeMenu.egolem1);
					
				} else if (block.hasMetadata("Emerald Golem Level Two")){
					plugin.upgradeMenu.initializeItems();
					plugin.upgradeMenu.openInventory(player, plugin.upgradeMenu.egolem2);
				} else if (block.hasMetadata("Emerald Golem Level Three")) {
					plugin.upgradeMenu.initializeItems();
					plugin.upgradeMenu.openInventory(player, plugin.upgradeMenu.egolem3);
				} else if (block.hasMetadata("Emerald Golem Level Four")) {
					plugin.upgradeMenu.initializeItems();
					plugin.upgradeMenu.openInventory(player, plugin.upgradeMenu.egolem4);
				} else if (block.hasMetadata("Emerald Golem Level Five")) {
					plugin.upgradeMenu.initializeItems();
					plugin.upgradeMenu.openInventory(player, plugin.upgradeMenu.egolem5);
				}
			}
		}
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent event) {
		
		String guiName = event.getInventory().getName();
		
		if (!(event.getRawSlot() < event.getInventory().getSize())) {
			return;
		}
		
		if (guiName.equalsIgnoreCase("Help Menu")) {
			return;
		}
		
		
		
		if (event.getInventory().getSize() <= 27 && event.getInventory().getSize() > 18 || event.getInventory().getSize() >= 54 ) {
			return;
		}
		
		if (event.getClick().equals(ClickType.NUMBER_KEY)){
            event.setCancelled(true); 
        }
		
		
		event.setCancelled(true);
		
		
		Player player = (Player) event.getWhoClicked();
        ItemStack clickedItem = event.getCurrentItem();
        
        if (guiName.equalsIgnoreCase(ChatColor.DARK_GRAY + player.getName() + "'s" + " Stats")) {
			return;
		}
        
        if (clickedItem == null || clickedItem.getType().equals(Material.AIR)) return;
        
        if ((event.getInventory().getType() == InventoryType.CHEST)) {
        	if (event.getRawSlot() == 4 && guiName.equalsIgnoreCase(plugin.upgradeMenu.lvl1Name)) {
            	event.setCancelled(true);
            	Economy economy = plugin.getEcononomy();
            	if (economy.getBalance(player) < 250000) {
            		player.sendMessage(ChatColor.RED + "[Spawners] You do not have enough money!");
            		player.closeInventory();
            		return;
            	} else {
            		
            		double current = economy.getBalance(player);
            		double newBal = current - 250000;
            		double cost = 250000;
            		
            		economy.withdrawPlayer(player, cost);
            		player.sendMessage(ChatColor.GREEN + "[Spawners] Upgrade successful.");
            		player.sendMessage(ChatColor.GREEN + "[Spawners] New Balance: " + newBal);
                    player.closeInventory();
                    
                    
                    Block spawnerToChange = getTargetBlock(player, 10);
                    if (spawnerToChange.getType() == Material.MOB_SPAWNER) {
                    	spawnerToChange.removeMetadata("Level One", plugin);
                        spawnerToChange.setMetadata("Level Two", new FixedMetadataValue(plugin, "lvl2"));
                    }
            	}
            	
                
                
                
            } else if (event.getRawSlot() == 4 && guiName.equalsIgnoreCase(plugin.upgradeMenu.lvl2Name)) {
            	
            	event.setCancelled(true);
            	Economy economy = plugin.getEcononomy();
            	if (economy.getBalance(player) < 250000) {
            		player.sendMessage(ChatColor.RED + "[Spawners] You do not have enough money!");
            		player.closeInventory();
            		return;
            	} else {
            		
            		double current = economy.getBalance(player);
            		double newBal = current - 250000;
            		double cost = 250000;
            		
            		economy.withdrawPlayer(player, cost);
            		player.sendMessage(ChatColor.GREEN + "[Spawners] Upgrade successful.");
            		player.sendMessage(ChatColor.GREEN + "[Spawners] New Balance: " + newBal);
                    player.closeInventory();

                    Block spawnerToChange = getTargetBlock(player, 10);
                    if (spawnerToChange.getType() == Material.MOB_SPAWNER) {
                    	spawnerToChange.removeMetadata("Level Two", plugin);
                        spawnerToChange.setMetadata("Level Three", new FixedMetadataValue(plugin, "lvl3"));
                    }
            	}
     
            } else if (event.getRawSlot() == 4 && guiName.equalsIgnoreCase(plugin.upgradeMenu.lvl3Name)) {
            	
            	event.setCancelled(true);
            	Economy economy = plugin.getEcononomy();
            	if (economy.getBalance(player) < 250000) {
            		player.sendMessage(ChatColor.RED + "[Spawners] You do not have enough money!");
            		player.closeInventory();
            		return;
            	} else {
            		
            		double current = economy.getBalance(player);
            		double newBal = current - 250000;
            		double cost = 250000;
            		
            		economy.withdrawPlayer(player, cost);
            		player.sendMessage(ChatColor.GREEN + "[Spawners] Upgrade successful.");
            		player.sendMessage(ChatColor.GREEN + "[Spawners] New Balance: " + newBal);
                    player.closeInventory();
                    
                    Block spawnerToChange = getTargetBlock(player, 10);
                    if (spawnerToChange.getType() == Material.MOB_SPAWNER) {
                    	 spawnerToChange.removeMetadata("Level Three", plugin);
                         spawnerToChange.setMetadata("Level Four", new FixedMetadataValue(plugin, "lvl4"));
                    }
            	}
            	
            	
            	

            }else if (event.getRawSlot() == 4 && guiName.equalsIgnoreCase(plugin.upgradeMenu.lvl4Name)) {
            	
            	event.setCancelled(true);
            	Economy economy = plugin.getEcononomy();
            	if (economy.getBalance(player) < 250000) {
            		player.sendMessage(ChatColor.RED + "[Spawners] You do not have enough money!");
            		player.closeInventory();
            		return;
            	} else {
            		
            		double current = economy.getBalance(player);
            		double newBal = current - 250000;
            		double cost = 250000;
            		
            		economy.withdrawPlayer(player, cost);
            		player.sendMessage(ChatColor.GREEN + "[Spawners] Upgrade successful.");
            		player.sendMessage(ChatColor.GREEN + "[Spawners] New Balance: " + newBal);
                    player.closeInventory();
                   
                    Block spawnerToChange = getTargetBlock(player, 10);
                    if (spawnerToChange.getType() == Material.MOB_SPAWNER) {
                    	spawnerToChange.removeMetadata("Level Four", plugin);
                        spawnerToChange.setMetadata("Level Five", new FixedMetadataValue(plugin, "lvl5"));
                    }
            	}
            	
            	
                
                
            } else if (event.getRawSlot() == 4 && guiName.equalsIgnoreCase(plugin.upgradeMenu.lvl5Name)) {

            	event.setCancelled(true);
            	player.sendMessage(ChatColor.RED + "[Spawners] Nothing left to upgrade.");
            	player.closeInventory();
    	
                
            } else if (event.getRawSlot() == 13 && guiName.equalsIgnoreCase(plugin.upgradeMenu.lvl1Name) || guiName.equalsIgnoreCase(plugin.upgradeMenu.lvl2Name) || guiName.equalsIgnoreCase(plugin.upgradeMenu.lvl3Name) || guiName.equalsIgnoreCase(plugin.upgradeMenu.lvl4Name) || guiName.equalsIgnoreCase(plugin.upgradeMenu.lvl5Name)) {
            	event.setCancelled(true);
            	player.closeInventory();
            }
            
    		
    		if (event.getRawSlot() == 4 && guiName.equalsIgnoreCase(plugin.upgradeMenu.dgolem1name)) {
            	event.setCancelled(true);
            	Economy economy = plugin.getEcononomy();
            	if (economy.getBalance(player) < 250000) {
            		player.sendMessage(ChatColor.RED + "[Spawners] You do not have enough money!");
            		player.closeInventory();
            		return;
            	} else {
            		
            		double current = economy.getBalance(player);
            		double newBal = current - 250000;
            		double cost = 250000;
            		
            		economy.withdrawPlayer(player, cost);
            		player.sendMessage(ChatColor.GREEN + "[Spawners] Upgrade successful.");
            		player.sendMessage(ChatColor.GREEN + "[Spawners] New Balance: " + newBal);
                    player.closeInventory();
                    
                    
                    Block spawnerToChange = getTargetBlock(player, 10);
                    if (spawnerToChange.getType() == Material.MOB_SPAWNER) {
                    	spawnerToChange.removeMetadata("Diamond Golem Level One", plugin);
                        spawnerToChange.setMetadata("Diamond Golem Level Two", new FixedMetadataValue(plugin, "lvl2"));
                    }
            	}
            	
                
                
                
            } else if (event.getRawSlot() == 4 && guiName.equalsIgnoreCase(plugin.upgradeMenu.dgolem2name)) {
            	
            	event.setCancelled(true);
            	Economy economy = plugin.getEcononomy();
            	if (economy.getBalance(player) < 250000) {
            		player.sendMessage(ChatColor.RED + "[Spawners] You do not have enough money!");
            		player.closeInventory();
            		return;
            	} else {
            		
            		double current = economy.getBalance(player);
            		double newBal = current - 250000;
            		double cost = 250000;
            		
            		economy.withdrawPlayer(player, cost);
            		player.sendMessage(ChatColor.GREEN + "[Spawners] Upgrade successful.");
            		player.sendMessage(ChatColor.GREEN + "[Spawners] New Balance: " + newBal);
                    player.closeInventory();

                    Block spawnerToChange = getTargetBlock(player, 10);
                    if (spawnerToChange.getType() == Material.MOB_SPAWNER) {
                    	spawnerToChange.removeMetadata("Diamond Golem Level Two", plugin);
                        spawnerToChange.setMetadata("Diamond Golem Level Three", new FixedMetadataValue(plugin, "lvl3"));
                    }
            	}
     
            } else if (event.getRawSlot() == 4 && guiName.equalsIgnoreCase(plugin.upgradeMenu.dgolem3name)) {
            	
            	event.setCancelled(true);
            	Economy economy = plugin.getEcononomy();
            	
            	if (economy.getBalance(player) < 250000) {
            		player.sendMessage(ChatColor.RED + "[Spawners] You do not have enough money!");
            		player.closeInventory();
            		return;
            	} else {
            		
            		double current = economy.getBalance(player);
            		double newBal = current - 250000;
            		double cost = 250000;
            		
            		economy.withdrawPlayer(player, cost);
            		player.sendMessage(ChatColor.GREEN + "[Spawners] Upgrade successful.");
            		player.sendMessage(ChatColor.GREEN + "[Spawners] New Balance: " + newBal);
                    player.closeInventory();
                    
                    Block spawnerToChange = getTargetBlock(player, 10);
                    if (spawnerToChange.getType() == Material.MOB_SPAWNER) {
                    	 spawnerToChange.removeMetadata("Diamond Golem Level Three", plugin);
                         spawnerToChange.setMetadata("Diamond Golem Level Four", new FixedMetadataValue(plugin, "lvl4"));
                    }
            	}
            	
            	
            	

            }else if (event.getRawSlot() == 4 && guiName.equalsIgnoreCase(plugin.upgradeMenu.dgolem4name)) {
            	
            	event.setCancelled(true);
            	Economy economy = plugin.getEcononomy();
            	if (economy.getBalance(player) < 250000) {
            		player.sendMessage(ChatColor.RED + "[Spawners] You do not have enough money!");
            		player.closeInventory();
            		return;
            	} else {
            		
            		double current = economy.getBalance(player);
            		double newBal = current - 250000;
            		double cost = 250000;
            		
            		economy.withdrawPlayer(player, cost);
            		player.sendMessage(ChatColor.GREEN + "[Spawners] Upgrade successful.");
            		player.sendMessage(ChatColor.GREEN + "[Spawners] New Balance: " + newBal);
                    player.closeInventory();
                   
                    Block spawnerToChange = getTargetBlock(player, 10);
                    if (spawnerToChange.getType() == Material.MOB_SPAWNER) {
                    	spawnerToChange.removeMetadata("Diamond Golem Level Four", plugin);
                        spawnerToChange.setMetadata("Diamond Golem Level Five", new FixedMetadataValue(plugin, "lvl5"));
                    }
            	}
            	
            	
                
                
            } else if (event.getRawSlot() == 4 && guiName.equalsIgnoreCase(plugin.upgradeMenu.dgolem5name)) {
            	
            	event.setCancelled(true);
            	player.sendMessage(ChatColor.RED + "[Spawners] Nothing left to upgrade.");
            	player.closeInventory();
    	
                
            } else if (event.getRawSlot() == 13 && guiName.equalsIgnoreCase(plugin.upgradeMenu.dgolem1name) || event.getRawSlot() == 13 && guiName.equalsIgnoreCase(plugin.upgradeMenu.dgolem2name )||  event.getRawSlot() == 13 && guiName.equalsIgnoreCase(plugin.upgradeMenu.dgolem3name) || event.getRawSlot() == 13 && guiName.equalsIgnoreCase(plugin.upgradeMenu.dgolem4name) || event.getRawSlot() == 13 && guiName.equalsIgnoreCase(plugin.upgradeMenu.dgolem5name)) {
            	event.setCancelled(true);
            	player.closeInventory();
            }
    		
    		//Emerald Spawner Inv
    		
    		if (event.getRawSlot() == 4 && guiName.equalsIgnoreCase(plugin.upgradeMenu.egolem1name)) {
            	
    			event.setCancelled(true);
            	Economy economy = plugin.getEcononomy();
            	if (economy.getBalance(player) < 250000) {
            		player.sendMessage(ChatColor.RED + "[Spawners] You do not have enough money!");
            		player.closeInventory();
            		return;
            	} else {
            		
            		double current = economy.getBalance(player);
            		double newBal = current - 250000;
            		double cost = 250000;
            		
            		economy.withdrawPlayer(player, cost);
            		player.sendMessage(ChatColor.GREEN + "[Spawners] Upgrade successful.");
            		player.sendMessage(ChatColor.GREEN + "[Spawners] New Balance: " + newBal);
                    player.closeInventory();
                    
                    
                    Block spawnerToChange = getTargetBlock(player, 10);
                    if (spawnerToChange.getType() == Material.MOB_SPAWNER) {
                    	spawnerToChange.removeMetadata("Emerald Golem Level One", plugin);
                        spawnerToChange.setMetadata("Emerald Golem Level Two", new FixedMetadataValue(plugin, "lvl2"));
                    }
            	}
            	
                
                
                
            } else if (event.getRawSlot() == 4 && guiName.equalsIgnoreCase(plugin.upgradeMenu.egolem2name)) {
            	
            	event.setCancelled(true);
            	Economy economy = plugin.getEcononomy();
            	if (economy.getBalance(player) < 250000) {
            		player.sendMessage(ChatColor.RED + "[Spawners] You do not have enough money!");
            		player.closeInventory();
            		return;
            	} else {
            		
            		double current = economy.getBalance(player);
            		double newBal = current - 250000;
            		double cost = 250000;
            		
            		economy.withdrawPlayer(player, cost);
            		player.sendMessage(ChatColor.GREEN + "[Spawners] Upgrade successful.");
            		player.sendMessage(ChatColor.GREEN + "[Spawners] New Balance: " + newBal);
                    player.closeInventory();

                    Block spawnerToChange = getTargetBlock(player, 10);
                    if (spawnerToChange.getType() == Material.MOB_SPAWNER) {
                    	spawnerToChange.removeMetadata("Emerald Golem Level Two", plugin);
                        spawnerToChange.setMetadata("Emerald Golem Level Three", new FixedMetadataValue(plugin, "lvl3"));
                    }
            	}
     
            } else if (event.getRawSlot() == 4 && guiName.equalsIgnoreCase(plugin.upgradeMenu.egolem3name)) {
            	
            	event.setCancelled(true);
            	Economy economy = plugin.getEcononomy();
            	if (economy.getBalance(player) < 250000) {
            		player.sendMessage(ChatColor.RED + "[Spawners] You do not have enough money!");
            		player.closeInventory();
            		return;
            	} else {
            		
            		double current = economy.getBalance(player);
            		double newBal = current - 250000;
            		double cost = 250000;
            		
            		economy.withdrawPlayer(player, cost);
            		player.sendMessage(ChatColor.GREEN + "[Spawners] Upgrade successful.");
            		player.sendMessage(ChatColor.GREEN + "[Spawners] New Balance: " + newBal);
                    player.closeInventory();
                    
                    Block spawnerToChange = getTargetBlock(player, 10);
                    if (spawnerToChange.getType() == Material.MOB_SPAWNER) {
                    	 spawnerToChange.removeMetadata("Emerald Golem Level Three", plugin);
                         spawnerToChange.setMetadata("Emerald Golem Level Four", new FixedMetadataValue(plugin, "lvl4"));
                    }
            	}
            	
            	
            	

            }else if (event.getRawSlot() == 4 && guiName.equalsIgnoreCase(plugin.upgradeMenu.egolem4name)) {
            	
            	event.setCancelled(true);
            	Economy economy = plugin.getEcononomy();
            	if (economy.getBalance(player) < 250000) {
            		player.sendMessage(ChatColor.RED + "[Spawners] You do not have enough money!");
            		player.closeInventory();
            		return;
            	} else {
            		
            		double current = economy.getBalance(player);
            		double newBal = current - 250000;
            		double cost = 250000;
            		
            		economy.withdrawPlayer(player, cost);
            		player.sendMessage(ChatColor.GREEN + "[Spawners] Upgrade successful.");
            		player.sendMessage(ChatColor.GREEN + "[Spawners] New Balance: " + newBal);
                    player.closeInventory();
                   
                    Block spawnerToChange = getTargetBlock(player, 10);
                    if (spawnerToChange.getType() == Material.MOB_SPAWNER) {
                    	spawnerToChange.removeMetadata("Emerald Golem Level Four", plugin);
                        spawnerToChange.setMetadata("Emerald Golem Level Five", new FixedMetadataValue(plugin, "lvl5"));
                    }
            	}
            	
            	
                
                
            } else if (event.getRawSlot() == 4 && guiName.equalsIgnoreCase(plugin.upgradeMenu.egolem5name)) {
            	
            	event.setCancelled(true);
            	player.sendMessage(ChatColor.RED + "[Spawners] Nothing left to upgrade.");
            	player.closeInventory();
    	
                
            } else if (event.getRawSlot() == 13 && guiName.equalsIgnoreCase(plugin.upgradeMenu.egolem1name) || event.getRawSlot() == 13 && guiName.equalsIgnoreCase(plugin.upgradeMenu.egolem2name) || event.getRawSlot() == 14 && guiName.equalsIgnoreCase(plugin.upgradeMenu.egolem3name) || event.getRawSlot() == 13 && guiName.equalsIgnoreCase(plugin.upgradeMenu.egolem4name) || event.getRawSlot() == 13 && guiName.equalsIgnoreCase(plugin.upgradeMenu.egolem5name)) {
            	event.setCancelled(true);
            	player.closeInventory();
            }
        }
        
        

        
		
	}
	
	public final Block getTargetBlock(Player player, int range) {
        BlockIterator iter = new BlockIterator(player, range);
        Block lastBlock = iter.next();
        while (iter.hasNext()) {
            lastBlock = iter.next();
            if (lastBlock.getType() == Material.AIR) {
                continue;
            }
            break;
        }
        return lastBlock;
    }
	

}
