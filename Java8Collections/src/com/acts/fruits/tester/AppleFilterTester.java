package com.acts.fruits.tester;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.acts.fruits.Apple;
import com.acts.fruits.AppleFilterUtils;
import com.acts.fruits.AppleUtils;
import com.acts.fruits.predicates.AppleColorPredicate;
import com.acts.fruits.predicates.AppleWeightPredicate;

public class AppleFilterTester {

	public static void main(String[] args) {
		//Getting apple list from utils class
		List<Apple> applesList = AppleUtils.getAppleList();
		System.out.println("1.All Apples\n" + applesList);

		//Filter By Red color
		List<Apple> filteredList1 = AppleFilterUtils.filterByRedColor(applesList);
		System.out.println("2.Red apples\n" + filteredList1);

		//Filter By Green color
		List<Apple> filteredList2 = AppleFilterUtils.filterByGreenColor(applesList);
		System.out.println("3.Green apples\n" + filteredList2);

		//Passing color as parameter
		//Filter By color: Red
		List<Apple> filteredList3 = AppleFilterUtils.filterByColor(applesList, "Red");
		System.out.println("4.Red apples\n" + filteredList3);

		//Filter By color: Green
		List<Apple> filteredList4 = AppleFilterUtils.filterByColor(applesList, "Green");
		System.out.println("5.Green apples\n" + filteredList4);

		//Filter By color: Green and weight >150
		List<Apple> filteredList5 = AppleFilterUtils.filterByColorAndWeight(applesList, "Green", 150);
		System.out.println("6.Green apples\n" + filteredList5);

		// Using predicate from java8
		Predicate<Apple> appleColorPredicate =  new AppleColorPredicate();
		//Filter By color: Green  using predicate
		List<Apple> filteredList6 = AppleFilterUtils.filterByCritera(applesList, appleColorPredicate);
		System.out.println("7.Green apples\n" + filteredList6);

		// Using predicate from java8
		Predicate<Apple> appleWeightPredicate =  new AppleWeightPredicate();
		//Filter By weight > =150  using predicate
		List<Apple> filteredList7 = AppleFilterUtils.filterByCritera(applesList, appleWeightPredicate);
		System.out.println("8.With Weight apples\n" + filteredList7);

		// Using predicate from java8
		Predicate<Apple> predicate = (apple) ->  apple.getColor().equals("Red") && apple.getWeight() > 200;
		List<Apple> filteredList8 = AppleFilterUtils.filterByCritera(applesList, predicate);
		System.out.println("9.Red With Weight apples\n" + filteredList8);

		// Using predicate and stream api from java8
		List<Apple> filteredList9 = applesList.stream()
		.filter(predicate)
		.collect(Collectors.toList());
		System.out.println("10.Red With Weight apples\n" + filteredList9);
		
		
		// Using Stream and predicate on the fly and stream api from java8
		List<Apple> filteredList10 = applesList.stream()
				.filter((apple) ->  apple.getColor().equals("Green") && apple.getWeight() > 150)
				.collect(Collectors.toList());
		System.out.println("11.Freen With Weight apples\n" + filteredList10);
		
		// Using Stream and predicate on the fly and stream api from java8
		List<Apple> filteredList11 = applesList.stream()
				.filter((apple) ->  apple.getColor().equals("Green"))
				.filter((apple) ->  apple.getTaste().equals("Sweet"))
				.collect(Collectors.toList());
		System.out.println("12.Green With Taste apples\n" + filteredList11);


	}

}
