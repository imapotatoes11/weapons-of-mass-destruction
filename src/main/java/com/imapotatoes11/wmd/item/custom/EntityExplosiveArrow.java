package com.imapotatoes11.wmd.item.custom;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityExplosiveArrow extends TridentEntity {
    public boolean chaos=false;
//    public EntityExplosiveArrow(World world, double x, double y, double z){
//        super(world,x,y,z);
//    }
    public EntityExplosiveArrow(EntityType entityType, World world, boolean chaos){super(entityType,world); this.chaos=chaos;}
    public EntityExplosiveArrow(EntityType entityType, World world){
        super(entityType,world);
    }

    private static BlockPos[] randomPos(int amount, BlockPos bound1, BlockPos bound2){
        BlockPos[] posList = new BlockPos[amount];
        for (int i = 0; i < amount; i++) {
            posList[i] = new BlockPos(
                    (int) (Math.random() * (bound2.getX() - bound1.getX()) + bound1.getX()),
                    (int) (Math.random() * (bound2.getY() - bound1.getY()) + bound1.getY()),
                    (int) (Math.random() * (bound2.getZ() - bound1.getZ()) + bound1.getZ())
            );
        }
        return posList;
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        if (!this.chaos) {
            world.createExplosion(
                    MinecraftClient.getInstance().player,
                    entityHitResult.getPos().x,
                    entityHitResult.getPos().y,
                    entityHitResult.getPos().z,
                    10.0F, // default 5.0F
                    World.ExplosionSourceType.TNT
            );
            this.kill();
            super.onEntityHit(entityHitResult);
        }
        else{
//            world.createExplosion(
//                    MinecraftClient.getInstance().player,
//                    entityHitResult.getPos().x,
//                    entityHitResult.getPos().y,
//                    entityHitResult.getPos().z,
//                    100.0F, // default 5.0F
//                    Explosion.DestructionType.BREAK
//            );

            BlockPos[] positions = randomPos(
                    50,
                    new BlockPos(
                            (int) (entityHitResult.getPos().x-25),
                            (int) (entityHitResult.getPos().y-25),
                            (int) (entityHitResult.getPos().z-25)),
                    new BlockPos(
                            (int) (entityHitResult.getPos().x+25),
                            (int) (entityHitResult.getPos().y+25),
                            (int) (entityHitResult.getPos().z+25)));
            for (BlockPos pos : positions) {
                world.createExplosion(
                        MinecraftClient.getInstance().player,
                        pos.getX(),
                        pos.getY(),
                        pos.getZ(),
                        random.nextFloat()*50,
                        World.ExplosionSourceType.TNT
                );
            }

            this.kill();
            super.onEntityHit(entityHitResult);
        }
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        if (!this.chaos) {
            world.createExplosion(
                    MinecraftClient.getInstance().player,
                    blockHitResult.getPos().x,
                    blockHitResult.getPos().y,
                    blockHitResult.getPos().z,
                    5.0F,
                    World.ExplosionSourceType.TNT
            );
            this.kill();
            super.onBlockHit(blockHitResult);
        }
        else{
//            world.createExplosion(
//                    MinecraftClient.getInstance().player,
//                    blockHitResult.getPos().x,
//                    blockHitResult.getPos().y,
//                    blockHitResult.getPos().z,
//                    100.0F,
//                    Explosion.DestructionType.BREAK
//            );
            BlockPos[] positions = randomPos(
                    50,
                    new BlockPos(
                            (int) (blockHitResult.getPos().x-25),
                            (int) (blockHitResult.getPos().y-25),
                            (int) (blockHitResult.getPos().z-25)),
                    new BlockPos(
                            (int) (blockHitResult.getPos().x+25),
                            (int) (blockHitResult.getPos().y+25),
                            (int) (blockHitResult.getPos().z+25)));
            for (BlockPos pos : positions) {
                world.createExplosion(
                        MinecraftClient.getInstance().player,
                        pos.getX(),
                        pos.getY(),
                        pos.getZ(),
                        random.nextFloat()*50,
                        World.ExplosionSourceType.TNT
                );
            }
            this.kill();
            super.onBlockHit(blockHitResult);
        }
    }
}
