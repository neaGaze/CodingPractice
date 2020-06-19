"""
A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Write a function to determine if a number is strobogrammatic. The number is represented as a string.

Example 1:

Input:  "69"
Output: true
Example 2:

Input:  "88"
Output: true
Example 3:

Input:  "962"
Output: false

Solution:
class Solution:
    def isStrobogrammatic(self, num: str) -> bool:
        if(int(num)!=0 and num[0]=='0'):
            return False
        return self.isStrobogrammaticHelper(num)
        
        
    def isStrobogrammaticHelper(self, num: str) -> bool:
        if(len(num)==0):
            return True
        if(len(num)==1):
            if(int(num) in {0,1,8}):
                return True
            else:
                return False  
        
        set = {(0,0),(1,1),(8,8),(6,9),(9,6)}
        
        l = len(num)
        return (int(num[0]),int(num[l-1]))in set and self.isStrobogrammaticHelper(num[1:l-1])
"""

class Solution:
    def isStrobogrammatic(self, num: str) -> bool:
