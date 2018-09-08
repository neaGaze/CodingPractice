package solutions.linkedlist;

import solutions.arrayandstring.BaseClass;

/**
 * Created by neaGaze on 8/26/18.
 */
public class LinkedLIst extends BaseClass {

    public static class Node {

        private Node next;
        private int data;

        public Node(int d) {
            this.data = d;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }
    }

    private Node head;

    public LinkedLIst() {

    }

    public LinkedLIst(int[] arr) {
        for(int i = 0; i < arr.length; i++)
            insert(arr[i]);

        print("Before:");
    }

    public void insert(int d) {
        Node node = new Node(d);
        Node curNode = this.getHead();

        if(curNode == null) {
            setHead(node);
            return;
        }

        while (curNode.getNext() != null) {
            curNode = curNode.getNext();
        }
        curNode.setNext(node);
    }

    public int remove(int d) {
        Node node = this.getHead();
        Node prevNode = null;
        while(node != null && node.getData() != d) {
            prevNode = node;
            node = node.getNext();
        }

        // no data found
        if(node == null || (node != null && node.getData() != d)) {
            // System.out.print("**"+d+" is not found**\n");
            return -1;
        }

        Node next = node.getNext();
        int data = node.getData();
        if(prevNode != null)
            prevNode.setNext(next);
        else
            setHead(next);

        return data;
    }

    public int getLength() {
        int count = 0;
        Node node = getHead();
        while(node != null) {
            count++;
            node = node.getNext();
        }
        return count;
    }

    public void print(String str) {
        System.out.println(str);
        Node node = this.getHead();

        if(node == null) {
            System.out.println("Empty LinkedList");
            return;
        }

        System.out.println(node.getData());
        while(node.getNext() != null) {
            node = node.getNext();
            System.out.println(node.getData());
        }

    }

    public void printList() {
        Node node = this.getHead();
        if(node == null) {
            System.out.println("Empty LinkedList");
            return;
        }

        StringBuilder strb = new StringBuilder();
        while(node != null) {
            strb.append(node.getData());
            if(node.getNext() != null)
                strb.append(" -> ");

            node = node.getNext();
        }
        System.out.println(strb.toString());
    }

    @Override
    public void test() {
        super.test();

        LinkedLIst l1 = new LinkedLIst(new int[]{1, 2, 3});
        l1.remove(2);
        l1.insert(4);
        l1.remove(1);
        l1.remove(4);
        l1.remove(7);
        l1.print("After:");
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getHead() {
        return head;
    }

}
