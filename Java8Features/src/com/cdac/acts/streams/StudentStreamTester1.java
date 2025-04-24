package com.cdac.acts.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.cdac.acts.Student;

public class StudentStreamTester1 {

	public static void main(String[] args) {


		//Student list
		List<Student> studentList = new ArrayList<>();
		studentList.add(new Student(123,"Nita", "DAC"));
		studentList.add(new Student(124,"Rajesh", "DAC"));
		studentList.add(new Student(125,"Bharti", "DESD"));

		//sort by RollNo
		//Passing Comparator  for Roll No
		//Using stream
		//1. Convert to stream
		//2. Perform operation
		//3. Collect from Stream to collection
		List<Student> sortedList = studentList.stream()
				.filter(s -> s.getCourse().equals("DAC"))
				.sorted((Student s1, Student s2)-> s1.getRollNo().compareTo(s2.getRollNo()))
				.collect(Collectors.toList());

		//Print Students using Lambda and for Each
		sortedList.forEach((Student s1) -> System.out.println(s1));
		//	sortedList.forEach(System.out::println);


		//sort by RollNo
		//Passing Comparator for Name
		//Using stream
		//1. Convert to stream
		//2. Perform operation
		//3. Collect from Stream to collection
		List<Student> sortedList1 = studentList.stream()
				.sorted((s1, s2)-> s1.getName().compareTo(s2.getName()))
				.sorted((s1, s2)-> s1.getRollNo().compareTo(s2.getRollNo()))
				.collect(Collectors.toList());

		//Print Students using Lambda
		//sortedList1.forEach((s1) -> System.out.println(s1));
		
		//Print Students using Method Reference
		sortedList1.forEach(System.out::println);
		
		//Remove if
		sortedList1.removeIf((s) -> s.getName().equals("Rajesh"));
		System.out.println("After Removal");
		//Print Students using Method Reference
		sortedList1.forEach(System.out::println);
	}

}
