package com.test.array;

public class Main {

	public static void main(String[] args) {

		Array arr = new Array(20);
		for (int i = 0; i < 10; i++) {
			arr.addLast(i);
		}
		arr.addIndex(1, 100);
		arr.addFirst(-1);
		System.out.println(arr.toString());
	}

}
