package love.marblegate.splashmilk;

import love.marblegate.splashmilk.registry.EntityRegistry;
import love.marblegate.splashmilk.registry.ItemRegistry;
import love.marblegate.splashmilk.registry.ParticleTypeRegistry;
import net.fabricmc.api.ModInitializer;

public class SplashMilk implements ModInitializer {
    public static final String MOD_ID = "splash_milk";

    @Override
    public void onInitialize() {
        ItemRegistry.ini();
        ParticleTypeRegistry.ini();
        EntityRegistry.ini();
    }
}
