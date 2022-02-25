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
    private final Player killer;
    private final Player deceased;
    private final Entity crystal;
    private final EntityDamageByEntityEvent damageByEntityEvent;
    private final PlayerDeathEvent playerDeathEvent;

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
                "killer=" + killer +
                ", deceased=" + deceased +
                ", crystal=" + crystal +
                '}';
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
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
     * Get the death message that will appear to everyone on the server.
     *
     * @return message to appear to other players on the server.
     */
    public String getDeathMessage() {
        return playerDeathEvent.getDeathMessage();
    }

    /**
     * Get if the Player keeps inventory on death.
     *
     * @return true if the player keeps inventory on death
     */
    public boolean getKeepInventory() {
        return playerDeathEvent.getKeepInventory();
    }

    /**
     * Get if the Player should keep all EXP at respawn.
     * This flag overrides other EXP settings
     *
     * @return true if Player should keep all pre-death exp
     */
    public boolean getKeepLevel() {
        return playerDeathEvent.getKeepLevel();
    }

    /**
     * Get how much EXP should be dropped from this death.
     * This does not indicate how much EXP should be taken from the entity in question,
     * merely how much should be created after its death.
     *
     * @return amount of EXP to drop.
     */
    public int getDroppedExp() {
        return playerDeathEvent.getDroppedExp();
    }

    /**
     * Get all the items which will drop when the entity dies
     *
     * @return items to drop when the entity dies
     */
    public List<ItemStack> getDrops() {
        return playerDeathEvent.getDrops();
    }

    /**
     * Get how much EXP the Player should have at respawn.
     * This does not indicate how much EXP should be dropped, please see getDroppedExp() for that.
     *
     * @return new EXP of the respawned player
     */
    public int getNewExp() {
        return playerDeathEvent.getNewExp();
    }

    /**
     * Get the Total EXP the Player should have at respawn.
     *
     * @return new Total EXP of the respawned player
     */
    public int getNewTotalExp() {
        return playerDeathEvent.getNewTotalExp();
    }

    /**
     * Get the Level the Player should have at respawn.
     *
     * @return new Level of the respawned player
     */
    public int getNewLevel() {
        return playerDeathEvent.getNewLevel();
    }
}
