package Ch_1_2_Data_Abstraction.Examples;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Zive on 2018-12-25.
 */
public class Counter implements Comparable<Counter>{
    private final String name;
    private int count=0;
    public Counter(String id){
        name = id;
    }

    public void increment(){
        count++;
    }

    public int tally(){
        return count;
    }

    public String toString(){
        return count + " " + name;
    }

    @Override
    public int compareTo(Counter that){
        if (this.count < that.count) return -1;
        else if (this.count > that.count) return 1;
        else return 0;
    }

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        Random rand = new Random();
        int n = read.nextInt();
        int trials = read.nextInt();

        Counter[] hits = new Counter[n];
        for (int i = 0; i < n; i++) {
            hits[i] = new Counter("count"+i);
        }

        for (int t = 0; t < trials; t++) {
            hits[rand.nextInt(n)].increment();
        }

        for (int i = 0; i < n; i++) {
            System.out.println(hits[i].toString());
        }
    }
}
