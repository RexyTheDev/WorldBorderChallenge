package com.rexythedev.worldborder;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static String chat(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public static ItemStack createItem(Inventory inv, String materialString, int ammount, int invSlot, String displayName, String... loreString) {
        List<String> lore = new ArrayList<String>();
        ItemStack item = new ItemStack(Material.matchMaterial(materialString), ammount);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(chat(displayName));
        for (String s : loreString) {
            lore.add(chat(s));
        }
        meta.setLore((List)lore);
        item.setItemMeta(meta);
        inv.setItem(invSlot - 1, item);
        return item;
    }

    public static ItemStack createItemByte(Inventory inv, String materialString, int byteId, int ammount, int invSlot, String displayName, String... loreString) {
        List<String> lore = new ArrayList<String>();
        ItemStack item = new ItemStack(Material.matchMaterial(materialString), ammount, (short)byteId);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(chat(displayName));
        for (String s : loreString) {
            lore.add(chat(s));
        }
        meta.setLore((List)lore);
        item.setItemMeta(meta);
        inv.setItem(invSlot - 1, item);
        return item;
    }
}