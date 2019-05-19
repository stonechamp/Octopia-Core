package me.champ.octopia.playtime;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.champ.octopia.Core;


public class PlaytimeCommand implements CommandExecutor {

	private Core plugin = Core.getInstance();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String name, String[] args) {
		
		if (cmd.getName().equalsIgnoreCase("ptreset")) {
			
			if (!(sender.hasPermission("oc.playtime-admin"))) {
				sender.sendMessage(ChatColor.RED + "You do not have permission for that!");
				return true;
			}
			
			if (args.length == 0) {
				for (Player player : Bukkit.getOnlinePlayers()) {
					player.setStatistic(Statistic.PLAY_ONE_TICK, 0);
					Bukkit.getServer().broadcastMessage(PlaytimeRewards.prefix + ChatColor.RED + " Playtime has been reset for the server.");
				}
			}
		}
		
		if (cmd.getName().equalsIgnoreCase("ptcheck")) {
			if (args.length == 0) {
				if(!(sender instanceof Player)) {
					sender.sendMessage("Please choose a player.");
				} else {
					Player player = (Player) sender;
					player.sendMessage(ChatColor.RED + "You are at " + ChatColor.GREEN + player.getStatistic(Statistic.PLAY_ONE_TICK) + ChatColor.RED + " ticks.");
				}
			}
		}
		
		if (cmd.getName().equalsIgnoreCase("ptset")) {
			
			if (sender instanceof Player){
				Player player = (Player) sender;
				
				if (!player.hasPermission("oc.playtime-admin")) {
					player.sendMessage(ChatColor.RED + "You do not have permission for that!");
					return true;
				}
			}
			
			if (args.length == 0) {
				sender.sendMessage(ChatColor.GRAY + "/ptset <player> <ticks>");
				return true;
			}
			if (args.length < 2) {
				sender.sendMessage(ChatColor.RED + "Please specift a number of ticks.");
				return true;
			}
			
			if (args.length == 2) {
				Player target = plugin.getServer().getPlayer(args[0]);
				
				if (!(StringUtils.isNumeric(args[1]))) {
					sender.sendMessage(ChatColor.RED + "Please provide a valid numeric value.");
					return true;
				}
				
				if (target == null) {
					sender.sendMessage(ChatColor.RED + "Player cannot be found.");
					return true;
				} else {
					target.setStatistic(Statistic.PLAY_ONE_TICK, Integer.valueOf(args[1]));
					PlaytimeConfig.save();
					sender.sendMessage(ChatColor.GREEN + "Ticks for player " + target.getName() + " have been set.");
					return true;
					
				}
			}
		}
		return true;
	}

}
