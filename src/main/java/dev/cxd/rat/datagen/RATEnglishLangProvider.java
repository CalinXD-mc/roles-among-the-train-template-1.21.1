package dev.cxd.rat.datagen;

import dev.cxd.rat.RolesAmongTheTrain;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class RATEnglishLangProvider extends FabricLanguageProvider {
    public RATEnglishLangProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder tb) {
        // Items
        tb.add("item.rat.medkit", "Medkit");

        //Effects
        tb.add("effect.rat.protected", "Protected");

        // Announcements – Time Keeper
        tb.add("announcement.goals.time_keeper", "You can see how much time is left of the round.");
        tb.add("announcement.role.time_keeper", "Time Keeper");
        tb.add("announcement.win.time_keeper", "Passagers Win!");

        // Announcements – Apathetic
        tb.add("announcement.goals.apathetic", "You don't have a Mood.");
        tb.add("announcement.role.apathetic", "Apathetic");
        tb.add("announcement.win.apathetic", "Passagers Win!");

        // Announcements – Toxicologist
        tb.add("announcement.goals.toxicologist", "You can tell if something is Poisoned.");
        tb.add("announcement.role.toxicologist", "Toxicologist");
        tb.add("announcement.win.toxicologist", "Passagers Win!");

        // Announcements – Doctor
        tb.add("announcement.goals.toxicologist", "You get a Medkit that can save someone's life.");
        tb.add("announcement.role.toxicologist", "Doctor");
        tb.add("announcement.win.toxicologist", "Passagers Win!");

        // Commands – setenabledrole
        tb.add("commands.setenabledrole.unchanged", "Nothing changed");
        tb.add("commands.setenabledrole.invalid", "Invalid role name");
        tb.add("commands.setenabledrole.enable.success", "Role %s has been enabled");
        tb.add("commands.setenabledrole.disable.success", "Role %s has been disabled");

        // Commands – forcerole
        tb.add("commands.forcerole.invalid", "Invalid role name");
        tb.add("commands.forcerole.success", "Forced role %s to player %s");
        tb.add("commands.forcerole.query", "Player %s is forced to have role %s");
        tb.add("commands.forcerole.query.none", "Player %s does not have a forced role");
    }
}
