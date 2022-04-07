package io.github.realstealthninja.stealthyplugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class StealthyPlugin extends JavaPlugin {
	@Override
	public void onEnable() {
		// insert logic here
		getLogger().info("Hello Plugin has been enabled");
		this.getCommand("translate").setExecutor(new TranslatorExecutor(this));
	}

	@Override
	public void onDisable() {
		// insert logic

		getLogger().info("Hello Plugin has been disabled");
	}
}
