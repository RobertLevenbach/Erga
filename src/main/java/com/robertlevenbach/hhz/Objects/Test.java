package com.robertlevenbach.hhz.Objects;

import com.robertlevenbach.hhz.framework.GameObject;
import com.robertlevenbach.hhz.framework.Objectid;

import java.awt.*;

/**
 * je maakt hem hier abstract, zodat je methodes weg kan laten van de superclass.
 * zo kan je eigen methodes toevoegen zoals jump voor de player e.d.
 */
public abstract class Test extends GameObject {

    public Test(float x, float y, Objectid id) {
        super(x, y, id);
    }

    public void tick() {

    }

    public void render(Graphics g) {

    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x=x;
    }

    public void setY(float y) {
        this.y=y;
    }

    public float getVelX() {
        return velX;
    }

    public float getVelY() {
        return velY;
    }

    public void setVelX(float x) {
        this.velX=x;
    }

    public void setVelY(float y) {
        this.velY=y;
    }

    public Objectid getId() {
        return id;
    }
}
