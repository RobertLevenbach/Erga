package com.robertlevenbach.hhz.window;

import com.robertlevenbach.hhz.framework.GameObject;

public class Camera{
    private float x;
    private float y;

    public Camera(float x, float y){
        this.x=x;
        this.y=y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void tick(GameObject player) {
        //camera naar de player locker
        float move = -player.getX() + Game.WIDTH/2 ;

        x += (move - x) * 0.1;

        float moveY = -player.getY() + 64+ Game.HEIGHT/2;

        y += (moveY - y) * 0.1;
    }
}
