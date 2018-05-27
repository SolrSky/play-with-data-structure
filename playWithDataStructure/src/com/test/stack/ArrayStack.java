package com.test.stack;

import com.test.array.Array;

public class ArrayStack<E> implements Stack<E>{

	private Array<E> array;
	
	public ArrayStack(){
		array = new Array<>();
	}
	
	public ArrayStack(int capacity){
		array = new Array<>(capacity);
	}

	@Override
	public void push(E e) {
		array.addLast(e);
	}

	@Override
	public void pop() {
		array.removeLast();
	}

	@Override
	public E peek() {
		return array.getLast();
	}

	@Override
	public int getSize() {
		return array.getSize();
	}

	@Override
	public boolean isEmpty() {
		return array.isEmpty();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("stack: ").append("[");
		for (int i = 0; i < array.getSize(); i++) {
			sb.append(array.get(i));
			if(i != array.getSize() - 1){
				sb.append(", ");
			}
		}
		sb.append("] top ");
		return sb.toString();
	}
	
}
