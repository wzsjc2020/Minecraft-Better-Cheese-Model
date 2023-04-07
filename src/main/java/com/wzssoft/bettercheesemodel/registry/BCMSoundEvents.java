package com.wzssoft.bettercheesemodel.registry;

import com.wzssoft.bettercheesemodel.BCMMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class BCMSoundEvents {

    private static SoundEvent register(String name) {
        Identifier id = new Identifier(BCMMod.MODID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerModSoundEvent() {
        //当执行这一行命令时，会自动执行一遍空参构造
    }
}
