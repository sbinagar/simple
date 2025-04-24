package com.cdac.acts.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTester1 {

	public static void main(String[] args) {


		List<Integer> list = new ArrayList<>(Arrays.asList(40,50,60,90,8,90,30,60));
		//Using stream
		//1. Convert to stream
		//2. Perform operation
		//3. Collect from Stream to collection
		Stream<Integer> stream = list.stream(); // Convert to stream
		stream = stream.distinct(); // Process
		List<Integer> processedLlist = stream.collect(Collectors.toList()); //Collect in collection
		processedLlist.forEach(System.out::println);

		//Finding max and using Optional
		//No need to collect as max return only one value
		Optional<Integer> max  = list.stream()
				.max((i1, i2) -> i1.compareTo(i2));
		
		
		System.out.println("Max=" +max.orElse(0));

		//Doing sum of using reduce
		List<Integer> integersList = Arrays.asList(10, 20, 30, 40, 50);
		//No need to collect as reduce return only one value
		Integer sum = integersList.stream()
		  .reduce(0, (a, b) -> a + b);
		System.out.println("Sum=" +sum);
		

		List<Integer> integersList1 = Arrays.asList(11, 22, 33, 44, 55);
		//No need to collect as reduce return only one value
		Integer sum1 = integersList1.stream()
		  .reduce(0, Integer::sum);
		System.out.println("Sum1=" +sum1);
		
		List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
		Integer sum2 = integers.stream()
		  .collect(Collectors.summingInt(Integer::intValue));
		System.out.println("Sum2=" +sum2);




	}

}
