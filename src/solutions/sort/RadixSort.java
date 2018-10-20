package solutions.sort;

import java.util.Arrays;

/**
 * Created by neaGaze on 10/14/18.
 */
public class RadixSort {
    // Radix sort

    RadixSort(int[] arr) {
        print("Before sorting: \n", arr);
        radixSort(arr);
        print("After sorting: \n", arr);
    }

    public int maxLength(int[] arr) {
        Integer max = Integer.MIN_VALUE;
        for(int x : arr) if(max < x) max = x;
        return max;
    }

    public void radixSort(int[] arr) {
        int max = maxLength(arr);
        for(int i = 1; max/i > 0; i = i*10) {
            countSort(arr, i);
        }
    }

    public void countSort(int[] arr, int base) {
        int[] count = new int[10];
        int[] newArr = new int[arr.length];
        Arrays.fill(count, 0);


        for(int i = 0; i < arr.length; i++)
            count[(arr[i] / base) % 10]++;

        for(int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // note here we don't go with forward propagation because if we do that, it would be replaced later anyway
        for(int i = arr.length - 1; i >= 0; i--) {
            newArr[count[(arr[i]/base) % 10] - 1] = arr[i];
            count[(arr[i]/base) % 10]--;
        }

        for(int i = 0; i < arr.length; i++)
            arr[i] = newArr[i];
    }

    void print(String exp, int[] arr) {
        StringBuilder str = new StringBuilder();
        for(int a : arr)
            str.append(a+" ");
        System.out.println(exp);
        System.out.println(str.toString());
    }

    public static void test() {
        RadixSort sort = new RadixSort(new int[] {99, 7, 45, 67, 405, 87, 12, 1, 206});
    }
}
