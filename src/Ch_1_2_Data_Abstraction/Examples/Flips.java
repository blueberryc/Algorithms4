package Ch_1_2_Data_Abstraction.Examples;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Zive on 2018-12-25.
 */
public class Flips {
    public static Counter max(Counter x, Counter y){
        if (x.tally() > y.tally()) return x;
        else return y;
    }
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        Random rand = new Random();
        int T = read.nextInt();
        Counter heads = new Counter("heads");
        Counter tails = new Counter("tails");
        for (int i = 0; i < T; i++) {
            if (rand.nextDouble() >= 0.5)
                heads.increment();
            else tails.increment();
        }
        System.out.println(heads);
        System.out.println(tails);
        int d = heads.tally() - tails.tally();
        System.out.println("delta: " + Math.abs(d));
        if (heads.tally() == tails.tally())
            System.out.println("Tie");
        else System.out.println(max(heads, tails) + " wins!");
    }
}
