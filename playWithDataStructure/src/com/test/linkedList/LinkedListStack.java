package com.test.linkedList;

import com.test.stack.Stack;

public class LinkedListStack<E> implements Stack<E>{

	private LinkedList<E> list;
	
	public LinkedListStack(){
        list = new LinkedList<>();
    }
	
	@Override
	public void push(E e) {
		list.addFirst(e);
	}

	@Override
	public void pop() {
		list.removeFirst();
	}

	@Override
	public E peek() {
		return list.getFirst();
	}

	@Override
	public int getSize() {
		return list.getSize();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Stack: top ");
		sb.append(list.toString());
		return sb.toString();
	}
	
}
