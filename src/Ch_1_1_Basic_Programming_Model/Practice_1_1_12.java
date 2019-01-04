package Ch_1_1_Basic_Programming_Model;

import java.util.Arrays;

/**
 * Created by Zive on 2018-12-15.
 */
public class Practice_1_1_12 {
    public static void main(String[] args) {
        int[] a = new int[10];
        System.out.println(Arrays.toString(a));
        for (int i = 0; i < 10; i++) {
            a[i] = 9 - i;
        }
        System.out.println(Arrays.toString(a));
        for (int i = 0; i < 10; i++) {
            a[i] = a[a[i]];
        }
        System.out.println(Arrays.toString(a));
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        System.out.println(Arrays.toString(a));
    }
}
