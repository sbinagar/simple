package com.cdac.acts.streams;

import java.util.Arrays;
import java.util.List;

public class ArrayStreamTester {

	public static void main(String[] args) {
		// Create Stream<Integer> from a fixed size list (un sorted ) of integers , sort
		// n display it.
		System.out.println("Sorted ints :asc ");
		
		List<Integer> list = Arrays.asList(10,1,23,45,56,789,-10);
		list.stream() //Stream<Integer> : src  : unsorted strm
		.sorted() //Stream<Integer> sorted : N.O
		.forEach((i) -> System.out.println(i+" "));
		
		System.out.println(list);
		
		
		//desc order 
		System.out.println("Sorted ints :desc ");
		Arrays.asList(10,1,23,45,56,789,-10)//List<Integer>
		.stream() //Stream<Integer> : src  : unsorted strm
		.sorted((i1,i2) -> i2.compareTo(i1))
		.forEach(System.out::println);
		
	}

}
