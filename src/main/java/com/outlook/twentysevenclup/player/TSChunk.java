package com.outlook.twentysevenclup.player;

import org.bukkit.Chunk;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class TSChunk {

    public static HashMap<Chunk, TSChunk> list = new LinkedHashMap<>();

    private Chunk chunk;

    private Player owner;

    public TSChunk(Chunk chunk, Player owner) {
        this.chunk = chunk;
        this.owner = owner;
        set(chunk, this);
    }

    public Chunk getChunk() { return this.chunk; }

    public Player getOwner() { return this.owner; }

    public TSPlayer getOwnerTS() { return TSPlayer.get(this.owner); }

    public void setOwner(Player player) {
        this.owner = player;
    }

    public static TSChunk get(Chunk chunk) { return list.get(chunk); }

    public static void set(Chunk chunk, TSChunk tsChunk) {
        list.put(chunk, tsChunk);
    }

}
