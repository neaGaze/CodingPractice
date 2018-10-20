package solutions.trees;

/**
 * Created by neaGaze on 10/14/18.
 */
public class FirstCommonAncestor {
    public class Node {
        int val;
        Node left, right;
	    public Node(int val) {
            this.val = val;
        }
    }

    public class NodeProps {
        Node node;
        Boolean isFound;
        public NodeProps(Node node, boolean isFound) {
            this.node = node;
            this.isFound = isFound;
        }
    }

    public boolean contains(Node root, Node child) {
        if(root == null) return false;
        if(root == child) return true;
        return contains(root.left, child) || contains(root.right, child);
    }

    /***
     *  Top Down appraoch where the root will check if the node contains `a` and/or `b`.
     *  Haven't checked yet
     ***/
    public Node findCommonAnc(Node root, Node a, Node b) {
        return traverse(root, a, b, new NodeProps(null, false));
    }


    public Node traverse(Node root, Node a, Node b, NodeProps props)  {
        if(root == null || a == null || b == null) return root;

        if(a == root || b == root) return root;

        if(props.isFound) return props.node;

        boolean leftA = contains(root.left, a);
        boolean leftB = contains(root.left, b);

        if(leftA && !leftB || !leftA && leftB) {
            props.node = root;
            props.isFound = true;
            return root;
        }

        if(leftA && leftB) {
            return traverse(root.left, a, b, props);
        } else {
            return traverse(root.right, a, b, props);
        }
    }

}
