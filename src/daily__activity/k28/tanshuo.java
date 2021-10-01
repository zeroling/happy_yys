package daily__activity.k28;

import Back.Backclick;
import Match_opencv.matchop;
import com.sun.jna.platform.win32.WinDef;
import onmyoji.maining;
import opencv.Aboutopencv;
import time.Aboutrandom;

import java.awt.*;

public class tanshuo{
    public static void ts(WinDef.HWND hwnd,double suofang) throws Exception {
        /**
         *探索的逻辑;
         * 1.先寻找boss,找不到找小怪✔
         * 2.因为怪物会走动,打几个怪之后就移动屏幕
         * 3.over之后点击宝箱
         * 4.进行1下一轮
         */
        Robot r = new Robot();
        /**
         * 点击boss怪物头上
         */
        double test1 = 0,test2;
        r.delay(Aboutrandom.randomtimes()+1200);
        for(int go=0;go<3;go++)
        {
            //一次悬赏的处理;
            test1=matchop.dotwo(hwnd,"cmp","k28","boss","tiaozhan");
        }
        if(test1>0.8)
        {
            //悬赏处理
            test2= matchop.dotwo(hwnd,"cmp","k28","back","back");
            if(test2>0.8)
            {
                int x=(int)(Aboutrandom.cd(Aboutopencv.shotx, Aboutopencv.imagex)*suofang);
                int y=(int)(Aboutrandom.cd(Aboutopencv.shoty, Aboutopencv.imagey)*suofang);
                System.out.println(x+"-"+y);
                Backclick.doMouseByPostMessage(hwnd,x,y);
                if(matchop.doone(hwnd,"cmp","k28","reallyover","back")>0.8)
                {
                    int x2=(int)(Aboutrandom.cd(Aboutopencv.shotx, Aboutopencv.imagex)*suofang);
                    int y2=(int)(Aboutrandom.cd(Aboutopencv.shoty, Aboutopencv.imagey)*suofang);
                    Backclick.doMouseByPostMessage(hwnd,x2,y2);
                    maining.over=999;
                    System.out.println("检测到boss,退出");
                }
            }
        }
        /**
         * 点击小怪头上;
         * 防止小怪移动bug:
         * 在点击小怪之后进行判断,看是否检测到晴明,如果没检测到,,则重新进行点击
         */
        double ifin=0;//判断是否点击进去了
        int flags=1;
        double test3;
        if(test1<0.8)
        {
            test3=matchop.doone(hwnd,"cmp","k28","small","tiaozhan");
            while(flags<5&&test3>0.8)
            {
                flags=10;
                int x1=(int)(Aboutrandom.cd(Aboutopencv.shotx, Aboutopencv.imagex)*suofang);
                int y1=(int)(Aboutrandom.cd(Aboutopencv.shoty, Aboutopencv.imagey)*suofang);
                Backclick.doMouseByPostMessage(hwnd,x1,y1);
                System.out.println("点击小怪");
                r.delay(4000);
                int tt=1;
                for(int go=0;go<3;go++)
                {
                    ifin=matchop.dotwo(hwnd,"cmp","k28","flag","flag");
                    if(ifin>0.8)
                    {
                        System.out.println("成功点击目标");
                        tt=0;
                    }
                }
                if(ifin<0.8&&tt==1)
                {
                    System.out.println("点击小怪失败,重新点击");
                    flags=1;
                }
                if(flags==1)
                {
                    test3=matchop.dotwo(hwnd,"cmp","k28","small","tiaozhan");
                    //System.out.println(test3);
                }
            }
        }
        /**
         * 第三次间隔为本局的总时长减去大约20秒;
         */
        r.delay(5000);//暂未统计游戏时长;
        /**
         * 这里是点击胜利到弹出达摩的时长,有一个2s左右的随机;
         */
        if(test1<0.8)
        {
            if(matchop.doone(hwnd,"cmp","k28","jingbi","jingbi")>0.8)
            {
                System.out.println("检测到结束");
//                int x2=(int)(Aboutrandom.cd(Aboutopencv.shotx, Aboutopencv.imagex)*suofang);
//                int y2=(int)(Aboutrandom.cd(Aboutopencv.shoty, Aboutopencv.imagey)*suofang);
//                r.delay(580);
//                Backclick.doMouseByPostMessage(hwnd,x2+(int)(220*maining.suofang),y2);
                if(matchop.doone(hwnd,"cmp","k28","jingbi","damo")>0.8)
                {
                    r.delay( 500);
                    int x2=(int)(Aboutrandom.cd(Aboutopencv.shotx, Aboutopencv.imagex)*suofang);
                    int y2=(int)(Aboutrandom.cd(Aboutopencv.shoty, Aboutopencv.imagey)*suofang);
                    Backclick.doMouseByPostMessage(hwnd,x2,y2-(int)(40*maining.suofang));//金币进行偏移
                }
            }
        }
    }
}
