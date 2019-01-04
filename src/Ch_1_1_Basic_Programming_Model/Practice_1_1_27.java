package Ch_1_1_Basic_Programming_Model;

/**
 * Created by Zive on 2018-12-16.
 */
public class Practice_1_1_27 {
    private static int count = 0;
    public static double binomial(int N, int k, double p){
        count += 1;
        if (N ==0 && k == 0)
            return 1.0;
        if (N < 0 || k < 0)
            return 0.0;
        return (1.0 - p) * binomial(N-1, k, p) + p * binomial(N-1, k-1, p);
    }

    public static double binomial_modified(int N, int k, double p){
        // 分配数组容量
        double[][] container= new double[N + 1][k + 1];
        container[0][0] = 1.0;
        // 初始化第一行的数和第一列的数
        for (int i = 1; i < N + 1; i++){
            container[i][0] = (1 - p) * container[i-1][0];
        }
        for (int i = 1; i < k + 1; i++){
            container[0][i] = 0.0;
        }
        for (int i = 1; i < N + 1; i++){
            for (int j = 1; j < k + 1; j++){
                container[i][j] = (1.0 - p) * container[i-1][j] + p * container[i-1][j-1];
            }
        }
        return container[N][k];
    }

    public static void main(String[] args) {
        System.out.println("=====二项分布=====");
        System.out.println(binomial(10, 5, 0.25));
        System.out.println("=====递归次数=====");
        System.out.println(count);
        System.out.println("=====利用数组优化=====");
        System.out.println(binomial_modified(10, 5, 0.25));
    }
}
