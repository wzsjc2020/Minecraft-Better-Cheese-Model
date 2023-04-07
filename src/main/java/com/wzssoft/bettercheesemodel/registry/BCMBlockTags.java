package com.wzssoft.bettercheesemodel.registry;

import com.wzssoft.bettercheesemodel.BCMMod;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;



public class BCMBlockTags {

    private static TagKey<Block> of(String name) {
        return TagKey.of(RegistryKeys.BLOCK,new Identifier(BCMMod.MODID, name));
    }

    public static void registerModBlockTags() {
        //当执行这一行命令时，会自动执行一遍空参构造
    }
}
