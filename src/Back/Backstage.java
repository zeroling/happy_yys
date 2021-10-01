package Back;

import com.sun.jna.platform.win32.GDI32Util;
import com.sun.jna.platform.win32.WinDef;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 后台截图;
 */

public class Backstage {
    public static void shotscreen(WinDef.HWND hwnd,String path1,String path2,String path3)
    {
        BufferedImage img = GDI32Util.getScreenshot(hwnd);
        /**
         * path1==电脑/mumu模拟器
         * path2==不同的活动,挖土,御灵等
         * path3==开始/结束/检测金币
         */
        final File file = new File("src\\image\\"+path1+"\\screenshot\\"+path2+"\\"+path3+"\\"+"jietu.png");
        try {
            ImageIO.write(img, "png", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
