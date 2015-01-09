package com.codermason.pc;

import com.codermason.pc.util.CountServer;
import com.codermason.pc.util.MessageSender;
import org.bukkit.Bukkit;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by slhscs216 on 1/9/2015.
 */
public class PCManager {

    private PlayerCount plugin;

    private List<CountServer> serverList;

    private int updateInterval;

    public PCManager(PlayerCount plugin) {
        this.plugin = plugin;
        this.updateInterval = plugin.getConfigOptions().getUpdateInterval();
        this.serverList = new ArrayList<CountServer>();
        fillList();
        start();
    }

    public int getPlayerCount() {
        int total = 0;
        for (CountServer server : serverList) {
            total += server.getCount();
        }
        return total;
    }

    public void setCount(String server, int count) {
        CountServer object = getObject(server);
        if (object != null) {
            object.setCount(count);
        }
    }

    private CountServer getObject(String server) {
        for (CountServer s : serverList) {
            if(s.getServer().equals(server)) {
                return s;
            }
        }
        return null;
    }

    private void updatePlayers() {
        for (String server : plugin.getConfigOptions().getServers()) {
            MessageSender.getPlayerCount(plugin, server);
        }
    }

    private void fillList() {
        for (String serverName : plugin.getConfigOptions().getServers()) {
            serverList.add(new CountServer(serverName, 0));
        }
    }

    private void start() {
        Bukkit.getScheduler().runTaskTimer(plugin, new Runnable() {
            @Override
            public void run() {
                updatePlayers();
            }
        }, 0L, updateInterval * 20);
    }

}
