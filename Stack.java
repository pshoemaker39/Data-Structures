package csc402;
import  stdlib.*;
import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * This is a generic stack class implemented with a linked
 * list.  
 */

public class Stack<T> {
	private int count;          // size of the stack
	private Node<T> first;      // top of stack

	// Linked list node inner class
	private static class Node<T> {
		public Node () { }
		public T item;
		public Node<T> next;
	}

	/**
	 * Create an empty stack.
	 */
	public Stack() {
		this.first = null;
		this.count = 0;
	}

	/**
	 * Is the stack empty?
	 */
	public boolean isEmpty() {
		return first == null;
	}

	/**
	 * Return the number of items in the stack.
	 */
	public int size() {
		return count;
	}

	/**
	 * Add the item to the stack.
	 */
	public void push(T item) {
		Node<T> oldfirst = first;
		first = new Node<>();
		first.item = item;
		first.next = oldfirst;
		count++;
	}

	/**
	 * Delete and return the item most recently added to the stack.
	 * @throws java.util.NoSuchElementException if stack is empty.
	 */
	public T pop() {
		if (isEmpty()) throw new NoSuchElementException("Stack underflow");
		T item = first.item;        // save item to return
		first = first.next;            // delete first node
		count--;
		return item;                   // return the saved item
	}

	/**
	 * Return the item most recently added to the stack.
	 * @throws java.util.NoSuchElementException if stack is empty.
	 */
	public T peek() {
		if (isEmpty()) throw new NoSuchElementException("Stack underflow");
		return first.item;
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
