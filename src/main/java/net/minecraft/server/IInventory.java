package net.minecraft.server;

import org.bukkit.craftbukkit.entity.CraftHumanEntity;
import org.bukkit.entity.HumanEntity;

import java.util.ArrayList;
import java.util.List;

public interface IInventory {

    int getSize();

    ItemStack getItem(int i);

    ItemStack splitStack(int i, int j);

    void setItem(int i, ItemStack itemstack);

    String getName();

    int getMaxStackSize();

    void update();

    boolean a_(EntityHuman entityhuman);

    ItemStack[] getContents(); // CraftBukkit

    // Poseidon start
    default List<HumanEntity> getViewers() {
        return new ArrayList<HumanEntity>();
    }

    default void onOpen(CraftHumanEntity player) {}

    default void onClose(CraftHumanEntity player) {}
    // Poseidon end
}
