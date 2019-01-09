package Ch_1_2_Data_Abstraction;

/**
 * Created by Zive on 2019-01-09.
 */
public class Practice_1_2_06 {
    /**
     * 判断两个字符串是否能通过回环变位来进行转换
     * 主要是其中一个字符串进行循环移动，然后判断新得到的字符串与另一个字符串是否相等
     * */
    public static boolean circularRotation(String str1, String str2){
        if (str1 == null || str2 == null || str1.length() != str2.length())
            return false;
        if ((str1 + str1).contains(str2))
            return true;
        return false;
    }

    public static void main(String[] args) {
        String str1 = "ACTGACG";
        String str2 = "TGACGAC";
        System.out.println(circularRotation(str1, str2));
    }

}
