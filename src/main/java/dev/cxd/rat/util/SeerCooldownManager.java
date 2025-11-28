package dev.cxd.rat.util;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SeerCooldownManager {
    private static final int COOLDOWN_TICKS = 3 * 60 * 20; // 3 minutes in ticks
    private static final Map<UUID, Long> cooldowns = new HashMap<>();

    public static boolean canUseAbility(UUID playerUUID) {
        if (!cooldowns.containsKey(playerUUID)) {
            return true;
        }

        long lastUsed = cooldowns.get(playerUUID);
        long currentTime = System.currentTimeMillis();
        long ticksPassed = (currentTime - lastUsed) / 50; // Convert ms to ticks (1 tick = 50ms)

        return ticksPassed >= COOLDOWN_TICKS;
    }

    public static void setOnCooldown(UUID playerUUID) {
        cooldowns.put(playerUUID, System.currentTimeMillis());
    }

    public static int getRemainingTicks(UUID playerUUID) {
        if (!cooldowns.containsKey(playerUUID)) {
            return 0;
        }

        long lastUsed = cooldowns.get(playerUUID);
        long currentTime = System.currentTimeMillis();
        long ticksPassed = (currentTime - lastUsed) / 50;

        return Math.max(0, (int)(COOLDOWN_TICKS - ticksPassed));
    }

    public static String getFormattedCooldown(UUID playerUUID) {
        int remainingTicks = getRemainingTicks(playerUUID);
        int seconds = remainingTicks / 20;
        int minutes = seconds / 60;
        int secs = seconds % 60;

        return String.format("%dm %ds", minutes, secs);
    }

    public static void clearCooldown(UUID playerUUID) {
        cooldowns.remove(playerUUID);
    }

    public static void clearAllCooldowns() {
        cooldowns.clear();
    }
}
