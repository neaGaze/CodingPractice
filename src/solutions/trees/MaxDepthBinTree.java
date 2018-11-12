package solutions.trees;

public class MaxDepthBinTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int maxDepth(TreeNode root) {
        return findMaxDepth(root, 1);
    }

    public int findMaxDepth(TreeNode node, int depth) {
        if(node == null) return depth - 1;

        return Math.max(findMaxDepth(node.left, depth + 1), findMaxDepth(node.right, depth + 1));
    }
}
