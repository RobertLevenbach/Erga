package Screen;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Frame {

public void buildScreen(){
    JFrame myFrame = new JFrame("Sample Frame");
    myFrame.setSize(300,400);
    myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    myFrame.setVisible(true);
}


}
