package com.cdac.acts.lambda.tester;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaTester3{
	public static void main(String... args) {
		Comparator<String> comparator = (left, right) -> left.compareTo(right); // Function Literal
		
		List<String> list = new ArrayList<>(Arrays.asList("VLSI","DESD","DAC"));
		//Sort using lambda targeting Comparator
		Collections.sort(list, comparator);
		System.out.println(list);
		
		List<String> list1 = new ArrayList<>(Arrays.asList("VLSI","DESD","DAC"));
		//Sort using lambda targeting Comparator
		Collections.sort(list1, (left, right) -> left.compareTo(right));
		System.out.println(list1);
		
		//Remove from list using
		// boolean test(T t);
		//  test(T t) -> boolean
		//list1.removeIf((s) -> s.equals("VLSI"));
		list1.removeIf(s -> s.equals("VLSI"));
		System.out.println(list1);
		
		//Print using Lambda
		list.stream().forEach(str -> System.out.println(str));
		
		//Passing method reference to for each
		list.stream().forEach(System.out::println);
		
	}
}
