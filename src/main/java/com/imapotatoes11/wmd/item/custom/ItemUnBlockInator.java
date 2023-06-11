package com.imapotatoes11.wmd.item.custom;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.FallingBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class ItemUnBlockInator extends Item {
    public ItemUnBlockInator(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        double r = 7; // anything bigger than 10 will start lagging hard ( O(2n^3) )

        Random random=new Random();
        HitResult hitResult = user.raycast(100.0d, 0.0f, false);
        if (hitResult.getType() == HitResult.Type.BLOCK) {
            for (double x=hitResult.getPos().getX()-r;x<hitResult.getPos().getX()+r;x++) {
                for (double y = hitResult.getPos().getY()-r;y<hitResult.getPos().getY()+r;y++) {
                    for (double z=hitResult.getPos().getZ()-r;z<hitResult.getPos().getZ()+r;z++) {
                        BlockPos pos = new BlockPos((int) Math.floor(x), (int) Math.floor(y - 1), (int) Math.floor(z));
                        FallingBlockEntity fallingBlock = FallingBlockEntity.spawnFromBlock(
                                world,
                                new BlockPos((int) Math.floor(x), (int) Math.floor(y - 1), (int) Math.floor(z)),
                                world.getBlockState(new BlockPos((int) Math.floor(x), (int) Math.floor(y - 1), (int) Math.floor(z)))
                        );
                        fallingBlock.addVelocity(new Vec3d(
                                random.nextDouble(-1, 1.5),
                                random.nextDouble(0.5, 1.5),
                                random.nextDouble(-1, 1.5)));
                        fallingBlock.addVelocity(
                                -(pos.getX()-hitResult.getPos().getX())/5,
                                -(pos.getY()-hitResult.getPos().getY())/5,
                                -(pos.getZ()-hitResult.getPos().getZ())/5
                        ); // this one makes too perfect results
                        fallingBlock.setNoGravity(false);
                    }
                }
            }
        }
        return super.use(world, user, hand);
    }
}
