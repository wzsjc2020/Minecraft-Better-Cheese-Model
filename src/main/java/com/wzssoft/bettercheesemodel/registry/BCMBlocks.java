package com.wzssoft.bettercheesemodel.registry;

import com.wzssoft.bettercheesemodel.BCMMod;
import com.wzssoft.bettercheesemodel.common.block.CheeseBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;


public class BCMBlocks {

    public static final Block CHEESE_BLOCK = registerBlock("cheese",
            new CheeseBlock(FabricBlockSettings.of(Material.STONE, MapColor.YELLOW).strength(0.1f).sounds(BlockSoundGroup.FUNGUS)));

    public static final Block MELON_BLOCK = registerBlock("melon",
            new CheeseBlock(FabricBlockSettings.of(Material.STONE, MapColor.LIME).strength(0.1f).sounds(BlockSoundGroup.FUNGUS)));

    public static final Block OXIDIZED_COPPER_BLOCK = registerBlock("oxidized_copper",
            new CheeseBlock(FabricBlockSettings.of(Material.STONE, MapColor.TEAL).strength(0.1f).sounds(BlockSoundGroup.FUNGUS)));

    public static final Block PODZOL_BLOCK = registerBlock("podzol",
            new CheeseBlock(FabricBlockSettings.of(Material.STONE,MapColor.DIRT_BROWN).strength(0.1f).sounds(BlockSoundGroup.FUNGUS)));


    private static Block registerBlock(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(BCMMod.MODID, name), block);
    }

    public static void registerModBlock() {
        //当执行这一行命令时，会自动执行一遍空参构造
    }
}
