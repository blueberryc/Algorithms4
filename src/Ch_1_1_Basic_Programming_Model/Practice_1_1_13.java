package Ch_1_1_Basic_Programming_Model;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Zive on 2018-12-15.
 */
public class Practice_1_1_13 {
    public static int[][] get2Array(int M, int N){
        int[][] intArray = new int[M][N];
        Random r = new Random();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++){
                int randNumber = r.nextInt(100);
                intArray[i][j] = randNumber;
            }
        }
        return intArray;
    }

    // 对二维数组进行转置运算
    public static int[][] transposeMatrix(int[][] matrix){
        if (matrix == null)
            throw new RuntimeException("not supported argument type");
        int row = matrix.length;
        int column = matrix[0].length;
        int[][] transpose = new int[column][row];
        for (int i = 0; i < column; i++){
            for (int j = 0; j < row; j++){
                transpose[i][j] = matrix[j][i];
            }
        }
        return transpose;
    }

    // 打印二维数组
    public static void print2Array(int[][] matrix){
        for (int i = 0; i < matrix.length; i++){
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    // 转置测试
    public static void main(String[] args) {
        int[][] matrix = get2Array(5, 8);
        System.out.println("原始数组为：");
        print2Array(matrix);
        System.out.println("转置后的数组为：");
        int[][] tranpose = transposeMatrix(matrix);
        print2Array(tranpose);

    }
}
