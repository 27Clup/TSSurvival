package com.outlook.twentysevenclup.clan;

import com.outlook.twentysevenclup.player.TSPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

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

}
