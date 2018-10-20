package solutions.stack;
import java.util.*;

/**
 * Created by neaGaze on 9/30/18.
 */
public class MyQueue {
	Stack<Integer> s1, s2;
	
	public MyQueue() {
	  s1 = new Stack<Integer>();
	  s2 = new Stack<Integer>();
	}

	public void insert(int data) {
		s1.push(data);
		System.out.println("Inserting " + data);
	}

	public Integer remove() {
		if(s2.isEmpty()) {
			if(s1.isEmpty()) throw new ArrayIndexOutOfBoundsException();
			while(!s1.isEmpty()) {
				s2.push(s1.pop());
			}
		}
		Integer data = s2.pop();
        System.out.println("removing " + data);
		return data;
	}

	public int size() {
		return s1.size() + s2.size();
	}

	public static void test() {
	    MyQueue q1 = new MyQueue();
	    q1.insert(1);
        q1.insert(2);
        q1.insert(3);
        q1.remove();
        q1.insert(4);
        q1.remove();
        q1.insert(5);
        System.out.println("The size of queue is: " + q1.size());
    }
}
