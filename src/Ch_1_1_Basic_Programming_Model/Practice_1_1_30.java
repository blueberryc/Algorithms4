package Ch_1_1_Basic_Programming_Model;

import java.util.Arrays;

/**
 * Created by Zive on 2018-12-17.
 */
public class Practice_1_1_30 {
    /**
     * 判断两个整数是否互质
     * 辗转相除法判断最大公约数是否为1
     * */
    public static boolean coprime(int p, int q){
        if (q == 0)
            return p == 1;
        return coprime(q, p%q);
    }

    /**
     * 对称矩阵，只需要计算矩阵的一半
     * */
    public static boolean[][] boolArray(int N){
        boolean[][] res = new boolean[N][N];
        for (int i = 0; i < N; i++){
            for (int j = i; j < N; j++){
                if (coprime(i, j)){
                    res[i][j] = true;
                    res[j][i] = true;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(coprime(3,5));
        System.out.println(coprime(30, 48));
        boolean[][] printArray = boolArray(8);
        for (int i = 0; i < printArray.length; i++)
            System.out.println(Arrays.toString(printArray[i]));
    }
}
