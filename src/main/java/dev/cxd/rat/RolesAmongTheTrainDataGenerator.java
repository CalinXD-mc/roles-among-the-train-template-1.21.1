package dev.cxd.rat;

import dev.cxd.rat.datagen.RATEnglishLangProvider;
import dev.cxd.rat.datagen.RATModelProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class RolesAmongTheTrainDataGenerator implements DataGeneratorEntrypoint {

    // "./gradlew runDatagenClient"

	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(RATModelProvider::new);
        pack.addProvider(RATEnglishLangProvider::new);
	}
}
