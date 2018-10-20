package solutions.stack;

/**
 * Created by neaGaze on 9/30/18.
 */
public class StackWithMin {
    class Node {
        Node next;
        int min, data;

        public Node(int data) {
            this.data = data;
            this.min = Integer.MAX_VALUE;
        }
    }

    Node head;
    int length;

    public void push(int x) {
        Node node = new Node(x);
        if(head == null) node.min = x;
        else {
            if(x < head.min) node.min = x;
            else node.min = head.min;
        }
        node.next = head;
        head = node;
        System.out.println("pushed elem: " + x);
        length++;
    }

    public int pop() {
        if(head == null) throw new ArrayIndexOutOfBoundsException("");
        Node node = head;
        head = head.next;
        length--;
        System.out.println("popped elem: " + node.data);
        return node.data;
    }

    public int min() {
        if(head == null) throw new ArrayIndexOutOfBoundsException();
        return head.min;
    }

    public int size() {
        return length;
    }

    public static void test() {
        StackWithMin stack = new StackWithMin();
        stack.push(3);
        stack.push(2);
        stack.push(4);
        stack.pop();
        stack.push(-1);
        System.out.println("Size: " + stack.size() + ", and min: " + stack.min());
    }
}
