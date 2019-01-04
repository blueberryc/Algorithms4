package Ch_1_1_Basic_Programming_Model;

import java.util.Scanner;

/**
 * Created by Zive on 2018-12-14.
 */
public class Practice_1_1_03 {
    public static void main(String[] args) {
        // 使用外部的参数 java xxx 2 2 2
//        int num1 = Integer.parseInt(args[0]);
//        int num2 = Integer.parseInt(args[1]);
//        int num3 = Integer.parseInt(args[2]);
//        if (num1 == num2 && num2 == num3){
//            System.out.println("equal");
//        }else {
//            System.out.println("not equal");
//        }
        // 标准化输入，推荐这种方式
        Scanner reader = new Scanner(System.in);
        int a = reader.nextInt();
        int b = reader.nextInt();
        int c = reader.nextInt();
        if (a == b && a == c){
            System.out.println("equal");
        }else {
            System.out.println("not equal");
        }
    }
}
