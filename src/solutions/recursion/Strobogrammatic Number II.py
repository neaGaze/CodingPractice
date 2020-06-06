"""
A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Find all strobogrammatic numbers that are of length = n.

Example:

Input:  n = 2
Output: ["11","69","88","96"]
"""

class Solution:
    def findStrobogrammatic(self, n: int) -> List[str]:
        """
        1 -> 1
        6 -> 9
        9 -> 6
        8 -> 8
        
        [111, 888, 619, 916, 689, 986, 818, 181]
        
        1 -> [111, 818, 619, 916]
        8 -> [181, 888, 689, 986]
        0 -> [101, 808, 609, 906]
         
        [1111, 8888, 6699, 9696, 1691, 8698, 6969, 9966, 1961, 8968, 6119, 9116, 6889, 9886, 8118, 1881 ]
    
        11 -> [1111, 8118, 6119, 9116]
        88 -> [1881, 8888, 6889, 9886]
        69 -> [1691, 8698, 6699, 9696]
        96 -> [1961, 8968, 6969, 9966]
        00 -> [1001, 8008, 6009, 9006]
        
        1. Base case: [11, 88, 69, 96] if n == 2 or [1, 8] if n == 1
        2. Recusively add 
         
        """
        if n == 0:
            return []
        strobo_nums = ["0", "1", "8"] if n % 2 != 0 else ["11", "88", "69", "96"]
        if n < 3:
            return strobo_nums
        if n % 2 == 0:
            strobo_nums.append("00")
        count = len(strobo_nums[0])
        while count < n:
            new_nums = []
            for each in strobo_nums:
                new_nums.append('1'+each+'1')
                new_nums.append('8'+each+'8')
                new_nums.append('6'+each+'9')
                new_nums.append('9'+each+'6')
                if count < n - 2:
                    new_nums.append('0'+each+'0')
                    
            strobo_nums = new_nums
            count += 2
        return strobo_nums
    
