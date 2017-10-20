package com.robertlevenbach.hhz.framework;

import com.robertlevenbach.hhz.window.BufferedImageLoader;

import java.awt.image.BufferedImage;

/**
 * deze class loadt alle textures in de game
 */
public class Texture {
    Spritesheet bs, ps;
    private BufferedImage block_sheet=null;
    private BufferedImage player_sheet=null;

    //getal is aantal blokken dat er zijn
    public BufferedImage[] block= new BufferedImage[2];
    public BufferedImage[] player= new BufferedImage[2];


    public Texture(){
        //load de sheets
        BufferedImageLoader loader=new BufferedImageLoader();
        try{
            block_sheet= loader.loadImage("/blockGoogle.png");
            player_sheet=loader.loadImage("/playerGoogle.png");
        }catch(Exception e){
            e.printStackTrace();
        }

        bs=new Spritesheet(block_sheet);
        ps=new Spritesheet(player_sheet);

        getTextures();
    }

    private void getTextures() {
        block[0]=bs.grabImage(1,1,32,32);  //eerste block
        block[1]=bs.grabImage(1,3,32,32);  //tweede block

        player[0]=bs.grabImage(3,2,32,32);
        player[1]=ps.grabImage(1,6,32,32);


    }


}
