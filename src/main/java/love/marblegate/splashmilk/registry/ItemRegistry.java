package love.marblegate.splashmilk.registry;

import love.marblegate.splashmilk.SplashMilk;
import love.marblegate.splashmilk.item.MilkBottle;
import love.marblegate.splashmilk.item.ThrowableMilkBottle;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ItemRegistry {
    public static final Item MILK_BOTTLE = new MilkBottle();
    public static final Item SPLASH_MILK_BOTTLE = new ThrowableMilkBottle();
    public static final Item LINGERING_MILK_BOTTLE = new ThrowableMilkBottle();

    public static void ini() {
        register(MILK_BOTTLE, "milk_bottle");
        register(SPLASH_MILK_BOTTLE, "splash_milk_bottle");
        register(LINGERING_MILK_BOTTLE, "lingering_milk_bottle");
    }

    private static void register(Item item, String id) {
        Registry.register(Registry.ITEM, new Identifier(SplashMilk.MOD_ID, id), item);
    }
}