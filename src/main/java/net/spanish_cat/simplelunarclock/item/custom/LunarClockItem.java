package net.spanish_cat.simplelunarclock.item.custom;

import com.mojang.blaze3d.systems.RenderCall;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TimeHelper;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.minecraft.world.tick.Tick;
import net.minecraft.world.tick.TickScheduler;
import net.spanish_cat.simplelunarclock.SimpleLunarClock;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LunarClockItem extends Item {

    Map<Integer, String> phases = new HashMap<>();
    public static String moonPhase = "Null";
    public static int moonPhaseNum = -1;
    public static Boolean isDay;

    public LunarClockItem(Settings settings){
        super(settings);

        // Map lunar phases
        phases.put(-1, "Null");
        phases.put(0, "Full Moon");
        phases.put(1, "Waxing Gibbous");
        phases.put(2, "First Quarter");
        phases.put(3, "Waxing Crescent");
        phases.put(4, "New Moon");
        phases.put(5, "Waning Crescent");
        phases.put(6, "Third Quarter");
        phases.put(7, "Waning Gibbous");
    }
//
//    @Override
//    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
//
//        if (world.isClient())
//        {
//            moonPhaseNum = world.getMoonPhase();
//            moonPhase = phases.get(moonPhaseNum);
//
////            SimpleLunarClock.LOGGER.info("Clock updated");
//        }
//
//        super.inventoryTick(stack, world, entity, slot, selected);
//    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        moonPhase = "Null";

        if (!world.isClient())
        {
            isDay = world.isDay();
            moonPhaseNum = world.getMoonPhase();
            moonPhase = phases.get(moonPhaseNum);
            user.sendMessage(Text.literal(moonPhase).formatted(Formatting.BLUE), true);
//            user.sendMessage(Text.literal(Boolean.toString(world.isDay())).formatted(Formatting.BLUE));
//            user.sendMessage(Text.literal(Float.toString(moonPhaseNum / 100.0f)).formatted(Formatting.BLUE));

        }


        return super.use(world, user, hand);
    }


    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (Screen.hasShiftDown()){
            tooltip.add(Text.literal(moonPhase).formatted(Formatting.BLUE));
        }

        super.appendTooltip(stack, world, tooltip, context);
    }
}
