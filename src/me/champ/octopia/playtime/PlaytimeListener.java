package me.champ.octopia.playtime;

import org.bukkit.ChatColor;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import me.champ.octopia.Core;

public class PlaytimeListener implements Listener {
	
	private Core plugin = Core.getInstance();
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		try {
			if (plugin.afkPool.get(e.getPlayer().getUniqueId()) >= 6000) {
				plugin.afkPool.remove(e.getPlayer().getUniqueId());
				e.getPlayer().sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "" + ChatColor.BOLD +  "Playtime Rewards" + ChatColor.GRAY + "]" + ChatColor.RED + " You are no longer AFK.");
				this.setPlaytime(e.getPlayer());
			}
		}catch(NullPointerException ex) {
			
		}
	    
	}

	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		
		try {
			if (plugin.afkPool.get(e.getPlayer().getUniqueId()) >= 6000) {
				plugin.afkPool.remove(e.getPlayer().getUniqueId());
				plugin.afkPool.put(e.getPlayer().getUniqueId(), 0);
				e.getPlayer().sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "" + ChatColor.BOLD +  "Playtime Rewards" + ChatColor.GRAY + "]" + ChatColor.RED + " You are no longer AFK.");
				this.setPlaytime(e.getPlayer());
			} else {
				plugin.afkPool.remove(e.getPlayer().getUniqueId());
				plugin.afkPool.put(e.getPlayer().getUniqueId(), 0);
			}
		}catch(NullPointerException ex) {
			
		}
		
	}

	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		
		try {
			if (plugin.afkPool.get(e.getPlayer().getUniqueId()) >= 6000) {
				plugin.afkPool.remove(e.getPlayer().getUniqueId());
				plugin.afkPool.put(e.getPlayer().getUniqueId(), 0);
				e.getPlayer().sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "" + ChatColor.BOLD +  "Playtime Rewards" + ChatColor.GRAY + "]" + ChatColor.RED + " You are no longer AFK.");
				this.setPlaytime(e.getPlayer());
			} else {
				plugin.afkPool.remove(e.getPlayer().getUniqueId());
				plugin.afkPool.put(e.getPlayer().getUniqueId(), 0);
			}
		}catch(NullPointerException ex) {
			
		}
	}
	
	@EventHandler
	public void onLeave(PlayerQuitEvent e) {
		try {
			if (plugin.afkPool.get(e.getPlayer().getUniqueId()) >= 6000) {
				plugin.afkPool.remove(e.getPlayer().getUniqueId());
				plugin.afkPool.put(e.getPlayer().getUniqueId(), 0);
				e.getPlayer().sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "" + ChatColor.BOLD +  "Playtime Rewards" + ChatColor.GRAY + "]" + ChatColor.RED + " You are no longer AFK.");
				this.setPlaytime(e.getPlayer());
			} else {
				plugin.afkPool.remove(e.getPlayer().getUniqueId());
				plugin.afkPool.put(e.getPlayer().getUniqueId(), 0);
			}
		}catch(NullPointerException ex) {
			
		}
		
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		//TODO: Set time to config time for player.
		
		if (PlaytimeConfig.getPlaytimeConfig().get("players." + event.getPlayer().getUniqueId()) == null) {
			return;
		} else {
			int ticks = PlaytimeConfig.getPlaytimeConfig().getInt("players." + event.getPlayer().getUniqueId() + ".playtime");
			event.getPlayer().setStatistic(Statistic.PLAY_ONE_TICK, ticks);
		}
	}
	
	public void setPlaytime(Player player) {
		int ticks = PlaytimeConfig.getPlaytimeConfig().getInt("players." + player.getUniqueId() + ".playtime");
		player.setStatistic(Statistic.PLAY_ONE_TICK, ticks);
	}

}
