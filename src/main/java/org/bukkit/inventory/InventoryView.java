package org.bukkit.inventory;

import org.bukkit.entity.HumanEntity;

/**
 * Represents a view linking two inventories and a single player
 * (whose inventory may or may not be one of the two)
 */
public abstract class InventoryView {

    /**
     * Returns the upper inventory involved in this transaction
     * @return The inventory
     */
    public abstract Inventory getTopInventory();

    /**
     * Returns the lower inventory involved in this transaction
     * @return The inventory
     */
    public abstract Inventory getBottomInventory();

    /**
     * Returns the inventory type of the top inventory
     *
     * @return The inventory type
     */
    public abstract InventoryType getType();

    /**
     * Returns the viewing player
     * @return The player
     */
    public abstract HumanEntity getPlayer();

    /**
     * Sets the item on the cursor of the viewing player.
     * @param item The item to put on the cursor, or null to remove the item on their cursor
     */
    public final void setCursor(ItemStack item) {
        getPlayer().setItemOnCursor(item);
    }
    /**
     * Returns the item on the cursor of the viewing player.
     * @return The item on the player's cursor, or null if they aren't holding one
     */
    public final ItemStack getCursor() {
        return getPlayer().getItemOnCursor();
    }

    /**
     * Closes the inventory view.
     */
    public final void close() {
        getPlayer().closeInventory();
    }
}
