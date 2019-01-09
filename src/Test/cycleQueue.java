package Test;

import java.util.Arrays;

/**
 * Created by Zive on 2019-01-04.
 */
public class cycleQueue {
    /**
     * 实现环形队列，当队列满时，新加入的数直接覆盖最早的数
     * */
    public static void cycleList(int N){
        // 头指针和尾指针
        int head = 0;
        int tail = 0;
        int[] cycle = new int[N];
        // 循环插入新的数
        for (int i = 0; i < 20; i++) {
            // 在尾指针处插入数
            cycle[tail] = i;
            tail = (tail + 1) % N;
            System.out.println(Arrays.toString(cycle));
        }
    }

    public static void main(String[] args) {
        cycleList(8);
    }
}
