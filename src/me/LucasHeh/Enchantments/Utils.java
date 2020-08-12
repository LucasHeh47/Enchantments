package me.LucasHeh.Enchantments;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;

import me.LucasHeh.Enchantments.Enchants.Experience;
import me.LucasHeh.Enchantments.Enchants.Tap;
import me.LucasHeh.Enchantments.Enchants.Teleportation;

public class Utils {
	
	public Teleportation teleportation;
	public Experience experience;
	public Tap tap;
	
	private List<Enchantment> customEnchantmentList;
	private Main main = Main.getInstance();

	public Utils() {
		customEnchantmentList = new ArrayList<Enchantment>();
		
		teleportation = new Teleportation();
		
		//Not Finished
		experience = new Experience();
		
		// WIP
		tap = new Tap();
		
	}
	
	// IMPORTANT
	public void registerAllEnchantments() {
		registerEnchantment(teleportation);
		Bukkit.getServer().getPluginManager().registerEvents(teleportation, main);
		
		registerEnchantment(experience);
		Bukkit.getServer().getPluginManager().registerEvents(experience, main);
		
		registerEnchantment(tap);
		Bukkit.getServer().getPluginManager().registerEvents(tap, main);
	}
	
	public void unregisterAllEnchantments() {
		for(Enchantment enchantment : customEnchantmentList) {
			unregisterEnchantment(enchantment);
		}
	}
	
	public void registerEnchantment(Enchantment enchantment) {
        boolean registered = true;
        try {
            Field f = Enchantment.class.getDeclaredField("acceptingNew");
            f.setAccessible(true);
            f.set(null, true);
            Enchantment.registerEnchantment(enchantment);
        } catch (Exception e) {
            registered = false;
            e.printStackTrace();
        }
        if(registered){
            System.out.println(enchantment.getName() + " Has been registered");
            customEnchantmentList.add(enchantment);
        }
    }
	
	public void unregisterEnchantment(Enchantment enchantment) {
		try {
            Field keyField = Enchantment.class.getDeclaredField("byKey");

            keyField.setAccessible(true);
            @SuppressWarnings("unchecked")
            HashMap<NamespacedKey, Enchantment> byKey = (HashMap<NamespacedKey, Enchantment>) keyField.get(null);

            if(byKey.containsKey(enchantment.getKey())) {
            	byKey.remove(enchantment.getKey());
            }

            Field nameField = Enchantment.class.getDeclaredField("byName");

            nameField.setAccessible(true);
            @SuppressWarnings("unchecked")
            HashMap<String, Enchantment> byName = (HashMap<String, Enchantment>) nameField.get(null);
            
            if(byName.containsKey(enchantment.getName())) {
            	byName.remove(enchantment.getName());
            }
        } catch (Exception ignored) { }

	}

	
}
