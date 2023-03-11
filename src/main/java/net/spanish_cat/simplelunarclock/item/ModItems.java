package net.spanish_cat.simplelunarclock.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.spanish_cat.simplelunarclock.SimpleLunarClock;
import net.spanish_cat.simplelunarclock.item.custom.LunarClockItem;

public class ModItems {
    public static final Item LUNAR_CLOCK = RegisterItem("lunar_clock",
            new LunarClockItem(new FabricItemSettings()), ItemGroups.TOOLS);

    private static Item RegisterItem(String name, Item item, ItemGroup group)
    {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
        return Registry.register(Registries.ITEM, new Identifier(SimpleLunarClock.MOD_ID, name), item);
    }

    public static void RegisterModItems()
    {
        SimpleLunarClock.LOGGER.info("Registering ModItems for " + SimpleLunarClock.MOD_ID);
    }
}
