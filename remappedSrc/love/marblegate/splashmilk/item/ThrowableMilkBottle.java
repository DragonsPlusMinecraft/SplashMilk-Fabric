package love.marblegate.splashmilk.item;

import love.marblegate.splashmilk.entity.MilkBottleEntity;
import love.marblegate.splashmilk.registry.ItemRegistry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class ThrowableMilkBottle extends Item {
    public ThrowableMilkBottle() {
        super(new FabricItemSettings().group(ItemGroup.BREWING));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemstack = user.getStackInHand(hand);
        boolean isLingering = itemstack.getItem().equals(ItemRegistry.LINGERING_MILK_BOTTLE);
        world.playSound(null, user.getX(), user.getY(), user.getZ(), isLingering ? SoundEvents.ENTITY_LINGERING_POTION_THROW : SoundEvents.ENTITY_SPLASH_POTION_THROW, SoundCategory.NEUTRAL, 0.5F, (float) (0.4F / (Math.random() * 0.4F + 0.8F)));

        if (!world.isClient()) {
            MilkBottleEntity milkBottleEntity = new MilkBottleEntity(world, user);
            milkBottleEntity.setItem(itemstack);
            milkBottleEntity.setVelocity(user, user.getPitch(), user.getYaw(), -20.0F, 0.5F, 1.0F);
            world.spawnEntity(milkBottleEntity);
        }

        if (!user.getAbilities().creativeMode) {
            itemstack.decrement(1);
        }

        return TypedActionResult.success(itemstack, world.isClient());
    }
}
