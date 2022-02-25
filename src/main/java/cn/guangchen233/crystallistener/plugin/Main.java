package cn.guangchen233.crystallistener.plugin;

import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {
    private static Main instance;

    public static Main getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        getServer().getPluginManager().registerEvents(new SpigotEventListener(), this);
    }
}
