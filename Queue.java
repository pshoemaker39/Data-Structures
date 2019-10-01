package csc402;
import  stdlib.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * This is a generic queue class implemented with a linked list.
 */

public class Queue<T> {
	private int count;         // number of elements on queue
	private Node<T> first;    // beginning of queue
	private Node<T> last;     // end of queue

	// helper linked list class
	private static class Node<T> {
		public Node() { }
		public T item;
		public Node<T> next;
	}

	/**
	 * Create an empty queue.
	 */
	public Queue() {
		first = null;
		last  = null;
		count = 0;
	}

	/**
	 * Is the queue empty?
	 */
	public boolean isEmpty() {
		return first == null;
	}

	/**
	 * Return the number of items in the queue.
	 */
	public int size() {
		return count;
	}

	/**
	 * Return the item least recently added to the queue.
	 * @throws java.util.NoSuchElementException if queue is empty.
	 */
	public T peek() {
		if (isEmpty()) throw new NoSuchElementException("Queue underflow");
		return first.item;
	}

	/**
	 * Add the item to the queue.
	 */
	public void enqueue(T item) {
		Node<T> oldlast = last;
		last = new Node<>();
		last.item = item;
		last.next = null;
		if (isEmpty()) first = last;
		else           oldlast.next = last;
		count++;
	}

	/**
	 * Remove and return the item on the queue least recently added.
	 * @throws java.util.NoSuchElementException if queue is empty.
	 */
	public T dequeue() {
		if (isEmpty()) throw new NoSuchElementException("Queue underflow");
		T item = first.item;
		first = first.next;
		count--;
		if (isEmpty()) last = null;
		return item;
	}

	/**
	 * Return string representation.
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (Node<T> current = first; current != null; current = current.next) {
			s.append(current.item + " ");
		}
		return s.toString();
	}
}
