"""
Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.

Example:
Given a / b = 2.0, b / c = 3.0.
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
return [6.0, 0.5, -1.0, 1.0, -1.0 ].

The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries , where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.

According to the example above:

equations = [ ["a", "b"], ["b", "c"] ],
values = [2.0, 3.0],
queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ]. 


equations = [ ["a", "b"], ["b", "c"], ["c", "d"], ["d", "e"] ],
values = [3.0, 4.0, 5.0, 6.0],
queries = [ ["a", "c"], ["b", "d"], ["a", "e"], ["a", "f"], ["x", "x"] ]. 
 

The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.
"""
# Time: O(m + n*m) where m is the length of the equations and n is the length of the queries
# Space: O(m) where m is the length of the equations
class Solution:

    def get_value(self, src, dest):
        if (src, dest) in self.hmap:
            return self.hmap[(src,dest)] 
        if (dest, src) in self.hmap:
            return (1 / self.hmap[(dest, src)])
        return -1
    
    def query_calc(self, src, dest, visited={}, prod=1):
        
        if src not in self.reln or dest not in self.reln:
            return -1, False
        
        if src == dest:
            return prod, True
        
        visited[src] = True
        
        res, valid = -1, False
        for cand in self.reln[src]:
            if cand not in visited:
                res, valid = self.query_calc(cand, dest, visited, prod * self.get_value(src, cand) )
                if valid:
                    break
            
        return res, valid
    
  
    
    def calcEquation(self, equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:
        self.hmap = {}
        self.reln = {}
        eqn_count = len(equations)
        for i in range(eqn_count):
            eqn = equations[i]
            self.hmap[(eqn[0], eqn[1])] = values[i]
            
            if eqn[0] not in self.reln:
                self.reln[eqn[0]] = []
            if eqn[1] not in self.reln:
                self.reln[eqn[1]] = []
            self.reln[eqn[0]].append(eqn[1])
            self.reln[eqn[1]].append(eqn[0])
 
        res = []
        for query in queries:
            visited = {}
            a, b = self.query_calc(query[0], query[1], visited)
            res.append(a)
        return res
        
