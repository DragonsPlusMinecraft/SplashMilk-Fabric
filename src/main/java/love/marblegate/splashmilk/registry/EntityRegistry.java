package love.marblegate.splashmilk.registry;

import love.marblegate.splashmilk.SplashMilk;
import love.marblegate.splashmilk.entity.MIlkAreaEffectCloudEntity;
import love.marblegate.splashmilk.entity.MilkBottleEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EntityRegistry {
    public static EntityType<MIlkAreaEffectCloudEntity> MILK_AREA_EFFECT_CLOUD;
    public static EntityType<MilkBottleEntity> MILK_BOTTLE;

    public static void ini(){
        MILK_AREA_EFFECT_CLOUD = Registry.register(Registry.ENTITY_TYPE, new Identifier(SplashMilk.MOD_ID, "milk_area_effect_cloud"),
                FabricEntityTypeBuilder.<MIlkAreaEffectCloudEntity>create(SpawnGroup.MISC, MIlkAreaEffectCloudEntity::new)
                        .dimensions(EntityDimensions.fixed(6.0f, 0.5f)).fireImmune().trackRangeBlocks(10).build());
        MILK_BOTTLE = Registry.register(Registry.ENTITY_TYPE, new Identifier(SplashMilk.MOD_ID, "milk_bottle"),
                FabricEntityTypeBuilder.<MilkBottleEntity>create(SpawnGroup.MISC, MilkBottleEntity::new)
                        .dimensions(EntityDimensions.fixed(0.5f, 0.5f)).fireImmune().trackedUpdateRate(20).trackRangeBlocks(10).build());

    }
}