package Ch_1_1_Basic_Programming_Model;

import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Zive on 2018-12-17.
 */

class Point{
    double x;
    double y;
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }
}

public class Practice_1_1_31 {
    public static void drawTest(int N, double p){
        // 画大小为2， 圆心为(2, 2)的圆
        StdDraw.setXscale(-3, 3);
        StdDraw.setYscale(-3, 3);
        StdDraw.circle(0, 0, 2);
        // 将圆 N 等分，每段弧的角度为 2*pi/N
        double arc = 2 * Math.PI / N;
        double current = 0.0;
        // 保存每个点的信息
        StdDraw.setPenRadius(0.05);
        ArrayList<Point> pointArray = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            double x = 2 * Math.cos(current);
            double y = 2 * Math.sin(current);
            StdDraw.point(x, y);
            current += arc;
            pointArray.add(new Point(x, y));
        }
        // 画线
//        System.out.println(pointArray.get(0).x + " " + pointArray.get(0).y);
        StdDraw.setPenColor(Color.GRAY);
        StdDraw.setPenRadius();
        Random r = new Random();
        for (int i = 0; i < pointArray.size(); i++){
            for (int j = i+1; j < pointArray.size(); j++){
                double prob = r.nextDouble();
                if (prob < p){
//                    System.out.println(pointArray.get(i).x + " " + pointArray.get(i).y);
                    StdDraw.line(pointArray.get(i).x, pointArray.get(i).y, pointArray.get(j).x, pointArray.get(j).y);
                }
            }
        }

    }

    public static void main(String[] args) {
        drawTest(10, 0.3);
    }
}
