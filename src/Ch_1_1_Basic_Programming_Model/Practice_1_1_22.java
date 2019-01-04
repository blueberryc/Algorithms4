package Ch_1_1_Basic_Programming_Model;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Zive on 2018-12-16.
 */
public class Practice_1_1_22 {
    public static int rank(int key, int[] a, int lo, int hi, int depth){
        /**
         * depth 参数记录递归的深度
         * */
        for (int i = 0; i < depth; i++)
            System.out.print("  ");
        System.out.printf("lo: %d hi: %d\n", lo, hi);
        if (lo > hi)
            return -1;
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid])
            return rank(key, a, lo, mid - 1, depth + 1);
        else if (key > a[mid])
            return rank(key, a, mid + 1, hi, depth + 1);
        else return mid;
    }

    // 生成随机长度的数组
    public static int[] generateRandomArray(int size, int value){
        int[] array = new int[size];
        Random r = new Random();
        for (int i = 0; i < array.length; i++){
            int randomNumber = r.nextInt(value);
            array[i] = randomNumber;
        }
        return array;
    }
    public static void main(String[] args) {
        // 生成随机长度的数组
        int[] a = generateRandomArray(20, 10);
        System.out.println("=====随机数组=====");
        System.out.println(Arrays.toString(a));
        // 对数组进行排序，并打印排序后的数组
        Arrays.sort(a);
        System.out.println("======排序后数组======");
        System.out.println(Arrays.toString(a));
        System.out.println("=====二分查找=====");
        int index = rank(2, a, 0, a.length - 1, 0);
        System.out.println(index);
    }
}
