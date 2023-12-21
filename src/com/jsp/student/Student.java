package com.jsp.student;

public class Student {
	//BEAN CLASS

	private String id;
	private String name;
	private int age;
	private int marks;

	private static int count=101;

	public Student (String name,int age,int marks) {
		this.id="JSP"+count;
		count++;

		this.name=name;
		this.age=age;
		this.marks=marks;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public static int getCount() {
		return count;
	}
	public static void setCount(int count) {
		Student.count = count;
	}
	@Override
	public String toString() {
		return "id is :" +id+" name is :"+name+" age is :"+age +" marks is:"+marks;
	}
}
