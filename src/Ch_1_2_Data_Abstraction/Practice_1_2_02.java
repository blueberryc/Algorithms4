package Ch_1_2_Data_Abstraction;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdDraw;

import java.util.Random;

/**
 * Created by Zive on 2019-01-07.
 */
public class Practice_1_2_02 {
    public static void printIntersect(int N){
//        StdDraw.setXscale(0, 100);
//        StdDraw.setYscale(0, 100);

        // 随机生成N个间隔
        Interval1D[] intersect1D = new Interval1D[N];
        Random loRand = new Random(10);
        Random hiRand = new Random(30);
        for (int i = 0; i < N; i++) {
            double lo = loRand.nextDouble() * 100;
            double hi = hiRand.nextDouble() * 100;
            if (hi < lo){
                intersect1D[i] = new Interval1D(hi, lo);
            }else {
                intersect1D[i] = new Interval1D(lo, hi);
            }
        }
        int count = 0;
        for (int i = 0; i < N; i++){
            for (int j = i+1; j < N; j++) {
                if (intersect1D[i].intersects(intersect1D[j])){
                    count++;
                    System.out.println(intersect1D[i] + " and " + intersect1D[j] + " intersect");
                }
            }
        }
        System.out.println("相交区间数目：" + count);
    }

    public static void main(String[] args) {
        printIntersect(50);
    }
}
