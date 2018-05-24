package com.test.array;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Array {

	private int[] data;

	private int size;

	/**
	 * ������������capaticy����Array
	 * 
	 * @param capacity
	 */
	public Array(int capacity) {
		this.data = new int[capacity];
		this.size = 0;
	}

	/**
	 * �޲ι��캯������ʼ����10
	 */
	public Array() {
		this(10);
	}

	/**
	 * ��ȡ�����е�Ԫ�ظ���
	 * 
	 * @return
	 */
	public int getSize() {
		return this.size;
	}

	/**
	 * ��ȡ���������
	 * 
	 * @return
	 */
	public int getCapacity() {
		return this.data.length;
	}

	/**
	 * �ж������Ƿ�Ϊ��
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * ������ĩβ���
	 * @param e
	 */
	public void addLast(int e) {
//		if (this.size == data.length) {
//			throw new IllegalArgumentException("AddLast Failed, Array is full.");
//		}
//
//		this.data[this.size] = e;
//		this.size++;
		
		addIndex(size, e);
	}
	
	/**
	 * ������Ԫ��ǰ���һ��Ԫ��
	 * @param e
	 */
	public void addFirst(int e){
		addIndex(0, e);
	}
	
	/**
	 * ��ָ��λ�ò���Ԫ��
	 * @param index
	 * @param e
	 */
	public void addIndex(int index, int e){
		if(this.size == data.length){
			throw new IllegalArgumentException("AddLast Failed, Array is full.");
		}
		
		if(index < 0 || index >= this.size){
			throw new IndexOutOfBoundsException("Add Failed. Require index >= 0 and index < size");
		}
		
		for (int i = this.size-1; i >= index; i--) {
			this.data[i+1] = this.data[i];
		}
		this.data[index] = e;
		this.size++;
	}
	
	/**
	 * ��ȡindex�����ϵ�ֵ
	 * @param index
	 * @return
	 */
	public int get(int index){
		if(index < 0 || index >= this.size){
			throw new IndexOutOfBoundsException("Add Failed. Require index >= 0 and index < size");
		}
		return data[index];
	}
	
	public void set(int index, int e){
		if(index < 0 || index >= this.size){
			throw new IndexOutOfBoundsException("Add Failed. Require index >= 0 and index < size");
		}
		data[index] = e;
	}
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
		res.append("[");
		for (int i = 0; i < size; i++) {
			res.append(data[i]);
			if(i != size - 1){
				res.append(", ");
			}
		}
		res.append("]");
		return res.toString();
	}
	
}
