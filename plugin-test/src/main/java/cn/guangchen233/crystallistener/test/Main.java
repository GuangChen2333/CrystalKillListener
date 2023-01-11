package cn.guangchen233.crystallistener.test;

import cn.guangchen233.crystallistener.events.PlayerDeathByPlayerWithCrystalEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerDeathWithCrystal(PlayerDeathByPlayerWithCrystalEvent event) {
        getLogger().info("Successful listen the event");
        event.setDeathMessage("Success to set death message");
    }
}