package daily__activity.yeyuanhuo;

import Back.Backclick;
import Match_opencv.matchop;
import com.sun.jna.platform.win32.WinDef;
import onmyoji.maining;
import opencv.Aboutopencv;
import time.Aboutrandom;

import java.awt.*;

public class fire {
    public static void open(WinDef.HWND hwnd, double suofang, int time, int times) throws Exception {
        Robot r = new Robot();
        /**
         * 点击挑战
         * 在点击挑战之后进行判断,看是否检测到计时图标,如果没检测到,则重新进行点击
         */
        double ifin=0;//判断是否点击进去了
        int flags=1;
        double test3=0.5;
        r.delay( Aboutrandom.test(times));
        long open = 0;
        while(test3<0.8)
        {
            test3= matchop.doone(hwnd,"cmp","fire","open","tiaozhan");
        }
        while(flags<5&&test3>0.8)
        {
            flags=10;
            int x1=(int)(Aboutrandom.cd(Aboutopencv.shotx, Aboutopencv.imagex)*suofang);
            int y1=(int)(Aboutrandom.cd(Aboutopencv.shoty, Aboutopencv.imagey)*suofang);
            Backclick.doMouseByPostMessage(hwnd,x1,y1);
            System.out.println("点击挑战");
            System.out.println("开始第"+times+"次");
            r.delay(5000);
            int tt=1;
            for(int go=0;go<3;go++)
            {
                ifin=matchop.dotwo(hwnd,"cmp","fire","flag","flag");
                if(ifin>0.8&&tt!=0)
                {
                    System.out.println("点击成功");
                    tt=0;
                }
                open = Aboutrandom.thetime();
            }
            if(ifin<0.8&&tt==1)
            {
                System.out.println("点击挑战失败,重新点击");
                flags=1;
            }
            if(flags==1)
            {
                test3=matchop.dotwo(hwnd,"cmp","fire","open","tiaozhan");
            }
        }
        /**
         * 第三次间隔为本局的总时长减去大约20秒;
         */
        r.delay(time-15000);
        if(matchop.doone(hwnd,"cmp","fire","jingbi","jingbi")>0.8)
        {
            System.out.println("检测到金币");
//            r.delay( Aboutrandom.test(times));
//            int x2=(int)(Aboutrandom.cd(Aboutopencv.shotx, Aboutopencv.imagex)*suofang);
//            int y2=(int)(Aboutrandom.cd(Aboutopencv.shoty, Aboutopencv.imagey)*suofang);
//            Backclick.doMouseByPostMessage(hwnd,x2,y2+(int)(170*maining.suofang));//金币进行偏移
            if(matchop.doone(hwnd,"cmp","fire","jingbi","damo")>0.8)
            {
                r.delay( Aboutrandom.test(times));
                int x2=(int)(Aboutrandom.cd(Aboutopencv.shotx, Aboutopencv.imagex)*suofang);
                int y2=(int)(Aboutrandom.cd(Aboutopencv.shoty, Aboutopencv.imagey)*suofang);
                Backclick.doMouseByPostMessage(hwnd,x2,y2-(int)(40*maining.suofang));//金币进行偏移
            }
        }
        long finish = Aboutrandom.thetime();
        maining.time = (int)(finish - open);
        System.out.println("本次用时:"+time/1000+"秒");
    }
}
