package com.acts.fruits;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class AppleFilterUtils {
	public static List<Apple> filterByRedColor(List<Apple> appleList){
		List<Apple> filteredList = new ArrayList<>();
		for(Apple apple : appleList) {
			if("Red".equals(apple.getColor())) {
				filteredList.add(apple);
			}
		}
		return filteredList;
	}
	
	public static List<Apple> filterByGreenColor(List<Apple> appleList){
		List<Apple> filteredList = new ArrayList<>();
		for(Apple apple : appleList) {
			if("Green".equals(apple.getColor())) {
				filteredList.add(apple);
			}
		}
		return filteredList;
	}
	
	public static List<Apple> filterByColor(List<Apple> appleList, String color){
		List<Apple> filteredList = new ArrayList<>();
		for(Apple apple : appleList) {
			if(color.equals(apple.getColor())) {
				filteredList.add(apple);
			}
		}
		return filteredList;
	}
	
	public static List<Apple> filterByColorAndWeight(List<Apple> appleList, String color, int weight){
		List<Apple> filteredList = new ArrayList<>();
		for(Apple apple : appleList) {
			if(color.equals(apple.getColor()) && weight >= apple.getWeight()) {
				filteredList.add(apple);
			}
		}
		return filteredList;
	}
	
	
	public static List<Apple> filterByCritera(List<Apple> appleList, Predicate<Apple> predicate){
		List<Apple> filteredList = new ArrayList<>();
		for(Apple apple : appleList) {
			if(predicate.test(apple)) {
				filteredList.add(apple);
			}
		}
		return filteredList;
	}
	
}
