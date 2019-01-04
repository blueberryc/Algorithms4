package Ch_1_1_Basic_Programming_Model;

/**
 * Created by Zive on 2018-12-15.
 */
public class Practice_1_1_14 {
    /**
     * 从1开始迭代乘以2，直到值大于N
     * */
    public static int lg(int N){
        int res = 1;
        for (int i = 0; i < N; i++) {
            if (res > N)
                return i - 1;
            res *= 2;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lg(50));
    }
}
