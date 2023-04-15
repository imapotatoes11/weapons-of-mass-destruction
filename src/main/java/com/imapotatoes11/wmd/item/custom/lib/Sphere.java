package com.imapotatoes11.wmd.item.custom.lib;

import net.minecraft.util.math.Vec3d;

public class Sphere {
    private int radius=0;
    private double x=0;
    private double y=0;
    private double z=0;
    public Sphere(int radius, double x, double y, double z) {
        this.radius=radius;
        this.x=x;
        this.y=y;
        this.z=z;
    }
    public Sphere(int radius) {
        this.radius=radius;
    }
    public Sphere(int radius, Vec3d offset) {
        this.x=offset.getX();
        this.y=offset.getY();
        this.z=offset.getZ();
    }

    public void addOffset(Vec3d offset) {
        this.x+=offset.getX();
        this.y+=offset.getY();
        this.z+=offset.getZ();
    }
    public void addOffset(double x, double y, double z) {
        this.x+=x;
        this.y+=y;
        this.z+=z;
    }
    public void setOffset(Vec3d offset) {
        this.x=offset.getX();
        this.y=offset.getY();
        this.z=offset.getZ();
    }
    public void setOffset(double x, double y, double z) {
        this.x=x;
        this.y=y;
        this.z=z;
    }
    public Vec3d getOffset() {
        return new Vec3d(x,y,z);
    }

    public void setRadius(int radius) {
        this.radius=radius;
    }
    public int getRadius() {
        return radius;
    }
    public void setX(double x) {
        this.x=x;
    }
    public double getX() {
        return x;
    }
    public void setY(double y) {
        this.y=y;
    }
    public double getY() {
        return y;
    }
    public void setZ(double z) {
        this.z=z;
    }
    public double getZ() {
        return z;
    }

    public boolean isIntersecting(Vec3d point) {
        return Math.pow(point.getX()-x,2)+Math.pow(point.getY()-y,2)+Math.pow(point.getZ()-z,2) <= Math.pow(radius,2);
    }
    public boolean isIntersecting(double x, double y, double z) {
        return Math.pow(x-this.x,2)+Math.pow(y-this.y,2)+Math.pow(z-this.z,2) <= Math.pow(radius,2);
    }
}
