package net.minecraft.server;

public class RecipesCrafting {

    public RecipesCrafting() {}

    public void a(CraftingManager craftingmanager) {
        craftingmanager.registerShapedRecipe(new ItemStack(Block.CHEST), new Object[] { "###", "# #", "###", Character.valueOf('#'), Block.WOOD});
        craftingmanager.registerShapedRecipe(new ItemStack(Block.FURNACE), new Object[] { "###", "# #", "###", Character.valueOf('#'), Block.COBBLESTONE});
        craftingmanager.registerShapedRecipe(new ItemStack(Block.WORKBENCH), new Object[] { "##", "##", Character.valueOf('#'), Block.WOOD});
        craftingmanager.registerShapedRecipe(new ItemStack(Block.SANDSTONE), new Object[] { "##", "##", Character.valueOf('#'), Block.SAND});
        craftingmanager.registerShapedRecipe(new ItemStack(Block.COBBLESTONE, 4, 1), new Object[] { "##", "##", Character.valueOf('#'), new ItemStack(Block.COBBLESTONE, 1, 0)});
        craftingmanager.registerShapedRecipe(new ItemStack(Block.COBBLESTONE, 4, 0), new Object[] { "##", "##", Character.valueOf('#'), new ItemStack(Block.COBBLESTONE, 1, 1)});
        craftingmanager.registerShapelessRecipe(new ItemStack(Block.COBBLESTONE, 1, 1), new Object[] {new ItemStack(Block.COBBLESTONE, 1, 0)});
        craftingmanager.registerShapelessRecipe(new ItemStack(Block.COBBLESTONE, 1, 0), new Object[] {new ItemStack(Block.COBBLESTONE, 1, 1)});
    }
}
