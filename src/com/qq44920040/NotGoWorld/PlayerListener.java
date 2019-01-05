package com.qq44920040.NotGoWorld;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;


public class PlayerListener implements Listener{
    @EventHandler
    public void PlayerClickEvent(InventoryClickEvent event){
        Player p = (Player) event.getWhoClicked();
        if (WorldMain.worldlist.toString().contains(p.getWorld().getName())){
            ItemStack itemStack = event.getCurrentItem();
            if (itemStack!=null) {
                for (String Item:WorldMain.itemlist){
                    if (String.valueOf(itemStack.getTypeId()).equalsIgnoreCase(Item)){
                        event.setCancelled(true);
                        p.sendMessage(WorldMain.Msg);
                        p.teleport(Bukkit.getWorld(WorldMain.Main).getSpawnLocation());
                    }
                }
            }
        }
    }

    @EventHandler
    public void PlayerChangeWorld(PlayerChangedWorldEvent event) {
        Player p = event.getPlayer();
        if (WorldMain.worldlist.toString().contains(p.getWorld().getName())) {
            Inventory inv = event.getPlayer().getInventory();
            for (int i = 0; i <= 35; i++) {
                for (String Item : WorldMain.itemlist) {
                    ItemStack itemStack = inv.getItem(i);
                    if (itemStack != null) {
                        if (String.valueOf(itemStack.getTypeId()).equalsIgnoreCase(Item)) {
                            event.getPlayer().sendMessage(WorldMain.Msg);
                            p.teleport(Bukkit.getWorld(WorldMain.Main).getSpawnLocation());
                        }
                    }
                }
            }
        }

    }
}
