package solutions.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are given an array-like data structure Listy which lacks a size
 * method. It does, however, have an e lementAt (i) method that returns the element at index i in
 * 0(1) time. If i is beyond the bounds of the data structure, it returns - 1. (For this reason, the data
 * structure only supports positive integers.) Given a Listy which contains sorted, positive integers,
 * find the index at which an element x occurs. If x occurs multiple times, you may return any index.
 ****/
public class NoSizeSortedSearch {

    // find 13 -> 6
    // 1 3 5 6 8 10 13 15 16
    // 0 1 2 3 4 5  6  7  8
    public int search(List<Integer> arr, int num) {
        int incr = 0, start = 0, end = 1;
        Integer val = null;
        try {
            if(arr.get(start) == num) return start;

            val = arr.get(end);
        } catch(ArrayIndexOutOfBoundsException ex) {
            return -1;
        }
            while (val >= 0 && val <= num) {

                //System.out.println("\tsearching for " + num);
                if (val == num) return end;

                start = end;   // start = 4
                end = end * 2;
                try {
                    val = arr.get(end); // val = null
                } catch(ArrayIndexOutOfBoundsException ex) {
                    val = -1;
                }
                System.out.println("\tstart: " + start + ", end: " + end + ", val: " + val);
            }
            return sortedSearch(arr, start, end, num);

    }

    public int sortedSearch(List<Integer> arr, int s, int e, int num) {

         if(s == e){
                try {
                    if (arr.get(s) == num) return s;
            } catch (ArrayIndexOutOfBoundsException ex) {}
            finally {
                return -1;
            }
         }
             if(arr.get(s) == num) return s;
             try {
                 if (arr.get(e) == num) return e;
             } catch (ArrayIndexOutOfBoundsException ex) {}

            int mid = s + (e - s) / 2;
            int val = -1;
            try {
                val = arr.get(mid);
            } catch (ArrayIndexOutOfBoundsException ex) {}
            if(val >= 0 || val <= num)
                return sortedSearch(arr, s, mid, num);
            else
                return sortedSearch(arr, mid, e, num);

    }

    public static void test() {
        NoSizeSortedSearch a = new NoSizeSortedSearch();
        List<Integer> arr = Arrays.asList(new Integer[]{1, 3, 5, 6, 8, 10, 13, 15});
        int resIndex = a.search(arr, 13);
        System.out.println("The element " + 13 + " can be found at pos:" + resIndex + "\n");


        resIndex = a.search(arr, 55);
        System.out.println("The element " + 55 + " can be found at pos:" + resIndex + "\n");

        List<Integer> arr1 = Arrays.asList(new Integer[]{});
        resIndex = a.search(arr1, 1);
        System.out.println("The element " + 1 + " can be found at pos:" + resIndex + "\n");

        resIndex = a.search(arr, 3);
        System.out.println("The element " + 3 + " can be found at pos:" + resIndex + "\n");

        resIndex = a.search(arr, 1);
        System.out.println("The element " + 1 + " can be found at pos:" + resIndex + "\n");
    }
}
