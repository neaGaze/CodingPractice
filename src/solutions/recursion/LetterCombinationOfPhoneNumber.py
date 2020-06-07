class Solution:
    
    def dfs(self, index, forms):
        if index >= len(self.digits):
            return forms
        
        cur_digit = self.digits[index]
        arr = self.mappings[cur_digit]
                
        # go through each possiblities
        for each in arr:
            a = self.dfs(index + 1, forms + each)
            
            if len(a) == len(self.digits):
                self.ans.append(a)
            
        return forms
    
    # Time complexity : O(3^N * 4^M) where N is the number of digits in the input that maps to 3 letters (e.g. 2, 3, 4, 5, 6, 8) and M is the number of digits in the input that maps to 4 letters (e.g. 7, 9), and N+M is the total number digits in the input.

    #Space complexity : O(3^N * 4^M) since one has to keep 3^N times 4^M == 3N×4M solutions.
    def letterCombinations(self, digits: str) -> List[str]:
        self.mappings = {
            '1': [''],
            '2': ['a','b','c'],
            '3': ['d','e','f'],
            '4': ['g','h','i'],
            '5': ['j','k','l'],
            '6': ['m','n','o'],
            '7': ['p','q','r','s'],
            '8': ['t','u','v'],
            '9': ['w','x','y','z']
        }
        self.ans = []
        self.digits = digits
        self.dfs(0, '')
        return self.ans
