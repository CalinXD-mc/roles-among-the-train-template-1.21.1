package dev.cxd.rat.commands;

import com.mojang.brigadier.CommandDispatcher;
import dev.cxd.rat.config.RolesAmongTheTrainConfig;
import dev.doctor4t.trainmurdermystery.api.Role;
import dev.doctor4t.trainmurdermystery.api.TMMRoles;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Colors;

public class ListRolesCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(CommandManager.literal("listRoles").executes((context -> execute(context.getSource()))));
    }
    private static int execute(ServerCommandSource source) {
        MutableText message = Text.literal("Roles:");
        Text enabled = Text.literal("[Enabled] ").withColor(Colors.GREEN);
        Text disabled = Text.literal("[Disabled] ").withColor(Colors.RED);
        for (Role role : TMMRoles.ROLES) {
            message.append("\n");
            String roleName = role.identifier().getPath();
            if (RolesAmongTheTrainConfig.HANDLER.instance().disabled.contains(roleName)) message.append(disabled);
            else message.append(enabled);
            message.append(Text.literal(roleName).withColor(role.color()));
        }
        source.sendMessage(message);
        return 1;
    }
}
