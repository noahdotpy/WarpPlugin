package me.diligord.warp.menus;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class Menus {
    public static void openMainBrowseMenu(Player player) {
        Inventory inventory = Bukkit.createInventory(player, InventoryType.CHEST);

        ItemStack spawnItem = new ItemStack(Material.DIAMOND);
        ItemMeta spawnItemMeta = spawnItem.getItemMeta();
        spawnItemMeta.displayName(Component.text("Spawn"));
        List<Component> spawnItemLore = List.of(new Component[]{
                Component.text("Wow")
        });
        spawnItemMeta.lore(spawnItemLore);
        spawnItem.setItemMeta(spawnItemMeta);

        ItemStack loungeItem = new ItemStack(Material.GLOWSTONE);
        ItemMeta loungeItemMeta = loungeItem.getItemMeta();
        loungeItemMeta.displayName(Component.text("Spawn"));
        List<Component> loungeItemLore = List.of(new Component[]{
                Component.text("Wow")
        });
        loungeItemMeta.lore(loungeItemLore);
        loungeItem.setItemMeta(loungeItemMeta);

        inventory.addItem(spawnItem, loungeItem);

        player.openInventory(inventory);
    }
}
