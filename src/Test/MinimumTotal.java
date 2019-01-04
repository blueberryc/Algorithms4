package Test;

/**
 * Created by Zive on 2018-12-27.
 */
public class MinimumTotal {
    public static int minimumTotal(int[][] triangle){
        if (triangle == null || triangle.length == 0){
            return 0;
        }
        int len = triangle.length;
        int[][] cost = new int[len][len]; // 记录走到具体位置的花费
        // 初始化第一行的值
        for (int i = 0; i < triangle[0].length; i++){
            cost[0][i] = triangle[0][i];
        }
        for (int i = 1; i < triangle.length; i++){
            for (int j = 0; j <= i; j++){
                if (j == 0){
                    cost[i][j] = cost[i-1][j] + triangle[i][j];
                    continue;
                }
                if (j < i){
                    cost[i][j] = Math.min(cost[i-1][j], cost[i-1][j-1]) + triangle[i][j];
                    continue;
                }
                else {
                    cost[i][j] = cost[i-1][j-1] + triangle[i][j];
                }
            }
        }
        int min = cost[len-1][0];
        for (int i = 0; i < len; i++) {
            if (cost[len-1][i] < min)
                min = cost[len-1][i];

        }
        return min;
    }

    public static void main(String[] args) {
        int[][] triangle = {
                {2},
                {3,4},
                {6,5,7},
                {4,1,8,3}
        };
        System.out.println(minimumTotal(triangle));
    }
}
