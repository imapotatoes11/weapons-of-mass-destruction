package com.imapotatoes11.wmd.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class EntityICBM extends ArrowEntity {
    private float POWER;
    private Entity SOURCE;

    private long ticks=0;

    public EntityICBM(World world, double x, double y, double z, float power, Entity source){
        super(world, x, y, z);
        this.POWER=power;
        this.SOURCE=source;
    }

    @Override
    public void tick() {
        ticks++;
        if (ticks>50){
            this.kill();
        }
        super.tick();
    }

    private void doExplosion(Entity entity, World world, double x, double y, double z){
        world.createExplosion(entity, x, y, z, this.POWER, World.ExplosionSourceType.BLOCK);
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        this.doExplosion(this.SOURCE, this.SOURCE.getEntityWorld(),
                hitResult.getPos().x, hitResult.getPos().y, hitResult.getPos().z);
    }

    @Override
    protected void onHit(LivingEntity target) {
        super.onHit(target);
        this.doExplosion(this.SOURCE, this.SOURCE.getEntityWorld(),
                target.getX(), target.getY(), target.getZ());
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        super.onBlockHit(blockHitResult);
        this.doExplosion(this.SOURCE, this.SOURCE.getEntityWorld(),
                blockHitResult.getPos().x,
                blockHitResult.getPos().y,
                blockHitResult.getPos().z);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        this.doExplosion(this.SOURCE, this.SOURCE.getEntityWorld(),
                entityHitResult.getPos().x,
                entityHitResult.getPos().y,
                entityHitResult.getPos().z);
    }
}
