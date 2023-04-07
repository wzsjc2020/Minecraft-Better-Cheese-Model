package com.wzssoft.bettercheesemodel.registry;


import com.wzssoft.bettercheesemodel.BCMMod;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class BCMItems {
    //public static final Item CRUSHED_GOLD_ORE = registerItem("crushed_gold_ore", new Item(new FabricItemSettings().rarity(Rarity.COMMON)));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(BCMMod.MODID, name), item);
    }

    public static void registerModItem() {
        //当执行这一行命令时，会自动执行一遍空参构造
    }
}
