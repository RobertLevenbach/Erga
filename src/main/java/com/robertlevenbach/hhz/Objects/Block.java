package com.robertlevenbach.hhz.Objects;

import com.robertlevenbach.hhz.framework.GameObject;
import com.robertlevenbach.hhz.framework.Objectid;
import com.robertlevenbach.hhz.framework.Texture;
import com.robertlevenbach.hhz.window.Game;

import java.awt.*;
import java.util.LinkedList;

/**
 * je maakt hem hier abstract, zodat je methodes weg kan laten van de superclass.
 * zo kan je eigen methodes toevoegen zoals jump voor de player e.d.
 */
public  class  Block extends GameObject {
    //Door deze method in de game class te maken kan je hem zo aanroepen voor alle classes
    Texture tex= Game.getInstance();
    private int type;

    public Block(float x, float y, int type, Objectid id) {
        super(x, y, id);
        this.type=type;
    }

    public void tick(LinkedList<GameObject> object) {

    }

    public void tick() {

    }

    public void render(Graphics g) {
       if(type==0){
           g.drawImage(tex.block[0],(int)x,(int)y,null);
       }
       if(type==1){
            g.drawImage(tex.block[1],(int)x,(int)y,null);
       }
    }

    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 32, 32);
    }


}
