package daily__activity.k28;

import Back.Backclick;
import Match_opencv.matchop;
import com.sun.jna.platform.win32.WinDef;
import onmyoji.maining;
import opencv.Aboutopencv;
import time.Aboutrandom;

public class tanshuo_another {
    public static void back(WinDef.HWND hwnd,double suofang) throws Exception {
        //System.out.println(conformity.once());
        if (matchop.doone(hwnd,"cmp", "k28", "back", "back") > 0.8)
        {
            int x=(int)(Aboutrandom.cd(Aboutopencv.shotx, Aboutopencv.imagex)*suofang);
            int y=(int)(Aboutrandom.cd(Aboutopencv.shoty, Aboutopencv.imagey)*suofang);
            Backclick.doMouseByPostMessage(hwnd,x,y);
        }
    }

    public static void open(WinDef.HWND hwnd,double suofang) throws Exception {
        if (matchop.doone(hwnd,"cmp", "k28", "open", "tanshuo") > 0.8)
        {
            int x=(int)(Aboutrandom.cd(Aboutopencv.shotx, Aboutopencv.imagex)*suofang);
            int y=(int)(Aboutrandom.cd(Aboutopencv.shoty, Aboutopencv.imagey)*suofang);
            System.out.println(x+"---"+y);
            Backclick.doMouseByPostMessage(hwnd,x,y);
        }
    }

    public static void click(WinDef.HWND hwnd,double suofang) throws Exception
    {
        if (matchop.doone(hwnd,"cmp", "k28", "yidong", "ssl") > 0.8)
        {
            int x=(int)(Aboutrandom.cd(Aboutopencv.shotx, Aboutopencv.imagex)*suofang);
            int y=(int)(Aboutrandom.cd(Aboutopencv.shoty, Aboutopencv.imagey)*suofang);
            int pianyi = (int)(maining.suofang*605);
            Backclick.doMouseByPostMessage(hwnd,x+pianyi,y);
        }
    }
}

