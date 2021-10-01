package opencv;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.opencv.core.MatOfFloat;
import org.opencv.core.MatOfInt;

public class Aboutopencv{
    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }
    public static int shotx;
    public static int shoty;
    public static int imagex;
    public static int imagey;
    public static void match(String path1,String path2)
    {
        Mat src = Imgcodecs.imread(path1);//待匹配图片
        Mat template = Imgcodecs.imread(path2);// 获取匹配模板
        int method = Imgproc.TM_CCORR_NORMED;
        int width=src.cols()-template.cols()+1;
        int height=src.rows()-template.rows()+1;
        // 创建32位模板匹配结果Mat
        Mat result=new Mat(width,height,CvType.CV_32FC1);
        Imgproc.matchTemplate(src, template, result, method);
        // 归一化 详见https://blog.csdn.net/ren365880/article/details/103923813
        Core.normalize(result, result,0, 1, Core.NORM_MINMAX, -1, new Mat());
        // 获取模板匹配结果 minMaxLoc寻找矩阵(一维数组当作向量,用Mat定义) 中最小值和最大值的位置.
        Core.MinMaxLocResult mmr = Core.minMaxLoc(result);
        // 绘制匹配到的结果 不同的参数对结果的定义不同
        double x,y;
        x = mmr.maxLoc.x;
        y = mmr.maxLoc.y;
        Imgproc.rectangle(src,new Point(x,y),new Point(x+template.cols(),y+template.rows()),new Scalar( 0, 0, 255),2,Imgproc.LINE_AA);
        shotx = (int)x;
        shoty = (int)y;
        imagex = template.cols();
        imagey = template.rows();
    }

    /**
     * Similarity(相似度比较)
     */
    public static double sl(String image1,String image2)
    {
        Mat src_1 = Imgcodecs.imread(image1);// 图片 1
        Mat src_2 = Imgcodecs.imread(image2);// 图片 2
        Mat hvs_1 = new Mat();
        Mat hvs_2 = new Mat();
        //图片转HSV
        Imgproc.cvtColor(src_1, hvs_1,Imgproc.COLOR_BGR2HSV);
        Imgproc.cvtColor(src_2, hvs_2,Imgproc.COLOR_BGR2HSV);
        Mat hist_1 = new Mat();
        Mat hist_2 = new Mat();
        //直方图计算
        Imgproc.calcHist(Stream.of(hvs_1).collect(Collectors.toList()),new MatOfInt(0),new Mat(),hist_1,new MatOfInt(255) ,new MatOfFloat(0,256));
        Imgproc.calcHist(Stream.of(hvs_2).collect(Collectors.toList()),new MatOfInt(0),new Mat(),hist_2,new MatOfInt(255) ,new MatOfFloat(0,256));
        //图片归一化
        Core.normalize(hist_1, hist_1, 1, hist_1.rows() , Core.NORM_MINMAX, -1, new Mat() );
        Core.normalize(hist_2, hist_2, 1, hist_2.rows() , Core.NORM_MINMAX, -1, new Mat() );
        return Imgproc.compareHist(hist_1,hist_2,Imgproc.CV_COMP_CORREL);
    }
}
