"""
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
"""

class Solution:
    def find_next_big(self, nums, val, index):
        next_max = index
        i = index
        while i < len(nums) and nums[i] > val:
            next_max = i
            i += 1
        return next_max  
        
    def rearrange(self, nums, index):
        last_index = len(nums)-1
        first_index = index
        i = index
        while i <= (first_index + last_index) // 2:
            tmp = nums[last_index]
            nums[last_index] = nums[first_index]
            nums[first_index] = tmp
            first_index += 1
            last_index -= 1
            i += 1
            
        
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        [132456] -> [132465]
        [132465] -> [132546]
        """
        if len(nums) < 2:
            return nums
            
        i = len(nums)-2
        while i >= 0:
            val = nums[i]
            if val < nums[i+1]:
                next_big_index = self.find_next_big(nums, val, i+1)
                nums[i] = nums[next_big_index]
                nums[next_big_index] = val
                self.rearrange(nums, i+1)
                return
           
            i -= 1
        self.rearrange(nums, 0)
