package com.acts.fruits.tester;

import java.util.List;
import java.util.Scanner;

import com.acts.fruits.Apple;
import com.acts.fruits.AppleUtils;

public class ApplePeekTester {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			//Get apple List
			List<Apple> list = AppleUtils.getAppleList();

			System.out.println("***************Printng list***********");
			list.forEach(p -> System.out.println(p));

			System.out.println("Enter apple color");
			String color = sc.next();

			System.out.println("Enter apple weight");
			int weight = sc.nextInt();

			System.out.println("Changing weight of user selected coloured apples ");
			list.stream() // Get stream
			.filter(a -> a.getColor().equals(color)) //Filter by color
			.peek(a -> a.setWeight(weight)) //Change weight for filtered apples 
			.forEach(System.out::println); //Print all apples whose weight is changed
		}

	}

}
