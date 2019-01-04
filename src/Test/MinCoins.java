package Test;

import java.util.Arrays;

/**
 * Created by Zive on 2018-12-27.
 */
public class MinCoins {
    public static int[] minCoins(int n, int[] values){
        /**
         * 价值为n元至少需要多少个硬币
         * Args:
         *   n -- 总价值
         *   values -- 硬币面值
         * */
        int[] min = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            min[i] = i;
        }
//        min[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < values.length; j++){
                if (values[j] <= i && min[i - values[j]] + 1 < min[i]){
                    min[i] = min[i - values[j]] + 1;
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] values = {1, 3, 5};
        System.out.println(Arrays.toString(minCoins(11, values)));
    }
}
