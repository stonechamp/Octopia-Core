package me.champ.octopia;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Statistic;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import de.candc.SilkSpawners;
import de.candc.api.SilkSpawnersAPI;
import me.champ.octopia.commands.CommandHandler;
import me.champ.octopia.commands.generic.Help;
import me.champ.octopia.commands.generic.OcShop;
import me.champ.octopia.entity.EntityListener;
import me.champ.octopia.entity.spawners.ClickListeners;
import me.champ.octopia.entity.spawners.GUI;
import me.champ.octopia.entity.spawners.OnSpawnerPlaceAndBreak;
import me.champ.octopia.entity.spawners.SpawnerSpawnListener;
import me.champ.octopia.playtime.PlaytimeCommand;
import me.champ.octopia.playtime.PlaytimeConfig;
import me.champ.octopia.playtime.PlaytimeListener;
import me.champ.octopia.playtime.PlaytimeRewards;
import me.champ.octopia.shop.Shop;
import me.champ.octopia.shop.ShopClickListener;
import me.champ.octopia.stats.StatsCommand;
import me.champ.octopia.stats.StatsConfig;
import me.champ.octopia.stats.StatsListener;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

public class Core extends JavaPlugin {
	
	public static Core plugin;
	public Shop shop;
	public CommandHandler commandHandler;
	public SilkSpawnersAPI silkSpawnerApi;
	public GUI upgradeMenu;
	private Economy econ;
    private Permission perms;
    private Chat chat;
    
    
    public File playTimeFile;
    public FileConfiguration playTimeConfiguration;
    
    public Map<UUID, Integer> afkPool = new HashMap<UUID, Integer>();
	
	public void onEnable() {
		plugin = this;
		silkSpawnerApi = SilkSpawners.getApi();
		
		this.registerEvents();
		this.registerCommands();
		upgradeMenu = new GUI();
		
		shop = new Shop();
		commandHandler = new CommandHandler();
		commandHandler.init();
		
		if (!setupEconomy()) {
            this.getLogger().severe("Disabled due to no Vault dependency found!");
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }
		
		this.setupPermissions();
        this.setupChat();
        
        PlaytimeConfig.setup();
        StatsConfig.setup();
        starPlaytimeThread();
	}
	
	

	public void onDisable() {
		
	}
	
	public static Core getInstance() {
		return plugin;
	}
	
	public void registerEvents() {
		this.getServer().getPluginManager().registerEvents(new EntityListener(), this);
		this.getServer().getPluginManager().registerEvents(new ShopClickListener(), this);
		this.getServer().getPluginManager().registerEvents(new ClickListeners(), this);
		this.getServer().getPluginManager().registerEvents(new OnSpawnerPlaceAndBreak(), this);
		this.getServer().getPluginManager().registerEvents(new SpawnerSpawnListener(), this);
		this.getServer().getPluginManager().registerEvents(new CoreListener(), this);
		this.getServer().getPluginManager().registerEvents(new PlaytimeListener(), this);
		this.getServer().getPluginManager().registerEvents(new StatsListener(), this);
	}
	
	public void registerCommands() {
		getCommand("ochelp").setExecutor(new Help());
		getCommand("ptset").setExecutor(new PlaytimeCommand());
		getCommand("ptcheck").setExecutor(new PlaytimeCommand());
		getCommand("ptreset").setExecutor(new PlaytimeCommand());
		getCommand("ocshop").setExecutor(new OcShop());
		getCommand("ocstats").setExecutor(new StatsCommand());
		
	}
	
	public void starPlaytimeThread() {
		new BukkitRunnable() {

			@Override
			public void run() {
				for (Player player : Bukkit.getOnlinePlayers()) {
					Integer counter = afkPool.get(player.getUniqueId());
					if (counter == null) {
						counter = 0;
					}
					counter++;
					afkPool.remove(player.getUniqueId());
					afkPool.put(player.getUniqueId(), counter);
					
					//PlaytimeConfig.getPlaytimeConfig().set("players." + player.getUniqueId() + ".playtime", player.getStatistic(Statistic.PLAY_ONE_TICK));
					
					int ticks = PlaytimeConfig.getPlaytimeConfig().getInt("players." + player.getUniqueId() + ".playtime");
					int hours = (((ticks / 20) / 60) / 60);
					
					if (isAfk(player.getUniqueId())) {
						player.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "" + ChatColor.BOLD +  "Playtime Rewards" + ChatColor.GRAY + "]" + ChatColor.RED + " You are now AFK.");
						
						PlaytimeConfig.getPlaytimeConfig().set("players." + player.getUniqueId() + ".display-name", player.getName());
						PlaytimeConfig.getPlaytimeConfig().set("players." + player.getUniqueId() + ".playtime", player.getStatistic(Statistic.PLAY_ONE_TICK));
						player.setStatistic(Statistic.PLAY_ONE_TICK, 0);
						PlaytimeConfig.save();
						
					} 
					
					if (afkPool.get(player.getUniqueId()) >= 36000 && !(player.isOp())) {
						afkPool.remove(player.getUniqueId());
						player.kickPlayer(player.getName());
					}
					
					PlaytimeConfig.getPlaytimeConfig().set("players." + player.getUniqueId() + ".hours-played", hours);
					
					PlaytimeRewards.check(player);
					
					PlaytimeConfig.save();
				}
				
				
			}
			
		}.runTaskTimer(plugin, 0, 1);
	}
	
	public boolean isAfk(UUID uuid) {
		if (afkPool.get(uuid) == 6000) {
			return true;
		}else {
			return false;
		}
	}
	
	private boolean setupEconomy() {
        if (Bukkit.getPluginManager().getPlugin("Vault") == null) {
            return false;
        }

        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }

    private boolean setupChat() {
        RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
        
        if (rsp == null) {
        	return false;
        }else {
        	chat = rsp.getProvider();
        	return chat != null;
        }
    }

    private boolean setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
        perms = rsp.getProvider();
        return perms != null;
    }

    public Economy getEcononomy() {
        return econ;
    }

    public Permission getPermissions() {
        return perms;
    }

    public Chat getChat() {
        return chat;
    }
	
	public Shop getShop() {
		return shop;
	}
	
	

}
