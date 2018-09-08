package solutions.linkedlist;

import solutions.arrayandstring.BaseClass;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by neaGaze on 9/8/18.
 */
public class KthToLast extends BaseClass {

    private LinkedLIst linkedList;
    private int data =  -1;
    private int k;

    public KthToLast() {}

    public KthToLast(int[] arr, int k) {
        this.k = k;
        linkedList = new LinkedLIst(arr);
        if(k > arr.length)
            print("K can't be longer than the length of linkedList", -1);
        else {
            recursiveFind(linkedList.getHead(), this.k);
            print("kth element from the last using recursive appraoch : ", data);
            print("kth element from the last using iterative appraoch : ", iterativeApproach());
        }
    }

    public LinkedLIst getLinkedList() {
        return linkedList;
    }

    public void setLinkedList(LinkedLIst linkedList) {
        this.linkedList = linkedList;
    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(n)
     * **/
    private int recursiveFind(LinkedLIst.Node node, int i) {

        if (node == null) return 0;
        int kth = recursiveFind(node.getNext(), i) + 1;
        if(kth == i)
            data = node.getData();

        return kth;
    }


    /***
     * Time Conplexity : O(n)
     * Space Complexity : O(1)
     **/
    private int iterativeApproach() {
        LinkedLIst.Node a = linkedList.getHead();
        LinkedLIst.Node b = linkedList.getHead();

        for(int i = 0; i < this.k; i++)
            b = b.getNext();

        while(b != null) {
            a = a.getNext();
            b = b.getNext();
        }
        return a.getData();
    }

    @Override
    public void test() {
        super.test();
        KthToLast a = new KthToLast(new int[] {1, 2, 3, 4, 5}, 3);
        a.getLinkedList();

        //KthToLast b = new KthToLast(new int[] {1, 2, 3, 4, 5}, 7);
        //b.getLinkedList();
    }

    public void print(String str, int data) {
        System.out.println(str+" => " + data);
    }
}
