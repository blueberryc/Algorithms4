package Ch_1_1_Basic_Programming_Model;

import java.sql.Time;
import java.util.HashSet;
import java.util.Random;

/**
 * Created by Zive on 2018-12-18.
 */
public class Practice_1_1_39 {
    public static double findCopy(int T, int N){
        /**
         * 该方法进行了重复计算，即
         * arr1 = {1, 2, 3, 5}
         * arr2 = {1, 1, 2, 4}
         * 此时相同的数
         * */
        int sumCount = 0;
        HashSet<Integer> container1 = new HashSet<>();
        HashSet<Integer> container2 = new HashSet<>();
        int[] array1 = new int[N];
        int[] array2 = new int[N];
        for (int i = 0; i < T; i++) {
            // 进行T次实验
            Random rand1 = new Random();
            Random rand2 = new Random();
            // 清空集合
            container1.clear();
            container2.clear();
            for (int j = 0; j < N; j++) {
                array1[j] = rand1.nextInt(899999) + 100000;
                array2[j] = rand2.nextInt(899999) + 100000;
            }
            for (int j = 0; j < N; j++) {
                container1.add(array1[j]);
                container2.add(array2[j]);
            }
            // 求两个集合的交集
            container1.retainAll(container2);
            sumCount += container1.size();
        }
        return sumCount * 1.0 / T;
    }

    public static void main(String[] args) {
        System.out.println(findCopy(1000, 100000));
    }

    /**
     * output:
     *   T 10000 N 1000 --> 1.1105
     *   T 10000 N 10000 --> 109.9077
     *   T 1000  N 100000 --> 9956.027
     * */
}
