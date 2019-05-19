package me.champ.octopia.guis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;



import me.champ.octopia.stats.StatsConfig;
import me.champ.octopia.stats.TimeUtil;

public class PlaytimeLeaderBoard {
	
	public Inventory ptleaders;
	
	public PlaytimeLeaderBoard() {
		ptleaders = Bukkit.createInventory(null, 45, "Playtime Leaderboard");
		
		setup();
	}

	private void setup() {
		ptleaders.setItem(0, new ItemStack(Material.STAINED_GLASS_PANE,1, (byte) 4));
		ptleaders.setItem(1, new ItemStack(Material.STAINED_GLASS_PANE,1, (byte) 3));
		ptleaders.setItem(3, new ItemStack(Material.STAINED_GLASS_PANE,1, (byte) 3));
		ptleaders.setItem(4, new ItemStack(Material.STAINED_GLASS_PANE,1, (byte) 4));
		ptleaders.setItem(5, new ItemStack(Material.STAINED_GLASS_PANE,1, (byte) 3));
		ptleaders.setItem(7, new ItemStack(Material.STAINED_GLASS_PANE,1, (byte) 3));
		ptleaders.setItem(8, new ItemStack(Material.STAINED_GLASS_PANE,1, (byte) 4));
		ptleaders.setItem(9, new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 3));
		ptleaders.setItem(27, new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 3));
		ptleaders.setItem(36, new ItemStack(Material.STAINED_GLASS_PANE,1, (byte) 4));
		ptleaders.setItem(17, new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 3));
		ptleaders.setItem(35, new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 3));
		ptleaders.setItem(37, new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 3));
		ptleaders.setItem(39, new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 3));
		ptleaders.setItem(40, new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 4));
		ptleaders.setItem(41, new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 3));
		ptleaders.setItem(43, new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 3));
		ptleaders.setItem(44, new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 4));
		
		
		if (listOfStatUsersToInt() == 1) {
			ptleaders.setItem(13, get1stPlace());
		} else if (listOfStatUsersToInt() == 2) {
			ptleaders.setItem(13, get1stPlace());
			ptleaders.setItem(21, get2ndPlace());
		} else if (listOfStatUsersToInt() == 3) {
			ptleaders.setItem(13, get1stPlace());
			ptleaders.setItem(21, get2ndPlace());
			ptleaders.setItem(23, get3rdPlace());
		} else if (listOfStatUsersToInt() == 4) {
			ptleaders.setItem(13, get1stPlace());
			ptleaders.setItem(21, get2ndPlace());
			ptleaders.setItem(23, get3rdPlace());
			ptleaders.setItem(29, get4thPlace());
		} else if (listOfStatUsersToInt() == 5){
			ptleaders.setItem(13, get1stPlace());
			ptleaders.setItem(21, get2ndPlace());
			ptleaders.setItem(23, get3rdPlace());
			ptleaders.setItem(29, get4thPlace());
			ptleaders.setItem(31, get5thPlace());
		} else {
			ptleaders.setItem(13, get1stPlace());
			ptleaders.setItem(21, get2ndPlace());
			ptleaders.setItem(23, get3rdPlace());
			ptleaders.setItem(29, get4thPlace());
			ptleaders.setItem(31, get5thPlace());
			ptleaders.setItem(33, get6thPlace());
		}
		
		
	}
	
	private ItemStack get1stPlace() {
		UUID uuid = UUID.fromString(first());
		ItemStack first = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
		SkullMeta meta = (SkullMeta) first.getItemMeta();
		meta.setOwner(Bukkit.getOfflinePlayer(uuid).getName());
		meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "(First Place) " + Bukkit.getOfflinePlayer(uuid).getName());
		List<String> lore = new ArrayList<String>();
		TimeUtil util = new TimeUtil();
		lore.add(ChatColor.GRAY + util.timePlayer((long) StatsConfig.getStatsConfig().getInt("players." + uuid + ".total-time")));
		meta.setLore(lore);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		first.setItemMeta(meta);
		return first;
	}
	
	private ItemStack get2ndPlace() {
		UUID uuid = UUID.fromString(second());
		ItemStack first = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
		SkullMeta meta = (SkullMeta) first.getItemMeta();
		meta.setOwner(Bukkit.getOfflinePlayer(uuid).getName());
		meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "(Second Place) " + Bukkit.getOfflinePlayer(uuid).getName());
		List<String> lore = new ArrayList<String>();
		TimeUtil util = new TimeUtil();
		lore.add(ChatColor.GRAY + util.timePlayer((long) StatsConfig.getStatsConfig().getInt("players." + uuid + ".total-time")));
		meta.setLore(lore);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		first.setItemMeta(meta);
		return first;
	}
	
	private ItemStack get3rdPlace() {
		UUID uuid = UUID.fromString(third());
		ItemStack first = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
		SkullMeta meta = (SkullMeta) first.getItemMeta();
		meta.setOwner(Bukkit.getOfflinePlayer(uuid).getName());
		meta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "(Third Place) " + Bukkit.getOfflinePlayer(uuid).getName());
		List<String> lore = new ArrayList<String>();
		TimeUtil util = new TimeUtil();
		lore.add(ChatColor.GRAY + util.timePlayer((long) StatsConfig.getStatsConfig().getInt("players." + uuid + ".total-time")));
		meta.setLore(lore);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		first.setItemMeta(meta);
		return first;
	}
	
	private ItemStack get4thPlace() {
		UUID uuid = UUID.fromString(fourth());
		ItemStack first = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
		SkullMeta meta = (SkullMeta) first.getItemMeta();
		meta.setOwner(Bukkit.getOfflinePlayer(uuid).getName());
		meta.setDisplayName(ChatColor.DARK_BLUE + "" + ChatColor.BOLD + "(Fourth Place) " + Bukkit.getOfflinePlayer(uuid).getName());
		List<String> lore = new ArrayList<String>();
		TimeUtil util = new TimeUtil();
		lore.add(ChatColor.GRAY + util.timePlayer((long) StatsConfig.getStatsConfig().getInt("players." + uuid + ".total-time")));
		meta.setLore(lore);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		first.setItemMeta(meta);
		return first;
	}
	
	private ItemStack get5thPlace() {
		UUID uuid = UUID.fromString(five());
		ItemStack first = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
		SkullMeta meta = (SkullMeta) first.getItemMeta();
		meta.setOwner(Bukkit.getOfflinePlayer(uuid).getName());
		meta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "(Fifth Place) " + Bukkit.getOfflinePlayer(uuid).getName());
		List<String> lore = new ArrayList<String>();
		TimeUtil util = new TimeUtil();
		lore.add(ChatColor.GRAY + util.timePlayer((long) StatsConfig.getStatsConfig().getInt("players." + uuid + ".total-time")));
		meta.setLore(lore);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		first.setItemMeta(meta);
		return first;
	}
	
	private ItemStack get6thPlace() {
		UUID uuid = UUID.fromString(six());
		ItemStack first = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
		SkullMeta meta = (SkullMeta) first.getItemMeta();
		meta.setOwner(Bukkit.getOfflinePlayer(uuid).getName());
		meta.setDisplayName(ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "(Sixth Place) " + Bukkit.getOfflinePlayer(uuid).getName());
		List<String> lore = new ArrayList<String>();
		TimeUtil util = new TimeUtil();
		lore.add(ChatColor.GRAY + util.timePlayer((long) StatsConfig.getStatsConfig().getInt("players." + uuid + ".total-time")));
		meta.setLore(lore);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		first.setItemMeta(meta);
		return first;
	}
	
	private String first() {
		HashMap<String, Integer> map = new HashMap<>();
        for (String s : StatsConfig.getStatsConfig().getConfigurationSection("players").getKeys(false)) {

            int num = StatsConfig.getStatsConfig().getInt("players." + s + ".total-time");
            map.put(s, num);
        }
        LinkedHashMap<String, Integer> reverseSortedMap = new LinkedHashMap<>();
        
        //Use Comparator.reverseOrder() for reverse ordering
        map.entrySet()
          .stream()
          .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
          .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));
        return (String) reverseSortedMap.keySet().toArray()[0];
	}
	
	private String second() {
		HashMap<String, Integer> map = new HashMap<>();
        for (String s : StatsConfig.getStatsConfig().getConfigurationSection("players").getKeys(false)) {

            int num = StatsConfig.getStatsConfig().getInt("players." + s + ".total-time");
            map.put(s, num);
        }
        LinkedHashMap<String, Integer> reverseSortedMap = new LinkedHashMap<>();
        
        //Use Comparator.reverseOrder() for reverse ordering
        map.entrySet()
          .stream()
          .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
          .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));
        return (String) reverseSortedMap.keySet().toArray()[1];
	}
	
	private String third() {
		HashMap<String, Integer> map = new HashMap<>();
        for (String s : StatsConfig.getStatsConfig().getConfigurationSection("players").getKeys(false)) {

            int num = StatsConfig.getStatsConfig().getInt("players." + s + ".total-time");
            map.put(s, num);
        }
        LinkedHashMap<String, Integer> reverseSortedMap = new LinkedHashMap<>();
        
        //Use Comparator.reverseOrder() for reverse ordering
        map.entrySet()
          .stream()
          .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
          .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));
        System.out.println(reverseSortedMap);
        return (String) reverseSortedMap.keySet().toArray()[2];
	}
	
	private String fourth() {
		HashMap<String, Integer> map = new HashMap<>();
        for (String s : StatsConfig.getStatsConfig().getConfigurationSection("players").getKeys(false)) {

            int num = StatsConfig.getStatsConfig().getInt("players." + s + ".total-time");
            map.put(s, num);
        }
        LinkedHashMap<String, Integer> reverseSortedMap = new LinkedHashMap<>();
        
        //Use Comparator.reverseOrder() for reverse ordering
        map.entrySet()
          .stream()
          .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
          .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));
        return (String) reverseSortedMap.keySet().toArray()[3];
	}
	
	private String five() {
		HashMap<String, Integer> map = new HashMap<>();
        for (String s : StatsConfig.getStatsConfig().getConfigurationSection("players").getKeys(false)) {

            int num = StatsConfig.getStatsConfig().getInt("players." + s + ".total-time");
            map.put(s, num);
        }
        LinkedHashMap<String, Integer> reverseSortedMap = new LinkedHashMap<>();
        
        //Use Comparator.reverseOrder() for reverse ordering
        map.entrySet()
          .stream()
          .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
          .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));

        return (String) reverseSortedMap.keySet().toArray()[4];
	}
	
	private String six() {
		HashMap<String, Integer> map = new HashMap<>();
        for (String s : StatsConfig.getStatsConfig().getConfigurationSection("players").getKeys(false)) {

            int num = StatsConfig.getStatsConfig().getInt("players." + s + ".total-time");
            map.put(s, num);
        }
        LinkedHashMap<String, Integer> reverseSortedMap = new LinkedHashMap<>();
        
        //Use Comparator.reverseOrder() for reverse ordering
        map.entrySet()
          .stream()
          .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
          .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));

        return (String) reverseSortedMap.keySet().toArray()[5];
	}
	
	public int listOfStatUsersToInt() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String s : StatsConfig.getStatsConfig().getConfigurationSection("players").getKeys(false)) {

            int num = StatsConfig.getStatsConfig().getInt("players." + s + ".total-time");
            map.put(s, num);
        }
		return map.size();
	}
	
	public void open(Player player) {
		player.openInventory(ptleaders);
	}

}
