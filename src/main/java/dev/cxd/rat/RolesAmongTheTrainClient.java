package dev.cxd.rat;

import com.google.common.collect.Maps;
import dev.cxd.rat.packet.SeerScanPacket;
import dev.doctor4t.trainmurdermystery.api.Role;
import dev.doctor4t.trainmurdermystery.api.TMMRoles;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class RolesAmongTheTrainClient implements ClientModInitializer {
    private KeyBinding seerKey;
    public static float rainbowRoleTime = 0;
    public static Role hudRole = null;

    @Override
    public void onInitializeClient() {
        seerKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.rat.seer_ability",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_G,
                "key.categories.gameplay"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (seerKey.wasPressed()) {
                if (client.player != null) {
                    // Send packet to server
                    ClientPlayNetworking.send(new SeerScanPacket());
                }
            }
        });

        ClientTickEvents.END_CLIENT_TICK.register((t)->{
            rainbowRoleTime += 1;
        });
    }
}