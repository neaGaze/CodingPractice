package solutions.linkedlist;

import solutions.arrayandstring.BaseClass;

/**
 * Given two (singly) linked list, determine if the two lists intersect. Return the intersecting node. Note
 * that the intersection is defined based on the reference, not value. That is, if the kth node of the first
 * linked list is the exact same node (by reference) s the jth node of the second linked list, then they are intersecting
 *
 * For Eg:
 *
 * 3 -> 1 - > 5 -> 9 -> 7 -> 2 -> 1
 * 4 -> 6 -> 7 -> 2 -> 1
 *
 * Both are intersecting at node 7
 */
public class Intersection extends BaseClass {

    private LinkedLIst a, b;

    public Intersection() {}

    public Intersection(int[] a, int[] b, int[] commonNodes) {
        this.a = new LinkedLIst(a);
        this.b = new LinkedLIst(b);
        LinkedLIst common = new LinkedLIst(commonNodes);
        LinkedLIst.Node headA = this.a.getHead();
        while(headA.getNext() != null)
            headA = headA.getNext();
        headA.setNext(common.getHead());

        LinkedLIst.Node headB = this.b.getHead();
        while(headB.getNext() != null)
            headB = headB.getNext();
        headB.setNext(common.getHead());

        this.a.printList();
        this.b.printList();
    }


    public LinkedLIst.Node recursiveIntersection(LinkedLIst.Node firstNode, LinkedLIst.Node secondNode) {

        //System.out.println(" -- first: " + firstNode.getData() + " vs second: " + secondNode.getData());
        if(firstNode == null && secondNode == null) return null;

        LinkedLIst.Node nextFirstNode = firstNode != null ? firstNode.getNext() : firstNode;
        LinkedLIst.Node nextSecondNode = secondNode != null ? secondNode.getNext() : secondNode;
        System.out.println(" -- first: " + (nextFirstNode != null ? nextFirstNode.getData() : "null") + " vs second: " +
                (nextSecondNode != null ? nextSecondNode.getData() : "null"));

        LinkedLIst.Node intersectingNode = recursiveIntersection(nextFirstNode, nextSecondNode);

        //if(intersectingNode != null) return intersectingNode;
        if(firstNode == secondNode) {
            System.out.println("Printing same nodes: " + (firstNode != null ? firstNode.getData() : "null"));
            return firstNode;
        }
        return intersectingNode;
    }

    /**
     * Time Complexity : O()
     * Space Complexity : O()
     ***/
    public LinkedLIst.Node findIntersect(LinkedLIst.Node firstNode, LinkedLIst.Node secondNode) {
        int lenA = 0, lenB = 0;
        LinkedLIst.Node headA = firstNode;
        while(headA != null) {
            lenA++;
            headA = headA.getNext();
        }
        LinkedLIst.Node headB = secondNode;
        while(headB != null) {
            lenB++;
            headB = headB.getNext();
        }

        headA = firstNode;
        headB = secondNode;

        int diff = lenA - lenB;
        if(diff >= 0) {
            for(int i = 0; i < diff; i++)
                headA = headA.getNext();

        } else {
            for(int i = 0; i < Math.abs(diff); i++)
                headB = headB.getNext();
        }
        return recursiveIntersection(headA, headB);
    }
    
    @Override
    public void test() {
        super.test();
        Intersection a = new Intersection(new int[] {3, 1, 5, 9}, new int[] {4, 6}, new int[] {7, 2, 1});
        printNode(a.findIntersect(a.getA().getHead(), a.getB().getHead()));

        Intersection b = new Intersection(new int[] {9, 8, 7, 6}, new int[] {4, 6}, new int[] {});
        printNode(b.findIntersect(a.getA().getHead(), b.getB().getHead()));
    }

    public void printNode(LinkedLIst.Node node) {
        System.out.println("\n**** The intersecting node is: " + (node != null ? node.getData() : "null") + " ****\n");
    }

    public LinkedLIst getA() {
        return a;
    }

    public void setA(LinkedLIst a) {
        this.a = a;
    }

    public LinkedLIst getB() {
        return b;
    }

    public void setB(LinkedLIst b) {
        this.b = b;
    }
}
