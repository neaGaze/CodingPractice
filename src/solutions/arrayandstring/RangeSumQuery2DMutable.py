"""
Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

Range Sum Query 2D
The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.

Example:
Given matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]

sumRegion(2, 1, 4, 3) -> 8
update(3, 2, 2)
sumRegion(2, 1, 4, 3) -> 10
Note:
The matrix is only modifiable by the update function.
You may assume the number of calls to update and sumRegion function is distributed evenly.
You may assume that row1 ≤ row2 and col1 ≤ col2.
"""

class NumMatrix:

    def __init__(self, matrix: List[List[int]]):
        self.row = len(matrix)
        self.col = len(matrix[0]) if self.row > 0 else 0
        
        for i in range(self.row):
            abc = ""
            for j in range(self.col):
                upper = matrix[i-1][j] if i > 0 else 0
                left = matrix[i][j-1] if j > 0 else 0
                diagonal = matrix[i-1][j-1] if (i > 0 and j > 0) else 0
                matrix[i][j] = matrix[i][j] + upper + left - diagonal 
                
        self.total_sum = matrix

    def update(self, row: int, col: int, val: int) -> None:
        """
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
         
  
  3 3 4 8 10 
8 14 18 24 27 
9 17 21 28 36 
13 22 26 34 49 
14 23 30 38 58 
        """
        upper = self.total_sum[row-1][col] if row > 0 else 0
        left = self.total_sum[row][col-1] if col > 0 else 0
        diagonal = self.total_sum[row-1][col-1] if (row > 0 and col > 0) else 0
        diff = self.total_sum[row][col] - upper - left + diagonal - val
        #print(diff)
        for i in range(row, self.row):
            abc = ""
            for j in range(col, self.col):
                self.total_sum[i][j] -= diff
                #abc += str(self.total_sum[i][j]) + " "
            #print(abc)    
        

    def sumRegion(self, row1: int, col1: int, row2: int, col2: int) -> int:        
        upper = self.total_sum[row1-1][col2] if row1 > 0 else 0
        left = self.total_sum[row2][col1-1] if col1 > 0 else 0
        diagonal = self.total_sum[row1-1][col1-1] if (row1 > 0 and col1 > 0) else 0
        sum_total = self.total_sum[row2][col2] - upper - left + diagonal
        return sum_total

# Your NumMatrix object will be instantiated and called as such:
# obj = NumMatrix(matrix)
# obj.update(row,col,val)
# param_2 = obj.sumRegion(row1,col1,row2,col2)
