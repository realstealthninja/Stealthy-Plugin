package io.github.realstealthninja.stealthyplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class TranslatorExecutor implements CommandExecutor {
	@SuppressWarnings("unused")
	private final StealthyPlugin plugin;

	public TranslatorExecutor(StealthyPlugin plugin) {
		this.plugin = plugin;
	}


	@Override
	public boolean onCommand(
			CommandSender sender,
			Command cmd,
			String label,
			String[] args
	) {
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
		
		if (!(args[0].equalsIgnoreCase("nether") || args[0].equalsIgnoreCase("nether"))) {
			sender.sendMessage(args[0]);
			return false;
		}

		String _returncooridnates = (args[0].equalsIgnoreCase("overworld")) ?  String.format("%f, %f, %f",
				Float.valueOf(args[1]).floatValue() / 8,
				Float.valueOf(args[2]).floatValue() / 8,
				Float.valueOf(args[3]).floatValue() / 8) : String.format("%f,%f,%f",
						Float.valueOf(args[1]).floatValue() * 8,
						Float.valueOf(args[2]).floatValue() * 8,
						Float.valueOf(args[3]).floatValue() * 8);

		sender.sendMessage(_returncooridnates);
		return true;
	}
}
