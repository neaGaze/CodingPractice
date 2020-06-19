"""
Given a sorted integer array nums, where the range of elements are in the inclusive range [lower, upper], return its missing ranges.

Example:

Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
Output: ["2", "4->49", "51->74", "76->99"]

Solution:

Using f'' syntax for string formatting
using zip and itertools.chain to get concise code with minimal overhead
class Solution:
    def findMissingRanges(self, nums: List[int], lower: int, upper: int) -> List[str]:
        def checkMissedRange(n1, n2):
            if n2 - n1 <= 1:
                return None
            if n2 - n1 == 2:
                return f'{n1 + 1}'
            return f'{n1+1}->{n2-1}'

        all_missed_ranges = []
        for a,b in zip(itertools.chain([lower-1], nums), itertools.chain(nums, [upper+1])):
            r = checkMissedRange(a, b)
            if r:
                all_missed_ranges.append(r)
        return all_missed_ranges

"""
