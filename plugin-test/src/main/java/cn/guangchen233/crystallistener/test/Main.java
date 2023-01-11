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
        getLogger().info("Original Damage: " + event.getDamage());
        getLogger().info("Final Damage: " + event.getFinalDamage());
        getLogger().info("Killer: " + event.getKiller());
        getLogger().info("Deceased: " + event.getDeceased());
        getLogger().info("Crystal: " + event.getCrystal());
        getLogger().info("Keep Inventory: " + event.getKeepInventory());
        getLogger().info("Keep Level: " + event.getKeepLevel());
        getLogger().info("New Exp: " + event.getNewExp());
        getLogger().info("New Level: " + event.getNewLevel());
        getLogger().info("New Total Exp: " + event.getNewTotalExp());
        getLogger().info("Dropped Exp:" + event.getDroppedExp());
        getLogger().info("Drops: " + event.getDrops());
        getLogger().info("Suicide: " + event.isSuicide());
        getLogger().info("Old death message: " + event.getDeathMessage());
        event.setDeathMessage("Success to set death message");
        getLogger().info("New death message: " + event.getDeathMessage());
    }
}