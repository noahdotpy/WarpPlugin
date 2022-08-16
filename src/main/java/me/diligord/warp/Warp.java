package me.diligord.warp;

import me.diligord.warp.commands.BrowseMenuCommand;
import me.diligord.warp.commands.WarpSetCommand;
import me.diligord.warp.commands.WarpToCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Warp extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        getConfig().options().copyDefaults();
        saveDefaultConfig();
//        Bukkit.getPluginManager().registerEvents(new BrowseMenuListeners(this), this);

        getCommand("warps").setExecutor(new BrowseMenuCommand(this));
        getCommand("warp").setExecutor(new WarpToCommand(this));
        getCommand("setwarp").setExecutor(new WarpSetCommand(this));
    }

}