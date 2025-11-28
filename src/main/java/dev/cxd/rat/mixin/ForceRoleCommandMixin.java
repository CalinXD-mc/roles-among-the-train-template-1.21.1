package dev.cxd.rat.mixin;

import com.mojang.brigadier.CommandDispatcher;
import dev.cxd.rat.RolesAmongTheTrain;
import dev.doctor4t.trainmurdermystery.command.ForceRoleCommand;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Collection;

@Mixin(ForceRoleCommand.class)
public class ForceRoleCommandMixin {

    @Inject(method = "register", at = @At("TAIL"))
    private static void addModdedRoleCommands(CommandDispatcher<ServerCommandSource> dispatcher, CallbackInfo ci) {
        // Seer
        dispatcher.register(CommandManager.literal("tmm:forceRole")
                .requires(source -> source.hasPermissionLevel(2))
                .then(CommandManager.literal("seer")
                        .then(CommandManager.argument("players", EntityArgumentType.players())
                                .executes(context -> {
                                    Collection<ServerPlayerEntity> players = EntityArgumentType.getPlayers(context, "players");
                                    for (ServerPlayerEntity player : players) {
                                        RolesAmongTheTrain.addToForcedRoles(RolesAmongTheTrain.SEER, player);
                                    }
                                    context.getSource().sendFeedback(
                                            () -> Text.literal("Forced " + players.size() + " player(s) to be Seer"),
                                            true
                                    );
                                    return 1;
                                })
                        )
                )
        );

        // Timekeeper
        dispatcher.register(CommandManager.literal("tmm:forceRole")
                .requires(source -> source.hasPermissionLevel(2))
                .then(CommandManager.literal("time_keeper")
                        .then(CommandManager.argument("players", EntityArgumentType.players())
                                .executes(context -> {
                                    Collection<ServerPlayerEntity> players = EntityArgumentType.getPlayers(context, "players");
                                    for (ServerPlayerEntity player : players) {
                                        RolesAmongTheTrain.addToForcedRoles(RolesAmongTheTrain.TIMEKEEPER, player);
                                    }
                                    context.getSource().sendFeedback(
                                            () -> Text.literal("Forced " + players.size() + " player(s) to be Timekeeper"),
                                            true
                                    );
                                    return 1;
                                })
                        )
                )
        );

        // Apathetic
        dispatcher.register(CommandManager.literal("tmm:forceRole")
                .requires(source -> source.hasPermissionLevel(2))
                .then(CommandManager.literal("apathetic")
                        .then(CommandManager.argument("players", EntityArgumentType.players())
                                .executes(context -> {
                                    Collection<ServerPlayerEntity> players = EntityArgumentType.getPlayers(context, "players");
                                    for (ServerPlayerEntity player : players) {
                                        RolesAmongTheTrain.addToForcedRoles(RolesAmongTheTrain.APATHETIC, player);
                                    }
                                    context.getSource().sendFeedback(
                                            () -> Text.literal("Forced " + players.size() + " player(s) to be Apathetic"),
                                            true
                                    );
                                    return 1;
                                })
                        )
                )
        );

        // Toxicologist
        dispatcher.register(CommandManager.literal("tmm:forceRole")
                .requires(source -> source.hasPermissionLevel(2))
                .then(CommandManager.literal("toxicologist")
                        .then(CommandManager.argument("players", EntityArgumentType.players())
                                .executes(context -> {
                                    Collection<ServerPlayerEntity> players = EntityArgumentType.getPlayers(context, "players");
                                    for (ServerPlayerEntity player : players) {
                                        RolesAmongTheTrain.addToForcedRoles(RolesAmongTheTrain.TOXICOLOGIST, player);
                                    }
                                    context.getSource().sendFeedback(
                                            () -> Text.literal("Forced " + players.size() + " player(s) to be Toxicologist"),
                                            true
                                    );
                                    return 1;
                                })
                        )
                )
        );
    }
}