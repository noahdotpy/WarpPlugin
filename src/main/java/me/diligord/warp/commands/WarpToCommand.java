package me.diligord.warp.commands;

import me.diligord.warp.Warp;
import me.diligord.warp.utils.WarpUtils;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;
import java.util.Objects;

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
        List warps = plugin.getConfig().getList("warps");
        int warpIndex = WarpUtils.findIndexOfWarp(warps, warpName);

        if (warps == null || warpIndex == -1) {
            sender.sendMessage(ChatColor.RED + "Warp not found.");
            return true;
        }

        Map warp = (Map) Objects.requireNonNull(plugin.getConfig().getList("warps")).get(warpIndex);

        // Teleport the player
        sender.sendMessage("Warping to " + warp.get("name").toString() + ".");
        ((Player) sender).teleport((Location) warp.get("location"));

        return true;
    }
}