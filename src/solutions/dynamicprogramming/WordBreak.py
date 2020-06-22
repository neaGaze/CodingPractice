"""
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.

Example 1:
Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code"

Example 2:
Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
Example 3:
Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false

Example 4:
Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat", "ando", "g"]
Output: True

Example 5:
Input: s = "aaaaaaa", wordDict = ["aaaa", "aaa"]
Output: True

"""

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        """        
        Time: O(n^2)
        Space: O(n)
        """
        N = len(s)
        wordSet = set(wordDict)
        dp = [False]*(N+1)
        dp[N] = True
        j = N
        past = [N]
        for i in range(N-1,-1,-1):
            for k in past:
                word = s[i:k]
                if word in wordSet:
                    dp[i] = dp[k] or dp[i]
                    j = i
                    if dp[i]:
                        past.append(i)
                        break
        return dp[0]  
