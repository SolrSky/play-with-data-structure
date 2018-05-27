package com.test.array;

public class Array<E> {

	private E[] data;

	private int size;

	/**
	 * 传入数组容量capaticy构造Array
	 * 
	 * @param capacity
	 */
	@SuppressWarnings("unchecked")
	public Array (int capacity) {
		this.data = (E[])new Object[capacity];
		this.size = 0;
	}

	/**
	 * 无参构造函数，初始容量10
	 */
	public Array () {
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
	public void addLast(E e) {
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
	public void addFirst(E e){
		addIndex(0, e);
	}
	
	/**
	 * 在指定位置插入元素
	 * @param index
	 * @param e
	 */
	public void addIndex(int index, E e){
		
		
		if(index < 0 || index >= data.length){
			throw new IndexOutOfBoundsException("Add Failed. Require index >= 0 and index < length");
		}
		
		if(this.size == data.length){
			resize(2 * data.length);
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
	public E get(int index){
		if(index < 0 || index >= this.size){
			throw new IndexOutOfBoundsException("Add Failed. Require index >= 0 and index < size");
		}
		return data[index];
	}
	
	/**
	 * 获取最后一个元素
	 * @return
	 */
	public E getLast(){
		return get(getSize() -1);
	}
	
	/**
	 * 获取第一个元素
	 * @return
	 */
	public E getFirst(){
		return get(0);
	}
	
	/**
	 * 设置指定索引上的值
	 * @param index
	 * @param e
	 */
	public void set(int index, E e){
		if(index < 0 || index >= this.size){
			throw new IndexOutOfBoundsException("Add Failed. Require index >= 0 and index <= size");
		}
		data[index] = e;
	}
	
	/**
	 * 是否包含某个元素
	 * @param e
	 * @return
	 */
	public boolean contains(E e){
		for (E i : data) {
			if(i == e){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 查找指定的值在数组中的索引，没有则返回-1
	 * @param e
	 * @return
	 */
	public int find(E e){
		for (int i = 0; i < size; i++) {
			if(data[i] == e){
				return i;
			}
		}
		return -1;
	}
	
	public int[] findAll(E e){
		//TODO------------------------------
		return new int[10];
	}
	
	/**
	 * 删除某个索引上的值
	 * @param index
	 */
	public E remove(int index){
		if(index < 0 || index >= this.size){
			throw new IndexOutOfBoundsException("Add Failed. Require index >= 0 and index < size");
		}
		
		E temp = data[index];
		for (int i = index + 1; i < size; i++) {
			data[i-1] = data[i];
		}
		size--;
		data[this.size] = null;
		
		if(size == data.length / 4 && data.length /2 != 0){
			resize(data.length / 2);
		}
		
		return temp;
	}
	
	/**
	 * 从数组中删除第一个元素
	 * @return
	 */
	public E removeFirst(){
		return remove(0);
	}
	
	/**
	 * 从数组中删除最后一个元素
	 * @return
	 */
	public E removeLast(){
		return remove(size -1);
	}
	
	/**
	 * 从数组中删除指定元素
	 * @param e
	 */
	public void removeElement(E e){
		int index = find(e);
		if(index != -1){
			remove(index);
		}
	}
	
	public void removeAllElements(int e){
		//TODO--------------------------------
	}
	
	/**
	 * 扩容
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	private void resize(int newCapacity){
		E[] newData = (E[])new Object[newCapacity];
		for (int i = 0; i < size; i++) {
			newData[i] = data[i];
		}
		this.data = newData;
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
