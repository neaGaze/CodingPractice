package solutions.search;

/***
 *  Given a set of non-sorted positive integer list, find if there any contiguous integers that sum up to the provided
 *  number.
 * **/
public class SumOfContiguosNum {


    // 1 4 7 9 12 find(16)
    public boolean search(int[] arr, int num) {
        if(arr.length == 0) return false;

        int start = 0, end = 0;
        int sum = 0;

        while(end < arr.length && start < arr.length) {
            if(sum == num) return true;
            else if(sum < num)
                sum += arr[end++];
            else
                sum -= arr[start++];
        }
        return false;
    }

    public static void test() {
        SumOfContiguosNum a = new SumOfContiguosNum();
        System.out.println(a.search(new int[] {1, 4, 7, 9, 12}, 16));
        System.out.println(a.search(new int[] {1, 4, 7, 9, 12}, 15));
    }
}
