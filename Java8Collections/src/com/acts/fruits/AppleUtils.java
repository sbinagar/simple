package com.acts.fruits;

import java.util.ArrayList;
import java.util.List;
//This class create methods for getting pre-filled list of apples
public class AppleUtils {
	public static List<Apple> getAppleList() {
		List<Apple> applesList = new ArrayList<>();
		applesList.add(new Apple(100, "Green", "Sour"));
		applesList.add(new Apple(200, "Red", "Sweet"));
		applesList.add(new Apple(150, "Green", "Sour"));
		applesList.add(new Apple(250, "Red", "Sweet"));
		applesList.add(new Apple(150, "Green", "Sour"));
		applesList.add(new Apple(150, "Red", "Sweet"));
		applesList.add(new Apple(200, "Green", "Sour"));
		return applesList;
	}

}
