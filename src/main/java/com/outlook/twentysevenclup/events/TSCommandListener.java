package com.outlook.twentysevenclup.events;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TSCommandListener implements CommandExecutor {

    public static void handleCommands() {
        String[] labels = new String[]
        {
            "kabile"
        };
        for (String label : labels) {
            handleCommand(label);
        }
    }

    public static void handleCommand(String label) {
        Bukkit.getPluginCommand(label).setExecutor(new TSCommandListener());
    }

    public static void crewMenuFor(Player player) {

    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("kabile")) {
            if (args.length != 0) {
                if (args[0].equalsIgnoreCase("oluştur")) {

                } else if (args[0].equalsIgnoreCase("dağıt")) {

                } else if (args[0].equalsIgnoreCase("davet")) {

                } else if (args[0].equalsIgnoreCase("at")) {

                } else if (args[0].equalsIgnoreCase("lider")) {

                } else {
                    crewMenuFor((Player)sender);
                }
            } else {
                crewMenuFor((Player)sender);
            }
            return true;
        } else if (label.equalsIgnoreCase("alan")) {

        }
        return false;
    }

}
