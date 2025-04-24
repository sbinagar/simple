package com.cdac.acts.lambda.tester;

import com.cdac.acts.lambda.AddOperation;
import com.cdac.acts.lambda.ArithmaticOperations;
import com.cdac.acts.lambda.Operation;
import com.cdac.acts.lambda.SubtractOperation;
public class ArithmaticOperationTester {

	public static void main(String[] args) {
		
//		Operation<Double> add = new AddOperation();
//		System.out.println(add.operate(1.0, 2.0));
//		
//		ArithmaticOperations.arithmaticOperation(1.0, 2.0, add);
		
		
//		Operation<Double> subtract = new SubtractOperation();
//		System.out.println(subtract.operate(10.0, 2.0));
//		
//		ArithmaticOperations.arithmaticOperation(10.0, 2.0, subtract);

		//Add 2 numbers using Anonymous Inner class
		double result = ArithmaticOperations.arithmaticOperation(
				10.20, 20.30, new Operation<Double>() {
					@Override
					public  Double operate(Double a, Double b) {
						return a + b;
					}
				});

		System.out.println("Sum =" + result);


		//Multiply 2 numbers using Anonymous Inner class
		double result1 = ArithmaticOperations.arithmaticOperation(
				10.20, 20.30, new Operation<Double>() {
					@Override
					public Double operate(Double a, Double b) {
						return a*b;
					}
				});

		System.out.println("Multiplication =" + result1);
		
		
		//VVIMP
		//target i/f Operation<Double> operation
		//target method T operate(T a, T b)
		
		
		Operation<Double> mult = (Double a, Double b) -> a * b;
//		Operation<Double> operation = (a, b) -> a + b;
		double res = ArithmaticOperations.arithmaticOperation(
				10.20, 20.30, mult);

		System.out.println("Multiplication =" + res);
		

		//VVIMP
		//target i/f Operation<Double> operation
		//target method T operate(T a, T b)
		 res = ArithmaticOperations.arithmaticOperation(
				10.20, 20.30, (a, b) -> a / b);

		System.out.println("Multiplication =" + res);
		 
				 
	}

}
