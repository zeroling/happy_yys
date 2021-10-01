package time;

import org.w3c.dom.ls.LSOutput;

import java.util.Random;

/**
 * 关于时间的操作;
 * 例如随机时间和获取时间戳的操作;
 * Abouttime
 */
public class Aboutrandom {
    public static long thetime()
    {
        return System.currentTimeMillis();
    }

    public static int randomtimes()
    {
        Random t =new Random();
        return t.nextInt(350);
    }

    public static int cd(int a,int b)//
    {
        Random t = new Random();
        return t.nextInt(b)+a;
    }

    public static int test(int times)
    {
        Random t = new Random();
        if(times>200)
        {
            times=times-200;
        }
        if(times<60)
        {
            return t.nextInt(700)+1800;
        }
        if(times<115)
        {
            return t.nextInt(1550)+2300;
        }
        if(times<=200)
        {
            return t.nextInt(2000)+2800;
        }
        return 0;
    }

//    public static void main(String[] args) {
//        for(int i=0;i<200;i++)
//        {
//            double test = ((double) test(i))/1000;
//            System.out.println(test);
//        }
//    }
}