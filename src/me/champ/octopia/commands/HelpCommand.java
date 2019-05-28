package me.champ.octopia.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.champ.octopia.Core;
import net.md_5.bungee.api.ChatColor;

public class HelpCommand extends SubCommand {
	
	private Core plugin = Core.getInstance();

	@Override
	public void onCommand(CommandSender sender, String[] args) {
		Player player = (Player) sender;
		player.sendMessage(ChatColor.GOLD + " " + ChatColor.BOLD + "Octopia" + ChatColor.WHITE + " (v 0.1)");
		player.sendMessage(ChatColor.GRAY + "----------------------------");
		player.sendMessage(ChatColor.WHITE + "/help" + ChatColor.GRAY + " - Access the server help menu. ");
		player.sendMessage(ChatColor.WHITE + "/ocshop" + ChatColor.GRAY + " - Access the server shop.");
		player.sendMessage(ChatColor.WHITE + "/ocstats" + ChatColor.GRAY + " - Access your personal stats. ");
		player.sendMessage(ChatColor.WHITE + "/ptcheck" + ChatColor.GRAY + " - Check your playtime ticks.");

	}

	@Override
	public String name() {
		
		return plugin.commandHandler.help;
	}

}
