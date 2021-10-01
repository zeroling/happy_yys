package daily__activity.offer_a_reward;

import Back.Backclick;
import Back.gethwnd;
import Match_opencv.matchop;
import com.sun.jna.platform.win32.WinDef;
import onmyoji.maining;
import opencv.Aboutopencv;
import time.Aboutrandom;

import java.awt.*;

public class gettask {
    public static void task() throws Exception {
        Robot r = new Robot();
        WinDef.HWND hwnd = gethwnd.thehwnd();
        double returned;
        returned = another.dotwo(hwnd,"cmp","task","get","task");
        if(returned>0.8)
        {
            System.out.println("检测到悬赏");
            r.delay(50);
            int x2=(int)(Aboutrandom.cd(Aboutopencv.shotx, Aboutopencv.imagex)*maining.suofang);
            int y2=(int)(Aboutrandom.cd(Aboutopencv.shoty, Aboutopencv.imagey)*maining.suofang);
            System.out.println(x2+"-"+y2);
            int pianyix = (int)(170*maining.suofang);
            int pianyiy = (int)(256*maining.suofang);
            Backclick.doMouseByPostMessage(hwnd,x2+pianyix,y2+pianyiy);
            System.out.println("接取悬赏");
        }
//        if(returned<0.8)
//        {
//            System.out.println(returned);
//            System.out.println("未检测到悬赏");
//        }
    }
}

