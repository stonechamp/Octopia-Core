package me.champ.octopia.playtime;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;

import me.champ.octopia.Core;
import net.milkbowl.vault.economy.Economy;

public class PlaytimeRewards {
	
	private static Core plugin = Core.getInstance();
	public static String prefix = ChatColor.GRAY + "[" + ChatColor.RED + "" + ChatColor.BOLD +  "Playtime Rewards" + ChatColor.GRAY + "]" + ChatColor.GOLD + "";
	
	public static void check(Player player) {
		Economy econ = plugin.getEcononomy();
		
		int ticks = player.getStatistic(Statistic.PLAY_ONE_TICK);
		//int ticks = PlaytimeConfig.getPlaytimeConfig().getInt("players." + player.getUniqueId() + ".playtime");
		int hours = (((ticks / 20) / 60) / 60);
		
		if (ticks == 72000*24) {
			player.sendMessage(prefix + " Giving 24 hour reward...");
			Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "cc give V LegendaryCrate 1 " + player.getName());
			player.sendMessage(ChatColor.GOLD + "[+]" + ChatColor.GREEN + " 1" + ChatColor.GOLD + " Legendary key has been safely escorted to you.");
			player.setStatistic(Statistic.PLAY_ONE_TICK, 0);
		} else if (ticks == 72000*12) {
			player.sendMessage(prefix + " Giving 12 hour reward..."); 
			Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "cc give V RareCrate 1 " + player.getName());
			player.sendMessage(ChatColor.GOLD + "[+]" + ChatColor.GREEN + " 1" + ChatColor.GOLD + " Rare key has been safely escorted to you.");
		} else if(ticks == 72000){
			player.sendMessage(prefix + " Giving 1 hour reward...");
			econ.depositPlayer(player, 25000);
		} else if(ticks== 72000*2){
			player.sendMessage(prefix + " Giving 1 hour reward...");
			econ.depositPlayer(player, 25000);
		} else if(ticks== 72000*3){
			player.sendMessage(prefix + " Giving 1 hour reward...");
			econ.depositPlayer(player, 25000);
		} else if(ticks== 72000*4){
			player.sendMessage(prefix + " Giving 1 hour reward...");
			econ.depositPlayer(player, 25000);
		} else if(ticks== 72000*5){
			player.sendMessage(prefix + " Giving 1 hour reward...");
			econ.depositPlayer(player, 25000);
		} else if(ticks== 72000*6){
			player.sendMessage(prefix + " Giving 1 hour reward...");
			econ.depositPlayer(player, 25000);
		} else if(ticks== 72000*7){
			player.sendMessage(prefix + " Giving 1 hour reward...");
			econ.depositPlayer(player, 25000);
		} else if(ticks== 72000*8){
			player.sendMessage(prefix + " Giving 1 hour reward...");
			econ.depositPlayer(player, 25000);
		} else if(ticks== 72000*9){
			player.sendMessage(prefix + " Giving 1 hour reward...");
			econ.depositPlayer(player, 25000);
		} else if(ticks== 72000*10){
			player.sendMessage(prefix + " Giving 1 hour reward...");
			econ.depositPlayer(player, 25000);
		} else if(ticks== 72000*11){
			player.sendMessage(prefix + " Giving 1 hour reward...");
			econ.depositPlayer(player, 25000);
		} else if(ticks== 72000*13){
			player.sendMessage(prefix + " Giving 1 hour reward...");
			econ.depositPlayer(player, 25000);
		} else if(ticks== 72000*14){
			player.sendMessage(prefix + " Giving 1 hour reward...");
			econ.depositPlayer(player, 25000);
		} else if(ticks== 72000*15){
			player.sendMessage(prefix + " Giving 1 hour reward...");
			econ.depositPlayer(player, 25000);
		} else if(ticks== 72000*16){
			player.sendMessage(prefix + " Giving 1 hour reward...");
			econ.depositPlayer(player, 25000);
		} else if(ticks== 72000*17){
			player.sendMessage(prefix + " Giving 1 hour reward...");
			econ.depositPlayer(player, 25000);
		} else if(ticks== 72000*18){
			player.sendMessage(prefix + " Giving 1 hour reward...");
			econ.depositPlayer(player, 25000);
		} else if(ticks== 72000*19){
			player.sendMessage(prefix + " Giving 1 hour reward...");
			econ.depositPlayer(player, 25000);
		} else if(ticks== 72000*20){
			player.sendMessage(prefix + " Giving 1 hour reward...");
			econ.depositPlayer(player, 25000);
		}else if(ticks== 72000*21){
			player.sendMessage(prefix + " Giving 1 hour reward...");
			econ.depositPlayer(player, 25000);
		} else if(ticks== 72000*22){
			player.sendMessage(prefix + " Giving 1 hour reward...");
			econ.depositPlayer(player, 25000);
		} else if(ticks== 72000*23){
			player.sendMessage(prefix + " Giving 1 hour reward...");
			econ.depositPlayer(player, 25000);
		}
		
	}

}
