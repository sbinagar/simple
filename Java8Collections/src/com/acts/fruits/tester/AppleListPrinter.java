package com.acts.fruits.tester;

import java.util.List;

import com.acts.fruits.Apple;
import com.acts.fruits.AppleUtils;

public class AppleListPrinter {
	public static void main(String[] args) {
		//Getting apple list from utils class
		List<Apple> applesList = AppleUtils.getAppleList();
		System.out.println("\n\n1.All Apples\n" + applesList);

		//Print apples by using for each and lambda
		System.out.println("\n\n2.Print apples by using for each and lambda");
		applesList.forEach(apple -> System.out.println(apple));


		//Print apples by using for each and method ref
		System.out.println("\n\n3.Print apples by using for each and method ref");
		applesList.forEach(System.out::println);


		applesList.forEach(apple -> apple.setColor("Green"));
		//Print apples by using for each and method ref
		System.out.println("\n\n4.Print apples by using for each and method ref");
		applesList.forEach(System.out::println);

		applesList.removeIf((apple) -> apple.getWeight()== 200);
		//Print apples by using for each and method ref
		System.out.println("\n\n5.Print apples by using for each and method ref");
		applesList.forEach(System.out::println);
	}

}
