package Ch_1_1_Basic_Programming_Model;

/**
 * Created by Zive on 2018-12-15.
 */
public class Practice_1_1_19 {
    /**
     * 每次需要重新计算前面所有的值，没有用到中间计算的结果
     * */
    public static long F(int N){
        if (N == 0) return 0;
        if (N == 1) return 1;
        return F(N-2) + F(N-1);
    }

    /**
     * 数组改进，需要用long，不然会出现溢出
     * */
    public static long[] F2(int N){
        long[] res = new long[N];
        res[0] = 0;
        res[1] = 1;
        for (int i = 2; i < N; i++) {
            res[i] = res[i-2] + res[i-1];
        }
        return res;
    }

    public static void main(String[] args) {
        int N = 50;
        long[] res = F2(N);
        for (int i = 0; i < N; i++){
            System.out.println(i + " :" + res[i]);
        }
    }
}
