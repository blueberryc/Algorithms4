package Ch_1_1_Basic_Programming_Model;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Zive on 2018-12-15.
 */
public class Practice_1_1_21 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        // 新建一个动态数组来保存输入的结果
        ArrayList<String> data = new ArrayList<>();
        while (reader.hasNextLine()){
            String newLine = reader.nextLine();
//            System.out.println(newLine);
            data.add(newLine);
        }
        // 输入数组中的所有内容
        for (String newStr : data) {
            // 将字符串划分为数组，然后计算分值
            String[] temp = newStr.split(" ");
            System.out.print(temp[0]+" ");
            System.out.print(temp[1]+" ");
            System.out.print(temp[2]+" ");
            System.out.printf("%.3f\n", Integer.parseInt(temp[1])*1.0 / Integer.parseInt(temp[2]));

        }
    }

    /**
     * input:
     *   Tom 21 23
     *   Yi 25 26
     *   Tim 25 27
     *   ^D
     *
     * output:
     *   Tom 21 23 0.913
     *   Yi 25 26 0.962
     *   Tim 25 27 0.926
     * */
}
