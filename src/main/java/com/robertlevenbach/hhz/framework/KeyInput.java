package com.robertlevenbach.hhz.framework;

import com.robertlevenbach.hhz.window.Handler;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{

    Handler handler;

    public KeyInput(Handler handler){
        this.handler=handler;
    }


    public void keyPressed(KeyEvent e){
        //neemt elke code van de toetst> die gaat in int key
        int key = e.getKeyCode();

        for(int i=0;i<handler.objects.size();i++){
            GameObject tempObject= handler.objects.get(i);

            //Als de player iets doet
            if(tempObject.getId()== Objectid.Player){
                //Als de player A of D klikt
                if(key==KeyEvent.VK_D) tempObject.setVelX(5);
                if(key==KeyEvent.VK_A) tempObject.setVelX(-5);
                //Als de player wilt springen
                if(key==KeyEvent.VK_W){
                        tempObject.setVelY(-10);
                }
            }
        }


        //Exit knop met escape
        if(key==KeyEvent.VK_ESCAPE){
            System.exit(1);
        }
    }

    public void keyReleased(KeyEvent e){
        //neemt elke code van de toetst> die gaat in int key
        int key = e.getKeyCode();

        for(int i=0;i<handler.objects.size();i++){
            GameObject tempObject= handler.objects.get(i);

            //Als de player iets doet
            if(tempObject.getId()== Objectid.Player){
                if(key==KeyEvent.VK_D){
                    tempObject.setVelX(0);
                }
                if(key==KeyEvent.VK_A){
                    tempObject.setVelX(0);
                }
            }
        }
    }

}
