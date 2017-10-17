package com.robertlevenbach.hhz.framework;

import java.awt.*;

public abstract class GameObject {
    /**
     * Dit zijn de basis functies die elk object moet hebben!
     */

    protected float x;
    protected float y;
    protected Objectid id;
    //velocity
    protected float velX =0;
    protected float velY=0;


    public GameObject(float x, float y, Objectid id){
        this.x=x;
        this.y=y;
        this.id=id;
    }


    public abstract void tick();
    public abstract void render(Graphics g);

    // getters en setters
    public abstract float getX();
    public abstract float getY();
    public abstract void setX(float x);
    public abstract void setY(float y);

    public abstract float getVelX();
    public abstract float getVelY();
    public abstract void setVelX(float x);
    public abstract void setVelY(float y);

    public abstract Objectid getId();

}
