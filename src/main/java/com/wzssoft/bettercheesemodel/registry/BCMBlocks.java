package com.wzssoft.bettercheesemodel.registry;

import com.wzssoft.bettercheesemodel.BCMMod;
import com.wzssoft.bettercheesemodel.common.block.CheeseBlock;
import com.wzssoft.bettercheesemodel.common.block.GlassCheeseBlock;
import com.wzssoft.bettercheesemodel.common.block.PillarCheeseBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;


public class BCMBlocks {

    public static final Block CHEESE_BLOCK = registerBlock("cheese",
            new CheeseBlock(FabricBlockSettings.of(Material.STONE, MapColor.YELLOW).strength(0.1f).sounds(BlockSoundGroup.FUNGUS)));

    public static final Block MELON_BLOCK = registerBlock("melon",
            new CheeseBlock(FabricBlockSettings.of(Material.STONE, MapColor.LIME).strength(0.1f).sounds(BlockSoundGroup.FUNGUS)));

    public static final Block OXIDIZED_COPPER_BLOCK = registerBlock("oxidized_copper",
            new CheeseBlock(FabricBlockSettings.of(Material.STONE, MapColor.TEAL).strength(0.1f).sounds(BlockSoundGroup.FUNGUS)));

    public static final Block PODZOL_BLOCK = registerBlock("podzol",
            new CheeseBlock(FabricBlockSettings.of(Material.STONE, MapColor.DIRT_BROWN).strength(0.1f).sounds(BlockSoundGroup.FUNGUS)));

    public static final Block BOOKSHELF_BLOCK = registerBlock("bookshelf",
            new CheeseBlock(FabricBlockSettings.of(Material.STONE, MapColor.OAK_TAN).strength(0.1f).sounds(BlockSoundGroup.FUNGUS)));

    public static final Block OAK_LOG_BLOCK = registerBlock("oak_log", createLogBlock(MapColor.OAK_TAN, MapColor.SPRUCE_BROWN));

    public static final Block OAK_LEAVES_BLOCK = registerBlock("oak_leaves",
            new CheeseBlock(FabricBlockSettings.of(Material.STONE, MapColor.DARK_GREEN).strength(0.1f).sounds(BlockSoundGroup.FUNGUS).nonOpaque()));

    public static final Block GLOBE_BLOCK = registerBlock("globe",
            new GlassCheeseBlock(FabricBlockSettings.of(Material.STONE, MapColor.LIGHT_BLUE).strength(0.1f).sounds(BlockSoundGroup.FUNGUS).nonOpaque()));

    public static final Block GLASS_BLOCK = registerBlock("glass",
            new GlassCheeseBlock(FabricBlockSettings.of(Material.STONE, MapColor.CLEAR).strength(0.1f).sounds(BlockSoundGroup.FUNGUS).nonOpaque()));


    //register oak block
    private static PillarCheeseBlock createLogBlock(MapColor topMapColor, MapColor sideMapColor) {
        return new PillarCheeseBlock(FabricBlockSettings.of(Material.STONE, state -> state.get(PillarCheeseBlock.AXIS) == Direction.Axis.Y ? topMapColor : sideMapColor).strength(0.1f).sounds(BlockSoundGroup.FUNGUS));
    }

    private static Block registerBlock(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(BCMMod.MODID, name), block);
    }

    public static void registerModBlock() {
        //当执行这一行命令时，会自动执行一遍空参构造
    }
}
