package com.outlook.twentysevenclup.gui;

import com.outlook.twentysevenclup.TSS;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public class TSInventory implements Listener {

    private Inventory inventory;

    private TSInventoryListener tsInventoryListener;

    private void createInventory(InventoryHolder owner, int rows, String label) {
        inventory = Bukkit.createInventory(owner, rows * 9, label);
        Bukkit.getPluginManager().registerEvents(this, TSS.instance);
    }

    public TSInventory(InventoryHolder owner, int rows, String label) {
        createInventory(owner, rows, label);
    }

    public TSInventory(InventoryHolder owner, int rows, String label, TSInventoryListener tsInventoryListener) {
        createInventory(owner, rows, label);
        this.setInventoryListener(tsInventoryListener);
    }

    public Inventory getInventory() { return this.inventory; }

    public TSInventoryListener getInventoryListener() { return this.tsInventoryListener; }

    public void setInventoryListener(TSInventoryListener tsInventoryListener) {
        this.tsInventoryListener = tsInventoryListener;
    }

    public void setSlot(int slot, ItemStack itemStack) {
        this.inventory.setItem(slot, itemStack);
    }

    public void open() {
        ((Player)this.inventory.getHolder()).openInventory(this.inventory);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onInventoryClick(InventoryClickEvent e) {
        if (e.getClickedInventory() == this.inventory) {
            this.tsInventoryListener.onClick(e);
        }
    }

}
