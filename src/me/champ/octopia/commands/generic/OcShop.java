package me.champ.octopia.commands.generic;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



public class OcShop implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String name, String[] args) {
		
		if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.DARK_RED + "Only players can run this command.");
			return true;
		}
		
		Player player = (Player) sender;
		
		if (command.getName().equalsIgnoreCase("ocshop")) {
			player.performCommand("oc shop");
			
		}
		
		return true;
	}
	
	

}
