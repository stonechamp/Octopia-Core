package me.champ.octopia.entity.spawners;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.util.BlockIterator;

import de.candc.SilkSpawners;
import de.candc.api.SilkSpawnersAPI;
import me.champ.octopia.Core;
import net.minecraft.server.v1_8_R3.BlockPosition;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import net.minecraft.server.v1_8_R3.TileEntityMobSpawner;

public class OnSpawnerPlaceAndBreak implements Listener {
	
	Core plugin = Core.getInstance();
	
	
	
	public void removeItems(Block block) {
		
		block.removeMetadata("Level One", plugin);
		block.removeMetadata("Level Two", plugin);
		block.removeMetadata("Level Three", plugin);
		block.removeMetadata("Level Four", plugin);
		block.removeMetadata("Level Five", plugin);
	}
	
	@EventHandler
    public void on(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        
        
        
        if (e.getBlock().getType() == Material.MOB_SPAWNER) {
        	Block customSpawner = e.getBlock();
        	BlockState state = customSpawner.getState();
        	CreatureSpawner cs = (CreatureSpawner) state;
        	World world = cs.getWorld();
        	Location loc = cs.getLocation();
        	BlockPosition blockPos = new BlockPosition(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ());
        	
        	TileEntityMobSpawner tes = (TileEntityMobSpawner) ((CraftWorld) world).getHandle().getTileEntity(blockPos);
            NBTTagCompound tag = new NBTTagCompound();
            tes.getSpawner().b(tag);
            tag.setInt("SpawnCount", (int) 1);
            tes.a(tag);
            tes.update();
            cs.setDelay(500);
            cs.update();
        	
        	String itemName = p.getItemInHand().getItemMeta().getDisplayName();
        	System.out.println(itemName);
        	if (itemName != null) {
        		cs.setMetadata("Level One", new FixedMetadataValue(plugin, "lvl1"));
        	}
        	
        	if (itemName != null) {
        		if (itemName.toString().contains(ChatColor.GOLD + "[Spawner] Level 1")) {
            		cs.setMetadata("Level One", new FixedMetadataValue(plugin, "lvl1"));
            		
            	}
        		if (itemName.toString().contains(ChatColor.GOLD + "[Spawner] Level 2")) {
            		cs.setMetadata("Level Two", new FixedMetadataValue(plugin, "lvl2"));
            		
            	}
        		if (itemName.toString().contains(ChatColor.GOLD + "[Spawner] Level 3")) {
            		cs.setMetadata("Level Three", new FixedMetadataValue(plugin, "lvl3"));
            		
            	} 
        		if (itemName.toString().contains(ChatColor.GOLD + "[Spawner] Level 4")) {
            		cs.setMetadata("Level Four", new FixedMetadataValue(plugin, "lvl4"));
            		
            	} 
        		
        		if (itemName.toString().contains(ChatColor.GOLD + "[Spawner] Max Level")) {
            		cs.setMetadata("Level Five", new FixedMetadataValue(plugin, "lvl5"));
            		
            	}
        		
        		if (itemName.toString().contains(ChatColor.GREEN + "[Level 1] Emerald Golem")) {
        			
            		cs.setMetadata("Emerald Golem Level One", new FixedMetadataValue(plugin, "elvl1"));
            	}
        		
        		if (itemName.toString().contains(ChatColor.GREEN + "[Level 2] Emerald Golem")) {
            		cs.setMetadata("Emerald Golem Level Two", new FixedMetadataValue(plugin, "elvl2"));
            		
            	}
        		
        		if (itemName.toString().contains(ChatColor.GREEN + "[Level 3] Emerald Golem")) {
            		cs.setMetadata("Emerald Golem Level Three", new FixedMetadataValue(plugin, "elvl3"));
            		
            	}
        		
        		if (itemName.toString().contains(ChatColor.GREEN + "[Level 4] Emerald Golem")) {

            		cs.setMetadata("Emerald Golem Level Four", new FixedMetadataValue(plugin, "elvl4"));
            		
            	}
        		
        		if (itemName.toString().contains(ChatColor.GREEN + "[Level 5] Emerald Golem")) {
            		cs.setMetadata("Emerald Golem Level Five", new FixedMetadataValue(plugin, "elvl5"));
            		
            	}
        		
        		if (itemName.toString().contains(ChatColor.AQUA + "[Level 1] Diamond Golem")) {
            		cs.setMetadata("Diamond Golem Level One", new FixedMetadataValue(plugin, "dlvl1"));
            		
            	}
        		
        		if (itemName.toString().contains(ChatColor.AQUA + "[Level 2] Diamond Golem")) {
            		cs.setMetadata("Diamond Golem Level Two", new FixedMetadataValue(plugin, "dlvl2"));
            		
            	}
        		
        		if (itemName.toString().contains(ChatColor.AQUA + "[Level 3] Diamond Golem")) {
            		cs.setMetadata("Diamond Golem Level Three", new FixedMetadataValue(plugin, "dlvl3"));
            		
            	}
        		
        		if (itemName.toString().contains(ChatColor.AQUA + "[Level 4] Diamond Golem")) {
            		cs.setMetadata("Diamond Golem Level Four", new FixedMetadataValue(plugin, "dlvl4"));
            		
            	}
        		
        		if (itemName.toString().contains(ChatColor.AQUA + "[Level 5] Diamond Golem")) {
            		cs.setMetadata("Diamond Golem Level Five", new FixedMetadataValue(plugin, "dlvl5"));
            		
            	}
        		
        	}
        	
            
        }
    }
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		Block block = event.getBlock();
		Player player = event.getPlayer();
		ItemStack itemInHand = player.getItemInHand();
		if (block.getType() == Material.MOB_SPAWNER) {
			
			BlockState mobSpawner = block.getState();
			CreatureSpawner cspawner = ((CreatureSpawner) mobSpawner);

			SilkSpawnersAPI api = SilkSpawners.getApi();
			
			if (itemInHand.containsEnchantment(Enchantment.SILK_TOUCH)){
				
				if (block.hasMetadata("Level One")) {
					EntityType ent = cspawner.getSpawnedType();
					event.setCancelled(true);
					block.setType(Material.AIR);
					ItemStack spawner = api.getSpawner(ent);
					ItemMeta meta = spawner.getItemMeta();
					meta.getLore().clear();
					meta.setDisplayName(ChatColor.GOLD + "[Spawner] Level 1");
					spawner.setItemMeta(meta);
					block.getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(spawner));
					
				}else if (block.hasMetadata("Level Two")) {
					EntityType ent = cspawner.getSpawnedType();
					event.setCancelled(true);
					block.setType(Material.AIR);
					ItemStack spawner = api.getSpawner(ent);
					ItemMeta meta = spawner.getItemMeta();
					meta.setDisplayName(ChatColor.GOLD + "[Spawner] Level 2");
					spawner.setItemMeta(meta);
					
					block.getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(spawner));
				} else if (block.hasMetadata("Level Three")) {
					EntityType ent = cspawner.getSpawnedType();
					event.setCancelled(true);
					block.setType(Material.AIR);
					ItemStack spawner = api.getSpawner(ent);
					ItemMeta meta = spawner.getItemMeta();
					meta.setDisplayName(ChatColor.GOLD + "[Spawner] Level 3");
					spawner.setItemMeta(meta);
					
					block.getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(spawner));
				} else if (block.hasMetadata("Level Four")) {
					EntityType ent = cspawner.getSpawnedType();
					event.setCancelled(true);
					block.setType(Material.AIR);
					ItemStack spawner = api.getSpawner(ent);
					ItemMeta meta = spawner.getItemMeta();
					meta.setDisplayName(ChatColor.GOLD + "[Spawner] Level 4");
					spawner.setItemMeta(meta);
					
					block.getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(spawner));
				} else if (block.hasMetadata("Level Five")) {
					EntityType ent = cspawner.getSpawnedType();
					event.setCancelled(true);
					block.setType(Material.AIR);
					ItemStack spawner = api.getSpawner(ent);
					ItemMeta meta = spawner.getItemMeta();
					meta.setDisplayName(ChatColor.GOLD + "[Spawner] Max Level");
					spawner.setItemMeta(meta);
					
					block.getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(spawner));
				} else if (block.hasMetadata("Diamond Golem Level One")) {
					EntityType ent = EntityType.IRON_GOLEM;
					event.setCancelled(true);
					block.setType(Material.AIR);
					ItemStack spawner = api.getSpawner(ent);
					ItemMeta meta = spawner.getItemMeta();
					meta.setDisplayName(ChatColor.AQUA + "[Level 1] Diamond Golem");
					spawner.setItemMeta(meta);
					
					block.getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(spawner));
				} else if (block.hasMetadata("Diamond Golem Level Two")) {
					EntityType ent = EntityType.IRON_GOLEM;
					event.setCancelled(true);
					block.setType(Material.AIR);
					ItemStack spawner = api.getSpawner(ent);
					ItemMeta meta = spawner.getItemMeta();
					meta.setDisplayName(ChatColor.AQUA + "[Level 2] Diamond Golem");
					spawner.setItemMeta(meta);
					
					block.getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(spawner));
				} else if (block.hasMetadata("Diamond Golem Level Three")) {
					EntityType ent = EntityType.IRON_GOLEM;
					event.setCancelled(true);
					block.setType(Material.AIR);
					ItemStack spawner = api.getSpawner(ent);
					ItemMeta meta = spawner.getItemMeta();
					meta.setDisplayName(ChatColor.AQUA + "[Level 3] Diamond Golem");
					spawner.setItemMeta(meta);
					
					block.getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(spawner));
				} else if (block.hasMetadata("Diamond Golem Level Four")) {
					EntityType ent = EntityType.IRON_GOLEM;
					event.setCancelled(true);
					block.setType(Material.AIR);
					ItemStack spawner = api.getSpawner(ent);
					ItemMeta meta = spawner.getItemMeta();
					meta.setDisplayName(ChatColor.AQUA + "[Level 4] Diamond Golem");
					spawner.setItemMeta(meta);
					
					block.getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(spawner));
				} else if (block.hasMetadata("Diamond Golem Level Five")) {
					EntityType ent = EntityType.IRON_GOLEM;
					event.setCancelled(true);
					block.setType(Material.AIR);
					ItemStack spawner = api.getSpawner(ent);
					ItemMeta meta = spawner.getItemMeta();
					meta.setDisplayName(ChatColor.AQUA + "[Level 5] Diamond Golem");
					spawner.setItemMeta(meta);
					
					block.getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(spawner));
				} else if (block.hasMetadata("Emerald Golem Level One")) {
					EntityType ent = EntityType.IRON_GOLEM;
					event.setCancelled(true);
					block.setType(Material.AIR);
					ItemStack spawner = api.getSpawner(ent);
					ItemMeta meta = spawner.getItemMeta();
					meta.setDisplayName(ChatColor.GREEN + "[Level 1] Emerald Golem");
					spawner.setItemMeta(meta);
					
					block.getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(spawner));
				} else if (block.hasMetadata("Emerald Golem Level Two")) {
					EntityType ent = EntityType.IRON_GOLEM;
					event.setCancelled(true);
					block.setType(Material.AIR);
					ItemStack spawner = api.getSpawner(ent);
					ItemMeta meta = spawner.getItemMeta();
					meta.setDisplayName(ChatColor.GREEN + "[Level 2] Emerald Golem");
					spawner.setItemMeta(meta);
					
					block.getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(spawner));
				} else if (block.hasMetadata("Emerald Golem Level Three")) {
					EntityType ent = EntityType.IRON_GOLEM;
					event.setCancelled(true);
					block.setType(Material.AIR);
					ItemStack spawner = api.getSpawner(ent);
					ItemMeta meta = spawner.getItemMeta();
					meta.setDisplayName(ChatColor.GREEN + "[Level 3] Emerald Golem");
					spawner.setItemMeta(meta);
					
					block.getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(spawner));
				} else if (block.hasMetadata("Emerald Golem Level Four")) {
					EntityType ent = EntityType.IRON_GOLEM;
					event.setCancelled(true);
					block.setType(Material.AIR);
					ItemStack spawner = api.getSpawner(ent);
					ItemMeta meta = spawner.getItemMeta();
					meta.setDisplayName(ChatColor.GREEN + "[Level 4] Emerald Golem");
					spawner.setItemMeta(meta);
					
					block.getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(spawner));
				} else if (block.hasMetadata("Emerald Golem Level Five")) {
					EntityType ent = EntityType.IRON_GOLEM;
					event.setCancelled(true);
					block.setType(Material.AIR);
					ItemStack spawner = api.getSpawner(ent);
					ItemMeta meta = spawner.getItemMeta();
					meta.setDisplayName(ChatColor.GREEN + "[Level 5] Emerald Golem");
					spawner.setItemMeta(meta);
					
					block.getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(spawner));
				} 
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
