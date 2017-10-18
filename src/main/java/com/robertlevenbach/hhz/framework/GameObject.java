package com.robertlevenbach.hhz.framework;

import java.awt.*;
import java.util.LinkedList;

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


    public abstract void tick(LinkedList<GameObject> object);
    public abstract void render(Graphics g);

    //Dit geeft de collision bounding voor de player
    public abstract Rectangle getBounds();

    // getters en setters
    public  float getX(){
        return x;
    }
    public  float getY(){
        return y;
    }

    public  void setX(float x){
        this.x=x;
    }
    public  void setY(float y){
        this.y=y;
    }

    public  float getVelX(){
        return velX;
    }
    public  float getVelY(){
        return velY;
    }
    public  void setVelX(float x){
        this.velX=x;
    }
    public  void setVelY(float y){
        this.velY=y;
    }

    public Objectid getId(){
        return id;
    }

}
