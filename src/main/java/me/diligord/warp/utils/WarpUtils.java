package me.diligord.warp.utils;

import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.Map;

public class WarpUtils {

    /**
    * Returns index of warp if found, otherwise -1
    */
    public static int findIndexOfWarp(List<Map<String, Object>> warpsList, String toFind) {
        // Find index of warp
        int i = 0;
        for (Map<String, Object> map : warpsList) {
            if (map.get("name").equals(toFind)) return i;
            i++;
        }
        return -1;
    }


    public static Map<String, Object> makeNewWarpMap(String warpName, Location warpLocation, ItemStack itemStack) {
        return Map.of(
            "name", warpName,
            "location", warpLocation,
            "item", itemStack
        );
    }
}
