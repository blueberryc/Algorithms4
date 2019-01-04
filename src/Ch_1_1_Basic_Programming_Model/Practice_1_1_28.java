package Ch_1_1_Basic_Programming_Model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

/**
 * Created by Zive on 2018-12-16.
 */
public class Practice_1_1_28 {
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
    public static int[] removeDouble(int[] arr){
        int[] res = new int[arr.length];
        int index = 0;
        res[0] = arr[0];
        for (int i = 1; i < arr.length; i++){
            if (arr[i] != res[index]){
                index += 1;
                res[index] = arr[i];
            }
        }
        return Arrays.copyOfRange(res, 0, index+1);
    }

    public static void main(String[] args) {
        System.out.println("=====随机数组=====");
        int[] array = generateRandomArray(10, 8);
        System.out.println(Arrays.toString(array));
        System.out.println("=====数组排序=====");
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        System.out.println("=====删除重复元素=====");
        int[] res = removeDouble(array);
        System.out.println(Arrays.toString(res));
        System.out.println("=====利用HashSet=====");
        HashSet<Integer> resSet = new HashSet<>();
        for(int element:array){
            resSet.add(element);
        }
        System.out.println(resSet);
//        HashSet<Integer> set = new HashSet<>(Arrays.asList(array));
//        System.out.println(set);
    }
}
