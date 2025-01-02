package org.bukkit.craftbukkit.inventory;

import net.minecraft.server.Container;
import org.bukkit.craftbukkit.entity.CraftHumanEntity;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryType;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

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

    @Override
    public void setItem(int slot, org.bukkit.inventory.ItemStack item) {
        if (slot != -999) {
            container.b(slot).c(item == null ? null : new net.minecraft.server.ItemStack(item.getTypeId(), item.getAmount(), item.getDurability()));
        }
    }

    @Override
    public ItemStack getItem(int slot) {
        if (slot == -999) {
            return null;
        }
        return new CraftItemStack(container.b(slot).getItem());
    }

    public boolean isInTop(int rawSlot) {
        return rawSlot < inventory.getSize();
    }

    public Container getHandle() {
        return container;
    }
}
