package com.outlook.twentysevenclup.events;

import com.outlook.twentysevenclup.TSS;
import com.outlook.twentysevenclup.gui.TSInventory;
import com.outlook.twentysevenclup.gui.TSInventoryListener;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

public class TSEventListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        TSS.overridePlayer(e.getPlayer());
        TSInventory tsInventory = new TSInventory(e.getPlayer(), 9, "", new TSInventoryListener() {
            @Override
            public void onClick(InventoryClickEvent e) {
                Bukkit.broadcastMessage(String.format("Slot %d on Join Menu", e.getSlot()));
            }
        });
        tsInventory.setSlot(0, new ItemStack(Material.WOODEN_AXE));
        tsInventory.open();
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        TSS.disoverridePlayer(e.getPlayer());
    }

}
