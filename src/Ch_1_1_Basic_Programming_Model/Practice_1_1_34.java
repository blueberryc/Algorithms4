package Ch_1_1_Basic_Programming_Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * Created by Zive on 2018-12-18.
 */
public class Practice_1_1_34 {
    /**
     * 打印出最大和最小的数
     *
     * 只需要固定数量的变量
     * */
    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;
    public static void MaxMin(int n){
        if (n > max){
            System.out.println("最大值为:" + n);
            max = n;
        }
        if (n < min){
            System.out.println("最小值为:" + n);
            min = n;
        }
    }
    public static void test1(){
        System.out.println("=====================");
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            MaxMin(r.nextInt(100));
        }
    }


    /**
     * 打印出所有数的中位数
     *
     * 需要保存所有的值，因为需要对数据进行排序
     * */
    public static int[] generateRandomArray(int size, int value){
        int[] res = new int[size];
        Random r = new Random();
        for (int i = 0; i < size; i++){
            res[i] = r.nextInt(value);
        }
        return res;
    }
    public static void midean(int[] arr){
        int[] newArr = new int[arr.length];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        Arrays.sort(newArr);
        if (newArr.length % 2 == 0)
            System.out.println("中位数: " +
                    (newArr[newArr.length / 2] + newArr[newArr.length / 2 - 1]) / 2);
        else
            System.out.println("中位数: " + newArr[newArr.length / 2]);
    }
    public static void test2(){
        // 随机数组
        System.out.println("=====================");
        int[] arr = generateRandomArray(12, 100);
        System.out.println("=====原数组=====");
        System.out.println(Arrays.toString(arr));
        midean(arr);
    }

    /**
     * 打印出第k小的数，k小于100
     *
     * 仅需维持一个大小为 k 的有序数组，也可以用最大堆
     * */
    private static int k = 5;
    private static int[] arr = new int[k];
    private static int count = 0; //记录加入数组的数的个数
    public static void theKthMin(int n){
        if (count < k - 1){
            arr[count] = n;
            count++;
        } else if (count == k - 1){
            // 刚好有k个数
            arr[count] = n;
            count++;
            Arrays.sort(arr);
            System.out.println("第k小的数: " + arr[arr.length-1]);
        } else {
            if (n >= arr[arr.length - 1])
                System.out.println("第k小的数: " + arr[arr.length-1]);
            else {
                arr[arr.length - 1] = n;
                Arrays.sort(arr);
                System.out.println("第k小的数: " + arr[arr.length-1]);
            }
        }
//        Arrays.sort(arr);
    }
    public static void test3(){
        System.out.println("=====================");
        Random r = new Random();
        for (int i = 0; i < 14; i++) {
            int number = r.nextInt(40);
            theKthMin(number);
        }
    }


    /**
     * 打印出所有数的平方和
     *
     * 只需保存一个变量
     * */
    private static long sum = 0;
    public static void sumOfSquare(int n){
        sum += n * n;
        System.out.println("输入值: " + n);
        System.out.println("平方和: " + sum);
    }
    public static void test4(){
        System.out.println("=====================");
        Random r = new Random();
        for (int i = 0; i < 15; i++) {
            sumOfSquare(i);
        }
    }

    /**
     * 打印出N个数的平均值
     *
     * 只需保存总和，以及数目两个变量
     * */
    private static int sum2 = 0;
    private static int number = 0;
    public static void average(int n){
        sum2 += n;
        number += 1;
        System.out.println("平均值: " + (sum2 * 1.0 / number));
    }
    public static void test5(){
        System.out.println("=====================");
        Random r = new Random();
        for (int i = 0; i < 15; i++) {
            average(i);
        }
    }

    /**
     * 打印出大于平均值的数的百分比
     *
     * 需要先统计所有数的平均值
     * */
    public static void largeAverage(int[] arr){
        // 对数组遍历两次，第一次计算总和，第二次找大于平均值的数目
        int sum3 = 0;
        int count3 = 0;
        for (int i = 0; i < arr.length; i++) {
            sum3 += arr[i];
        }
        double average = sum3 * 1.0 / arr.length;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > average)
                count3++;
        }
        System.out.println("百分比: " + (count3 * 1.0 / arr.length)*100 + "%");
    }
    public static void test6(){
        System.out.println("=====================");
        int[] arr = generateRandomArray(12, 30);
        System.out.println(Arrays.toString(arr));
        largeAverage(arr);
    }

    /**
     * 将N个数按照升序打印
     *
     * 需要保存所有的值
     * */
    public static void printSortedArray(int[] arr){
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void test7(){
        System.out.println("=====================");
        int[] arr = generateRandomArray(13, 40);
        printSortedArray(arr);
    }


    /**
     * 将N个数按照随机顺序打印
     *
     * 需要保存所有的值
     * */
    public static void shuffleArray(int[] arr){
        // 利用 shuffle 函数
        ArrayList<Integer> intList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            intList.add(arr[i]);
        }
        Collections.shuffle(intList);
        System.out.println(intList);
    }
    public static void test8(){
        System.out.println("=====================");
        int[] arr = generateRandomArray(13, 40);
        System.out.println(Arrays.toString(arr));
        shuffleArray(arr);
    }
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
    }
}
