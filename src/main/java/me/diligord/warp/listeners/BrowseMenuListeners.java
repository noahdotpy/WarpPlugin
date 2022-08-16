package me.diligord.warp.listeners;

import me.diligord.warp.Warp;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class BrowseMenuListeners implements Listener {

    public final Warp plugin;

    public BrowseMenuListeners(Warp plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public static void onMenuClick(InventoryClickEvent e) {

        /* TODO (in order of priority, first is highest priority):
            - find a better way to check if inventory is my custom menu
            - find a better way to check if it is a custom item (maybe Persistent Data Containers?)
        */
        if (ChatColor.stripColor(String.valueOf(e.getView().title())).equals("Warps")) {
            if (e.getCurrentItem() == null) return;

            switch (e.getCurrentItem().getType()) {
                case GLOWSTONE_DUST -> e.getWhoClicked().sendMessage("Warping to Crates.");
                case DIAMOND -> e.getWhoClicked().sendMessage("Warping to Spawn.");
            }
        } else {
            e.setCancelled(true);
        }
    }

}

//            if (e.currentItem == null) return
//
//            when(e.currentItem!!.type) {
//            Material.GLOWSTONE_DUST -> e.whoClicked.sendMessage("Warping to Crates.")
//            Material.DIAMOND -> e.whoClicked.sendMessage("Warping to Spawn.")
//            else -> {}
//            }
//
//            e.isCancelled = true
//
//            }
//
//            }
//            }