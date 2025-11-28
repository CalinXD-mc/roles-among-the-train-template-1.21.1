package dev.cxd.rat.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import dev.cxd.rat.commands.suggestions.RoleSuggestionProvider;
import dev.cxd.rat.config.RolesAmongTheTrainConfig;
import dev.doctor4t.trainmurdermystery.api.Role;
import dev.doctor4t.trainmurdermystery.api.TMMRoles;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

public class SetEnabledRoleCommand {
    public static final SimpleCommandExceptionType INVALID_ROLE_EXCEPTION = new SimpleCommandExceptionType(Text.translatable("commands.setenabledrole.invalid"));
    public static final SimpleCommandExceptionType ROLE_UNCHANGED_EXCEPTION = new SimpleCommandExceptionType(Text.translatable("commands.setenabledrole.unchanged"));


    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(CommandManager.literal("setEnabledRole")
                .requires(serverCommandSource -> serverCommandSource.hasPermissionLevel(2))
                .then(CommandManager.argument("role", StringArgumentType.string()).suggests(new RoleSuggestionProvider())
                        .then(CommandManager.argument("enabled", BoolArgumentType.bool())
                                .executes(context -> execute(context.getSource(), StringArgumentType.getString(context, "role"), BoolArgumentType.getBool(context, "enabled"))))));
    }
    private static int execute(ServerCommandSource source, String roleName, boolean enabled) throws CommandSyntaxException {
        for (Role role : TMMRoles.ROLES) {
            if (role.identifier().getPath().equals(roleName)) {
                boolean disabled = RolesAmongTheTrainConfig.HANDLER.instance().disabled.contains(roleName);
                Text roleText = Text.literal(roleName).withColor(role.color());

                if (disabled && enabled) {
                    RolesAmongTheTrainConfig.HANDLER.instance().disabled.remove(roleName);
                    source.sendFeedback(() -> Text.translatable("commands.setenabledrole.enable.success", roleText), true);
                }
                else if (!disabled && !enabled) {
                    RolesAmongTheTrainConfig.HANDLER.instance().disabled.add(roleName);
                    source.sendFeedback(() -> Text.translatable("commands.setenabledrole.disable.success", roleText), true);
                }
                else throw ROLE_UNCHANGED_EXCEPTION.create();

                RolesAmongTheTrainConfig.HANDLER.save();
                return 1;
            }
        }
        throw INVALID_ROLE_EXCEPTION.create();
    }
}
