package com.robertlevenbach.hhz.window;

import com.robertlevenbach.hhz.Objects.Block;
import com.robertlevenbach.hhz.Objects.Player;
import com.robertlevenbach.hhz.framework.GameObject;
import com.robertlevenbach.hhz.framework.Objectid;

import java.awt.*;
import java.util.LinkedList;

/**
 * Deze class geeft een overzicht van alle gameObjecten die gemaakt worden
 * Zo hoef je ze niet de hele tijd apart in de Game class aan te maken
 */
public class Handler {
    public LinkedList<GameObject> objects = new LinkedList<GameObject>();


    private GameObject tempObject;

    /**
     * nu een method die de list rendered en update
     * Hij gaat(aan de hand van de grootte van de LinkedList
     * Loopen door de objecten, waarna hij tempobject dat object maakt
     */

    public void tick(){
        for(int i =0; i<objects.size();i++){
            tempObject=objects.get(i);

            tempObject.tick(objects);
        }
    }

    public void render(Graphics g){
        for(int i =0; i<objects.size();i++){
            tempObject=objects.get(i);

            tempObject.render(g);
        }
    }

    /**
     *  Methode om objecten toe te voegen
     */

    public void addObject(GameObject object){
        this.objects.add(object);
    }

    /**
     * Methode om objecten te removen
     */

    public void removeObject(GameObject object){
        this.objects.remove(object);
    }

    /**
     * Method om een level te creëren
     */

    public void createLevel(){

        for(int xx=0;xx<Game.WIDTH+32;xx+= 32) {
            addObject(new Block(xx, Game.HEIGHT-32, Objectid.Block ));
        }
        for(int yy=0;yy<Game.HEIGHT;yy+=32){
            addObject((new Block(Game.WIDTH-33,yy, Objectid.Block)));
        }
        for(int yy=0;yy<Game.HEIGHT;yy+=32){
            addObject((new Block(0,yy, Objectid.Block)));
        }

    }

}
