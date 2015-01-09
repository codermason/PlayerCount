package com.codermason.pc.util;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

/**
 * Created by slhscs216 on 1/9/2015.
 */
public class MessageSender {

    public static void getPlayerCount(Plugin plugin, String server) {
        Player player = plugin.getServer().getOnlinePlayers();
    }

}
