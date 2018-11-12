package solutions.trees;

/**
 * Check Subtree: Tl and T2 are two very large binary trees, with Tl much bigger than T2. Create an
 * algorithm to determine if T2 is a subtree of Tl.
 * A tree T2 is a subtree ofTi if there exists a node n in Ti such that the subtree of n is identical to T2.
 * That is, if you cut off the tree at node n, the two trees would be identical.
 ***/
public class CheckSubTree {

    TreeNode t1 = null, t2 = null;

    public class TreeNode {
        Integer val;
        TreeNode left, right;

        public TreeNode(Integer val) {
            this.val = val;
        }
    }

    public boolean isSubTree(Integer[] arrT1, Integer[] arrT2) {
        t1 = constructTree(arrT1, t1, 0);
        //System.out.println("\n");
        t2 = constructTree(arrT2, t2, 0);

        return recurse(t1, t2);

    }

    /**
     *   Time Complexity: O(n), where n is the total no of nodes in t1
     *   Space Complexity: O(n), where n is the total no of nodes in t1
     ****/
    public boolean recurse(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null)
            return true;

        if((t1 == null && t2 != null) || (t1 != null && t2 == null))
            return false;

        boolean v = false;
        if(t1.val == t2.val)
            v = recurse(t1.left, t2.left) && recurse(t1.right, t2.right);

        if(v) return v;
        else return recurse(t1.left, t2) || recurse(t1.right, t2);
    }

    public TreeNode constructTree(Integer[] nodes, TreeNode node, Integer i) {
        if(nodes.length == 0 || i >= nodes.length) return null;

        node = new TreeNode(nodes[i]);
        //System.out.println(nodes[i]);
        node.left = constructTree(nodes, node.left, 2 * i + 1);
        node.right = constructTree(nodes, node.right, 2 * i + 2);
        return node;
    }

    public void print() {

    }

    public static void test() {
        CheckSubTree checkSubTree = new CheckSubTree();
        // assert = True
        Integer[] arr1 = new Integer[] {8, 5, 7, 3, 1, 6, 9, null, 4, null, null, null, null, null, null};
        Integer[] arr2 = new Integer[] {5, 3, 1, null, 4, null, null};
        System.out.println(checkSubTree.isSubTree(arr1, arr2));

        // assert = True
        arr1 = new Integer[] {8, 7, 5, 6, 9, 3, 1, null, null, null, null, null, 4, null, null};
        arr2 = new Integer[] {5, 3, 1, null, 4, null, null};
        System.out.println(checkSubTree.isSubTree(arr1, arr2));

        // assert = False
        arr1 = new Integer[] {8, 5, 7, 3, 1, 6, 9, null, null, null, null, null, null, null, null};
        arr2 = new Integer[] {5, 3, 1, null, 4, null, null};
        System.out.println(checkSubTree.isSubTree(arr1, arr2));

        // assert = True
        arr1 = new Integer[] {5, 5, 7, 3, 1, 6, 9, null, 4, null, null, null, null, null, null};
        arr2 = new Integer[] {5, 3, 1, null, 4, null, null};
        System.out.println(checkSubTree.isSubTree(arr1, arr2));

        // assert = False
        arr1 = new Integer[] {8, 5, 7, 3, 1, 6, 9, 9, 4, null, null, null, null, null, null};
        arr2 = new Integer[] {5, 3, 1, null, 4, null, null};
        System.out.println(checkSubTree.isSubTree(arr1, arr2));
    }
}
