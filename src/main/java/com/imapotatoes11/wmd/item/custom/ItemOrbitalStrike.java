package com.imapotatoes11.wmd.item.custom;

import com.imapotatoes11.wmd.Wmd;
import com.imapotatoes11.wmd.WmdSounds;
import net.minecraft.client.particle.CampfireSmokeParticle;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class ItemOrbitalStrike extends Item {
    private int remainingTicks = 0;
    private boolean hitStored = false;
    private HitResult hitResult;
    public ItemOrbitalStrike(Settings settings){
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        HitResult hitResult = user.raycast(256.0d, 0.0f, false);
        if (hitResult.getType() == HitResult.Type.BLOCK || hitResult.getType() == HitResult.Type.ENTITY) {
//            user.playSound(
//                    SoundEvents.ENTITY_ZOMBIE_VILLAGER_CURE,
//                    SoundCategory.PLAYERS,
//                    1F,
//                    1.5F
//            );
            this.hitResult=hitResult;
            this.remainingTicks=5;
            this.hitStored=true;
//            user.playSound(Wmd.ORBITAL_STRIKE, SoundCategory.PLAYERS, 10.0f, 1.0f);
            for (int y = -60; y < 318; y++) {
                world.addParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE,
                        hitResult.getPos().x,
                        y,
                        hitResult.getPos().z,
                        0, 0, 0);
            }
            world.playSound(null, user.getBlockPos(), Wmd.ORBITAL_STRIKE, SoundCategory.PLAYERS, 1.0f, 1.0f);
        }
        return super.use(world, user, hand);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        Random random=new Random();
        if (!(this.hitResult ==null) && !world.isClient()) {
            if ((!this.hitStored) && this.remainingTicks != 0) this.remainingTicks = 0;
            if (this.remainingTicks <= 1) {
//                for (int y = -60; y < 318; y+=10) {
//                    if (this.hitResult!=null)
////                        world.createExplosion(null, hitResult.getPos().x, y, hitResult.getPos().z, 10.0f, World.ExplosionSourceType.TNT);
//                        Util.voidSphere(world, random.nextInt(5,25), new BlockPos(
//                                (int)this.hitResult.getPos().getX() + random.nextInt(-10, 10),
//                                y,
//                                (int)this.hitResult.getPos().getZ() + random.nextInt(-10, 10)
//                        ));
//                }
                Util.voidSphere(world, 20, new BlockPos(
                        (int)this.hitResult.getPos().getX(),
                        (int)this.hitResult.getPos().getY(),
                        (int)this.hitResult.getPos().getZ()
                ));
                List<Entity> entities = world.getOtherEntities(entity, new Box(
                        this.hitResult.getPos().x-20,
                        this.hitResult.getPos().y-20,
                        this.hitResult.getPos().z-20,
                        this.hitResult.getPos().x+20,
                        this.hitResult.getPos().y+20,
                        this.hitResult.getPos().z+20
                ));
                entities.forEach( entity1 -> entity1.damage(entity.getDamageSources().generic(), 100.0f));
//                world.playSound(null, entity.getBlockPos(), Wmd.ORBITAL_STRIKE, SoundCategory.PLAYERS, 1.0f, 1.0f);
                this.hitStored = false;
                this.hitResult=null;
                this.remainingTicks=0;
            }
            this.remainingTicks--;
//            entity.playSound(Wmd.ORBITAL_STRIKE, 1.0f, 1.0f);
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }
}
