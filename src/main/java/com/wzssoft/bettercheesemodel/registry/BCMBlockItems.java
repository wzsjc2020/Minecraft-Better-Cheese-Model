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

    public static final Item BOOKSHELF_BLOCK_ITEM = registerBlockItem("bookshelf",
            new BlockItem(BCMBlocks.BOOKSHELF_BLOCK, new FabricItemSettings().rarity(Rarity.COMMON)));

    public static final Item OAK_LOG_BLOCK_ITEM = registerBlockItem("oak_log",
            new BlockItem(BCMBlocks.OAK_LOG_BLOCK, new FabricItemSettings().rarity(Rarity.COMMON)));

    public static final Item OAK_LEAVES_BLOCK_ITEM = registerBlockItem("oak_leaves",
            new BlockItem(BCMBlocks.OAK_LEAVES_BLOCK, new FabricItemSettings().rarity(Rarity.COMMON)));

    public static final Item GLOBE_BLOCK_ITEM = registerBlockItem("globe",
            new BlockItem(BCMBlocks.GLOBE_BLOCK, new FabricItemSettings().rarity(Rarity.COMMON)));

    public static final Item GLASS_BLOCK_ITEM = registerBlockItem("glass",
            new BlockItem(BCMBlocks.GLASS_BLOCK, new FabricItemSettings().rarity(Rarity.COMMON)));


    public static Item registerBlockItem(String name, BlockItem blockitem) {
        return Registry.register(Registries.ITEM, new Identifier(BCMMod.MODID, name), blockitem);
    }

    public static void registerModBlockItems() {
        //当执行这一行命令时，会自动执行一遍空参构造
    }
}
