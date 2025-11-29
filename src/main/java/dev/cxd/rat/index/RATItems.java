package dev.cxd.rat.index;

import dev.cxd.rat.RolesAmongTheTrain;
import dev.cxd.rat.items.MedkitItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class RATItems {

    public static final Item MEDKIT = register("medkit", new MedkitItem(new Item.Settings().maxCount(1)));

    public static Item register(String id, Item item) {
        Identifier itemID = Identifier.of(RolesAmongTheTrain.MOD_ID, id);

        Item registeredItem = Registry.register(Registries.ITEM, itemID, item);

        return registeredItem;
    }

    public static void initialize() {}
}
