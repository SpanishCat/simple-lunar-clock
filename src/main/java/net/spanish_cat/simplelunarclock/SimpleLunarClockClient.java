package net.spanish_cat.simplelunarclock;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;
import net.spanish_cat.simplelunarclock.item.ModItems;
import net.spanish_cat.simplelunarclock.item.custom.LunarClockItem;

@Environment(EnvType.CLIENT)
public class SimpleLunarClockClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		SimpleLunarClock.LOGGER.info("Registering ModelPredicateProvider");

	}

	static{
			ModelPredicateProviderRegistry.register(ModItems.LUNAR_CLOCK, new Identifier(SimpleLunarClock.MOD_ID, "phase"), (itemStack, clientWorld, livingEntity, i) -> {
				if (clientWorld != null){
					LunarClockItem.moonPhaseNum = clientWorld.getMoonPhase();
				}

				return (float) LunarClockItem.moonPhaseNum / 100;
			});

		ModelPredicateProviderRegistry.register(ModItems.LUNAR_CLOCK, new Identifier(SimpleLunarClock.MOD_ID, "is_day"), (itemStack, clientWorld, livingEntity, i) -> {
			if (clientWorld != null){
				return (float) ((LunarClockItem.isDay) ? 1 : 0);
			}
			else{
				return 0.5f;
			}
		});
	}
}
