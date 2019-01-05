package com.qq44920040.NotGoWorld;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.List;

public class WorldMain extends JavaPlugin {
    public static List<String> worldlist;
    public static List<String> itemlist;
    public static String Msg;
    public static String Main;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("NGW")&&args.length==1){
            if (args[0].equalsIgnoreCase("reload")&&sender.isOp()){
                this.saveDefaultConfig();
                this.reloadConfig();
                itemlist = getConfig().getStringList("Item");
                worldlist = getConfig().getStringList("Noworld");
                Msg = getConfig().getString("Msg");
                Main = getConfig().getString("MainWorld");
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
        itemlist = getConfig().getStringList("Item");
        worldlist = getConfig().getStringList("Noworld");
        Msg = getConfig().getString("Msg");
        Main = getConfig().getString("MainWorld");
        if (itemlist.size()!=0&&worldlist.size()!=0&&!Main.equalsIgnoreCase("")){
            Bukkit.getPluginManager().registerEvents(new PlayerListener(),this);
            System.out.println("=======NoWorld加载成功=======");
            System.out.println("NoWorld 作者:QQ44920040定制");
            System.out.println("=======NoWorld加载成功=======");
        }else {
            System.out.println("§4=======NoWorld加载失败=======");
            System.out.println("NoWorld 作者:QQ44920040 定制");
            System.out.println("§4=======NoWorld加载失败=======");
        }
        super.onEnable();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
}
