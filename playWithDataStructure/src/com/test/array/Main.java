package com.test.array;

public class Main {

	public static void main(String[] args) {

		Array<Student> arr = new Array<Student>(20);
//		for (int i = 0; i < 10; i++) {
//			arr.addLast(i);
//		}
//		arr.addIndex(1, 100);
//		arr.addFirst(-1);
		
		arr.addFirst(new Student("小明", "100"));
		arr.addFirst(new Student("小王", "89"));
		arr.addFirst(new Student("黑子", "94"));
		
		Array<Integer> arr2 = new Array<>();
		
		arr2.set(0, 1);
		
		System.out.println(arr.toString());
	}

}
