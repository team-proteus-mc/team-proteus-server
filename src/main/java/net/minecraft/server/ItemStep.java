package net.minecraft.server;

import org.bukkit.block.BlockState;
import org.bukkit.craftbukkit.block.CraftBlockState;
import org.bukkit.craftbukkit.event.CraftEventFactory;
import org.bukkit.event.block.BlockPlaceEvent;

public class ItemStep extends ItemBlock {

    public ItemStep(int i) {
        super(i);
        this.d(0);
        this.a(true);
    }

    public int filterData(int i) {
        return i;
    }
    
    public boolean a(ItemStack var1, EntityHuman var2, World var3, int xPos, int yPos, int zPos, int var7) {
        int clickedX = xPos;
        int clickedY = yPos;
        int clickedZ = zPos;
        int var8 = var3.getTypeId(xPos, yPos, zPos);
        int var9 = var3.getData(xPos, yPos, zPos);
        int yOff = 0;
        int sneakside = var7 > 1 ? (var2.hity > 0.5 ? 8 : 0) : (1 - var7) * 8 & 8;
        if (var8 != Block.SNOW.id && var8 != Block.LONG_GRASS.id) {
            if (var7 == 0) {
                --yOff;
            }
            if (var7 == 1) {
                ++yOff;
            }
            if (var7 == 2) {
                --zPos;
            }
            if (var7 == 3) {
                ++zPos;
            }
            if (var7 == 4) {
                --xPos;
            }
            if (var7 == 5) {
                ++xPos;
            }
        } else {
            var7 = 0;
        }
        int var10 = var3.getTypeId(xPos, yPos + yOff, zPos);
        int var11 = var3.getData(xPos, yPos + yOff, zPos);
        if (var1.count == 0) {
            return false;
        }
        if (yPos + yOff == 127 && Block.byId[this.id].material.isSolid()) {
            return false;
        }
        Block var15 = Block.byId[this.id];
        Block var16 = Block.byId[Block.DOUBLE_STEP.id];
        CraftBlockState replacedBlockState = CraftBlockState.getBlockState(var3, xPos, yPos + yOff, zPos);
        CraftBlockState replacedBlockState2 = CraftBlockState.getBlockState(var3, xPos, yPos, zPos);
        if (var8 == this.id && (var9 & 7) == var1.g() && yOff != 0 && var7 != (var9 & 8) >> 3) {
            if (var3.containsEntity(var16.e(var3, xPos, yPos, zPos)) && var3.setRawTypeIdAndData(xPos, yPos, zPos, Block.DOUBLE_STEP.id, this.filterData(var1.g() & 7))) {
                BlockPlaceEvent event = CraftEventFactory.callBlockPlaceEvent(var3, var2, (BlockState)replacedBlockState2, clickedX, clickedY, clickedZ, var15);
                if (event.isCancelled() || !event.canBuild()) {
                    if (this.id == Block.ICE.id) {
                        var3.setTypeId(xPos, yPos, zPos, 20);
                    }
                    var3.setTypeIdAndData(xPos, yPos, zPos, replacedBlockState2.getTypeId(), replacedBlockState2.getRawData());
                    return true;
                }
                Block.byId[this.id].postPlace(var3, xPos, yPos, zPos, var7);
                Block.byId[this.id].postPlace(var3, xPos, yPos, zPos, var2);
                var3.makeSound((float)xPos + 0.5f, (float)yPos + 0.5f, (float)zPos + 0.5f, var15.stepSound.getName(), (var15.stepSound.getVolume1() + 1.0f) / 2.0f, var15.stepSound.getVolume2() * 0.8f);
                --var1.count;
                return true;
            }
            return false;
        }
        if (var3.a(this.id, xPos, yPos + yOff, zPos, false, var7, sneakside)) {
            if (var3.containsEntity(((BlockStep)var15).e(var3, xPos, yPos + yOff, zPos, sneakside)) && var3.setRawTypeIdAndData(xPos, yPos + yOff, zPos, this.id, this.filterData((var1.g() & 7) + sneakside))) {
                BlockPlaceEvent event = CraftEventFactory.callBlockPlaceEvent(var3, var2, (BlockState)replacedBlockState, clickedX, clickedY, clickedZ, var15);
                if (event.isCancelled() || !event.canBuild()) {
                    if (this.id == Block.ICE.id) {
                        var3.setTypeId(xPos, yPos + yOff, zPos, 20);
                    }
                    var3.setTypeIdAndData(xPos, yPos + yOff, zPos, replacedBlockState.getTypeId(), replacedBlockState.getRawData());
                    return true;
                }
                Block.byId[this.id].postPlace(var3, xPos, yPos + yOff, zPos, var7);
                Block.byId[this.id].postPlace(var3, xPos, yPos + yOff, zPos, var2);
                var3.makeSound((float)xPos + 0.5f, (float)yPos + (float)yOff + 0.5f, (float)zPos + 0.5f, var15.stepSound.getName(), (var15.stepSound.getVolume1() + 1.0f) / 2.0f, var15.stepSound.getVolume2() * 0.8f);
                --var1.count;
                return true;
            }
            return false;
        }
        if (var10 == this.id && (var11 & 7) == (var1.g() & 7)) {
            if (var3.containsEntity(var16.e(var3, xPos, yPos + yOff, zPos)) && var3.setRawTypeIdAndData(xPos, yPos + yOff, zPos, Block.DOUBLE_STEP.id, this.filterData(var1.g() & 7))) {
                BlockPlaceEvent event = CraftEventFactory.callBlockPlaceEvent(var3, var2, (BlockState)replacedBlockState, clickedX, clickedY, clickedZ, var15);
                if (event.isCancelled() || !event.canBuild()) {
                    if (this.id == Block.ICE.id) {
                        var3.setTypeId(xPos, yPos + yOff, zPos, 20);
                    }
                    var3.setTypeIdAndData(xPos, yPos + yOff, zPos, replacedBlockState.getTypeId(), replacedBlockState.getRawData());
                    return true;
                }
                Block.byId[this.id].postPlace(var3, xPos, yPos + yOff, zPos, var7);
                Block.byId[this.id].postPlace(var3, xPos, yPos + yOff, zPos, var2);
                var3.makeSound((float)xPos + 0.5f, (float)yPos + (float)yOff + 0.5f, (float)zPos + 0.5f, var15.stepSound.getName(), (var15.stepSound.getVolume1() + 1.0f) / 2.0f, var15.stepSound.getVolume2() * 0.8f);
                --var1.count;
                return true;
            }
            return false;
        }
        return false;
    }
}
