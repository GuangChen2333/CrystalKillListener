package cn.guangchen233.crystallistener.events;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathByPlayerWithCrystalEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private final Player killer;
    private final Player deceased;
    private final Entity crystal;
    private final EntityDamageByEntityEvent damageByEntityEvent;
    private final PlayerDeathEvent playerDeathEvent;

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    @Override
    public String getEventName() {
        return "PlayerDeathByPlayerWithCrystalEvent";
    }

    @Override
    public String toString() {
        return "PlayerDeathByPlayerWithCrystalEvent{" +
                "killer=" + killer +
                ", deceased=" + deceased +
                ", crystal=" + crystal +
                '}';
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public PlayerDeathByPlayerWithCrystalEvent(
            Player killer,
            Player deceased,
            Entity crystal,
            EntityDamageByEntityEvent playerDamageEvent,
            PlayerDeathEvent playerDeathEvent
    ) {
        this.killer = killer;
        this.deceased = deceased;
        this.crystal = crystal;
        this.damageByEntityEvent = playerDamageEvent;
        this.playerDeathEvent = playerDeathEvent;
    }

    /**
     * Get the killer
     *
     * @return the player who killed the player with the crystal
     */
    public Player getKiller() {
        return killer;
    }

    /**
     * Get the deceased
     *
     * @return the player killed with crystals by another player
     */
    public Player getDeceased() {
        return deceased;
    }

    /**
     * Get the crystal
     *
     * @return the crystal that kills the player
     */
    public Entity getCrystal() {
        return crystal;
    }

    /**
     * Get the amount of damage caused by the event after all damage reduction is applied.
     *
     * @return the amount of damage caused by the event
     */
    public double getFinalDamage() {
        return damageByEntityEvent.getFinalDamage();
    }

    /**
     * Get the raw amount of damage caused by the event
     *
     * @return the raw amount of damage caused by the event
     */
    public double getDamage() {
        return damageByEntityEvent.getDamage();
    }

    /**
     * This will check if the player's cause of death was suicide
     *
     * @return true if the player died by suicide, false otherwise
     */
    public boolean isSuicide() {
        return killer == deceased;
    }

    /**
     * Get raw event
     *
     * @return Return the PlayerDeathEvent
     */
    public PlayerDeathEvent getRawEvent() {
        return playerDeathEvent;
    }
}
