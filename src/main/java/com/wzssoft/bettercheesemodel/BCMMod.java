package com.wzssoft.bettercheesemodel;

import com.wzssoft.bettercheesemodel.registry.*;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BCMMod implements ModInitializer {

    public static final String MODID = "bettercheesemodel";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

    @Override
    public void onInitialize() {

        //BCMBlockEntityType.registerModBlockEntityType();
        BCMItems.registerModItem();
        BCMBlocks.registerModBlock();
        BCMBlockItems.registerModBlockItems();
        //BCMItemTags.registerModItemTags();
        //BCMBlockTags.registerModBlockTags();
        BCMItemGroups.registerModItemGroup();
        //BCMSoundEvents.registerModSoundEvent();
    }
}
