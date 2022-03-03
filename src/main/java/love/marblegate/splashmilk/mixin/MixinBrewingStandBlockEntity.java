package love.marblegate.splashmilk.mixin;

import love.marblegate.splashmilk.registry.ItemRegistry;
import net.minecraft.block.entity.BrewingStandBlockEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ThrowablePotionItem;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionUtil;
import net.minecraft.potion.Potions;;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(BrewingStandBlockEntity.class)
public class MixinBrewingStandBlockEntity {
    @Inject(method = "canCraft(Lnet/minecraft/util/collection/DefaultedList;)Z", at = @At("HEAD"), cancellable = true)
    private static void injected(DefaultedList<ItemStack> slots, CallbackInfoReturnable<Boolean> cir) {
        ItemStack itemStack = slots.get(3);
        if (itemStack.isOf(Items.MILK_BUCKET)) {
            for (int i = 0; i < 3; ++i) {
                ItemStack itemStack2 = slots.get(i);
                if(qualified(itemStack2))
                    cir.setReturnValue(true);
            }
        }
    }

    @Inject(method = "craft(Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/collection/DefaultedList;)V", at = @At("HEAD"), cancellable = true)
    private static void injected(World world, BlockPos pos, DefaultedList<ItemStack> slots, CallbackInfo ci) {
        ItemStack itemStack = slots.get(3);
        if(itemStack.isOf(Items.MILK_BUCKET)){
            for(int i = 0; i < 3; ++i) {
                if(qualified(slots.get(i))){
                    ItemStack brewed = slots.get(i).isOf(Items.LINGERING_POTION)?
                            ItemRegistry.LINGERING_MILK_BOTTLE.getDefaultStack():
                            ItemRegistry.SPLASH_MILK_BOTTLE.getDefaultStack();
                    slots.set(i, brewed);
                }
            }
            slots.set(3, Items.BUCKET.getDefaultStack());
            world.syncWorldEvent(1035, pos, 0);
            ci.cancel();
        }
    }

    private static boolean qualified(ItemStack itemStack){
        if(itemStack.getItem() instanceof ThrowablePotionItem){
            Potion potion = PotionUtil.getPotion(itemStack);
            return potion.equals(Potions.WATER) || potion.equals(Potions.MUNDANE) || potion.equals(Potions.THICK) || potion.equals(Potions.AWKWARD);
        }
        return false;
    }

}
