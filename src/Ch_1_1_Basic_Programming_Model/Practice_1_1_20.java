package Ch_1_1_Basic_Programming_Model;

/**
 * Created by Zive on 2018-12-15.
 */
public class Practice_1_1_20 {
    public static double Factorial(int N){
        if (N == 0 || N == 1)
            return 1;
        return Factorial(N-1) * N;
    }

    public static void main(String[] args) {
        int N = 9;
        System.out.println(Math.log(Factorial(N)));
    }
}
