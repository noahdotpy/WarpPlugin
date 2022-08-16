package me.diligord.warp.commands;

import me.diligord.warp.Warp;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class WarpSetCommand implements CommandExecutor {

    public final Warp plugin;

    public WarpSetCommand(Warp plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Must be run as player.");
            return true;
        }
        if (args.length < 1) return false;

        if (!(sender.hasPermission("warp.setWarp"))) {
            sender.sendMessage(ChatColor.RED + "You do not have permission to execute this command.");
            return true;
        }

        String warpName = args[0];

        plugin.getConfig().set("warps." + warpName + ".location", ((Player) sender).getLocation());

        return true;
    }
}
