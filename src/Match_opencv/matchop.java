/**
 * 整合一次截图,到匹配图片,到最终返回阈值,确定是否点击的操作
 */
package Match_opencv;

import Back.Backstage;
import Thread_task.task;
import com.sun.jna.platform.win32.WinDef;
import daily__activity.offer_a_reward.gettask;
import onmyoji.maining;
import opencv.Aboutopencv;

public class matchop {
    static int flag=0;
    public static double doone(WinDef.HWND hwnd,String path1, String path2, String path3, String filename) throws Exception
    {
        /**
         * 第一个doone循环是通用的模板匹配;
         */
        gettask.task();
        double result=0;
        while(result<=0.92)
        {
            Backstage.shotscreen(hwnd,path1,path2,path3);//执行一次截图,
            Aboutopencv.match("src\\image\\"+path1+"\\screenshot\\"+path2+"\\"+path3+"\\jietu.png","src\\image\\"+path1+"\\template\\"+path2+"\\"+path3+"\\"+filename+".png");
            //上面一句话是执行一opencv的模板匹配;
            Aboutscreenshot.partshot(Aboutopencv.shotx, Aboutopencv.shoty, Aboutopencv.imagex, Aboutopencv.imagey,"src\\image\\"+path1+"\\screenshot\\"+path2+"\\"+path3+"\\"+"temp.png","src\\image\\"+path1+"\\screenshot\\"+path2+"\\"+path3+"\\"+"jietu.png");
            //截取整张图的一部分,需要修改代码,因为后台截图的图片需要重新裁剪
            result = Aboutopencv.sl("src\\image\\"+path1+"\\template\\"+path2+"\\"+path3+"\\"+filename+".png","src\\image\\"+path1+"\\screenshot\\"+path2+"\\"+path3+"\\"+"temp.png");
            //是否找出需要的图片,用part截图之后的图片与之前就截好的图片进行比较,返回一个阈值;
        }
        return result;
    }

    public static double dotwo(WinDef.HWND hwnd,String path1, String path2, String path3, String filename) throws Exception
    {
        /**
         * 第二个dotwo是专门为了检测困28的boss而进行的检测
         */
        gettask.task();
        double result=0;
        Backstage.shotscreen(hwnd,path1,path2,path3);//执行一次截图,
        Aboutopencv.match("src\\image\\"+path1+"\\screenshot\\"+path2+"\\"+path3+"\\jietu.png","src\\image\\"+path1+"\\template\\"+path2+"\\"+path3+"\\"+filename+".png");
        //上面一句话是执行一opencv的模板匹配;
        Aboutscreenshot.partshot(Aboutopencv.shotx, Aboutopencv.shoty, Aboutopencv.imagex, Aboutopencv.imagey,"src\\image\\"+path1+"\\screenshot\\"+path2+"\\"+path3+"\\"+"temp.png","src\\image\\"+path1+"\\screenshot\\"+path2+"\\"+path3+"\\"+"jietu.png");
        //截取整张图的一部分,需要修改代码,因为后台截图的图片需要重新裁剪
        result = Aboutopencv.sl("src\\image\\"+path1+"\\template\\"+path2+"\\"+path3+"\\"+filename+".png","src\\image\\"+path1+"\\screenshot\\"+path2+"\\"+path3+"\\"+"temp.png");
        //是否找出需要的图片,用part截图之后的图片与之前就截好的图片进行比较,返回一个阈值;
        return result;
    }

}
