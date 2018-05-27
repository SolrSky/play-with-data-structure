package com.test.queue;

public class Main {

	public static void main(String[] args) {
		ArrayQueue<Integer> arr = new ArrayQueue<>(10);
		for (int i = 0; i < 5; i++) {
			arr.enqueue(i);
			System.out.println(arr);
		}
		
		arr.dequeue();
		System.out.println(arr);
		System.out.println(arr.getFront());
		
		arr.dequeue();
		System.out.println(arr);
		System.out.println(arr.getFront());
		
		arr.dequeue();
		System.out.println(arr);
		System.out.println(arr.getFront());
		
	}

}
