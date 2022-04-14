package love.marblegate.splashmilk.registry;

import love.marblegate.splashmilk.SplashMilk;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ParticleTypeRegistry {
    public static final DefaultParticleType MILK_AREA_EFFECT = FabricParticleTypes.simple();

    public static void ini() {
        Registry.register(Registry.PARTICLE_TYPE, new Identifier(SplashMilk.MOD_ID, "milk_area_effect"), MILK_AREA_EFFECT);
    }
}
