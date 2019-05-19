package me.champ.octopia.commands;

import org.bukkit.entity.Player;

import me.champ.octopia.Core;
import net.md_5.bungee.api.ChatColor;

public class HelpCommand extends SubCommand {
	
	private Core plugin = Core.getInstance();

	@Override
	public void onCommand(Player player, String[] args) {
		
		player.sendMessage(ChatColor.GOLD + " " + ChatColor.BOLD + "Octopia" + ChatColor.WHITE + " (v 0.1)");
		player.sendMessage(ChatColor.GRAY + "----------------------------");
		player.sendMessage(ChatColor.WHITE + "/oc shop" + ChatColor.GRAY + " - Access the server shop. ");

	}

	@Override
	public String name() {
		
		return plugin.commandHandler.help;
	}

}
