package com.test.array;

public class Student {

	private String name;
	
	private String score;

	public Student(String name, String score) {
		super();
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return String.format("Student[name: %s, score: %s]", this.name, this.score);
	}
	
}
