package me.champ.octopia.entity.spawners;

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

public class GUI {

	public Inventory lvl1inv;
	public Inventory lvl2inv;
	public Inventory lvl3inv;
	public Inventory lvl4inv;
	public Inventory lvl5inv;
	public Inventory inv;
	
	public Inventory mobShop;
	
	public Inventory egolem1;
	public Inventory egolem2;
	public Inventory egolem3;
	public Inventory egolem4;
	public Inventory egolem5;
	
	public Inventory dgolem1;
	public Inventory dgolem2;
	public Inventory dgolem3;
	public Inventory dgolem4;
	public Inventory dgolem5;
	
	
	public String lvl1Name = ChatColor.GOLD + "[Upgrade Menu] Level 1";
	public String lvl2Name = ChatColor.GOLD + "[Upgrade Menu] Level 2";
	public String lvl3Name = ChatColor.GOLD + "[Upgrade Menu] Level 3";
	public String lvl4Name = ChatColor.GOLD + "[Upgrade Menu] Level 4";
	public String lvl5Name = ChatColor.GOLD + "[Upgrade Menu] Max Level";
	
	public String mobShopTitle = ChatColor.DARK_GRAY + "Mob Shop";
	
	public String dgolem1name = ChatColor.AQUA + "[Level 1] Diamond Golem";
	public String dgolem2name = ChatColor.AQUA + "[Level 2] Diamond Golem";
	public String dgolem3name = ChatColor.AQUA + "[Level 3] Diamond Golem";
	public String dgolem4name = ChatColor.AQUA + "[Level 4] Diamond Golem";
	public String dgolem5name = ChatColor.AQUA + "[Level 5] Diamond Golem";
	
	public String egolem1name = ChatColor.GREEN + "[Level 1] Emerald Golem";
	public String egolem2name = ChatColor.GREEN + "[Level 2] Emerald Golem";
	public String egolem3name = ChatColor.GREEN + "[Level 3] Emerald Golem";
	public String egolem4name = ChatColor.GREEN + "[Level 4] Emerald Golem";
	public String egolem5name = ChatColor.GREEN + "[Level 5] Emerald Golem";
	
	
	public GUI() {
		inv = Bukkit.createInventory(null, 18, lvl1Name );
		lvl2inv = Bukkit.createInventory(null, 18, lvl2Name );
		lvl3inv = Bukkit.createInventory(null, 18, lvl3Name );
		lvl4inv = Bukkit.createInventory(null, 18, lvl4Name );
		lvl5inv = Bukkit.createInventory(null, 18, lvl5Name );
		
		egolem1 = Bukkit.createInventory(null, 18, egolem1name );
		egolem2 = Bukkit.createInventory(null, 18, egolem2name );
		egolem3 = Bukkit.createInventory(null, 18, egolem3name );
		egolem4 = Bukkit.createInventory(null, 18, egolem4name );
		egolem5 = Bukkit.createInventory(null, 18, egolem5name );
		
		dgolem1 = Bukkit.createInventory(null, 18, dgolem1name );
		dgolem2 = Bukkit.createInventory(null, 18, dgolem2name );
		dgolem3 = Bukkit.createInventory(null, 18, dgolem3name );
		dgolem4 = Bukkit.createInventory(null, 18, dgolem4name );
		dgolem5 = Bukkit.createInventory(null, 18, dgolem5name );
		
		mobShop = Bukkit.createInventory(null, 36, mobShopTitle);
	}
	
