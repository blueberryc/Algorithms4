package Ch_1_2_Data_Abstraction;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;
import java.util.Random;

/**
 * Created by Zive on 2019-01-07.
 */
public class Practice_1_2_01 {
    public static void nearstDistance(int N){
        /**
         * 找到最近最近距离的两个点，并绘制连线
         * */
        StdDraw.setXscale(0, 100);
        StdDraw.setYscale(0, 100);
        StdDraw.setPenRadius(0.01);
        // 随机生成N个点，横纵坐标都是随机值
        Point2D[] points = new Point2D[N];
        Random x = new Random(10);
        Random y = new Random(20);
        for (int i = 0; i < N; i++) {
            points[i] = new Point2D(x.nextDouble() * 100, y.nextDouble() * 100);
            points[i].draw();
        }

        double minDistance = Double.MAX_VALUE;
        // 计算每两个节点间的距离，找到最短距离的两个节点
        int index1 = 0, index2 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                double dis = points[i].distanceTo(points[j]);
                if (dis < minDistance){
                    minDistance = dis;
                    index1 = i;
                    index2 = j;
                }
            }
        }

        // 最短距离的两个点进行连线
        StdDraw.setPenColor(Color.red);
        StdDraw.setPenRadius(0.001);
        System.out.println("两点之间的最短距离为：" + minDistance);
        StdDraw.line(points[index1].x(), points[index1].y(), points[index2].x(), points[index2].y());
    }

    public static void main(String[] args) {
        nearstDistance(50);
    }
}
