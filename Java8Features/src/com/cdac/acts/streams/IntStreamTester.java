package com.cdac.acts.streams;

import java.util.stream.IntStream;

public class IntStreamTester {

	public static void main(String[] args) {
		//Create stream numbers from 500-1000
		//Print all odd elements.
		IntStream.range(500, 1000)//Create IntStream 
		.filter((i) -> i % 2 != 0)//Filter Stream and Print
		.forEach(System.out::println);
	}

}
