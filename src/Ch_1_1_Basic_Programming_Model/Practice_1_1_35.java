package Ch_1_1_Basic_Programming_Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Zive on 2018-12-18.
 */
public class Practice_1_1_35 {
    /**
     * 先计算实际的概率值，即统计和的各种情况, 总情况数为 6 * 6
     * 例如 4 = 1 + 3 = 2 + 2 = 3 + 1
     * */
    public static double[] exactProb(int SIDES){
        double[] exactDist = new double[2*SIDES + 1];
        for (int i = 2; i < exactDist.length; i++){
            int count = 0;
            for (int j = 1; j <= SIDES && j < i; j++){
                if (i - j < 1 || i - j > SIDES)
                    continue;
                count += 1;
            }
            exactDist[i] = count * 1.0 / (SIDES * SIDES);
        }
        return exactDist;
    }

    /**
     * 模拟投掷骰子，产生两个区间在[1, 6]的随机整数值
     * */
    public static void testProb(int SIDES, double[] exactDist){
        double[] testDist = new double[2 * SIDES + 1];
        double[] status = new double[2 * SIDES + 1]; // 保存频率
        int N = 0;
        Random r1 = new Random();
        Random r2 = new Random();
        while (! equal(exactDist, testDist)){
            N += 1; //投掷骰子次数
            int i = r1.nextInt(SIDES) + 1;
            int j = r2.nextInt(SIDES) + 1;
            status[i+j] += 1;
            // 计算概率
            for (int x = 2; x < testDist.length; x++)
                testDist[x] = status[x] * 1.0 / N;
        }
        System.out.println(Arrays.toString(testDist));
        System.out.println("N的大小为: " + N);
    }

    /**
     * 两个浮点数数组相等
     * */
    public static boolean equal(double[] arr1, double[] arr2){
        if (arr1.length != arr2.length)
            return false;
        for (int i = 0; i < arr1.length; i++){
            if (arr1[i] - arr2[i] >= 0.0001)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        double[] exactDist = exactProb(6);
        System.out.println(Arrays.toString(exactDist));
        testProb(6, exactDist);
    }
}
