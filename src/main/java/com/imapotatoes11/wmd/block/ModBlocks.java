package com.imapotatoes11.wmd.block;

import com.imapotatoes11.wmd.Wmd;
import com.imapotatoes11.wmd.block.custom.BlockNuclearWarhead;
import com.imapotatoes11.wmd.block.custom.BlockProximityMine;
import com.imapotatoes11.wmd.block.custom.EntityNuclearWarhead;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.mob.MagmaCubeEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModBlocks {

    public static final Block PROXIMITY_MINE = registerBlock("proximity_mine",
            new BlockProximityMine(FabricBlockSettings.of(Material.AGGREGATE)),null);

    public static final Block NUCLEAR_WARHEAD = registerBlock("nuclear_warhead",
            new BlockNuclearWarhead(FabricBlockSettings.of(Material.TNT)),null);

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
