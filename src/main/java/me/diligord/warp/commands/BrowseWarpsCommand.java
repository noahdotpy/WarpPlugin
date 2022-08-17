package me.diligord.warp.commands;

import me.diligord.warp.Warp;
import me.diligord.warp.menus.Menus;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class BrowseWarpsCommand implements CommandExecutor {

    public final Warp plugin;

    public BrowseWarpsCommand(Warp plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) return true;

        Menus.openMainBrowseMenu((Player) sender, plugin.getConfig());
        return true;
    }
}
