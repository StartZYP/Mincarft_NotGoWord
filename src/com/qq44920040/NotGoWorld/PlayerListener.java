package com.qq44920040.NotGoWorld;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.List;


public class PlayerListener implements Listener{
    @EventHandler
    public void PlayerClickEvent(InventoryClickEvent event){
        Player p = (Player) event.getWhoClicked();
        String name = p.getWorld().getName();
        //System.out.println(event.getSlot());
        if (WorldMain.Worlds.containsKey(name)){
            ItemStack itemStack = event.getCurrentItem();
            if (itemStack!=null) {
                List<String> worldlist = WorldMain.Worlds.get(name).getWorldlist();
                for (String Item:worldlist){
                    if (Item.contains("*")){
                        String[] split = Item.split(":");
                        if (split[0].equalsIgnoreCase(String.valueOf(itemStack.getTypeId()))){
                            event.setCancelled(true);
                            p.sendMessage(WorldMain.Worlds.get(name).getMsg());
                            p.teleport(Bukkit.getWorld(WorldMain.Main).getSpawnLocation());
                        }
                    }else {
                        String iteminfo = itemStack.getTypeId()+":"+itemStack.getAmount();
                        //System.out.println(iteminfo+"Vs"+Item);
                        if (iteminfo.equalsIgnoreCase(Item)){
                            event.setCancelled(true);
                            p.sendMessage(WorldMain.Worlds.get(name).getMsg());
                            p.teleport(Bukkit.getWorld(WorldMain.Main).getSpawnLocation());
                        }

                    }
                }
            }
        }
    }

    @EventHandler
    public void PlayerChangeWorld(PlayerChangedWorldEvent event) {
        Player p = event.getPlayer();
        String name = p.getWorld().getName();
        //System.out.println(name+"世界");
        if (WorldMain.Worlds.containsKey(name)) {
            Inventory inv = event.getPlayer().getInventory();
            for (int i = 0; i <= 39; i++) {
                List<String> worldlist = WorldMain.Worlds.get(name).getWorldlist();
                //System.out.println(worldlist.toString());
                for (String Item : worldlist) {
                    ItemStack itemStack = inv.getItem(i);
                    if (itemStack != null) {
                        if (Item.contains("*")){
                            String[] split = Item.split(":");
                            if (split[0].equalsIgnoreCase(String.valueOf(itemStack.getTypeId()))){
                                event.getPlayer().sendMessage(WorldMain.Worlds.get(name).getMsg());
                                p.teleport(Bukkit.getWorld(WorldMain.Main).getSpawnLocation());
                            }
                        }else {
                            String iteminfo = itemStack.getTypeId()+":"+itemStack.getAmount();
                            //System.out.println(iteminfo+"Vs"+Item);
                            if (iteminfo.equalsIgnoreCase(Item)){
                                event.getPlayer().sendMessage(WorldMain.Worlds.get(name).getMsg());
                                p.teleport(Bukkit.getWorld(WorldMain.Main).getSpawnLocation());
                            }

                        }
                    }
                }
            }
        }

    }
}
