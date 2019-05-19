package me.champ.octopia.stats;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import me.champ.octopia.Core;

public class StatsConfig {
	
private static Core plugin = Core.getInstance();
	
	public static File statsFile;
	public static FileConfiguration statsConfig;
	
	
	public static void setup() {
		statsFile = new File(plugin.getDataFolder(), "stats.yml");
		
		if (!(statsFile.exists())) {
			try {
				statsFile.createNewFile();
			} catch (IOException e) {
				System.out.println("Can't create Stats Config");
			}
		}
		statsConfig = YamlConfiguration.loadConfiguration(statsFile);
		
	}
	
	public static void save() {
		try {
			statsConfig.save(statsFile);
		} catch (IOException e) {
			System.out.println("Can't save file.");
		}
	}
	
	public static void reload() {
		statsConfig = YamlConfiguration.loadConfiguration(statsFile);
	}
	
	public static FileConfiguration getStatsConfig() {
		return statsConfig;
	}

}
