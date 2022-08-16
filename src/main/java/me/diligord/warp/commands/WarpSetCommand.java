package me.diligord.warp.commands;

import me.diligord.warp.Warp;
import me.diligord.warp.utils.WarpUtils;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;
import java.util.Map;

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
        Location warpLocation = ((Player) sender).getLocation();
        ItemStack defaultItemStack = new ItemStack(Material.BARRIER);

        List<Map<String, Object>> warps = (List<Map<String, Object>>) plugin.getConfig().getList("warps");

        Map<String, Object> newWarpMap = WarpUtils.makeNewSetWarpMap(
                warpName,
                warpLocation,
                defaultItemStack
        );

        List<Map<String, Object>> newWarps;

        if (warps != null) {
            warps.add(newWarpMap);
            newWarps = warps;
        } else {
            newWarps = Collections.singletonList(newWarpMap);
        }

        plugin.getConfig().set("warps", newWarps);
        plugin.saveConfig();
        sender.sendMessage("Set warp, " + warpName + ".");
        return true;
    }
}
