package me.champ.octopia.playtime;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import me.champ.octopia.Core;

public class PlaytimeConfig {
	
	private static Core plugin = Core.getInstance();
	
	public static File playTimeFile;
	public static FileConfiguration playTimeConfig;
	
	
	public static void setup() {
		playTimeFile = new File(plugin.getDataFolder(), "playtime.yml");
		
		if (!(playTimeFile.exists())) {
			try {
				playTimeFile.createNewFile();
			} catch (IOException e) {
				System.out.println("Can't create Playtime Config");
			}
		}
		playTimeConfig = YamlConfiguration.loadConfiguration(playTimeFile);
		PlaytimeConfig.getPlaytimeConfig().createSection("players");
	}
	
	public static void save() {
		try {
			playTimeConfig.save(playTimeFile);
		} catch (IOException e) {
			System.out.println("Can't save file.");
		}
	}
	
	public static void reload() {
		playTimeConfig = YamlConfiguration.loadConfiguration(playTimeFile);
	}
	
	public static FileConfiguration getPlaytimeConfig() {
		return playTimeConfig;
	}

}
