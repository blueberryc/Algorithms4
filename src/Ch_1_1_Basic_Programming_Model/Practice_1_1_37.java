package Ch_1_1_Basic_Programming_Model;

import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;
import java.util.Random;

/**
 * Created by Zive on 2018-12-18.
 */
public class Practice_1_1_37 {

    /**
     * 糟糕的乱序
     * */
    public static void terribleShuffle(int[] a){
        int N = a.length;
        Random rand = new Random();
        for (int i = 0; i < N; i++) {
            int r = rand.nextInt(N);
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    /**
     * 正确的乱序
     * */
    public static void rightShuffle(int[] a){
        int N = a.length;
        Random rand = new Random();
        for (int i = 0; i < N; i++){
            int r = i + rand.nextInt(N - i);
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    /**
     * 记录落到每个列的次数
     * */
    public static int[][] ShuffleTest(int M, int N, boolean method){
        // 数组初始化
        int[] arr = new int[M];
        int[][] res = new int[M][M];
        for (int j = 0; j < N; j++){
            // 打乱N
            for (int i = 0; i < M; i++){
                arr[i] = i;
            }
            // 对数组进行乱序
            if (method)
                terribleShuffle(arr);
            else
                rightShuffle(arr);
            // 统计位置
            for (int i = 0; i < M; i++){
                // 数 arr[i] 落到位置 i
                res[arr[i]][i] += 1;
            }
        }
        return res;
    }

    /**
     * 计算矩阵的标准差
     * */
    public static double standardeviation(int[][] arr){
        double sum = 0;
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                sum += arr[i][j];
            }
        }
        double average = sum * 1.0 / (arr.length * arr[0].length);
        double variance = 0.0;
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                variance += Math.pow(arr[i][j] - average, 2);
            }
        }
        variance = Math.sqrt(variance / (arr.length * arr[0].length));
        return variance;
    }

    public static void twoMethodComparasion(int arrSize, int shuffleCount, int samplePointCount){
        /**
         * 通过绘制标准差图像来比较两种方法
         * 标准差小的，代表值普遍接近于平均值
         * 参数说明：
         * @parm arrSize 数组容量
         * @parm shuffleCount 打乱次数
         * @parm samplePointCount 采样点间隔，
         * */
        StdDraw.setXscale(0, shuffleCount);
        StdDraw.setYscale(0, 30);
        class Point {
            double x;
            double y;
            public Point(double x, double y){
                this.x = x;
                this.y = y;
            }
        }
        Point[] normalPoints = new Point[shuffleCount];
        Point[] terriblePoints = new Point[shuffleCount];
        for (int i = 0; i < shuffleCount; i++) {
            // 正常的打乱
            normalPoints[i] = new Point(i, standardeviation(ShuffleTest(arrSize, shuffleCount, false)));
            // 问题的打乱
            terriblePoints[i] = new Point(i, standardeviation(ShuffleTest(arrSize, shuffleCount, true)));
        }

        for (int i = 0; i + samplePointCount < shuffleCount; i += samplePointCount){
            StdDraw.setPenColor(Color.red);
            Point prev = normalPoints[i];
            Point next = normalPoints[i + samplePointCount];
            StdDraw.line(prev.x, prev.y, next.x, next.y);
        }

        for (int i = 0; i + samplePointCount < shuffleCount; i += samplePointCount){
            StdDraw.setPenColor(Color.black);
            Point prev = terriblePoints[i];
            Point next = terriblePoints[i + samplePointCount];
            StdDraw.line(prev.x, prev.y, next.x, next.y);
        }

    }

    public static void main(String[] args) {
        System.out.println("=====数组乱序=====");
        int arrSize = 10;
        int shuffleCount = 1000;
        int samplePointCount = 13;
        twoMethodComparasion(arrSize, shuffleCount, samplePointCount);
    }
}
