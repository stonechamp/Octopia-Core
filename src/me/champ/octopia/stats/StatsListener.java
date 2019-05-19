package me.champ.octopia.stats;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import me.champ.octopia.guis.PlaytimeLeaderBoard;



public class StatsListener implements Listener {
	
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		
		if (!(StatsConfig.getStatsConfig().contains("players." + player.getUniqueId()))){
			StatsConfig.getStatsConfig().set("players." + player.getUniqueId() + ".time-joined", System.currentTimeMillis());
			StatsConfig.getStatsConfig().set("players." + player.getUniqueId() + ".total-time", 0);
			StatsConfig.getStatsConfig().set("players." + player.getUniqueId() + ".blocks", 0);
			player.sendMessage("Test");
			StatsConfig.save();
		} else {
			StatsConfig.getStatsConfig().set("players." + player.getUniqueId() + ".time-joined", System.currentTimeMillis());
			StatsConfig.save();
		}
	}
	
	@EventHandler 
	public void onQuit(PlayerQuitEvent event) {
		Player player = event.getPlayer();
		int jointime = StatsConfig.getStatsConfig().getInt("players." + player.getUniqueId() + ".time-joined");
		int totaltime = StatsConfig.getStatsConfig().getInt("players." + player.getUniqueId() + ".total-time");
		if (!StatsConfig.getStatsConfig().contains("players." + event.getPlayer().getUniqueId() + ".total-time")){
			return;
		} else {
			StatsConfig.getStatsConfig().set("players." + player.getUniqueId() + ".total-time", totaltime += System.currentTimeMillis() - jointime);
			StatsConfig.save();
		}
		
	}
	
	
	@EventHandler
	public void onBreak(BlockBreakEvent event) {
		Player player = event.getPlayer();
		int blocks = StatsConfig.getStatsConfig().getInt("players." + player.getUniqueId() + ".blocks");
		StatsConfig.getStatsConfig().set("players." + player.getUniqueId() + ".blocks", blocks += 1);
		StatsConfig.save();
	}
	
	@EventHandler
	public void onInvClick(InventoryClickEvent event) {
		
		if (event.getWhoClicked() instanceof Player) {
			Player player = (Player) event.getWhoClicked();
			String guiName = ChatColor.DARK_GRAY + player.getName() + "'s Stats";
			
			if (event.getInventory().getTitle().equalsIgnoreCase(guiName)) {
				if (event.getRawSlot() == 22) {
					PlaytimeLeaderBoard ptlb = new PlaytimeLeaderBoard();
					player.closeInventory();
					ptlb.open(player);
					
				}
			}
			
			
			
		}
		
	}

}
