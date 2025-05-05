package net.minecraft.server;

public class ItemAxe extends ItemTool {

	private static Block[] bk = new Block[]{
			Block.WOOD, 
			Block.BOOKSHELF, 
			Block.LOG, 
			Block.CHEST, 
			Block.WORKBENCH, 
			Block.SIGN_POST, 
			Block.WOODEN_DOOR, 
			Block.LADDER, 
			Block.WALL_SIGN, 
			Block.CACTUS, 
			Block.PUMPKIN, 
			Block.TRAP_DOOR, 
			Block.NOTE_BLOCK, 
			Block.WOOD_STAIRS, 
			Block.FENCE
	};

    protected ItemAxe(int i, EnumToolMaterial enumtoolmaterial) {
        super(i, 3, enumtoolmaterial, bk);
    }
}
