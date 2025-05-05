package net.minecraft.server;

import java.util.ArrayList;

import com.legacyminecraft.poseidon.PoseidonConfig;

public class BlockFence extends Block {
    private boolean modernFencingBounding = false;

    public BlockFence(int i, int j) {
        super(i, j, Material.WOOD);
        modernFencingBounding = (boolean) PoseidonConfig.getInstance().getConfigOption("world-settings.use-modern-fence-bounding-boxes", false);
    }

    public boolean canPlace(World world, int i, int j, int k) {
        return world.getTypeId(i, j - 1, k) == this.id ? true : (!world.getMaterial(i, j - 1, k).isBuildable() ? false : super.canPlace(world, i, j, k));
    }

    public void a(World world, int i, int j, int k, AxisAlignedBB axisalignedbb, ArrayList arraylist) {
        AxisAlignedBB axisalignedbb1 = this.e(world, i, j, k);
        boolean flag = this.b(world, i, j, k - 1);
        boolean flag1 = this.b(world, i, j, k + 1);
        boolean flag2 = this.b(world, i - 1, j, k);
        boolean flag3 = this.b(world, i + 1, j, k);
        boolean flag4 = !flag && !flag1 && !flag2 && !flag3;
        float f = 0.375f;
        float f1 = 0.625f;
        float f2 = 0.375f;
        float f3 = 0.625f;
        if (flag) {
            f2 = 0.0f;
        }
        if (flag1) {
            f3 = 1.0f;
        }
        if (flag2) {
            f = 0.0f;
        }
        if (flag3) {
            f1 = 1.0f;
        }
        if (flag || flag1) {
            this.a(0.375f, 0.0f, f2, 0.625f, 1.5f, f3);
            super.a(world, i, j, k, axisalignedbb, arraylist);
        }
        if (flag2 || flag3) {
            this.a(f, 0.0f, 0.375f, f1, 1.5f, 0.625f);
            super.a(world, i, j, k, axisalignedbb, arraylist);
        }
        if (flag4) {
            this.a(0.375f, 0.0f, 0.375f, 0.625f, 1.5f, 0.625f);
            super.a(world, i, j, k, axisalignedbb, arraylist);
        }
    }
    
    public AxisAlignedBB e(World world, int i, int j, int k, int index) {
        boolean flag = this.b(world, i, j, k - 1);
        boolean flag1 = this.b(world, i, j, k + 1);
        boolean flag2 = this.b(world, i - 1, j, k);
        boolean flag3 = this.b(world, i + 1, j, k);
        float f = 0.375f;
        float f1 = 0.625f;
        float f2 = 0.375f;
        float f3 = 0.625f;
        if (flag) {
            f2 = 0.0f;
        }
        if (flag1) {
            f3 = 1.0f;
        }
        if (flag2) {
            f = 0.0f;
        }
        if (flag3) {
            f1 = 1.0f;
        }
        return AxisAlignedBB.b((float)i + f, j, (float)k + f2, (float)i + f1, (float)j + 1.5f, (float)k + f3);
    }

    public boolean b(IBlockAccess iblockaccess, int i, int j, int k) {
        int l = iblockaccess.getTypeId(i, j, k);

        if (l != this.id) {
            Block block = Block.byId[l];

            return block != null && block.material.h() && block.b() ? block.material != Material.PUMPKIN : false;
        } else {
            return true;
        }
    }


    public boolean a() {
        return false;
    }

    public boolean b() {
        return false;
    }
}
