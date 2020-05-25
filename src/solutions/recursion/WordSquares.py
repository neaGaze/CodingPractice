"""
Given a set of words (without duplicates), find all word squares you can build from them.

A sequence of words forms a valid word square if the kth row and column read the exact same string, 
where 0 ≤ k < max(numRows, numColumns).

For example, the word sequence ["ball","area","lead","lady"] forms a word square because each word reads the same both 
horizontally and vertically.

b a l l
a r e a
l e a d
l a d y
Note:
There are at least 1 and at most 1000 words.
All words will have the exact same length.
Word length is at least 1 and at most 5.
Each word contains only lowercase English alphabet a-z.
Example 1:

Input:
["area","lead","wall","lady","ball"]

Output:
[
  [ "wall",
    "area",
    "lead",
    "lady"
  ],
  [ "ball",
    "area",
    "lead",
    "lady"
  ]
]

Explanation:
The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).
Example 2:

Input:
["abat","baba","atan","atal"]

Output:
[
  [ "baba",
    "abat",
    "baba",
    "atan"
  ],
  [ "baba",
    "abat",
    "baba",
    "atal"
  ]
]

Explanation:
The output consists of two word squares. The order of output does not matter (just the order of words in each word squ

INCORRECT SOLUTION. TRY AGAIN
"""


class Solution:
    
    def recurse(self, res, index, prefix):
        if len(res) == len(self.words[0]):
            return
        for word in self.words:
            if prefix == word[0:index]:
                res.append(word)
                recurse(res, index - 1, word[(len(word)-index-1)::])
    
    def wordSquares(self, words: List[str]) -> List[List[str]]:
        result = []
        self.words = words
        for word in self.words:
          res = [word]
          self.recurse(res, len(word)-1, word[1::])
          if len(res) == len(word):
              result.append(res)
        return result
         
"""
Input:
["abat","baba","atan","atal"]

Output:
[
  [ "baba",
    "abat",
    "baba",
    "atan"
  ],
  [ "baba",
    "abat",
    "baba",
    "atal"
  ]
]
"""
    
    


