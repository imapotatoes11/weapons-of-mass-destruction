package com.imapotatoes11.wmd.item.custom;

import com.imapotatoes11.wmd.item.custom.lib.Sphere;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class Util {
    public static void voidSphere(World world, int radius, BlockPos center){
        Random random = new Random();
        // use eq of sphere and see if point intersects with sphere
        Sphere sphere = new Sphere(radius, center.getX(), center.getY(), center.getZ());
        for (int i=center.getX()-radius; i<center.getX()+radius; i++){
            for (int j = center.getY() - radius; j < center.getY() + radius; j++){
                for (int k = center.getZ() - radius; k < center.getZ() + radius; k++){
                    if (sphere.isIntersecting(i,j,k)){
                        if (
                                !world.getBlockState(new BlockPos(i, j, k)).getBlock().getName().toString().equalsIgnoreCase("bedrock")
//                                &&
//                                Util.randomChance(
//                                        (float)(1-Math.abs(i-center.getX())/radius) *
//                                                (float)(1-Math.abs(j-center.getY())/radius) *
//                                                (float)(1-Math.abs(k-center.getZ())/radius) * 10.0f
//                                )
                        ) {
                            world.breakBlock(new BlockPos(i, j, k), false);
                            world.setBlockState(new BlockPos(i, j, k), (world.getBlockState(new BlockPos(i,j-1,k)).isAir() && random.nextFloat()<0.75f) ? Blocks.AIR.getDefaultState() : Blocks.FIRE.getDefaultState());
                        }
                    }
                }
            }
        }
    }
    public static boolean randomChance(float percentChance) {
        return Math.random() < percentChance;
    }
}
