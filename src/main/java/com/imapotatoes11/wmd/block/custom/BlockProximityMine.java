package com.imapotatoes11.wmd.block.custom;

import com.imapotatoes11.wmd.item.custom.EntityExplosiveArrow;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SculkSensorBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class BlockProximityMine extends Block {
    private double tick=0;
    public BlockProximityMine(Settings settings){
        super(settings);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        Random random=new Random();
        EntityExplosiveArrow explosiveArrow = new EntityExplosiveArrow(EntityType.ARROW,world);
        explosiveArrow.setPos(pos.getX(),pos.getY()+1.25,pos.getZ());
        for(int i=0;i<50;i++){
            explosiveArrow.setPos(pos.getX()+0.5+random.nextDouble(-0.5,0.5),
                    pos.getY()+1.25+random.nextDouble(-0.5,0.5),
                    pos.getZ()+0.5+random.nextDouble(-0.5,0.5)
            );
            world.spawnEntity(explosiveArrow);
        }
        super.onSteppedOn(world, pos, state, entity);
    }
}
