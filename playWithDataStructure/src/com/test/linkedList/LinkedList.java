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

	// ��ȡ�����е�Ԫ�ظ���
	public int getSize() {
		return size;
	}

	// �ж������Ƿ�Ϊ��
	public boolean isEmpty() {
		return size == 0;
	}

	// ������ͷ����������
	public void addFirst(E e) {
		// Node node = new Node(e);
		// node.next = head;
		// head = node;

		// head = new Node(e, head);
		// size++;
		add(0, e);
	}

	// �������index������һ��Ԫ��
	public void add(int index, E e) {
		if (index < 0 || index > size) {
			throw new IllegalArgumentException("Add failed. Illegal index.");
		}

		Node prev = dummyHead;
		// ���ҵ�Ҫ�����Ԫ�ص�ǰһ��Ԫ��
		for (int i = 0; i < index; i++) {
			prev = prev.next;
		}
		prev.next = new Node(e, prev.next);
		size++;
	}

	// �������ĩβ����Ԫ��
	public void addLast(E e) {
		add(size, e);
	}

	// �������ĵ�index(0-based)��λ�õ�Ԫ��
	// �������в���һ�����õĲ�������ϰ�ã���
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

	// �������ĵ�һ��Ԫ��
	public E getFirst() {
		return get(0);
	}

	// �������ĩβ��Ԫ��
	public E getLast() {
		return get(size - 1);
	}

	// �޸�����ĵ�index(0-based)��λ�õ�Ԫ��Ϊe
	// �������в���һ�����õĲ�������ϰ�ã���
	public void set(int index, E e) {
		if (index < 0 || index > size) {
			throw new IllegalArgumentException("Set failed. Illegal index.");
		}

		Node cur = dummyHead.next;
		for (int i = 0; i < index; i++) {
			cur = cur.next;
		}
		cur.e = e; // ֻ�ı������λ���ϵ�Ԫ�ص�ֵ�����ı�ǰ��Ԫ�ص�ָ��
	}

	// �ж��������Ƿ����ĳ��Ԫ��
	public boolean contains(E e) {
		Node cur = dummyHead.next;
		while (cur != null) {
			if (cur.e.equals(e))
				return true;
			cur = cur.next;
		}
		return false;
	}

	// ɾ��indexλ�õ�Ԫ��
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

	// ɾ�������һ��Ԫ��
	public E removeFirst() {
		return remove(0);
	}

	// ɾ������ĩβ��Ԫ��
	public E removeLast() {
		return remove(size - 1);
	}

	// ��������ɾ��Ԫ��e
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
