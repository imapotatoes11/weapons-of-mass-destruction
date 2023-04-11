package com.imapotatoes11.wmd.block;

import com.imapotatoes11.wmd.Wmd;
import com.imapotatoes11.wmd.block.custom.BlockProximityMine;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block PROXIMITY_MINE = registerBlock("proximity_mine",
            new BlockProximityMine(FabricBlockSettings.of(Material.AGGREGATE)),null);

    private static Block registerBlock(String name, Block block, ItemGroup group){
        registerBlockItem(name,block,group);
        return Registry.register(Registries.BLOCK, new Identifier(Wmd.MOD_ID,name),block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registries.ITEM, new Identifier(Wmd.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks(){
        Wmd.LOGGER.info("Registering ModBlocks for "+Wmd.MOD_ID);
    }

}
