package dev.cxd.rat.commands.suggestions;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import dev.cxd.rat.RolesAmongTheTrain;
import dev.doctor4t.trainmurdermystery.api.Role;
import dev.doctor4t.trainmurdermystery.api.TMMRoles;
import net.minecraft.command.CommandSource;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class RoleSuggestionProvider implements SuggestionProvider<ServerCommandSource> {
    @Override
    public CompletableFuture<Suggestions> getSuggestions(CommandContext<ServerCommandSource> context, SuggestionsBuilder builder) throws CommandSyntaxException {
        // suggest all roles
        if (TMMRoles.ROLES.isEmpty()) return Suggestions.empty();

        for (Role role : TMMRoles.ROLES) {
            if (RolesAmongTheTrain.VANNILA_ROLES.contains(role)) continue;
            if (role != null && CommandSource.shouldSuggest(builder.getRemaining(), role.identifier().getPath())) {
                builder.suggest(role.identifier().getPath());
            }
        }
        return builder.buildFuture();
    }
}
