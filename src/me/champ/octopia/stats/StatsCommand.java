package me.champ.octopia.stats;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.champ.octopia.guis.StatsGui;

public class StatsCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String name, String[] args) {
		
		if (command.getName().equalsIgnoreCase("ocstats")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				StatsGui gui = new StatsGui(player);
				gui.open(player);
			}
		}
		
		return true;
	} 

}
