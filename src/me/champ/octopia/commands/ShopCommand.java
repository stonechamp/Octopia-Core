package me.champ.octopia.commands;

import org.bukkit.entity.Player;

import me.champ.octopia.Core;

public class ShopCommand extends SubCommand {
	
	private Core plugin = Core.getInstance();

	@Override
	public void onCommand(Player player, String[] args) {
		plugin.getShop().openInventory(player, plugin.getShop().getMainShop());
		plugin.getShop().setup();

	}

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return plugin.commandHandler.shop;
	}

}
