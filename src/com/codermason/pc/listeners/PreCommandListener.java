package com.codermason.pc.listeners;

import com.codermason.pc.PlayerCount;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

/**
 * Created by slhscs216 on 1/9/2015.
 */
public class PreCommandListener implements Listener {

    private PlayerCount plugin;

    public PreCommandListener(PlayerCount playerCount) {
        this.plugin = playerCount;
    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e) {
        final Player player = e.getPlayer();
        if (e.getMessage() != null) {
            String message;
            if (e.getMessage().contains(" ")) {
                message = e.getMessage().split(" ")[0];
            } else {
                message = e.getMessage();
            }
            if (plugin.getConfigOptions().getCommands().contains(message)) {
                Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
                    @Override
                    public void run() {
                        player.sendMessage(plugin.getConfigOptions().getMessage().replace("%players%", plugin.getPCManager().getPlayerCount() + ""));
                    }
                }, 5L);
            }
        }
    }

}
