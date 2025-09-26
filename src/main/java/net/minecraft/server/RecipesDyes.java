package net.minecraft.server;

public class RecipesDyes {

    public RecipesDyes() {}

    public void a(CraftingManager craftingmanager) {
        for (int i = 0; i < 16; ++i) {
            craftingmanager.registerShapelessRecipe(new ItemStack(Block.WOOL, 1, BlockCloth.d(i)), new Object[] { new ItemStack(Item.INK_SACK, 1, i), new ItemStack(Block.WOOL, 1, -1)});
            craftingmanager.registerShapedRecipe(new ItemStack(Block.WOOL, 8, BlockCloth.d(i)), "###", "#X#", "###", Character.valueOf('#'), Block.WOOL, Character.valueOf('X'), new ItemStack(Item.INK_SACK, 1, i));
        }
        craftingmanager.registerShapelessRecipe(new ItemStack(Block.CLASSIC_WOOL, 1, 0), new Object[]{new ItemStack(Item.INK_SACK, 1, 15), new ItemStack(Block.CLASSIC_WOOL, 1, -1)});
        craftingmanager.registerShapedRecipe(new ItemStack(Block.CLASSIC_WOOL, 8, 0), "###", "#X#", "###", Character.valueOf('#'), Block.CLASSIC_WOOL, Character.valueOf('X'), new ItemStack(Item.INK_SACK, 1, 15));
		
        this.add2WayWoolRecipe(craftingmanager, 0, 0);
		this.add2WayWoolRecipe(craftingmanager, 1, 2);
		this.add2WayWoolRecipe(craftingmanager, 2, 12);
		this.add2WayWoolRecipe(craftingmanager, 3, 8);
		this.add2WayWoolRecipe(craftingmanager, 4, 3);
		this.add2WayWoolRecipe(craftingmanager, 5, 5);
		this.add2WayWoolRecipe(craftingmanager, 6, 13);
		this.add2WayWoolRecipe(craftingmanager, 7, 14);
		this.add2WayWoolRecipe(craftingmanager, 8, 15);
		this.add2WayWoolRecipe(craftingmanager, 9, 7);
		this.add2WayWoolRecipe(craftingmanager, 10, 10);
		this.add2WayWoolRecipe(craftingmanager, 11, 9);
		this.add2WayWoolRecipe(craftingmanager, 14, 1);
		
		craftingmanager.registerShapelessRecipe(new ItemStack(Block.CLASSIC_WOOL, 2, 4), new Object[]{new ItemStack(Block.CLASSIC_WOOL, 1, 3), new ItemStack(Block.CLASSIC_WOOL, 1, 5)});
		craftingmanager.registerShapelessRecipe(new ItemStack(Block.CLASSIC_WOOL, 2, 6), new Object[]{new ItemStack(Block.CLASSIC_WOOL, 1, 5), new ItemStack(Block.CLASSIC_WOOL, 1, 7)});
		craftingmanager.registerShapelessRecipe(new ItemStack(Block.CLASSIC_WOOL, 2, 11), new Object[]{new ItemStack(Block.CLASSIC_WOOL, 1, 10), new ItemStack(Block.CLASSIC_WOOL, 1, 12)});

        craftingmanager.registerShapelessRecipe(new ItemStack(Item.INK_SACK, 2, 11), new Object[] {Block.YELLOW_FLOWER});
        craftingmanager.registerShapelessRecipe(new ItemStack(Item.INK_SACK, 2, 1), new Object[] {Block.RED_ROSE});
        craftingmanager.registerShapelessRecipe(new ItemStack(Item.INK_SACK, 3, 15), new Object[] {Item.BONE});
        craftingmanager.registerShapelessRecipe(new ItemStack(Item.INK_SACK, 2, 9), new Object[] {new ItemStack(Item.INK_SACK, 1, 1), new ItemStack(Item.INK_SACK, 1, 15)});
        craftingmanager.registerShapelessRecipe(new ItemStack(Item.INK_SACK, 2, 14), new Object[] {new ItemStack(Item.INK_SACK, 1, 1), new ItemStack(Item.INK_SACK, 1, 11)});
        craftingmanager.registerShapelessRecipe(new ItemStack(Item.INK_SACK, 2, 10), new Object[] {new ItemStack(Item.INK_SACK, 1, 2), new ItemStack(Item.INK_SACK, 1, 15)});
        craftingmanager.registerShapelessRecipe(new ItemStack(Item.INK_SACK, 2, 8), new Object[] {new ItemStack(Item.INK_SACK, 1, 0), new ItemStack(Item.INK_SACK, 1, 15)});
        craftingmanager.registerShapelessRecipe(new ItemStack(Item.INK_SACK, 2, 7), new Object[] {new ItemStack(Item.INK_SACK, 1, 8), new ItemStack(Item.INK_SACK, 1, 15)});
        craftingmanager.registerShapelessRecipe(new ItemStack(Item.INK_SACK, 3, 7), new Object[] {new ItemStack(Item.INK_SACK, 1, 0), new ItemStack(Item.INK_SACK, 1, 15), new ItemStack(Item.INK_SACK, 1, 15)});
        craftingmanager.registerShapelessRecipe(new ItemStack(Item.INK_SACK, 2, 12), new Object[] {new ItemStack(Item.INK_SACK, 1, 4), new ItemStack(Item.INK_SACK, 1, 15)});
        craftingmanager.registerShapelessRecipe(new ItemStack(Item.INK_SACK, 2, 6), new Object[] {new ItemStack(Item.INK_SACK, 1, 4), new ItemStack(Item.INK_SACK, 1, 2)});
        craftingmanager.registerShapelessRecipe(new ItemStack(Item.INK_SACK, 2, 5), new Object[] {new ItemStack(Item.INK_SACK, 1, 4), new ItemStack(Item.INK_SACK, 1, 1)});
        craftingmanager.registerShapelessRecipe(new ItemStack(Item.INK_SACK, 2, 13), new Object[] {new ItemStack(Item.INK_SACK, 1, 5), new ItemStack(Item.INK_SACK, 1, 9)});
        craftingmanager.registerShapelessRecipe(new ItemStack(Item.INK_SACK, 3, 13), new Object[] {new ItemStack(Item.INK_SACK, 1, 4), new ItemStack(Item.INK_SACK, 1, 1), new ItemStack(Item.INK_SACK, 1, 9)});
        craftingmanager.registerShapelessRecipe(new ItemStack(Item.INK_SACK, 4, 13), new Object[] {new ItemStack(Item.INK_SACK, 1, 4), new ItemStack(Item.INK_SACK, 1, 1), new ItemStack(Item.INK_SACK, 1, 1), new ItemStack(Item.INK_SACK, 1, 15)});
    }
    
	private void add2WayWoolRecipe(CraftingManager var1, int var2, int var3) {
		var1.registerShapelessRecipe(new ItemStack(Block.CLASSIC_WOOL, 1, var3), new Object[]{new ItemStack(Block.WOOL, 1, var2)});
		var1.registerShapelessRecipe(new ItemStack(Block.WOOL, 1, var2), new Object[]{new ItemStack(Block.CLASSIC_WOOL, 1, var3)});
	}
}
