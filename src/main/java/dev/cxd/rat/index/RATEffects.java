package dev.cxd.rat.index;

import dev.cxd.rat.RolesAmongTheTrain;
import dev.cxd.rat.effects.ProtectedEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class RATEffects {
    public static final RegistryEntry<StatusEffect> PROTECTED = registerStatusEffect("protected",
            new ProtectedEffect(StatusEffectCategory.NEUTRAL, 0x36ebab));


    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(RolesAmongTheTrain.MOD_ID, name), statusEffect);
    }

    public static void initialize() {}
}
