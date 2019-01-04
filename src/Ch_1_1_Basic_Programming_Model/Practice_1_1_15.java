package Ch_1_1_Basic_Programming_Model;

import javax.swing.plaf.synth.SynthLookAndFeel;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Zive on 2018-12-15.
 */
public class Practice_1_1_15 {
    public static int[] histogram(int[] a, int M){
        int[] res = new int[M];
        for (int i = 0; i < a.length; i++) {
            res[a[i]] += 1;

        }
        return res;
    }

    // 生成随机数组
    public static int[] generateRandomArray(int size, int value){
        /**
         * 生成长度为 size
         * 数组元素在 [0, value) 间的随机数组
         * */
        int[] array = new int[size];
        Random r = new Random();
        for (int i = 0; i < size; i++) {
            int randNumber = r.nextInt(value);
            array[i] = randNumber;
        }
        return array;
    }

    public static void main(String[] args) {
        // 生成随机数组
        int[] array = generateRandomArray(10, 5);
        System.out.println(Arrays.toString(array));
        int[] res = histogram(array, 5);
        System.out.println(Arrays.toString(res));
    }
    /**
     * output:
     *   [1, 4, 0, 2, 2, 1, 1, 2, 2, 2]
     *   [1, 3, 5, 0, 1]
     * */
}
