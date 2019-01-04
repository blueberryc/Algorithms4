package Ch_1_1_Basic_Programming_Model;

/**
 * Created by Zive on 2018-12-14.
 */
public class Practice_1_1_07 {
    /**
    * 1.1.7a 求平方根
    * */
    public static void practice_1_1_07_a(double c){
        double result = c;
        while (Math.abs(result - c / result) > 0.001){
            result = (c / result + result) / 2.0;
        }
        System.out.println(result);
    }

    /**
     * 1.1.7b
     * 0-1000 的公差为1的等差数列求和
     * 1 + 2 + ... + 999
    * */
    public static void practice_1_1_07_b(){
        int sum = 0;
        for (int i = 1; i < 1000; i++) {
            for (int j = 0; j < i; j++){
                sum++;
            }
        }
        System.out.println(sum);
    }

    /**
     * 1.1.7c
     * 1000 * (int(log2(1000))+1)
     * */
    public static void practice_1_1_07_c(){
        int sum = 0;
        for (int i = 1; i < 1000; i *= 2) {
            for (int j = 0; j < 1000; j++){
                sum ++;
            }
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        practice_1_1_07_a(9.0);
        practice_1_1_07_b();
        practice_1_1_07_c();
    }

    /**
     * output:
     *   3.00009155413138
     *   499500
     *   10000
     * */
}
