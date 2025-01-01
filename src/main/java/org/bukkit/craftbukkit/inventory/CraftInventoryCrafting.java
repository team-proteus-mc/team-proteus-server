package org.bukkit.craftbukkit.inventory;

import net.minecraft.server.IInventory;
import net.minecraft.server.InventoryCrafting;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public class CraftInventoryCrafting extends CraftInventory implements CraftingInventory {

    private IInventory resultInventory;

    public CraftInventoryCrafting(InventoryCrafting inventory, IInventory resultInventory) {
        super(inventory);
        this.resultInventory = resultInventory;
    }

    public IInventory getResultInventory() {
        return resultInventory;
    }

    public IInventory getMatrixInventory() {
        return inventory;
    }

    @Override
    public int getSize() {
        return inventory.getSize() + resultInventory.getSize();
    }

    @Override
    public void setContents(ItemStack[] items) {
        int resultLen = resultInventory.getContents().length;
        int len = inventory.getContents().length + resultLen;
        if (len > items.length) {
            throw new IllegalArgumentException("Invalid inventory size; expected " + len + " or less");
        }
        setContents(Arrays.copyOfRange(items, 1, items.length), items[0]);
    }

    public void setContents(ItemStack[] matrix, ItemStack result) {
        setMatrix(matrix);
        setResult(result);
    }

    public ItemStack getResult() {
        net.minecraft.server.ItemStack item = resultInventory.getItem(0);
        return item == null ? null : new CraftItemStack(item);
    }

    public ItemStack[] getMatrix() {
        CraftItemStack[] items = new CraftItemStack[getSize()];
        net.minecraft.server.ItemStack[] matrix = inventory.getContents();
        for (int i = 0; i < matrix.length; i++ ) {
            items[i] = new CraftItemStack(matrix[i]);
        }
        return items;
    }

    public void setResult(ItemStack item) {
        net.minecraft.server.ItemStack[] contents = resultInventory.getContents();
        if (item == null || item.getTypeId() <= 0) {
            contents[0] = null;
        } else {
            contents[0] = new net.minecraft.server.ItemStack(item.getTypeId(), item.getAmount(), item.getDurability());
        }
    }

    public void setMatrix(ItemStack[] contents) {
        if (inventory.getContents().length > contents.length) {
            throw new IllegalArgumentException("Invalid inventory size; expected " + inventory.getContents().length + " or less");
        }
        net.minecraft.server.ItemStack[] items = inventory.getContents();
        for (int i = 0; i < items.length; i++) {
            if (i < contents.length) {
                ItemStack item = contents[i];
                if (item == null || item.getTypeId() <= 0) {
                    items[i] = null;
                } else {
                    items[i] = new net.minecraft.server.ItemStack(item.getTypeId(), item.getAmount(), item.getDurability());
                }
            } else {
                items[i] = null;
            }
        }
    }
}
