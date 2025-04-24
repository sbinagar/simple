package com.cdac.acts.lambda.tester;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class LambdaTester2 {

	public static void main(String[] args) {
		List<Double> list = new ArrayList<Double>();
		list.add(160.50);
		list.add(150.50);
		list.add(140.50);
		list.add(1000.50);
		list.add(900.50);
		
		Collections.sort(list);
		Collections.sort(list, (o1, o2) -> o2.compareTo(o1));
		//Collections.sort(list, (o1, o2) -> o2.getName().compareTo(o1.getName(0));
		
		
		//Objective: Use forEach method from Iterable I/F
		//public default void forEach(Consumer<? super T> action)
		//Target I/F is Consumer ( SAM type) and target method is accept
		//SAM : public void accept(T t)
		//(t) -> void
		list.forEach(new Consumer<Double>() {
			//Implementing method of consumer
			@Override
			public void accept(Double t) {
				System.out.println(t);
			}
		});
		
		//With lambda expression
		//Target I/F is Consumer ( SAM type) and target method is accept
		//SAM : public void accept(T t)
		//(t) -> void
		
		list.forEach((value) -> System.out.println(value));
		
		//With Method Reference
		list.forEach(System.out::println);
		

	}

}
