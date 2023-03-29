package com.imapotatoes11.wmd.item.custom;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AirStrikeICBM extends Item {

    public static final int RANGE = 100;

    public AirStrikeICBM(Settings settings){
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        HitResult hitResult = user.raycast(100, 0.0f, false);
        if (hitResult.getType() == HitResult.Type.ENTITY ||
        hitResult.getType() == HitResult.Type.BLOCK){
            Entity arrow = new EntityICBM(
                    world,
                    hitResult.getPos().x,
                    hitResult.getPos().y+128,
                    hitResult.getPos().z,
                    100.0f,
                    user
            );
            arrow.setVelocity(0,-50,0);
            world.spawnEntity(arrow);
        }
        return super.use(world, user, hand);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("Shatterer of Worlds").formatted(Formatting.DARK_RED));
        tooltip.add(Text.translatable("run.").formatted(Formatting.DARK_PURPLE).formatted(Formatting.ITALIC));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
