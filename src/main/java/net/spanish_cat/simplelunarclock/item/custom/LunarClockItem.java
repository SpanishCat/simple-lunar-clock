package net.spanish_cat.simplelunarclock.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LunarClockItem extends Item {

    Map<Integer, String> phases = new HashMap<>();
    public static String moonPhase = "Null";
    public static int moonPhaseNum;

    public LunarClockItem(Settings settings){
        super(settings);

        // Map lunar phases
        phases.put(-1, "Waning Gibbous -> Full Moon");
        phases.put(0, "Full Moon");
        phases.put(1, "Full Moon -> Waxing Gibbous");
        phases.put(2, "Waxing Gibbous");
        phases.put(3, "Waxing Gibbous -> First Quarter");
        phases.put(4, "First Quarter");
        phases.put(5, "First Quarter -> Waxing Crescent");
        phases.put(6, "Waxing Crescent");
        phases.put(7, "Waxing Crescent -> New Moon");
        phases.put(8, "New Moon");
        phases.put(9, "New Moon -> Waning Crescent");
        phases.put(10, "Waning Crescent");
        phases.put(11, "Waning Crescent -> Third Quarter");
        phases.put(12, "Third Quarter");
        phases.put(13, "Third Quarter -> Waning Gibbous");
        phases.put(14, "Waning Gibbous");
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        // Update moon phase
        if (!world.isClient)
        {
            moonPhaseNum = world.getMoonPhase() * 2 - ((world.isDay()) ? 1 : 0);
            moonPhase = phases.get(moonPhaseNum);
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        if (world.isClient())
        {
            user.sendMessage(Text.literal(moonPhase).formatted(Formatting.BLUE), true);
        }


        return super.use(world, user, hand);
    }


    // Tooltip view
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (Screen.hasShiftDown())
        {
            tooltip.add(Text.literal(moonPhase).formatted(Formatting.BLUE));
        }

        super.appendTooltip(stack, world, tooltip, context);
    }
}
