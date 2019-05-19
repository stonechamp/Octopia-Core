package me.champ.octopia.guis;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import me.champ.octopia.Core;
import me.champ.octopia.stats.StatsConfig;
import me.champ.octopia.stats.TimeUtil;
import net.milkbowl.vault.economy.Economy;




public class StatsGui {
	
	private Core plugin = Core.getInstance();
	
	public Inventory statsGui;
	
	public StatsGui(Player player) {
		statsGui = Bukkit.createInventory(null, 45, ChatColor.DARK_GRAY + player.getName() + "'s" + " Stats");
		
		setup(player);
	}
	
	public void setup(Player player) {
		statsGui.setItem(0, new ItemStack(Material.STAINED_GLASS_PANE,1, (byte) 4));
		statsGui.setItem(1, new ItemStack(Material.STAINED_GLASS_PANE,1, (byte) 3));
		statsGui.setItem(3, new ItemStack(Material.STAINED_GLASS_PANE,1, (byte) 3));
		statsGui.setItem(4, new ItemStack(Material.STAINED_GLASS_PANE,1, (byte) 4));
		statsGui.setItem(5, new ItemStack(Material.STAINED_GLASS_PANE,1, (byte) 3));
		statsGui.setItem(7, new ItemStack(Material.STAINED_GLASS_PANE,1, (byte) 3));
		statsGui.setItem(8, new ItemStack(Material.STAINED_GLASS_PANE,1, (byte) 4));
		statsGui.setItem(9, new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 3));
		statsGui.setItem(27, new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 3));
		statsGui.setItem(36, new ItemStack(Material.STAINED_GLASS_PANE,1, (byte) 4));
		statsGui.setItem(17, new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 3));
		statsGui.setItem(35, new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 3));
		statsGui.setItem(37, new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 3));
		statsGui.setItem(39, new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 3));
		statsGui.setItem(40, new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 4));
		statsGui.setItem(41, new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 3));
		statsGui.setItem(43, new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 3));
		statsGui.setItem(44, new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 4));
		
		statsGui.setItem(22, addTimeIcon(player));
		statsGui.setItem(21, addKillsIcon(player));
		statsGui.setItem(23, addBlocksIcon(player));
		statsGui.setItem(13, addDeathsIcon(player));
		statsGui.setItem(31, addProfileIcon(player));
	}
	
	public ItemStack addTimeIcon(Player player) {
		ItemStack time = new ItemStack(Material.WATCH);
		long timeJoin = StatsConfig.getStatsConfig().getLong("players." + player.getUniqueId() + ".total-time");
		ItemMeta meta = time.getItemMeta();
		meta.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "Time Played");
		List<String> lore = new ArrayList<String>();
		TimeUtil util = new TimeUtil();
		lore.add(ChatColor.GRAY + util.timePlayer(timeJoin));
		lore.add("");
		lore.add(ChatColor.GREEN + "(Click for leadboard)");
		meta.setLore(lore);
		time.setItemMeta(meta);
		
		
		return time;
	}
	
	public ItemStack addProfileIcon(Player player) {
		ItemStack profile = new ItemStack(Material.EMERALD);
		//kills.addEnchantment(Enchantment.FIRE_ASPECT, 2);
		ItemMeta meta = profile.getItemMeta();
		meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Balance");
		List<String> lore = new ArrayList<String>();
		Economy econ = plugin.getEcononomy();
		lore.add(ChatColor.GRAY + String.valueOf(econ.getBalance(player)) + "$");
		meta.setLore(lore);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		profile.setItemMeta(meta);
		return profile;
	}
	
	public ItemStack addKillsIcon(Player player) {
		ItemStack kills = new ItemStack(Material.BOW);
		//kills.addEnchantment(Enchantment.FIRE_ASPECT, 2);
		ItemMeta meta = kills.getItemMeta();
		meta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Kills");
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GRAY + String.valueOf(player.getStatistic(Statistic.PLAYER_KILLS)));
		meta.setLore(lore);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		kills.setItemMeta(meta);
		return kills;
	}
	
	public ItemStack addBlocksIcon(Player player) {
		ItemStack blocks = new ItemStack(Material.IRON_PICKAXE);
		//blocks.addEnchantment(Enchantment.SILK_TOUCH, 1);
		ItemMeta meta = blocks.getItemMeta();
		meta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Blocks Mined");
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GRAY + StatsConfig.getStatsConfig().getString("players." + player.getUniqueId() + ".blocks"));
		meta.setLore(lore);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		blocks.setItemMeta(meta);
		return blocks;
	}
	
	public ItemStack addDeathsIcon(Player player) {
		ItemStack deaths = new ItemStack(Material.SKULL_ITEM);
		SkullMeta meta = (SkullMeta) deaths.getItemMeta();
		meta.setOwner(player.getName());
		meta.setDisplayName(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Deaths");
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GRAY + String.valueOf(player.getStatistic(Statistic.DEATHS)));
		meta.setLore(lore);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		deaths.setItemMeta(meta);
		return deaths;
	}
	
	public void open(Player player) {
		player.openInventory(statsGui);
	}

}
