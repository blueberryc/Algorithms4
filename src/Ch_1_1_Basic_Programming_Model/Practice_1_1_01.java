package Ch_1_1_Basic_Programming_Model;

public class Practice_1_1_01 {
    public static void main(String[] args) {
        // 整型相除，向0舍入
        System.out.println((0 + 15) / 2);

        // 字面值是双精度
        System.out.println(2.0e-6 * 100000000.1);

        // && 优先级高于 ||
        System.out.println(true && false || true && true);
    }
    // output:
    /*
    *   7
    *   200.0000002
    *   true
    */
}
