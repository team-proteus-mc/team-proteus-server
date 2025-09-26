package net.minecraft.server;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class CraftingManager {

    private static final CraftingManager a = new CraftingManager();
    private List b = new ArrayList();

    public static final CraftingManager getInstance() {
        return a;
    }

    private CraftingManager() {
        (new RecipesTools()).a(this);
        (new RecipesWeapons()).a(this);
        (new RecipeIngots()).a(this);
        (new RecipesFood()).a(this);
        (new RecipesCrafting()).a(this);
        (new RecipesArmor()).a(this);
        (new RecipesDyes()).a(this);
        this.registerShapedRecipe(new ItemStack(Item.PAPER, 3), "###", Character.valueOf('#'), Item.SUGAR_CANE);
        this.registerShapedRecipe(new ItemStack(Item.BOOK, 1), "#", "#", "#", Character.valueOf('#'), Item.PAPER);
        this.registerShapedRecipe(new ItemStack(Block.FENCE, 4), "###", "###", Character.valueOf('#'), Item.STICK);
        this.registerShapedRecipe(new ItemStack(Block.JUKEBOX, 1), "###", "#X#", "###", Character.valueOf('#'), Block.WOOD, Character.valueOf('X'), Item.DIAMOND);
        this.registerShapedRecipe(new ItemStack(Block.NOTE_BLOCK, 1), "###", "#X#", "###", Character.valueOf('#'), Block.WOOD, Character.valueOf('X'), Item.REDSTONE);
        this.registerShapedRecipe(new ItemStack(Block.BOOKSHELF, 1), "###", "XXX", "###", Character.valueOf('#'), Block.WOOD, Character.valueOf('X'), Item.BOOK);
        this.registerShapedRecipe(new ItemStack(Block.SNOW_BLOCK, 1), "##", "##", Character.valueOf('#'), Item.SNOW_BALL);
        this.registerShapedRecipe(new ItemStack(Block.CLAY, 1), "##", "##", Character.valueOf('#'), Item.CLAY_BALL);
        this.registerShapedRecipe(new ItemStack(Block.BRICK, 1), "##", "##", Character.valueOf('#'), Item.CLAY_BRICK);
        this.registerShapedRecipe(new ItemStack(Block.GLOWSTONE, 1), "##", "##", Character.valueOf('#'), Item.GLOWSTONE_DUST);
        this.registerShapedRecipe(new ItemStack(Block.WOOL, 1), "##", "##", Character.valueOf('#'), Item.STRING);
        this.registerShapedRecipe(new ItemStack(Block.STONE_BRICKS, 4, 0), "##", "##", Character.valueOf('#'), Block.STONE);
        this.registerShapedRecipe(new ItemStack(Block.STONE_BRICKS, 4, 1), "A#", "#A", Character.valueOf('#'), Block.STONE, Character.valueOf('A'), Block.MOSSY_COBBLESTONE);
        this.registerShapedRecipe(new ItemStack(Block.STONE_BRICKS, 2, 3), "##", "##", Character.valueOf('#'), new ItemStack(Block.STEP, 1, 5));
        this.registerShapedRecipe(new ItemStack(Block.TNT, 1), "X#X", "#X#", "X#X", Character.valueOf('X'), Item.SULPHUR, Character.valueOf('#'), Block.SAND);
       
        this.registerShapedRecipe(new ItemStack(Block.STEP, 6, 0), "###", Character.valueOf('#'), Block.STONE);
        this.registerShapedRecipe(new ItemStack(Block.STEP, 6, 1), "###", Character.valueOf('#'), Block.SANDSTONE);
        this.registerShapedRecipe(new ItemStack(Block.STEP, 6, 2), "###", Character.valueOf('#'), Block.WOOD);
        this.registerShapedRecipe(new ItemStack(Block.STEP, 6, 3), "###", Character.valueOf('#'), new ItemStack(Block.COBBLESTONE, 1, 0));
        this.registerShapedRecipe(new ItemStack(Block.STEP, 6, 4), "###", Character.valueOf('#'), Block.BRICK);
        this.registerShapedRecipe(new ItemStack(Block.STEP, 6, 5), "###", Character.valueOf('#'), new ItemStack(Block.STONE_BRICKS, 1, 0));
        this.registerShapedRecipe(new ItemStack(Block.STEP, 6, 6), "###", Character.valueOf('#'), new ItemStack(Block.COBBLESTONE, 1, 1));
       
        this.registerShapedRecipe(new ItemStack(Block.STONE, 1), "#", "#", Character.valueOf('#'), new ItemStack(Block.STEP, 1, 0));
        this.registerShapedRecipe(new ItemStack(Block.SANDSTONE, 1), "#", "#", Character.valueOf('#'), new ItemStack(Block.STEP, 1, 1));
        this.registerShapedRecipe(new ItemStack(Block.WOOD, 1), "#", "#", Character.valueOf('#'), new ItemStack(Block.STEP, 1, 2));
        this.registerShapedRecipe(new ItemStack(Block.COBBLESTONE, 1, 0), "#", "#", Character.valueOf('#'), new ItemStack(Block.STEP, 1, 3));
        this.registerShapedRecipe(new ItemStack(Block.BRICK, 1), "#", "#", Character.valueOf('#'), new ItemStack(Block.STEP, 1, 4));
        this.registerShapedRecipe(new ItemStack(Block.STONE_BRICKS, 1, 0), "#", "#", Character.valueOf('#'), new ItemStack(Block.STEP, 1, 5));
        this.registerShapedRecipe(new ItemStack(Block.COBBLESTONE, 1, 1), "#", "#", Character.valueOf('#'), new ItemStack(Block.STEP, 1, 6));
        
        this.registerShapedRecipe(new ItemStack(Block.WOOD, 3), "##", "##", Character.valueOf('#'), Block.WOOD_STAIRS);
        this.registerShapedRecipe(new ItemStack(Block.COBBLESTONE, 3, 0), "##", "##", Character.valueOf('#'), Block.COBBLESTONE_STAIRS);
        this.registerShapedRecipe(new ItemStack(Block.COBBLESTONE, 3, 1), "##", "##", Character.valueOf('#'), Block.OLD_COBBLESTONE_STAIRS);
        this.registerShapedRecipe(new ItemStack(Block.BRICK, 3), "##", "##", Character.valueOf('#'), Block.BRICK_STAIRS);
        this.registerShapedRecipe(new ItemStack(Block.STONE_BRICKS, 3, 0), "##", "##", Character.valueOf('#'), Block.STONE_BRICK_STAIRS);
        
        this.registerShapedRecipe(new ItemStack(Block.WOOD_STAIRS, 8), "#  ", "## ", "###", Character.valueOf('#'), Block.WOOD);
        this.registerShapedRecipe(new ItemStack(Block.COBBLESTONE_STAIRS, 8), "#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Block.COBBLESTONE, 1, 0));
        this.registerShapedRecipe(new ItemStack(Block.OLD_COBBLESTONE_STAIRS, 8), "#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Block.COBBLESTONE, 1, 1));
        this.registerShapedRecipe(new ItemStack(Block.BRICK_STAIRS, 8), "#  ", "## ", "###", Character.valueOf('#'), Block.BRICK);
        this.registerShapedRecipe(new ItemStack(Block.STONE_BRICK_STAIRS, 8), "#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Block.STONE_BRICKS, 1, 0));
        
        this.registerShapedRecipe(new ItemStack(Block.LADDER, 4), "# #", "###", "# #", Character.valueOf('#'), Item.STICK);
        this.registerShapedRecipe(new ItemStack(Item.WOOD_DOOR, 1), "##", "##", "##", Character.valueOf('#'), Block.WOOD);
        this.registerShapedRecipe(new ItemStack(Block.TRAP_DOOR, 2), "###", "###", Character.valueOf('#'), Block.WOOD);
        this.registerShapedRecipe(new ItemStack(Block.IRON_TRAP_DOOR, 2), "###", "###", Character.valueOf('#'), Item.IRON_INGOT);
        this.registerShapedRecipe(new ItemStack(Item.IRON_DOOR, 1), "##", "##", "##", Character.valueOf('#'), Item.IRON_INGOT);
        this.registerShapedRecipe(new ItemStack(Item.SIGN, 1), "###", "###", " X ", Character.valueOf('#'), Block.WOOD, Character.valueOf('X'), Item.STICK);
        this.registerShapedRecipe(new ItemStack(Item.CAKE, 1), "AAA", "BEB", "CCC", Character.valueOf('A'), Item.MILK_BUCKET, Character.valueOf('B'), Item.SUGAR, Character.valueOf('C'), Item.WHEAT, Character.valueOf('E'), Item.EGG);
        this.registerShapedRecipe(new ItemStack(Item.SUGAR, 1), "#", Character.valueOf('#'), Item.SUGAR_CANE);
        this.registerShapedRecipe(new ItemStack(Block.WOOD, 4), "#", Character.valueOf('#'), Block.LOG);
        this.registerShapedRecipe(new ItemStack(Item.STICK, 4), "#", "#", Character.valueOf('#'), Block.WOOD);
        this.registerShapedRecipe(new ItemStack(Block.TORCH, 4), "X", "#", Character.valueOf('X'), Item.COAL, Character.valueOf('#'), Item.STICK);
        this.registerShapedRecipe(new ItemStack(Block.TORCH, 4), "X", "#", Character.valueOf('X'), new ItemStack(Item.COAL, 1, 1), Character.valueOf('#'), Item.STICK);
        this.registerShapedRecipe(new ItemStack(Item.BOWL, 4), "# #", " # ", Character.valueOf('#'), Block.WOOD);
        this.registerShapedRecipe(new ItemStack(Block.RAILS, 16), "X X", "X#X", "X X", Character.valueOf('X'), Item.IRON_INGOT, Character.valueOf('#'), Item.STICK);
        this.registerShapedRecipe(new ItemStack(Block.GOLDEN_RAIL, 6), "X X", "X#X", "XRX", Character.valueOf('X'), Item.GOLD_INGOT, Character.valueOf('R'), Item.REDSTONE, Character.valueOf('#'), Item.STICK);
        this.registerShapedRecipe(new ItemStack(Block.DETECTOR_RAIL, 6), "X X", "X#X", "XRX", Character.valueOf('X'), Item.IRON_INGOT, Character.valueOf('R'), Item.REDSTONE, Character.valueOf('#'), Block.STONE_PLATE);
        this.registerShapedRecipe(new ItemStack(Item.MINECART, 1), "# #", "###", Character.valueOf('#'), Item.IRON_INGOT);
        this.registerShapedRecipe(new ItemStack(Block.JACK_O_LANTERN, 1), "A", "B", Character.valueOf('A'), Block.PUMPKIN, Character.valueOf('B'), Block.TORCH);
        this.registerShapedRecipe(new ItemStack(Item.STORAGE_MINECART, 1), "A", "B", Character.valueOf('A'), Block.CHEST, Character.valueOf('B'), Item.MINECART);
        this.registerShapedRecipe(new ItemStack(Item.POWERED_MINECART, 1), "A", "B", Character.valueOf('A'), Block.FURNACE, Character.valueOf('B'), Item.MINECART);
        this.registerShapedRecipe(new ItemStack(Item.BOAT, 1), "# #", "###", Character.valueOf('#'), Block.WOOD);
        this.registerShapedRecipe(new ItemStack(Item.BUCKET, 1), "# #", " # ", Character.valueOf('#'), Item.IRON_INGOT);
        this.registerShapedRecipe(new ItemStack(Item.FLINT_AND_STEEL, 1), "A ", " B", Character.valueOf('A'), Item.IRON_INGOT, Character.valueOf('B'), Item.FLINT);
        this.registerShapedRecipe(new ItemStack(Item.BREAD, 1), "###", Character.valueOf('#'), Item.WHEAT);
        this.registerShapedRecipe(new ItemStack(Item.FISHING_ROD, 1), "  #", " #X", "# X", Character.valueOf('#'), Item.STICK, Character.valueOf('X'), Item.STRING);
        this.registerShapedRecipe(new ItemStack(Item.PAINTING, 1), "###", "#X#", "###", Character.valueOf('#'), Item.STICK, Character.valueOf('X'), Block.WOOL);
        this.registerShapedRecipe(new ItemStack(Item.GOLDEN_APPLE, 1), "###", "#X#", "###", Character.valueOf('#'), Block.GOLD_BLOCK, Character.valueOf('X'), Item.APPLE);
        this.registerShapedRecipe(new ItemStack(Block.LEVER, 1), "X", "#", Character.valueOf('#'), Block.COBBLESTONE, Character.valueOf('X'), Item.STICK);
        this.registerShapedRecipe(new ItemStack(Block.REDSTONE_TORCH_ON, 1), "X", "#", Character.valueOf('#'), Item.STICK, Character.valueOf('X'), Item.REDSTONE);
        this.registerShapedRecipe(new ItemStack(Item.DIODE, 1), "#X#", "III", Character.valueOf('#'), Block.REDSTONE_TORCH_ON, Character.valueOf('X'), Item.REDSTONE, Character.valueOf('I'), Block.STONE);
        this.registerShapedRecipe(new ItemStack(Item.WATCH, 1), " # ", "#X#", " # ", Character.valueOf('#'), Item.GOLD_INGOT, Character.valueOf('X'), Item.REDSTONE);
        this.registerShapedRecipe(new ItemStack(Item.COMPASS, 1), " # ", "#X#", " # ", Character.valueOf('#'), Item.IRON_INGOT, Character.valueOf('X'), Item.REDSTONE);
        this.registerShapedRecipe(new ItemStack(Item.MAP, 1), "###", "#X#", "###", Character.valueOf('#'), Item.PAPER, Character.valueOf('X'), Item.COMPASS);
        this.registerShapedRecipe(new ItemStack(Block.STONE_BUTTON, 1), "#", "#", Character.valueOf('#'), Block.STONE);
        this.registerShapedRecipe(new ItemStack(Block.STONE_PLATE, 1), "##", Character.valueOf('#'), Block.STONE);
        this.registerShapedRecipe(new ItemStack(Block.WOOD_PLATE, 1), "##", Character.valueOf('#'), Block.WOOD);
        this.registerShapedRecipe(new ItemStack(Block.DISPENSER, 1), "###", "#X#", "#R#", Character.valueOf('#'), Block.COBBLESTONE, Character.valueOf('X'), Item.BOW, Character.valueOf('R'), Item.REDSTONE);
        this.registerShapedRecipe(new ItemStack(Block.PISTON, 1), "TTT", "#X#", "#R#", Character.valueOf('#'), Block.COBBLESTONE, Character.valueOf('X'), Item.IRON_INGOT, Character.valueOf('R'), Item.REDSTONE, Character.valueOf('T'), Block.WOOD);
        this.registerShapedRecipe(new ItemStack(Block.PISTON_STICKY, 1), "S", "P", Character.valueOf('S'), Item.SLIME_BALL, Character.valueOf('P'), Block.PISTON);
        this.registerShapedRecipe(new ItemStack(Item.BED, 1), "###", "XXX", Character.valueOf('#'), Block.WOOL, Character.valueOf('X'), Block.WOOD);
        this.registerShapedRecipe(new ItemStack(Block.MOB_SPAWNER, 1, 50), "#B#", "#X#", "#B#", Character.valueOf('#'), Item.SULPHUR, Character.valueOf('X'), Block.MOB_SPAWNER, Character.valueOf('B'), Block.LAPIS_BLOCK);
        this.registerShapedRecipe(new ItemStack(Block.MOB_SPAWNER, 1, 51), "#B#", "FXF", "#B#", Character.valueOf('#'), Item.BONE, Character.valueOf('X'), Block.MOB_SPAWNER, Character.valueOf('B'), Block.LAPIS_BLOCK, Character.valueOf('F'), Item.ARROW);
        this.registerShapedRecipe(new ItemStack(Block.MOB_SPAWNER, 1, 52), "#B#", "#X#", "#B#", Character.valueOf('#'), Item.STRING, Character.valueOf('X'), Block.MOB_SPAWNER, Character.valueOf('B'), Block.LAPIS_BLOCK);
        this.registerShapedRecipe(new ItemStack(Block.MOB_SPAWNER, 1, 54), "#B#", "FXF", "#B#", Character.valueOf('#'), Item.FEATHER, Character.valueOf('X'), Block.MOB_SPAWNER, Character.valueOf('B'), Block.LAPIS_BLOCK, Character.valueOf('F'), Item.BEEF);
        this.registerShapedRecipe(new ItemStack(Block.MOB_SPAWNER, 1, 55), "#B#", "#X#", "#B#", Character.valueOf('#'), Item.SLIME_BALL, Character.valueOf('X'), Block.MOB_SPAWNER, Character.valueOf('B'), Block.LAPIS_BLOCK);
        this.registerShapedRecipe(new ItemStack(Block.MOB_SPAWNER, 1, 57), "#B#", "FXF", "#B#", Character.valueOf('#'), Item.GRILLED_PORK, Character.valueOf('X'), Block.MOB_SPAWNER, Character.valueOf('B'), Block.LAPIS_BLOCK, Character.valueOf('F'), Item.GOLD_SWORD);
        this.registerShapedRecipe(new ItemStack(Block.MOB_SPAWNER, 1, 90), "#B#", "#X#", "#B#", Character.valueOf('#'), Item.PORK, Character.valueOf('X'), Block.MOB_SPAWNER, Character.valueOf('B'), Block.LAPIS_BLOCK);
        this.registerShapedRecipe(new ItemStack(Block.MOB_SPAWNER, 1, 91), "#B#", "#X#", "#B#", Character.valueOf('#'), Block.WOOL, Character.valueOf('X'), Block.MOB_SPAWNER, Character.valueOf('B'), Block.LAPIS_BLOCK);
        this.registerShapedRecipe(new ItemStack(Block.MOB_SPAWNER, 1, 92), "#B#", "FXF", "#B#", Character.valueOf('#'), Item.BEEF, Character.valueOf('X'), Block.MOB_SPAWNER, Character.valueOf('B'), Block.LAPIS_BLOCK, Character.valueOf('F'), Item.LEATHER);
        this.registerShapedRecipe(new ItemStack(Block.MOB_SPAWNER, 1, 93), "#B#", "FXF", "#B#", Character.valueOf('#'), Item.FEATHER, Character.valueOf('X'), Block.MOB_SPAWNER, Character.valueOf('B'), Block.LAPIS_BLOCK, Character.valueOf('F'), Item.CHICKEN);
        this.registerShapedRecipe(new ItemStack(Block.MOB_SPAWNER, 1, 94), "#B#", "#X#", "#B#", Character.valueOf('#'), new ItemStack(Item.INK_SACK, 1, 0), Character.valueOf('X'), Block.MOB_SPAWNER, Character.valueOf('B'), Block.LAPIS_BLOCK);
        this.registerShapedRecipe(new ItemStack(Block.MOB_SPAWNER, 1, 95), "#B#", "#X#", "#B#", Character.valueOf('#'), Item.BONE, Character.valueOf('X'), Block.MOB_SPAWNER, Character.valueOf('B'), Block.LAPIS_BLOCK);
        Collections.sort(this.b, new RecipeSorter(this));
        System.out.println(this.b.size() + " recipes");
    }

    public void registerShapedRecipe(ItemStack itemstack, Object... aobject) { // CraftBukkit - default -> public
        String s = "";
        int i = 0;
        int j = 0;
        int k = 0;

        if (aobject[i] instanceof String[]) {
            String[] astring = (String[]) ((String[]) aobject[i++]);

            for (int l = 0; l < astring.length; ++l) {
                String s1 = astring[l];

                ++k;
                j = s1.length();
                s = s + s1;
            }
        } else {
            while (aobject[i] instanceof String) {
                String s2 = (String) aobject[i++];

                ++k;
                j = s2.length();
                s = s + s2;
            }
        }

        HashMap hashmap;

        for (hashmap = new HashMap(); i < aobject.length; i += 2) {
            Character character = (Character) aobject[i];
            ItemStack itemstack1 = null;

            if (aobject[i + 1] instanceof Item) {
                itemstack1 = new ItemStack((Item) aobject[i + 1]);
            } else if (aobject[i + 1] instanceof Block) {
                itemstack1 = new ItemStack((Block) aobject[i + 1], 1, -1);
            } else if (aobject[i + 1] instanceof ItemStack) {
                itemstack1 = (ItemStack) aobject[i + 1];
            }

            hashmap.put(character, itemstack1);
        }

        ItemStack[] aitemstack = new ItemStack[j * k];

        for (int i1 = 0; i1 < j * k; ++i1) {
            char c0 = s.charAt(i1);

            if (hashmap.containsKey(Character.valueOf(c0))) {
                aitemstack[i1] = ((ItemStack) hashmap.get(Character.valueOf(c0))).cloneItemStack();
            } else {
                aitemstack[i1] = null;
            }
        }

        this.b.add(new ShapedRecipes(j, k, aitemstack, itemstack));
    }

    public void registerShapelessRecipe(ItemStack itemstack, Object... aobject) { // CraftBukkit - default -> public
        ArrayList arraylist = new ArrayList();
        Object[] aobject1 = aobject;
        int i = aobject.length;

        for (int j = 0; j < i; ++j) {
            Object object = aobject1[j];

            if (object instanceof ItemStack) {
                arraylist.add(((ItemStack) object).cloneItemStack());
            } else if (object instanceof Item) {
                arraylist.add(new ItemStack((Item) object));
            } else {
                if (!(object instanceof Block)) {
                    throw new RuntimeException("Invalid shapeless recipy!");
                }

                arraylist.add(new ItemStack((Block) object));
            }
        }

        this.b.add(new ShapelessRecipes(itemstack, arraylist));
    }

    public ItemStack craft(InventoryCrafting inventorycrafting) {
        for (int i = 0; i < this.b.size(); ++i) {
            CraftingRecipe craftingrecipe = (CraftingRecipe) this.b.get(i);

            if (craftingrecipe.a(inventorycrafting)) {
                return craftingrecipe.b(inventorycrafting);
            }
        }

        return null;
    }

    public List b() {
        return this.b;
    }
}
