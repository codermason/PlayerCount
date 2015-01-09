package com.codermason.pc.listeners;

import com.codermason.pc.PlayerCount;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Created by slhscs216 on 1/9/2015.
 */
public class LoginListener implements Listener {

    private PlayerCount plugin;

    public LoginListener(PlayerCount plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        if (plugin.getConfigOptions().onLogin()) {
            e.getPlayer().sendMessage(plugin.getConfigOptions().getMessage().replace("%players%", plugin.getPCManager().getPlayerCount() + ""));
        }
    }

}
