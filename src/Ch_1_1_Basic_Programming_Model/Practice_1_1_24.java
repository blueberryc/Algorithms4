package Ch_1_1_Basic_Programming_Model;

/**
 * Created by Zive on 2018-12-16.
 */
public class Practice_1_1_24 {

    /**
     * 非递归型式
     * */
    public static int gcd(int p, int q){
        if (q == 0)
            return p;
        while (q != 0){
            int rem = p % q;
            p = q;
            q = rem;
        }
        return p;
    }

    /**
     * 递归型式
     * */
    public static int gcdRecursion(int p, int q){
        System.out.println("p: " + p + "  q: " + q);
        if (q == 0)
            return p;
        return gcdRecursion(q, p % q);
    }

    public static void main(String[] args) {
        System.out.println("=====最大公约数(非递归)=====");
        System.out.println(gcd(1111111, 1234567));
        System.out.println("=====最大公约数(递归)=====");
        System.out.println(gcdRecursion(1111111, 1234567));
    }
}
