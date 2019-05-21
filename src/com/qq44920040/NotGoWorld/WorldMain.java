package com.qq44920040.NotGoWorld;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.HashMap;
import java.util.Set;

public class WorldMain extends JavaPlugin {
    public static HashMap<String,WorldInfoEntity> Worlds = new HashMap<>();
    public static String Main;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("NGW")&&args.length==1){
            if (args[0].equalsIgnoreCase("reload")&&sender.isOp()){
                LoadConfig();
                sender.sendMessage("=======NoWorld加载成功=======");
            }
        }
        return super.onCommand(sender, command, label, args);
    }

    @Override
    public void onEnable() {
        if (!getDataFolder().exists()) {
            getDataFolder().mkdir();
        }
        File file = new File(getDataFolder(),"config.yml");
        if (!(file.exists())){
            saveDefaultConfig();
        }
        Bukkit.getPluginManager().registerEvents(new PlayerListener(),this);
        LoadConfig();
        super.onEnable();
    }

    private void LoadConfig(){
        reloadConfig();
        Main = getConfig().getString("MainWorld");
        Set<String> mines = getConfig().getConfigurationSection("Noworld").getKeys(false);
        for (String temp : mines) {
            Worlds.put(temp,new WorldInfoEntity(getConfig().getStringList("Noworld."+temp+".Item"),getConfig().getString("Noworld."+temp+".Msg")));
            //AppraisalInfo.put(temp, getConfig().getString("AppraisalItem."+temp+".Value"));
        }
        System.out.println("=======NoWorld加载成功=======");
        System.out.println("NoWorld 作者:QQ44920040定制");
        System.out.println("=======NoWorld加载成功=======");
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
}
