package net.minecraft.server;
// CraftBukkit start
import com.legacyminecraft.poseidon.PoseidonConfig;
import org.bukkit.craftbukkit.block.CraftBlockState;
import org.bukkit.craftbukkit.event.CraftEventFactory;
import org.bukkit.event.block.BlockPlaceEvent;
// CraftBukkit end
public class ItemTrapdoor extends ItemBlock {

    public ItemTrapdoor(int i) {
        super(i);
    }

    public boolean a(ItemStack itemstack, EntityHuman entityhuman, World world, int xPos, int yPos, int zPos, int var7) {
        int clickedX = xPos;
        int clickedY = yPos;
        int clickedZ = zPos;
        int var8 = world.getTypeId(xPos, yPos, zPos);
        int facing = (MathHelper.floor((double)(entityhuman.yaw * 4.0F / 360.0F) + 0.5D) & 3);
        switch (facing) {
			case 1:
				facing = 3;
				break;
			case 2:
				facing = 1;
				break;
			case 3:
				facing = 2;
				break;
			default:
				break;
        }
        int data = (var7 >= 2 ? var7 - 2 + (entityhuman.hity > 0.5 ? 8 : 0) : facing + (var7 == 0 ? 8 : 0));
        if (var8 != Block.SNOW.id && var8 != Block.LONG_GRASS.id) {
            if (var7 == 0) {
                --yPos;
            }
            if (var7 == 1) {
                ++yPos;
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

        if (itemstack.count == 0) {
            return false;
        } else if (yPos == 127 && Block.byId[this.id].material.isBuildable()) {
            return false;
        } else if (world.a(this.id, xPos, yPos, zPos, false, var7)) {
            Block block = Block.byId[this.id];

            // CraftBukkit start - This executes the placement of the block
            CraftBlockState replacedBlockState = CraftBlockState.getBlockState(world, xPos, yPos, zPos);

            /**
            * @see net.minecraft.server.World#setTypeIdAndData(int i, int j, int k, int l, int i1)
            *
            * This replaces world.setTypeIdAndData(IIIII), we're doing this because we need to
            * hook between the 'placement' and the informing to 'world' so we can
            * sanely undo this.
            *
            * Whenever the call to 'world.setTypeIdAndData' changes we need to figure out again what to
            * replace this with.
            */
            if (world.setRawTypeIdAndData(xPos, yPos, zPos, this.id, data)) { // <-- world.setTypeIdAndData does this to place the block
                BlockPlaceEvent event = CraftEventFactory.callBlockPlaceEvent(world, entityhuman, replacedBlockState, clickedX, clickedY, clickedZ, block);

                if (event.isCancelled() || !event.canBuild()) {
                    world.setTypeIdAndData(xPos, yPos, zPos, replacedBlockState.getTypeId(), replacedBlockState.getRawData());
                    return true;
                }
                // CraftBukkit end

                if (PoseidonConfig.getInstance().getConfigBoolean("world.settings.pistons.other-fixes.enabled", true) && (this.id == 29 || this.id == 33)) {
                    Block.byId[this.id].postPlace(world, xPos, yPos, zPos, var7);
                    Block.byId[this.id].postPlace(world, xPos, yPos, zPos, entityhuman);
                    world.update(xPos, yPos, zPos, this.id); // <-- world.setTypeIdAndData does this on success (tell the world)
                } else {
                    world.update(xPos, yPos, zPos, this.id);
                    Block.byId[this.id].postPlace(world, xPos, yPos, zPos, var7);
                    Block.byId[this.id].postPlace(world, xPos, yPos, zPos, entityhuman);
                }

                world.makeSound((double) ((float) xPos+ 0.5F), (double) ((float) yPos + 0.5F), (double) ((float) zPos + 0.5F), block.stepSound.getName(), (block.stepSound.getVolume1() + 1.0F) / 2.0F, block.stepSound.getVolume2() * 0.8F);
                --itemstack.count;
            }

            return true;
        } else {
            return false;
        }
    }

    public String a() {
        return Block.byId[this.id].l();
    }
}

