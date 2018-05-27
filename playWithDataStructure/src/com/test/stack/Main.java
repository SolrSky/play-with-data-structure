package com.test.stack;

public class Main {

	public static void main(String[] args) {
		ArrayStack<Integer> arrStack = new ArrayStack<>(10);
		for (int i = 0; i < 5; i++) {
			arrStack.push(i);
			System.out.println(arrStack);
		}
		
		arrStack.pop();
		System.out.println(arrStack);
		
		System.out.println(arrStack.peek());
		
	}
}
