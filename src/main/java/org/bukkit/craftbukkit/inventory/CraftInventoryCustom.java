package org.bukkit.craftbukkit.inventory;

import net.minecraft.server.*;
import org.bukkit.Location;
import org.bukkit.craftbukkit.entity.CraftHumanEntity;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.InventoryType;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a custom inventory.
 * <br>
 * It is highly recommended to use this class to show inventories of all types to players.
 */
public class CraftInventoryCustom extends CraftInventory {

    public CraftInventoryCustom(HumanEntity owner, InventoryType type) {
        super(createInventory(owner, type));
    }

    public CraftInventoryCustom(HumanEntity owner, int size) {
        super(new MinecraftInventory(owner, size));
    }

    public CraftInventoryCustom(HumanEntity owner, int size, String title) {
        super(new MinecraftInventory(owner, size, title));
    }

    private static IInventory createInventory(HumanEntity owner, InventoryType type) {
        switch (type) {
            case LARGE_CHEST:
                return new InventoryLargeChest("Large chest", new TileEntityChest(), new TileEntityChest());
            case DISPENSER:
                return new TileEntityDispenser();
            case FURNACE:
                return new TileEntityFurnace();
            case WORKBENCH:
                CraftHumanEntity player = (CraftHumanEntity) owner;
                Location loc = player.getLocation();
                return new InventoryCrafting(new ContainerWorkbench(player.getHandle().inventory, player.getHandle().world, loc.getBlockX(), loc.getBlockY(), loc.getBlockZ()), 3, 3);
            default:
                return new TileEntityChest();
        }
    }

    static class MinecraftInventory implements IInventory {
        private ItemStack[] items;
        private int maxStack;
        private String title;
        private InventoryType type;
        private HumanEntity owner;
        private List<HumanEntity> viewers;

        public MinecraftInventory(HumanEntity owner, InventoryType type) {
            this(owner, type.getDefaultSize(), type.getDefaultTitle());
            this.type = type;
        }

        public MinecraftInventory(HumanEntity owner, int size) {
            this(owner, size, "Chest");
        }

        public MinecraftInventory(HumanEntity owner, int size, String title) {
            this.items = new ItemStack[size];
            this.title = title;
            this.viewers = new ArrayList<HumanEntity>();
            this.owner = owner;
            this.type = InventoryType.CUSTOM;
        }

        public int getSize() {
            return items.length;
        }

        public ItemStack getItem(int i) {
            return items[i];
        }

        public ItemStack splitStack(int i, int j) {
            ItemStack stack = this.getItem(i);
            ItemStack result;
            if (stack == null) return null;
            if (stack.count <= j) {
                this.setItem(i, null);
                result = stack;
            } else {
                result = new ItemStack(stack.id, j, stack.getData());
                stack.count -= j;
            }
            this.update();
            return result;
        }

        public void setItem(int i, ItemStack itemstack) {
            items[i] = itemstack;
        }

        public String getName() {
            return title;
        }

        public InventoryType getType() {
            return type;
        }

        public int getMaxStackSize() {
            return maxStack;
        }

        public void update() {}

        public boolean a_(EntityHuman entityhuman) {
            return true;
        }

        public ItemStack[] getContents() {
            return items;
        }

        public List<HumanEntity> getViewers() {
            return viewers;
        }

        public void onOpen(HumanEntity player) {
            viewers.add(player);
        }

        public void onClose(HumanEntity player) {
            viewers.remove(player);
        }
    }
}
