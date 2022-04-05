package io.github.realstealthninja.stealthyplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class StealthyPlugin extends JavaPlugin  {
	@Override
	public void onEnable() {
		// insert logic here
		getLogger().info("Hello Plugin has been enabled");
	}
	
	@Override
	public void onDisable() {
		// insert logic

		getLogger().info("Hello Plugin has been disabled");
	}
	
	@Override 
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// checks
		
		if (!cmd.getName().equalsIgnoreCase("translate")) { return false;}
		if (args.length > 4) { sender.sendMessage("Too many arguments!"); return false;}
		if (args.length < 4) { sender.sendMessage("Not enough arguments!"); return false;}
		
		
		String _returncooridnates;
		
		if (args[0] == "nether") {
			// to the nether coordinates
			_returncooridnates = String.format(
					"%f, %f, %f",
					Float.valueOf(args[1]).floatValue()*8,
					Float.valueOf(args[2]).floatValue()*8,
					Float.valueOf(args[1]).floatValue()*8
					);
		}
		else if (args[0] == "overworld") {
			// to over world coordinates
			_returncooridnates = String.format(
					"%f, %f, %f",
					Float.valueOf(args[1]).floatValue()*8,
					Float.valueOf(args[2]).floatValue()*8,
					Float.valueOf(args[1]).floatValue()*8
					);
		}
		else {
			return false;
		}
		sender.sendMessage(_returncooridnates);
		return true;
	}
}
