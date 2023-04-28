package com.imapotatoes11.wmd.item.custom.lib;

import net.fabricmc.loader.impl.lib.sat4j.core.Vec;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.math.Vec3d;

public class ParticleInfo {
    public Vec3d vec;
    public DefaultParticleType particle;
    public ParticleInfo(Vec3d vec3d, DefaultParticleType particle){
        vec=vec3d;
        this.particle=particle;
    }

    public ParticleInfo(Double x, Double y, Double z, DefaultParticleType particle){
        vec = new Vec3d(x, y, z);
        this.particle=particle;
    }

    public Vec3d getVec(){
        return vec;
    }
    public void setVec(Vec3d vec){
        this.vec=vec;
    }
    public DefaultParticleType getParticle(){
        return particle;
    }
    public void setParticle(DefaultParticleType particle_){
        this.particle = particle_;
    }

    public static ParticleInfo of(Vec3d vec3d, DefaultParticleType particle_) {
        return new ParticleInfo(vec3d, particle_);
    }
    public static ParticleInfo of(Double x, Double y, Double z, DefaultParticleType particle_){
        return new ParticleInfo(x,y,z, particle_);
    }
}
