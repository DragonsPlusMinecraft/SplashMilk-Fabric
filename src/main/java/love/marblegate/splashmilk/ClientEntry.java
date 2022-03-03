package love.marblegate.splashmilk;

import love.marblegate.splashmilk.registry.ParticleFactoryRegistry;
import love.marblegate.splashmilk.registry.RendererRegistry;
import net.fabricmc.api.ClientModInitializer;

public class ClientEntry implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ParticleFactoryRegistry.ini();
        RendererRegistry.ini();
    }
}
