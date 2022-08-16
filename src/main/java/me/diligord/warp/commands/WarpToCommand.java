package me.diligord.warp.commands;

import me.diligord.warp.Warp;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class WarpToCommand implements CommandExecutor {

    public final Warp plugin;

    public WarpToCommand(Warp plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Must be run as player.");
            return true;
        }

        if (args.length < 1) return false;

        String warpName = args[0];

        if (plugin.getConfig().get("warps." + warpName) == null) {
            sender.sendMessage("${ChatColor.RED}Warp not found.");
            return true;
        }

        Location warpLocation = (Location) plugin.getConfig().get("warps." + warpName + ".location");

        assert warpLocation != null;
        ((Player) sender).teleport(warpLocation);

        return true;
    }
}