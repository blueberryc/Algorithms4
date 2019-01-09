package Ch_1_2_Data_Abstraction;

/**
 * Created by Zive on 2019-01-09.
 */
public class Practice_1_2_09 {
    public static int rank(int key, int[] a){
        Counter keyCount = new Counter("key");
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]){
                keyCount.increment();
                hi = mid - 1;
            }else if (key > a[mid]){
                keyCount.increment();
                lo = mid + 1;
            }else {
                System.out.println(keyCount);
                return mid;
            }
        }
        System.out.println(keyCount);
        return -1;
    }

    public static void main(String[] args) {
        int[] whitelist = {1, 2, 3, 5, 7, 9, 12, 15, 18};
        int key = 9;
        int index = rank(key, whitelist);
        System.out.println(index);
    }
}

class Counter implements Comparable<Counter>{
    private final String name;
    private int count = 0;
    Counter(String name){
        this.name = name;
    }
    public void increment(){
        count++;
    }
    public int tally(){
        return count;
    }
    public String toString(){
        return name + " " + count;
    }
    @Override
    public int compareTo(Counter that){
        if (this.count < that.count) return -1;
        else if (this.count > that.count) return 1;
        else return 0;
    }

}
