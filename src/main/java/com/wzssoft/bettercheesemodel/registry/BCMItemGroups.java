package com.wzssoft.bettercheesemodel.registry;

import com.wzssoft.bettercheesemodel.BCMMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class BCMItemGroups {

    public static final ItemGroup TAB = FabricItemGroup.builder(new Identifier(BCMMod.MODID, "tab"))
            .displayName(Text.translatable("itemGroup.bettercheesemodel.tab"))
            .icon(() -> new ItemStack(BCMBlockItems.CHEESE_BLOCK_ITEM))
            .entries((displayContext, entries) -> {

                entries.add(BCMBlockItems.CHEESE_BLOCK_ITEM);
                entries.add(BCMBlockItems.MELON_BLOCK_ITEM);
                entries.add(BCMBlockItems.OXIDIZED_COPPER_BLOCK_ITEM);
                entries.add(BCMBlockItems.PODZOL_BLOCK_ITEM);
                entries.add(BCMBlockItems.BOOKSHELF_BLOCK_ITEM);
                entries.add(BCMBlockItems.OAK_LOG_BLOCK_ITEM);
                entries.add(BCMBlockItems.OAK_LEAVES_BLOCK_ITEM);
                entries.add(BCMBlockItems.GLOBE_BLOCK_ITEM);
                entries.add(BCMBlockItems.GLASS_BLOCK_ITEM);

            })
            .build();

    public static void registerModItemGroup() {
        //当执行这一行命令时，会自动执行一遍空参构造
    }
}
