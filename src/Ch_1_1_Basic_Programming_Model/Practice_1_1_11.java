package Ch_1_1_Basic_Programming_Model;

import java.util.Random;

/**
 * Created by Zive on 2018-12-15.
 */
public class Practice_1_1_11 {
    // 生成随机的boolean型二维数组
    public static boolean[][] get_bool_array2(int N, int M){
        boolean[][] booleanArray = new boolean[N][M];
        Random r = new Random();
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                double randNumber = r.nextDouble();
                if (randNumber <= 0.5){
                    booleanArray[i][j] = true;
                }else {
                    booleanArray[i][j] = false;
                }
            }
        }
        return booleanArray;
    }
    // 打印二维数组
    public static void print_array2(boolean[][] array){
        for (int i = -1; i < array.length; i++){
            if (i != -1)
                System.out.print(i+" ");
            else
                System.out.print("  ");
            for (int j = 0; j < array[0].length; j++){
                if (i == -1){
                    System.out.print(j + " ");
                    continue;
                }
                if (array[i][j] == true){
                    System.out.print("* ");
                }else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        boolean[][] test = get_bool_array2(10, 10);
        print_array2(test);
    }
}
