package com.outlook.twentysevenclup.player;

import com.outlook.twentysevenclup.TSS;
import com.outlook.twentysevenclup.clan.TSClan;
import com.outlook.twentysevenclup.data.TSData;
import com.outlook.twentysevenclup.gui.TSInventory;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.UUID;
public class TSPlayer {

    public static HashMap<UUID, TSPlayer> list = new LinkedHashMap<>();

    private Player player;

    private List<String> clanInvites;

    private TSClan tsClan;

    private TSData tsData;

    public TSPlayer(Player player) {
        this.player = player;
        this.clanInvites = new ArrayList<>();
        String pDataPath = TSS.path + player.getUniqueId() + ".yml";
        tsData = new TSData(pDataPath);
    }

    public Player getPlayer() { return this.player; }

    public TSClan getClan() { return this.tsClan; }

    public void receiveInvite(TSPlayer from) {
        if (this.tsClan == null || from.tsClan.getName() != this.tsClan.getName()) {
            this.clanInvites.add(from.tsClan.getName());
        }
    }

    public TSData getData() { return this.tsData; }

    public Object get(String path) { return this.tsData.get(path); }

    public void saveData() {
        if (this.tsData.getYamlConfiguration().saveToString() == "") {
            this.tsData.save();
        }
    }

    public void set(String path, Object value) {
        this.tsData.set(path, value);
    }

    public static TSPlayer get(Player player) { return list.get(player.getUniqueId()); }

}
