package com.cdac.acts.lambda;

public class ArithmaticOperations {
	public static double arithmaticOperation(double d1, double d2,
			Operation<Double> operation) {
		return operation.operate(d1, d2);
		//add.operate(d1, d2);
		//subtract.operate(d1, d2);
	}

}
