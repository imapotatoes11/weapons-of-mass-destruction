package com.imapotatoes11.wmd.item;

import com.imapotatoes11.wmd.Wmd;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(Wmd.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Wmd.LOGGER.info("Registered mod items for "+Wmd.MOD_ID);
    }
}
