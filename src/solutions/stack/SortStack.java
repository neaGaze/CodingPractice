package solutions.stack;
import java.util.*;

/**
 * Created by neaGaze on 9/30/18.
 *
 * 4 1 3 9 7 8
 *
 * stack 1 :
 *  9 8 7 4 3 1
 *
 * stack 2:
 *  1 3 4 7 8 9
 *
 * tmp:
 *
 */
public class SortStack {
	Stack<Integer> stack, buffer;

	public SortStack(int[] arr) {
		stack = new Stack<Integer>();
		buffer = new Stack<Integer>();
		for(int x : arr)
		  stack.push(x);
	}

	// stack:  4
    // buffer: 3 7 8 9
    // tmp:    1

	public void sort() {
		int temp;
		while(!stack.isEmpty()) {
			temp = stack.pop();
			if(buffer.isEmpty() || buffer.peek() <= temp) {
				buffer.push(temp);
			} else {
				while(!buffer.isEmpty() && buffer.peek() > temp) {
					stack.push(buffer.pop());
				}
				buffer.push(temp);
			}
		}
		
		System.out.println("Printing the sorted stack");
		while(!buffer.isEmpty()) {
			int val = buffer.pop();
			System.out.println(val);
			stack.push(val);
		}
	}

	public static void test() {
		SortStack stack = new SortStack(new int[] {4, 1, 3, 9, 7, 8});
		stack.sort();
	}
}

