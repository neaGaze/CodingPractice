package solutions.trees;

/**
 * Created by neaGaze on 10/5/18.
 */
public class CheckBalanced {
    public static class Node {
        Node left, right;
        public Node(Node left, Node right) {
            this.left = left;
            this.right = right;
        }
    }

    public static class NodeProps {
        int depth;
        boolean isBalanced;
        public NodeProps(int depth, boolean isBalanced) {
            this.depth = depth;
            this.isBalanced = isBalanced;
        }
    }

    public boolean isBalancedTree(Node node) {
        return recursiveBalanced(node, new NodeProps(0, true)).isBalanced;
    }

    private NodeProps recursiveBalanced(Node node, NodeProps props) {
        if(!props.isBalanced)
        return props;

        if(node.left == null && node.right == null) return props;

        int leftDepth = props.depth, rightDepth = props.depth;
        if(node.left != null) leftDepth = recursiveBalanced(node.left, new NodeProps(props.depth+1, props.isBalanced)).depth;
        if(node.right != null) rightDepth = recursiveBalanced(node.right, new NodeProps(props.depth+1, props.isBalanced)).depth;
        boolean isBalanced = Math.abs(leftDepth - rightDepth) <= 1;
        System.out.println("Checking the balance of tree: " + leftDepth + " - " + rightDepth + " = " + isBalanced);
        int newDepth = Math.max(leftDepth, rightDepth);
        return new NodeProps(newDepth, isBalanced);
    }


    public static void test() {
        test1();
        test2();
    }

    public static void test1() {
        Node lll = new Node(null, null);
        Node ll = new Node(lll, null);
        Node lr = new Node(null, null);
        Node l = new Node(ll, lr);
        Node r = new Node(null, null);
        Node node = new Node(l, r);

        CheckBalanced checkBalanced = new CheckBalanced();
        System.out.println("Is the tree balanced? " + checkBalanced.isBalancedTree(node) + "\n");
    }

    public static void test2() {
        Node lll = new Node(null, null);
        Node ll = new Node(lll, null);
        Node lr = new Node(null, null);
        Node l = new Node(ll, lr);
        Node rl = new Node(null, null);
        Node r = new Node(rl, null);
        Node node = new Node(l, r);

        CheckBalanced checkBalanced = new CheckBalanced();
        System.out.println("Is the tree balanced? " + checkBalanced.isBalancedTree(node) + "\n");
    }
}
