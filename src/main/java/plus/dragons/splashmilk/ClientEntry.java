package plus.dragons.splashmilk;

import plus.dragons.splashmilk.registry.ParticleFactoryRegistry;
import plus.dragons.splashmilk.registry.RendererRegistry;
import net.fabricmc.api.ClientModInitializer;

public class ClientEntry implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ParticleFactoryRegistry.ini();
        RendererRegistry.ini();
    }
}
