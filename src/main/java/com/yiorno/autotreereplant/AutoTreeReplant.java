package com.yiorno.autotreereplant;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

public final class AutoTreeReplant extends JavaPlugin {

    private static AutoTreeReplant instance;
    public static World shigenNormal = Bukkit.getWorld("shigen_normal");
    public static World saishu = Bukkit.getWorld("saishu");


    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        getServer().getPluginManager().registerEvents(new Event(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static AutoTreeReplant getInstance(){
        return instance;
    }

}
