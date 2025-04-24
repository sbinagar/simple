package com.cdac.acts.lambda.tester;

import java.util.function.BiFunction;
import java.util.function.DoublePredicate;
import java.util.function.Predicate;

import com.cdac.acts.lambda.Operation;

public class LambdaTester1 {

	public static void main(String[] args) {
		int a = 100;
		int b = 20;
		//Lambda target is our own Operation FI I/F
		Operation<Integer> operation = (x, y) -> x + y; //Function literal
		Integer sum = operation.operate(a, b);
		System.out.println(sum);

		//Lambda target is our own Operation FI I/F
		Operation<Integer> operation1 = (x, y) -> x - y; //Function literal
		Integer substraction = operation1.operate(a, b);
		System.out.println(substraction);

		//Lambda target is BiFunction FI I/F
		BiFunction<Integer, Integer, Integer> add = (x, y) -> x + y; // Function Literal
		Integer sum2 = add.apply(100, 200);
		System.out.println(sum2);

		//Lambda target is Predicate FI I/F
		Predicate<Integer> evenPredicate = (x) -> x % 2 == 0; // Function Literal
		boolean even = evenPredicate.test(20);
		System.out.println("Even=" +even);
		
		//Lambda target is DoublePredicate FI I/F
		DoublePredicate check = (x) -> x > 100; // Function Literal
		boolean greaterThan100 = check.test(200);
		System.out.println("GreaterThan100=" +greaterThan100);


	}
}
