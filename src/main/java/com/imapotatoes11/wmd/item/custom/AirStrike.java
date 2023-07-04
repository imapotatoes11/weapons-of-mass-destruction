package com.imapotatoes11.wmd.item.custom;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EntityType;
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
import java.util.Random;

public class AirStrike extends Item {
    public int bound = 5;
    public int precision = 25;

    public AirStrike(Settings settings){
        super(settings);
    }

    public AirStrike(Settings settings, int precision) {
        super(settings);
        this.precision = precision;
    }

    public AirStrike(Settings settings, int precision, int bound) {
        super(settings);
        this.precision = precision;
        this.bound = bound;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        Random random = new Random();

        HitResult hitResult = user.raycast(256, 0.0f, false);

        int randX, randY, randZ;
        double velX = 0; double velZ = 0;
        for (int i = 0; i < 500; i++){
            randX = (precision != 0) ? random.nextInt(-precision, precision) : 0;
            randY = random.nextInt(-bound, bound);
            randZ = (precision != 0) ? random.nextInt(-precision, precision) : 0;

//            velX = random.nextDouble(-0.25, 0.25);
//            velZ = random.nextDouble(-0.25, 0.25);

            EntityExplosiveArrow explosiveArrow = new EntityExplosiveArrow(EntityType.TRIDENT, world);
            explosiveArrow.teleport(user.getX() + randX, 256 + randY, user.getZ() + randZ);
            explosiveArrow.setVelocity(velX, 0, velZ);
            world.spawnEntity(explosiveArrow);
        }
        return super.use(world, user, hand);
    }
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("Total surface annihilation").formatted(Formatting.DARK_PURPLE));
        tooltip.add(Text.translatable("USE SPARINGLY").formatted(Formatting.DARK_PURPLE));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
