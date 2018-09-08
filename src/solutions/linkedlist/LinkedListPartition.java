package solutions.linkedlist;

import solutions.arrayandstring.BaseClass;

/**
 * Write a code to partition a linked list around a value x, such that all nodes less than x come before all nodes
 * greater than or equal to x. If x is contained within the list, the value of x only need to be after the elements
 * less than x. The partition element x can appear anywhere in the "right partition"; it doesn't need to appear between
 * the left and right partition
 *
 * Eg:
 * Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition = 5]
 * Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
 */
public class LinkedListPartition extends BaseClass {

    private LinkedLIst list;
    private int partition;

    public LinkedListPartition() {}

    public LinkedListPartition(int[] arr, int partition) {
        list = new LinkedLIst(arr);
        this.partition = partition;
    }

    /**
     * Time complexity : O(n)
     * Space Complexity : O(1)
     ***/
    private void getPartition() {
        LinkedLIst.Node head = list.getHead();
        if(head == null) return;

        LinkedLIst.Node child = head.getNext();
        LinkedLIst.Node partNode = null;

        while(child != null && head != null) {
            if(partNode == null) {
                if (child.getData() == partition) {
                    partNode = head;

                }
            } else {
                if(child.getData() < partition) {
                    // delete from current pos
                    LinkedLIst.Node curNode = child;
                    head.setNext(child.getNext());

                    // insert before the partition element
                    curNode.setNext(partNode.getNext());
                    partNode.setNext(curNode);

                    // set the partition node as currentNode
                    partNode = curNode;
                }
            }

            head = child;
            if(head != null) child = head.getNext();
        }
        list.printList();
    }

    @Override
    public void test() {
        super.test();
        LinkedListPartition a = new LinkedListPartition(new int[]{1, 2, 3, 4, 5}, 4);
        a.getPartition();

        LinkedListPartition b = new LinkedListPartition(new int[]{3, 5, 8 ,5, 10, 2, 1}, 5);
        b.getPartition();
    }

    public void print(String str) {
        System.out.println(str);
    }
}
