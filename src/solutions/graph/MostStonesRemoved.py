"""
### GOOGLE MOST ASKED QUESTION ###

Most Stones Removed with Same Row or Column:
On a 2D plane, we place stones at some integer coordinate points.  Each coordinate point may have at most one stone.

Now, a move consists of removing a stone that shares a column or row with another stone on the grid.

What is the largest possible number of moves we can make?

 

Example 1:

Input: stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
Output: 5
Example 2:

Input: stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
Output: 3
Example 3:

Input: stones = [[0,0]]
Output: 0
 

Note:

1 <= stones.length <= 1000
0 <= stones[i][j] < 10000

Solution:
Approach 1: Depth-First Search
Algorithm

To count connected components of the above graph, we will use depth-first search.
For every stone not yet visited, we will visit it and any stone in the same connected component. Our depth-first search traverses each node in the component.
For each component, the answer changes by -1 + component.size.

class Solution(object):
    def removeStones(self, stones):
        graph = collections.defaultdict(list)
        for i, x in enumerate(stones):
            for j in xrange(i):
                y = stones[j]
                if x[0]==y[0] or x[1]==y[1]:
                    graph[i].append(j)
                    graph[j].append(i)

        N = len(stones)
        ans = 0

        seen = [False] * N
        for i in xrange(N):
            if not seen[i]:
                stack = [i]
                seen[i] = True
                while stack:
                    ans += 1
                    node = stack.pop()
                    for nei in graph[node]:
                        if not seen[nei]:
                            stack.append(nei)
                            seen[nei] = True
                ans -= 1
        return ans
        
Complexity Analysis
Time Complexity: O(N^2), where NN is the length of stones.
Space Complexity: O(N^2)

Approach 2: Union-Find
Algorithm

Let's connect row i to column j, which will be represented by j+10000. The answer is the number of components after making all the connections.
Note that for brevity, our DSU implementation does not use union-by-rank. This makes the asymptotic time complexity larger.

class DSU:
    def __init__(self, N):
        self.p = range(N)

    def find(self, x):
        if self.p[x] != x:
            self.p[x] = self.find(self.p[x])
        return self.p[x]

    def union(self, x, y):
        xr = self.find(x)
        yr = self.find(y)
        self.p[xr] = yr

class Solution(object):
    def removeStones(self, stones):
        N = len(stones)
        dsu = DSU(20000)
        for x, y in stones:
            dsu.union(x, y + 10000)

        return N - len({dsu.find(x) for x, y in stones})
        
Complexity Analysis

Time Complexity: O(NlogN), where NN is the length of stones. (If we used union-by-rank, this can be O(N∗α(N)), where \alphaα is the Inverse-Ackermann function.)
Space Complexity: O(N)
"""
