package com.acts.fruits.tester;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.acts.fruits.Apple;
import com.acts.fruits.AppleUtils;

public class AppleListConverterTest {
	public static void main(String[] args) {
		//Getting apple list from utils class
		List<Apple> applesList = AppleUtils.getAppleList();
		
		System.out.println("\n\n1.All Apples\n");
		applesList.forEach(System.out::println);

		Map<String, List<Apple>> map = applesList.stream()
		.collect(Collectors.groupingBy(Apple::getTaste));
		
		//Iterate Over Map using For Each
		map.forEach((key, value) -> System.out.println ("Key= " + key +" Value= " + value));
		
		Map<Boolean, List<Apple>> partionedMap = applesList.stream()
		.collect(Collectors.partitioningBy((apple)-> apple.getColor().equals("Red")));
		System.out.println(partionedMap);
		
		Set<Apple> appleSet = applesList.parallelStream()
		.collect(Collectors.toSet());
		appleSet.forEach(System.out::println);
		

		
	}

}
