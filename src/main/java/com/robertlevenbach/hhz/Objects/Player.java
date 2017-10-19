package com.robertlevenbach.hhz.Objects;

import com.robertlevenbach.hhz.framework.GameObject;
import com.robertlevenbach.hhz.framework.Objectid;
import com.robertlevenbach.hhz.window.Handler;

import java.awt.*;
import java.util.LinkedList;

public class Player extends GameObject {
    private float width= 48;
    private float height=96;
    private float gravity = 0.05f;
    private final float MAX_SPEED=10;

    private Handler handler;

    public Player(float x, float y, Handler handler, Objectid id) {
        super(x, y, id);
        this.handler=handler;
    }

    public void tick(LinkedList<GameObject> object) {

        //Gravity regelen
        x+= velX;
        y+= velY;

        if(falling || jumping == true){
            velY+= gravity;

            //Velocity controleren op max
            if(velY>MAX_SPEED){
                velY=MAX_SPEED;
            }

        }
        Collision(object);
    }

    private void Collision(LinkedList<GameObject> object){
        for(int i=0; i< handler.objects.size(); i++){
            GameObject tempObject = handler.objects.get(i);

            if(tempObject.getId()==Objectid.Block){
                if(getBounds().intersects(tempObject.getBounds())){
                    velY=0;
                    falling=false;
                    jumping=false;
                }
            }
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect((int)x,(int)y,(int)width,(int)height);

        // je gaat nu van g een 2d g maken om de collision boxes te maken
        Graphics2D g2d = (Graphics2D) g;

        g.setColor(Color.BLACK);
        g2d.draw(getBounds());
        g2d.draw(getBoundsRight());
        g2d.draw(getBoundsLeft());
        g2d.draw(getBoundsTop());
    }

    public Rectangle getBounds() {
        return new Rectangle((int) ((int)x+(width/2)-( width/2)/2), (int) ((int)y+(height/2)),(int)width/2,(int)height/2);
    }
    public Rectangle getBoundsTop() {
        return new Rectangle((int) ((int)x+(width/2)-(width/2)/2),(int)y,(int)width/2,(int)height/2);
    }
    public Rectangle getBoundsRight() {
        return new Rectangle((int) ((int)x+width-5),(int)y+5,(int)5,(int)height-10);
    }
    public Rectangle getBoundsLeft() {
        return new Rectangle((int)x,(int)y+5,(int)5,(int)height-10);
    }

}
