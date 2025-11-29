package dev.cxd.rat.items;

import dev.cxd.rat.index.RATEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.UseAction;

public class MedkitItem extends Item {
    public MedkitItem(Settings settings) {
        super(settings);
    }

    public ActionResult useOnEntity(ItemStack stack, PlayerEntity player, LivingEntity target, Hand hand) {
        target.addStatusEffect(new StatusEffectInstance(RATEffects.PROTECTED, 999999999, 0, true, false));
        player.setStackInHand(hand, Items.AIR.getDefaultStack());
        return ActionResult.SUCCESS;
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.TOOT_HORN;
    }
}
