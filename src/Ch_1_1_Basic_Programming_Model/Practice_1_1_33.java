package Ch_1_1_Basic_Programming_Model;

/**
 * Created by Zive on 2018-12-18.
 */
public class Practice_1_1_33 {
    public static double dot(double[] x, double[] y){
        /**
         * 向量点乘
         * */
        if (x.length != y.length)
            throw new RuntimeException("the length of vector not equal!");
        double sum = 0;
        for (int i = 0; i < x.length; i++) {
            sum += x[i] * y[i];
        }
        return sum;
    }
    public static double[][] mult(double[][] a, double[][] b){
        /**
         * 矩阵和矩阵之积
         * 先判断不能进行矩阵乘法的情况
         * */
        if (a[0].length != b.length)
            throw new RuntimeException("the length of matrix not equal!");
        double[][] c = new double[a.length][b[0].length];
        for (int i = 0; i < a.length; i++){
            for (int j = 0; j < b[0].length; j++){
                double sum = 0.0;
                for (int k = 0; k < a[0].length; k++){
                    sum += a[i][k] * b[k][j];
                }
                c[i][j] = sum;
            }
        }
        return c;
    }

    public static double[][] transpose(double[][] a){
        /**
         * 转置矩阵
         * */
        double[][] newMatrix = new double[a[0].length][a.length];
        for (int i = 0; i < a.length; i++){
            for (int j = 0; j < a[i].length; j++){
                newMatrix[j][i] = a[i][j];
            }
        }
        return newMatrix;
    }

    public static double[] mult(double[][] a, double[] x){
        /**
         * 矩阵和向量之积
         * (m x n) * (n * 1) = (m * 1)
         * */
        if (a[0].length != x.length)
            throw new RuntimeException("the length of matrix not equal!");
        double[] newVector = new double[a.length];
        for (int i = 0; i < a.length; i++){
            newVector[i] = dot(a[i], x);
        }
        return newVector;
    }

    public static double[] mult(double[] y, double[][] a){
        /**
         * 向量和矩阵之积
         * (1 x m) * (m x n) = (1 x n)
         * */
        if (y.length != a.length)
            throw new RuntimeException("the length of matrix not equal!");
        double[] newVector = new double[a[0].length];
        for (int i = 0; i < a[0].length; i++){
            for (int j = 0; j < a.length; j++){
                newVector[i] += y[i] * a[j][i];
            }
        }
        return newVector;
    }

    /**
     * 打印二维数组
     * */
    public static void printArr(double[][] a){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
//        System.out.println("===========");
    }

    /**
     * 打印一维数组
     * */
    public static void printArr(double[] x){
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + " ");
        }
        System.out.println();
//        System.out.println("===========");
    }

    public static void main(String[] args) {
        // 初始化向量和数组
        double[] x = {1, 2, 3, 4, 5};
        double[] y = {7, 8, 9, 10, 11};
        double[][] A = {
                {1, 2},
                {3, 4},
                {5, 6}
        };
        double[][] B = {{6, 7, 8}, {9, 10, 11}};
        double[] D = {3, 2, 1};
        double[][] C = {{1}, {2}, {3}};
        double[][] E = {{9, 8, 7},
                        {6, 5, 4},
                        {3, 2, 1}};
        System.out.println("向量点乘");
        System.out.println(dot(x, y));
        System.out.println("==========");

        System.out.println("矩阵乘法");
        printArr(mult(A, B));
        System.out.println("==========");

        System.out.println("转置矩阵");
        printArr(transpose(E));
        System.out.println("==========");
        printArr(transpose(A));
        System.out.println("==========");

        System.out.println("矩阵和向量之积");
        printArr(mult(B, D));
        System.out.println("==========");

        System.out.println("向量和矩阵之积");
        printArr(mult(D, A));
        System.out.println("==========");
    }

    /**
     * output:
     *   向量点乘
     *   145.0
     *   ==========
     *   矩阵乘法
     *   24.0 27.0 30.0
     *   54.0 61.0 68.0
     *   84.0 95.0 106.0
     *   ==========
     *   转置矩阵
     *   9.0 6.0 3.0
     *   8.0 5.0 2.0
     *   7.0 4.0 1.0
     *   ==========
     *   1.0 3.0 5.0
     *   2.0 4.0 6.0
     *   ==========
     *   矩阵和向量之积
     *   40.0 58.0
     *   ==========
     *   向量和矩阵之积
     *   27.0 24.0
     *   ==========
     * */
}
