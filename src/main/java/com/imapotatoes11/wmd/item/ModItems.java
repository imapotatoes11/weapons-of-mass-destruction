package com.imapotatoes11.wmd.item;

import com.imapotatoes11.wmd.Wmd;
import com.imapotatoes11.wmd.item.custom.AirStrike;
import com.imapotatoes11.wmd.item.custom.AirStrikeICBM;
import com.imapotatoes11.wmd.item.custom.ItemDematerializer;
import com.imapotatoes11.wmd.item.custom.ItemOrbitalStrike;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item AIR_STRIKE_ICBM = registerItem("air_strike_icbm",
            new AirStrikeICBM(new FabricItemSettings()));
    public static final Item AIR_STRIKE = registerItem("air_strike",
            new AirStrike(new FabricItemSettings()));

    public static final Item ORBITAL_STRIKE = registerItem("orbital_strike",
            new ItemOrbitalStrike(new FabricItemSettings()));

    public static final Item DEMATERIALIZER = registerItem("dematerializer",
            new ItemDematerializer(new FabricItemSettings()));


//    public static final ItemGroup ITEM_GROUP = FabricItemGroup.builder(
//            new Identifier("wmd","wmd_items")
//    )
//            .displayName(Text.literal("Weapons of Mass Destruction"))
//            .icon(() -> new ItemStack(AIR_STRIKE_ICBM))
//            .entries((enabledFeatures, entries) -> {
//                for (Item entry : new Item[] {
//                        AIR_STRIKE_ICBM,
//                        AIR_STRIKE
//                }) entries.add(new ItemStack(entry));
//            })
//            .build();

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(Wmd.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Wmd.LOGGER.info("Registered mod items for "+Wmd.MOD_ID);
    }
}
