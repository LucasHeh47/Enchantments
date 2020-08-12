package me.LucasHeh.Enchantments.Enchants;

import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import me.LucasHeh.Enchantments.Main;
import me.LucasHeh.Enchantments.Utils;

public class Experience extends Enchantment implements Listener{
	
	private Main main = Main.getInstance();
	private Utils utils = main.getUtils();

	public Experience() {
		super(new NamespacedKey(Main.getInstance(), "experience"));
	}
	
	@EventHandler
	public void onKill(EntityDeathEvent e) {
		
	}

	@Override
	public boolean canEnchantItem(ItemStack arg0) {
		return true;
	}

	@Override
	public boolean conflictsWith(Enchantment arg0) {
		return false;
	}

	@Override
	public EnchantmentTarget getItemTarget() {
		return EnchantmentTarget.WEAPON;
	}

	@Override
	public int getMaxLevel() {
		return 3;
	}

	@Override
	public String getName() {
		return "Experience";
	}

	@Override
	public int getStartLevel() {
		return 1;
	}

	@Override
	public boolean isCursed() {
		return false;
	}

	@Override
	public boolean isTreasure() {
		return false;
	}
	
	
	
}
