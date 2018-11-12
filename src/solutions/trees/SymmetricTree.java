package solutions.trees;

public class SymmetricTree {
    public class TreeNode {
         int val;
          TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;

        if((left == null && right != null) || (left != null && right == null) || (left.val != right.val)) return false;

        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

}
