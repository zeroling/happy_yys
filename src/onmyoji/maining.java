package onmyoji;

import com.sun.jna.platform.win32.WinDef;
import daily__activity.k28.tanshuo;
import daily__activity.k28.tanshuo_another;
import daily__activity.yeyuanhuo.fire;
import daily__activity.yuhun11.yuhun_driver;
import daily__activity.yuhun11.yuhun__passenger;
import daily__activity.yuling.yuling;
import hun_sea.sea_driver;
import hun_sea.sea_passenger;

import java.awt.*;
import java.util.Objects;
import java.util.Scanner;

import static Back.dpidemo.zoom;
import static java.lang.System.exit;
import static onmyoji.print.mianzhe;


/**
 * 思路:先截图,然后执行匹配算法,然后再点击,over;
 * gettask函数可以处理悬赏,请在运行mianing时的同时运行,但其中的缩放需要自己修改一下;
 *
 */
public class maining {
    public static int time = 20000;
    public static int over =0;
    public static double suofang=1;
    public static WinDef.HWND hwnd;

    public static void main(String[] args) throws AWTException {
        Scanner scanner = new Scanner(System.in);
        mianzhe();
        String get = scanner.next();
        if(Objects.equals(get, "Q") || Objects.equals(get, "q"))
        {
            exit(0);
        }
        //suofang = zoom();//注释
        System.out.println(suofang);
        System.out.println("我们已经获取您的windows缩放比例:"+suofang);
        print.print1();
        int i, j, go;
        System.out.println("---欢迎使用此脚本---");
        System.out.println("请选择功能:");
        i = scanner.nextInt();
        if (i == 1) {
            print.print2();
            System.out.println("请选择司机/打手");
            go = scanner.nextInt();
            System.out.println("输入进行次数:");
            j = scanner.nextInt();
            if(go==1)
            {
                hwnd = hwndornull.back();
                for(int m = 0 ;m<j;m++)
                {
                    try {
                        yuhun_driver.open(hwnd,suofang,time,m+1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            if(go==2)
            {
                hwnd = hwndornull.back();
                for(int m = 0 ;m<j;m++)
                {
                    try {
                        yuhun__passenger.open(hwnd,suofang,time,m+1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        if(i==2)
        {
            System.out.println("输入进行次数:");
            j = scanner.nextInt();
            hwnd = hwndornull.back();
            for(int m =0;m<j;m++)
            {
                /**
                 *打开困28的界面
                 */
                Robot r = new Robot();
                r.delay(3000);
                try {
                    tanshuo_another.open(hwnd,suofang);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                over=0;
                int bb=0;
                while(over!=999)
                {
                    /**
                     * 刷前面三个小怪
                     */
                    System.out.println("开始第"+(m+1)+"次探索");
                    while(bb<3)
                    {
                        try {
                            tanshuo.ts(hwnd,suofang);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        bb++;
                    }
                    System.out.println("开始移动地图");
                    for(int kk=0;kk<11;kk++)
                    {
                        try {
                            tanshuo_another.click(hwnd,suofang);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    while(over!=999)
                    {
                        try {
                            tanshuo.ts(hwnd,suofang);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        if(i==3)
        {
            System.out.println("输入进行次数:");
            j = scanner.nextInt();
            hwnd = hwndornull.back();
            for(int m = 0 ;m<j;m++)
            {
                try {
                    fire.open(hwnd,suofang,time,m+1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        if(i==4)///探索
        {
            System.out.println("输入进行次数:");
            j = scanner.nextInt();
            hwnd = hwndornull.back();
            for(int m = 0 ;m<j;m++)
            {
                try {
                    yuling.open(hwnd,suofang,time,m+1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        if(i==5)
        {
            print.print2();
            System.out.println("请选择司机/打手");
            go = scanner.nextInt();
            System.out.println("输入进行次数:");
            j = scanner.nextInt();
            if(go==1)
            {
                hwnd = hwndornull.back();
                for(int m = 0 ;m<j;m++)
                {
                    try {
                        sea_driver.open(hwnd,suofang,time,m+1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            if(go==2)
            {
                hwnd = hwndornull.back();
                for(int m = 0 ;m<j;m++)
                {
                    try {
                        sea_passenger.open(hwnd,suofang,time,m+1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
