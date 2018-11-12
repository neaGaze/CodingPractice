package solutions.arrayandstring;

/***
 * In an array A of 0s and 1s, how many non-empty subarrays have sum S?
 *
 *
 *
 * Example 1:
 *
 * Input: A = [1,0,1,0,1], S = 2
 * Output: 4
 * Explanation:
 * The 4 subarrays are bolded below:
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 *
 * Eg 2:
 * Input: A = [0,0,0,0,0], S = 0
 * Output: 15
 *
 *
 * Note:
 *
 * A.length <= 30000
 * 0 <= S <= A.length
 * A[i] is either 0 or 1.
 ***/
public class BinarySubarraysWithSum {

    public int numSubarraysWithSum(int[] A, int S) {
        int head = 0, tail = 0;
        int sum = 0;
        int count = 0;
        while(head < A.length || tail < A.length) {
            if(sum <= S && tail < A.length) {
                sum += A[tail++];
                if(sum == S)
                    count++;
            } else {
                tail = ++head;
                sum = 0;
            }
        }
        return count;
    }

    public static void test() {
        BinarySubarraysWithSum a = new BinarySubarraysWithSum();
        a.numSubarraysWithSum(new int[] {1,0,1,0,1}, 2);
    }
}
