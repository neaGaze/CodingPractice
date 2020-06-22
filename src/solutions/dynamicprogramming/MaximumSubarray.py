"""
### GOOGLE INTERVIEW FREQ ASKED ###

Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example #1:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

Example #2:
Input: [-2,-1],
Output: -1

Example #3:
Input: [-1,-2],
Output: -1

Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

Solution:
Approach 2: Greedy
class Solution:
    def maxSubArray(self, nums: 'List[int]') -> 'int':
        n = len(nums)
        curr_sum = max_sum = nums[0]

        for i in range(1, n):
            curr_sum = max(nums[i], curr_sum + nums[i])
            max_sum = max(max_sum, curr_sum)
            
        return max_sum
        
Complexity Analysis
Time complexity : O(N) since it's one pass along the array.
Space complexity : O(1), since it's a constant space solution.

Approach 3: Dynamic Programming (Kadane's algorithm)
The problem to find sum or maximum or minimum in an entire array or in a fixed-size sliding window could be solved by the dynamic programming (DP) approach in linear time.

There are two standard DP approaches suitable for arrays:

Constant space one. Move along the array and modify the array itself.

Linear space one. First move in the direction left->right, then in the direction right->left. Combine the results. Here is an example.

Let's use here the first approach since one could modify the array to track the current local maximum sum at this given point.

Next step is to update the global maximum sum, knowing the local one.

class Solution:
    def maxSubArray(self, nums: 'List[int]') -> 'int':
        n = len(nums)
        max_sum = nums[0]
        for i in range(1, n):
            if nums[i - 1] > 0:
                nums[i] += nums[i - 1] 
            max_sum = max(nums[i], max_sum)

        return max_sum
        
Complexity Analysis
Time complexity : O(N) since it's one pass along the array.
Space complexity : O(1), since it's a constant space solution.
"""

class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        N = len(nums)
        dp = [-sys.maxsize-1]*(N+1)
        maxsum = -sys.maxsize-1
        for i in range(N):
            dp[i] = max(dp[i-1] + nums[i], nums[i])
            maxsum = max(maxsum, dp[i])
        return maxsum
