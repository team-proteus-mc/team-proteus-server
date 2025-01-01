package org.bukkit.craftbukkit.inventory;

import net.minecraft.server.*;
import org.bukkit.craftbukkit.entity.CraftHumanEntity;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryType;
import org.bukkit.inventory.InventoryView;

public class CraftInventoryView extends InventoryView {

    private CraftHumanEntity player;
    private CraftInventory inventory;
    private Container container;

    public CraftInventoryView(HumanEntity player, Inventory inventory, Container container) {
        this.player = (CraftHumanEntity) player;
        this.inventory = (CraftInventory) inventory;
        this.container = container;
    }

    public Inventory getTopInventory() {
        return inventory;
    }

    public Inventory getBottomInventory() {
        return player.getInventory();
    }

    public InventoryType getType() {
        return inventory.getType();
    }

    public HumanEntity getPlayer() {
        return player;
    }
}
