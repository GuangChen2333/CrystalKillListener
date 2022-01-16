package cn.guangchen233.crystallistener.plugin;

import cn.guangchen233.crystallistener.events.PlayerDeathByPlayerWithCrystalEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;


public class CrystalListener extends JavaPlugin implements Listener {
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
