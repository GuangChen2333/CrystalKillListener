package cn.guangchen233.crystallistener.events;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

@SuppressWarnings("unused")
public class PlayerDeathByPlayerWithCrystalEvent extends Event {
    private static final HandlerList HANDLERS = new HandlerList();
    private final Player killer;
    private final Player deceased;
    private final Entity crystal;
    private final EntityDamageByEntityEvent playerDamageEvent;
    private final PlayerDeathEvent playerDeathEvent;

    // Builder
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
        this.playerDeathEvent = playerDeathEvent;
        this.playerDamageEvent = playerDamageEvent;
    }

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
                "KILLER=" + killer +
                ", DECEASED=" + deceased +
                ", CRYSTAL=" + crystal +
                ", PLAYER_DAMAGE_EVENT=" + playerDamageEvent +
                ", PLAYER_DEATH_EVENT=" + playerDeathEvent +
                '}';
    }

    /**
     * Set the death message that will appear to everyone on the server.
     *
     * @param deathMessage Message to appear to other players on the server.
     */
    public void setDeathMessage(String deathMessage) {
        this.playerDeathEvent.setDeathMessage(deathMessage);
    }

    /**
     * Get the death message that will appear to everyone on the server.
     *
     * @return Message to appear to other players on the server.
     */
    public String getDeathMessage() {
        return this.playerDeathEvent.getDeathMessage();
    }

    /**
     * Returns the killer involved in this event
     *
     * @return Killer who is involved in this event
     */
    public Player getKiller() {
        return killer;
    }

    /**
     * Returns the deceased involved in this event
     *
     * @return Deceased who is involved in this event
     */
    public Player getDeceased() {
        return deceased;
    }

    /**
     * Returns the End Crystal involved in this event
     *
     * @return End Crystal which is involved in this event
     */
    public Entity getCrystal() {
        return crystal;
    }

    /**
     * Gets if the Player keeps inventory on death.
     *
     * @return True if the player keeps inventory on death
     */
    public boolean getKeepInventory() {
        return this.playerDeathEvent.getKeepInventory();
    }

    /**
     * Sets if the Player keeps inventory on death.
     *
     * @param keepInventory True to keep the inventory
     */
    public void setKeepInventory(boolean keepInventory) {
        this.playerDeathEvent.setKeepInventory(keepInventory);
    }

    /**
     * Gets if the Player should keep all EXP at respawn.
     * <p>
     * This flag overrides other EXP settings
     *
     * @return True if Player should keep all pre-death exp
     */
    public boolean getKeepLevel() {
        return this.playerDeathEvent.getKeepLevel();
    }

    /**
     * Sets if the Player should keep all EXP at respawn.
     * <p>
     * This overrides all other EXP settings
     * <p>
     * This doesn't prevent the EXP from dropping.
     * {@link #setDroppedExp(int)} should be used stop the
     * EXP from dropping.
     *
     * @param keepLevel True to keep all current value levels
     */
    public void setKeepLevel(boolean keepLevel) {
        this.playerDeathEvent.setKeepLevel(keepLevel);
    }

    /**
     * Gets how much EXP the Player should have at respawn.
     * <p>
     * This does not indicate how much EXP should be dropped, please see
     * {@link #getDroppedExp()} for that.
     *
     * @return New EXP of the respawned player
     */
    public int getNewExp() {
        return this.playerDeathEvent.getNewExp();
    }

    /**
     * Sets how much EXP the Player should have at respawn.
     * <p>
     * This does not indicate how much EXP should be dropped, please see
     * {@link #setDroppedExp(int)} for that.
     *
     * @param exp New EXP of the respawned player
     */
    public void setNewExp(int exp) {
        this.playerDeathEvent.setNewExp(exp);
    }

    /**
     * Gets the Level the Player should have at respawn.
     *
     * @return New Level of the respawned player
     */
    public int getNewLevel() {
        return this.playerDeathEvent.getNewLevel();
    }

    /**
     * Sets the Level the Player should have at respawn.
     *
     * @param level New Level of the respawned player
     */
    public void setNewLevel(int level) {
        this.playerDeathEvent.setNewLevel(level);
    }

    /**
     * Gets the Total EXP the Player should have at respawn.
     *
     * @return New Total EXP of the respawned player
     */
    public int getNewTotalExp() {
        return this.playerDeathEvent.getNewTotalExp();
    }

    /**
     * Sets the Total EXP the Player should have at respawn.
     *
     * @param totalExp New Total EXP of the respawned player
     */
    public void setNewTotalExp(int totalExp) {
        this.playerDeathEvent.setNewTotalExp(totalExp);
    }

    /**
     * Gets how much EXP should be dropped from this death.
     * <p>
     * This does not indicate how much EXP should be taken from the entity in
     * question, merely how much should be created after its death.
     *
     * @return Amount of EXP to drop.
     */
    public int getDroppedExp() {
        return this.playerDeathEvent.getDroppedExp();
    }

    /**
     * Sets how much EXP should be dropped from this death.
     * <p>
     * This does not indicate how much EXP should be taken from the entity in
     * question, merely how much should be created after its death.
     *
     * @param exp Amount of EXP to drop.
     */
    public void setDroppedExp(int exp) {
        this.playerDeathEvent.setDroppedExp(exp);
    }

    /**
     * Gets all the items which will drop when the entity dies
     *
     * @return Items to drop when the entity dies
     */
    public List<ItemStack> getDrops() {
        return this.playerDeathEvent.getDrops();
    }

    /**
     * Gets the raw amount of damage caused by the event
     *
     * @return The raw amount of damage caused by the event
     */
    public double getDamage() {
        return this.playerDamageEvent.getDamage();
    }

    /**
     * Gets the amount of damage caused by the event after all damage
     * reduction is applied.
     *
     * @return the amount of damage caused by the event
     */
    public final double getFinalDamage() {
        return this.playerDamageEvent.getFinalDamage();
    }

    /**
     * Gets if the Player is suicide.
     *
     * @return True if Player is suicide.
     */
    public boolean isSuicide() {
        return this.killer == this.deceased;
    }
}