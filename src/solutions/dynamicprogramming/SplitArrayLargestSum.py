"""
Leetcode #410:

Given an array which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays. Write an algorithm to minimize the largest sum among these m subarrays.

Note:
If n is the length of array, assume the following constraints are satisfied:

1 ≤ n ≤ 1000
1 ≤ m ≤ min(50, n)
Examples:

Input:
nums = [7,2,5,10,8]
m = 2

Output:
18

Explanation:
There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8],
where the largest sum among the two subarrays is only 18.

Solution: Intuition

Approach #1 Dynamic Programming [Accepted]
Intuition

The problem satisfies the non-aftereffect property. We can try to use dynamic programming to solve it.

The non-aftereffect property means, once the state of a certain stage is determined, it is not affected by the state in the future.
In this problem, if we get the largest subarray sum for splitting nums[0..i] into j parts, this value will not be affected by how we
split the remaining part of nums.

To know more about non-aftereffect property, this link may be helpful : http://www.programering.com/a/MDOzUzMwATM.html

Algorithm

Let's define f[i][j] to be the minimum largest subarray sum for splitting nums[0..i] into j parts.

Consider the jth subarray. We can split the array from a smaller index k to i to form it. Thus f[i][j] can be derived from
max(f[k][j - 1], nums[k + 1] + ... + nums[i]). For all valid index k, f[i][j] should choose the minimum value of the above formula.

The final answer should be f[n][m], where n is the size of the array.

For corner situations, all the invalid f[i][j] should be assigned with INFINITY, and f[0][0] should be initialized with 0.

Complexity Analysis

Time complexity : O(n^2 * m). The total number of states is O(n∗m). To compute each state f[i][j], we need to go through the whole array
 to find the optimum k. This requires another O(n) loop. So the total time complexity is O(n ^ 2 * m)

Space complexity : O(n * m). The space complexity is equivalent to the number of states, which is O(n * m).

Approach #2 Binary Search + Greedy [Accepted]
Intuition

We can easily find a property for the answer:

If we can find a splitting method that ensures the maximum largest subarray sum will not exceed a value x, then we can also
find a splitting method that ensures the maximum largest subarray sum will not exceed any value y that is greater than x.

Lets define this property as F(x) for the value x. F(x) is true means we can find a splitting method that ensures the maximum 
largest subarray sum will not exceed x.

From the discussion above, we can find out that for x ranging from -INFINITY to INFINITY, F(x) will start with false, 
then from a specific value x0, F(x) will turn to true and stay true forever.

Obviously, the specific value x0 is our answer.

Algorithm

We can use Binary search to find the value x0. Keeping a value mid = (left + right) / 2. 
If F(mid) is false, then we will search the range [mid + 1, right]; If F(mid) is true, then we will search [left, mid - 1].

For a given x, we can get the answer of F(x) using a greedy approach. Using an accumulator sum to store the sum of the current
processing subarray and a counter cnt to count the number of existing subarrays. We will process the elements in the array one by one.
For each element num, if sum + num <= x, it means we can add num to the current subarray without exceeding the limit. Otherwise, 
we need to make a cut here, start a new subarray with the current element num. This leads to an increment in the number of subarrays.

After we have finished the whole process, we need to compare the value cnt to the size limit of subarrays m. If cnt <= m, 
it means we can find a splitting method that ensures the maximum largest subarray sum will not exceed x. Otherwise, F(x) should be false.

Complexity Analysis

Time complexity : O(n∗log(sum of array)). The binary search costs O(log(sum of array)), where sum of array is the sum of elements
in nums. For each computation of F(x), the time complexity is O(n) since we only need to go through the whole array.
Space complexity : O(n). Same as the Brute Force approach. We only need the space to store the array.
"""

class Solution:
    def splitArray(self, nums: List[int], m: int) -> int:
        
        def find_split(mid):
            count = 0
            split = 1
            for n in nums:
                count += n
                if count > mid:
                    split += 1
                    count = n
                    if split > m:
                        break
            return split
        
        l, h = max(nums), 0
        for n in nums:
            h += n
        res = sys.maxsize
        while l <= h:
            mid = (l + h) // 2
            split = find_split(mid)
            if split > m:
                l = mid + 1
            elif split <= m:
                h = mid - 1
                res = min(res, mid)
        return res
