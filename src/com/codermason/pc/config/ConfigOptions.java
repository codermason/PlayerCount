package com.codermason.pc.config;

import org.bukkit.configuration.file.FileConfiguration;

import java.util.List;

/**
 * Created by slhscs216 on 1/9/2015.
 */
public class ConfigOptions {

    private FileConfiguration configuration;

    private List<String> servers, commands;

    private String message;

    private int updateInterval;

    private boolean onLogin;

    public ConfigOptions(FileConfiguration configuration) {
        this.configuration = configuration;
    }

    public boolean onLogin() {
        if (onLogin == false) {
            onLogin = configuration.getBoolean("on_login");
        }
        return this.onLogin;
    }

    public String getMessage() {
        if (message == null) {
            message = configuration.getString("message");
        }
        return message;
    }

    public List<String> getServers() {
        if (servers == null) {
            servers = configuration.getStringList("servers");
        }
        return servers;
    }

    public List<String> getCommands() {
        if (commands == null) {
            commands = configuration.getStringList("commands");
        }
        return commands;
    }

    public int getUpdateInterval() {
        if (updateInterval == 0) {
            updateInterval = configuration.getInt("update_interval");
        }
        return updateInterval;
    }

}
