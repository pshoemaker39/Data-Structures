/*
 * Price Shoemaker
 * Data Structures I - Autumn 2018-2019
 */

package csc402;
import stdlib.*;
import algs13.Queue;
import java.util.*;

public class ReverseQueue {
	
	public static Queue<Integer> createQueue() {
		Queue<Integer> q = new Queue<>();
		
		for (int i = 0; i < 17; i++) {
			int rand = new Random().nextInt(1000 + 1 + 1000) - 1000;
			q.enqueue(rand);
		}
		
		return q;
	}
	
	public static Queue<Integer> reverseQueue(Queue<Integer> q) {
		Queue<Integer> r = new Queue<>();
		Stack<Integer> t = new Stack<>();
		
		while(!q.isEmpty()) {
			t.push(q.dequeue());
		}
		while(!t.isEmpty()) {
			r.enqueue(t.pop());
		}
		return r;
	}

	public static void main(String[] args) {
		Queue<Integer> a = createQueue();
		System.out.println(a);
		Queue<Integer> b = reverseQueue(a);
		System.out.println(b);
	}

}
