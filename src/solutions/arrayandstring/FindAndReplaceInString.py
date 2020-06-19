"""
To some string S, we will perform some replacement operations that replace groups of letters with new ones (not necessarily the same size).

Each replacement operation has 3 parameters: a starting index i, a source word x and a target word y.  The rule is that if x starts at position i in the original string S, then we will replace that occurrence of x with y.  If not, we do nothing.

For example, if we have S = "abcd" and we have some replacement operation i = 2, x = "cd", y = "ffff", then because "cd" starts at position 2 in the original string S, we will replace it with "ffff".

Using another example on S = "abcd", if we have both the replacement operation i = 0, x = "ab", y = "eee", as well as another replacement operation i = 2, x = "ec", y = "ffff", this second operation does nothing because in the original string S[2] = 'c', which doesn't match x[0] = 'e'.

All these operations occur simultaneously.  It's guaranteed that there won't be any overlap in replacement: for example, S = "abc", indexes = [0, 1], sources = ["ab","bc"] is not a valid test case.

Example 1:

Input: S = "abcd", indexes = [0,2], sources = ["a","cd"], targets = ["eee","ffff"]
Output: "eeebffff"
Explanation: "a" starts at index 0 in S, so it's replaced by "eee".
"cd" starts at index 2 in S, so it's replaced by "ffff".
Example 2:

Input: S = "abcd", indexes = [0,2], sources = ["ab","ec"], targets = ["eee","ffff"]
Output: "eeecd"
Explanation: "ab" starts at index 0 in S, so it's replaced by "eee". 
"ec" doesn't starts at index 2 in the original S, so we do nothing.
Notes:

0 <= indexes.length = sources.length = targets.length <= 100
0 < indexes[i] < S.length <= 1000
All characters in given inputs are lowercase letters.
 
 
 Eg:

        "vmokgggqzp"
        [3,5,1]
        ["kg","ggq","mo"]
        ["s","so","bfr"]
        Expected: "vbfrssozp"
        
        "mhnbzxkwzxtaanmhtoirxheyanoplbvjrovzudznmetkkxrdmr"
        [46,29,2,44,31,26,42,9,38,23,36,12,16,7,33,18]
        ["rym","kv","nbzxu","vx","js","tp","tc","jta","zqm","ya","uz","avm","tz","wn","yv","ird"]
        ["gfhc","uq","dntkw","wql","s","dmp","jqi","fp","hs","aqz","ix","jag","n","l","y","zww"]

        Expected: "mhnbzxkwzxtaanmhtoirxheaqznoplbvjrovzudznmetkkxrdmr"
"""

# Time: O(N*M) where N = len(S) and M = repleacement operation
# Space: O(M+N)

class Data:
    def __init__(self, index: int, s: str, r: str):
        self.index = index
        self.s = s
        self.r = r
        
class Solution:
    def findReplaceString(self, S: str, indexes: List[int], sources: List[str], targets: List[str]) -> str:
        s = []
        for i in range(len(indexes)):
            s.append(Data(indexes[i], sources[i], targets[i]))
            
        so = sorted(s, key=lambda a: a.index)
        
        index_pos, i = 0, 0
        new_str = ""
        while i < len(S):
            if index_pos < len(sources) and i == so[index_pos].index:
                d = so[index_pos]
                j = len(d.s) + i
                index_pos += 1
                if d.s == S[i:j]:
                    new_str += d.r
                    i = j
                    continue

            new_str += S[i]
            i += 1
        return new_str
