package com.imapotatoes11.wmd;

import com.imapotatoes11.wmd.block.ModBlocks;
import com.imapotatoes11.wmd.item.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class WmdItemGroup {
    public static final ItemGroup ITEM_GROUP = FabricItemGroup.builder(
            new Identifier("wmd","wmd_items")
    )
            .displayName(Text.literal("Weapons of Mass Destruction"))
            .icon(()->new ItemStack(ModItems.AIR_STRIKE_ICBM))
            .entries((enabledFeatures, entries)->{
                for (Item entry: new Item[]{
                        ModItems.AIR_STRIKE_ICBM,
                        ModItems.AIR_STRIKE,
                        ModItems.AIR_STRIKE_PRECISION,
                        ModItems.ORBITAL_STRIKE,
                        ModItems.DEMATERIALIZER,
                        ModItems.UNBLOCKINATOR,
                        ModBlocks.NUCLEAR_WARHEAD.asItem(),
                        ModBlocks.PROXIMITY_MINE.asItem()
                }) entries.add(new ItemStack(entry));
            })
            .build();

    public static void buildItemGroup() {
        Wmd.LOGGER.info("Building item group for "+Wmd.MOD_ID);
    }
}
