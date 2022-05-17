package com.outlook.twentysevenclup;

import com.outlook.twentysevenclup.data.TSData;
import com.outlook.twentysevenclup.events.TSCommandListener;
import com.outlook.twentysevenclup.events.TSEventListener;
import com.outlook.twentysevenclup.player.TSPlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class TSS extends JavaPlugin {

    public static TSS instance;

    @Override
    public void onLoad() {
        instance = this;
    }

    public static void overridePlayers() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            overridePlayer(player);
        }
    }

    public static void overridePlayer(Player player) {
        TSPlayer.list.put(player.getUniqueId(), new TSPlayer(player));
    }

    public static void disoverridePlayer(Player player) {
        TSPlayer.list.remove(player.getUniqueId());
    }

    public static String path;

    public static TSData config;

    public static void handleData() {
        config = new TSData(path + "config.yml");
    }

    @Override
    public void onEnable() {
        path = getDataFolder() + File.separator;
        handleData();
        overridePlayers();
        TSCommandListener.handleCommands();
        Bukkit.getPluginManager().registerEvents(new TSEventListener(), this);
    }

    @Override
    public void onDisable() {
        for (TSPlayer tsPlayer : TSPlayer.list.values()) {

        }
    }

}
