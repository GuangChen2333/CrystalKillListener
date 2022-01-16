package cn.guangchen233.crystallistener.plugin;

import org.bukkit.plugin.java.JavaPlugin;


public class CrystalListener extends JavaPlugin {
    private static CrystalListener instance;

    public static CrystalListener getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        getServer().getPluginManager().registerEvents(new SpigotEventListener(), this);
    }
}
