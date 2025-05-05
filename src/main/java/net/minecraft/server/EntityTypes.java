package net.minecraft.server;

import java.util.HashMap;
import java.util.Map;

public class EntityTypes {

    private static Map<String, Class<?>> a = new HashMap<String, Class<?>>();
    private static Map<Class<?>, String> b = new HashMap<Class<?>, String>();
    private static Map<Integer, Class<?>> c = new HashMap<Integer, Class<?>>();
    private static Map<Class<?>, Integer> d = new HashMap<Class<?>, Integer>();
    private static Map<String, Integer> e = new HashMap<String, Integer>();
    private static Map<Integer, String> f = new HashMap<Integer, String>();
    private static Map<String, String> g = new HashMap<String, String>();
    private static Map<Integer, String> h = new HashMap<Integer, String>();

    public EntityTypes() {}

    private static void a(Class<?> oclass, String s, int i, String ss) {
        a.put(s, oclass);
        b.put(oclass, s);
        c.put(Integer.valueOf(i), oclass);
        d.put(oclass, Integer.valueOf(i));
        e.put(s, i);
        f.put(i, s);
        g.put(s, ss);
        h.put(i, ss);
    }

    public static Entity a(String s, World world) {
        Entity entity = null;

        try {
            Class<?> oclass = (Class<?>) a.get(s);

            if (oclass != null) {
                entity = (Entity) oclass.getConstructor(new Class[] { World.class}).newInstance(new Object[] { world});
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return entity;
    }

    public static Entity a(NBTTagCompound nbttagcompound, World world) {
        Entity entity = null;

        try {
            Class<?> oclass = (Class<?>) a.get(nbttagcompound.getString("id"));

            if (oclass != null) {
                entity = (Entity) oclass.getConstructor(new Class[] { World.class}).newInstance(new Object[] { world});
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        if (entity != null) {
            entity.e(nbttagcompound);
        } else {
            System.out.println("Skipping Entity with id " + nbttagcompound.getString("id"));
        }

        return entity;
    }

    public static int a(Entity entity) {
        return ((Integer) d.get(entity.getClass())).intValue();
    }

    public static String b(Entity entity) {
        return (String) b.get(entity.getClass());
    }
    
    public static int nameToID(String name) {
        return (Integer)e.get(name);
    }

    public static String idToName(int id) {
        return (String)f.get(id);
    }

    public static String getSpawnType(String name) {
        String s = (String)g.get(name);
        return s != null ? s : "illegal";
    }

    public static String getSpawnType(int id) {
        String s = (String)h.get(id);
        return s != null ? s : "illegal";
    }

    static {
        a(EntityArrow.class, "Arrow", 10, "illegal");
        a(EntitySnowball.class, "Snowball", 11, "illegal");
        a(EntityItem.class, "Item", 1, "illegal");
        a(EntityPainting.class, "Painting", 9, "illegal");
        a(EntityLiving.class, "Mob", 48, "illegal");
        a(EntityMonster.class, "Monster", 49, "illegal");
        a(EntityCreeper.class, "Creeper", 50, "hostile");
        a(EntitySkeleton.class, "Skeleton", 51, "hostile");
        a(EntitySpider.class, "Spider", 52, "hostile");
        a(EntityGiantZombie.class, "Giant", 53, "hostile");
        a(EntityZombie.class, "Zombie", 54, "hostile");
        a(EntitySlime.class, "Slime", 55, "hostile");
        a(EntityGhast.class, "Ghast", 56, "hostile");
        a(EntityPigZombie.class, "PigZombie", 57, "hostile");
        a(EntityPig.class, "Pig", 90, "passive");
        a(EntitySheep.class, "Sheep", 91, "passive");
        a(EntityCow.class, "Cow", 92, "passive");
        a(EntityChicken.class, "Chicken", 93, "passive");
        a(EntitySquid.class, "Squid", 94, "passive");
        a(EntityWolf.class, "Wolf", 95, "passive");
        a(EntityTNTPrimed.class, "PrimedTnt", 20, "illegal");
        a(EntityFallingSand.class, "FallingSand", 21, "illegal");
        a(EntityMinecart.class, "Minecart", 40, "illegal");
        a(EntityBoat.class, "Boat", 41, "illegal");
    }
}
