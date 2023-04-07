package com.wzssoft.bettercheesemodel.registry;

import com.wzssoft.bettercheesemodel.BCMMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;


public class BCMBlockItems {

    public static final Item CHEESE_BLOCK_ITEM = registerBlockItem("cheese",
            new BlockItem(BCMBlocks.CHEESE_BLOCK, new FabricItemSettings().rarity(Rarity.COMMON)));

    public static final Item MELON_BLOCK_ITEM = registerBlockItem("melon",
            new BlockItem(BCMBlocks.MELON_BLOCK, new FabricItemSettings().rarity(Rarity.COMMON)));

    public static final Item OXIDIZED_COPPER_BLOCK_ITEM = registerBlockItem("oxidized_copper",
            new BlockItem(BCMBlocks.OXIDIZED_COPPER_BLOCK, new FabricItemSettings().rarity(Rarity.COMMON)));

    public static final Item PODZOL_BLOCK_ITEM = registerBlockItem("podzol",
            new BlockItem(BCMBlocks.PODZOL_BLOCK, new FabricItemSettings().rarity(Rarity.COMMON)));


    public static Item registerBlockItem(String name, BlockItem blockitem) {
        return Registry.register(Registries.ITEM, new Identifier(BCMMod.MODID, name), blockitem);
    }

    public static void registerModBlockItems() {
        //当执行这一行命令时，会自动执行一遍空参构造
    }
}