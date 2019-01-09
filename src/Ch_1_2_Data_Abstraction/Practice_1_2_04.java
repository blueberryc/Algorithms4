package Ch_1_2_Data_Abstraction;

/**
 * Created by Zive on 2019-01-09.
 */
public class Practice_1_2_04 {
    public static void main(String[] args) {
        // 类型相当于对象的别名
        String string1 = "hello";
        String string2 = string1;
        string1 = "world";
        System.out.println(string1);
        System.out.println(string2);
    }
}
