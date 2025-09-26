package net.minecraft.server;

import java.util.HashMap;
import java.util.Map;

public class FurnaceRecipes {

    private static final FurnaceRecipes a = new FurnaceRecipes();
    private Map<Integer, ItemStack> b = new HashMap<Integer, ItemStack>();
    private Map<Integer, Integer> c = new HashMap<Integer, Integer>();

    public static final FurnaceRecipes getInstance() {
        return a;
    }

    private FurnaceRecipes() {
        this.registerRecipe(Block.IRON_ORE.id, -1, new ItemStack(Item.IRON_INGOT));
        this.registerRecipe(Block.GOLD_ORE.id, -1, new ItemStack(Item.GOLD_INGOT));
        this.registerRecipe(Block.DIAMOND_ORE.id, -1, new ItemStack(Item.DIAMOND));
        this.registerRecipe(Block.SAND.id, -1, new ItemStack(Block.GLASS));
        this.registerRecipe(Item.PORK.id, -1, new ItemStack(Item.GRILLED_PORK));
        this.registerRecipe(Item.RAW_FISH.id, -1, new ItemStack(Item.COOKED_FISH));
        this.registerRecipe(Block.COBBLESTONE.id, -1, new ItemStack(Block.STONE));
        this.registerRecipe(Item.CLAY_BALL.id, -1, new ItemStack(Item.CLAY_BRICK));
        this.registerRecipe(Block.CACTUS.id, -1, new ItemStack(Item.INK_SACK, 1, 2));
        this.registerRecipe(Block.LOG.id, -1, new ItemStack(Item.COAL, 1, 1));
        this.registerRecipe(Item.BEEF.id, -1, new ItemStack(Item.STEAK));
        this.registerRecipe(Item.CHICKEN.id, -1, new ItemStack(Item.GRILLED_CHICKEN));
        this.registerRecipe(Block.STONE_BRICKS.id, 0, new ItemStack(Block.STONE_BRICKS, 1, 2));
    }

    public void registerRecipe(int i, int meta, ItemStack itemstack) {
        this.b.put(i, itemstack);
        this.c.put(i, meta);
    }

    public ItemStack a(int i, int meta) {
    	int meta2 = this.c.getOrDefault(i, -2);
    	if (meta2 == meta || meta2 == -1) {
    		return this.b.get(Integer.valueOf(i));
    	} else {
    		return null;
    	}
    }

    public Map<Integer, ItemStack> b() {
        return this.b;
    }
}
