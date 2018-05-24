package com.test.array;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Array {

	private int[] data;

	private int size;

	/**
	 * 传入数组容量capaticy构造Array
	 * 
	 * @param capacity
	 */
	public Array(int capacity) {
		this.data = new int[capacity];
		this.size = 0;
	}

	/**
	 * 无参构造函数，初始容量10
	 */
	public Array() {
		this(10);
	}

	/**
	 * 获取数组中的元素个数
	 * 
	 * @return
	 */
	public int getSize() {
		return this.size;
	}

	/**
	 * 获取数组的容量
	 * 
	 * @return
	 */
	public int getCapacity() {
		return this.data.length;
	}

	/**
	 * 判断数组是否为空
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * 在数组末尾添加
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
	 * 在所有元素前添加一个元素
	 * @param e
	 */
	public void addFirst(int e){
		addIndex(0, e);
	}
	
	/**
	 * 在指定位置插入元素
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
	 * 获取index索引上的值
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
