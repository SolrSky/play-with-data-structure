package com.test.linkedList;

public class LinkedList<E> {

	private class Node {

		public E e;

		public Node next;

		public Node(E e, Node next) {
			this.e = e;
			this.next = next;
		}

		public Node(E e) {
			this(e, null);
		}

		public Node() {
			this(null, null);
		}

		@Override
		public String toString() {
			return e.toString();
		}
	}

	private Node dummyHead;

	private int size;

	public LinkedList() {
		dummyHead = new Node();
		size = 0;
	}

	// 获取链表中的元素个数
	public int getSize() {
		return size;
	}

	// 判断链表是否为空
	public boolean isEmpty() {
		return size == 0;
	}

	// 在链表头部插入数据
	public void addFirst(E e) {
		// Node node = new Node(e);
		// node.next = head;
		// head = node;

		// head = new Node(e, head);
		// size++;
		add(0, e);
	}

	// 在链表的index处插入一个元素
	public void add(int index, E e) {
		if (index < 0 || index > size) {
			throw new IllegalArgumentException("Add failed. Illegal index.");
		}

		Node prev = dummyHead;
		// 先找到要插入的元素的前一个元素
		for (int i = 0; i < index; i++) {
			prev = prev.next;
		}
		prev.next = new Node(e, prev.next);
		size++;
	}

	// 在链表的末尾插入元素
	public void addLast(E e) {
		add(size, e);
	}

	// 获得链表的第index(0-based)个位置的元素
	// 在链表中不是一个常用的操作，练习用：）
	public E get(int index) {
		if (index < 0 || index > size) {
			throw new IllegalArgumentException("Get failed. Illegal index.");
		}

		Node cur = dummyHead.next;
		for (int i = 0; i < index; i++) {
			cur = cur.next;
		}
		return cur.e;
	}

	// 获得链表的第一个元素
	public E getFirst() {
		return get(0);
	}

	// 获得链表末尾的元素
	public E getLast() {
		return get(size - 1);
	}

	// 修改链表的第index(0-based)个位置的元素为e
	// 在链表中不是一个常用的操作，练习用：）
	public void set(int index, E e) {
		if (index < 0 || index > size) {
			throw new IllegalArgumentException("Set failed. Illegal index.");
		}

		Node cur = dummyHead.next;
		for (int i = 0; i < index; i++) {
			cur = cur.next;
		}
		cur.e = e; // 只改变该索引位置上的元素的值，不改变前后元素的指向。
	}

	// 判断链表中是否包含某个元素
	public boolean contains(E e) {
		Node cur = dummyHead.next;
		while (cur != null) {
			if (cur.e.equals(e))
				return true;
			cur = cur.next;
		}
		return false;
	}

	// 删除index位置的元素
	public E remove(int index) {
		if (index < 0 || index > size) {
			throw new IllegalArgumentException("Remove failed. Illegal index.");
		}
		Node prev = dummyHead;
		for (int i = 0; i < index; i++) {
			prev = prev.next;
		}
		Node ret = prev.next;
		prev.next = ret.next;
		ret.next = null;
		return ret.e;
	}

	// 删除链表第一个元素
	public E removeFirst() {
		return remove(0);
	}

	// 删除链表末尾的元素
	public E removeLast() {
		return remove(size - 1);
	}

	// 从链表中删除元素e
	public void removeElement(E e) {

		Node prev = dummyHead;
		while (prev.next != null) {
			if (prev.next.e.equals(e))
				break;
			prev = prev.next;
		}

		if (prev.next != null) {
			Node delNode = prev.next;
			prev.next = delNode.next;
			delNode.next = null;
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (Node cur = dummyHead.next; cur != null; cur = cur.next) {
			sb.append(cur.e + "-->");
		}
		sb.append("NULL");
		return sb.toString();
	}
}
