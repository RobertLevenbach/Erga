package com.robertlevenbach.hhz.window;

import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 *
 */
public class Game extends Canvas implements Runnable {

    private boolean running=false;
    private Thread thread;


    public synchronized void start(){
        if(running==true){
            return;
        }

        running= true;
        thread= new Thread(this);
        thread.start();
    }

    /**
     * Deze class zorgt voor dat de GameLoopt
     */
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int updates = 0;
        int frames = 0;
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                tick();
                updates++;
                delta--;
            }
            render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                System.out.println("FPS: " + frames + " TICKS: " + updates);
                frames = 0;
                updates = 0;
            }
        }
    }

    private void tick(){

    }


    /**
     *  Deze class zorgt voor alles dat je gaat renderen
     *  this gaat naar de extention van Canvas in de method naam
     *  Bufferstrategy is voor: als je eerste beeld klaar is met laden, kan die een extra beeld maken alvast
     *  De 3 bepaalt het aantal schermen dat kunnen laden(incl. afgebeelde scherm)
     *  RENDER WORDT ELKE SECONDE ZIEK VAAK AANGEROEPEN
     */

    private void render(){
        //Bufferstrategy
        BufferStrategy bs = this.getBufferStrategy();
        if(bs==null){
            this.createBufferStrategy(3);
            return;
        }

        //Nu de graphics bouwen
        Graphics g = bs.getDrawGraphics();
        //////////////////////////////////// Alles wordt tussen deze lijnen getekend!



        ////////////////////////////////
        g.dispose();
        bs.show();

    }


    public static void main(String[] args){
        new Window(800, 600, "HHZ Platformer", new Game());
    }

}
