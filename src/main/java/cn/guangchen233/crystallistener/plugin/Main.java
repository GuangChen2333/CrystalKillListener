package cn.guangchen233.crystallistener.plugin;

import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new SpigotEventListener(), this);
    }
}
