package com.imapotatoes11.wmd;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class WmdSounds {
//    public static final SoundEvent ORBITAL_STRIKE = registerSound(new Identifier(Wmd.MOD_ID, "orbital_strike"));


    private static SoundEvent registerSound(Identifier sound){
        return Registry.register(Registries.SOUND_EVENT, sound, SoundEvent.of(sound));
    }
    public static void registerSounds(){
//        ORBITAL_STRIKE_ID = new Identifier(Wmd.MOD_ID, "orbital_strike");
//        ORBITAL_STRIKE= SoundEvent.of(ORBITAL_STRIKE_ID);
//        Registry.register(Registries.SOUND_EVENT, ORBITAL_STRIKE, SoundEvent.of(ORBITAL_STRIKE));

        Wmd.LOGGER.info("Registered sounds for "+Wmd.MOD_ID);
    }
}
