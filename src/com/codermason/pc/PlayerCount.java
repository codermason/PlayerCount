package com.codermason.pc;

import com.codermason.pc.config.ConfigOptions;
import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

/**
 * Created by slhscs216 on 1/9/2015.
 */
public class PlayerCount extends JavaPlugin implements PluginMessageListener {

    private ConfigOptions configOptions;

    private PCManager pcManager;

    public void onEnable() {
        saveDefaultConfig();

        this.configOptions = new ConfigOptions(getConfig());
        this.pcManager = new PCManager(this);

        this.getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", this);
        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
    }

    public PCManager getPCManager() {
        return this.pcManager;
    }

    public ConfigOptions getConfigOptions() {
        return this.configOptions;
    }

    public void onPluginMessageReceived(String channel, Player player, byte[] bytes) {
        if (!channel.equals("BungeeCord")) {
            return;
        }
        ByteArrayDataInput in = ByteStreams.newDataInput(bytes);
        String subchannel = in.readUTF();
        if(subchannel.equals("PlayerCount")) {
            getPCManager().setCount(in.readUTF(), in.readInt());
        }
    }
}
