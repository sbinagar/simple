package com.acts.fruits.tester;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.acts.fruits.Apple;
import com.acts.fruits.AppleUtils;

public class ApplpSortTester {
	public static void main(String[] args) {
		//Getting apple list from utils class
		List<Apple> applesList = AppleUtils.getAppleList();
		System.out.println("1.All Apples\n" + applesList);

		//Getting apple list sorted
		List<Apple> sortedApplesList = applesList.stream()
				.sorted()
				.collect(Collectors.toList());
		System.out.println("2.Sorted Apples\n" + sortedApplesList);

		//Getting apple list sorted  by weight ( natural or by Comparble)
		List<Apple> sortedApplesList1 = applesList.stream()
				.sorted(Comparator.naturalOrder())
				.collect(Collectors.toList());
		System.out.println("3.Sorted Apples\n" + sortedApplesList1);

		//Getting apple list sorted by color
		List<Apple> sortedApplesList2 = applesList.stream()
				.sorted((apple1, apple2) -> apple1.getColor().compareTo(apple2.getColor()))
				.collect(Collectors.toList());

		System.out.println("3.Sorted Apples\n" + sortedApplesList2);


		//Getting apple list sorted by Taste
		List<Apple> sortedApplesList3 = applesList.stream()
				.sorted(Comparator.comparing(Apple::getTaste).reversed())
				.collect(Collectors.toList());

		System.out.println("4.Sorted Apples\n" + sortedApplesList3);
		
		
		//Getting apple list sorted by Taste and then by weight
		List<Apple> sortedApplesList4 = applesList.stream()
				.sorted(Comparator.comparing(Apple::getTaste).thenComparing(Apple::getWeight))
				.collect(Collectors.toList());

		System.out.println("5.Sorted Apples\n" + sortedApplesList4);


	}

}
