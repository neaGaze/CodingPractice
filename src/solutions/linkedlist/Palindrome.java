package solutions.linkedlist;

import solutions.arrayandstring.BaseClass;

import java.util.Stack;

/**
 * Created by neaGaze on 9/9/18.
 */
public class Palindrome extends BaseClass {

    private LinkedLIst list;

    public Palindrome() {}

    public Palindrome(int[] arr) {
        list = new LinkedLIst(arr);
    }

    /**
     * Simple linkedList reversal technique
     * Time Complexity : O(n)
     * Space Complexity : O(n)
     ***/
    public boolean isPalindrome1() {
        LinkedLIst revList = reverseLinkedList(list);
        //revList.printList();
        LinkedLIst.Node curNode = list.getHead();
        LinkedLIst.Node revNode = revList.getHead();

        for(int i = 0; i < list.getLength(); i++) {
            if(curNode.getData() != revNode.getData()) return false;
            curNode = curNode.getNext();
            revNode = revNode.getNext();
        }
        return true;
    }

    public LinkedLIst reverseLinkedList(LinkedLIst list) {
        LinkedLIst.Node head = list.getHead();
        LinkedLIst newList = new LinkedLIst();
        LinkedLIst.Node prevNode = null;
        while(head != null) {
            LinkedLIst.Node newNode = new LinkedLIst.Node(head.getData());
            newNode.setNext(prevNode);
            prevNode = newNode;
            head = head.getNext();
        }
        newList.setHead(prevNode);
        return newList;
    }


    /***
     *  Using stacks and the fast and slow moving window technique. The fast and slow moving window technique
     *  is used when the length of the LinkedList is not given.
     ***/
    public boolean isPalindrome2() {
        Stack<Integer> stack = new Stack();
        LinkedLIst.Node node = list.getHead();
        LinkedLIst.Node fastMover = list.getHead(), slowMover = list.getHead();

        // just to know the length of the LinkedList
        while(fastMover != null) {
            stack.push(slowMover.getData());
            slowMover = slowMover.getNext();
            if(fastMover.getNext() != null)
                fastMover = fastMover.getNext().getNext();
            else break;
        }

        if(fastMover != null)
            stack.pop();

        while(slowMover != null) {
            if(slowMover.getData() != stack.pop()) return false;
            slowMover = slowMover.getNext();
        }
        return true;
    }

    /**
     * Recursive solution
     * Time Complexity : O(n)
     * Space Complexity : O(Result * linkedlistLength) => O(n)
     ***/
    class Result {
        private LinkedLIst.Node node;
        private boolean status;

        public Result(LinkedLIst.Node node, boolean status) {
            this.node = node;
            this.status = status;
        }
        public LinkedLIst.Node getNode() {
            return node;
        }

        public void setNode(LinkedLIst.Node node) {
            this.node = node;
        }

        public boolean isStatus() {
            return status;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }
    }

    public boolean isPalindrome3() {
        int len = list.getLength();
        return recurse(list.getHead(), len).isStatus();
    }

    public Result recurse(LinkedLIst.Node res, int length) {
        if(length == 0)
            return new Result(res, true);
        else if(length == 1)  {
            return new Result(res.getNext(), true);
        }

        Result backVal = recurse(res.getNext(), length - 2);

        if(!backVal.status || backVal.node == null) return new Result(null, false);

        return new Result(backVal.getNode().getNext(), (backVal.getNode().getData() == res.getData()));
    }

    @Override
    public void test() {
        super.test();
        Palindrome a = new Palindrome(new int[] {3, 0, 1, 5, 1, 0, 3});
        a.print(a.isPalindrome3());

        Palindrome b = new Palindrome(new int[] {3, 0, 1, 5, 1, 0});
        b.print(b.isPalindrome3());

        Palindrome c = new Palindrome(new int[] {1, 2, 3, 4});
        c.print(c.isPalindrome3());

        Palindrome d = new Palindrome(new int[] {1});
        d.print(d.isPalindrome3());

        Palindrome e = new Palindrome(new int[] {8, 7, 2, 2, 7, 8});
        e.print(e.isPalindrome3());

        Palindrome f = new Palindrome(new int[] {8, 4, 1, 2, 7, 8});
        f.print(f.isPalindrome3());
    }

    public LinkedLIst getList() {
        return list;
    }

    public void setList(LinkedLIst list) {
        this.list = list;
    }

    public void print(boolean isPalid) {
        System.out.println("The output of ");
        list.printList();
        System.out.println("is " + isPalid +"\n");
    }
}
