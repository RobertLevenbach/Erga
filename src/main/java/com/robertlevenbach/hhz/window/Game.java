package com.robertlevenbach.hhz.window;


import com.robertlevenbach.hhz.Objects.Block;
import com.robertlevenbach.hhz.Objects.Player;
import com.robertlevenbach.hhz.framework.GameObject;
import com.robertlevenbach.hhz.framework.KeyInput;
import com.robertlevenbach.hhz.framework.Objectid;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

/**
 * Alle objecten(spelers, guns, etc.) in het spel extenden deze class "Game"> alleen effecten niet.
 */
public class Game extends Canvas implements Runnable {

    private boolean running=false;
    private Thread thread;

    public static int WIDTH, HEIGHT;

    private BufferedImage level = null;

    //objecten
    Handler handler;
    Camera cam;

    //init methode start alles voor de loop(dus bouwt alles op)
    private void init() {
        WIDTH= getWidth();
        HEIGHT=getHeight();

        BufferedImageLoader loader= new BufferedImageLoader();

        //Loading the level

        handler=new Handler();

        cam=new Camera(0,0);
        level=loader.loadImage("/LevelFirst.png");

        loadImageLevel(level);

        //handler.addObject(new Player(100, 100,handler, Objectid.Player));
        //handler.createLevel();

        this.addKeyListener(new KeyInput((handler)));

    }

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
        init();
        this.requestFocus();
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

    /**
     * hier alles dat moet ticken
     */

    private void tick(){
        handler.tick();
        for(int i=0; i<handler.objects.size();i++) {
            if(handler.objects.get(i).getId()==Objectid.Player) {
                cam.tick(handler.objects.get(i));
            }
        }
    }


    /**
     *  Deze class zorgt voor alles dat je gaat renderen
     *  "this" gaat naar de extention van Canvas in de method naam
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
        //Voor de camera 'cast' je nu graphics 2d, dit doe je voor de functie translate die hieronder wordt gebruikt
        Graphics2D g2d = (Graphics2D) g;
        //////////////////////////////////// Alles wordt tussen deze lijnen getekend!
        g.setColor(Color.BLUE);
        g.fillRect(0,0, getWidth(), getHeight());

        //Deze zin hieronder translates alles dat die sandwiched> alles hiertussen wordt door de camera ge-effect
        g2d.translate(cam.getX(), cam.getY());                          // begin of cam
        handler.render(g);

        g2d.translate(-cam.getX(), -cam.getY());                         // end of cam
        ////////////////////////////////
        g.dispose();
        bs.show();

    }

    /**
     * Nieuwe methode voor image level loader
     */

    public void loadImageLevel(BufferedImage image){
        int w= image.getWidth();
        int h= image.getHeight();

        //loopen door elke pixel vd image
        for(int xx=0;xx<h;xx++){
            for(int yy=0; yy <w;yy++){
                //dit geeft voor elke pixel een RGB value. Lees: welke kleur die is
                int pixel= image.getRGB(xx,yy);
                int red = (pixel>> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue=  (pixel) & 0xff;

                //255 is max colorspectrum
                //Bij alle drie weetje dat je wit hebt!
                if(red == 255 && green ==255 && blue==255) {
                    handler.addObject(new Block(xx * 32, yy * 32, Objectid.Block));
                    System.out.println(red+ " "+ green+ " "+blue);
                }

                if(red == 0 && green==255 && blue==0 ) {
                    handler.addObject(new Player(100, 100,handler, Objectid.Player));
                }

            }
        }

    }


    public static void main(String[] args){
        new Window(800, 600, "HHZ Platformer", new Game());
    }

}
