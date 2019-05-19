package me.champ.octopia.guis;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;



public class HelpGui {
	
	public Inventory helpInv;
	public ItemStack skyBlockCommands;
	public ItemStack generalCommands;
	public ItemStack serverStore;
	public ItemStack howToPlay;
	
	public ItemStack closeBtn;
	
	
	public HelpGui() {
		helpInv = Bukkit.createInventory(null, 45, "Help Menu");
		skyBlockCommands = new ItemStack(Material.STAINED_GLASS, 1, (byte) 9);
		generalCommands = new ItemStack(Material.STAINED_GLASS, 1, (byte) 14);
		serverStore = new ItemStack(Material.STAINED_GLASS, 1, (byte) 4);
		howToPlay = new ItemStack(Material.STAINED_GLASS, 1, (byte) 13);
		closeBtn = new ItemStack(Material.BARRIER, 1);
		setup();
	}

	private void setup() {
		
		helpInv.setItem(0, new ItemStack(Material.STAINED_GLASS_PANE,1, (byte) 4));
		helpInv.setItem(1, new ItemStack(Material.STAINED_GLASS_PANE,1, (byte) 3));
		helpInv.setItem(3, new ItemStack(Material.STAINED_GLASS_PANE,1, (byte) 3));
		helpInv.setItem(4, new ItemStack(Material.STAINED_GLASS_PANE,1, (byte) 4));
		helpInv.setItem(5, new ItemStack(Material.STAINED_GLASS_PANE,1, (byte) 3));
		helpInv.setItem(7, new ItemStack(Material.STAINED_GLASS_PANE,1, (byte) 3));
		helpInv.setItem(8, new ItemStack(Material.STAINED_GLASS_PANE,1, (byte) 4));
		helpInv.setItem(9, new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 3));
		helpInv.setItem(27, new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 3));
		helpInv.setItem(36, new ItemStack(Material.STAINED_GLASS_PANE,1, (byte) 4));
		helpInv.setItem(17, new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 3));
		helpInv.setItem(35, new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 3));
		helpInv.setItem(37, new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 3));
		helpInv.setItem(39, new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 3));
		helpInv.setItem(40, new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 4));
		helpInv.setItem(41, new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 3));
		helpInv.setItem(43, new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 3));
		helpInv.setItem(44, new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 4));
		
		
		helpInv.setItem(20, getSkyblockCommands());
		helpInv.setItem(12, getGeneralCommands());
		helpInv.setItem(24, getServerStore());
		helpInv.setItem(14, getPvp());
		helpInv.setItem(31, getCloseBtn());
		
	}
	
	private ItemStack getSkyblockCommands() {
		ItemMeta meta = skyBlockCommands.getItemMeta();
		meta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Island Commands");
		skyBlockCommands.setItemMeta(meta);
		return skyBlockCommands;
	}
	
	private ItemStack getGeneralCommands() {
		ItemMeta meta = generalCommands.getItemMeta();
		meta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "General Commands");
		generalCommands.setItemMeta(meta);
		return generalCommands;
	}
	
	private ItemStack getServerStore() {
		ItemMeta meta = serverStore.getItemMeta();
		meta.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "Tokens");
		serverStore.setItemMeta(meta);
		return serverStore;
	}
	
	private ItemStack getPvp() {
		ItemMeta meta = howToPlay.getItemMeta();
		meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Pvp");
		howToPlay.setItemMeta(meta);
		return howToPlay;
	}
	
	private ItemStack getCloseBtn() {
		ItemMeta meta = closeBtn.getItemMeta();
		meta.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + "Close Menu");
		closeBtn.setItemMeta(meta);
		return closeBtn;
	}
	

}
