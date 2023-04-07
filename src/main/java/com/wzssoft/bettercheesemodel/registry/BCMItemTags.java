package com.wzssoft.bettercheesemodel.registry;

import com.wzssoft.bettercheesemodel.BCMMod;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class BCMItemTags {

    private static TagKey<Item> of(String name) {
        return TagKey.of(RegistryKeys.ITEM,new Identifier(BCMMod.MODID, name));
    }

    public static void registerModItemTags() {
        //当执行这一行命令时，会自动执行一遍空参构造
    }
}
