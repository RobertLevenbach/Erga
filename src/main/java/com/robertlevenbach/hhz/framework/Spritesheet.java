package com.robertlevenbach.hhz.framework;

import java.awt.image.BufferedImage;

/**
 * deze class breekt de afbeelding in individuele delen
 */
public class Spritesheet {
    private BufferedImage image;

    public Spritesheet(BufferedImage image){
        this.image=image;
    }

    public BufferedImage grabImage(int col, int row, int width, int height) {
        BufferedImage img= image.getSubimage((col*width)-width, (row*height)-height,(width),height);

        return img;
    }
}