	public void initializeItems() {
        inv.setItem(0, createGuiItem( ChatColor.AQUA + "Spawner Stats", new ArrayList<String>(Arrays.asList(ChatColor.YELLOW + "Level:"+ ChatColor.WHITE + " 1", ChatColor.YELLOW + "Mobs Spawned: " + ChatColor.WHITE + "3")), Material.MOB_SPAWNER));
        inv.setItem(4, createGuiItem(ChatColor.AQUA + "Upgrade", new ArrayList<String>(Arrays.asList(ChatColor.YELLOW +"Cost:" + ChatColor.WHITE + " 250k", ChatColor.YELLOW + "About:" + ChatColor.WHITE + " +1 Mob Spawned")), Material.EMERALD));
        inv.setItem(8, createGuiItem(ChatColor.AQUA + "Next Level", new ArrayList<String>(Arrays.asList(ChatColor.YELLOW +"Level:" + ChatColor.WHITE +" 2",ChatColor.YELLOW + "Mobs Per Spawn:"+ ChatColor.WHITE +" - 4" )), Material.BOOK));
        inv.setItem(13, createGuiItem(ChatColor.YELLOW + "Close GUI", new ArrayList<String>(Arrays.asList()), Material.ANVIL)); 
        
        lvl2inv.setItem(0, createGuiItem(ChatColor.AQUA + "Spawner Stats", new ArrayList<String>(Arrays.asList(ChatColor.YELLOW +"Level:"+ ChatColor.WHITE +" 2", ChatColor.YELLOW + "Mobs Spawned:"+ ChatColor.WHITE +" 4")), Material.MOB_SPAWNER));
        lvl2inv.setItem(4, createGuiItem(ChatColor.AQUA + "Upgrade", new ArrayList<String>(Arrays.asList(ChatColor.YELLOW +"Cost:"+ ChatColor.WHITE +" 250k", ChatColor.YELLOW + "About:"+ ChatColor.WHITE +" +1 Mob Spawned")), Material.EMERALD));
        lvl2inv.setItem(8, createGuiItem(ChatColor.AQUA + "Next Level", new ArrayList<String>(Arrays.asList(ChatColor.YELLOW +"Level:"+ ChatColor.WHITE +" 3", ChatColor.YELLOW + "Mobs Per Spawn:"+ ChatColor.WHITE +" - 5" )), Material.BOOK));
        lvl2inv.setItem(13, createGuiItem(ChatColor.YELLOW + "Close GUI", new ArrayList<String>(Arrays.asList("")), Material.ANVIL)); 
        
        lvl3inv.setItem(0, createGuiItem(ChatColor.AQUA + "Spawner Stats", new ArrayList<String>(Arrays.asList(ChatColor.YELLOW +"Level:"+ ChatColor.WHITE +" 3", ChatColor.YELLOW + "Mobs Spawned:"+ ChatColor.WHITE +" 5")), Material.MOB_SPAWNER));
        lvl3inv.setItem(4, createGuiItem(ChatColor.AQUA + "Upgrade", new ArrayList<String>(Arrays.asList(ChatColor.YELLOW +"Cost:"+ ChatColor.WHITE +" 250k", ChatColor.YELLOW + "About:" + ChatColor.WHITE +" +1 Mob Spawned")), Material.EMERALD));
        lvl3inv.setItem(8, createGuiItem(ChatColor.AQUA + "Next Level", new ArrayList<String>(Arrays.asList(ChatColor.YELLOW +"Level:"+ ChatColor.WHITE +" 4", ChatColor.YELLOW + "Mobs Per Spawn:" + ChatColor.WHITE +" - 6" )), Material.BOOK));
        lvl3inv.setItem(13, createGuiItem(ChatColor.YELLOW + "Close GUI", new ArrayList<String>(Arrays.asList("")), Material.ANVIL));
        
        lvl4inv.setItem(0, createGuiItem(ChatColor.AQUA + "Spawner Stats", new ArrayList<String>(Arrays.asList(ChatColor.YELLOW +"Level:"+ ChatColor.WHITE +" 4", ChatColor.YELLOW + "Mobs Spawned:"+ ChatColor.WHITE +" 6")), Material.MOB_SPAWNER));
        lvl4inv.setItem(4, createGuiItem(ChatColor.AQUA + "Upgrade", new ArrayList<String>(Arrays.asList(ChatColor.YELLOW +"Cost:"+ ChatColor.WHITE +" 250k", ChatColor.YELLOW + "About:"+ ChatColor.WHITE +" +1 Mob Spawned")), Material.EMERALD));
        lvl4inv.setItem(8, createGuiItem(ChatColor.AQUA + "Next Level", new ArrayList<String>(Arrays.asList(ChatColor.YELLOW +"Level:"+ ChatColor.WHITE +" 5", ChatColor.YELLOW + "Mobs Per Spawn:"+ ChatColor.WHITE +" - 7" )), Material.BOOK));
        lvl4inv.setItem(13, createGuiItem(ChatColor.YELLOW + "Close GUI", new ArrayList<String>(Arrays.asList("")), Material.ANVIL));
        
        lvl5inv.setItem(0, createGuiItem(ChatColor.AQUA + "Spawner Stats", new ArrayList<String>(Arrays.asList(ChatColor.YELLOW +"Level:"+ ChatColor.WHITE +" 5", ChatColor.YELLOW + "Mobs Spawned: 7")), Material.MOB_SPAWNER));
        lvl5inv.setItem(4, createGuiItem(ChatColor.AQUA + "Upgrade", new ArrayList<String>(Arrays.asList(ChatColor.YELLOW +"You have reached the max level.")), Material.EMERALD));
        lvl5inv.setItem(8, createGuiItem(ChatColor.AQUA + "Next Level", new ArrayList<String>(Arrays.asList(ChatColor.YELLOW +"You have reached the max level." )), Material.BOOK));
        lvl5inv.setItem(13, createGuiItem(ChatColor.YELLOW + "Close GUI", new ArrayList<String>(Arrays.asList("")), Material.ANVIL));
        
        mobShop.setItem(13, this.getGolemHead(ChatColor.AQUA + "" + ChatColor.BOLD + "Diamond Golem", "diamonds"));
		mobShop.setItem(13, this.getGolemHead(ChatColor.GREEN + "" + ChatColor.BOLD + "Emerald Golem", "emeralds"));
		
		egolem1.setItem(0, createGuiItem( ChatColor.AQUA + "Spawner Stats", new ArrayList<String>(Arrays.asList(ChatColor.YELLOW + "Level:"+ ChatColor.WHITE + " 1", ChatColor.YELLOW + "Mobs Spawned: " + ChatColor.WHITE + "3")), Material.MOB_SPAWNER));
		egolem1.setItem(4, createGuiItem(ChatColor.AQUA + "Upgrade", new ArrayList<String>(Arrays.asList(ChatColor.YELLOW +"Cost:" + ChatColor.WHITE + " 250k", ChatColor.YELLOW + "About:" + ChatColor.WHITE + " +1 Mob Spawned")), Material.EMERALD));
		egolem1.setItem(8, createGuiItem(ChatColor.AQUA + "Next Level", new ArrayList<String>(Arrays.asList(ChatColor.YELLOW +"Level:" + ChatColor.WHITE +" 2",ChatColor.YELLOW + "Mobs Per Spawn:"+ ChatColor.WHITE +" - 4" )), Material.BOOK));
		egolem1.setItem(13, createGuiItem(ChatColor.YELLOW + "Close GUI", new ArrayList<String>(Arrays.asList()), Material.ANVIL)); 
		
		egolem2.setItem(0, createGuiItem(ChatColor.AQUA + "Spawner Stats", new ArrayList<String>(Arrays.asList(ChatColor.YELLOW +"Level:"+ ChatColor.WHITE +" 2", ChatColor.YELLOW + "Mobs Spawned:"+ ChatColor.WHITE +" 4")), Material.MOB_SPAWNER));
		egolem2.setItem(4, createGuiItem(ChatColor.AQUA + "Upgrade", new ArrayList<String>(Arrays.asList(ChatColor.YELLOW +"Cost:"+ ChatColor.WHITE +" 250k", ChatColor.YELLOW + "About:"+ ChatColor.WHITE +" +1 Mob Spawned")), Material.EMERALD));
		egolem2.setItem(8, createGuiItem(ChatColor.AQUA + "Next Level", new ArrayList<String>(Arrays.asList(ChatColor.YELLOW +"Level:"+ ChatColor.WHITE +" 3", ChatColor.YELLOW + "Mobs Per Spawn:"+ ChatColor.WHITE +" - 5" )), Material.BOOK));
		egolem2.setItem(13, createGuiItem(ChatColor.YELLOW + "Close GUI", new ArrayList<String>(Arrays.asList("")), Material.ANVIL)); 
		
		egolem3.setItem(0, createGuiItem(ChatColor.AQUA + "Spawner Stats", new ArrayList<String>(Arrays.asList(ChatColor.YELLOW +"Level:"+ ChatColor.WHITE +" 3", ChatColor.YELLOW + "Mobs Spawned:"+ ChatColor.WHITE +" 5")), Material.MOB_SPAWNER));
		egolem3.setItem(4, createGuiItem(ChatColor.AQUA + "Upgrade", new ArrayList<String>(Arrays.asList(ChatColor.YELLOW +"Cost:"+ ChatColor.WHITE +" 250k", ChatColor.YELLOW + "About:" + ChatColor.WHITE +" +1 Mob Spawned")), Material.EMERALD));
		egolem3.setItem(8, createGuiItem(ChatColor.AQUA + "Next Level", new ArrayList<String>(Arrays.asList(ChatColor.YELLOW +"Level:"+ ChatColor.WHITE +" 4", ChatColor.YELLOW + "Mobs Per Spawn:" + ChatColor.WHITE +" - 6" )), Material.BOOK));
		egolem3.setItem(13, createGuiItem(ChatColor.YELLOW + "Close GUI", new ArrayList<String>(Arrays.asList("")), Material.ANVIL));
		
		egolem4.setItem(0, createGuiItem(ChatColor.AQUA + "Spawner Stats", new ArrayList<String>(Arrays.asList(ChatColor.YELLOW +"Level:"+ ChatColor.WHITE +" 4", ChatColor.YELLOW + "Mobs Spawned:"+ ChatColor.WHITE +" 6")), Material.MOB_SPAWNER));
		egolem4.setItem(4, createGuiItem(ChatColor.AQUA + "Upgrade", new ArrayList<String>(Arrays.asList(ChatColor.YELLOW +"Cost:"+ ChatColor.WHITE +" 250k", ChatColor.YELLOW + "About:"+ ChatColor.WHITE +" +1 Mob Spawned")), Material.EMERALD));
		egolem4.setItem(8, createGuiItem(ChatColor.AQUA + "Next Level", new ArrayList<String>(Arrays.asList(ChatColor.YELLOW +"Level:"+ ChatColor.WHITE +" 5", ChatColor.YELLOW + "Mobs Per Spawn:"+ ChatColor.WHITE +" - 7" )), Material.BOOK));
		egolem4.setItem(13, createGuiItem(ChatColor.YELLOW + "Close GUI", new ArrayList<String>(Arrays.asList("")), Material.ANVIL));
		
		egolem5.setItem(0, createGuiItem(ChatColor.AQUA + "Spawner Stats", new ArrayList<String>(Arrays.asList(ChatColor.YELLOW +"Level:"+ ChatColor.WHITE +" 5", ChatColor.YELLOW + "Mobs Spawned: 7")), Material.MOB_SPAWNER));
		egolem5.setItem(4, createGuiItem(ChatColor.AQUA + "Upgrade", new ArrayList<String>(Arrays.asList(ChatColor.YELLOW +"You have reached the max level.")), Material.EMERALD));
		egolem5.setItem(8, createGuiItem(ChatColor.AQUA + "Next Level", new ArrayList<String>(Arrays.asList(ChatColor.YELLOW +"You have reached the max level." )), Material.BOOK));
		egolem5.setItem(13, createGuiItem(ChatColor.YELLOW + "Close GUI", new ArrayList<String>(Arrays.asList("")), Material.ANVIL));
		
		dgolem1.setItem(0, createGuiItem( ChatColor.AQUA + "Spawner Stats", new ArrayList<String>(Arrays.asList(ChatColor.YELLOW + "Level:"+ ChatColor.WHITE + " 1", ChatColor.YELLOW + "Mobs Spawned: " + ChatColor.WHITE + "3")), Material.MOB_SPAWNER));
		dgolem1.setItem(4, createGuiItem(ChatColor.AQUA + "Upgrade", new ArrayList<String>(Arrays.asList(ChatColor.YELLOW +"Cost:" + ChatColor.WHITE + " 250k", ChatColor.YELLOW + "About:" + ChatColor.WHITE + " +1 Mob Spawned")), Material.EMERALD));
		dgolem1.setItem(8, createGuiItem(ChatColor.AQUA + "Next Level", new ArrayList<String>(Arrays.asList(ChatColor.YELLOW +"Level:" + ChatColor.WHITE +" 2",ChatColor.YELLOW + "Mobs Per Spawn:"+ ChatColor.WHITE +" - 4" )), Material.BOOK));
		dgolem1.setItem(13, createGuiItem(ChatColor.YELLOW + "Close GUI", new ArrayList<String>(Arrays.asList()), Material.ANVIL)); 
		
		
		dgolem2.setItem(0, createGuiItem(ChatColor.AQUA + "Spawner Stats", new ArrayList<String>(Arrays.asList(ChatColor.YELLOW +"Level:"+ ChatColor.WHITE +" 2", ChatColor.YELLOW + "Mobs Spawned:"+ ChatColor.WHITE +" 4")), Material.MOB_SPAWNER));
		dgolem2.setItem(4, createGuiItem(ChatColor.AQUA + "Upgrade", new ArrayList<String>(Arrays.asList(ChatColor.YELLOW +"Cost:"+ ChatColor.WHITE +" 250k", ChatColor.YELLOW + "About:"+ ChatColor.WHITE +" +1 Mob Spawned")), Material.EMERALD));
		dgolem2.setItem(8, createGuiItem(ChatColor.AQUA + "Next Level", new ArrayList<String>(Arrays.asList(ChatColor.YELLOW +"Level:"+ ChatColor.WHITE +" 3", ChatColor.YELLOW + "Mobs Per Spawn:"+ ChatColor.WHITE +" - 5" )), Material.BOOK));
		dgolem2.setItem(13, createGuiItem(ChatColor.YELLOW + "Close GUI", new ArrayList<String>(Arrays.asList("")), Material.ANVIL)); 
		
		dgolem3.setItem(0, createGuiItem(ChatColor.AQUA + "Spawner Stats", new ArrayList<String>(Arrays.asList(ChatColor.YELLOW +"Level:"+ ChatColor.WHITE +" 3", ChatColor.YELLOW + "Mobs Spawned:"+ ChatColor.WHITE +" 5")), Material.MOB_SPAWNER));
		dgolem3.setItem(4, createGuiItem(ChatColor.AQUA + "Upgrade", new ArrayList<String>(Arrays.asList(ChatColor.YELLOW +"Cost:"+ ChatColor.WHITE +" 250k", ChatColor.YELLOW + "About:" + ChatColor.WHITE +" +1 Mob Spawned")), Material.EMERALD));
		dgolem3.setItem(8, createGuiItem(ChatColor.AQUA + "Next Level", new ArrayList<String>(Arrays.asList(ChatColor.YELLOW +"Level:"+ ChatColor.WHITE +" 4", ChatColor.YELLOW + "Mobs Per Spawn:" + ChatColor.WHITE +" - 6" )), Material.BOOK));
		dgolem3.setItem(13, createGuiItem(ChatColor.YELLOW + "Close GUI", new ArrayList<String>(Arrays.asList("")), Material.ANVIL));
		
		dgolem4.setItem(0, createGuiItem(ChatColor.AQUA + "Spawner Stats", new ArrayList<String>(Arrays.asList(ChatColor.YELLOW +"Level:"+ ChatColor.WHITE +" 4", ChatColor.YELLOW + "Mobs Spawned:"+ ChatColor.WHITE +" 6")), Material.MOB_SPAWNER));
		dgolem4.setItem(4, createGuiItem(ChatColor.AQUA + "Upgrade", new ArrayList<String>(Arrays.asList(ChatColor.YELLOW +"Cost:"+ ChatColor.WHITE +" 250k", ChatColor.YELLOW + "About:"+ ChatColor.WHITE +" +1 Mob Spawned")), Material.EMERALD));
		dgolem4.setItem(8, createGuiItem(ChatColor.AQUA + "Next Level", new ArrayList<String>(Arrays.asList(ChatColor.YELLOW +"Level:"+ ChatColor.WHITE +" 5", ChatColor.YELLOW + "Mobs Per Spawn:"+ ChatColor.WHITE +" - 7" )), Material.BOOK));
		dgolem4.setItem(13, createGuiItem(ChatColor.YELLOW + "Close GUI", new ArrayList<String>(Arrays.asList("")), Material.ANVIL));
		
		dgolem5.setItem(0, createGuiItem(ChatColor.AQUA + "Spawner Stats", new ArrayList<String>(Arrays.asList(ChatColor.YELLOW +"Level:"+ ChatColor.WHITE +" 5", ChatColor.YELLOW + "Mobs Spawned: 7")), Material.MOB_SPAWNER));
		dgolem5.setItem(4, createGuiItem(ChatColor.AQUA + "Upgrade", new ArrayList<String>(Arrays.asList(ChatColor.YELLOW +"You have reached the max level.")), Material.EMERALD));
		dgolem5.setItem(8, createGuiItem(ChatColor.AQUA + "Next Level", new ArrayList<String>(Arrays.asList(ChatColor.YELLOW +"You have reached the max level." )), Material.BOOK));
		dgolem5.setItem(13, createGuiItem(ChatColor.YELLOW + "Close GUI", new ArrayList<String>(Arrays.asList("")), Material.ANVIL));
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
