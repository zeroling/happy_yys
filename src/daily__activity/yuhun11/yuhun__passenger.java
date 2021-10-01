package daily__activity.yuhun11;

import Back.Backclick;
import Match_opencv.matchop;
import com.sun.jna.platform.win32.WinDef;
import onmyoji.maining;
import opencv.Aboutopencv;
import time.Aboutrandom;

import java.awt.*;

public class yuhun__passenger {
    public static void open(WinDef.HWND hwnd, double suofang, int time, int times) throws Exception {
        /**
         * 魂11的逻辑
         * 1.组队点击挑战,进去之后检测怪物血条,判断是否成功进入游戏
         * 2.结束时点击胜利,然后检测金币,使用位置偏移退出
         */
        Robot r = new Robot();
        /**
         * 点击挑战
         * 在点击挑战之后进行判断,看是否检测到大蛇,如果没检测到,,则重新进行点击
         */
        double ifin=0;//判断是否点击进去了
        int flags=1;
        long open = 0;
        while(flags<5)
        {
            flags=10;
            r.delay(5000);
            int tt=1;
            for(int go=0;go<3;go++)
            {
                ifin=matchop.dotwo(hwnd,"cmp","hun11","flag","flag");
                if(ifin>0.8&&tt!=0)
                {
                    System.out.println("成功进入魂土");
                    tt=0;
                    System.out.println("成功开始第"+times+"次");
                }
                open = Aboutrandom.thetime();
            }
            if(ifin<0.8&&tt==1)
            {
                System.out.println("未成功进入");
                flags=1;
            }
        }
        /**
         * 第三次间隔为本局的总时长减去大约20秒;
         */
        r.delay(time-15000);//暂未统计游戏时长;
        /**
         * 这里是点击胜利到弹出达摩的时长,有一个2s左右的随机;
         */
        if(matchop.doone(hwnd,"cmp","hun11","victory","victory")>0.8)
        {
            System.out.println("检测到结束");
            r.delay( Aboutrandom.test(times));
            int x2=(int)(Aboutrandom.cd(Aboutopencv.shotx, Aboutopencv.imagex)*suofang);
            int y2=(int)(Aboutrandom.cd(Aboutopencv.shoty, Aboutopencv.imagey)*suofang);
            Backclick.doMouseByPostMessage(hwnd,x2,y2);
        }
        r.delay(1250);
        if(matchop.doone(hwnd,"cmp","hun11","jingbi","jingbi")>0.8)
        {
            System.out.println("检测到金币");
//            r.delay( Aboutrandom.test(times));
//            int x2=(int)(Aboutrandom.cd(Aboutopencv.shotx, Aboutopencv.imagex)*suofang);
//            int y2=(int)(Aboutrandom.cd(Aboutopencv.shoty, Aboutopencv.imagey)*suofang);
//            Backclick.doMouseByPostMessage(hwnd,x2,y2+(int)(170*maining.suofang));//金币进行偏移
            if(matchop.doone(hwnd,"cmp","hun11","jingbi","damo")>0.8)
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
