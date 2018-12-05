package com.qq44920040.NotGoWorld;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorldMain extends JavaPlugin {
    public static Map <String,String> Worldorid =new HashMap<>();
    @Override
    public void onEnable() {
        if (!getDataFolder().exists()) {
            getDataFolder().mkdir();
        }
        File file = new File(getDataFolder(),"config.yml");
        if (!(file.exists())){
            saveDefaultConfig();
        }
        List<String> list = getConfig().getStringList("Noworld");
        for (String i:list){
            String[] arry = i.split("\\|");
            Worldorid.put(arry[0],arry[1]);
            System.out.println("NoWorld配置项为:"+arry[0]+arry[1]);
        }
        if (Worldorid.size()!=0){
            Bukkit.getPluginManager().registerEvents(new PlayerListener(),this);
            System.out.println("=======NoWorld加载成功=======");
            System.out.println("NoWorld 作者:QQ44920040 梦幻天国虚无而生忘羡定制");
            System.out.println("=======NoWorld加载成功=======");
        }else {
            System.out.println("§4=======NoWorld加载失败=======");
            System.out.println("NoWorld 作者:QQ44920040 梦幻天国虚无而生忘羡定制");
            System.out.println("§4=======NoWorld加载失败=======");
        }
        super.onEnable();

    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
}
