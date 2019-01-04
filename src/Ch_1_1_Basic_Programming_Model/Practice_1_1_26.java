package Ch_1_1_Basic_Programming_Model;

import java.util.Random;

/**
 * Created by Zive on 2018-12-16.
 */
public class Practice_1_1_26 {
    public static void main(String[] args) {
        /**
         * 类似于冒泡排序，任意两个字符，将较大的放到后面的位置
         * */
        Random r = new Random();
        int a = r.nextInt(100);
        int b = r.nextInt(100);
        int c = r.nextInt(100);
        System.out.println("a = " + a + " b = " + b + " c = " + c);
        if (a > b){
            int t = a;
            a = b;
            b = t;
        }
        if (a > c){
            int t = a;
            a = c;
            c = t;
        }
        if (b > c){
            int t = b;
            b = c;
            c = t;
        }
        System.out.println("after compare and swap");
        System.out.println("a = " + a + " b = " + b + " c = " + c);
    }
    /**
     * output:
     *   a = 40 b = 14 c = 55
     *   after compare and swap
     *   a = 14 b = 40 c = 55
     * */
}
