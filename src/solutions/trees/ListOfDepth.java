package solutions.trees;

import java.util.*;

/**
 * Created by neaGaze on 10/3/18.
 */
public class ListOfDepth {

    public static class TreeNode<Integer> {
        Integer val;
        TreeNode<Integer> left;
        TreeNode<Integer> right;

        public TreeNode(Integer val){
            this.val = val;
        }

        public TreeNode(Integer val, TreeNode<Integer> left, TreeNode<Integer> right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public void buildLinkedList(TreeNode root) {
        ArrayList<LinkedList<Integer>> arrList = new ArrayList<>();
        dfs(arrList, 0, root);
        System.out.println("### output ###");
        for(LinkedList<Integer> r : arrList) {
            StringBuilder str = new StringBuilder();
            while(r.peek() != null) {
                str.append(r.poll()+" ");
            }
            System.out.print("\n"+str.toString());
        }

    }

    public void dfs(ArrayList<LinkedList<Integer>> list, int depth, TreeNode<Integer> node) {
        if(node == null) return;

        LinkedList<Integer> l = null; //list.get(depth);
        if(list.size() == depth) l = new LinkedList<>();
        else l = list.remove(depth);
        l.offer(node.val);
        list.add(depth, l);
        System.out.println(""+depth+": " + l.toString());
        dfs(list, depth+1, node.left);
        dfs(list, depth+1, node.right);
    }

    public static void test() {
        ListOfDepth tree = new ListOfDepth();
        TreeNode<Integer> ll = new ListOfDepth.TreeNode<Integer>(4);
        TreeNode<Integer> lr = new ListOfDepth.TreeNode<Integer>(1);
        TreeNode<Integer> l = new ListOfDepth.TreeNode<Integer>(11, ll, lr);
        TreeNode<Integer> rlr = new ListOfDepth.TreeNode<Integer>(6);
        TreeNode<Integer> rl = new ListOfDepth.TreeNode<Integer>(2, null, rlr);
        TreeNode<Integer> r = new ListOfDepth.TreeNode<Integer>(5, rl, null);
        TreeNode<Integer> root = new ListOfDepth.TreeNode<Integer>(7, l, r);
        tree.buildLinkedList(root);
    }
}
