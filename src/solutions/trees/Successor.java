package solutions.trees;

/**
 * Created by neaGaze on 10/6/18.
 */
public class Successor {

    public static class Node {
        Node left, right, parent;
        int val;

        public Node(int val, Node left, Node right) {
            this.left = left;
            this.right = right;
            this.val = val;
        }
    }

        public Node findLeftMost(Node node) {
            if(node == null) return null;
            if(node.left == null) return node;
            return findLeftMost(node.left);
        }

        public Node findNextInOrder(Node curNode) {
            if(curNode == null) return null;
            if(curNode.right != null) return findLeftMost(curNode.right);
            Node parent = curNode;
            while(parent != null) {
                parent = curNode.parent;
                if(parent.left == curNode) return parent;
                curNode = parent;
            }
            return parent;
        }


    public static void test() {
        test1();
    }

    public static void test1() {
        Node lll = new Node(5, null, null);
        Node llr = new Node(4, null, null);
        Node ll = new Node(3, lll, llr);
        Node rr = new Node(7, null, null);
        Node l = new Node(2, ll, null);
        Node r = new Node(6, null, rr);
        Node node = new Node(1, l, r);
        lll.parent = ll;
        llr.parent = ll;
        ll.parent = l;
        rr.parent = r;
        l.parent = node;
        r.parent = node;
        Successor successor = new Successor();

        System.out.println("The next node in-order traversal from " + ll.val + " is: " + successor.findNextInOrder(ll).val);
        System.out.println("The next node in-order traversal from " + lll.val + " is: " + successor.findNextInOrder(lll).val);
        System.out.println("The next node in-order traversal from " + llr.val + " is: " + successor.findNextInOrder(llr).val);
        System.out.println("The next node in-order traversal from " + rr.val + " is: " + successor.findNextInOrder(rr).val);
    }
}
