package me.diligord.warp.menus;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

import java.util.List;
import java.util.Map;

public class Menus {


    public static void openMainBrowseMenu(Player player, FileConfiguration config) {
        Inventory inventory = Bukkit.createInventory(player, InventoryType.CHEST);
        List<Map<String, Object>> warps = (List<Map<String, Object>>) config.getList("warps");
        if (warps == null) {
            player.sendMessage(ChatColor.RED + "No warps found.");
        }

        player.openInventory(inventory);
    }
}
