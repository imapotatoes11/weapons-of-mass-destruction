package com.imapotatoes11.wmd;

import com.imapotatoes11.wmd.block.ModBlocks;
import com.imapotatoes11.wmd.item.ModItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Wmd implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("modid");

	public static final String MOD_ID = "wmd";

	public static final Identifier ORBITAL_STRIKE_ID = new Identifier("wmd:orbital_strike");
	public static SoundEvent ORBITAL_STRIKE = SoundEvent.of(ORBITAL_STRIKE_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
//		WmdSounds.registerSounds();
		WmdItemGroup.buildItemGroup();

		ORBITAL_STRIKE = Registry.register(Registries.SOUND_EVENT, ORBITAL_STRIKE_ID, ORBITAL_STRIKE);
		LOGGER.info("Registered sound event: "+ORBITAL_STRIKE_ID.toString());
	}
}
