package com.cdac.acts;

public class Student {
	private Integer rollNo;
	private String name;
	private String course;
	
	public Student() {
		this.rollNo =0;
		this.name = "";
		this.course = "";
	}

	public Student(Integer rollNo, String name, String course) {
		this.rollNo = rollNo;
		this.name = name;
		this.course = course;
	}

	public Integer getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", course=" + course + "]";
	}

}
