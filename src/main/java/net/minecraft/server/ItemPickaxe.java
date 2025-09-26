package net.minecraft.server;

public class ItemPickaxe extends ItemTool {

    private static Block[] bk = new Block[]
    {
    	Block.COBBLESTONE, 
    	Block.DOUBLE_STEP, 
    	Block.STEP, 
    	Block.STONE, 
    	Block.SANDSTONE, 
    	Block.MOSSY_COBBLESTONE, 
    	Block.IRON_ORE, 
    	Block.IRON_BLOCK, 
    	Block.COAL_ORE, 
    	Block.GOLD_BLOCK, 
    	Block.GOLD_ORE, 
    	Block.DIAMOND_ORE, 
    	Block.DIAMOND_BLOCK, 
    	Block.ICE, 
    	Block.NETHERRACK, 
    	Block.LAPIS_ORE, 
    	Block.LAPIS_BLOCK, 
    	Block.REDSTONE_ORE, 
    	Block.GLOWING_REDSTONE_ORE, 
    	Block.DISPENSER, 
    	Block.RAILS, 
    	Block.GOLDEN_RAIL, 
    	Block.DETECTOR_RAIL, 
    	Block.COBBLESTONE_STAIRS, 
    	Block.FURNACE, 
    	Block.BURNING_FURNACE, 
    	Block.BRICK, 
    	Block.IRON_DOOR_BLOCK, 
    	Block.IRON_TRAP_DOOR, 
    	Block.MOB_SPAWNER, 
    	Block.STONE_BRICKS,
    	Block.BRICK_STAIRS,
    	Block.STONE_BRICK_STAIRS,
    	Block.OLD_COBBLESTONE_STAIRS
    };

    protected ItemPickaxe(int i, EnumToolMaterial enumtoolmaterial) {
        super(i, 2, enumtoolmaterial, bk);
    }

    public boolean a(Block block) {
		if (block.material == Material.STONE || block.material == Material.ORE) {
			return this.a.d() >= block.gphl();
		}
		return false;
    }
}
