package com.imapotatoes11.wmd.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

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
            Entity arrow = new EntityExplosiveArrow(
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
}
