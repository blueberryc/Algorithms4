package Ch_1_2_Data_Abstraction;

/**
 * Created by Zive on 2019-01-09.
 */
public class Practice_1_2_07 {
    public static String mystery(String s){
        int N = s.length();
        if (N <= 1) return s;
        String a = s.substring(0, N/2);
        String b = s.substring(N/2, N);
        return mystery(b) + mystery(a);
    }

    public static void main(String[] args) {
        System.out.println(mystery("abcdefg"));
    }
}
