package solutions.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by neaGaze on 10/7/18.
 */
public class BSTSequence {

    public class Node {
        Integer value;
        Node left, right;
        public Node(Integer value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    private LinkedList<Node> queue;
    private ArrayList<LinkedList<Integer>> list;

    public BSTSequence() {
        queue = new LinkedList<>();
        list = new ArrayList<>();
    }

    public void findSeq(Node root) {}

    /**
     * a = {}
     * b = {4}
     * finalWeaved = {1, 3, 2, 4}
     ****/
    public void weave(List<Node> a, List<Node> b, List<ArrayList<Node>> finalWeaved, LinkedList<Node> prefix) {

        if(a.size() > 0) {
            Node curANode = a.remove(0);
            prefix.add(curANode);
            weave(a, b, finalWeaved, prefix);
            a.add(0, curANode);
        }

        if(b.size() > 0) {
            Node curBNode = b.remove(0);
            prefix.add(curBNode);
            weave(a, b, finalWeaved, prefix);
            b.add(0, curBNode);
        }
    }
}
