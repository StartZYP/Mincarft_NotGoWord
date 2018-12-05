package com.qq44920040.NotGoWorld;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.Map;

public class WorldMain extends JavaPlugin {
    public static Map <String,String> Worldorid;
    @Override
    public void onEnable() {
        if (!getDataFolder().exists()) {
            getDataFolder().mkdir();
        }
        File file = new File(getDataFolder(),"config.yml");
        if (!(file.exists())){
            saveDefaultConfig();
        }
        for(String TempWorld:getConfig().getStringList("Noworld")){
            String IdorTitle = getConfig().getString("Noworld."+TempWorld);
            Worldorid.put(TempWorld,IdorTitle);
            System.out.println("[NoWorld]§2加载配置项"+TempWorld+IdorTitle);
        }
        Bukkit.getPluginManager().registerEvents(new PlayerListener(),this);
        System.out.println("=======NoWorld加载成功=======");
        System.out.println("NoWorld 作者:QQ44920040 梦幻天国虚无而生忘羡定制");
        System.out.println("=======NoWorld加载成功=======");
        super.onEnable();

    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
}
