package io.github.realstealthninja.stealthyplugin;

import java.io.File;
import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class StealthyPlugin extends JavaPlugin {

	private File configfile;
	private FileConfiguration configuration;

	@Override
	public void onEnable() {
		// insert logic here
		getLogger().info("Hello Plugin has been enabled");
		createConfigFile();
	}

	@Override
	public void onDisable() {
		// insert logic

		getLogger().info("Hello Plugin has been disabled");
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// checks

		if (!cmd.getName().equalsIgnoreCase("translate")) {
			return false;
		}
		if (args.length > 4) {
			sender.sendMessage("Too many arguments!");
			return false;
		}
		if (args.length < 4) {
			sender.sendMessage("Not enough arguments!");
			return false;
		}

		String _returncooridnates;

		if (args[0] == "nether") {
			// to the nether coordinates
			_returncooridnates = String.format("%f, %f, %f", Float.valueOf(args[1]).floatValue() * 8,
					Float.valueOf(args[2]).floatValue() * 8, Float.valueOf(args[1]).floatValue() * 8);
		} else if (args[0] == "overworld") {
			// to over world coordinates
			_returncooridnates = String.format("%f, %f, %f", Float.valueOf(args[1]).floatValue() * 8,
					Float.valueOf(args[2]).floatValue() * 8, Float.valueOf(args[1]).floatValue() * 8);
		} else {
			return false;
		}
		sender.sendMessage(_returncooridnates);
		return true;
	}

	public FileConfiguration getCustomConfig() {
		return this.configuration;
	}

	// Configuration file creation
	private void createConfigFile() {
		configfile = new File(getDataFolder(), "config.yml");
		if (!configfile.exists()) {
			configfile.getParentFile().mkdirs();
			saveResource("config.yml", false);
			this.getConfig().set("discord-webhook", "https://replace.me/put-your-webhook-link/over/here");
			this.saveConfig();
		}

		configuration = new YamlConfiguration();

		try {
			configuration.load(configfile);
		} catch (IOException | InvalidConfigurationException e) {
			e.printStackTrace();
		}
	}
}
