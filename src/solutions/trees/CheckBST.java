package solutions.trees;

/**
 * Created by neaGaze on 10/6/18.
 */
public class CheckBST {

    public static class Node {
        Integer data;
        Node left, right;
        public Node(Integer data, Node left, Node right) {
            this.left = left;
            this.right = right;
            this.data = data;
        }
    }

    public boolean checkBST(Node root) {
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean checkBST(Node root, Integer min, Integer max) {
        if(root == null) return true;

        if(root.data < min || root.data > max) return false;

        return checkBST(root.left, min, root.data) && checkBST(root.right, root.data, max);
    }

    public static void test() {
        test1();
        test2();
    }

    public static void test1() {
        // false case
        Node lr = new Node(25,null, null);
        Node l = new Node(10, null, lr);
        Node r = new Node(30, null, null);
        Node node = new Node(20, l, r);

        CheckBST c = new CheckBST();
        System.out.println("Is the tree Binary Search Tree? " + c.checkBST(node) + "\n");
    }

    public static void test2() {
        // false case
        Node lr = new Node(20,null, null);
        Node l = new Node(10, null, lr);
        Node r = new Node(30, null, null);
        Node node = new Node(25, l, r);

        CheckBST c = new CheckBST();
        System.out.println("Is the tree Binary Search Tree? " + c.checkBST(node) + "\n");
    }
}
