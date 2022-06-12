package love.marblegate.splashmilk.registry;

import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.minecraft.client.particle.EmotionParticle;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.util.Identifier;

public class ParticleFactoryRegistry {
    public static void ini() {
        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register(((atlasTexture, registry) -> registry.register(new Identifier("splash_milk", "particle/milk_area_effect"))));
        net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry.getInstance().register(ParticleTypeRegistry.MILK_AREA_EFFECT, EmotionParticle.AngryVillagerFactory::new);
    }
}
