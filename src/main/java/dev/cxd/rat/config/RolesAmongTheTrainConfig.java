package dev.cxd.rat.config;

import dev.cxd.rat.RolesAmongTheTrain;
import dev.isxander.yacl3.config.v2.api.ConfigClassHandler;
import dev.isxander.yacl3.config.v2.api.SerialEntry;
import dev.isxander.yacl3.config.v2.api.serializer.GsonConfigSerializerBuilder;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.Identifier;

import java.util.List;

public class RolesAmongTheTrainConfig {
    public static ConfigClassHandler<RolesAmongTheTrainConfig> HANDLER = ConfigClassHandler.createBuilder(RolesAmongTheTrainConfig.class)
            .id(Identifier.of(RolesAmongTheTrain.MOD_ID, "config"))
            .serializer(config -> GsonConfigSerializerBuilder.create(config)
                    .setPath(FabricLoader.getInstance().getConfigDir().resolve( RolesAmongTheTrain.MOD_ID + ".json5"))
                    .setJson5(true)
                    .build())
            .build();

    @SerialEntry(comment = "Disables roles from being in the role pool. use /listRoles to get role names, use /enableRoles to ban/unban them in-game (saves here).")
    public List<String> disabled = List.of("");
    @SerialEntry(comment = "Whether insane players will randomly see people as morphed.")
    public boolean insanePlayersSeeMorphs = true;

}
