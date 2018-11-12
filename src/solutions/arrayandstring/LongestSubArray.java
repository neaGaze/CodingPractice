package solutions.arrayandstring;

public class LongestSubArray {

    public int longestSubArray(int[] arr, int k) {
        int globalMin = Integer.MIN_VALUE;
        for(int hops = 1; hops <= arr.length; hops++) {
            int sum = 0;
            int j = 0;
            for(j = 0; j < hops - 1; j++) {
                sum += arr[j];
            }
            while(j < arr.length) {
                sum += arr[j++];
                if(sum <= k && globalMin < hops) {
                    globalMin = hops;
                }
                sum -= arr[j - hops];
            }
        }
        return globalMin;
    }

    public static void test() {
        LongestSubArray a = new LongestSubArray();
        System.out.println(a.longestSubArray(new int[] {1, 2, 3}, 4));
    }
}
