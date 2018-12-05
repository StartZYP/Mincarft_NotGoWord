package com.qq44920040.NotGoWorld;


import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Map;


public class PlayerListener implements Listener{

    @EventHandler
    public void PlayerGoworld(PlayerChangedWorldEvent playerChangedWorldEvent){
        Player player = (Player)playerChangedWorldEvent.getPlayer();
        String WorldName = player.getLocation().getWorld().getName();

        for (Map.Entry<String,String> TempName: WorldMain.Worldorid.entrySet()){
            if (WorldName.equalsIgnoreCase(TempName.getKey())){
                String[] temparry = TempName.getValue().split("-");
                if (player.getInventory().getMaxStackSize()!=0){
                    for (ItemStack itemStack:player.getInventory().getContents()){
                        //物品空位则为Material.AIR 也可能为null
                        if(itemStack==null || itemStack.getType()== Material.AIR)
                            continue;
//                        System.out.println("迭代背包中.物品ID为："+itemStack.getTypeId());
                        if (String.valueOf(itemStack.getTypeId()).equalsIgnoreCase(temparry[0])){
//                            System.out.println("判定玩家有灵宝武器");
                            player.sendMessage("§4[NoWorld]§2切换世界成功");
                            return;
                        }
                    }
                }
                player.sendMessage(temparry[1]);
                playerChangedWorldEvent.getPlayer().setHealth(0);
//            System.out.println("迭代完成玩家没有灵宝切换至死亡");
            }
        }
    }
}
