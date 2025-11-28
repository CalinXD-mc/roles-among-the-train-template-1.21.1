package dev.cxd.rat.mixin.client;

import dev.cxd.rat.RolesAmongTheTrain;
import dev.doctor4t.trainmurdermystery.api.GameMode;
import dev.doctor4t.trainmurdermystery.api.TMMGameModes;
import dev.doctor4t.trainmurdermystery.cca.GameWorldComponent;
import dev.doctor4t.trainmurdermystery.client.gui.MoodRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(MoodRenderer.class)
public class MoodRendererMixin {
    @Redirect(method = "renderHud", at = @At(value = "INVOKE", target = "Ldev/doctor4t/trainmurdermystery/cca/GameWorldComponent;getGameMode()Ldev/doctor4t/trainmurdermystery/api/GameMode;"))
    private static GameMode a(GameWorldComponent instance) {
        if (instance.getGameMode().equals(RolesAmongTheTrain.MODDED_GAMEMODE)) return TMMGameModes.MURDER;
        return instance.getGameMode();
    }
}