"""
Given a complete binary tree, count the number of nodes.

Note:

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Example:

Input: 
    1
   / \
  2   3
 / \  /
4  5 6

Output: 6
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def find_depth(self, node, direction, depth):
        if node == None:
            return depth-1
        #if node.val in self.mapper:
        #    return self.mapper[node.val]
        #self.mapper[node.val] = depth
        return self.find_depth(node.left if direction < 0 else node.right, -1, depth+1)
    
    def countNodes(self, root: TreeNode) -> int:
        #self.mapper = {}
        max_depth = 0
        node = root
        last_node = 0
        offset = 1
        # depth = 0
        
        while node != None:
            last_node = 2 * last_node + offset
            # depth += 1
            left_depth = self.find_depth(node, -1, 1)
            right_depth = self.find_depth(node, 1, 1)
            max_depth = max(left_depth, right_depth)
            #last_node = node.val
            if left_depth == right_depth:
                node = node.right
                offset = 1
            else:
                node = node.left
                offset = 0
               
        #sum_of_nodes = pow(2, max_depth)-1 # sum of all the nodes until  the max_depth
        return last_node
