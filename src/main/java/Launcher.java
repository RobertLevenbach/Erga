import Screen.Animation;
import Screen.Frame;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Launcher {

    Launcher launcher;
    Frame frame;
    Animation animation;

    public static void main(String[] args){
        new Launcher().launch();
    }

    private void launch() {
        makeGame();
    }

    private void makeGame() {
//        frame = new Frame();
//        frame.buildScreen();
        animation = new Animation();
        try {
            animation.animateMethod();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
