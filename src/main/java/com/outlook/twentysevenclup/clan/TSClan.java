package com.outlook.twentysevenclup.clan;

import com.outlook.twentysevenclup.gui.TSInventory;
import com.outlook.twentysevenclup.gui.TSInventoryListener;
import com.outlook.twentysevenclup.player.TSPlayer;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class TSClan implements Listener {

    public static HashMap<String, TSClan> list = new LinkedHashMap<>();

    private Player owner;

    private String name;

    private Player[] players;

    public TSClan(Player owner, String name)
    {
        this.owner = owner;
        this.name = name;
        this.players = new Player[10];
    }

    public Player getOwner() { return this.owner; }

    public TSPlayer getOwnerTS() { return TSPlayer.get(this.owner); }

    public String getName() { return this.name; }

    public Player[] getPlayers() { return this.players; }

    public void setOwner(Player player) {
        // TODO: implementation of change in the list by the index and seting the owner if it has the same clan as with the owner
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public void addPlayer(Player player) {
        this.players[this.players.length] = player;
    }

    public boolean isOwner(Player player) { return this.owner.getUniqueId() == player.getUniqueId(); }

    public static void invite(TSPlayer from, TSPlayer to) {
        to.receiveInvite(from);
    }

    public static TSInventory gui(Player player) {
        TSInventory tsInventory = new TSInventory(player, 1, "&7Kabile Arayüzü", new TSInventoryListener() {
            @Override
            public void onClick(InventoryClickEvent e) {
                // TODO: add stuff
                if (e.getSlot() == 0) {

                } else if (e.getSlot() == 1) {

                } else if (e.getSlot() == 2) {

                } else if (e.getSlot() == 3) {

                } else if (e.getSlot() == 4) {

                } else if (e.getSlot() == 5) {

                }
            }
        });
        tsInventory.setSlots(new int[] { 0, 1, 2, 3, 4, 5 }, new ItemStack[] {
            new ItemStack(Material.PAPER),
            new ItemStack(Material.PAPER),
            new ItemStack(Material.PAPER),
            new ItemStack(Material.PAPER),
            new ItemStack(Material.PAPER),
        });
        tsInventory.open();
        return tsInventory;
    }

}
