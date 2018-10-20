package solutions.bitmanipulation;

/**
 * Created by neaGaze on 10/9/18.
 */
public class Insertion {

    public Insertion(int M, int N, int j, int i) {
        int mask = ~0;
        mask = (mask << (j + 1)) | ((1 << i) - 1);

        N = N & mask;
        N = N | (M << i);
        System.out.println("The bit value are: " + N);
    }

    public static void test() {
        Insertion insertion = new Insertion(15,173, 4, 1);
    }
}
