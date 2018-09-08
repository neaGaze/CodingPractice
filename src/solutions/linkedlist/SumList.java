package solutions.linkedlist;

import solutions.arrayandstring.BaseClass;

/**
 * you have two numbers respresented by a linked list, where each node contains a single digit. The digits are
 * stored in reverse order, such that the 1's digit is at the head of the list. Write a function that adds the
 * two numbers and returns the sum as a linked list.
 *
 * For Eg:
 * Input: (7 -> 1 -> 6) + (5 -> 9 -> 2). That is, 617 + 295.
 * Output: 2 -> 1 -> 9. That is, 912.
 */
public class SumList extends BaseClass {

    private LinkedLIst a, b;

    public SumList() {}

    public SumList(int[] a, int[] b) {
        this.a = new LinkedLIst(a);
        this.b = new LinkedLIst(b);
    }

    /**
     * Time Complexity : O(n)
     * Space Complexity : O(n)
     ****/
    public LinkedLIst addInReverseOrder() {
        LinkedLIst.Node nodeA = a.getHead();
        LinkedLIst.Node nodeB = b.getHead();
        LinkedLIst ans = new LinkedLIst();

        int carryOver = 0;
        while(nodeA != null || nodeB != null) {

            int valA = nodeA != null ? nodeA.getData() : 0;
            int valB = nodeB != null ? nodeB.getData() : 0;

            int sum = valA + valB + carryOver;
            ans.insert(sum % 10);
            carryOver = sum / 10;

            // increment
            if(nodeA != null) nodeA = nodeA.getNext();
            if(nodeB != null) nodeB = nodeB.getNext();
        }

        if(carryOver > 0) ans.insert(carryOver);
        return ans;
    }

    /**
     * Start if the numbers are stored in the forward order
     * For Eg:
     * Input: (6 -> 1 -> 7) + (2 -> 9 -> 5). That is, 617 + 295.
     * Output: 9 -> 1 -> 2. That is, 912.
     ***/
    LinkedLIst answer = new LinkedLIst();

    class AddParam {
        private int carryOver;
        private int val;

        public int getCarryOver() {
            return carryOver;
        }

        public void setCarryOver(int carryOver) {
            this.carryOver = carryOver;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }
    }

    public AddParam addInForwardOrder(LinkedLIst.Node a, LinkedLIst.Node b) {
        AddParam param = null;
        int carryOver = 0;
        if(a == null || b == null) {
            param = new AddParam();
            param.setCarryOver(0);
            param.setVal(0);
            return param;
        }

        param = addInForwardOrder(a.getNext(), b.getNext());
        int sum = param.getCarryOver() + a.getData() + b.getData();
        param.setCarryOver(sum / 10);
        param.setVal(sum % 10);
        insertAtBeginning(answer, param.getVal());
        System.out.println("val after adding "+a.getData()+" and "+b.getData()+" -> "+sum+", actualval -> "+param.getVal());
        return param;
    }

    /**
     *  Time Complexity : O(n)
     *  Space Complexity : O(n)
     ***/
    public void recursiveTraverse() {
        int lenA = a.getLength(), lenB = b.getLength();

        if(lenA - lenB > 0)
            stuffZeros(b, lenA - lenB);
        else if(lenB - lenA > 0)
            stuffZeros(a, lenB - lenA);

        AddParam param = addInForwardOrder(a.getHead(), b.getHead());
        if(param.getCarryOver() > 0)
            insertAtBeginning(answer, param.getCarryOver());
    }

    private LinkedLIst insertAtBeginning(LinkedLIst list, int data) {
        LinkedLIst.Node head = list.getHead();
        LinkedLIst.Node newNode = new LinkedLIst.Node(data);
        newNode.setNext(head);
        list.setHead(newNode);
        return list;
    }

    private void stuffZeros(LinkedLIst list, int offset) {
        for(int i = 0; i < offset; i++)
            insertAtBeginning(list, 0);
    }

    @Override
    public void test() {
        super.test();
        SumList sumList1 = new SumList(new int[] {7, 1, 6}, new int[]{5, 9, 2});
        sumList1.addInReverseOrder().printList();

        SumList sumList2 = new SumList(new int[] {4, 1, 6}, new int[]{5, 9, 5});
        sumList2.addInReverseOrder().printList();


        SumList sumList3 = new SumList(new int[] {4, 1, 6}, new int[]{5, 9, 5, 3});
        sumList3.addInReverseOrder().printList();

        SumList sumList4 = new SumList(new int[] {4, 1, 6}, new int[]{5, 9, 5, 3});
        sumList4.recursiveTraverse();
        sumList4.answer.printList();


        SumList sumList5 = new SumList(new int[] {4, 1, 6, 7}, new int[]{5, 9, 5, 3});
        sumList5.recursiveTraverse();
        sumList5.answer.printList();
    }
}
