package solutions.stack;

/**
 * Created by neaGaze on 9/30/18.
 */
public class SetOfStacks {
	int MAX_CAP = 3;
	SingleStack stacks;
	
	class SingleStack {
	  int[] stack = new int[MAX_CAP];
	  SingleStack next;
 	  int head;
	
	  SingleStack(int data) {
	    push(data);
 	  }

	  void push(int data) {
	    if(head == MAX_CAP) throw new ArrayIndexOutOfBoundsException();
	    this.stack[head++] = data;
	    System.out.println("Inserting "+ data);
	  }

	  int pop() {
	    if(head < 1) throw new ArrayIndexOutOfBoundsException();
	    int data = stack[--head];
	    System.out.println("Popping "+ data);
	    return data;
	  }

	  boolean isEmpty() {
	      return head == 0;
      }
	}

	public SetOfStacks() {}


	public void push(int data) {
	  if(stacks == null) {
	      stacks = new SingleStack(data);
	  } else if(stacks.head == MAX_CAP) {
	      System.out.println("Creating a new stack due to overload");
          SingleStack newStack = new SingleStack(data);
		  newStack.next = stacks;
		  stacks = newStack;
      } else {
	      stacks.push(data);
      }
	}	

	public int pop() {
	  if(stacks == null) 
	    throw new ArrayIndexOutOfBoundsException();

	  int retData = stacks.pop();
	  if(stacks.isEmpty()) {
        System.out.println("Dropping the current stack due to underload");
	    stacks = stacks.next;
	    stacks.head = MAX_CAP; 
	  } 
	  return retData;
	}

	public static void test() {
        SetOfStacks stacks = new SetOfStacks();
        stacks.push(1);
        stacks.push(2);
        stacks.push(3);
        stacks.push(4);
        stacks.push(5);
        stacks.pop();
        stacks.pop();
        stacks.pop();
    }
}
