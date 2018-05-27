package com.test.queue;

import com.test.array.Array;

public class ArrayQueue<E> implements Queue<E>{

	private Array<E> array;
	
	public ArrayQueue(){
		array = new Array<>();
	}
	
	public ArrayQueue(int capacity){
		array = new Array<>(capacity);
	}

	@Override
	public void enqueue(E e) {
		array.addLast(e);
	}

	@Override
	public E dequeue() {
		return array.removeFirst();
	}

	@Override
	public boolean isEmpty() {
		return array.isEmpty();
	}

	@Override
	public int getSize() {
		return array.getSize();
	}

	@Override
	public E getFront() {
		return array.getFirst();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("queue: front ").append("[");
		for (int i = 0; i < array.getSize(); i++) {
			sb.append(array.get(i));
			if(i != array.getSize() - 1){
				sb.append(", ");
			}
		}
		sb.append("] tail");
		return sb.toString();
	}
	
	
}
