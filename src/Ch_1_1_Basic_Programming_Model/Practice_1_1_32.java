package Ch_1_1_Basic_Programming_Model;

import edu.princeton.cs.algs4.StdDraw;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Zive on 2018-12-18.
 */
public class Practice_1_1_32 {
    public static void printHistogram(int N, double l, double r){
        // 存储输入的 double 值, 输入任意字符串终止输入
        Scanner reader = new Scanner(System.in);
        ArrayList<Double> input = new ArrayList<>();
        // 利用数组记录每个区间的值的数目
        // 数组的大小为N
        int[] count = new int[N];
        double width = (r - l) / N; // 每块区间的长度
        int size = 0; // 记录输入的数的个数
        System.out.println("输入Double值：");
        while (reader.hasNextDouble()){
            size += 1;
            double number = reader.nextDouble();
            if (number < l || number >= r)
                continue;
            int index = (int)((number - l) / width);
            count[index] += 1;
        }
        // 画直方图
        StdDraw.setXscale(0, r+1);
        StdDraw.setYscale(0, size+1);
        double currentPoint = l;
        for (int i=0; i < count.length; i++){
            StdDraw.filledRectangle(currentPoint, count[i], width, count[i]);
            currentPoint += width;
        }
    }

    public static void main(String[] args) {
        printHistogram(10, 1.0, 9.0);
    }
}
