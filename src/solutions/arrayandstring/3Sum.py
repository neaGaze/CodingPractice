"""
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array
which gives the sum of zero.

Note:
The solution set must not contain duplicate triplets.

Example:
Given array nums = [-1, 0, 1, 2, -1, -4],
A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
"""
# [INCORRECT SOLUTION]
class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        num_count = {}
        final_list = []
        
        for j in range(1, len(nums)):
            for i in range(j):
                counter = -(nums[i] + nums[j])
                if counter not in num_count:
                    num_count[counter] = set()
                num_count[counter].add([nums[i], nums[j]] if nums[i] < nums[j] else [nums[j], nums[i]])
                
        for key, value in num_count:
            for elem in value:
                if -key == (elem[0] + elem[1]):
                    new_list = None
                    if -key <= elem[0] <= elem[1]:
                        new_list = [-key, elem[0], elem[1]]
                    elif elem[0] <= -key <= elem[1]:
                        new_list = [elem[0], -key, elem[1]]
                    else:
                        new_list = [elem[0], elem[1], -key]
                    final_list.append(new_list)
        return final_list
                
                
                
                
                
