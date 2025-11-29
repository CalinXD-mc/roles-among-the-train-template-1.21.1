package dev.cxd.rat.mixin;

import dev.doctor4t.trainmurdermystery.game.GameFunctions;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameFunctions.class)
public class GameFunctionsMixin {

    @Inject(method = "finalizeGame", at = @At("TAIL"))
    private static void finalizeGame(ServerWorld world, CallbackInfo ci) {
        for (ServerPlayerEntity player : world.getPlayers()) {
            player.clearStatusEffects();
        }
    }
}