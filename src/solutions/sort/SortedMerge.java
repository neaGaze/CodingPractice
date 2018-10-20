package solutions.sort;

/**
 * Created by neaGaze on 10/14/18.
 */
public class SortedMerge {

    public SortedMerge(int[] a, int[] b, int x, int y) {
        merge(a, b, x, y);
    }


    public void merge(int[] a, int[] b, int lenA, int lenB) {
        int x = lenA - 1, y = lenB - 1;
        int finalSize = lenA + lenB - 1;
        while(y >= 0) {
            if(x >= 0 && a[x] > b[y]) {
                a[finalSize--] = a[x--];
            } else {
                a[finalSize--] = b[y--];
            }
        }
    }

    public static void test() {
        int[] a = new int[20];
        for(int i = 0; i < 4; i++) a[i] = 2 * (i + 1) - 1;
        int[] b = new int[] {2, 4, 6};
        print("Before: \na:", a);
        print("b:", b);
        SortedMerge sortedMerge = new SortedMerge(a, b, 4, 3);
        print("After: \n", a);
    }

    static void print(String exp, int[] arr) {
        StringBuilder str = new StringBuilder();
        for(int a : arr)
            str.append(a+" ");
        System.out.println(exp);
        System.out.println(str.toString());
    }
}
