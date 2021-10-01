package Back;

import java.awt.*;

public class dpidemo {
    public static double zoom(){


        GraphicsDevice graphDevice = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        DisplayMode disMode = graphDevice.getDisplayMode();
        int true_width = disMode.getWidth();
        int true_height = disMode.getHeight();
//        System.out.println(true_width);
//        System.out.println(true_height);



        Dimension screensize   =   Toolkit.getDefaultToolkit().getScreenSize();
        double width = screensize.getWidth();
        double height = screensize.getHeight();
//        System.out.println(width);
//        System.out.println(height);
        System.out.println(true_height/height);
        return true_width/width;
    }

//    public static void main(String[] args) {
//        System.out.println(zoom());
//    }
}
