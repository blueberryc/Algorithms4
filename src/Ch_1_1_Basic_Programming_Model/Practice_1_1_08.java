package Ch_1_1_Basic_Programming_Model;

/**
 * Created by Zive on 2018-12-14.
 */
public class Practice_1_1_08 {
    public static void main(String[] args) {
        System.out.println('b');
        // char 被提升为 int
        System.out.println('b' + 'c');
        // char 提升为 int，然后强制转化为 char
        System.out.println((char) ('a' + 4));
    }

    /**
     * output:
     *   b
     *   197
     *   e
     * */
}
