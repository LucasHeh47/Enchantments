package me.LucasHeh.Enchantments;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	private static Main instance;
	private Utils utils;
	
	public void onEnable() {
		utils = new Utils();
		utils.registerAllEnchantments();
	}

	public void onDisable() {
		utils.unregisterAllEnchantments();
	}
	
	public static Main getInstance() {
		return instance;
	}

	public Utils getUtils() {
		return utils;
	}
	
}
