package me.champ.octopia.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public abstract class SubCommand {
	
	public SubCommand() {
		
	}
	
	public abstract void onCommand(CommandSender sender, String[] args);
	
	public abstract String name();
	

}
