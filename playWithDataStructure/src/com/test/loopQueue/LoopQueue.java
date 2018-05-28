package com.test.loopQueue;

import com.test.queue.Queue;

public class LoopQueue<E> implements Queue<E> {

	private E[] data;

	private int front;

	private int tail;

	private int size;

	@SuppressWarnings("unchecked")
	public LoopQueue(int capacity) {
		data = (E[]) new Object[capacity + 1];
		front = 0;
		tail = 0;
		size = 0;
	}

	public LoopQueue() {
		this(10);
	}

	/**
	 * 获取循环队列容量
	 * 
	 * @return
	 */
	public int getCapacity() {
		return data.length - 1;
	}

	/**
	 * 循环队列入队
	 */
	@Override
	public void enqueue(E e) {
		// 先判断需不需要扩容
		if ((tail + 1) % data.length == front) {
			resize(getCapacity() * 2);
		}

		data[tail] = e;
		tail = (tail + 1) % data.length;
		size++;
	}

	/**
	 * 循环队列扩容或缩容
	 * 
	 * @param newCapacity
	 */
	@SuppressWarnings("unchecked")
	private void resize(int newCapacity) {
		E[] newData = (E[]) new Object[newCapacity + 1];

		for (int i = 0; i < size; i++) {
			newData[i] = data[(front + i) % data.length];
		}
		data = newData;
		front = 0;
		tail = size;
	}

	/**
	 * 循环队列出队
	 */
	@Override
	public E dequeue() {
		if (isEmpty()) {
			throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
		}
		E ret = data[front];
		data[front] = null;
		front = (front + 1) % data.length;
		size--;

		if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
			resize(getCapacity() / 2);
		}
		return ret;
	}

	@Override
	public boolean isEmpty() {
		return front == tail;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public E getFront() {
		if (isEmpty()) {
			throw new IllegalArgumentException("Queue is empty.");
		}
		return data[front];
	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
		res.append("front [");
		for (int i = front; i != tail; i = (i + 1) % data.length) {
			res.append(data[i]);
			if ((i + 1) % data.length != tail) {
				res.append(", ");
			}
		}
		// for (int i = 0; i < size; i++) {
		// res.append(data[i]);
		// if(i != size - 1){
		// res.append(", ");
		// }
		// }
		res.append("] tail");
		return super.toString();
	}

}
