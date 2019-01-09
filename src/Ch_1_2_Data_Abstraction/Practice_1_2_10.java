package Ch_1_2_Data_Abstraction;

import edu.princeton.cs.algs4.StdDraw;

import java.util.Random;

/**
 * Created by Zive on 2019-01-09.
 */
public class Practice_1_2_10 {
    public static void main(String[] args) {
        int N = 10000;
        int max= 100;
        VisualCounter counter = new VisualCounter(N, max);
        double probility = 0.5;
        Random rand = new Random();
        for (int i = 0; i < N; i++) {
            if (rand.nextDouble() > probility)
                counter.increment();
            else
                counter.decrease();
        }
    }
}

class VisualCounter {
    /**
     * @parm max: 计数器的最大绝对值
     * @parm N: 操作的最大次数
     * */
    private final int max;
    private final int N;
    private int opCount = 0;
    private int count = 0;
    VisualCounter (int N, int max){
        this.N = N;
        this.max = max;
        StdDraw.setXscale(0, N);
        StdDraw.setYscale(-this.max - 10, this.max + 10);
        StdDraw.setPenRadius(0.01);

        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.line(0, max / 2, N + 1, max / 2);
        StdDraw.line(0, -max / 2 , N + 1, -max / 2);

        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(.001);
    }
    public void increment(){
        if (opCount < N){
            opCount++;
            if (Math.abs(count) < max){
                count++;
            }
        }
        StdDraw.point(opCount, count);
    }
    public void decrease(){
        if (opCount < N){
            opCount++;
            if (Math.abs(count) < max){
                count--;
            }
        }
        StdDraw.point(opCount, count);
    }
    public int tally(){
        return count;
    }
    public String toString(){
        return count + "";
    }
    public void drawCounter(){

    }
}