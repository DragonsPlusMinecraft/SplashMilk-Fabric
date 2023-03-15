package plus.dragons.splashmilk;

import plus.dragons.splashmilk.registry.EntityRegistry;
import plus.dragons.splashmilk.registry.ItemRegistry;
import plus.dragons.splashmilk.registry.ParticleTypeRegistry;
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
