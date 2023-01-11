package cn.guangchen233.crystallistener.events;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class PlayerDeathByPlayerWithCrystalEvent extends Event {
    private static final HandlerList HANDLERS = new HandlerList();
    private final Player KILLER;
    private final Player DECEASED;
    private final Entity CRYSTAL;
    private final EntityDamageByEntityEvent PLAYER_DAMAGE_EVENT;
    private final PlayerDeathEvent PLAYER_DEATH_EVENT;

    // Builder
    public PlayerDeathByPlayerWithCrystalEvent(
            Player killer,
            Player deceased,
            Entity crystal,
            EntityDamageByEntityEvent playerDamageEvent,
            PlayerDeathEvent playerDeathEvent
    ) {
        this.KILLER = killer;
        this.DECEASED = deceased;
        this.CRYSTAL = crystal;
        this.PLAYER_DEATH_EVENT = playerDeathEvent;
        this.PLAYER_DAMAGE_EVENT = playerDamageEvent;
    }

    // Base
    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    @Override
    public String getEventName() {
        return "PlayerDeathByPlayerWithCrystalEvent";
    }

    @Override
    public String toString() {
        return "PlayerDeathByPlayerWithCrystalEvent{" +
                "KILLER=" + KILLER +
                ", DECEASED=" + DECEASED +
                ", CRYSTAL=" + CRYSTAL +
                ", PLAYER_DAMAGE_EVENT=" + PLAYER_DAMAGE_EVENT +
                ", PLAYER_DEATH_EVENT=" + PLAYER_DEATH_EVENT +
                '}';
    }

    // Methods
    /**
     * Set the death message that will appear to everyone on the server.
     *
     * @param deathMessage Message to appear to other players on the server.
     */
    public void setDeathMessage(String deathMessage) {
        this.PLAYER_DEATH_EVENT.setDeathMessage(deathMessage);
    }
}