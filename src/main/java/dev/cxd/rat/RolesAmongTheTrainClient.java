package dev.cxd.rat;

import dev.doctor4t.trainmurdermystery.api.Role;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class RolesAmongTheTrainClient implements ClientModInitializer {
    public static float rainbowRoleTime = 0;
    public static Role hudRole = null;

    @Override
    public void onInitializeClient() {

        ClientTickEvents.END_CLIENT_TICK.register((t)->{
            rainbowRoleTime += 1;
        });
    }
}