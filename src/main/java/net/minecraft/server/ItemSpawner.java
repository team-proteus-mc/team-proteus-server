// Decompiled with: CFR 0.152
// Class Version: 8
package net.minecraft.server;

import org.bukkit.block.BlockState;
import org.bukkit.craftbukkit.block.CraftBlockState;
import org.bukkit.craftbukkit.event.CraftEventFactory;
import org.bukkit.event.block.BlockPlaceEvent;

public class ItemSpawner
extends Item {
    private int id;

    public ItemSpawner(int i) {
        super(i);
        this.id = i + 256;
        this.b(Block.byId[i + 256].a(2));
        this.d(0);
        this.a(true);
    }

    @Override
    public boolean a(ItemStack itemstack, EntityHuman entityhuman, World world, int i, int j, int k, int l) {
        int clickedX = i;
        int clickedY = j;
        int clickedZ = k;
        if (world.getTypeId(i, j, k) == Block.SNOW.id) {
            l = 0;
        } else {
            if (l == 0) {
                --j;
            }
            if (l == 1) {
                ++j;
            }
            if (l == 2) {
                --k;
            }
            if (l == 3) {
                ++k;
            }
            if (l == 4) {
                --i;
            }
            if (l == 5) {
                ++i;
            }
        }
        if (itemstack.count == 0) {
            return false;
        }
        if (j == 127 && Block.byId[this.id].material.isBuildable()) {
            return false;
        }
        if (world.a(this.id, i, j, k, false, l)) {
            Block block = Block.byId[this.id];
            CraftBlockState replacedBlockState = CraftBlockState.getBlockState(world, i, j, k);
            if (world.setRawTypeIdAndData(i, j, k, this.id, 0)) {
                BlockPlaceEvent event = CraftEventFactory.callBlockPlaceEvent(world, entityhuman, (BlockState)(replacedBlockState), clickedX, clickedY, clickedZ, block);
                if (event.isCancelled() || !event.canBuild()) {
                    world.setTypeIdAndData(i, j, k, replacedBlockState.getTypeId(), replacedBlockState.getRawData());
                    return true;
                }
                world.update(i, j, k, this.id);
                Block.byId[this.id].postPlace(world, i, j, k, itemstack.getData());
                Block.byId[this.id].postPlace(world, i, j, k, entityhuman);
                world.makeSound((float)i + 0.5f, (float)j + 0.5f, (float)k + 0.5f, block.stepSound.getName(), (block.stepSound.getVolume1() + 1.0f) / 2.0f, block.stepSound.getVolume2() * 0.8f);
                --itemstack.count;
            }
            return true;
        }
        return false;
    }

    @Override
    public String a() {
        return Block.byId[this.id].l();
    }
}
