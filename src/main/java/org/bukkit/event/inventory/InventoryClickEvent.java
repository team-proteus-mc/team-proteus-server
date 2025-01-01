package org.bukkit.event.inventory;

import org.bukkit.event.Cancellable;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

/**
 * Called when a player clicks on an inventory slot in their inventory
 */
public class InventoryClickEvent extends InventoryEvent implements Cancellable {
    private boolean cancelled = false;
    private boolean rightClick, shiftClick;
    private int rawSlot;
    private ItemStack current = null;

    public InventoryClickEvent(InventoryView transaction) {
        super(Type.INVENTORY_CLICK, transaction);
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancel) {
        cancelled = cancel;
    }
}
