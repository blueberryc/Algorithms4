package Ch_1_1_Basic_Programming_Model;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Zive on 2018-12-18.
 */
public class Practice_1_1_36 {
    // 对数组随机排序，通过交换数组的位置
    public static void shuffle(double[] a){
        int N = a.length;
        Random rand = new Random();
        for (int i = 0; i < N; i++) {
            int r = i + rand.nextInt(N - i);
            double temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    public static void shuffle(int[] a){
        int N = a.length;
        Random rand = new Random();
        for (int i = 0; i < N; i++) {
            int r = i + rand.nextInt(N - i);
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    public static void ShuffleTest(int M, int N){
        // 数组初始化
        int[] arr = new int[M];
        int[][] res = new int[M][M];
        for (int j = 0; j < N; j++){
            // 打乱N次
            for (int i = 0; i < M; i++){
                arr[i] = i;
            }
            // 对数组进行乱序
            shuffle(arr);
            // 统计位置
            for (int i = 0; i < M; i++){
                // 数 arr[i] 落到位置 i
                res[arr[i]][i] += 1;
            }
        }
        // 打印数组
        for (int i = 0; i < res.length; i++){
            for (int j = 0; j < res[i].length; j++){
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static double[] generateRandomArray(int size){
        double[] res = new double[size];
        DecimalFormat df3 = new DecimalFormat("#.###");
        Random r = new Random();
        for (int i = 0; i < size; i++){
            res[i] = Double.parseDouble(df3.format(r.nextDouble()));
        }
        return res;
    }
    public static void main(String[] args) {
        double[] arr = generateRandomArray(10);
        System.out.println(Arrays.toString(arr));
        System.out.println("=====随机排序=====");
        shuffle(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("=====数组乱序=====");
        ShuffleTest(5, 500);
    }
}
