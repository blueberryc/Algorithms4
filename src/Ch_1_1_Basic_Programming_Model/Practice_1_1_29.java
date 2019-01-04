package Ch_1_1_Basic_Programming_Model;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Zive on 2018-12-16.
 */
public class Practice_1_1_29 {
    // 生成随机长度的数组
    public static int[] generateRandomArray(int size, int value){
        int[] array = new int[size];
        Random r = new Random();
        for (int i = 0; i < array.length; i++){
            int randomNumber = r.nextInt(value);
            array[i] = randomNumber;
        }
        return array;
    }

    /**
     * 顺序遍历，时间复杂度O(n)
     * */
    public static int orderRank(int key, int[] arr){
        int lessKey = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] < key){
                lessKey++;
            }else {
                break;
            }
        }
        return lessKey;
    }
    public static int orderCount(int key, int[] arr){
        int equalKey = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < key)
                continue;
            else if (arr[i] == key){
                equalKey++;
            }else
                break;
        }
        return equalKey;
    }

    /**
     * 二分查找：
     * 第一个查找最后一个小于key的元素位置
     * 第二个查找最后一个小于key的元素位置和第一个大于key的元素位置
     * */
    public static int lastLessKey(int key, int[] arr, int lo, int hi){
        int mid = lo + (hi - lo) / 2;
        if (key > arr[mid-1] && key <= arr[mid])
            return mid;
        if (key <= arr[mid-1])
            return lastLessKey(key, arr, lo, mid-1);
        if (key > arr[mid] && key <= arr[mid+1])
            return mid + 1;
        if (key >= arr[mid+1])
            return lastLessKey(key, arr, mid+1, hi);
        return -1;
    }

    public static int firstLargeKey(int key, int[] arr, int lo, int hi){
        if (lo > hi)
            return -1;
        int mid = lo + (hi - lo) / 2;
        if (key >= arr[mid-1] && key <arr[mid])
            return mid + 1;
        else if (key < arr[mid-1])
            return firstLargeKey(key, arr, lo, mid-1);
        else if (key >= arr[mid] && key < arr[mid+1])
            return mid + 2;
        else
            return firstLargeKey(key, arr, mid+1, hi);
    }

    public static int binaryRank(int key, int[] arr){
        return lastLessKey(key, arr, 0, arr.length-1);
    }

    public static int binaryCount(int key, int[] arr){
        int lastIndex = lastLessKey(key, arr, 0, arr.length-1);
        int firstIndex = firstLargeKey(key, arr, 0, arr.length-1);
        return firstIndex - lastIndex - 1;
    }
    public static void main(String[] args) {
        System.out.println("=====生成随机数组=====");
        int[] arr = generateRandomArray(20, 10);
        System.out.println(Arrays.toString(arr));
        System.out.println("=====数组排序=====");
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("_____顺序遍历_____");
        System.out.println("=====小于key=====");
        System.out.println(orderRank(6, arr));
        System.out.println("=====等于key=====");
        System.out.println(orderCount(6, arr));
        System.out.println("_____二分查找_____");
        System.out.println("=====小于key=====");
        System.out.println(binaryRank(6, arr));
        System.out.println("=====等于key=====");
        System.out.println(binaryCount(6, arr));
    }

}
