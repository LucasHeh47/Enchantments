package me.LucasHeh.Enchantments.Enchants;

import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import me.LucasHeh.Enchantments.Main;
import me.LucasHeh.Enchantments.Utils;

public class Teleportation extends Enchantment implements Listener{
	
	private Main main = Main.getInstance();
	private Utils utils = main.getUtils();

	public Teleportation() {
		super(new NamespacedKey(Main.getInstance(), "teleportation"));
	}
	
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		if(e.getPlayer() == null) return;
		
		Player p = e.getPlayer();
		ItemStack item = p.getInventory().getItemInMainHand();
		if(item.getEnchantments().containsKey(Enchantment.getByKey(utils.teleportation.getKey()))) {
			p.giveExp(e.getExpToDrop());
			e.setExpToDrop(0);
			for(ItemStack itemToAdd : e.getBlock().getDrops(item))
				p.getInventory().addItem(itemToAdd);
			e.setDropItems(false);
		}
		
	}

	@Override
	public boolean canEnchantItem(ItemStack item) {
		return true;
	}

	@Override
	public boolean conflictsWith(Enchantment arg0) {
		return false;
	}

	@Override
	public EnchantmentTarget getItemTarget() {
		return EnchantmentTarget.TOOL;
	}

	@Override
	public int getMaxLevel() {
		return 1;
	}

	@Override
	public String getName() {
		return "Teleportation";
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
