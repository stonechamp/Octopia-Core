package me.champ.octopia.shop;


import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;





public class Shop {
	
	public Inventory main;
	public Inventory mobShop;
	
	public String mainShopTitle = ChatColor.DARK_GRAY + "Octopia Shop";
	public String mobShopTitle = ChatColor.DARK_GRAY + "Mob Shop";
	
	public Shop() {
		main = Bukkit.createInventory(null, 45, mainShopTitle);
		mobShop = Bukkit.createInventory(null, 36, mobShopTitle);
		
		setup();
	}
	
	@SuppressWarnings("deprecation")
	public void setup() {
		main.setItem(11, createGuiItem(ChatColor.AQUA + "" + ChatColor.BOLD + "Custom Spawners", new ArrayList<String>(Arrays.asList(ChatColor.GRAY + "Buy custom spawners",ChatColor.GRAY + "that can give the upper hand", ChatColor.GRAY + "as you take on your foes!", " ", ChatColor.YELLOW + "Click to browse!")), Material.MOB_SPAWNER));
		main.setItem(13, createGuiItem(ChatColor.AQUA + "" + ChatColor.BOLD + "Wands", new ArrayList<String>(Arrays.asList(ChatColor.GRAY + "Buy custom wands",ChatColor.GRAY + "that can give the upper hand", ChatColor.GRAY + "as you take on your foes!", " ", ChatColor.YELLOW + "Click to browse!")), Material.BLAZE_ROD));
		main.setItem(15, createGuiItem(ChatColor.AQUA + "" + ChatColor.BOLD + "Void Chests", new ArrayList<String>(Arrays.asList(ChatColor.GRAY + "Buy custom chests",ChatColor.GRAY + "that can give the upper hand", ChatColor.GRAY + "as you take on your foes!", " ", ChatColor.YELLOW + "Click to browse!")), Material.ENDER_CHEST));
		main.setItem(29, createGuiItem(ChatColor.AQUA + "" + ChatColor.BOLD + "Generators", new ArrayList<String>(Arrays.asList(ChatColor.GRAY + "Buy custom generators",ChatColor.GRAY + "that can give the upper hand", ChatColor.GRAY + "as you take on your foes!", " ", ChatColor.YELLOW + "Click to browse!")), Material.DIAMOND_ORE));
		main.setItem(33, createGuiItem(ChatColor.AQUA + "" + ChatColor.BOLD + "Hoppers", new ArrayList<String>(Arrays.asList(ChatColor.GRAY + "Buy custom hoopers",ChatColor.GRAY + "that can give the upper hand", ChatColor.GRAY + "as you take on your foes!", " ", ChatColor.YELLOW + "Click to browse!")), Material.SKULL_ITEM));
		
		main.setItem(0, new ItemStack(Material.STAINED_GLASS_PANE,1, (byte) 4));
		main.setItem(1, new ItemStack(Material.STAINED_GLASS_PANE,1, (byte) 3));
		main.setItem(3, new ItemStack(Material.STAINED_GLASS_PANE,1, (byte) 3));
		main.setItem(4, new ItemStack(Material.STAINED_GLASS_PANE,1, (byte) 4));
		main.setItem(5, new ItemStack(Material.STAINED_GLASS_PANE,1, (byte) 3));
		main.setItem(7, new ItemStack(Material.STAINED_GLASS_PANE,1, (byte) 3));
		main.setItem(8, new ItemStack(Material.STAINED_GLASS_PANE,1, (byte) 4));
		main.setItem(9, new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 3));
		main.setItem(27, new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 3));
		main.setItem(36, new ItemStack(Material.STAINED_GLASS_PANE,1, (byte) 4));
		main.setItem(17, new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 3));
		main.setItem(35, new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 3));
		main.setItem(37, new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 3));
		main.setItem(39, new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 3));
		main.setItem(40, new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 4));
		main.setItem(41, new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 3));
		main.setItem(43, new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 3));
		main.setItem(44, new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 4));
		
		mobShop.setItem(14, this.getGolemHead(ChatColor.AQUA + "" + ChatColor.BOLD + "Diamond Golem", "diamonds"));
		mobShop.setItem(13, this.getGolemHead(ChatColor.GREEN + "" + ChatColor.BOLD + "Emerald Golem", "emeralds"));
	}
	
	public ItemStack createGuiItem(String name, ArrayList<String> desc, Material mat) {
        ItemStack i = new ItemStack(mat, 1);
        ItemMeta iMeta = i.getItemMeta();
        iMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        iMeta.setDisplayName(name);
        iMeta.setLore(desc);
        i.setItemMeta(iMeta);
        return i;
    }
	
	public void openInventory(Player p, Inventory i) {
        p.openInventory(i);
        return;
    }
	
	public String getMainShopTitle() {
		return mainShopTitle;
	}
	
	public String getMobShopTitle() {
		return mobShopTitle;
	}
	
	public Inventory getMainShop() {
		return main;
	}
	
	public Inventory getMobShop() {
		return mobShop;
	}
	
	@SuppressWarnings("deprecation")
	public ItemStack getGolemHead(String name, String item) {
		//Heads for the mob shop.
		ItemStack golem = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
		SkullMeta golemMeta = (SkullMeta) golem.getItemMeta();
		golemMeta.setDisplayName(name);
		ArrayList<String> lore = new ArrayList<String>(Arrays.asList(ChatColor.GRAY + "Drops " + item + " upon death.", "", ChatColor.YELLOW + "Click to purchase!"));
		golemMeta.setLore(lore);
		golemMeta.setOwner("MHF_Golem");
		golem.setItemMeta(golemMeta);
		return golem;
	}
	
	

}
