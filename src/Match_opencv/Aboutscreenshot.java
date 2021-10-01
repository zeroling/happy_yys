package Match_opencv;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * AboutScreenShot(屏幕截图操作相关)
 */
public class Aboutscreenshot {
    /**
     * 获取一整张屏幕截图(shot all screen)
     */
    public static void allshot(String path_in,String folder) throws Exception {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle screenRectangle = new Rectangle(screenSize);
        Robot robot = new Robot();
        BufferedImage image = robot.createScreenCapture(screenRectangle);
        //保存路径
        File screenFile = new File(path_in);
        File f = new File(screenFile, folder);
        ImageIO.write(image, "png", f);
    }

    /**
     * 截取图片中的一部分
     */
    public static void partshot(int openx,int openy,int h,int w,String path_in,String origin)
    {
        File sourcePic = new File(origin);
        try {
            BufferedImage pic1 = ImageIO.read(sourcePic);
            //参数依次为，截取起点的x坐标，y坐标，截取宽度，截取高度
            BufferedImage pic2 = pic1.getSubimage(openx, openy, h, w);
            //将截取的子图另行存储
            File desImage = new File(path_in);
            ImageIO.write(pic2, "png", desImage);
        }catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
