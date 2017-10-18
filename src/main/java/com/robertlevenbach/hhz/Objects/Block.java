package com.robertlevenbach.hhz.Objects;

import com.robertlevenbach.hhz.framework.GameObject;
import com.robertlevenbach.hhz.framework.Objectid;

import java.awt.*;
import java.util.LinkedList;

/**
 * je maakt hem hier abstract, zodat je methodes weg kan laten van de superclass.
 * zo kan je eigen methodes toevoegen zoals jump voor de player e.d.
 */
public  class Block extends GameObject {

    public Block(float x, float y, Objectid id) {
        super(x, y, id);
    }

    public void tick(LinkedList<GameObject> object) {

    }

    public void tick() {

    }

    public void render(Graphics g) {
        g.setColor(Color.red);
        g.drawRect((int)x,(int)y,32,32);
    }

    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 32, 32);
    }


}
