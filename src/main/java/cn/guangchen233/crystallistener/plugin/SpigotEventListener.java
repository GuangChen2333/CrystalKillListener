package cn.guangchen233.crystallistener.plugin;

import cn.guangchen233.crystallistener.events.PlayerDeathByPlayerWithCrystalEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

public class SpigotEventListener implements Listener {
    private Entity crystal;
    private Player deceased;
    private Player killer;
    private EntityDamageByEntityEvent playerDamageEvent;

    private void resetTempData() {
        this.crystal = null;
        this.deceased = null;
        this.killer = null;
        this.playerDamageEvent = null;
    }

    // 1st the crystal exploded
    @EventHandler
    public void onCrystalExplode(EntityDamageByEntityEvent event) {
        if (event.getEntityType() != EntityType.ENDER_CRYSTAL) {
            return;
        }

        if (event.getDamager() == null) {
            return;
        }

        if (event.getDamager().getType() != EntityType.PLAYER) {
            return;
        }

        this.resetTempData();
        this.crystal = event.getEntity();
        this.killer = (Player) event.getDamager();
    }

    // 2nd the player takes damage and records
    @EventHandler
    public void onPlayerDamage(EntityDamageByEntityEvent event) {
        if (event.getEntityType() != EntityType.PLAYER) {
            return;
        }

        if (this.crystal == null) {
            this.resetTempData();
            return;
        }

        if (event.getDamager() == null) {
            this.resetTempData();
            return;
        }

        if (event.getDamager() == this.crystal) {
            this.deceased = (Player) event.getEntity();
            this.playerDamageEvent = event;
        } else {
            this.resetTempData();
        }
    }

    // 3rd the recorded player dies
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        if (this.crystal == null || this.killer == null || deceased == null || playerDamageEvent == null) {
            return;
        }

        if (event.getEntity() == this.deceased) {
            PlayerDeathByPlayerWithCrystalEvent calledEvent = new PlayerDeathByPlayerWithCrystalEvent(
                    this.killer, this.deceased, this.crystal, this.playerDamageEvent
            );
            Bukkit.getScheduler().runTask(
                    CrystalListener.getInstance(),
                    () -> Bukkit.getPluginManager().callEvent(calledEvent)
            );
            this.resetTempData();
        }
    }
}
