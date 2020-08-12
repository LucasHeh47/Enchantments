package me.LucasHeh.Enchantments.Enchants;

import java.util.Random;

import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

import me.LucasHeh.Enchantments.Main;
import me.LucasHeh.Enchantments.Utils;

public class Tap extends Enchantment implements Listener{
	
	private Main main = Main.getInstance();
	private Utils utils = main.getUtils();

	public Tap() {
		super(new NamespacedKey(Main.getInstance(), "tap"));
	}
	
	@EventHandler
	public void onHit(EntityDamageByEntityEvent e) {
		if(!(e.getDamager() instanceof Player)) return;
		if(e.getEntity() instanceof Player) return;
		if(!(e.getEntity() instanceof LivingEntity)) return;
		
		Player p = (Player) e.getDamager();
		ItemStack item = p.getInventory().getItemInMainHand();
		
		if(item == null) return;
		
		if(item.getEnchantments().containsKey(Enchantment.getByKey(utils.tap.getKey()))) {
			Random random = new Random();
			int result = random.nextInt(101);
			LivingEntity mob = (LivingEntity) e.getEntity();
			
			if(result <= 5*item.getEnchantmentLevel(Enchantment.getByKey(utils.tap.getKey()))) {
				mob.damage(mob.getHealth(), p);
			}
		}
		
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
		return 5;
	}

	@Override
	public String getName() {
		return "Tap";
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
