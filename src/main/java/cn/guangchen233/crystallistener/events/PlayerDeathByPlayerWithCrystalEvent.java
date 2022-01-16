package cn.guangchen233.crystallistener.events;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class PlayerDeathByPlayerWithCrystalEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private final Player killer;
    private final Player deceased;
    private final Entity crystal;
    private final EntityDamageByEntityEvent damageByEntityEvent;

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public PlayerDeathByPlayerWithCrystalEvent(
            Player killer,
            Player deceased,
            Entity crystal,
            EntityDamageByEntityEvent playerDamageEvent
    ) {
        this.killer = killer;
        this.deceased = deceased;
        this.crystal = crystal;
        this.damageByEntityEvent = playerDamageEvent;
    }

    /**
     * Gets the killer
     *
     * @return the player who killed the player with the crystal
     */
    public Player getKiller() {
        return killer;
    }

    /**
     * Gets the deceased
     *
     * @return the player killed with crystals by another player
     */
    public Player getDeceased() {
        return deceased;
    }

    /**
     * Gets the crystal
     *
     * @return the crystal that kills the player
     */
    public Entity getCrystal() {
        return crystal;
    }

    /**
     * Gets the amount of damage caused by the event after all damage reduction is applied.
     *
     * @return the amount of damage caused by the event
     */
    public double getFinalDamage() {
        return damageByEntityEvent.getFinalDamage();
    }

    /**
     * Gets the raw amount of damage caused by the event
     *
     * @return the raw amount of damage caused by the event
     */
    public double getDamage() {
        return damageByEntityEvent.getDamage();
    }
}
