package Ch_1_1_Basic_Programming_Model;

/**
 * Created by Zive on 2018-12-14.
 */
public class Practice_1_1_06 {
    public static void main(String[] args) {
        // 打印斐波拉契数列的前16项，从 0 开始
        int f = 0;
        int g = 1;
        for (int i = 0; i <= 15; i++) {
            System.out.println("the " + i + "th: " + f);
            f = f + g;
            g = f - g;
        }
    }

    // output:
    /**
     * the 0th: 0
     * the 1th: 1
     * the 2th: 1
     * the 3th: 2
     * the 4th: 3
     * the 5th: 5
     * the 6th: 8
     * the 7th: 13
     * the 8th: 21
     * the 9th: 34
     * the 10th: 55
     * the 11th: 89
     * the 12th: 144
     * the 13th: 233
     * the 14th: 377
     * the 15th: 610
     * */
}
