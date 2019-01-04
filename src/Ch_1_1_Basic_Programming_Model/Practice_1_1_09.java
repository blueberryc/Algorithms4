package Ch_1_1_Basic_Programming_Model;

/**
 * Created by Zive on 2018-12-15.
 */
public class Practice_1_1_09 {
    public static String toBinaryString(int N){
        String s = "";
        for (int n = N; n > 0; n /= 2){
            s = (n % 2) + s;
        }
        return s;
    }

    public static void main(String[] args) {
        String result = toBinaryString(10);
        System.out.println(result);
    }
}
