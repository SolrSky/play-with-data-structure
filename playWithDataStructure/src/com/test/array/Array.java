package com.test.array;

public class Array<E> {

	private E[] data;

	private int size;

	/**
	 * ������������capaticy����Array
	 * 
	 * @param capacity
	 */
	@SuppressWarnings("unchecked")
	public Array (int capacity) {
		this.data = (E[])new Object[capacity];
		this.size = 0;
	}

	/**
	 * �޲ι��캯������ʼ����10
	 */
	public Array () {
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
	 * ������Ԫ��ǰ���һ��Ԫ��
	 * @param e
	 */
	public void addFirst(E e){
		addIndex(0, e);
	}
	
	/**
	 * ��ָ��λ�ò���Ԫ��
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
	 * ��ȡindex�����ϵ�ֵ
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
	 * ��ȡ���һ��Ԫ��
	 * @return
	 */
	public E getLast(){
		return get(getSize() -1);
	}
	
	/**
	 * ��ȡ��һ��Ԫ��
	 * @return
	 */
	public E getFirst(){
		return get(0);
	}
	
	/**
	 * ����ָ�������ϵ�ֵ
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
	 * �Ƿ����ĳ��Ԫ��
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
	 * ����ָ����ֵ�������е�������û���򷵻�-1
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
	 * ɾ��ĳ�������ϵ�ֵ
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
	 * ��������ɾ����һ��Ԫ��
	 * @return
	 */
	public E removeFirst(){
		return remove(0);
	}
	
	/**
	 * ��������ɾ�����һ��Ԫ��
	 * @return
	 */
	public E removeLast(){
		return remove(size -1);
	}
	
	/**
	 * ��������ɾ��ָ��Ԫ��
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
	 * ����
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
