package net.spanish_cat.simplelunarclock;

import net.fabricmc.api.ModInitializer;
import net.spanish_cat.simplelunarclock.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleLunarClock implements ModInitializer {
	public static final String MOD_ID = "simplelunarclock";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info(MOD_ID + ": Hello Fabric world!");
		ModItems.RegisterModItems();
	}
}
